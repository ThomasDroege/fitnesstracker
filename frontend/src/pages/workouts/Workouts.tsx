import "./workouts.css"
import React, { useEffect, useState } from "react"
import { DataGrid } from '@mui/x-data-grid';
import {DeleteOutline} from '@material-ui/icons'
import {userRows} from "../../dummyData"
import {Link} from "react-router-dom"
import axios, {AxiosResponse} from 'axios';
import { couldStartTrivia } from "typescript";

export default function Workouts() {
  const [isLoaded,setIsLoaded] = useState(false);
  const [workouts, setWorkouts] = useState<Workouts[]>([]);
  const [WorkoutResponse, setWorkoutResponses] = useState<WorkoutResponse>()
  

interface WorkoutResponse{
  testentry: [];
}

//ToDo: es wird response.data.workouts nicht gesetzt bzw. response.data.workouts = undefined
interface Workouts{
  workoutId: number;
  timeStarted: String;
  timeEnded: String;
  userId: number;

}

useEffect(() => {
  axios.get<WorkoutResponse>('http://localhost:8080/workout/getAllWithSets')
  .then(response => {
    var array = [];
    array.push(response)
   
   //setWorkouts(response.data.workouts)
  // var obj2: Workouts[] = response.data.workouts
  // console.log(obj2)
  
    setIsLoaded(true);
    //console.log(response.data.workouts)
   // console.log(typeof(response.data.workouts))
    
    response.data.testentry.forEach(test => {
      console.log(test)
      //test.timeStarted = test.timeStarted.substring(11,16);
      console.log("Test")
    })
    
    setWorkouts(response.data.testentry); 
  });
}, [])

/*
useEffect(() => {
  axios.get<WorkoutResponse>('http://localhost:8080/workout/getAllWithSets')
  .then(response => {
    var array = [];
    array.push(response)
  
   //setWorkouts(response.data.workouts)
  // var obj2: Workouts[] = response.data.workouts
  // console.log(obj2)
  
    setIsLoaded(true);
    //console.log(response.data.workouts)
   // console.log(typeof(response.data.workouts))
    
    response.data.testentry.forEach(test => {
      console.log(test)
      //test.timeStarted = test.timeStarted.substring(11,16);
      console.log("Test")
    })
    
    setWorkouts(response.data); 
  });
}, [])
*/
const columns = [
  {field: "workoutI", headerName: "ID", width: 90},
  {field: "workoutName", headerName: "WorkoutName", width: 200},
  {field: "timeStarted", headerName: "TimeStarted", width: 200},
  {field: "date", headerName: "Date", width: 200}
]
   
return (
  <div className="userList">
   
    <DataGrid
      rows={workouts}
      disableSelectionOnClick
      columns={columns}
      //pageSize={8}
      checkboxSelection
    />
    
  </div>
)
}
