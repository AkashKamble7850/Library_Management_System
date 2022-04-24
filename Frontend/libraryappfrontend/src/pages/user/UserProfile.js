import { Link } from 'react-router-dom'
import { useState, useEffect } from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import axios from "axios";
import { useNavigate, useLocation } from 'react-router'
import { URL } from '../../config'
import UserDashboard from './../../components/user/UserDashboard'
import '../../components/user/dashboard.css'
import WelcomeBlock from './../../components/user/WelcomeBlock'


const UserProfile = () => {
    const [userProfile, setUserProfile] = useState([])

    const [userId, setUserId] = useState('')
    const [uFirstName, setuFirstName] = useState('')
    const [uLastName, setuLastName] = useState('')
    const [uPassword, setuPassword] = useState('')
    const [uMobile, setuMobile] = useState('')
    const [uAddress, setuAddress] = useState('')
    const [uEducation, setuEducation] = useState('')
    const [uIntrest, setuIntrest] = useState('')   
    const currentUserId = sessionStorage['id']
    const { state } = useLocation()
    // used to navigate from one component to another
    const navigate = useNavigate()

    useEffect(() => {
        const id = sessionStorage['id']
        const urll = `${URL}/admin/getusersbyid/${id}`
        console.log(urll)
        axios
          .get(urll)
          .then((Response) => setUserProfile(Response.data.data));
          console.log(userProfile)

      },[])

    const update = () => {
        if (uFirstName.length == 0) {
          toast.warning('Please enter first name')
        } else if (uLastName.length == 0) {
          toast.warning('Please enter last name')
        }  else if (uPassword.length == 0) {
           toast.warning('Please enter password')
         } else {
            const body = {
                userId,
                uFirstName,
                uLastName,
                uPassword,
                uAddress,
                uMobile,
                uEducation,
                uIntrest                
            }
            console.log(body)
        // url to call the api

        const url = `${URL}/user/update/${currentUserId}`
    
        // http method: post
        // body: contains the data to be sent to the API
        axios.put(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('ProFile is Updated Successfully!')
    
              // navigate to the signin page
              navigate('/view-issued-books')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }

    
    return (
        <div id="#App" class="row">    
            <div className='col-3'>
                <UserDashboard></UserDashboard>
            </div>
            
                <div className="col">
                <div className="col">
                    <WelcomeBlock></WelcomeBlock>
                </div>

                <div class="container">
                    <div class="row">
                        <div class="col">
                        </div>

                        <div class="col-12">

                    <div>Welcome user</div>
                    <div >
                    <h3>Personal Information</h3>
                    <hr/>

                    <div className="form">
                    <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">User Id</label>
                    <input type="text" id="disabledTextInput" class="form-control" value={currentUserId} />
                    </div>
                    </div>
                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            First Name
                        </label>
                        <input value = {uFirstName}
                        onChange={(e) => {
                                setuFirstName(e.target.value)
                            }} type="text" className="form-control" placeholder={userProfile.uFirstName}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Last Name
                        </label>
                        <input value = {uLastName} 
                        onChange={(e) => {
                                setuLastName(e.target.value)
                            }} type="text" className="form-control" placeholder={userProfile.uLastName}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Password
                        </label>
                        <input value = {uPassword} 
                        onChange={(e) => {
                                setuPassword(e.target.value)
                            }} type="password" className="form-control" placeholder="*******"/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Address
                        </label>
                        <input value = {uAddress}
                        onChange={(e) => {
                                setuAddress(e.target.value)
                            }} type="text" className="form-control" placeholder={userProfile.uAddress}/>
                    </div>
                    </div>
                    </div>


                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Mobile
                        </label>
                        <input value = {uMobile}
                        onChange={(e) => {
                                setuMobile(e.target.value)
                            }} type="number" className="form-control" placeholder={userProfile.uMobile}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Education
                        </label>
                        <input value = {uEducation}
                        onChange={(e) => {
                                setuEducation(e.target.value)
                            }} type="text" className="form-control" placeholder={userProfile.uEducation}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Intrest
                        </label>
                        <input value = {uIntrest}
                        onChange={(e) => {
                                setuIntrest(e.target.value)
                            }} type="text" className="form-control" placeholder={userProfile.uIntrest}/>
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

export default UserProfile;

