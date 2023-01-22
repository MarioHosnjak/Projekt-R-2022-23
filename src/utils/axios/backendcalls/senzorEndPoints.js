import axios from "../apiClient";

export const getAllSensors = async () => {
    const response = await axios.get("http://93.137.174.47/sensordata/ids");
    return response.data;
}
export const latestOfId = async (id) => {
    const response = await axios.post(`http://93.137.174.47/sensordata/findlatest`,{"sensorId":id});
    return response.data;
}
export const allOfId = async (id) => {
    const response = await axios.post(`http://93.137.174.47/sensordata/all`,{"sensorId":id});
    return response.data;
}