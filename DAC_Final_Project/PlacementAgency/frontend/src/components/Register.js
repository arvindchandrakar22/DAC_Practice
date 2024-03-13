import { Button, Card } from "react-bootstrap"
import React, { useEffect, useState } from 'react'
import { useNavigate } from "react-router-dom";
import Header from "./Header";

function Register() {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const history = useNavigate();

    useEffect(()=>{
        if(localStorage.getItem('user-info'))
        {
            history('/user')
        }
    },[history])

    async function signUp() {
        let item = { firstName, lastName, email, password };
        if(firstName.length===0||lastName.length===0||email.length===0||password.length===0)
        {
            alert("Please Enter Data")
            return
        }
        console.warn(item)

        let response = await fetch("/user/add", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(item)
        });
        let result = await response.json();
        if(response.ok)
        { 
        localStorage.setItem("user-info", JSON.stringify(result))
        var name = JSON.parse(localStorage.getItem('user-info')).user.firstName
        alert("Welcome "+name)
        history('/user')
        }
    }
    return (
        <><Header/>
        <div className="col-sm-4 offset-sm-4">
        <Card className="App" style={{marginTop:20,padding:20,backgroundColor:"lightgrey"}}>
            <h2 style={{marginBottom:40}}>User Sign Up</h2>
            <div>
            <input type="text" value={firstName} onChange={(e) => setFirstName(e.target.value)} placeholder="Enter FirstName" className="form-control" />
            <br />
            <input type="text" value={lastName} onChange={(e) => setLastName(e.target.value)} placeholder="Enter LastName" className="form-control" />
            <br />
            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Enter Email" className="form-control" />
            <br />
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Enter Password" className="form-control" />
            <br />
            </div>
            <div>
            <Button onClick={signUp}>Sign Up</Button>
            </div>
           </Card>
        </div>
        </>
    )
}

export default Register