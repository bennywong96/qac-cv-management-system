import React from 'react';
import App from './App';

import { configure, shallow } from 'enzyme';
import { expect } from 'chai';
import Adapter from 'enzyme-adapter-react-16'

import {Login} from './components/login.js';
import {NavBar} from "./components/navbar";
import loginAuthen from "./components/loginContainer";



configure({ adapter: new Adapter() });

describe('Check main App.js loads', function() {
    it('login component renders in App.js', function() {
        const wrapper = shallow(<App />);
        const frontPage = (
            <div className="login">
            <NavBar/>
            <Login />
            </div>
        );
        expect(wrapper.contains(frontPage)).to.equal(true);
    });
});

describe('Check Login component', function() {
    it('login component exists', () => {
        const wrapper = shallow(<Login/>);
        const loginComponents = (
            <div>
                <p>Username:</p><input type="text" placeholder="Username"/>
                <p>Password</p><input type="password" placeholder="Password"/>
                <br/>
                <br/>
                <input type="submit" value="Submit"/>
            </div>
        );
        expect(wrapper.contains(loginComponents)).to.equal(true);
    });
});

describe('REST test', () => {
    it ('Login function', (done) => {
        loginAuthen(body)
            .then(data => {
                expect(data).toBeDefined();
                expect(data).status.equal();
                done();
            })

    });
});




