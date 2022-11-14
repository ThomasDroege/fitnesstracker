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
  

interface Workouts{
  id: string;
  timeStarted: string;
  workoutName: string;
  date: string;
}


useEffect(() => {
  axios.get<Workouts[]>('http://localhost:8080/workout/getAll')
  .then(response => {
    console.log(response.data);
    setIsLoaded(true);
    response.data.forEach(test => {
      test.date = test.timeStarted.substring(0,10);
      test.timeStarted = test.timeStarted.substring(11,16);
      test.workoutName = "Chest/Triceps";
    })
    setWorkouts(response.data); 
  });
}, [])

const columns = [
  {field: "id", headerName: "ID", width: 90},
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
      pageSize={8}
      checkboxSelection
    />
  </div>
)
}
