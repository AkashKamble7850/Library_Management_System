import "./index.css"
import { Link } from 'react-router-dom'
import { useState } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import { URL } from '../../config'


const Signin = () => {
    const [userId , setUserId] = useState('')
    const [staffId , setStaffId] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [role, setRole] = useState('')

    //used to navigate from one component to another
    const navigate = useNavigate()

    const signinUser = () => {
        if (email.length == 0) {
            toast.warning('please enter email')
        } else if (password.length == 0) {
            toast.warning('please enter password')
        } else {
        const body = {
            email,
            password,
            }   

            console.log(body);

            //url to call api
            const url = `${URL}/signin`

            //http method post
            axios.post(url, body).then((response) => {
                //get the result from server
                const result = response.data

                if(result['status'] == 'success'){
                    toast.success('Welcome to the application')

                    if(result.data.role){
                        const { staffId, firstName, lastName, role } = result['data']


                        // persist the logged in user's information for future use
                        sessionStorage['staffId'] = staffId
                        sessionStorage['firstName'] = firstName
                        sessionStorage['lastName'] = lastName
                        sessionStorage['role'] = role
                        sessionStorage['loginStatus'] = 1
                        
                       
                    if(sessionStorage['role'] == "admin")
                        navigate('/staffDetails')
                    
                    if(sessionStorage['role'] == "Librarian")
                        navigate('/libHome')

                    if(sessionStorage['role'] == "Manager")
                        navigate('/book')
            }else{
                const { id, firstName, lastName } = result['data']

                // persist the logged in user's information for future use
                sessionStorage['id'] = id
                sessionStorage['firstName'] = firstName
                sessionStorage['lastName'] = lastName
                sessionStorage['loginStatus'] = 1
                
            //navigate to user Dashboard
            
            navigate('/submit-book-request')
        }
        }
        else{
            toast.error('Invalid user name or password')  
                }      
                
    })
     
        }
}


    return (
        
        <div className="container-fluid"  >
            
            <div className="row">
                <div className="col-8 border border-dark" style={{width: '900px',
               height: '700px',
               left: '36px',
               top: '36px',
               background: 'rgba(34, 95, 117, 0.049)'}}>
                   <br/>
                    <br/>
                    <h1 class= "text-center">Library Management System</h1>
                    <br/>
                    <br/>
                
                    <div>
                        <ul type="circle">
                            <b>Rules & Regulations:</b>
                            <br/>
                            <br/>
                            <h6>Library Membership</h6>
                            <li> Everyone is entitled to become library members inorder to isssue book.</li>
                            <li>User has to take on of the following Membership Plan</li>
                            <br />
                            <table class="table table-bordered border-primary">
                            <thead>
                                <tr>
                                    <th scope='col'>Plan Id</th>
                                    <th scope='col'>Plan Name</th>
                                    <th scope='col'>Rate</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                <th scope="row">1</th>
                                <td>One Month</td>
                                <td>500</td>
                                </tr>
                                <tr>
                                <th scope="row">2</th>
                                <td>Three Months</td>
                                <td>1400</td>
                                </tr>
                                <tr>
                                <th scope="row">3</th>
                                <td>Six Months</td>
                                <td>2600</td>
                                </tr>
                                <tr>
                                <th scope="row">4</th>
                                <td>One Year</td>
                                <td>5000</td>
                                </tr>
                            </tbody>


                            </table>
                            <br/>
                            <h6>Issue/Return Rules</h6>
                            
                            
                            <li>User can issue as many of book he/she want.</li>
                            <li>Book should return it within 15 days.</li>
                            <li>Otherwise, late fees of Rs.5/- per day will be charge on each book.</li>
                            <li>Fine will be collected by Libraian at time of Book return.</li>
                            <br/>
                            
                        


                        </ul>
                        
                    </div>
                </div>
                
                <div className="col-4 " style={{width: '400px',height: '700px' }}>
                    <br/>
                    <h3 className= "text-center">Welcome to Library</h3>
                    <br/>
                    <br/>
                    <h6 className= "text-center" ><i>"Nothing is pleasenter than Expoloring A Library"</i></h6>
                    <br/>
                    <br/>
                    

                    <br/>
                    <div className="form">
                        <div className="mp-3">
                            <label htmlFor="" className="label-control">
                                Email Address
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
                    <br/>
                    <div className= "text-center">
                        New Here? <Link to="/signupuser">Create Account</Link> 
                    </div>
                    
                    <br/>
                    <div className="mb-3 text-center">
                        
                        <button onClick={signinUser} className="btn btn-primary margin-right">
                            Signin
                        </button>
                        
                    </div>     
                </div>        
            </div>
        </div>     
        
    )
}


export default Signin