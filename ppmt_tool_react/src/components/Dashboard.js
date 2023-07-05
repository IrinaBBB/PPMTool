import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import CreateProjectButton from "./Project/CreateProjectButton";

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
                                <CreateProjectButton />
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
