import React from "react";
import { slide as Menu } from 'react-burger-menu';
import { Link } from "react-router-dom";
import './dashboard.css'

function Dashboard () {
    return (
        <Menu>
            {/* <Link to="/adminHome" className="menu-item" >
            Home
            </Link> */}
    
            <Link to="/userDetails" className="menu-item" >
            User Details
            </Link>
    
            <Link to="/staffDetails" className="menu-item" >
            Staff Details
            </Link>
    
            <Link to="/planDetails" className="menu-item" >
            Membership Plan Details
            </Link>

        </Menu>
    )
}

export default Dashboard