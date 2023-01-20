import React, { useState, useEffect } from 'react';

import "./homePage.css"
import { getAllSensors } from "../../utils/axios/backendcalls/senzorEndPoints";
import { MapContainer, TileLayer } from 'react-leaflet'
import L from "leaflet";

import logo from '../../assets/images/FER_logo.png';

const HomePage = () => {
    const [senzorIds, setSenzorIds] = useState([]);

    useEffect(() => {
        getAllSensors().then((res) => {
            //console.log(res);
            setSenzorIds(res);
        }).catch((err) => {
            console.log(err);
        });
    }, []);
    //const senzorIds=await getAllSensors();
    return (
        <div className="home-container">
            <div className='logo-container' ><img src={logo} alt="Logo" /></div>
            {<div className='sensor-div'>
                <h1>Aktivni senzori:</h1>
                {
                    senzorIds.map((id)=>{
                        return (
                        <div key={id}>
                            <h2><a href={"/senzor/"+id}>{id}</a></h2>
                        </div>
                    )})	
                }
            </div>}
            <div className="home-map-div">
                <MapContainer className="homemap" center={[45.80013699500578, 15.97122171454018]} zoom={16} doubleClickZoom={false} scrollWheelZoom={true}
                    whenReady={async (map) => {
                        let i=0;
                        const senids=await getAllSensors();
                        senids.map((id)=>{
                            const lat=45.8015166376239;
                            const lng=15.971291992802115;
                            const popup='<a href="/senzor/' + id + '">' + id+ '</a>';
                            
                            L.marker([lat-i*0.0015, lng]).addTo(map.target).bindPopup(popup)
                            .on('mouseover', function (e) {
                                this.openPopup();
                            })
                            i++;
                        })
                    }}>
                    <TileLayer
                        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                    />
                    
                    
                </MapContainer>
            </div>

        </div>
    );
};
export default HomePage;
