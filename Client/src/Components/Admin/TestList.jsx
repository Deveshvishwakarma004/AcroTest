import { useEffect, useRef, useState } from "react"
import Apicall, {urls} from "../../services/Apicall"
import { useSelector } from "react-redux"
import { Link } from "react-router-dom"
export default function TestList()
{  
    const [testlist,setTestList] = useState([])
    const token = useSelector(store=>store.user.value.token)
    const role = useSelector(store=>store.user.value.role)

    useEffect(()=>{
        loadTest()
    },[])

    const loadTest = ()=>
    {
        const URL = role=='admin'?urls.TEST_LIST:urls.TEST_LIST_STUD;
        Apicall.getCallToken(URL,token)
        .then(res=>{
            if(res.status)
            {
                setTestList(res.data);
            }
        });
    }
   
    return <>
        <h1 className="alert-success">Test Records</h1>      
        <table className="table">
            <thead>
                <tr>
                    <th>S. No.</th>
                    <th>Title</th>
                    <th>Test Date</th>
                    <th>Submit Date</th>
                    <th>Faculty</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
            {testlist.map((ob,index)=><tr>
                    <td>{index+1}</td>
                    <td>{ob.title}</td>
                    <td>{ob.testDate}</td>
                    <td>{ob.postDate}</td>
                    <td>{ob.user.name}</td>
                    <td>
                        {role=='admin'?<>
                            <button className="btn-sm btn-danger">Delete</button>
                        </>:<>
                            <Link to="/student/testrun"> <b>Run</b> </Link>
                        </>}
                    </td>
                </tr>)}
            </tbody>
        </table>
    </>
}