import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function User() {
    const paperStyle={padding:'50px 20px', width:600, margin:"20px auto"};
    const [userName,setUserName]=useState('');
    const [firstName,setFirstName]=useState('');
    const [lastName,setLastName]=useState('');
    const [email,setEmail]=useState('');
    const [password,setPassword]=useState('');

    const [users,setUsers]=useState([])
    const classes = useStyles();

    const handleClick=(e)=>{
        e.preventDefault()
        const user={userName, firstName, lastName, email, password}
        console.log(user)

        fetch("http://localhost:8080/user/add",{
            method:"POST",
            headers:{"Content-Type": "application/json"},
            body:JSON.stringify(user)
            }).then(()=>{
                console.log("New User added")
                })
    }

    useEffect(()=>{
        fetch("http://localhost:8080/user/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setUsers(result);
        }
        )
    },[])

  return (
      <Container>
          <Paper elevation={3} style={paperStyle}>
              <h1 style={{color: "blue"}}><u>Add User</u></h1>
            <form className={classes.root} noValidate autoComplete="off">
            
            <TextField id="outlined-basic" label="User Name" variant="outlined" fullWidth
             value={userName} onChange={(e)=>setUserName(e.target.value)}/>
            <TextField id="outlined-basic" label="First Name" variant="outlined" fullWidth
             value={firstName} onChange={(e)=>setFirstName(e.target.value)}/>
            <TextField id="outlined-basic" label="Last Name" variant="outlined" fullWidth
             value={lastName} onChange={(e)=>setLastName(e.target.value)}/>
            <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
             value={email} onChange={(e)=>setEmail(e.target.value)}/>
            <TextField id="outlined-basic" label="password" variant="outlined" fullWidth
             value={password} onChange={(e)=>setPassword(e.target.value)}/>

                 <Button variant="contained" onClick={handleClick}>Submit</Button>
            </form>
        </Paper>
        <h1>Users</h1>

        <Paper elevation={3} style={paperStyle}>

            {users.map(user=>(
                <Paper elevation={6} 
                    style={{margin:"10px", padding:"15px", textAlign:"left"}} key={user.id}>
                    Id: {user.id}<br/>
                    Name: {user.userName}<br/>
                    Email: {user.email}<br/>    
                </Paper>
            ))
        }


        </Paper>
    </Container>
  );
}