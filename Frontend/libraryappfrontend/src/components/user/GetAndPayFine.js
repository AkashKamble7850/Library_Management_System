import react from "react";
import { URL } from './../../config'
import { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'


const GetFineDetails=(props)=>{
    const { details }= props
    const navigate = useNavigate()

    function payFine(issueBookId){
        const url = `${URL}/issueBooks/payFine/${issueBookId}`
        
        axios.get(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              toast.success('Fine paid')
              navigate('/view-issued-books')
            } else {
              toast.error(result['error'])
            }
          })

          
    }
  

    return(
         <tr key={ details.issueBookId }>
            <td>{ details.issueBookId }</td>
            <td>{ details.bookName }</td>
            <td>{ details.issueDate }</td>
            <td>{ details.dueDate }</td>
            <td>{ details.returnDate }</td>
            <td>{ details.fine }</td>
            {details.fine > 0 ? 
                <td>
                  <button onClick={() => payFine( details.issueBookId ) } type="button"  className="btn btn-primary btn-sm" class="btn btn-primary">Pay Now</button>
                </td>
                :
                <td></td>
            }
            
        {console.log(details)}

        </tr>
    )
}

export default GetFineDetails