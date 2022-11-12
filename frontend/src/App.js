import './App.css';
import React from 'react';
import Student from './components/User';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Topbar from './components/topbar/Topbar';
import Sidebar from './components/sidebar/Sidebar';
import Workouts from './pages/workouts/Workouts';
import Home from './pages/home/Home';

function App() {
  return (
    <Router>
      <Topbar/>
      <div className="container">
        <Sidebar/>
        <Routes>
          <Route path="/" element={<Home/>} exact/>
          <Route path="/workouts" element={<Workouts/>} exact/>
        </Routes>
      
      </div>
    </Router>
  );
}

export default App;
