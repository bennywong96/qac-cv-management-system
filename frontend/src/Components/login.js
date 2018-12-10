import React from 'react';

export class Login extends React.Component {
    render() {

        return (
            <div>
                <p>Username:</p><input type="text" placeholder="Username"/>
                <p>Password</p><input type="text" placeholder="Password"/>
                <br/>
                <br/>
                <input type="submit" value="Submit"/>
            </div>
        );
    }
}