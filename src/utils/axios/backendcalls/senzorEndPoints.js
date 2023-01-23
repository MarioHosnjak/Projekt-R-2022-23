import axios from "../apiClient";

export const getAllSensors = async () => {
    const response = await axios.get("http://projektr.hopto.org/sensordata/ids");
    return response.data;
}
export const latestOfId = async (id) => {
    const response = await axios.post(`http://projektr.hopto.org/sensordata/findlatest`,{"sensorId":id});
    return response.data;
}
export const allOfId = async (id) => {
    const response = await axios.post(`http://projektr.hopto.org/sensordata/all`,{"sensorId":id});
    return response.data;
}