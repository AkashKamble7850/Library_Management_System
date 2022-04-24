import React from "react";

const GetFeedback = (props) => {
    
    const { list } = props

    return (
        <tr>
            <td>{list.user.userId}</td>
            <td>{list.feedback}</td>
        
        </tr>
    )  
}

export default GetFeedback