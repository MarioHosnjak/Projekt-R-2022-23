import React, { useState, useEffect } from 'react';

import "./senzorPage.css"
import { latestOfId } from "../../utils/axios/backendcalls/senzorEndPoints";

const SenzorPage = () => {
    var [idSenzora, setIdSenzora] = useState("Default");
    const [latestMeasurement, setLatestMeasurement] = useState();

    idSenzora = window.location.pathname.substring(window.location.pathname.indexOf("senzor/") + 7);
    
    useEffect(() => {
        if(idSenzora !== "Default"){
            latestOfId(idSenzora).then((res) => {
                console.log(res);
                setLatestMeasurement(res);
            }).catch((err) => {
                console.log(err);
            });
        }
    }, []);

    let measurementInfo
    if(latestMeasurement){
        measurementInfo = <div>
                            <h2>Time: {latestMeasurement["time"]}</h2>
                            <h2>Location: {latestMeasurement["location"]}</h2>
                            <p>-----------------------------</p>
                            <h2>Temperature: {latestMeasurement["temperature"]}</h2>
                            <h2>Humidity: {latestMeasurement["humidity"]}</h2>
                            <h2>Pressure: {latestMeasurement["pressure"]}</h2>
                            <h2>Illuminance: {latestMeasurement["illuminance"]}</h2>
                            <h2>UVA: {latestMeasurement["uva"]}</h2>
                            <h2>UVB: {latestMeasurement["uvb"]}</h2>
                            <h2>UV-Index: {latestMeasurement["uvindex"]}</h2>
                            </div>
    }

    return (
        <div className="">
            <h1>Sensor id: {idSenzora}</h1>
            {measurementInfo}
        </div>
    );
}
export default SenzorPage;