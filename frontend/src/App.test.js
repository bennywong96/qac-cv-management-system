import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {login} from './Components/login.js';

import { configure, shallow } from 'enzyme';
import { expect } from 'chai';
import Adapter from 'enzyme-adapter-react-16'
import {Login} from "./Components/login";

configure({ adapter: new Adapter() });

describe('Check main App.js loads', function() {
    it('login component renders in App.js', function() {
        const wrapper = shallow(<App />);
        const frontPage = (
            <div className="login">
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
                <p>Password</p><input type="text" placeholder="Password"/>
                <br/>
                <br/>
                <input type="submit" value="Submit"/>
            </div>
        );
        expect(wrapper.contains(loginComponents)).to.equal(true);
    });
});





