import React, { Component } from 'react';
// import logo from './logo.svg';
import './App.css';
import { Login } from './components/login.js';
import {NavBar} from "./components/navbar";


export class App extends Component {

  render() {
    return (
        <div className="login">
            <NavBar/>
            <Login />

        </div>
    );
  }
}

export default App;
