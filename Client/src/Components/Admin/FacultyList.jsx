import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import Apicall, { urls } from '../../services/Apicall';

const FacultyList = () => {
    const [faclist , setFac] = useState([]);
    const token = useSelector(store=>store.user.value.token);

    useEffect(()=>{
       loadfac();
    } , [])
    const loadfac = ()=>{
        Apicall.getCallToken(urls.FAC_LIST , token)
        .then(res=>{
            if(res.status){
                setFac(res.data);
            }
        })
    }
  return (
    <>
      <h1 className='alert-success'>Faculty Records</h1>
      <table className='table mt-3'>
        <thead>
            <tr>
                <th>Faculty ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody>
                {faclist.map(ob=><tr>
                    <td>{ob.facid}</td>
                    <td>{ob.name}</td>
                    <td>{ob.email}</td>
                    <td>{ob.phone}</td>
                </tr>)}
            </tbody>
      </table>
    </>
  )
}

export default FacultyList
