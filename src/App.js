import logo from './logo.svg';
import './App.css';
import React from "react";
import { Route, Routes } from "react-router-dom";
import NotFound from './container/notFound/notFound';
import HomePage from './container/homePage/homePage';
import SenzorPage from './container/senzorPage/senzorPage';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route
          path={"/"}
          element={<HomePage/>}
        />
        <Route
          path={"/senzor/:id"}
          element={<SenzorPage/>}
        />
        <Route
          path={"*"}
          element={<NotFound/>}
        />
      </Routes>
    </div>
  );
}

export default App;
