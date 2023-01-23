import axios from "../apiClient";

export const getAllSensors = async () => {
    const response = await axios.get("http://projektsensors.ddns.net/sensordata/ids");
    return response.data;
}
export const latestOfId = async (id) => {
    const response = await axios.post(`http://projektsensors.ddns.net/sensordata/findlatest`,{"sensorId":id});
    return response.data;
}
export const allOfId = async (id) => {
    const response = await axios.post(`http://projektsensors.ddns.net/sensordata/all`,{"sensorId":id});
    return response.data;
}