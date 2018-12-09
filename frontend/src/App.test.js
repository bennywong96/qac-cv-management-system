import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { login } from './Components/login_page.js';

import { configure, shallow } from 'enzyme';
import { expect } from 'chai';
import Adapter from 'enzyme-adapter-react-16'

configure({ adapter: new Adapter() });

describe('Check main App.js loads', function() {
    it('login component renders in App.js', function() {
        const wrapper = shallow(<App />);
        const frontPage = <login />
        expect(wrapper.contains(frontPage)).to.equal(true);
    });
});

describe('Check Login component', function() {
    it('login component exists', () => {
        const wrapper = shallow(<App />);
        const loginComponents = (
            <div>
                <input type="text" placeholder="Username"/>
                <input type="text" placeholder="Password"/>
                <input type="button" value="Submit"/>
            </div>
        );
        expect(wrapper.contains(loginComponents)).to.equal(true);
    });
}

);




