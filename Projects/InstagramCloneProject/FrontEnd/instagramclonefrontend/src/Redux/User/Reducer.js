import { REQ_USER } from "./ActionType"

const initialValue={
    reqUser : null,
}

export const userReducer=(store=initialValue,{type,payload})=>{
    if(type===REQ_USER){
        return {...store, reqUser:payload}
    }
    return store
}