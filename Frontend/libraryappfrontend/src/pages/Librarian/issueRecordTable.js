import React from 'react';
import axios from 'axios';
import { useEffect, useState } from 'react'
import Record from './../../components/Librarian/record'
import LibrarianDashboard from './../../components/Librarian/librarianDashboard'
import {URL} from './../../config'
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import Footer from './../../components/Librarian/footer'


const IssueRecordTable = () => {

    const [books, setBooks] = useState([])

     useEffect(() => {
       axios.get(`${URL}/issueBooks/viewIssueBookRequest`).then(Response => setBooks(Response.data.data))
      }, [])

    
    
    return (

<div id="#App">
<div className='col-3'>
            <LibrarianDashboard></LibrarianDashboard>
</div>

<div className="col">
          <WelcomeBlock></WelcomeBlock>
        </div>

<br></br>

<div class="container">
  <div class="row">
    <div class="col">
    </div>

    <div class="col-12">
      <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Issue Id</th>
      <th scope="col">Book Id</th>
      <th scope="col">Book Name</th>
      <th scope="col">User Id</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Issue Date</th>
      <th scope="col">Return Date</th>
      <th scope="col">Issue Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    {books.map((book) => {
      return <Record record={book} />
        })}
  </tbody>
 </table>
    </div>

    <div class="col">
    </div>
  </div>
</div>
 <Footer></Footer>
      </div>
    )

    
  }
  
  export default IssueRecordTable