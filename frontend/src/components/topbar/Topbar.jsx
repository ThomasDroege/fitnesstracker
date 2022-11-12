import React from 'react'
import "./topbar.css"

export default function Topbar() {
  return (
    <div className="topbar">
        <div className="topbarWrapper">
            <div className="topbarLeft">
                <span className="logo">fitnesstracker</span>
            </div>
            <div className="topbarRight">Benutzerkonto</div>
        </div>
    </div>
  )
}
