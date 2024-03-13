import { useState } from 'react';
import { Card } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useNavigate } from 'react-router-dom';
import UserNav from "./UserNav"


function UserProfileUpdate() {

    const history = useNavigate();
    // let response = fetch('/user/get')
    // var userInfo = JSON.parse(localStorage.getItem('user-info'))
    // var user = JSON.stringify(userInfo.user)
    var userInfo = JSON.parse(localStorage.getItem('user-info'))
    var user = userInfo.user;
    var addressIn = ["", "", "", ""]
    if (user.address != null) {
        addressIn = user.address.split(" ,, ");
    }
    var qualIn = ["", "", "", "", "", "", "", "", ""]
    if (user.qualification != null) {
        qualIn = user.qualification.split(" ,, ");
    }

    const userId = user.userId
    const email = user.email
    const password = user.password
    const [contactNo,setContactNo] = useState(JSON.stringify(user.contactNo))
    const [firstName,setFirstName] = useState(user.firstName)
    // console.log(contactNo,contactNo.length,firstName,firstName.length)
    const [lastName,setLastName] = useState(user.lastName)
    const [age,setAge] = useState(user.age)
    const [gender,setGender] = useState(user.gender)

    const [addr,setAddr] = useState(addressIn[0])
    const [city,setCity] = useState(addressIn[1])
    const [state,setState] = useState(addressIn[2])
    const [zip,setZip] = useState(addressIn[3])
    const address = addr+" ,, "+city+" ,, "+state+" ,, "+zip

    const [ssc,setSsc] = useState(qualIn[0])
    const [sscboard,setSscboard] = useState(qualIn[1])
    const [sscperc,setSscperc] = useState(qualIn[2])
    const [hsc,setHsc] = useState(qualIn[3])
    const [hscboard,setHscboard] = useState(qualIn[4])
    const [hscperc,setHscperc] = useState(qualIn[5])
    const [gradcol,setGradcol] = useState(qualIn[6])
    const [graduniv,setGraduniv] = useState(qualIn[7])
    const [gradperc,setGradperc] = useState(qualIn[8])
    const qualification = ssc+" ,, "+sscboard+" ,, "+sscperc+" ,, "+hsc+" ,, "+hscboard+" ,, "+hscperc+" ,, "+gradcol+" ,, "+graduniv+" ,, "+gradperc

    // console.log(firstName,contactNo,lastName,address,qualification)
    // console.log(gender)

    async function Update() {
        let item = { userId,email,password,firstName,lastName,age,gender,contactNo,address,qualification };
        if (firstName.length === 0) {
            alert("FirstName cant be empty")
            return
        }
        if (contactNo !== 0 && contactNo.length !== 10) {
            alert("Invalid Phone no.")
            return
        }
        if (age !== 0 && (age <20 || age > 40)) {
            alert("Age should be between 20-40")
            return
        }

    let response = await fetch("/user/update", {
        method: 'PUT',
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(item)
    });
    let result = await response.json();
    if (response.ok) {
        localStorage.setItem('user-info', JSON.stringify(result))
        history('/user/profile')
    }
}

    
    return (
        <><UserNav/>
        <div className="col-sm-8 offset-sm-2">
            <Card className='App' style={{ marginTop: 20, padding: 20, backgroundColor: "lightgrey" }}>
                <Form>

                    <Row className="mb-3">
                        <Form.Group as={Col} >
                            <Form.Label><strong>Email</strong></Form.Label>
                            <Form.Control placeholder="Enter Email" defaultValue={user.email} disabled />
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Contact No.</strong></Form.Label>
                            <Form.Control type="number" placeholder="Enter ContactNo" onChange={(e) => setContactNo(e.target.value)} defaultValue={user.contactNo===0?"":user.contactNo} />
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridFirstName">
                            <Form.Label><strong>First Name</strong></Form.Label>
                            <Form.Control type="text" onChange={(e) => setFirstName(e.target.value)} defaultValue={user.firstName} placeholder="Enter FirstName" />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridLastName">
                            <Form.Label><strong>Last Name</strong></Form.Label>
                            <Form.Control type="text" onChange={(e) => setLastName(e.target.value)} defaultValue={user.lastName} placeholder="Enter LastName" />
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} >
                            <Form.Label><strong>Age</strong></Form.Label>
                            <Form.Control type="number" onChange={(e) => setAge(e.target.value)} placeholder="Enter Age" defaultValue={user.age===0?"":user.age}/>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Gender</strong></Form.Label>
                            <Form.Select onChange={(e) => setGender(e.target.value)} defaultValue={(user.gender===null)?null:(user.gender==='m')?'m':(user.gender==='f')?'f':'o'}>
                                <option value={null}>Choose..</option>
                                <option value='m'>Male</option>
                                <option value='f'>Female</option>
                                <option value='o'>Others</option>
                            </Form.Select>
                        </Form.Group>
                    </Row>

                    <Form.Group className='mb-3' controlId="formGridAddress">
                        <Form.Label><strong>Address</strong></Form.Label>
                        <Form.Control placeholder="Enter Address" onChange={(e) => setAddr(e.target.value)} defaultValue={addressIn[0]}/>
                    </Form.Group>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridCity">
                            <Form.Label><strong>City</strong></Form.Label>
                            <Form.Control placeholder="Enter City" onChange={(e) => setCity(e.target.value)} defaultValue={addressIn[1]} />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label><strong>State</strong></Form.Label>
                            <Form.Control placeholder="Enter State" onChange={(e) => setState(e.target.value)} defaultValue={addressIn[2]} />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridZip">
                            <Form.Label><strong>Zip</strong></Form.Label>
                            <Form.Control placeholder="Enter Zip" onChange={(e) => setZip(e.target.value)} defaultValue={addressIn[3]} />
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">

                        <strong>SSC</strong>
                        <hr />

                        <Form.Group as={Col} >
                            <Form.Label><strong>School</strong></Form.Label>
                            <Form.Control placeholder="Enter School Name" onChange={(e) => setSsc(e.target.value)} defaultValue={qualIn[0]} />
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Board</strong></Form.Label>
                            <Form.Control placeholder="Enter Board" onChange={(e) => setSscboard(e.target.value)} defaultValue={qualIn[1]}/>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Percentage</strong></Form.Label>
                            <Form.Control placeholder="Enter Percentage" onChange={(e) => setSscperc(e.target.value)} defaultValue={qualIn[2]}/>
                        </Form.Group>

                    </Row>

                    <Row className="mb-3">

                        <strong>HSC</strong>
                        <hr />

                        <Form.Group as={Col} >
                            <Form.Label><strong>School</strong></Form.Label>
                            <Form.Control placeholder="Enter School Name" onChange={(e) => setHsc(e.target.value)} defaultValue={qualIn[3]}/>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Board</strong></Form.Label>
                            <Form.Control placeholder="Enter Board" onChange={(e) => setHscboard(e.target.value)} defaultValue={qualIn[4]}/>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Percentage</strong></Form.Label>
                            <Form.Control placeholder="Enter Percentage" onChange={(e) => setHscperc(e.target.value)} defaultValue={qualIn[5]}/>
                        </Form.Group>

                    </Row>

                    <Row className="mb-3">

                        <strong>Graduation</strong>
                        <hr />

                        <Form.Group as={Col} >
                            <Form.Label><strong>College</strong></Form.Label>
                            <Form.Control placeholder="Enter College Name" onChange={(e) => setGradcol(e.target.value)} defaultValue={qualIn[6]}/>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>University</strong></Form.Label>
                            <Form.Control placeholder="Enter University" onChange={(e) => setGraduniv(e.target.value)} defaultValue={qualIn[7]}/>
                        </Form.Group>

                        <Form.Group as={Col} >
                            <Form.Label><strong>Percentage</strong></Form.Label>
                            <Form.Control placeholder="Enter Percentage" onChange={(e) => setGradperc(e.target.value)} defaultValue={qualIn[8]}/>
                        </Form.Group>

                    </Row>

                    <Button variant="primary" onClick={Update}>
                        Submit
                    </Button>
                    <Button style={{marginLeft:20}} variant="danger" onClick={()=>history('/user/profile')}>
                        Cancel
                    </Button>
                </Form>
            </Card>
        </div>
        </>
    )
}


export default UserProfileUpdate