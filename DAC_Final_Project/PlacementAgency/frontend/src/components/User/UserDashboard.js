import { Button, Card, Col, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import UserNav from "./UserNav"

function UserDashboard() {

    const user = JSON.parse(localStorage.getItem('user-info')).user

    async function getAppliedJobs() {

        let response = await fetch('/user/getAppliedJobs/' + user.userId, {
            method: 'GET',
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
        });

        let result = await response.json();
        if (response.ok) {
            localStorage.setItem('applied-jobs', JSON.stringify(result))
        }
    }

    getAppliedJobs();

    const appJobs = JSON.parse(localStorage.getItem('applied-jobs'))

    if (!localStorage.getItem('applied-jobs')) {
        return (
            <><UserNav />
            <div className="col-sm-8 offset-sm-2">
                <br />
                <br />
                <br />
                <br />
                <h4>Welcome {user.firstName}</h4>
                <br />
                <p>Looks like you haven't applied for any jobs yet</p>
                <p><Link to='/user/jobs'>Click here</Link> to start applying.</p>
                </div>
            </>
        )
    }

    else {
        return (
            <><UserNav />
                <br />
                <h3 style={{ marginLeft: 20 }}>Dashboard</h3>
                <hr />
                <div className="col-sm-8 offset-sm-2">
                    {
                        appJobs.map((data) =>
                            <Card style={{ marginTop: 20, padding: 20, backgroundColor: "lightgrey" }}>
                                <Row className="App" >
                                    <Col><h4>{data.employer.companyName}</h4></Col>
                                    <Col></Col>
                                    <Col><h4>{data.job.jobDescp}</h4></Col>
                                </Row>
                                <br />
                                <Row className="App">
                                    <Col>Location : {data.job.jobLocation}</Col>
                                    <Col>Salary : Rs.{data.job.jobSalary}</Col>
                                    <Col>Category : {data.job.jobCat}</Col>
                                </Row>
                                <br />
                                <Row className="App">
                                    <Col>Email : {data.employer.companyemail}</Col>
                                    <Col>Contact : {data.employer.contact}</Col>
                                    <Col><Button variant="danger" style={{ maxHeight: 35 }}>Unapply</Button></Col>
                                </Row>
                            </Card>
                        )
                    }

                </div>
            </>
        )

    }
}

export default UserDashboard