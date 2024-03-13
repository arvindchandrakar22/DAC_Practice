import { Button, Card, Col, Row } from "react-bootstrap";
import UserNav from "./UserNav"

function JobList() {

    var user = JSON.parse(localStorage.getItem('user-info')).user

    async function getJobList() {

        let response = await fetch('/user/getAllJobs/', {
            method: 'GET',
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
        });

        let result = await response.json();
        if (response.ok) {
            localStorage.setItem('job-list', JSON.stringify(result))
        }
    }

    getJobList();

    const Jobs = JSON.parse(localStorage.getItem('job-list'))

    if (!localStorage.getItem('job-list')) {
        return (
            <><UserNav />
                <div className="col-sm-8 offset-sm-2">
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <h4>Nothings here</h4>
                    <p>Looks like no jobs have been posted by any company</p>
                </div>
            </>
        )
    }

    else {
        return (
            <><UserNav />
                <br />
                <h3 style={{ marginLeft: 20 }}>Jobs</h3>
                <hr />
                <div className="col-sm-8 offset-sm-2">
                    {
                        Jobs.map((data) =>
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
                                    <Col>{data.uid===user.userId?<Button disabled style={{ maxHeight: 35,}}>Applied</Button>:<Button style={{ maxHeight: 35 }}>Apply</Button>}</Col>
                                </Row>
                            </Card>
                        )
                    }

                </div>
            </>
        )

    }

}

export default JobList