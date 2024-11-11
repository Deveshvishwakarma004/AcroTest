import { useEffect, useRef, useState } from "react"
import { useParams } from "react-router-dom"
import Apicall, {urls} from "../../services/Apicall"
import { useSelector } from "react-redux"
import toast from "react-hot-toast"

export default function AddQues()
{
    const params = useParams()
    const token = useSelector(store=>store.user.value.token)
    const [quslist,setQusList] = useState([])
  

    const qusRef = useRef()
    const ans1Ref = useRef()
    const ans2Ref = useRef()
    const ans3Ref = useRef()
    const ans4Ref = useRef()
    const rightRef = useRef()

    useEffect(()=>{
        loadQus()
    },[])

    const loadQus = ()=>{
         const URL = `${urls.LIST_QUS}/${params.id}`
        Apicall.getCallToken(URL,token)
        .then(res=>{
            if(res.status)
            {
                setQusList(res.data);
            }
        });
    }

    const save = (event)=>
    {
        event.preventDefault()
        const data = {
            question : qusRef.current.value,
            ans1  :ans1Ref.current.value,
            ans2 : ans2Ref.current.value,
            ans3 : ans3Ref.current.value,
            ans4 : ans4Ref.current.value,
            rightAns : rightRef.current.value
        }
        const URL = `${urls.SAVE_QUS}/${params.id}`
        Apicall.postCallToken(URL,data,token).then(res=>{
            if(res.status)
            {
                setQusList([...quslist,res.data])
                toast.success(res.msg)
                event.target.reset()
            }
        });
    }

    return <>
         <h1 className="alert-success">Add Questions</h1>

         <form onSubmit={save}>
            <div className="row mt-3 justify-content-center">
                <div className="col-xl-10 col-lg-10">
                    <input type="text" ref={qusRef} className="form-control" placeholder="Question" required/>
                </div>
            </div>    
            <div className="row mt-3">
                <div className="col-xl-6 col-lg-6">
                    <input type="text" ref={ans1Ref} className="form-control" placeholder="Answer 1" required/>
                </div>
                <div className="col-xl-6 col-lg-6">
                    <input type="text" ref={ans2Ref} className="form-control" placeholder="Answer 2" required/>
                </div>
            </div>
            <div className="row mt-3">
                <div className="col-xl-6 col-lg-6">
                    <input type="text" ref={ans3Ref} className="form-control" placeholder="Answer 3" required/>
                </div>
                <div className="col-xl-6 col-lg-6">
                    <input type="text" ref={ans4Ref} className="form-control" placeholder="Answer 4" required/>
                </div>
            </div>
            <div className="row mt-3">
                <div className="col-xl-6 col-lg-6">
                    <select ref={rightRef} className="form-control" required>
                        <option value=''>Choose Right Answer</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>    
                </div>
                <div className="col-xl-6 col-lg-6">
                   <button className="btn btn-success">Save Ques</button>
                </div>
            </div>
        </form>
        <hr/>
        <table className="table">
            <thead>
                <th>S. No.</th>
                <th>Question</th>
                <td>Answer 1</td>
                <td>Answer 2</td>
                <td>Answer 3</td>
                <td>Answer 4</td>
                <td>Operation</td>
            </thead>
            <tbody>
                {quslist.map((ob,index)=><tr>
                    <td>{index+1}</td>
                    <td>{ob.question}</td>
                    <td>{ob.ans1}</td>
                    <td>{ob.ans2}</td>
                    <td>{ob.ans3}</td>
                    <td>{ob.ans4}</td>
                </tr>)}
            </tbody>
        </table>
    </>
}