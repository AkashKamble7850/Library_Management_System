import react from "react";
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom'
import { URL } from './../../config'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'

const Record=(props)=>{
    const {record}= props
    const navigate = useNavigate()

    function rejectRequest(issueBookId) {
        const url = `${URL}/issueBooks/deleteRequestByStaff/${issueBookId}`
        axios.delete(url).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            toast.warning("Request Rejected")
          } else {
            const res = result['error']
              function getKey(val) {
                return Object.keys(res).find(key => res[key] === val);
              }
              toast.error(getKey(0))
          }
        })
    }

    function approveRequest(issueBookId, bookId, userId){
        const url = `${URL}/issueBooks/approveRequestByStaff/`
        const body = {
            issueBookId,
            bookId,
            userId,
            staffId: sessionStorage['staffId'],        
          }
          axios.put(url, body).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              toast.success('Request Approved')
            } else {
              const res = result['error']
              function getKey(val) {
                return Object.keys(res).find(key => res[key] === val);
              }
              toast.error(getKey(0))
            }
          })
    }


    function approveReturnRequest(issueBookId) {
        const staffId = sessionStorage['staffId']
        const url = `${URL}/issueBooks/approveReturnRequestByStaff/${issueBookId}/${staffId}`
        axios.put(url).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            toast.success('Return request approved')
          } else {
            const res = result['error']
              function getKey(val) {
                return Object.keys(res).find(key => res[key] === val);
              }
              toast.error(getKey(0))
          }
        })
    }


    function rejectReturnRequest(issueBookId) {
        const staffId = sessionStorage['staffId']
        const url = `${URL}/issueBooks/rejectReturnRequestByStaff/${issueBookId}/${staffId}`
        axios.put(url).then((response) => {
          const result = response.data
          if (result['status'] == 'success') {
            toast.warning('Return reques rejected')
          } else {
            const res = result['error']
              function getKey(val) {
                return Object.keys(res).find(key => res[key] === val);
              }
              toast.error(getKey(0))
          }
        })
    }

    return(
        <tr key={record.issueBookId}>
            <td>{record.issueBookId}</td>
            <td>{record.bookId}</td>
            <td>{record.BookName}</td>
            <td>{record.userId}</td>
            <td>{record.firstName}</td>
            <td>{record.lastName}</td>
            <td>{record.issueDate}</td>
            <td>{record.returnDate}</td>
            <td>{record.issueStatus}</td>
            {record.issueStatus==="IR" ? 
                    <td>
                    <button onClick={() => approveRequest(record.issueBookId, record.bookId, record.userId)} type="button" class="btn btn-outline-danger" class="btn btn-outline-info" class="btn btn-primary btn-sm" class="btn btn-primary">Accept</button>
                    {" "}
                    <button onClick={() => rejectRequest(record.issueBookId)} type="button" class="btn btn-outline-danger" class="btn btn-outline-info" class="btn btn-primary btn-sm" class="btn btn-danger">Reject</button>
                    </td>
                    : record.issueStatus==="RR" ? 
                    <td>
                    <button onClick={() => approveReturnRequest(record.issueBookId)} type="button" class="btn btn-outline-danger" class="btn btn-outline-info" class="btn btn-primary btn-sm" class="btn btn-primary">Return</button>
                    {" "}
                    <button onClick={() => rejectReturnRequest(record.issueBookId)} type="button" class="btn btn-outline-danger" class="btn btn-outline-info" class="btn btn-primary btn-sm" class="btn btn-danger" >Reject</button>
                    </td>
                    :
                    <td></td>
                }
        </tr>
    )
}

export default Record