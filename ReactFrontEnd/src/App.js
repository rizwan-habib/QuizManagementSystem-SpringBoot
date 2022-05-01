import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import React, { useEffect } from 'react'
import WelcomePage from './welcome';
import LoginPage from './login';
import SetupProfilePage from './setupProfile';
import RegisterTeacherPage from './registerTeacher';
import CreateQuiz from "./CreateQuiz";
import RoomsAndBeds from './roomsAndBeds';
import UpdateRooms from './updateRooms';
import TakeQuiz from './TakeQuiz';
import DelHostel from './deleteHostel';
import HostelMain from './hostelMain';
import RequestMessages from './requestMessages';


function App() {
  useEffect(() => {
    document.title = "Quiz Management System"
  }, [])


  return (
    <div>
      <Router>
        <Switch>
          <Route path="/login">
            <LoginPage/>
          </Route>
          <Route path="/setupProfile">
            <SetupProfilePage/>
          </Route>
          <Route path="/registerTeacher">
            <RegisterTeacherPage/>
          </Route>
          <Route path="/CreateQuiz">
            <CreateQuiz/>
          </Route> 
          <Route path="/roomsAndBeds">
            <RoomsAndBeds/>
          </Route>
          <Route path= "/updateRooms">
            <UpdateRooms/>
          </Route> 
          <Route path= "/TakeQuiz">
            <TakeQuiz/>
          </Route>
          <Route path= "/deleteHostel">
            <DelHostel/>
          </Route>
          <Route path= "/requestMessages">
            <RequestMessages/>
          </Route>
          <Route path= "/hostelMain">
            <HostelMain/>
          </Route>  
          <Route path="/">
            <WelcomePage/>
          </Route> 
        </Switch>
      </Router>
      
    </div>
  );
}

export default App;
