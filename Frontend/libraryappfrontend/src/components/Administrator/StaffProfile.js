
import { useState, useEffect } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import WelcomeBlock from './WelcomeBlock';
import {URL} from './../../config'


const AdminStaffProfile = () => {
    const [staffProfile, setStaffProfile] = useState([])
    

    const [staffId, setStaffId] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
//     const [password, setPassword] = useState('')
//     const [confirmPassword, setConfirmPassword] = useState('')
    const [mobile, setMobile] = useState('')
    const [address, setAddress] = useState('')
    const [gender, setGender] = useState('') 
    const [role, setRole] = useState('')
    const [dateOfJoining, setDateOfJoining] = useState('')

    // used to navigate from one component to another
    const navigate = useNavigate()

    useEffect(() => {
        const st = sessionStorage['staffId']
        const url = `${URL}/staff/${st}`
        console.log(url)
        axios
          .get(url)
          .then((Response) => setStaffProfile(Response.data.data));
          console.log(staffProfile)
    },[]);

    const update = () => {
        if (firstName.length == 0) {
          toast.warning('Please enter first name')
        } else if (lastName.length == 0) {
          toast.warning('Please enter last name')
        } else if (email.length == 0) {
          toast.warning('Please enter email')
//         } else if (password.length == 0) {
//           toast.warning('Please enter password')
//         } else if (confirmPassword.length == 0) {
//           toast.warning('Please confirm your password')
//         } else if (password != confirmPassword) {
//           toast.warning('Password does not match')
        } else {
            const body = {
                staffId,
                firstName,
                lastName,
                role,
                gender,
                email,
                mobile,
                address,
                dateOfJoining
            }
    
        // url to call the api
        const st = sessionStorage['staffId']
        const url = `${URL}/staff/${st}`
    
        // http method: post
        // body: contains the data to be sent to the API
        axios.get(url).then((response) => {
            // get the data from the response
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('ProFile is Updated Successfully!')
    
              // navigate to the signin page
              // navigate('/signin')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }
    const back = () => {
        navigate('/adminHome')
    }

    
    return (
        <div className="container">
            <div class="col">
              <div className="col">
                <WelcomeBlock></WelcomeBlock>
              </div>
              </div>
      <br></br>

            <div className="row">


                {/* <div className="col-4"></div> */}
                <div className="col">
                    <div className="row"></div>
                    <div className="row">
                    <h3>Personal Information</h3>
                    <hr/>

                    <div className="row">
                        <div className="col">
                        <div className="form">
                    <div className="mp-3" >
                    <label htmlFor="" className="label-control">
                            Staff ID
                        </label>
                        <input onChange={(e) => {
                                setStaffId(e.target.value)
                            }} type="number" className="form-control" value={staffProfile.staffId}/>    
                    </div>
                    
                    
                    </div>
                    <br></br>

                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            First Name
                        </label>
                        <input onChange={(e) => {
                                setFirstName(e.target.value)
                            }} type="text" className="form-control" value={staffProfile.firstName}/>
                        
                    </div>
                    </div>
                    <br></br>

                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Last Name
                        </label>
                        <input onChange={(e) => {
                                setLastName(e.target.value)
                            }} type="email" className="form-control" value={staffProfile.lastName}/>
                        
                    </div>
                    </div>
                    <br></br>

                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Gender
                        </label>
                        <input onChange={(e) => {
                                setGender(e.target.value)
                            }} type="text" className="form-control" value={staffProfile.gender}/>
                        
                    </div>
                    </div>
                    <br></br>

                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Email
                        </label>
                        <input onChange={(e) => {
                                setEmail(e.target.value)
                            }} type="email" className="form-control" value={staffProfile.email}/>
                        
                    </div>
                    </div>
                    <br></br>

                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Address
                        </label>
                        <input onChange={(e) => {
                                setAddress(e.target.value)
                            }} type="email" className="form-control" value={staffProfile.address}/>
                        
                    </div>
                    </div>
                    <br></br>


                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Mobile
                        </label>
                        <input onChange={(e) => {
                                setMobile(e.target.value)
                            }} type="number" className="form-control" value={staffProfile.mobile}/>
                        
                    </div>
                    </div>                   
                    
                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Role
                        </label>
                        <input onChange={(e) => {
                                setRole(e.target.value)
                            }} type="email" className="form-control" value={staffProfile.role}/>
                        
                    </div>
                    </div>
                    <br></br>

                    <div className="form">
                    <div className="mp-3">
                    <label htmlFor="" className="label-control">
                            Date Of Joining
                        </label>
                        <input onChange={(e) => {
                                setDateOfJoining(e.target.value)
                            }} type="date" className="form-control" value={staffProfile.dateOfJoining}/>
                        
                    </div>
                    </div>
                    <br></br>
                    
                            <br/>
                            <br/>

                        </div>
                        <div className="mb-3">
                        <br/>
                        <button onClick={back} className= "btn btn-primary">  Back </button>
                    {/* <button onClick={update} className="btn btn-primary">
                        Update Profile
                    </button> */}
                    </div>    

                    </div>
                    </div>
                </div>
            </div>             
        </div>    

    ) 
}

export default AdminStaffProfile;