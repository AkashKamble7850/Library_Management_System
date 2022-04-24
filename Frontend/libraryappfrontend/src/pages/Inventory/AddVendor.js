
import { Link } from 'react-router-dom'
import { useState } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const AddVendor = () => {
    // const [staffId, setStaffId] = useState('')
    // vendorId | vendorName | vendorAddress | vendorContact | categoryId
    const [vendorName, setVendorName] = useState('')
    const [vendorAddress, setVendorAddress] = useState('')
    const [vendorContact, setVendorContact] = useState('')
    const [categoryId, setCategoryId] = useState('')

    // used to navigate from one component to another
    const navigate = useNavigate()

    const add = () => {
        if (vendorName.length == 0) {
          toast.warning('Please enter first name')
        } else if (vendorAddress.length == 0) {
          toast.warning('Please enter last name')
        } else if (vendorContact.length == 0) {
          toast.warning('Please enter email')
        } else {
            const body = {
                vendorName,
                vendorAddress,
                vendorContact
            }
    
        // url to call the api
        const url = `${URL}/vendor/add/${categoryId}`
        console.log(url)
    
        // http method: post
        // body: contains the data to be sent to the API
        
        axios.post(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Vendor Added Successfully!')
    
              // navigate to the signin page
              navigate('/vendor')
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
                    <h3>ADD VENDOR</h3>
                    <hr/>
                    <div className="row">
                        <div className="col">
                        <div className="form">
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Vendor Name
                        </label>
                        <input onChange={(e) => {
                                setVendorName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Vendor Address
                        </label>
                        <input onChange={(e) => {
                                setVendorAddress(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Vendor Contact
                        </label>
                        <input onChange={(e) => {
                                setVendorContact(e.target.value)
                            }} type="number" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Category Id
                        </label>
                        <input onChange={(e) => {
                                setCategoryId(e.target.value)
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

export default AddVendor













// import React, { Component } from "react";
// import VendorService from "../pages/VendorService";

// class AddVendor extends Component
// {
//     constructor(props)
//     {
//         super(props)
//         this.state =
//         {
//             vendorName: '',
//             vendorAddress: '',
//             vendorContact: '',
//             categoryId: ''
//         }

//         this.changeVendorNameHandler = this.changeVendorNameHandler.bind(this);
//         this.changeVendorAddressHandler = this.changeVendorAddressHandler.bind(this);
//         this.saveVendor = this.saveVendor.bind(this);

//     }

//     saveVendor = (e) => {
//         e.preventDefault();
//         let vendor = {vendorName: this.state.vendorName, vendorAddress: this.state.vendorAddress, 
//                         vendorContact: this.state.vendorContact};
//         console.log('vendor => '+JSON.stringify(vendor));

//         VendorService.createVendor(vendor).then(res => {
//             this.props.history.push('/vendor');
//         })
//     }

//     changeVendorNameHandler = (event) => {
//         this.setState({vendorName: event.target.value});
//     }
//     changeVendorAddressHandler = (event) => {
//         this.setState({vendorAddress: event.target.value});
//     }
//     changeVendorContactHandler = (event) => {
//         this.setState({vendorContact: event.target.value});
//     }
//     cancel(){
//         this.props.history.push('/vendor');
//     }


//     render()
//     {
//         return( 
//         <div>
//             <div className="container">
//                 <div className="row">
//                     <div className="card col-md-6 offset-md-3 offset-md-3">
//                         <h3 className="text-center">Add Vendor</h3>
//                             <div className="card-body">
//                                 <form>
//                                     <div className="form-group">
//                                         <label>Vendor Name</label>
//                                         <input placeholder="Vendor Name" name="vendorName" className="form-control"
//                                         value={this.state.vendorName} onChange={this.changeVendorNameHandler}/>
//                                     </div>
//                                     <div className="form-group">
//                                         <label>Vendor Address</label>
//                                         <input placeholder="Vendor Address" name="vendorAddress" className="form-control"
//                                         value={this.state.vendorAddress} onChange={this.changeVendorAddressHandler}/>
//                                     </div>
//                                     <div className="form-group">
//                                         <label>Vendor Contact</label>
//                                         <input placeholder="Vendor Contact" name="vendorContact" className="form-control"
//                                         value={this.state.vendorContact} onChange={this.changeVendorContactHandler}/>
//                                     </div>
//                                     <button className="btn btn-success" onClick={this.saveVendor}>Save</button>
//                                     <button className="btn btn-danger" onClick={this.changeVendorContactHandler.bind(this)} 
//                                             style={{marginLeft:"10px"}}>Cancel</button>
//                                 </form>
//                             </div>
//                     </div>
//                 </div>
//             </div>

//         </div>
//         )
//     }
// }

// export default AddVendor