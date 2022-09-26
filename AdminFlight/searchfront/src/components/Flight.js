import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';


const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function Flight() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[arrivalLoc,setArrivalLoc]=useState('')
    const[departureLoc,setDepartureLoc]=useState('')
    const[model]=useState('')
    const[fleetName]=useState('')
    const[remainingSeats]=useState('')
    const[flights,setFlights]=useState([])
     const[date,setDate]=useState([])
     const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const flight={arrivalLoc,departureLoc,model,fleetName,remainingSeats,date}
    console.log(flight)
    fetch("http://localhost:8002/flight/add-one-flight",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(flight)

  }).then(()=>{
    console.log("New Flight added")
  })
}

useEffect(()=>{
  fetch("http://localhost:8002/flight/get-all-flights")
  .then(res=>res.json())
  .then((result)=>{
    setFlights(result);
  }
)
},[])
  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Add Flight</u></h1>

    <form cllassName={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Arrival Location" variant="outlined" fullWidth 
      value={arrivalLoc}
      onChange={(e)=>setArrivalLoc(e.target.value)}
      />
      <TextField id="outlined-basic" label="Departure Location" variant="outlined" fullWidth 
      value={departureLoc}
      onChange={(e)=>setDepartureLoc(e.target.value)}
      />

      <TextField id="outlined-basic" label="Date" variant="outlined" fullWidth
      value={date}
      onChange={(e)=>setDate(e.target.value)}
      />
      <Button variant="contained" color="secondary" onClick={handleClick}>
  Submit
</Button>
    </form>
   
    </Paper>
    <h1>Flights</h1>

    <Paper elevation={3} style={paperStyle}>

      {flights.map(flight=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={flight.flightId}>
         FlightId:{flight.flightId}<br/>
         FleetName:{flight.fleetName}<br/>
         ArrivalLoc:{flight.arrivalLoc}<br/>
         DepartureLoc:{flight.departureLoc}<br/>
         Model:{flight.model}<br/>
         Datee:{flight.date}<br/>
         Seats:{flight.remainingSeats}

        </Paper>
      ))
}


    </Paper>



    </Container>
  );
}