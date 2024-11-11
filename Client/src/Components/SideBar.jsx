import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { deleteUserData } from "../reduxconfig/UserSlice";

const SideBar = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const loginuser = useSelector((store) => store.user.value);
  
  const logout = () => {
    dispatch(deleteUserData());
    navigate("/");
  };

  const setupmenu = () => {
    if (loginuser.islogin) {
      if (loginuser.role === "faculty") {
        return (
          <ul>
            <li className="tm-nav-item ">
              <Link to="/faculty/home" className="tm-nav-link">
                <i className="fas fa-home"></i>
                Home
              </Link>
            </li>
            <li className="tm-nav-item ">
              <Link to="/faculty/home" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Students
              </Link>
            </li>
            <li className="tm-nav-item ">
              <Link to="/faculty/test" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Test
              </Link>
            </li>
            <li className="tm-nav-item" onClick={logout}>
              <Link to="" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Logout
              </Link>
            </li>
          </ul>
        );
      } else if (loginuser.role === "student") {
        return (
          <ul>
            <li className="tm-nav-item  ">
              <Link to="/student/home" className="tm-nav-link">
                <i className="fas fa-home"></i>
                Home
              </Link>
            </li>
            <li className="tm-nav-item ">
              <Link to="/student/home" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Give Test
              </Link>
            </li>
            <li className="tm-nav-item " onClick={logout}>
              <Link to="" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Logout
              </Link>
            </li>
          </ul>
        );
      } else {
        return (
          <ul>
            <li className="tm-nav-item  ">
              <Link to="/student/home" className="tm-nav-link">
                <i className="fas fa-home"></i>
                Home
              </Link>
            </li>
            <li className="tm-nav-item ">
              <Link to="/admin/student" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Student
              </Link>
            </li>
            <li className="tm-nav-item ">
              <Link to="/admin/faculty" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Faculty
              </Link>
            </li>
            <li className="tm-nav-item " onClick={logout}>
              <Link to="" className="tm-nav-link">
                <i className="fas fa-user"></i>
                Logout
              </Link>
            </li>
          </ul>
        );
      }
    } else {
      return (
        <ul>
          <li className="tm-nav-item ">
            <Link to="/" className="tm-nav-link">
              <i className="fas fa-home"></i>
              Home
            </Link>
          </li>
          <li className="tm-nav-item ">
            <Link to="/register" className="tm-nav-link">
              <i className="fas fa-user"></i>
              Register
            </Link>
          </li>
          <li className="tm-nav-item ">
            <Link to="/login" className="tm-nav-link">
              <i className="fas fa-user"></i>
              Login
            </Link>
          </li>
        </ul>
      );
    }
  };

  return (
    <header className="tm-header" id="tm-header">
      <div className="tm-header-wrapper">
        <button
          className="navbar-toggler"
          type="button"
          aria-label="Toggle navigation"
        >
          <i className="fas fa-bars"></i>
        </button>
        <div className="tm-site-header text-center">
          <img src="/img/Logo_acro.png" height={50} alt="..." />
          <h1 className="text-center">
            {loginuser.islogin?loginuser.name:"Acropolis Institute"}</h1>
        </div>
        <nav className="tm-nav" id="tm-nav">
          {setupmenu()}
        </nav>
      </div>
    </header>
  );
};

export default SideBar;
