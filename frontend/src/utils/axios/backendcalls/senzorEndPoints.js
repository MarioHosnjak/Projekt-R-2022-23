import axios from "../apiClient";

export const getAllSensors = async () => {
    const response = await axios.get("http://localhost:8080/sensordata/ids");
    return response.data;
}
export const latestOfId = async ({"sensorId":id}) => {
    const response = await axios.post(`http://localhost:8080/sensordata/findlatest`,{"sensorId":id});
    return response.data;
}
export const allOfId = async ({"sensorId":id}) => {
    const response = await axios.post(`http://localhost:8080/sensordata/all`,{"sensorId":id});
    return response.data;
}