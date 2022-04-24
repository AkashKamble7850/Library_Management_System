import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import GetFine from "./../../components/Librarian/getFine";
import LibrarianDashboard from './../../components/Librarian/librarianDashboard'
import {URL} from './../../config'
import WelcomeBlock from './../../components/Librarian/WelcomeBlock'
import Footer from './../../components/Librarian/footer'

const FineTable = () => {
  const [bookList, setBookList] = useState([]);
  const [urll, setUrll] = useState(`${URL}/issueBooks/checkFineByBookId`);
  const [parameter, setParameter] = useState("");

  useEffect(() => {
    axios
      .get(`${URL}/issueBooks/checkFine`)
      .then((Response) => setBookList(Response.data.data));
      console.log(bookList)
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
                          `${URL}/issueBooks/checkFineByBookId`
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
                          `${URL}/issueBooks/checkFineByUserId`
                        );
                      }}
                      className="dropdown-item"
                    >
                      By User Id
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
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Issue Date</th>
              <th scope="col">Due Date</th>
              <th scope="col">Return Date</th>
              <th scope="col">Fine</th>
            </tr>
          </thead>
          <tbody>
            {bookList.map((book) => {
              return <GetFine list={book} />;
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

export default FineTable
