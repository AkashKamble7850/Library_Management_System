import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import GetBook from './../../components/Librarian/getBook'
import { toast } from "react-toastify";
import LibrarianDashboard from './../../components/Librarian/librarianDashboard'
import {URL} from './../../config'
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import Footer from './../../components/Librarian/footer'

const BookTable = () => {
  const [bookList, setBookList] = useState([]);
  const [urll, setUrll] = useState(`${URL}/books/bookId`);
  const [parameter, setParameter] = useState("");

  useEffect(() => {
    axios
      .get(`${URL}/books/all`)
      .then((Response) => setBookList(Response.data.data));
  }, []);

  const search = () => {
    const url = `${urll}/${parameter}`;
    console.log(url);
    if (parameter.length === 0) {
      toast.warning("please enter value to search");
    } //else{
    axios.get(url).then((Response) => setBookList(Response.data.data));

    console.log(bookList);
  };

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

    <div class="col">
    </div>
  </div>
</div>
      <Footer></Footer>
    </div>
  );
};

export default BookTable;
