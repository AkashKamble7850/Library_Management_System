import { Link } from 'react-router-dom'
import { useState, useEffect } from "react";
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import axios from "axios";
import { useNavigate, useLocation } from 'react-router'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'
import { URL } from '../../config'

const UpdateBook = () => {

    //|bookId|isbn|bookName|bookDescription|categoryId|authorId|quantity|language|published|
    const [bookId, setBookId] = useState('')
    const [isbn, setIsbn] = useState('')
    const [bookName, setBookName] = useState('')
    const [bookDescription, setBookDescription] = useState('')
    const [categoryName, setCategoryName] = useState('')
    const [aFirstName, setAFirstName] = useState('')
    const [aLastName, setALastName] = useState('')
    const [quantity, setQuantity] = useState('')
    const [language, setLanguage] = useState('')
    const [published, setPublished] = useState('')  

    const currentBookId = sessionStorage['bid']
    const { state } = useLocation()
    
    // used to navigate from one component to another
    const navigate = useNavigate()

    useEffect(() => {
        setBookId(bookId)
        setIsbn(isbn) 
        setBookName(bookName)
        setBookDescription(bookDescription) 
        setCategoryName(bookId.categoryName)
        setAFirstName(bookId.aFirstName)
        setALastName(bookId.aLastName)
        setQuantity(quantity)
        setLanguage(language)
        setPublished(published)
        
        console.log(state)
      },[])

    const update = () => {
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
            console.log(body)
        // url to call the api
        const url = `${URL}/books/update/${currentBookId}`
    
        // http method: post
        // body: contains the data to be sent to the API
        axios.put(url, body).then((response) => {
            // get the data from the response
            const result = response.data
            console.log(result)
            if (result['status'] == 'success') {
              toast.success('Book is Updated Successfully!')
    
              // navigate to the signin page
              navigate('/book')
            } else {
              toast.error(result['error'])
            }
          })
        }
    }

    
    return (
        <div id="#App" class="row">    
            <div className='col-3'>
                <IMDashboard></IMDashboard>
            </div>
            
                <div className="col">
                <div className="col">
                    <WelcomeBlock></WelcomeBlock>
                </div>

                    <div></div>
                    <div >
                    <h3>Update Book</h3>
                    <hr/>

                    <div className="form">
                    <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Book Id</label>
                    <input type="number" id="disabledTextInput" class="form-control" placeholder={currentBookId} />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            ISBN
                        </label>
                        <input value = {isbn}
                        onChange={(e) => {
                                setIsbn(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Book Name
                        </label>
                        <input value = {bookName} 
                        onChange={(e) => {
                                setBookName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Book Description
                        </label>
                        <input value = {bookDescription} 
                        onChange={(e) => {
                                setBookDescription(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Category
                        </label>
                        <input value = {categoryName}
                        onChange={(e) => {
                                setCategoryName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>
                    </div>


                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            A FirstName
                        </label>
                        <input value = {aFirstName}
                        onChange={(e) => {
                                setAFirstName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            A LastName
                        </label>
                        <input value = {aLastName}
                        onChange={(e) => {
                                setALastName(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Quantity
                        </label>
                        <input value = {quantity}
                        onChange={(e) => {
                                setQuantity(e.target.value)
                            }} type="number" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Language
                        </label>
                        <input value = {language}
                        onChange={(e) => {
                                setLanguage(e.target.value)
                            }} type="text" className="form-control" />
                    </div>
                    </div>

                    <div className="form">
                    <div className="mp-3">
                        <label htmlFor="" className="label-control">
                            Published
                        </label>
                        <input value = {published}
                        onChange={(e) => {
                                setPublished(e.target.value)
                            }} type="number" className="form-control" />
                    </div>
                    </div>

                    <br/>
                    
                    <div className="mb-3">
                    <button onClick={update} className="btn btn-primary">
                        Update Book
                    </button>
                    </div>    
                        </div>
                    </div>

    ) 
}

export default UpdateBook