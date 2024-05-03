import { SIGN_IN, SIGN_UP } from "./ActionType";

export const singinAction = (data) => async (dispatch) => {
  try {
    const res = await fetch("http://localhost:8888/signin", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Basic " + btoa(data.email + ":" + data.password),
      },
      credentials: "include",
    });

    if (res.ok) {
      const token = res.headers.get("Authorization");
      localStorage.setItem("token", token);

      dispatch({ type: SIGN_IN, payload: token });

      console.log("Token from header:", token);
    } else {
      console.error("Error:", res.statusText);
    }
  } catch (error) {
    console.error("Fetch error:", error);
  }
};

export const singupAction = (data) => async (dispatch) => {
  try {
    const res = await fetch("http://localhost:8888/signup", {
      method: "POST",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(data),
    });
    const user = await res.json();
    console.log("signup user :", user);
    dispatch({ type: SIGN_UP, payload: user });
  } catch (error) {
    console.log(error);
  }
};

// import { SIGN_IN, SIGN_UP } from "./ActionType";

// export const signinAction=(data)=>async (dispatch)=>{
//     try{

//         const res = await fetch("/signin",{
//             // mode : "no-cors",
//             method:"GET",
//             headers : {
//                 "Content-Type" : "application/json",
//                 "Accept" : "application/json",
//                 Authorization : "Basic " +btoa(data.email + ":" + data.password)
//             }
//         })
//         const token = res.headers.get("Authorization");
//         localStorage.setItem("token", token);

//         dispatch({type:SIGN_IN, payload:token})

//         console.log("Signin Token : ", token)

//     }catch(error){
//         console.log(error)
//     }
// }

// export const signupAction=(data)=>async (dispatch)=>{
//     try{

//         const res = await fetch("http://localhost:8888/signup",{
//             method:"POST",
//             headers : {
//                 "Content-Type" : "application/json",
//             }
//         })
//         const user = await res.json();

//         console.log("Signup User : ", user)

//         dispatch({type:SIGN_UP, payload:user})

//     }catch(error){
//         console.log(error)
//     }
// }
