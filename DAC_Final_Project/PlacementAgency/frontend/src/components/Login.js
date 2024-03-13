import { Button, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import React, { useEffect, useState } from "react";
import Header from "./Header";

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [path, setPath] = useState("/user/get/");
    const history = useNavigate();

    const [selected, setSelected] = useState('/user');
    const locStore = (selected === '/user') ? 'user-info' : (selected === '/admin') ? 'admin-info' : 'employer-info'

    var display = (selected === '/user') ? 'inline' : 'none' 

    useEffect(() => {
        if (localStorage.getItem(locStore)) {
            history(selected)
        }
    }, [locStore,history,selected])

    const handleChange = event => {
        setSelected(event.target.value);
    };

    async function LogIn() {
    
        if (email.length === 0 || password.length === 0) {
            alert("Please Enter Data")
            return
        }
        // console.warn(item, path, selected)

        let response = await fetch(path+email+"/"+password, {
            method: 'GET',
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
        });

        let result = await response.json();
        if (response.ok) {
            localStorage.setItem(locStore, JSON.stringify(result))
            // console.warn("result:", result)
            var name = JSON.parse(localStorage.getItem('user-info')).user.firstName
            alert("Welcome "+name)
            history(selected)
        }
    }

    return (

        <><Header/>
            <div className="col-sm-4 offset-sm-4">
                <Card className="App" style={{ marginTop: 20, padding: 20, backgroundColor: "lightgrey" }}>
                    <h2>Log In</h2>
                    <div>
                        <label style={{ margin: 10 }}>
                            <input type="radio" name="path" value="/admin" checked={selected === '/admin'}
                                onChange={handleChange} onClick={() => setPath('/admin/get/')} />
                            Admin
                        </label>
                        <label style={{ margin: 10 }}>
                            <input type="radio" name="path" value="/employer" checked={selected === '/employer'}
                                onChange={handleChange} onClick={() => setPath('/employer/get/')} />
                            Employer
                        </label>
                        <label style={{ margin: 10 }}>
                            <input type="radio" name="path" value="/user" checked={selected === '/user'}
                                onChange={handleChange} onClick={() => setPath('/user/get/')} />
                            User
                        </label>
                    </div>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Enter Email" className="form-control" />
                    <br />
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Enter Password" className="form-control" />
                    <br />
                    <div>
                        <Button onClick={LogIn}>LogIn</Button>
                        <Button style ={{marginLeft:10,display:display}} onClick={()=>{history('/forgetPassword')}}>Forget Password</Button>
                    </div>
                </Card>
            </div>
        </>
    )
}

export default Login


