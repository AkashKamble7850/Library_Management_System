import react from "react";

const GetFine=(props)=>{
    const {list}= props

    return(
        <tr>
            <td>{list.bookId}</td>
            <td>{list.bookName}</td>
            <td>{list.firstName}</td>
            <td>{list.lastName}</td>
            <td>{list.issueDate}</td>
            <td>{list.dueDate}</td>
            <td>{list.returnDate}</td>
            <td>{list.fine}</td>
        </tr>
    )
}

export default GetFine