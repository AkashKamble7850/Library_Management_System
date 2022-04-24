import React from "react";

const GetAuthor=(props)=>{
    const {list}= props

    return(
        <tr>
            <td>{list.authorId}</td>
            <td>{list.afirstName}</td>
            <td>{list.alastName}</td>
        </tr>

    )
}

export default GetAuthor