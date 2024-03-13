
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom'


function Header() {
    return (
        <div>
            <Navbar style={{ backgroundColor: 'lightgrey' }} expand="lg">
                <Container fluid>
                    <Link to="/"><Navbar.Brand><img style={{ height: 40 }} src={require('..//images/job-finder-logo-339385278B-seeklogo.com.png')} alt=""></img></Navbar.Brand></Link>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav
                            className="me-auto nav_bar_wrapper"
                            style={{ maxHeight: '100px' }}
                            navbarScroll>

                        </Nav>
                        <Form className="d-flex">
                            <Link to="/login"><Button style={{ marginRight: 10 }}>Login</Button></Link>
                            <Link to="/register"><Button style={{ marginRight: 10 }}>Register</Button></Link>
                            {/* <Form.Control
                                type="search"
                                placeholder="Search"
                                className="me-2"
                                aria-label="Search"
                            />
                            <Button variant="outline-success">Search</Button> */}
                        </Form>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
                   
        </div>
        
    )
}

export default Header