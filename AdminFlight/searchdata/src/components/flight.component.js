import React, { Component } from "react";
import FlightDataService from "../services/flight.service";

export default class Flight extends Component {
  constructor(props) {
    super(props);
    this.onChangeArrivalLoc = this.onChangeArrivalLoc.bind(this);
    this.onChangeDepartureLoc = this.onChangeDepartureLoc.bind(this);
    this.onChangeFleetName = this.onChangeFleetName.bind(this);
    this.onChangeModel = this.onChangeModel.bind(this);
    this.onChangeDate = this.onChangeDate.bind(this);
    this.onChangeRemainingSeats = this.onChangeRemainingSeats.bind(this);
    this.getFlight = this.getFlight.bind(this);
    this.updateFlight = this.updateFlight.bind(this);
    this.deleteFlight = this.deleteFlight.bind(this);

    this.state = {
      currentFlight: {
        arrivalLoc: "",
        departureLoc: "",
        fleetName: "",
        model: "",
        date: "",
        remainingSeats: ""

      },
      message: ""
    };
  }

  componentDidMount() {
    this.getFlight(this.props.match.params.flightId);
  }

  onChangeArrivalLoc(e) {
    const arrivalLoc = e.target.value;

    this.setState(function(prevState) {
      return {
        currentFlight: {
          ...prevState.currentFlight,
          arrivalLoc: arrivalLoc
        }
      };
    });
  }

  onChangeDepartureLoc(e) {
    const departureLoc = e.target.value;
    
    this.setState(prevState => ({
      currentFlight: {
        ...prevState.currentFlight,
        departureLoc: departureLoc
      }
    }));
  }

  onChangeFleetName(e) {
    const fleetName = e.target.value;

    this.setState(function(prevState) {
      return {
        currentFlight: {
          ...prevState.currentFlight,
          fleetName: fleetName
        }
      };
    });
  }
  onChangeModel(e) {
    const model = e.target.value;

    this.setState(function(prevState) {
      return {
        currentFlight: {
          ...prevState.currentFlight,
          model: model
        }
      };
    });
  }
  onChangeDate(e) {
    const date = e.target.value;

    this.setState(function(prevState) {
      return {
        currentFlight: {
          ...prevState.currentFlight,
          date: date
        }
      };
    });
  }
  onChangeRemainingSeats(e) {
    const remainingSeats = e.target.value;

    this.setState(function(prevState) {
      return {
        currentFlight: {
          ...prevState.currentFlight,
          remainingSeats: remainingSeats
        }
      };
    });
  }
  getFlight(flightId) {
    FlightDataService.get(flightId)
      .then(response => {
        this.setState({
          currentFlight: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

//   updatePublished(status) {
//     var data = {
//       id: this.state.currentTutorial.id,
//       title: this.state.currentTutorial.title,
//       description: this.state.currentTutorial.description,
//       published: status
//     };
//
//     FlightDataService.update(this.state.currentTutorial.id, data)
//       .then(response => {
//         this.setState(prevState => ({
//           currentTutorial: {
//             ...prevState.currentTutorial,
//             published: status
//           }
//         }));
//         console.log(response.data);
//       })
//       .catch(e => {
//         console.log(e);
//       });
//   }

  updateFlight() {
    FlightDataService.update(
      this.state.currentFlight.flightId,
      this.state.currentFlight
    )
      .then(response => {
        console.log(response.data);
        this.setState({
          message: "The flight was updated successfully!"
        });
      })
      .catch(e => {
        console.log(e);
      });
  }

  deleteFlight() {    
    FlightDataService.delete(this.state.currentFlight.flightId)
      .then(response => {
        console.log(response.data);
        this.props.history.push('/delete-flight-by-id')
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { currentFlight } = this.state;

    return (
      <div>
        {currentFlight ? (
          <div className="edit-form">
            <h4>Flight</h4>
            <form>
              <div className="form-group">
                <label htmlFor="arrivalLoc">Arrival Loc</label>
                <input
                  type="text"
                  className="form-control"
                  id="arrivalLoc"
                  value={currentFlight.arrivalLoc}
                  onChange={this.onChangeArrivalLoc}
                />
              </div>
              <div className="form-group">
                <label htmlFor="departureLoc">Departure Loc</label>
                <input
                  type="text"
                  className="form-control"
                  id="departureLoc"
                  value={currentFlight.departureLoc}
                  onChange={this.onChangeDepartureLoc}
                />
              </div>
              <div className="form-group">
              <label htmlFor="fleetName">Flight Name</label>
              <input
                type="text"
                className="form-control"
                id="fleetName"
                value={currentFlight.fleetName}
                onChange={this.onChangeFleetName}
              />
            </div>
            <div className="form-group">
            <label htmlFor="model">Model</label>
            <input
              type="text"
              className="form-control"
              id="model"
              value={currentFlight.model}
              onChange={this.onChangeModel}
            />
          </div>
          <div className="form-group">
          <label htmlFor="date">Date</label>
          <input
            type="text"
            className="form-control"
            id="date"
            value={currentFlight.date}
            onChange={this.onChangeDate}
          />
        </div>
        <div className="form-group">
        <label htmlFor="remainingSeats">Remaining Seats</label>
        <input
          type="text"
          className="form-control"
          id="remainingSeats"
          value={currentFlight.remainingSeats}
          onChange={this.onChangeRemainingSeats}
        />
      </div>
      </form>
           

            <button
              className="badge badge-danger mr-2"
              onClick={this.deleteFlight}
            >
              Delete
            </button>

            <button
              type="submit"
              className="badge badge-success"
              onClick={this.updateFlight}
            >
              Update
            </button>
            <p>{this.state.message}</p>
          </div>
        ) : (
          <div>
            <br />
            <p>Please click on a Flight...</p>
          </div>
        )}
      </div>
    );
  }
}
