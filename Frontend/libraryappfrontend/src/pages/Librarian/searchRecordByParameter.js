import axios from 'axios'
import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import {URL} from './../../config'




const SearchRecordByParameter = () => {

  const [urll, setUrll] = useState(`${URL}/issueBooks/viewRecordByBookId`)
  const [parameter, setParameter]=useState('')
  const [books, setBooks] = useState([])

  
  const search = () => {
    const url = `${urll}/${parameter}`
    console.log(url)
    if(parameter.length === 0){
      toast.warning('please enter value to search')
    }else{
      axios.get(url).then((response) =>{
        const result = response.data
        if(result['status'] == 'success'){
          setBooks(result.data)
        }else{
          toast.error('error')
        }
      })
    }
  }

  
    return (
      <div id="#App" class="container">
      
        

        <br></br>
        <br></br>

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
    )
  }


  
  export default SearchRecordByParameter
  