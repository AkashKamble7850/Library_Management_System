import axios from "axios"
import { useEffect, useState } from 'react'
import Dashboard from "../../../components/Administrator/Dashboard"
import WelcomeBlock from "../../../components/Administrator/WelcomeBlock"
import Graph from "../../../components/Administrator/Graph"
import { URL } from "../../../config"
import './index.css'

const StaffDashboard = () => {
    const [books, setBooks] = useState(0)
    const [users, setUsers] = useState(0)
    const [issuedBooks, setIssuedBooks] = useState(0)
    const [defaulterBooks, setDefaulterBooks] = useState(0)

    useEffect(() => {
      axios.get(`${URL}/books`).then(Response => setBooks(Response.data.data))

      axios.get(`${URL}/books/countActiveUsers`).then(Response => setUsers(Response.data.data))

      axios.get(`${URL}/issueBooks`).then(Response => setIssuedBooks(Response.data.data))

      axios.get(`${URL}/issueBooks/defaulterBook`).then(Response => setDefaulterBooks(Response.data.data))
     })
    

    return (
        <div> 
            <div id="#App">
                <div className='col-3'>
                    <Dashboard/>
                </div>
            </div>

            <div className="col">
            <WelcomeBlock/>
            </div>
        
        <br></br>
        <br></br>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                    <div class="col-12">
                        <div>
                        <div className="row">
                            <div className="col">
                                <div className="yellow">
                                <div className="text">Users</div>
                                <h1 class="display-2"><strong>{users}</strong></h1>
                                </div>
                            </div>
                            <div className="col">
                                <div className="blue">
                                <div className="text">Books</div>
                                <h1 class="display-2"><strong>{books}</strong></h1>
                                </div>
                            </div>
                            <div className="col">
                                <div className="grey">
                                <div className="text">Issued Books</div>
                                <h1 class="display-2"><strong>{issuedBooks}</strong></h1>
                                </div>
                            </div>
                            <div className="col">
                                <div className="grey">
                                <div className="text">Defaulter Book</div>
                                <h1 class="display-2"><strong>{defaulterBooks}</strong></h1>
                                </div>
                            </div>
                        </div>
                            </div>
                                <Graph/>
                            </div>

                    <div class="col">
                </div>
            </div>
        </div>
    </div>
        )    

} 

export default StaffDashboard
