import { BrowserRouter, Route, Routes, Link } from 'react-router-dom'
import 'react-toastify/dist/ReactToastify.min.css';
import { ToastContainer, toast } from 'react-toastify'
// User import
import Signin from './pages/Signin';
import Signup from './pages/SignupUser'
import WriteFeedback from './pages/user/writeFeedback'
import BookRequest from './pages/user/BookRequest'
import IssuedBookReturn from './pages/user/ViewIssuedBooksAndReturn';
import FineDetails from './pages/user/ViewAndPayFine';
import UserProfile from './pages/user/UserProfile';

// Librarian import
import StaffProfile from './components/Librarian/StaffProfile'
import IssueRecordTable from './pages/Librarian/issueRecordTable'
import ReturnRequestTable from './pages/Librarian/returnRequestTable'
import SearchBar from './pages/Librarian/searchBar'
import BookTable from './pages/Librarian/bookTable'
import FineTable from './pages/Librarian/fineTable'
import LibHome from './pages/Librarian/Home/index'

// Inventory import
import OrderTable from './pages/Inventory/OrderTable'
import VendorTable from './pages/Inventory/VendorTable'
import CategoryTable from './pages/Inventory/CategoryTable'
import AuthorTable from './pages/Inventory/AuthorTable'
import BooksTable from './pages/Inventory/BookTable'
import UpdateBook from './pages/Inventory/UpdateBook'
import AddBook from './pages/Inventory/AddBook'
import AddOrder from './pages/Inventory/AddOrder'
import AddVendor from './pages/Inventory/AddVendor'

//Administrator import
import StaffDashboard from './pages/Administrator/Home/index'
import PlanDetails from './pages/Administrator/membershipPlanTable'
import StaffDetails from './pages/Administrator/staffDetails'
import UserDetails from './pages/Administrator/userDetails'
import EditStaff from './components/Administrator/Staff/editStaff';
import AddPlan from './components/Administrator/Plan/addPlan';
import AdminStaffProfile from './components/Administrator/StaffProfile';
import EditPlan from './components/Administrator/Plan/editPlan';
import AddStaff from './components/Administrator/Staff/addStaff';


const AuthorizeUser = () => {
  const loginStatus = sessionStorage['loginStatus']
  if (loginStatus == '0') {
      return <Signin />
    }
}

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
{/* User Routes */}
          <Route path= "/" element= {<Signin />} />
          <Route path= "/signupuser" element= {<Signup />} />
          <Route path="/write-feedback" element={<WriteFeedback />} />
          <Route path='/submit-book-request' element={<BookRequest />} />
          <Route path='/view-issued-books' element={<IssuedBookReturn />} /> 
          <Route path='/fine' element={<FineDetails />} />
          <Route path="/user-profile" element = {<UserProfile/>} />
{/* Librarian Routes */}
          <Route path= "/staffProfile" element={<StaffProfile />} />
          <Route path="/issueRecordTable" element={<IssueRecordTable />} />
          <Route path="/returnRequestTable" element={<ReturnRequestTable />} />
          <Route path="/searchBar" element={<SearchBar />} />
          <Route path="/bookTable" element={<BookTable/>} />
          <Route path="/fineTable" element={<FineTable/>} />
          <Route path="/libHome" element={<LibHome/>} />

{/* Inventory Routes */}
          <Route path="/orders" element={<OrderTable/>} />
          <Route path="/vendor" element={<VendorTable/>} />
          <Route path="/category" element={<CategoryTable/>} />
          <Route path="/author" element={<AuthorTable/>} />
          <Route path="/add-vendor" element={<AddVendor/>} />
          <Route path="/add-book" element={<AddBook/>} />
          <Route path="/add-order" element={<AddOrder/>} />
          <Route path="/book" element={<BooksTable/>} />
          <Route path="/updateBook" element={<UpdateBook/>} />

{/* Administrator Routes */}
<Route path="/adminHome" element={<StaffDashboard/>} />
          <Route path= "/planDetails" element= {<PlanDetails />} />
          <Route path= "/addPlan" element= {<AddPlan />} />
          <Route path= "/editPlan" element= {<EditPlan />} />
          <Route path= "/staffDetails" element= {<StaffDetails />} />
          <Route path= "/addStaff" element= {<AddStaff/>} />
          <Route path= "/editStaff" element= {<EditStaff />} />
          <Route path= "/userDetails" element= {<UserDetails />} />
          <Route path= "/staffProfile" element={<AdminStaffProfile />} />


        </Routes>
      </BrowserRouter>
      <ToastContainer theme="colored" />

    </div>
  );
}

export default App;
