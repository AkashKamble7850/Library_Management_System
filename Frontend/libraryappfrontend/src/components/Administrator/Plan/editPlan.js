import { Link } from 'react-router-dom'
import { useState, useEffect } from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import axios from "axios";
import { useNavigate, useLocation } from 'react-router'
import WelcomeBlock from "../../../components/Administrator/WelcomeBlock"

const EditPlan = () => {
    
    const [plan, setPlan] = useState([])
    console.log(plan)

    const [planId, setplanId] = useState("")
    const [planName, setPlanName] = useState('')
    const [planFee, setPlanFee] = useState('')
    
    // const currentStaffId = sessionStorage['staffId']
  
    // used to navigate from one component to another
    const navigate = useNavigate()

    useEffect(() => {
        // const id = sessionStorage['staffId']
        const urll = `${URL}/admin/getplanbyid/${planId}`
        console.log(urll)
        axios
          .get(urll)
          .then((Response) => setPlan(Response.data.data));
          console.log(plan)

      },[])

      const update = () => {
        if (planName.length == 0) {
          toast.warning('Please enter plan name')
        } else if (planFee.length == 0) {
          toast.warning('Please enter Fee')
        } else {
            const body = {
                planName,
                planFee
            }
            console.log(body)
        // url to call the api

        const url = `${URL}/admin/updateplan/${planId}`
    
        // http method: post
        // body: contains the data to be sent to the API
        axios.put(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Plan updated Successfully')
    
              // navigate to the signin page
              navigate('/planDetails')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }

    
    return (
        <div className='container'>    
            
            
                <div className="col">
                <div className="col">
                    <WelcomeBlock></WelcomeBlock>
                </div>
                <br/><br/>
                <div class="container">
                    <div class="row">
                        <div class="col">

                    <div >
                    <h3>Edit Existing Plan</h3>
                    <hr/>

                    <div className="form">
                    <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Plan Id</label>
                    <input type="text" id="disabledTextInput" class="form-control" value={planId} />
                    </div>
                    </div>
                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Plan Name
                        </label>
                        <input value = {planName}
                        onChange={(e) => {
                                setPlanName(e.target.value)
                            }} type="text" className="form-control" placeholder={plan.planName}/>
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Plan Fee
                        </label>
                        <input value = {planFee} 
                        onChange={(e) => {
                                setPlanFee(e.target.value)
                            }} type="text" className="form-control" placeholder={plan.planFee}/>
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
                    
                    </div>
                    </div>
                    </div>

    ) 
}

export default EditPlan;