import { useNavigate } from 'react-router'
import { useEffect, useState } from 'react'
import axios from 'axios'
import { toast } from 'react-toastify'
import { Link } from 'react-router-dom'
import { slide as Menu } from 'react-burger-menu';
import "./dashboard.css"

const WelcomeBlock  = () => {

 // get the logged in user's information
 const { staffId, firstName, lastName } = sessionStorage
 const navigate = useNavigate()

 
 const logoutUser = () => {
   // remove the logged users details from session storage
   sessionStorage.removeItem('staffId')
   sessionStorage.removeItem('firstName')
   sessionStorage.removeItem('lastName')
   sessionStorage.removeItem('loginStatus')
   sessionStorage.removeItem('role')
   // navigate to sign in component
   navigate('/')
 }

 const profileUser = () => {


     navigate('/staffProfile')
 }
  return (
        <div className="col">
          <div className="float-end">
            <div className="btn-group " role="group">
              <button
                id="btnGroupDrop1"
                type="button"
                className="btn btn-primary dropdown-toggle"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                {firstName} {lastName}
              </button>
              <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li>
                  <button onClick={profileUser} className="dropdown-item">
                  Profile
                  </button>
                </li>
                <li>
                  <button onClick={logoutUser} className="dropdown-item">
                    Logout
                  </button>
                </li>
              </ul>
            </div>
          </div>
        </div>
  )
}

export default WelcomeBlock