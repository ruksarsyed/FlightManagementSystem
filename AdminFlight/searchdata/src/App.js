import React, { Component } from "react";
import { Link } from 'react-router-dom';
import {
  Routes, 
  Route,
} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Flight from "./components/flight.component";


class App extends Component {
  render() {
    return (
      <div>

          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/get-flight-by-id"} className="nav-link">
                <Flight/>
              </Link>
            </li>
            </div>

        <div className="container mt-3">
          <Routes>
            <Route path="/get-flight-by-id/:flightId" component={Flight} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;

