import axios from "axios";
import React from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { useNavigate } from 'react-router'
import { URL } from '../../config'


const GetVendor=(props)=>{

    const {list}= props
    const navigate = useNavigate()


    function deleteVendor(vendorId)
    {
    const url = `${URL}/vendor/${vendorId}`
    axios.delete(url).then((response) => {
        // get the data from the response
        const result = response.data
        
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Vendor Deleted!')
          navigate('/book')
        } else {
          toast.error(result['error'])
        }
      })
    }

    return(
        <tr key={list.vendorId}>
            <td>{list.vendorId}</td>
            <td>{list.vendorName}</td>
            <td>{list.vendorAddress}</td>
            <td>{list.vendorContact}</td>
            <td>{list.category.categoryName}</td>

            <td>
            <button onClick={() => deleteVendor(list.vendorId)} 
            type="button" class="btn btn-outline-danger">Delete</button> 
            </td>
            
        </tr>

        // orderId | bookName  | aFirstName | quantity | language | vendorId
    )
}

export default GetVendor

