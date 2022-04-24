import react from "react";
import axios from "axios";
import { toast } from 'react-toastify';
import { useNavigate  } from 'react-router'
import './editStaff'
import { URL } from '../../../config'

const GetStaff = (props) => {
    const { list } = props
    const navigate = useNavigate()

    function salaryStatus(staffId){
        const url = `${URL}/staff/salary/${staffId}`
          axios.put(url).then((response) => {
            const result = response.data
            if (result['status'] == 'success') {
              if(response.data = "1")
                  toast.success('salary send successfully')
              
            } else {
              toast.error(result['error'])
            }
          })
    }

    const editStaff = () => {
      <editStaff/>
      navigate('/editStaff')
  }

  function deleteStaff(staffId){
    const url =`${URL}/staff/${staffId}`
    // const text = document.getStaffBystaffId
      axios.delete(url).then((response) => {
        const result = response.data 
        console.log(result)
        if (result['status'] == 'success') {
          if(response.data == '1')
            toast.success('Staff Deleted Successfully!')

          // navigate to the signin page
          navigate('/admin/StaffDetails')
        } else {
          toast.error(result['error'])
        }
      })
}

// function myFunction() {
//   // Get the checkbox
//   var checkBox = document.getElementById("myCheck");
//   // Get the output text
//   var text = document.getElementById("text");

//   // If the checkbox is checked, display the output text
//   if (checkBox.checked == true){
//     text.style.display = "block";
//   } else {
//     text.style.display = "none";
//   }
// }

    return (
        
        <tr>
            <td>{list.staffId}</td>
            <td>{list.firstName}</td>
            <td>{list.lastName}</td>
            <td>{list.role}</td>
            <td>{list.email}</td>
            {/* <td>
                
                {/* <button onClick={()=>salaryStatus(list.staffId)} type="button" class="btn btn-lg btn-primary btn-sm">Send</button> 
                {/* <label class="switch" >
                  <input onClick={()=>salaryStatus(list.staffId)} type="checkbox"/>
                  <span  class="slider round" ></span>
                </label> 
                

            </td> */}
            <td>
              <button onClick={editStaff} type="button" class="btn btn-lg btn-warning btn-sm">Edit</button>
            </td>
            <td>
            <button onClick={()=>deleteStaff(list.staffId)} type="button" class="btn btn-lg btn-danger btn-sm">Delete</button>
            </td>
        </tr>
             
    )
        

   
}

export default GetStaff
