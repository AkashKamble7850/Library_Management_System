import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import GetBook from "./../../components/Inventory/getBook";
import {URL} from './../../config'
import IMDashboard from './../../components/Inventory/IMDashboard';
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import '../../components/Inventory/IMDashboard.css'

const BooksTable = () => {
  const [bookList, setBookList] = useState([]);
  const [urll, setUrll] = useState(`${URL}/books/bookId`);
  const [parameter, setParameter] = useState("");

  useEffect(() => {
    axios
      .get(`${URL}/books/all`)
      .then((Response) => setBookList(Response.data.data))
      console.log(bookList)
  }, []);

  const search = () => {
    const url = `${urll}/${parameter}`;
    console.log(url);
    if (parameter.length === 0) {
      toast.warning("please enter value to search");
    } //else{
    axios.get(url).then((Response) => setBookList(Response.data.data));

   
  };

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


      <div class="container">
        <div class="row">
          <div class="col"></div>
          <div class="col-6">
            <div>
              <div className="input-group">
                <input
                  onChange={(e) => {
                    setParameter(e.target.value);
                  }}
                  type="text"
                  className="form-control"
                  aria-label="Text input with segmented dropdown button"
                ></input>
                <button
                  onClick={search}
                  type="button"
                  className="btn btn-outline-secondary"
                >
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
                    <button
                      onClick={() => {
                        setUrll(
                          `${URL}/books/bookId`
                        );
                      }}
                      className="dropdown-item"
                    >
                      By book Id
                    </button>
                  </li>
                  <li>
                    <button
                      onClick={() => {
                        setUrll(
                          `${URL}/books/bookName`
                        );
                      }}
                      className="dropdown-item"
                    >
                      By Book Name
                    </button>
                  </li>
                  <li>
                    <button
                      onClick={() => {
                        setUrll(
                          `${URL}/books/authorName`
                        );
                      }}
                      className="dropdown-item"
                    >
                      By Author
                    </button>
                  </li>
                  <li>
                    <button
                      onClick={() => {
                        setUrll(
                          `${URL}/books/category`
                        );
                      }}
                      className="dropdown-item"
                    >
                      By Category
                    </button>
                  </li>
                  <li>
                    <button
                      onClick={() => {
                        setUrll(
                          `${URL}/books/isbn`
                        );
                      }}
                      className="dropdown-item"
                    >
                      By Isbn
                    </button>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col"></div>
        </div>
      </div>

      <br></br>
      
      <div>
        <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">Book Id</th>
              <th scope="col">Book Name</th>
              <th scope="col">Isbn</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Category</th>
              <th scope="col">Quantity</th>
              <th scope="col">Available Quantity</th>
            </tr>
          </thead>
          <tbody>
            {bookList.map((book) => {
              return <GetBook list={book} />;
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

  );
};

export default BooksTable;
{/* <div class="container">
  <div class="row">
    <div class="col">
    </div>

    <div class="col-12">
      ##Place Your Code Here where you want to place in centre##
    </div>

    <div class="col">
    </div>
  </div>
</div> */}