import React from "react";
import ReactDOM from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import WorkoutApp from "./WorkoutApp.jsx";
import "@fortawesome/fontawesome-free/js/all.js";

const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <WorkoutApp />
  </>
);
