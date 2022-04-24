import React from 'react';
import axios from 'axios';
import { useEffect, useState } from 'react'
import GetOrder from '../../components/Inventory/getOrder'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const OrderTable = () => {

    const [orderList, setOrderList] = useState([])

     useEffect(() => {
       axios.get(`${URL}/orders`).then(Response => setOrderList(Response.data.data))
      }, [])

      console.log(orderList)

    
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
      <th scope="col">Order Id</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Language</th>
      <th scope="col">Vendor Name</th>
    </tr>
  </thead>
  <tbody>
    {orderList.map((order) => {
      return <GetOrder list={order} />
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
  
  export default OrderTable