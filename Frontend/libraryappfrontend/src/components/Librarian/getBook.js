import react from "react";

const GetBook=(props)=>{
    const {list}= props

    return(
        <tr>
            <td>{list.bookId}</td>
            <td>{list.bookName}</td>
            <td>{list.isbn}</td>
            <td>{list.firstName}</td>
            <td>{list.lastName}</td>
            <td>{list.category}</td>
            <td>{list.quantity}</td>
            <td>{list.availableQuantity}</td>
            
        </tr>
    )
}

export default GetBook