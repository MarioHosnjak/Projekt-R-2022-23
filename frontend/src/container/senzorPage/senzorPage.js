import "./senzorPage.css"
import { latestOfId } from "../../utils/axios/backendcalls/senzorEndPoints";

const SenzorPage = async () => {
    var idSenzora = window.location.pathname.indexOf("senzor/") + 7;
    idSenzora = window.location.pathname.substring(idSenzora);
    const latest = await latestOfId(idSenzora);
    return (
        <div className="">
            <h1>Id senzora: {idSenzora}</h1>
            <h1>latest: {latest}</h1>
        </div>
    );
}
export default SenzorPage;