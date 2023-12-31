import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import AddProject from "./components/Project/AddProject";
import Header from "./components/Layout/Header";
import { Provider } from "react-redux";
import store from "./store";
import Test from "./components/Layout/Test";

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>
// );

const router = createBrowserRouter([
    {
        path: "/dashboard",
        element: <Test />,
    },
    {
        path: "/addProject",
        element: <AddProject />,
    },
    {
        path: "/",
        element: <App />,
    },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <Provider store={store}>
            <Header />
            <RouterProvider router={router} />
        </Provider>
    </React.StrictMode>,
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
