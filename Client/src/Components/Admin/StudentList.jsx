import React , {useState , useEffect} from 'react'
import { useSelector } from 'react-redux'
import Apicall, { urls } from '../../services/Apicall';

const StudentList = () => {

    const [stulist , setStu] = useState([]);
    const token = useSelector(store=>store.user.value.token);

    useEffect(()=>{
       loadstd();
    } , [])
    const loadstd = ()=>{
        Apicall.getCallToken(urls.STU_LIST , token)
        .then(res=>{
            if(res.status){
                setStu(res.data);
            }
        })
    }
  return (
    <>
       <h1 className='alert-success'>Student Records</h1>
      <table className='table mt-3'>
        <thead>
            <tr>
                <th>Enrollment No.</th>
                <th>Name</th>
                <th>Email</th>
                <th>Branch</th>
                <th>Semester</th>
            </tr>
            </thead>
            <tbody>
                {stulist.map(ob=><tr>
                    <td>{ob.enrollnum}</td>
                    <td>{ob.name}</td>
                    <td>{ob.email}</td>
                    <td>{ob.branch}</td>
                    <td>{ob.sem}</td>
                </tr>)}
            </tbody>
      </table>
    </>
  )
}

export default StudentList
