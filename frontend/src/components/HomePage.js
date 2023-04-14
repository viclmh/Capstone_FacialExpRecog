import React from "react";
import ModalPoP from "./ModalPop"
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../App.css'
import './css/Box.css'
import WebCamera from './WebCamera'


import { useState } from 'react';
import ChatBox from "./ChatBox";


const HomePage = () => {
  const [resStatus, setResStatus] = useState(false)
  const [res, setRes] = useState()
  const [emoji, setEmoji] = useState([])

  return (
    <>
      <div className="instruction">
        <p>Hi there! 👋 This is a facial expression recognition application supporting classifying 4 kinds of expression: 👻</p>
        <p><b>1. Neutral 2. Happy 3. Sad 4. Surprise</b></p>
        <p>You could start by clicking on the <b>"Capture"</b> button, please come closer to the camera and the first try might take longer time.</p>
        <p>After getting the classification result, you could select the corresponding emoji you like and click <b>"OK"</b> to send it to the chatbox 🗣.</p>
        <p>Click on the <b>"Retake"</b> button to have another try.</p>
        <p>Have fun! 🌟</p>
      </div>
      <div className="container mt-5">
        <WebCamera setResStatus={setResStatus} setRes={setRes} />
      </div>
      <div>
        {resStatus && <ModalPoP isModalOpen={resStatus} setResStatus={setResStatus} res={res} setEmoji={setEmoji} />}
      </div>
      {emoji && <ChatBox emoji={emoji} />}
      <p></p>
      <footer className="footer">
        ©2023 Facial Expression Recognition Web App. All Rights Reserved. Website Made by Minghan Li & Hongju Lee.
      </footer>      
    </>
  )
}

export default HomePage;
