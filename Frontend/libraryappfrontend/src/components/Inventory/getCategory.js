import React from "react";

const GetCategory=(props)=>{
    const {list}= props

    return(
        <tr>
            <td>{list.categoryId}</td>
            <td>{list.categoryName}</td>
            {/* <td>{list.vendor}</td> */}
        </tr>

        // orderId | bookName  | aFirstName | quantity | language | vendorId
    )
}

export default GetCategory