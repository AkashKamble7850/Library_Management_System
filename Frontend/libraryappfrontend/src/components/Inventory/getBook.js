import axios from "axios";
import React from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { useNavigate } from 'react-router'
import { URL } from '../../config'
const GetBook=(props)=>{
    const {list}= props
    const navigate = useNavigate()

    function deleteBook(bookId)
    {
    const url = `${URL}/books/delete/${bookId}`
    axios.delete(url).then((response) => {
        // get the data from the response
        const result = response.data
        
        console.log(result)
        if (result['status'] == 'success') {
          toast.success('Book Deleted!')
          navigate('/book')
        } else {
          toast.error(result['error'])
        }
      })
    }

    function editBook(bookId)
    {
      sessionStorage['bid'] = bookId      
      navigate('/updateBook')

    }

    return(
        <tr key={list.bookId}>
            <td>{list.bookId}</td>
            <td>{list.bookName}</td>
            <td>{list.isbn}</td>
            <td>{list.firstName}</td>
            <td>{list.lastName}</td>
            <td>{list.category}</td>
            <td>{list.quantity}</td>
            <td>{list.availableQuantity}</td>

            <td>
            <button onClick={() => deleteBook(list.bookId)} 
            type="button" class="btn btn-outline-danger">Delete</button> 
            </td>

            <td>
            <button onClick={() => editBook(list.bookId)} 
            type="button" class="btn btn-outline-primary">Update</button> 
            </td>
            
        </tr>
    )
}

export default GetBook