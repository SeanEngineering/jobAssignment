import React from 'react';
import styled from 'styled-components';

const Title = () => {
    const Heading = styled.h1`
    padding: 0px;
    margin: 0px;
    `;
    const SubHeading = styled.h5`
    padding: 0px;
    margin: 0px;
    padding-top: 5px;
    `
    const TitleBox = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;`

    return (
        <TitleBox>
               <Heading>WorkFlo</Heading>
               <SubHeading>Your Job Management Portal</SubHeading>
        </TitleBox>
     
    );
};

export default Title;