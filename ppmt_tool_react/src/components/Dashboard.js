import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";

class Dashboard extends Component {
    render() {
        return (
            <>
                <div className="projects">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12">
                                <h1 className="text-center h2">
                                    <i className="fa fa-flag-checkered pr-1">
                                        &nbsp;Projects
                                    </i>
                                </h1>
                                <br />
                                <a
                                    href="ProjectForm.html"
                                    className="btn btn-lg btn-info"
                                >
                                    <i className="fa fa-plus-circle pr-1">
                                    </i>
                                    &nbsp;Create a Project
                                </a>
                                <br />
                                <hr />
                                <ProjectItem />
                            </div>
                        </div>
                    </div>
                </div>
            </>
        );
    }
}

export default Dashboard;
