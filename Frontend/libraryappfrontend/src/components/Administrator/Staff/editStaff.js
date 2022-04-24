import { Link } from 'react-router-dom'
import { useState, useEffect } from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import axios from "axios";
import { useNavigate, useLocation } from 'react-router'
import { URL } from '../../../config'
import '../../../components/user/dashboard.css'
import WelcomeBlock from '../../user/WelcomeBlock'

const EditStaff = () => {
    const [staffProfile, setstaffProfile] = useState([])

    const [staffId, setStaffId] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
//  const [confirmPassword, setConfirmPassword] = useState('')
    const [mobile, setMobile] = useState('')
    const [address, setAddress] = useState('')
    const [gender, setGender] = useState('') 
    const [role, setRole] = useState('')
    const [dateOfJoining, setDateOfJoining] = useState('')  
    const currentStaffId = sessionStorage['staffId']
    const { state } = useLocation()
    // used to navigate from one component to another
    const navigate = useNavigate()

    useEffect(() => {
        const id = sessionStorage['staffId']
        const urll = `${URL}/staff/${id}`
        console.log(urll)
        axios
          .get(urll)
          .then((Response) => setstaffProfile(Response.data.data));
          console.log(staffProfile)

      },[])

      const update = () => {
        if (firstName.length == 0) {
          toast.warning('Please enter first name')
        } else if (lastName.length == 0) {
          toast.warning('Please enter last name')
        } else if (email.length == 0) {
          toast.warning('Please enter email')
        } else if (password.length == 0) {
          toast.warning('Please enter password')
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
                password,
                mobile,
                address,
                dateOfJoining
            }
            console.log(body)
        // url to call the api

        const url = `${URL}/staff/${currentStaffId}`
    
        // http method: post
        // body: contains the data to be sent to the API
        axios.put(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Staff Edited Successfully')
    
              // navigate to the signin page
              navigate('/staffDetails')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }

    
    return (
        <div className='continer'>    
            
            
                <div className="col">
                <div className="col">
                    <WelcomeBlock></WelcomeBlock>
                </div>
                <br/><br/>
                <div class="container">
                    <div class="row">
                        <div class="col">

                    <div >
                    <h3>Edit Staff Profile</h3>
                    <hr/>

                    <div className="form">
                    <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Staff Id</label>
                    <input type="text" id="disabledTextInput" class="form-control" value={currentStaffId} />
                    </div>
                    </div>
                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            First Name
                        </label>
                        <input value = {firstName}
                        onChange={(e) => {
                                setFirstName(e.target.value)
                            }} type="text" className="form-control" placeholder={staffProfile.firstName}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Last Name
                        </label>
                        <input value = {lastName} 
                        onChange={(e) => {
                                setLastName(e.target.value)
                            }} type="text" className="form-control" placeholder={staffProfile.lastName}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Email
                        </label>
                        <input value = {email} 
                        onChange={(e) => {
                                setEmail(e.target.value)
                            }} type="email" className="form-control" placeholder={staffProfile.email}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Password
                        </label>
                        <input value = {password} 
                        onChange={(e) => {
                                setPassword(e.target.value)
                            }} type="password" className="form-control" placeholder="*******"/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Address
                        </label>
                        <input value = {address}
                        onChange={(e) => {
                                setAddress(e.target.value)
                            }} type="text" className="form-control" placeholder={staffProfile.address}/>
                    </div>
                    </div>
                    </div>


                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Mobile
                        </label>
                        <input value = {mobile}
                        onChange={(e) => {
                                setMobile(e.target.value)
                            }} type="number" className="form-control" placeholder={staffProfile.mobile}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Role
                        </label>
                        <input value = {role}
                        onChange={(e) => {
                                setRole(e.target.value)
                            }} type="text" className="form-control" placeholder={staffProfile.role}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Gender
                        </label>
                        <input value = {gender}
                        onChange={(e) => {
                                setGender(e.target.value)
                            }} type="text" className="form-control" placeholder={staffProfile.gender}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Date of Joining 
                        </label>
                        <input value = {dateOfJoining}
                        onChange={(e) => {
                                setDateOfJoining(e.target.value)
                            }} type="date" className="form-control" placeholder={staffProfile.dateOfJoining}/>
                    </div>
                    </div>
                            <br/>
                    
                    <div className="mb-3">
                    <button onClick={update} className="btn btn-primary">
                        Update Profile
                    </button>
                    </div>    
                        </div>
                    </div>

                    </div>
                    <div class="col">
                    </div>
                    </div>
                    </div>

    ) 
}

export default EditStaff;
