
import { NavDropdown, NavLink } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router-dom';



function UserNav() {

    
    const history = useNavigate();
    var name = JSON.parse(localStorage.getItem('user-info')).user.firstName

    function logout() {

        var ans = window.confirm("Do you want to logout?")
        if (ans) {
            localStorage.clear()
            history('/')
        }
    }

    return (
        <div>
            <Navbar style={{ backgroundColor: 'lightgrey' }} expand="lg">
                <Container fluid>
                    <Navbar.Brand><img style={{ height: 40 }} src={require('../..//images/job-finder-logo-339385278B-seeklogo.com.png')} alt=""></img></Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav
                            className="me-auto nav_bar_wrapper"
                            style={{ maxHeight: '100px' }}
                            navbarScroll>
                        </Nav>
                        <NavLink style={{marginRight:20}} onClick={()=>{history('/user/jobs')}}>Apply Jobs</NavLink>
                        <NavLink style={{marginRight:20}} onClick={()=>{history('/user')}}>Dashboard</NavLink>
                        <NavDropdown title={name} style={{ marginRight: 20 }} >
                            
                            <NavDropdown.Item onClick={() => { history('/user/profile') }}>Profile</NavDropdown.Item>
                            <NavDropdown.Item onClick={logout}>Logout</NavDropdown.Item>
                        </NavDropdown>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    )
}

export default UserNav