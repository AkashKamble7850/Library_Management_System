import react from 'react';
import axios from 'axios';
import { useEffect, useState} from 'react'
import GetStaff from '../../components/Administrator/Staff/GetStaff'
import { useNavigate } from 'react-router'
import Dashboard from '../../components/Administrator/Dashboard';
import WelcomeBlock from '../../components/Administrator/WelcomeBlock';
import { URL } from '../../config';

const StaffDetails = () => {
    const [list, setList] = useState([])
    const navigate = useNavigate()
    
    useEffect(() => {
        axios.get(`${URL}/staff`)
        .then(Response => setList(Response.data.data))
    }, [])

    const addStaff = () => {
        <addStaff/>
        navigate('/addStaff')
    }

    console.log(list)

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
            
            <br/><br/><br/><br/>
            <div className='container'>
            <h1 >Staff Details</h1>
        <table class= "table table-striped table table-bordered border-primary">
        
            <thead>
                <tr>
                    <th scope='col'>Staff Id</th>
                    <th scope='col'>First Name</th>
                    <th scope='col'>Last Name</th>
                    <th scope='col'>Role</th>
                    <th scope='col'>Email</th>
                    {/* <th scope='col'>Salary Status</th> */}
                    <th scope='col'colSpan={2}>
                    <button onClick={addStaff} type="button" class="btn btn-lg btn-primary btn-sm"> + Add Staff</button>
                    </th>
                    {/* <th scope='col'>Delete</th> */}

                </tr>
            </thead>
            <tbody>
                {list.map((staff) => {
                    return <GetStaff list={staff} />
                })}
            </tbody>
        </table>
        </div>
        </div>
    )
}

export default StaffDetails