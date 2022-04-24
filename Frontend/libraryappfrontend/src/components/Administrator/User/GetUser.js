import React from "react";
import axios from "axios";
import { toast } from 'react-toastify';
import { URL } from '../../../config'

const GetUser = (props) => {
    const { list } = props
    // const { feedback } = props

    function approveRequest(userId){
        const url = `${URL}/admin/updateuserstatus/${userId}`
          axios.patch(url).then((response) => {
            const result = response.data
            // if (result['data'] == 1)         
            if(result['status'] == 'success'){
              console.log(response.data)
              toast.success('Request is Approved')
            } else {
              toast.error(result['error'])
            }
          })
    }

    return (
        
        <tr>
            <td>{list.userId}</td>
            <td>{list.uFirstName}</td>
            <td>{list.uLastName}</td>
            <td>{list.uEmail}</td>
            <td>{list.uPlan.planName}</td>
            {list.uStatus == false ? 
            <td>
            <button onClick={() => approveRequest(list.userId)} type="button" class="btn btn-primary" data-bs-toggle="button" autocomplete="off">Accept Request</button>
            </td>
            :
            <td></td>
            }

        </tr>
        


       
    )
        

   
}

export default GetUser
