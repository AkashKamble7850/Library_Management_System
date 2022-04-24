import React from 'react';
import axios from 'axios';
import { useEffect, useState } from 'react'
import GetCategory from '../../components/Inventory/getCategory'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const CategoryTable = () => {

    const [categoryList, setCategoryList] = useState([])

     useEffect(() => {
       axios.get(`${URL}/category`).then(Response => setCategoryList(Response.data.data))
      }, [])

      console.log(categoryList)

    
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
      <th scope="col">Category Id</th>
      <th scope="col">Category Name</th>
      {/* <th scope="col">Vendor Name</th> */}
    </tr>
  </thead>
  <tbody>
    {categoryList.map((category) => {
      return <GetCategory list={category} />
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
  
  export default CategoryTable