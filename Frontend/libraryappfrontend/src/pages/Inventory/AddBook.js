
import { Link } from 'react-router-dom'
import { useState } from "react";
import { toast } from 'react-toastify';
import axios from "axios";
import { useNavigate } from 'react-router'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const AddBook = () => {
    // const [staffId, setStaffId] = useState('')
    //bookId|isbn| bookName|bookDescription|categoryId|authorId|quantity|language|availableBooks|issuedBooks|published|deprecatedStatus|
    const [isbn, setIsbn] = useState('')
    const [bookName, setBookName] = useState('')
    const [bookDescription, setBookDescription] = useState('')
    const [categoryName, setCategoryName] = useState('')
    const [aFirstName, setAFirstName] = useState('')
    const [aLastName, setALastName] = useState('')
    const [quantity, setQuantity] = useState('')
    const [language, setLanguage] = useState('')
    const [published, setPublished] = useState('')

    // used to navigate from one component to another
    const navigate = useNavigate()

    const add = () => {
        if (isbn.length == 0) {
          toast.warning('Please enter isbn')
        } else if (bookName.length == 0) {
          toast.warning('Please enter book name')
        } else {
            const body = {
                isbn,
                bookName,
                bookDescription,
                categoryName,
                aFirstName,
                aLastName,
                quantity,
                language,
                published
            }
    
        // url to call the api
        const url = `${URL}/books/add`
        console.log(url)
    
        // http method: post
        // body: contains the data to be sent to the API
        
        axios.post(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Book Added Successfully!')
    
              // navigate to the signin page
              navigate('/book')
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
                    <h3>ADD BOOK</h3>
                    <hr/>
                    <div className="row">
                        <div className="col">
                        <div className="form">
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            ISBN
                        </label>
                        <input onChange={(e) => {
                                setIsbn(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
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
                            Book Description
                        </label>
                        <input onChange={(e) => {
                                setBookDescription(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Category Name
                        </label>
                        <input onChange={(e) => {
                                setCategoryName(e.target.value)
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
                            Author Last Name
                        </label>
                        <input onChange={(e) => {
                                setALastName(e.target.value)
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
                            Published
                        </label>
                        <input onChange={(e) => {
                                setPublished(e.target.value)
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

export default AddBook
