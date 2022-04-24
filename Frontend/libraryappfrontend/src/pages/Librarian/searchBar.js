import axios from 'axios'
import { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import Record from './../../components/Librarian/record'
import LibrarianDashboard from './../../components/Librarian/librarianDashboard'
import { URL } from '../../config'
import Footer from './../../components/Librarian/footer'
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'

const SearchBar = () => {

  const [books, setBooks] = useState([])

  const [urll, setUrll] = useState(`${URL}/issueBooks/viewRecordByBookId`)
  const [parameter, setParameter]=useState('')

  useEffect(() => {
    axios.get(`${URL}/issueBooks/viewAllIssuedBooksRecord`).then(Response => setBooks(Response.data.data))
   },[])
  
  const search = () => {
    const url = `${urll}/${parameter}`
    console.log(url)
    if(parameter.length === 0){
      toast.warning('please enter value to search')
    }//else{
      axios.get(url).then(Response => setBooks(Response.data.data))
      //axios.get(url).then((response) =>{
        //const result = response.data
      //   if(result['status'] == 'success'){
      //     setBooks(result)
      //     books.map((book) => {
      // return <Record record={book} />
      //   })
      //   }else{
      //     toast.error('error')
      //   }
     // })
 // }

  }


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
    <div class="col-6">
      <div>
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
                  setUrll(`${URL}/issueBooks/viewRecordByBookId`)
                }} className="dropdown-item" >
                By book Id
              </button>
            </li>
            <li>
              <button onClick={() => {
                  setUrll(`${URL}/issueBooks/viewRecordByBookName`)
                }} className="dropdown-item">
                By Book Name
              </button>
            </li>
            <li>
              <button onClick={() => {
                  setUrll(`${URL}/issueBooks/viewRecordByUserId`)
                }} className="dropdown-item">
                By User Id
              </button>
            </li>
            <li>
              <button onClick={() => {
                  setUrll(`${URL}/issueBooks/viewRecordByUserName`)
                }} className="dropdown-item">
                By User Name
              </button>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="col">
      
    </div>
  </div>
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
        {console.log(books)}
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


export default SearchBar