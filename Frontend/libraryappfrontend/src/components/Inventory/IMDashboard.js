import React from "react";
import { slide as Menu } from 'react-burger-menu';
import { Link } from "react-router-dom";
import './IMDashboard.css'

function IMDashboard () {
    return (
        <Menu>
            <Link to="/category" className="menu-item" >
            Category summary
            </Link>
    
            <Link to="/orders" className="menu-item" >
            Orders Summary
            </Link>
    
            <Link to="/vendor" className="menu-item" >
            Vendor Summary
            </Link>
    
            <Link to="/add-vendor" className="menu-item" >
            Add Vendor
            </Link>
    
            <Link to="/add-book" className="menu-item" >
            Add Book
            </Link>

            <Link to="/add-order" className="menu-item" >
            Order Book
            </Link>

            <Link to="/book" className="menu-item" >
            Search Book
            </Link>

            <Link to="/author" className="menu-item" >
            Authors summary
            </Link>

        </Menu>
    )
}

export default IMDashboard
