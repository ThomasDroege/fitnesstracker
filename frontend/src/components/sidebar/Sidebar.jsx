import React from 'react'
import "./sidebar.css"
import {FitnessCenter, Home, ShowChart} from "@material-ui/icons"
import LeaderboardIcon from '@mui/icons-material/Leaderboard';
import SnowshoeingIcon from '@mui/icons-material/Snowshoeing';
import WorkspacePremiumIcon from '@mui/icons-material/WorkspacePremium';
import { Link } from 'react-router-dom'


export default function Sidebar() {
  return (
    <div className="sidebar">
        <div className="sidebarWrapper">
            <div className="sidebarMenu">
                <h3 className="sidbarTitle">...</h3>  
                <ul className="sidebarList">
                <Link to="/" className="link">
                        <li className="sidebarListItem">
                            <Home className="sidebarIcon"/>
                            Home
                        </li>
                    </Link>
                </ul>
            </div>
            <div className="sidebarMenu">
                <h3 className="sidbarTitle">...</h3>  
                <ul className="sidebarList">
                    <Link to="/workouts" className="link">
                        <li className="sidebarListItem">
                            <FitnessCenter className="sidebarIcon"/>
                            Workouts
                        </li>
                    </Link>
                    <Link to="/" className="link">
                        <li className="sidebarListItem">
                            <SnowshoeingIcon className="sidebarIcon"/>
                            Exercises
                        </li>
                    </Link>
                </ul>
            </div>
            <div className="sidebarMenu">
                <h3 className="sidbarTitle">...</h3>  
                <ul className="sidebarList">
                <Link to="/" className="link">
                    <li className="sidebarListItem">
                        <ShowChart className="sidebarIcon"/>
                        Statistics
                    </li>
                </Link>
                <Link to="/" className="link">
                    <li className="sidebarListItem">
                        <LeaderboardIcon className="sidebarIcon"/>
                        Leaderboard
                    </li>
                </Link>
                <Link to="/" className="link">
                    <li className="sidebarListItem">
                        <WorkspacePremiumIcon className="sidebarIcon"/>
                        Goals
                    </li>
                </Link>
                </ul>
            </div>
        </div>    
    </div>
  )
}
