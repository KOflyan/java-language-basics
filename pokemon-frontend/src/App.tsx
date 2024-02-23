import React from 'react';
import { HomePage } from "./pages/HomePage/HomePage";
import { TrainerProfilePage } from "./pages/TrainerProfilePage/TrainerProfilePage";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Toolbar } from "./components/Toolbar/Toolbar";
import { LoginPage } from "./pages/LoginPage/LoginPage";

export const App = () => {
  return (
      <BrowserRouter>
          <Toolbar></Toolbar>
          <Routes>
              <Route path='/' element={<HomePage></HomePage>}/>
              <Route
                  path='/profile'
                  element={<TrainerProfilePage></TrainerProfilePage>}
              />
              <Route
                  path='/login'
                  element={<LoginPage></LoginPage>}
              />
          </Routes>
      </BrowserRouter>
  )
}
