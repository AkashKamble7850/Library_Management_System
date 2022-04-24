import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { URL } from '../../config'
import UserDashboard from './../../components/user/UserDashboard'
import '../../components/user/dashboard.css'
import WelcomeBlock from './../../components/user/WelcomeBlock'
import RequestIssue from './../../components/user/SearchAndRequest'

const BookRequest = () => {

  const [urll, setUrll] = useState(`${URL}/books`)
  const [parameter, setParameter]=useState('')
  const [books, setBooks] = useState([])
  const currentUserId = sessionStorage['id']
  const navigate = useNavigate()
  const [userId, setUserId] = useState('')

  useEffect(() => {
    axios
      .get(`${URL}/books/all`)
      .then((Response) => setBooks(Response.data.data));
  }, []);  
  
    const search = () => {
    const url = `${urll}/${parameter}`
    console.log(url)
   
    if(parameter.length === 0){
      toast.warning('please enter value to search')
    }
    else{
      axios.get(url).then((response) =>{
        const result = response.data
        if(result['status'] == 'success'){
          setBooks(result.data)
          console.log(books)
        }
        else{
          toast.error('error')
        }
      })
    }
  }
   

  
    return (
      <div id="#App" className="row">
            <div className='col-3'>
                <UserDashboard></UserDashboard>
            </div>
            
            <div class="col">
              <div className="col">
                <WelcomeBlock></WelcomeBlock>
              </div>

              <div class="container">
                    <div class="row">
                        <div class="col">
                        </div>

                        <div class="col-12">
                          <br />
                          <br />
                <div className="input-group">
                    <input onChange={(e) => {
                        setParameter(e.target.value)
                    }}
                type="text"
                className="form-control"
                aria-label="Text input with segmented dropdown button"
            ></input>
          
            <button onClick={search} type="button" className="btn btn-outline-secondary">
            Search
            </button>
          
            <button
            type="button"
            className="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
            data-bs-toggle="dropdown"
            aria-expanded="false"
            >
            <span className="visually-hidden">Toggle Dropdown</span>
            </button>
          
            <ul className="dropdown-menu dropdown-menu-end">
                <li>
                    <button onClick={() => {
                        setUrll(`${URL}/books/category`)
                        }} className="dropdown-item" >
                        By book category
                    </button>
                </li>
            
                <li>
                    <button onClick={() => {
                        setUrll(`${URL}/books/bookName`)
                        }} className="dropdown-item">
                        By Book Name
                    </button>
                </li>
            
                <li>
                    <button onClick={() => {
                    setUrll(`${URL}/books/authorName`)
                    }} className="dropdown-item">
                    By Author Name
                    </button>
                </li>
            </ul>
            </div>
            <br />
        <br />
        <br />
            <h1 className="title">Book Details</h1>
          <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Book Name</th>
                    <th scope="col">Book Id</th>
                    <th scope="col">Isbn</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                {books.map((book) => {
                    return <RequestIssue record={book} />
                    })
                }
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
  
export default BookRequest
  