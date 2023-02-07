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
    var [NumMeasurements, setNumMeasurements] = useState("all");
    var[lastNoOfData, setlastNoOfData] = useState();
    var maxSuggested = {
        "humidity": 100,
        "pressure": 150,
        "temperature": 40,
        "pm25": 100,
        "pm10": 100,
        "motions": 100,
      };
    var minSuggested = {
        "humidity": 0,
        "pressure": 90,
        "temperature": 0,
        "pm25": 0,
        "pm10": 0,
        "motions": 0,
      };  
    var measUnits={
        "humidity": "%",
        "pressure": "kPa",
        "temperature": "°C",
        "pm25": "µg/m³",
        "pm10": "µg/m³",
        "motions": "",
    }
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
        const n=allMeasurements.length;
        if(event.target.value==="half"){
            if(n%2===0){
                setlastNoOfData(allMeasurements.slice(allMeasurements.length-n/2,allMeasurements.length))
            }else{
                setlastNoOfData(allMeasurements.slice(allMeasurements.length-(n+1)/2,allMeasurements.length))
            }
        }else if(event.target.value==="all"){
            setlastNoOfData(allMeasurements);
        }
        setNumMeasurements(event.target.value);
        /* kad cemo imat za odabrat vise mjerenja
        const m=event.target.value;
        if(n<m){
            setlastNoOfData(allMeasurements);
        }else{
            setlastNoOfData(allMeasurements.slice(allMeasurements.length-m,allMeasurements.length))
        }
        setNumMeasurements(event.target.value);
        */
    };
    
    useEffect(() => {
        if(idSenzora !== "Default"){
            latestOfId(idSenzora).then((res) => {
                console.log(res);
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
                    <h2>Latest {key==="pm25"?"pm2.5":key}:  {latestMeasurement[key]}{measUnits[key]}</h2>
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
                                            suggestedMin: minSuggested[key],
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
                            <label><input name="rb" type="radio" value="all" onChange={handleRadio} checked={NumMeasurements==="all"}/>all</label>
                            <label><input name="rb" type="radio" value="half" onChange={handleRadio} checked={NumMeasurements==="half"}/>half</label>
                            {/*
                            <label><input name="rb" type="radio" value="30" onChange={handleRadio} checked={NumMeasurements==="30"}/>30</label>
                            <label><input name="rb" type="radio" value="20" onChange={handleRadio} checked={NumMeasurements==="20"}/>20</label>
                            <label><input name="rb" type="radio" value="10" onChange={handleRadio} checked={NumMeasurements==="10"}/>10</label>
                            */}
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