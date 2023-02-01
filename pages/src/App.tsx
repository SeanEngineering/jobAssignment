import { useState } from 'react'
import { BrowserRouter, Route, Routes} from 'react-router-dom';
import './styles/style.scss'
import Nav from './components/nav/Nav';
import Footer from './components/footer/Footer';
import Base from './components/layouts/Base';
import Title from './components/title/Title';
import Login from './components/login/Login';

function App() {

  return (
    <BrowserRouter>
    <Base>
    <Nav />
    <Routes>
      <Route path="/login" element={<Login />}/>
      <Route path="/home"/>
      <Route path="/profile"/>
      <Route path="/temps"/>
      <Route path="/jobs"/>
      <Route path="/temps/:id"/>
      <Route path="/jobs/:id"/>
    </Routes>
    <Footer />
    </Base>
    </BrowserRouter>
  )
}

export default App
