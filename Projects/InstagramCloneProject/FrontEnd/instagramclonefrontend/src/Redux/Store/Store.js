import { applyMiddleware, combineReducers, legacy_createStore } from "redux"
import { AuthReducer } from "../Auth/Reducer"
import thunk from "redux-thunk"
import { userReducer } from "../User/Reducer";

const rootReducers = combineReducers({
    auth : AuthReducer,
    user : userReducer
})

export const store = legacy_createStore(rootReducers, applyMiddleware(thunk));