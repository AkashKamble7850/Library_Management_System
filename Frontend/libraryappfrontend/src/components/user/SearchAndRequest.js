import react from "react";
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom'
import { URL } from './../../config'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'

const RequestIssue=(props)=>{
    const { record }= props
    const navigate = useNavigate()


    function requestBook(bookId){
      const url = `${URL}/issueBooks/issueRequestFromUser`
      const body = {
          bookId,
          userId: sessionStorage['id'],        
        }
        axios.post(url, body).then((response) => {
          console.log(url)
          const result = response.data
          console.log(result)
          if (result['status'] == 'success') {
            toast.success('Book Requested')
          } else {
            toast.error(result['error'])
          }
        })
  }



    return(
      <tr key={ record.bookId }>
        <td>{ record.bookName }</td>
        <td>{ record.bookId }</td>
        <td>{ record.isbn }</td>
        <td>{ record.firstName }</td>
        <td>{ record.lastName }</td>
        <td>{ record.category }</td>
        <td>
          <button onClick={ () => requestBook( record.bookId ) } type="button"  className="btn btn-primary btn-sm" class="btn btn-primary">Request Book</button>
          {" "}
        </td>

  </tr>
)
}

export default RequestIssue