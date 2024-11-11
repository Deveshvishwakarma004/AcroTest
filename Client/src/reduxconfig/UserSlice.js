import { createSlice } from "@reduxjs/toolkit";

const slice = createSlice({
    name : 'usr',
    initialState : {
        value : {
            islogin : false,
            name : undefined,
            token : undefined,
            role : undefined
        }
    },
    reducers : {
        setUserData : (state , action) =>{
            const obj = {
                ...action.payload,
                islogin:true
            }
            state.value = obj;
        },
        deleteUserData : (state,action)=>{
            state.value = {
                islogin : false,
                name : undefined,
                token : undefined,
                role : undefined
            }
        },
    }

});

export default slice.reducer;

export const {setUserData , deleteUserData} = slice.actions;