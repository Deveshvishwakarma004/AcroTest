import React from "react";
import SideBar from "./Components/SideBar";
import { Route, Routes } from "react-router-dom";
import Login from "./Components/Login";
import Home from "./Components/Home";
import { Toaster } from "react-hot-toast";
import FacultyHome from "./Components/Faculty/FacultyHome"
import StudHome from "./Components/Student/StudHome"
import Register from "./Components/Register";
import AdminHome from "./Components/Admin/AdminHome";
import FacultyList from "./Components/Admin/FacultyList";
import StudentList from "./Components/Admin/StudentList";
import Test from "./Components/Faculty/Test";
import TestList from "./Components/Admin/TestList"
import AddQues from "./Components/Faculty/AddQues"

function App() {
  return (
    <>
      <Toaster position="top-right" reverseOrder={false} />
      <SideBar />
      <div className="container-fluid">
        <main className="tm-main">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />

            <Route path="/admin/"> 
            <Route path="home" element={<AdminHome/>}/>
            <Route path="faculty" element={<FacultyList/>}/>
            <Route path="student" element={<StudentList/>}/>
            <Route path="test" element={<TestList/>}/>
             </Route>

             <Route path="/faculty/">
               <Route path="home" element={<FacultyHome/>}/>
               <Route path="test" element={<Test/>}/>
               <Route path="addqus/:id" element={<AddQues/>}/>
             </Route>

             <Route path="/student/">
             <Route path ="home" element={<StudHome/>}/>
             <Route path="test" element={<TestList/>}/>
             </Route>
          </Routes>
        </main>
      </div>
    </>
  );
}

export default App;
