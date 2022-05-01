import { useHistory } from "react-router";
import NavStudentMain from "./NavStudentMain";
import HeaderStudentMain from "./headerStudentMain";
import {useLocation} from 'react-router-dom';

function HostelMain() {
    const history = useHistory();
    const location = useLocation();

    // function handleSubmit(e) {
    // e.preventDefault();
    // // history.push('/RoomsAndBeds');
    // }



    return (  
            <div>
              
               <header class="header-blue">
                <NavStudentMain  state = {location.state}  />
                <HeaderStudentMain/>
                </header>     
            </div>
        
    );
  }
  
  export default HostelMain;