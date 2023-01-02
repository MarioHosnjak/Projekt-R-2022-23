import React, { useState, useEffect } from 'react';

import "./homePage.css"
import { getAllSensors } from "../../utils/axios/backendcalls/senzorEndPoints";

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
        </div>
    );
};
export default HomePage;
