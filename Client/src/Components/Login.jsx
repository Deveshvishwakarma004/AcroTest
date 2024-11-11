import React, { useRef } from 'react'
import toast from 'react-hot-toast'
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom'
import { setUserData } from '../reduxconfig/UserSlice';
import apiCall , { urls } from '../services/Apicall';

const Login = () => {

   const navigate = useNavigate();
   const dispatch = useDispatch();
    var mailbox = useRef()
    var passbox = useRef()

    const login = (event)=>{
        event.preventDefault()
        const email = mailbox.current.value;
        const password = passbox.current.value;
        const data = {email , password}

        apiCall.postCall(urls.LOGIN , data).then(res=>{
          console.log(res.data)
            if(res.status){
              toast.success(res.msg);
              dispatch(setUserData(res.data));
              navigate(`/${res.data.role}/home`);
            }
            else{
              toast.error(res.msg);
            }
        })
    }
  return (
  <>
  <h1 className='alert-success'>Login Page</h1>
  <form onSubmit={login}>
  <div className='row mt-3'>
    <div className='col-xl-6 col-lg-6'>
        <input type='email' className='form-control' placeholder='Email' ref={mailbox} required />
    </div>
  </div>
  <div className='row mt-3'>
    <div className='col-xl-6 col-lg-6'>
        <input type='password' className='form-control' placeholder='Password'  ref={passbox} required />
    </div>
  </div>
  <div className='row mt-3'>
    <div className='col-xl-6 col-lg-6'>
        <button className='btn btn-success'>Login</button>
    </div>
  </div>
  
  </form>
  </>
  )
}

export default Login
