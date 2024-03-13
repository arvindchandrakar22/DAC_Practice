import { Card } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useNavigate } from 'react-router-dom';
import UserNav from "./UserNav"


function UserProfile() {

    // let response = fetch('/user/get')
    var userInfo = JSON.parse(localStorage.getItem('user-info'))
    var user = userInfo.user;
    var address = ["---", "---", "---", "---"]
    if (user.address != null) {
        address = user.address.split(" ,, ");
    }
    var qualification = ["---", "---", "---", "---", "---", "---", "---", "---", "---"]
    if (user.qualification != null) {
        qualification = user.qualification.split(" ,, ");
    }
    const history = useNavigate();

    return (
        <><UserNav/>
        <div className="col-sm-8 offset-sm-2">
            <Card className='App' style={{ marginTop: 20, padding: 20, backgroundColor: "lightgrey" }}>
                <Form>
                    <Row className="mb-3">
                        <Form.Group as={Col} >
                            <Form.Label><strong>Email</strong></Form.Label>
                            <p>{user.email}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Contact No.</strong></Form.Label>
                            <p>{user.contactNo === 0 ? "---" : user.contactNo}</p>
                        </Form.Group>

                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridFirstName">
                            <Form.Label><strong>First Name</strong></Form.Label>
                            <p>{user.firstName}</p>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridLastName">
                            <Form.Label><strong>Last Name</strong></Form.Label>
                            <p>{user.lastName}</p>
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} >
                            <Form.Label><strong>Age</strong></Form.Label>
                            <p>{user.age === 0 ? "---" : user.age}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Gender</strong></Form.Label>
                            <p>{(user.gender == null) ? '---' : (user.gender === 'm') ? 'Male' : (user.gender === 'f') ? 'Female' : 'Others'}</p>
                        </Form.Group>
                    </Row>

                    <Row >
                    <Form.Group className='mb-3' controlId="formGridAddress">
                        <Form.Label><strong>Address</strong></Form.Label>
                        <p>{address[0]}</p>
                    </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridCity">
                            <Form.Label><strong>City</strong></Form.Label>
                            <p>{address[1]}</p>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label><strong>State</strong></Form.Label>
                            <p>{address[2]}</p>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridZip">
                            <Form.Label><strong>Zip</strong></Form.Label>
                            <p>{address[3]}</p>
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">

                        <strong>SSC</strong>
                        <hr />

                        <Form.Group as={Col} >
                            <Form.Label><strong>School</strong></Form.Label>
                            <p>{qualification[0]}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Board</strong></Form.Label>
                            <p>{qualification[1]}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Percentage</strong></Form.Label>
                            <p>{qualification[2]}</p>
                        </Form.Group>

                    </Row>

                    <Row className="mb-3">

                        <strong>HSC</strong>
                        <hr />

                        <Form.Group as={Col} >
                            <Form.Label><strong>School</strong></Form.Label>
                            <p>{qualification[3]}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Board</strong></Form.Label>
                            <p>{qualification[4]}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Percentage</strong></Form.Label>
                            <p>{qualification[5]}</p>
                        </Form.Group>

                    </Row>

                    <Row className="mb-3">

                        <strong>Graduation</strong>
                        <hr />

                        <Form.Group as={Col} >
                            <Form.Label><strong>College</strong></Form.Label>
                            <p>{qualification[6]}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>University</strong></Form.Label>
                            <p>{qualification[7]}</p>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Percentage</strong></Form.Label>
                            <p>{qualification[8]}</p>
                        </Form.Group>

                    </Row>

                    <Button variant="primary" onClick={() => history('/user/profile/update')}>
                        Edit
                    </Button>
                </Form>
            </Card>
        </div>
        </>
    )
}


export default UserProfile