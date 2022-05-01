import Nav from "./Navbar"
import './css/Registration-Form-with-Photo.css'
import { useHistory } from "react-router";
import { useState } from "react";
import axios from "axios";
function TakeQuiz() {

  return (
    <div>
      <Nav />
      <section class="register-photo">
        <div class="form-container">
          <div class="image-holder"></div>
          <form >
            <h2 class="text-center">
              <strong>QUIZ</strong>
            </h2>
            <div class="mb-3">
              <a>What is Computer?</a>
              <input
                class="form-control"
                id="inputName"
                type="text"
                name="text"
                placeholder="Answer"
              />
            </div>

            
            <div class="mb-3">
              <a>What is Programming?</a>
                <input
                  class="form-control"
                  id="inputUserName"
                  type="text"
                  name="text"
                  placeholder="Answer"
                />
              
            </div>
            <div class="mb-3">
              <a>What is Data Structures?</a>
                <input
                  class="form-control"
                  id="inputUserName"
                  type="text"
                  name="text"
                  placeholder="Answer"
                />
              
            </div>
            <div class="mb-3">
              <a>What is Software Engineering?</a>
                <input
                  class="form-control"
                  id="inputUserName"
                  type="text"
                  name="text"
                  placeholder="Answer"
                />
              
            </div>
            <div class="mb-3">
              <button class="btn btn-primary d-block w-100" type="submit">
                Submit
              </button>
            </div>
            
          </form>
        </div>
      </section>
    </div>
  );
}

export default TakeQuiz;
