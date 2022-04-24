
import { Link } from 'react-router-dom'
import { useState } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import { URL } from '../../../config'

const AddStaff = () => {
    // const [staffId, setStaffId] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [confirmPassword, setConfirmPassword] = useState('')
    const [mobile, setMobile] = useState('')
    const [address, setAddress] = useState('')
    const [gender, setGender] = useState('') 
    const [role, setRole] = useState('')
    const [dateOfJoining, setDateOfJoining] = useState('')

    // used to navigate from one component to another
    const navigate = useNavigate()

    const add = () => {
        if (firstName.length == 0) {
          toast.warning('Please enter first name')
        } else if (lastName.length == 0) {
          toast.warning('Please enter last name')
        } else if (email.length == 0) {
          toast.warning('Please enter email')
        } else if (password.length == 0) {
          toast.warning('Please enter password')
        } else if (confirmPassword.length == 0) {
          toast.warning('Please confirm your password')
        } else if (password != confirmPassword) {
          toast.warning('Password does not match')
        } else {
            const body = {
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
    
        // url to call the api
        const url = `${URL}/staff/add`
        console.log(url)
    
        // http method: post
        // body: contains the data to be sent to the API
        
        axios.post(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Staff Added Successfully!')
    
              // navigate to the signin page
              navigate('/staffDetails')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }

    
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-4">DashBoard</div>
                <div className="col-8">
                    <div className="row"></div>
                    <div className="row">
                    <h3>Personal Information</h3>
                    <hr/>
                    <div className="row">
                        <div className="col">
                        <div className="form">
                    {/* <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Staff ID
                        </label>
                        <input onChange={(e) => {
                                setStaffId(e.target.value)
                            }} type="number" className="form-control" />
                    </div> */}
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            First Name
                        </label>
                        <input onChange={(e) => {
                                setFirstName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Gender
                        </label>
                        <input onChange={(e) => {
                                setGender(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Email
                        </label>
                        <input onChange={(e) => {
                                setEmail(e.target.value)
                            }} type="email" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Password
                        </label>
                        <input onChange={(e) => {
                                setPassword(e.target.value)
                            }} type="password" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Address
                        </label>
                        <input onChange={(e) => {
                                setAddress(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>
                        </div>
                        <div className="col">
                    

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Last Name
                        </label>
                        <input onChange={(e) => {
                                setLastName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Role
                        </label>
                        <input onChange={(e) => {
                                setRole(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Date Of Joining
                        </label>
                        <input onChange={(e) => {
                                setDateOfJoining(e.target.value)
                            }} type="date" className="form-control" />
                    </div>
                    </div>

                    
                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Confirm Password
                        </label>
                        <input onChange={(e) => {
                                setConfirmPassword(e.target.value)
                            }} type="password" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Mobile
                        </label>
                        <input onChange={(e) => {
                                setMobile(e.target.value)
                            }} type="number" className="form-control" />
                    </div>
                    </div>
                            <br/>
                    <div className="mb-3">
                    <button onClick={add} className="btn btn-primary">
                        Save
                    </button>
                    </div>    
                        </div>
                    </div>
                    </div>
                </div>
            </div>             
        </div>    

    ) 
}

export default AddStaff;