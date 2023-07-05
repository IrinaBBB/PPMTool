import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";

class Dashboard extends Component {
    render() {
        return (
            <>
                <h1>Welcome to Dashboard</h1>
                <ProjectItem />
            </>
        );
    }
}

export default Dashboard;
