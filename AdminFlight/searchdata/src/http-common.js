import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8002/flight",
  headers: {
    "Content-type": "application/json"
  }
});