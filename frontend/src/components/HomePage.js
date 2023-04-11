import React from "react";
import ModalPoP from "./ModalPop"
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../App.css'
import WebCamera from './WebCamera'


import { useState } from 'react';
import ChatBox from "./ChatBox";


const HomePage = () => {
  const [resStatus, setResStatus] = useState(false)
  const [res, setRes] = useState()
  const [emoji, setEmoji] = useState([])

  return(
    <>
    <div className="container mt-5">
      <WebCamera setResStatus={setResStatus} setRes={setRes}/>
    </div>
    <div>
      {resStatus && <ModalPoP isModalOpen={resStatus} setResStatus={setResStatus} res={res} setEmoji={setEmoji}/>}
    </div>
    {emoji && <ChatBox emoji={emoji}/>}
    </>
  )
}

export default HomePage;
