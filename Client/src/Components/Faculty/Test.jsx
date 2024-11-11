import React, { useRef , useEffect , useState } from 'react'
import { useSelector } from 'react-redux';
import Apicall, { urls } from '../../services/Apicall';
import toast from 'react-hot-toast';
import { Link } from 'react-router-dom';

const Test = () => {
  const [testlist,setTestList] = useState([])
  const titleref = useRef();
  const dateref = useRef();

  const token = useSelector(store=>store.user.value.token);
  
  useEffect(()=>{
    loadTest()
},[])

const loadTest = ()=>{
  Apicall.getCallToken(urls.MYTEST_LIST,token)
  .then(res=>{
      if(res.status)
      {
          setTestList(res.data);
      }
  });
}

  const save = (event)=>{
    event.preventDefault()
    const data = {
      title: titleref.current.value,
      dateref : dateref.current.value,
    }
    Apicall.postCallToken(urls.SAVE_TEST,data,token).then(res=>{
      if(res.status){
        toast.success(res.msg)
      }
      else{
        toast.error("Test is not saved")
      }
    })
  }

  
  return (
  <>
  <h1 className='alert-success'>Test</h1>
  <form onSubmit={save}>
    <div className='row mt-4'>
      <div className='col-xl-4 col-lg-4'>
        <input type='text' className='form-control' placeholder='Test Title' required ref={titleref}/>
      </div>
      <div className='col-xl-4 col-lg-4'>
        <input type='date' className='form-control' placeholder='dd/mm/yyyy' required ref={dateref}/>
      </div>
   
    <div className='col-xl-4 col-lg-4'>
        <button  className='btn btn-success'>Save</button>
      </div>
       </div>
  </form>
  <table className='table mt-3'>
        <thead>
            <tr>
                <th>S.NO.</th>
                <th>Title</th>
                <th>Test Date</th>
                <th>Submit Date</th>
                <th>Operation</th>
            </tr>
            </thead>
            <tbody>
                {testlist.map((ob,index)=><tr>
                    <td>{index+1}</td>
                    <td>{ob.title}</td>
                    <td>{ob.testDate}</td>
                    <td>{ob.postDate}</td>
                    <td>
                        <Link to={`/faculty/addqus/${ob.testId}`}><b>Add Questions</b></Link>
                    </td>
                </tr>)}
            </tbody>
      </table>
  </>
  )
}

export default Test;
