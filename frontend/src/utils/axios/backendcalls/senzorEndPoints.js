import axios from "../apiClient";

export const getAllSensors = async () => {
    const response = await axios.get("/spring/ids");
    return response.data;
}
export const latestOfId = async ({"sensorId":id}) => {
    const response = await axios.post(`/sensordata/findlatest`,{"sensorId":id});
    return response.data;
}
export const allOfId = async ({"sensorId":id}) => {
    const response = await axios.post(`/sensordata/all`,{"sensorId":id});
    return response.data;
}