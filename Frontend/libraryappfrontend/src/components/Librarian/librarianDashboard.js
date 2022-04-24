import React from "react";
import { slide as Menu } from 'react-burger-menu';
import { Link } from "react-router-dom";
import './dashboard.css'

function LibrarianDashboard () {
    return (
        <Menu>
            <Link to="/libHome" className="menu-item" >
            Home
            </Link>
    
            <Link to="/issueRecordTable" className="menu-item" >
            Issue Book Request
            </Link>
    
            <Link to="/returnRequestTable" className="menu-item" >
            Return Book Request
            </Link>
    
            <Link to="/bookTable" className="menu-item" >
            Search Book
            </Link>
    
            <Link to="/searchBar" className="menu-item" >
            View Records
            </Link>
    

            <Link to="/fineTable" className="menu-item" >
            Check Fine
            </Link>

        </Menu>
    )
}

export default LibrarianDashboard