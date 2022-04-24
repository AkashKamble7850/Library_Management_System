import React from 'react';
import axios from 'axios';
import { useEffect, useState } from 'react'
import GetAuthor from '../../components/Inventory/getAuthor'
import '../../components/Inventory/IMDashboard.css'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import { URL } from '../../config'

const AuthorTable = () => {

    const [authorList, setAuthorList] = useState([])

     useEffect(() => {
       axios.get(`${URL}/author`).then(Response => setAuthorList(Response.data.data))
      }, [])

      console.log(authorList)

    
    return (
      <div id="#App">
      <div className='col-3'>
          <IMDashboard></IMDashboard>
      </div>

          <div class="col">
            <div className="col">
              <WelcomeBlock></WelcomeBlock>
            </div>
            </div>
    <br></br>

    <div class="container">
  <div class="row">
    <div class="col">
    </div>

    <div class="col-12">

<div>
        <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Author Id</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
    </tr>
  </thead>
  <tbody>
    {authorList.map((author) => {
      return <GetAuthor list={author} />
        })}
  </tbody>
 </table>
      </div>
      </div>
      </div>

<div class="col">
</div>
</div>
</div>
    )

    
  }
  
  export default AuthorTable