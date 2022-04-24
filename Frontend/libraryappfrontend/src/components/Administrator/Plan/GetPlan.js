import axios from "axios";
import { useEffect, useState } from 'react'
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router'

const GetPlan=(props)=>{
    const {list}= props
    const [users, setUsers] = useState(0)
    
    const navigate = useNavigate()

    useEffect(() => {
      axios.get(`${URL}/books/countActiveUsers`).then(Response => setUsers(Response.data.data))
    })

    function UpdatePlan(planId, planName,planFee) {
        const url = `${URL}/admin/updateplan/${planId}`
            const body = {
                planName,
                planFee           
              }
              axios.put(url, body).then((response) => {
                const result = response.data
                if (result['status'] == 'success') {
                  toast.success('successfully updated plan..')
                } else {
                  toast.error(result['error'])
                }
              })
        

    }



    const editPlan = () => {
      // console.log({list});
      <editPlan thePlan={list}/>
      // console.log({list})
      
      navigate('/editPlan')
  }

    function DeletePlan(planId) {
        const url = `${URL}/admin/deleteplan/${planId}`
        axios.delete(url).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            toast.success('successfully Deleted plan')
          
          } else {
            toast.error(result['error'])
          }
        })
    }
    
    return(
        <tr>
            <td>{list.planId}</td>
            <td>{list.planName}</td>
            <td>{list.planFee}</td>
           
            {/* <td>
            {/* <button onClick={() => UpdatePlan(list.planId,list.planName,list.planFee)} type="button" className="btn btn-warning btn-sm">Edit</button> 
             <button onClick={editPlan}type="button" className="btn btn-warning btn-sm">Edit</button>
            </td> */}
            <td>
            <button onClick={() => DeletePlan(list.planId)} type="button" className=" btn btn-danger btn-sm" >Delete</button>
            </td>
            
        </tr>
    )
}

export default GetPlan