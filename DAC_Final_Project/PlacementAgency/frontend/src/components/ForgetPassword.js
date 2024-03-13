import { Button, Card } from "react-bootstrap"
import React, { useEffect, useState } from 'react'
import { useNavigate } from "react-router-dom";
import Header from "./Header";

function ForgetPassword() {

    const [email, setEmail] = useState("");
    const [OTP, setOTP] = useState("");

    const history = useNavigate();

    useEffect(() => {
        if (localStorage.getItem('user-info')) {
            history('/user')
        }
    }, [])

    async function validate() {

        if (email.length === 0) {
            alert("Please Enter Data")
            return
        }

        let response = await fetch("/user/validate?name="+{email}, {
            method: 'GET',
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(email)
        });

        let result = await response.json();
        
        if (response.ok) {
            
            history('/user')
        }
    }
    return (
        <><Header />
            <div className="col-sm-4 offset-sm-4">
                <Card style={{ marginTop: 20, padding: 20, backgroundColor: "lightgrey" }}>
                    <h2 style={{ marginBottom: 40 }}>User Sign Up</h2>
                    <div>
                        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Enter Email" className="form-control" />
                        <br />
                    </div>
                    <div>
                        <Button onClick={validate}>Submit</Button>
                    </div>
                </Card>
            </div>
        </>
    )
}

export default ForgetPassword