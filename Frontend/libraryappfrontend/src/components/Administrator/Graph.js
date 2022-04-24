import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer, AreaChart, Area, BarChart, Bar } from 'recharts';
import react from "react";
import axios  from 'axios';
import { useEffect, useState } from 'react'

const Graph = () => {
    const book = [
        {
            bookName: "The Alchemist",
            quantity: 15,
            available_quantity : 9
        },
        {
            bookName: "Atomic Habits",
            quantity: 12,
            available_quantity : 10
        }
    ]
    
    
    return (
        <div>
      <h1 className="chart-heading">Bar Chart</h1>
      <ResponsiveContainer width="100%" aspect={3}>
        <BarChart
          width={200}
          height={300}
          data={book}
          
          margin={{
            top: 5,
            right: 50,
            left: 40,
            bottom: 5,
          }}
        >
          console.log(list)
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="bookName" />
                console.log(dataKey)
          <YAxis />
          <Tooltip />
          <Legend />
          <Bar dataKey="quantity" fill="#8884d8" />
          console.log(dataKey)
          <Bar dataKey="available_quantity" fill="#82ca9d" />
        </BarChart>
      </ResponsiveContainer>
          
        </div>
    )
 
}

export default Graph
