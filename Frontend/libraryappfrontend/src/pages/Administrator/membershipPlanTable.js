import axios from 'axios';
import { useEffect, useState} from 'react'
import { useNavigate  } from 'react-router'
import GetPlan from '../../components/Administrator/Plan/GetPlan'
import addPlan from '../../components/Administrator/Plan/addPlan';
import Dashboard from '../../components/Administrator/Dashboard';
import WelcomeBlock from '../../components/Administrator/WelcomeBlock';
import { URL } from '../../config';

const PlanDetails = () => {
    const [list, setList] = useState([])
    const navigate = useNavigate()
    
    useEffect(() => {
        axios.get(`${URL}/admin/getplans`)
        .then(Response => setList(Response.data.data))
    })

    console.log(list)

    const addPlan = () => {
        <addPlan/>
        navigate('/addPlan')
    }

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
            
            <div className='container'>
            <br/><br/><br/><br/>
            <h1>Membership Plan</h1>
            <div class = "float-end">
            <button onClick={addPlan} type="button" class="btn btn-lg btn-light"> + Add Plan</button>
            </div>
            
        <table class= "table table-striped table-bordered border-primary">
            <thead>
                <tr>
                    <th scope='col'>Plan Id</th>
                    <th scope='col'>Plan Name</th>
                    <th scope='col'>Rate</th>
                    {/* <th scope='col'>Active user</th> */}
                    {/* <th scope='col'>Edit Plan</th> */}
                    <th scope='col'>Delete Plan</th>

                </tr>
            </thead>
            <tbody>
                {list.map((plan) => {
                    return <GetPlan list={plan} />
                })}
            </tbody>
        </table>
        </div>
        </div>
    )
}

export default PlanDetails