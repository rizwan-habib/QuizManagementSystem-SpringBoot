import Card from "./card";
import UserProfile from "./userProfile";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import { useHistory } from "react-router";
import { useLocation } from "react-router-dom";
import "./css/Growing-Search-Bar-Animated-Text-Input.css";
import "./fonts/fa-brands-400.eot";
import "./fonts/fa-brands-400.svg";
import "./fonts/fa-brands-400.ttf";
import "./fonts/fa-brands-400.woff";
import "./fonts/fa-regular-400.svg";
import "./fonts/fa-solid-900.svg";
import "./fonts/fontawesome-all.min.css"


function CreateQuiz() {
  const location = useLocation();
  const history = useHistory();
  const [searchTerm, setSearchTerm] = useState("");
  const [searchResults, setSearchResults] = useState([]);
  const [filteredNames, setFilterNames] = useState([]);
  const [username, setusername] = useState("");

  function updateSearch(e) {
    setSearchTerm(e.target.value);
    //console.log(searchTerm);
  }

  useEffect(() => {
    const user = {
      hostelName: searchTerm
    };

    let result = false;

     
    axios
      .post(`http://localhost:8001/searchHostel`, user)
      .then((res) => {
        result = res.data;

        setSearchResults(res.data);
      })
      .catch((err) => {
        // Do something for an error here
        console.log("Error Reading data " + err);
      });
  }, [searchTerm]);
  
//   useEffect(() => {
//     // Run! Like go get some data from an API.
//     setusername(location.state.data.username);
//   }, []);
  useEffect(() => {
    const hostelnames = searchResults.map((val) => {
      if (!searchTerm || searchTerm.length === 0 || searchTerm === "") {
        return {
          hostelName: val.hostelName,
          login: val.login,
          address: val.address,
          hostelID: val.hostelID,
          rooms: val.rooms,
        };
      } else if (
        val.hostelName.toLowerCase().includes(searchTerm.toLowerCase())
      ) {
        return {
          hostelName: val.hostelName,
          login: val.login,
          address: val.address,
          hostelID: val.hostelID,
          rooms: val.rooms,
        };
      }
      return null; 
    });

    setFilterNames(hostelnames);
    // setusername()
  }, [searchTerm]);

  return (
    <div>
        <h1>Under Developement</h1>

      </div>                  

      

        );
}

export default CreateQuiz;
