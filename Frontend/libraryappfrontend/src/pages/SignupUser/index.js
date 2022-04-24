import "./index.css"
import { Link } from 'react-router-dom'
import { useState } from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import axios from "axios";
import { useNavigate } from 'react-router'
import { URL } from './../../config'
import image from "./images8.png" 

const Signup = () => {
    const [userId, setUserId] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [confirmPassword, setConfirmPassword] = useState('')
    const [mobile, setMobile] = useState('')
    const [address, setAddress] = useState('')
    const [education, setEducation] = useState('') 
    const [intrest, setIntrest] = useState('')
    const [plan, setPlan] = useState('')
    const [parameter, setParameter]=useState('')

    // used to navigate from one component to another
    const navigate = useNavigate()


    const signupUser = () => {
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
                email,
                password,
                mobile,
	            address,
	            education,
	            intrest
            }
    
        // url to call the api
        const url = `${URL}/signup/${parameter}`
    
        // http method: post
        // body: contains the data to be sent to the API
        axios.post(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Successfully signed up new user')
    
              // navigate to the signin page
              navigate('/')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }


    return (
        <div className="container-fluid">
            
            <div className="row">
            <div className="col">
            
            </div>
                <div className="col">
                    <h3>Registration Form</h3>
                </div>
            </div>
        
            <hr/>
            <div className="row">
            <div className="col">
            <img width="100%" height="100%"  src={image} />
            </div>

                <div className="col">

                <div className="row">
                    <div className="col">
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
                    </div>
                    <div className="col">
                        <div className="form">
                        <div className="mp-3">
                            <label htmlFor="" className="label-control">
                                Last Name
                            </label>
                            <input onChange={(e) => {
                                setLastName(e.target.value)
                            }}type="text" className="form-control" />
                        </div>
                        </div>
                    </div>
                </div>

                <div className="row">
                    <div className="col">
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
                    </div>
                    <div className="col">
                        <div className="form">
                        <div className="mp-3">
                            <label htmlFor="" className="label-control">
                                Password
                            </label>
                            <input onChange={(e) => {
                                setPassword(e.target.value)
                            }}type="password" className="form-control" />
                        </div>
                        </div>
                    </div>
                </div>
            
                

                <div className="form">
                <div className="mp-3">
                    <label htmlFor="" className="label-control">
                        Confirm Passward
                    </label>
                    <input onChange={(e) => {
                                setConfirmPassword(e.target.value)
                            }} type="password" className="form-control" />
                </div>
                </div>

                
                <div className="row">
                    <div className="col">
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
                               Mobile
                            </label>
                            <input onChange={(e) => {
                                setMobile(e.target.value)
                            }}type="number" className="form-control" />
                        </div>
                        </div>
                    </div>
                </div>

                
                <div className="row">
                    <div className="col">
                        <div className="form">
                        <div className="mp-3">
                            <label htmlFor="" className="label-control">
                                Education
                            </label>
                        <input onChange={(e) => {
                                setEducation(e.target.value)
                            }} type="text" className="form-control" />
                        </div>
                        </div>
                    </div>
                    <div className="col">
                        <div className="form">
                        <div className="mp-3">
                            <label htmlFor="" className="label-control">
                                Intrest
                            </label>
                            <input onChange={(e) => {
                                setIntrest(e.target.value)
                            }}type="text" className="form-control" />
                        </div>
                        </div>
                    </div>
                </div>
            
                <br />
                <div className="form">
                <div className="mp-3">
                    <label htmlFor="" className="label-control">
                        MemberShip Plan
                    </label>
      
                    <div class="form-check">
                        <input onClick={(e) => {
                                setParameter('1')
                            }} class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"/>
                        <label class="form-check-label" for="flexRadioDefault1">
                        One Month
                        </label>

                    </div>
                    
                    <div class="form-check">
                        <input onClick={(e) => {
                                setParameter('2')
                            }} class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"/>
                        <label class="form-check-label" for="flexRadioDefault2">
                        Three Months
                        </label>
                    </div>

                    <div class="form-check">
                        <input onClick={(e) => {
                                setParameter('3')
                            }} class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3"/>
                        <label class="form-check-label" for="flexRadioDefault3">
                        Six Months
                        </label>
                    </div>

                    <div class="form-check">
                        <input onClick={(e) => {
                                setParameter('4')
                            }} class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault4"/>
                        <label class="form-check-label" for="flexRadioDefault4">
                        One Year
                        </label>
                    </div>

                </div>
                
              <br />
                <div className="col">
                <div>
                    Already Registered? <Link to="/">SignIn here</Link> 
                </div>
                </div>
                
                </div>    
                
                <div className="mb-3">
                    <button onClick={signupUser} className="btn btn-primary">
                        Register
                    </button>
                </div> 


                </div>

            </div>         
        
        </div>   

    ) 
}

export default Signup;