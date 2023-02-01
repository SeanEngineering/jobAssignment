import React from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const Nav = () => {
    const navigate = useNavigate();

    const Link = styled.li`
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    list-style: none;
    transition: 0.5s;
    color: black;
    cursor: pointer;
    &:hover {
        color: red;
        transition: 0.5s;
    }
    `;

    const NavList = styled.ul`
    display: flex;
    width: 50vw;
    height: auto;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;`;

    const changeNavigate = (link: string) => {
        navigate(`/${link}`)
    }

    
    return (
        <div>
            <NavList>
                <Link onClick={() => {changeNavigate('login')}}>login</Link>
                <Link onClick={() => {changeNavigate('profile')}}>profile</Link>
                <Link onClick={() => {changeNavigate('temps')}}>temps</Link>
                <Link onClick={() => {changeNavigate('jobs')}}>jobs</Link>
            </NavList>
        </div>
    );
};

export default Nav;