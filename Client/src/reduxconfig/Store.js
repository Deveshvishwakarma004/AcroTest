import { configureStore } from "@reduxjs/toolkit";
import UserReducer from "./UserSlice"

const store = configureStore({
    reducer: {
        user : UserReducer,
        // We can add multiple state and reducers here
    }
});

export default store;