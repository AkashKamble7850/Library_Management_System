import react from 'react';
import axios from 'axios';
import { useEffect, useState} from 'react'
import GetUser from '../../../components/GetUser'
import GetFeedback from '../../../components/GetFeedback'
import { URL } from '../../../config'

const UserDetails = () => {
    const [list, setList] = useState([])
    const [feedback, setFeedback] = useState([])
    
    useEffect(() => {
        axios.get(`${URL}/admin/getusers`)
        .then(Response => setList(Response.data.data))
    }, [])

    useEffect(() => {
        axios.get(`${URL}/admin/getfeed`)
        .then(Response => setFeedback(Response.data.data))
    }, [])

    console.log(list)

    return (
        <div>
            <h4>List of users</h4>
        {/* <table class= "table table-striped"> */}
        <table class= "table table-bordered border-primary">
            <thead class="table-dark">
                <tr>
                    <th scope='col'>First Name</th>
                    <th scope='col'>Last Name</th>
                    <th scope='col'>Email</th>
                    <th scope='col'>Membership Plan</th>
                    <th scope='col'>Approval from admin</th>
                </tr>
            </thead>
            <tbody>
                {list.map((user) => {
                    return <GetUser list={user} />
                })}
            </tbody>
        </table>

        <hr/>

        <h4> Feedback From User </h4>
        <table class= "table table-bordered border-primary">
            <thead class="table-dark">
                <tr>
                    <th scope='col'>User Id</th>
                    <th scope='col'>Feedback</th>
                </tr>
            </thead>
            <tbody>
                {feedback.map((feedback) => {
                    return <GetFeedback list={feedback} />
                })}
            </tbody>
        </table>
        </div>
    )
}

export default UserDetails