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
    var [NumMeasurements, setNumMeasurements] = useState("5");
    var[lastNoOfData, setlastNoOfData] = useState();
    var maxSuggested = {
        "humidity": 100,
        "pressure": 150,
        "illuminance": 15,
        "temperature": 40,
        "uva":15,
        "uvb":15,
        "uvindex":15,
      };

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



    function handleRadio(event){
        const n=event.target.value;
        setNumMeasurements(event.target.value);
        setlastNoOfData(allMeasurements.slice(allMeasurements.length-n,allMeasurements.length))
    };
    
    useEffect(() => {
        if(idSenzora !== "Default"){
            latestOfId(idSenzora).then((res) => {
                setLatestMeasurement(res);
            }).catch((err) => {
                console.log(err);
            });
            allOfId(idSenzora).then((res) => {
                res = res.reverse();
                setAllMeasurements(res);
                setlastNoOfData=res.slice(res.length-NumMeasurements,res.length);
            }).catch((err) => {
                console.log(err);
            });
        }

    }, []);

    let measurementData=[];
    if(latestMeasurement && allMeasurements){
        var chartdata=allMeasurements;
        if(lastNoOfData){
            chartdata=lastNoOfData;
        }
        for(var key in latestMeasurement){
            if(!["id","location","sensorId","time"].includes(key)){
                measurementData.push(
                <div key={key}>
                    <h2>Latest {key}: {latestMeasurement[key]}</h2>
                    <div className="graphDiv">
                            <Line 
                                data={{
                                    labels: chartdata.map((data) => data.time),
                                    datasets: [{
                                        label: key,
                                        data: chartdata.map((data) => data[key]),
                                        borderColor: "black",
                                        borderWidth: 2,
                                    }]
                                }}
                                options={{
                                    scales: {
                                        y: {
                                            suggestedMin: key==="pressure"?90:0,
                                            suggestedMax: maxSuggested[key],
                                        }
                                    }
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
                            <p>Number of measurements</p>
                            <label><input name="rb" type="radio" value="5" onChange={handleRadio} checked={NumMeasurements==="5"}/>5</label>
                            <label><input name="rb" type="radio" value="3" onChange={handleRadio} checked={NumMeasurements==="3"}/>3</label>
                            {measurementData}
                            </div>
    }
    


    return (
        <div className="centeredContainer">
            <div className="backBtnDiv">
                <button className="backBtn" onClick={event =>  window.location.href='/'}><strong>Return</strong></button>
            </div>
            <div className="centeredContainer">
                <h1>Sensor id: {idSenzora}</h1>
                <div className="graphDiv">
                    <Line 
                        data={testChartData} 
                        options={{
                            scales: {
                                y: {
                                    suggestedMin: 0,
                                    suggestedMax: 30,
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