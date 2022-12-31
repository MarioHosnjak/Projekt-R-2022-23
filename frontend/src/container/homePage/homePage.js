import "./homePage.css"
import { getAllSensors } from "../../utils/axios/backendcalls/senzorEndPoints";

const HomePage = async () => {
    const senzorIds=await getAllSensors();
    return (
        <div className="">
            {
                senzorIds.map((id)=>{
                    return <h1><a href={"/senzor/"+id}/></h1>
                })	
            }
            <h1>This will be a home page.</h1>
        </div>
    );
};
export default HomePage;
