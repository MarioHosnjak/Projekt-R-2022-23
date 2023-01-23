import React, { useState, useEffect } from 'react';

import "./senzorPage.css"
import { latestOfId, allOfId } from "../../utils/axios/backendcalls/senzorEndPoints";
import {Line} from 'react-chartjs-2';
import {testData} from './testChartData'
import { Chart as ChartJS } from "chart.js/auto"; //NE BRISAT, veli da se nigdje ne koristi, ali bez tog ne radi graf

const SenzorPage = () => {
    var [idSenzora, setIdSenzora] = useState("Default");
    const [latestMeasurement, setLatestMeasurement] = useState();
    const [allMeasurements, setAllMeasurements] = useState();

    const [testChartData,setTestData] = useState({
        labels: testData.map((data) => data.time),
        datasets: [
            {
                label: "Temperature",
                data: testData.map((data) => data.temp),
                borderColor: "black",
                borderWidth: 2,
              },
        ]
    });

    idSenzora = window.location.pathname.substring(window.location.pathname.indexOf("senzor/") + 7);
    
    useEffect(() => {
        if(idSenzora !== "Default"){
            latestOfId(idSenzora).then((res) => {
                console.log(res);
                setLatestMeasurement(res);
            }).catch((err) => {
                console.log(err);
            });
            allOfId(idSenzora).then((res) => {
                console.log(res);
                res = res.reverse();
                setAllMeasurements(res);
            }).catch((err) => {
                console.log(err);
            });
        }

    }, []);

    let measurementData=[];
    if(latestMeasurement && allMeasurements){
        for(var key in latestMeasurement){
            if(!["id","location","sensorId","time"].includes(key)){
                measurementData.push(
                <div key={key}>
                    <h2>Latest {key}: {latestMeasurement[key]}</h2>
                    <div style={{width:"50vw"}}>
                            <Line 
                                data={{
                                    labels: allMeasurements.map((data) => data.time),
                                    datasets: [{
                                        label: key,
                                        data: allMeasurements.map((data) => data[key]),
                                        borderColor: "black",
                                        borderWidth: 2,
                                    }]
                                }}
                            />
                        </div>
                </div>
                
                );
            }
            
        }
        
    }

    let measurementInfo
    if(latestMeasurement){
        
        measurementInfo = <div>
                            <h2>Time: {latestMeasurement["time"]}</h2>
                            <h2>Location: {latestMeasurement["location"]}</h2>
                            <p>-----------------------------</p>
                            {measurementData}
                            </div>
    }
    


    return (
        <div className="centeredContainer">
            <div className="centeredContainer">
                <h1>Sensor id: {idSenzora}</h1>
                <div style={{width:"50vw"}}>
                    <Line 
                        data={testChartData} 
                        options={{
                            scales: {
                                yAxis: {
                                    min: 0,
                                    max: 50,
                                }
                            }
                        }}
                    />
                </div>
            </div>
            {measurementInfo}
        </div>
    );
}
export default SenzorPage;