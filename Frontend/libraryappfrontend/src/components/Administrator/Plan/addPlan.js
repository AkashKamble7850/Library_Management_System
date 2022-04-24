
import { Link } from 'react-router-dom'
import { useState } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import { URL } from '../../../config'

const AddPlan = () => {
    // const [staffId, setStaffId] = useState('')
    const [planName, setPlanName] = useState('')
    const [planFee, setPlanFee] = useState('')
    

    // used to navigate from one component to another
    const navigate = useNavigate()

    const add = () => {
        if (planName.length == 0) {
          toast.warning('Please enter plan name')
        } else if (planFee.length == 0) {
          toast.warning('Please enter fee')
        } else {
            const body = {
                planName,
                planFee,
            }
    
        // url to call the api
        const url = `${URL}/admin/addplan`
        console.log(url)
    
        // http method: post
        // body: contains the data to be sent to the API
        
        axios.post(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Plan Added Successfully!')
    
              // navigate to the signin page
              navigate('/planDetails')
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
                        <h3>Add New Plan</h3>
                        <hr/>
                        <div className="row">
                            <div className="col">
                        
                    

                            <div className="form">
                                <div className="mp-3">
                                <label htmlFor="" className="label-control">
                                    Plan Name
                                </label>
                                <input onChange={(e) => {
                                    setPlanName(e.target.value)
                                }} type="text" className="form-control" />
                            </div>
                            </div>

                            <div className="form">
                            <div className="mp-3">
                                <label htmlFor="" className="label-control">
                                Plan Fee
                                </label>
                                <input onChange={(e) => {
                                setPlanFee(e.target.value)
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

export default AddPlan;