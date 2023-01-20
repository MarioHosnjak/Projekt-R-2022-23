import logo from './logo.svg';
import './App.css';
import React from "react";
import { Route, Routes } from "react-router-dom";
import HomePageWrapper from './components/wrappers/homePageWrapper';
import NotFound from './container/notFound/notFound';
import SenzorPageWrapper from './components/wrappers/senzorPageWrapper';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route
          path={"/"}
          element={<HomePageWrapper/>}
        />
        <Route
          path={"/senzor/:id"}
          element={<SenzorPageWrapper/>}
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
