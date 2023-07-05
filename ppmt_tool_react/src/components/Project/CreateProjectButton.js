import React from "react";
import { Link } from "react-router-dom";

const CreateProjectButton = () => {
    return (
        <>
            <Link to="/addProject" className="btn btn-lg btn-info">
                <i className="fa fa-plus-circle pr-1"></i>
                &nbsp;Create a Project
            </Link>
        </>
    );
};

export default CreateProjectButton;
