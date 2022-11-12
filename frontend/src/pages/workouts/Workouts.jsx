import "./workouts.css"
import React, { useState } from "react"
import { DataGrid } from '@mui/x-data-grid';
import {DeleteOutline} from '@material-ui/icons'
import {userRows} from "../../dummyData"
import {Link} from "react-router-dom"

export default function Workouts() {
  const [data,setData] = useState(userRows)
  const handleDelete = (id)=>{
    setData(data.filter(item=>item.id !== id))
  }
const columns = [
  { field: 'id', headerName: 'ID', width: 90 },
  { field: 'userId', headerName: 'UserName', width: 100 },
  { field: 'workoutName', headerName: 'WorkoutName', width: 150 },
  { field: 'date', headerName: 'Date', width: 150 },
  { field: 'duration', headerName: 'Duration', type: 'number', width: 120 }
];

return (
  <div className="userList">
    <DataGrid
      rows={data}
      disableSelectionOnClick
      columns={columns}
      pageSize={8}
      checkboxSelection
    />
  </div>
)
}
