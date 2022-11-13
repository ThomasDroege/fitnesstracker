import "./workouts.css"
import React, { useEffect, useState } from "react"
import { DataGrid } from '@mui/x-data-grid';
import {DeleteOutline} from '@material-ui/icons'
import {userRows} from "../../dummyData"
import {Link} from "react-router-dom"

export default function Workouts() {
  const [isLoaded,setIsLoaded] = useState(false);
  const [id, setId]=useState('');
  const [timeStarted, setTimeStarted]=useState('');
  const [workoutName, setWorkoutName]=useState('');


  const [workouts, setWorkouts] = useState([]);
  const workout={id, timeStarted, workoutName}

useEffect(() => {
  const axios = require('axios').default;
  axios
  .get('http://localhost:8080/workout/getAll')
  .then((response) => {
    setIsLoaded(true);
    console.log(response.data);
    
    response.data.forEach(oneWorkout => {
       workout.id = oneWorkout.id
       workout.timeStarted = oneWorkout.timeStarted
       workout.workoutName = oneWorkout.id
    });
    setWorkouts(response.data);
  });
}, [])

const columns = [
  {field: "id", headerName: "ID", width: 90},
  {field: "timeStarted", headerName: "TimeStarted", width: 200},
  {field: "workoutName", headerName: "WorkoutName", width: 200}
]
   
return (
  <div className="userList">
    <DataGrid
      rows={workouts}
      disableSelectionOnClick
      columns={columns}
      pageSize={8}
      checkboxSelection
    />
  </div>
)
}
