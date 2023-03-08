
import * as React from 'react';
import { useState } from 'react';
import axios from 'axios';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './TrainBooking.css'
import Button from '@mui/material/Button';
function Train() {
  const [trainName,setTrainName]= useState();
  const[routeNumber,setRouteNumber]= useState();
  const[boardingPlace,setBoardingPlace]=useState();
  const[destinationPlace,setDestinationPlace]=useState();
  const[arrivalTime,setArrivalTime]=useState();
  const[departureTime,setDepartureTime]=useState();
  const[open,setOpen]=useState();
  const[loading,setLoading]=useState();

  function handleClose(){
    setOpen(false);
  }
  async function handleSubmit(e){
    e.preventDefault();
    setLoading(true);
    try{
      const data={
        trainName:trainName,
        routeNumber: Number(routeNumber),
        boardingPlace:boardingPlace,
        destinationPlace:destinationPlace,
        arrivalTime:Number(arrivalTime),
        departureTime:Number(departureTime),
      };
      const res=await axios.post("http://localhost:8080/train",data);
      await console.log(res);
      await setOpen(true);
    }
    catch(e){
      console.log(e.message);
    }
    setLoading(false);
    alert("Get your details here!!");
  }
    return ( 
        <>
        <div  className='top'>
        <center>
          <div className='main'>
    <Box
      component="form"
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
        <center>
            <br></br>
            <h2><b>Travel ON!</b></h2>
            <br></br>
        <TextField required id="outlined-basic" label="trainName" variant="outlined"
        onChange={(event)=>setTrainName(event.target.value)}/> 
        <br></br><br></br>
        <TextField id="outlined-basic" label="routeNumber" variant="outlined"
        onChange={(event)=>setRouteNumber(event.target.value)}/> 
        <br></br><br></br>
        <TextField required id="outlined-basic" label="boardingPlace" variant="outlined" 
        onChange={(event)=>setBoardingPlace(event.target.value)}/>
        <br></br><br></br>
        <TextField required id="outlined-basic" label="destinationPlace" variant="outlined" 
        onChange={(event)=>setDestinationPlace(event.target.value)}/>
        <br></br><br></br>
        <TextField required id="outlined-basic" label="arrivalTime" variant="outlined" 
        onChange={(event)=>setArrivalTime(event.target.value)}/>
        <br></br><br></br>
        <TextField required id="outlined-basic" label="departureTime" variant="outlined" 
        onChange={(event)=>setDepartureTime(event.target.value)}/>
        <br></br>
        <br></br>
      <Button variant="contained" color="success" onClick={handleSubmit}>
        CHECK
      </Button>
      
        </center>
    </Box>
    </div>
    </center>
    </div>
        </>
     );
}
export default Train;