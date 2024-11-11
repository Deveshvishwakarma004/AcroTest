class Apicall
{
    postCall(URL , data){
    return fetch(URL , {
        method :"POST",
        headers : {
            "Content-Type" : "application/json",
        },
        body : JSON.stringify(data)
     }).then(res=>res.json())
    }

    postCallToken(URL, data, token){
        return fetch(URL , {
            method :"POST",
            headers : {
                "Content-Type" : "application/json",
                "Authorization" : token,
            },
            body : JSON.stringify(data)
         }).then(res=>res.json())
        }
        
        getCallToken(URL ,token){
            return fetch(URL , {
                method :"GET",
                headers : {
                    "Authorization" :token,
                },
             }).then(res=>res.json())
            }
}

export default new Apicall();

export const urls ={
    STUDENT_REG : "http://localhost:8080/acro/stud_reg" ,
    FACULTY_REG : "http://localhost:8080/acro/fac_reg" ,
    LOGIN : "http://localhost:8080/acro/login",
    FAC_LIST : "http://localhost:8080/auth/admin/faculties",
    STU_LIST : "http://localhost:8080/auth/admin/students",
    SAVE_TEST : "http://localhost:8080/auth/faculty/savetest",
    MYTEST_LIST : "http://localhost:8080/auth/faculty/mytestlist",
    SAVE_QUS : "http://localhost:8080/auth/faculty/savequs",
    LIST_QUS : "http://localhost:8080/auth/faculty/listqus",

    TEST_LIST_STUD : "http://localhost:8080/auth/student/testlist",

}
