import React from "react";
import "./Auth.css";
import Signin from "../../Components/Register/Signin";
import Signup from "../../Components/Register/Signup";
import { useLocation } from "react-router-dom";

export const Auth = () => {
  const location = useLocation()
  return (
    <div>
      <div className="flex items-center justify-center h-[84vh] space-x-5">
        <div className="relative hidden lg:block">
          <div className="h-[35.3rem] w-[23rem]">
            <img
            className="h-[85vh] w-full"
              src="https://cdn.pixabay.com/photo/2013/07/13/12/46/iphone-160307_1280.png"
              alt=""
            />
            <div className="mobileWallpaper h-[34rem] w-[19rem] absolute top-14 right-8" >

            </div>
          </div>
        </div>
        <div className="w-[40vw] lg:w-[23vw] h-[70vh]">
          {location.pathname==="/login" ? <Signin/> : <Signup/>}
      </div>
      </div>
    </div>
  );
};
