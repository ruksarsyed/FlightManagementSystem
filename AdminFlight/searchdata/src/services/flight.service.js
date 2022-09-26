import http from "../http-common";

class FlightDataService {
  getAll() {
    return http.get("/get-all-flights");
  }

  get(flightId) {
    return http.get(`/get-flight-by-id/${flightId}`);
  }

  
  update(flightId, data) {
    return http.put(`/update-flight/${flightId}`, data);
  }

  delete(flightId) {
    return http.delete(`/delete-flight-by-id/${flightId}`);
  }
  findByDate(date) {
    return http.get(`/findbyDate?title=${date}`);
  }

  // findByTitle({date}/{arrivalLoc}/{departureLoc}) {
  //   return http.get(`/findbyData?date=${date}?arrivalLoc=${arrivalLoc}?departureLoc=${departureLoc}`);
  // }
}



export default new FlightDataService();