import React, { useState, useEffect } from 'react';

import "./homePage.css"
import { getAllSensors } from "../../utils/axios/backendcalls/senzorEndPoints";
import { MapContainer, TileLayer } from 'react-leaflet'
import L from "leaflet";

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
        <div className="">
            {
                senzorIds.map((id)=>{
                    return (
                    <div key={id}>
                        <h1><a href={"/senzor/"+id}>{id}</a></h1>
                    </div>
                )})	
            }
            <h1>This will be a home page.</h1>
            <div className="home-map-div">
                <MapContainer className="homemap" center={[45.80013699500578, 15.97122171454018]} zoom={16} doubleClickZoom={false} scrollWheelZoom={true}
                    whenReady={async (map) => {
                        let i=0;
                        senzorIds.map((id)=>{
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
