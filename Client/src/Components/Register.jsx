import React, { useRef, useState } from "react";
import toast from "react-hot-toast";

import apicall, { urls } from "../services/Apicall";

function Studreg() {
  const nameref = useRef();
  const branchref = useRef();
  const enrollref = useRef();
  const semref = useRef();
  const emailref = useRef();
  const passref = useRef();

  const register = (event) => {
    event.preventDefault();
    const data = {
      name: nameref.current.value,
      branch: branchref.current.value,
      enroll: enrollref.current.value,
      semester: semref.current.value,
      email: emailref.current.value,
      password: passref.current.value,
    };
    apicall.postCall(urls.STUDENT_REG , data).then(resdata=>{
        console.log(resdata);
        if (resdata.status) {
            event.target.reset();
            toast.success("Registration Succesfull")
        }
        else{
            toast.error("Registration Failed")
        }

    })
  };
  return (
    <form onSubmit={register}>
      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <input
            type="text"
            className="form-control"
            placeholder="Name"
            required
            ref={nameref}
          />
        </div>
        <div className="col-xl-6 col-lg-6">
          <select ref={branchref} className="form-control" required>
            <option value="">Choose Branch</option>
            <option>CSE</option>
            <option>IT</option>
            <option>CSIT</option>
            <option>EC</option>
            <option>ME</option>
            <option>CIVIL</option>
          </select>
        </div>
      </div>

      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <input
            type="text"
            className="form-control"
            placeholder="Enrollment"
            required
            ref={enrollref}
          />
        </div>
        <div className="col-xl-6 col-lg-6">
          <select className="form-control" required ref={semref}>
            <option value="">Choose Semester</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
          </select>
        </div>
      </div>
      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <input
            type="email"
            className="form-control"
            placeholder="Email"
            required
            ref={emailref}
          />
        </div>
        <div className="col-xl-6 col-lg-6">
          <input
            type="password"
            className="form-control"
            placeholder="Password"
            required
            ref={passref}
          />
        </div>
      </div>
      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <button className="btn btn-success">Save Student</button>
        </div>
      </div>
    </form>
  );
}

function Facreg() {

  const nameref = useRef();
  const facidref = useRef();
  const phoneref = useRef();
  const emailref = useRef();
  const passref = useRef();

  const register = (event) => {
    event.preventDefault();
    const data = {
      name: nameref.current.value,
      facid: facidref.current.value,
      phone: phoneref.current.value,
      email: emailref.current.value,
      password: passref.current.value,
    };
    apicall.postCall(urls.FACULTY_REG , data).then(resdata=>{
        console.log(resdata);
        if (resdata.status) {
            event.target.reset();
            toast.success("Registration Succesfull")
        }
        else{
            toast.error("Registration Failed")
        }

    })
  };

  return (
    <form onSubmit={register}>
      <div className="row mt-3">
        <div className="col-xl-12 col-lg-12">
          <input
            type="text"
            className="form-control"
            placeholder="Name"
            required
            ref={nameref}
          />
        </div>
      </div>

      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <input
            type="text"
            className="form-control"
            placeholder="Contact No."
            required
           ref={phoneref}
          />
        </div>
        <div className="col-xl-6 col-lg-6">
          <input
            type="text"
            className="form-control"
            placeholder="Faculty ID"
            required
            ref={facidref}
          />
        </div>
      </div>
      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <input
            type="email"
            className="form-control"
            placeholder="Email"
            required
            ref={emailref}
          />
        </div>
        <div className="col-xl-6 col-lg-6">
          <input
            type="password"
            className="form-control"
            placeholder="Password"
            required
            ref={passref}
          />
        </div>
      </div>
      <div className="row mt-3">
        <div className="col-xl-6 col-lg-6">
          <button className="btn btn-success">Save Faculty</button>
        </div>
      </div>
    </form>
  );
}

const Register = () => {
  const [type, setType] = useState("student");

  return (
    <>
      <h1 className="alert-success"> Registration Page</h1>
      <button
        onClick={() => setType("student")}
        className="btn btn-outline-info"
      >
        Student
      </button>
      &nbsp;
      <button
        onClick={() => setType("faculty")}
        className="btn btn-outline-info"
      >
        Faculty
      </button>
      &nbsp;
      <hr />
      {type === "student" ? <Studreg /> : <Facreg />}
    </>
  );
};

export default Register;
