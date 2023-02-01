import React from 'react';
import styled from 'styled-components';

const Footer = () => {
    const Footer = styled.h3`
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 0px;
    margin: 0px;
    width: 100%;
    height: 30px;

    `
    return (
    <Footer>Designed By Sean Gan 2023</Footer>
    );
};

export default Footer;