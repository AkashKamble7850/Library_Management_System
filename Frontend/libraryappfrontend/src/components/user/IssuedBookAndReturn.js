import react, { useState } from "react";
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { URL } from './../../config'
import GetFineDetails from "./GetAndPayFine";
const Return=(props)=>{
    const { list }= props
    const navigate = useNavigate()
    const [fine, setFine] = useState([])

    function requestBookReturn(issueBookId, bookId, issueStatus){

      const fineUrl = `${URL}/issueBooks/addFineTableRows/${issueBookId}`
      axios.post(fineUrl).then((response) => {
        const resultFine = response.data
      })

      const checkFineStatusUrl = `${URL}/issueBooks/checkFineStatusByIssueBookId/${issueBookId}`
      axios.get(checkFineStatusUrl).then((response) => {
        const resultFineStatus = response.data

        if (resultFineStatus['status'] == 'success') {
                  const url = `${URL}/issueBooks/getReturnRequest/${issueBookId}`
                  const body = {
                  issueBookId,
                  bookId,
                  issueStatus,
                  userId: sessionStorage['userId'],        
                }
                  axios.put(url, body).then((response) => {
                  const result = response.data
                  if (result['status'] == 'success') {
                    toast.success('Book Return Requested')
                  } else {
                    toast.error(result['error'])
                  }
                })
        }
        else{
          toast.warning("You havn't paid fine yet")
          navigate('/fine')
          
              
        }
      })

      

      
  }



    return(
      <tr key={ list.issueBookId }>
        <td>{ list.issueBookId }</td>
        <td>{ list.bookId }</td>
        <td>{ list.issueDate }</td>
        <td>{ list.dueDate }</td>
        <td>{ list.issueStatus }</td>
        {list.issueStatus==="I" ? 
                    <td>
                      <button onClick={() => requestBookReturn(list.issueBookId, list.bookId, list.issueStatus)} type="button"  className="btn btn-primary btn-sm" class="btn btn-primary">Return Book</button>
                    {" "}
                    </td>
                    :
                    <td></td>
                }


  </tr>
)
}

export default Return