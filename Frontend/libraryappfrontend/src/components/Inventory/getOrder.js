import React from "react";
import axios from "axios";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { useNavigate } from 'react-router'
import { URL } from '../../config'

const GetOrder=(props)=>{
    const {list}= props
    const navigate = useNavigate()

    function deleteOrder(orderId)
    {
    const url = `${URL}/orders/${orderId}`
    axios.delete(url).then((response) => {
        // get the data from the response
        const result = response.data
        
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Order Deleted!')
          navigate('/book')
        } else {
          toast.error(result['error'])
        }
      })
    }

    return(
        <tr key={list.orderId}>
            <td>{list.orderId}</td>
            <td>{list.bookName}</td>
            <td>{list.aFirstName}</td>
            <td>{list.quantity}</td>
            <td>{list.language}</td>
            <td>{list.vendor.vendorName}</td>

        <td>
        <button onClick={() => deleteOrder(list.orderId)} 
        type="button" class="btn btn-outline-danger">Delete</button> 
        </td>

        </tr>

        // orderId | bookName  | aFirstName | quantity | language | vendorId
    )
}

export default GetOrder

