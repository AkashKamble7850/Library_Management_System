
import { Link } from 'react-router-dom'
import { useState } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const AddOrder = () => {
    // const [staffId, setStaffId] = useState('')
    // orderId | bookName  | aFirstName | quantity | language | vendorId
    const [bookName, setBookName] = useState('')
    const [aFirstName, setAFirstName] = useState('')
    const [quantity, setQuantity] = useState('')
    const [language, setLanguage] = useState('')
    const [vendorId, setVendorId] = useState('')

    // used to navigate from one component to another
    const navigate = useNavigate()

    const add = () => {
        if (bookName.length == 0) {
          toast.warning('Please enter book name')
        } else if (aFirstName.length == 0) {
          toast.warning('Please enter author name')
        } else {
            const body = {
                bookName,
                aFirstName,
                quantity,
                language
            }
    
        // url to call the api
        const url = `${URL}/orders/add/${vendorId}`
        console.log(url)
    
        // http method: post
        // body: contains the data to be sent to the API
        
        axios.post(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Order Added Successfully!')
    
              // navigate to the signin page
              navigate('/orders')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }

    
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

    <div className="container-fluid">
            <div className="row">
                <div className="col-4"></div>
                <div className="col-8">
                    <div className="row"></div>
                    <div className="row">
                    <h3>ORDER BOOK</h3>
                    <hr/>
                    <div className="row">
                        <div className="col">
                        <div className="form">
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Book Name
                        </label>
                        <input onChange={(e) => {
                                setBookName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Author First Name
                        </label>
                        <input onChange={(e) => {
                                setAFirstName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Quantity
                        </label>
                        <input onChange={(e) => {
                                setQuantity(e.target.value)
                            }} type="number" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Language
                        </label>
                        <input onChange={(e) => {
                                setLanguage(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Vendor Id
                        </label>
                        <input onChange={(e) => {
                                setVendorId(e.target.value)
                            }} type="number" className="form-control" />
                    </div>
                    </div>

                        </div>
                        <div className="col">

                            <br/>

                        </div>

                        <div className="mb-3">
                        <br/>

                    <button onClick={add} className="btn btn-primary">
                        Save
                    </button>
                    </div>    

                    </div>
                    </div>
                </div>
            </div>             
        </div>    
        </div>    

    ) 
}

export default AddOrder
