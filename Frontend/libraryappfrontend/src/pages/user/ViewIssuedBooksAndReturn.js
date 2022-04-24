import { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
import { URL } from './../../config'
import UserDashboard from './../../components/user/UserDashboard'
import '../../components/user/dashboard.css'
import WelcomeBlock from './../../components/user/WelcomeBlock'
import Return from '../../components/user/IssuedBookAndReturn';

const IssuedBookReturn = (props) => {
  const { state } = useLocation()
  const [ issueBooks, setIssueBooks ] = useState([])
  const currentUserId = sessionStorage['id']
  console.log(currentUserId)
  const navigate = useNavigate()
  const [ parameter, setParameter ] = useState('') 

  const loadBookDetails = () => {
    // const { id } = state
    const url = `${URL}/issueBooks/viewRecordByUserId/${currentUserId}`
    axios.get(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setIssueBooks(result.data)
        console.log(issueBooks)
      }
      else{
        toast.error('error')
      }
    })
  }

  useEffect(() => {
    loadBookDetails()
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

          <h1 className="title">Issued Book Details</h1>
          <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Issue Book Id</th>
                    <th scope="col">Book Id</th>
                    <th scope="col">Issue Date</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Issue Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                {issueBooks.map((issueBook) => {
                    return <Return list={ issueBook } />
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
export default IssuedBookReturn
