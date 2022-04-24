import React from 'react';
import axios from 'axios';
import { useEffect, useState } from 'react'
import GetVendor from './../../components/Inventory/getVendor'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const VendorTable = () => {

    const [vendorList, setVendorList] = useState([])

     useEffect(() => {
       axios.get(`${URL}/vendor`).then(Response => setVendorList(Response.data.data))
      }, [])

      console.log(vendorList)

    
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
      <th scope="col">Vendor Id</th>
      <th scope="col">Vendor Name</th>
      <th scope="col">Vendor Address</th>
      <th scope="col">Vendor Contact</th>
      <th scope="col">Category</th>
      {/* <th scope="col">Vendor Name</th> */}
    </tr>
  </thead>
  <tbody>
    {vendorList.map((vendor) => {
      return <GetVendor list={vendor} />
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
  
  export default VendorTable