import { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { URL } from './../../config'
import UserDashboard from './../../components/user/UserDashboard'
import '../../components/user/dashboard.css'
import WelcomeBlock from './../../components/user/WelcomeBlock'
import GetFineDetails from '../../components/user/GetAndPayFine';

const FineDetails = () => {
  const { state } = useLocation()
  const [ fine, setFine ] = useState([])
  const currentUserId = sessionStorage['id']
  console.log(currentUserId)
  const navigate = useNavigate()
  const [ parameter, setParameter ] = useState('') 

  const loadFineDetails = () => {
    // const { id } = state
    const url = `${URL}/issueBooks/checkFineByUserId/${currentUserId}`
    console.log(url)
    axios.get(url).then((response) => {
    const result = response.data.data
    console.log(result)
    setFine(result)
    console.log(fine)
    }, [])
  }

  useEffect(() => {
    loadFineDetails()
  }, [])

  
  return (
    <div id="#App" className='row'>
        <div className='col-3'>
            <UserDashboard></UserDashboard>
        </div>
        <div className="col" >
        <div className="col">
            <WelcomeBlock></WelcomeBlock>
        </div>
        <div class="container">
  <div class="row">
    <div class="col">
    </div>

    <div class="col-12">

          <h1 className="title">Fine Details</h1>
          <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Issue Book Id</th>
                    <th scope="col">Book Name</th>
                    <th scope="col">Issue Date</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Return Date</th>
                    <th scope="col">Fine</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                { fine.map((fines) => {
                    return <GetFineDetails details={ fines } />
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
export default FineDetails
