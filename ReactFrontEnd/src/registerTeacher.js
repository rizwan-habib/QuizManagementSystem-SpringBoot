import Nav from "./Navbar"
import './css/Registration-Form-with-Photo.css'
import { useHistory } from "react-router";
import { useState } from "react";
import axios from "axios";

function RegisterTeacherPage() {
    const history = useHistory();

    const [teacherName, setTeacherName] = useState("");
    const [login, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [university, setUniversity] = useState("");
    const[department,setDepartment] =  useState("");
    
    function updateTeacherName(e)
    {
      setTeacherName(e.target.value);
    }

    function updateUserName(e)
    {
      setUserName(e.target.value);
    }
  
    function updatePassword(e)
    {
      setPassword(e.target.value);
    }
    function updateUniversity(e)
    {
      setUniversity(e.target.value);
    }
    function updateDepartment(e)
    {
      setDepartment(e.target.value);
    }

    
    function handleSubmit(e) {
        e.preventDefault();
        
        const user = {
            "teacherName":teacherName,
            "login": login,
            "password": password,
            "university": university,
            "department":department
        };
          
          let result =  false;
      
          axios.post(`http://localhost:8001/enterTeacherDetails`,user)
          .then(res => {
              console.log(res);
              //data message now in result
              result =res.data;
              if(result=="success")
              {
                history.push("/login");
              }
              else if(result=="false"){
                alert("Username Already Exist")
                console.log("error");
              }  
            }
          )
          .catch(err => {
            console.log("Error Reading data " + err);
          });
    
       
        
      }
  
    return (
    <div>
    <Nav/>
    <section class="register-photo">
        <div class="form-container">
            <div class="image-holder"></div>
            <form onSubmit={handleSubmit}>
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="mb-3"><input class="form-control" id ="inputName"  onChange={updateTeacherName} value={teacherName} type="text" name="text" placeholder="Teacher Name"/></div>
                <div class="mb-3">
                    <div class="input-group">
                        <span class="input-group-text" id="inputGroupPrepend2">@</span>
                        <input class="form-control" id ="inputUserName"  onChange={updateUserName} value={login} type="text" name="text" placeholder="User Name"/>
                    </div>
                </div>
                <div class="mb-3"><input class="form-control" id="passwordH" onChange={updatePassword} value={password} type="password" name="password" placeholder="Password"/></div>
                <div class="mb-3"><input class="form-control" id="hostelAddr" onChange={updateUniversity} value={university} type="text" name="hostel-address" placeholder="University Name"/></div>
                <div class="mb-3"><input class="form-control" id="totalRooms" onChange={updateDepartment} value={department} type="text" name="total-rooms" placeholder="Department"/></div>
                <div class="mb-3">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox"/>I agree to the license terms.</label></div>
                </div>
                <div class="mb-3"><button class="btn btn-primary d-block w-100" type="submit">Register Teacher</button></div><a class="already" href="/Login">You already have an account? Login here.</a>
            </form>
        </div>
    </section>

    </div>
  );
}

export default RegisterTeacherPage;