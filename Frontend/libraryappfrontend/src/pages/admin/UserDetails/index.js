import "./index.css" 
import { useNavigate } from 'react-router'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import React from "react";
import User from '../../../components/User'
// import UserDetails from "../UserDetails";
import axios from "axios";
import { toast } from 'react-toastify';
import StaffProfile from "../../../components/StaffProfile";

const UserDetails= () => {
   const [userId , setUserId] = useState('')
   const [staffId , setStaffId] = useState('')
   const [firstName, setFirstName ] = useState("")
   const [lastName, setLasttName ] = useState("")
   const [role, setRole] = useState('')

    const navigate = useNavigate()
    const profileUser =() =>{ 
      
     
         <StaffProfile/>
        navigate('/staffProfile')}
   const user =() =>{
        navigate('/admin/UserDetails')}
   const staff =() =>{
        navigate('/admin/StaffDetails')}
   const plan =() =>{
        navigate('/admin/MemberShipPlan')
   
   
         
    }    
    return (
      <div className="container-fluid" >
         <div className="row">
            <div className="col-4" style={{
               width: '300px',
               height: '1000px',
               left: '36px',
               top: '36px',
               background: 'rgba(10, 24, 40, 0.169)'
               
               }}>
                  <h1>Dashboard</h1>
                  <hr/>
                  <hr/>
                  <br/>
                  <br/>
                  <div className="d-grid gap-2">
                     <button onClick={user}  className="btn btn-outline-secondary" type="button">User Details</button>
                     <br/>
                     <button onClick={staff}  className="btn btn-outline-secondary" type="button">Staff Details</button>
                     <br/>
                     <button onClick={plan}  className="btn btn-outline-secondary" type="button">Membership plan Details</button>
                     
                  </div>
                  {/* <br/>
                  <br/>
                  
                  <Link to="/admin/UserDetails">User Details</Link> 
                  <br/>
                  <br/>
                  <Link to="/admin/StaffDetails">Staff Details</Link> 
                  <br/>
                  <br/>
                  <Link to="/admin/MemberShipPlan">Membership Plan</Link> 
                  <br/>
                  <br/> */}
               </div>


            <div className="col-5 ">
               <div className="row" style={{
               width: '1100px',
               height: '100px',
               left: '36px',
               top: '36px',
               // background: 'rgba(66, 151, 235, 0.169)'
               
               }}>\
                  <div className="col">
          <div className="float-centre">
            <div className="btn-group " role="group">
              <button
                id="btnGroupDrop1"
                type="button"
                className="btn btn-primary dropdown-toggle"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Welcome {firstName}
              </button>
              <ul className="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li>
                  <button onClick={profileUser} className="dropdown-item">
                  My Profile
                  </button>
                </li>
                {/* <li>
                  <button onClick={logoutUser} className="dropdown-item">
                    Logout
                  </button>
                </li> */}
                <li>
                  {/* <button onClick={logoutStaff} className="dropdown-item">
                    Logout
                  </button> */}
                </li>
              </ul>
            </div>
            </div>
            </div>
               </div>

               {/* <div className="row" style={{
               width: '1100px',
               height: '100px',
               left: '36px',
               top: '36px',
               // background: 'rgba(77, 201, 305, 0.169)'            
               }}>
                  {/* <div className="col border border-dark" style={{
                     height: '80px',
                     background: '$blue-600'}}>Total number of User </div>

                  <div className="col">Total number of Book</div>

                  <div className="col">Total number of Issue Book</div> 

               </div> */}


               <div className="row" style={{
               width: '1100px',
               height: '500px',
               left: '36px',
               top: '36px'          
               }}>
                                
               <User/>

               </div>
               
            </div>
         </div>
         </div> 
    )
}


export default UserDetails
  
