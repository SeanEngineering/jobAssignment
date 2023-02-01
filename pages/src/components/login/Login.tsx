import React from 'react';
import styled from 'styled-components';
import Title from '../title/Title';

const Login = () => {
    const LoginForm = styled.form`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 15px;
    `;
    const SectionForm = styled.div`
    width: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    gap: 10px;`;
    return (
        <LoginForm>
            <Title />
            <SectionForm>
                <label htmlFor="username">Username</label>
                <input type="text" id='username'/>
            </SectionForm>
            <SectionForm>
                <label htmlFor="password">Password</label>
                <input type="password" id='password'/>
            </SectionForm>
            <button>Login</button>
        </LoginForm>
    );
};

export default Login;