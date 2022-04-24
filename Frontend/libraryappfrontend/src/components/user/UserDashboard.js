import React from "react";
import { slide as Menu } from 'react-burger-menu';
import { Link } from "react-router-dom";
import './dashboard.css'

function UserDashboard () {
    return (
        <Menu>
            <Link to="/view-issued-books" className="menu-item" >
            View All Issued Books
            </Link>
    
            <Link to="/submit-book-request" className="menu-item" >
            Submit Book Request
            </Link>
    
            <Link to="/fine" className="menu-item" >
            Fine
            </Link>
        
            <Link to="/write-feedback" className="menu-item" >
            Feedback
            </Link>
        </Menu>
    )
}

export default UserDashboard