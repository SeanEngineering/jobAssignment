import React, { ReactComponentElement } from 'react';
import styled from 'styled-components';

interface baseProps {
    children: React.ReactNode[];
}

const Base: React.FunctionComponent<baseProps> = ({children}) => {
    const Capsule = styled.div`
    display: flex;
    height: 97vh;
    width: 99vw;
    margin: 0px;
    padding: 0px;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    `;

    return (
        <Capsule>
            {children}
        </Capsule>
    );
};

export default Base;