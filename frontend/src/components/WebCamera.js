import React, { useState } from 'react'
import Webcam from 'react-webcam'
import { sumbitImage } from "../utils";
import { message} from "antd";

const videoConstraints = {
  width: 400,
  height: 400,
  facingMode: 'user',
}

const WebCamera = ({setResStatus, setRes}) => {
  const [picture, setPicture] = useState('')
  const webcamRef = React.useRef(null)

  const capture = React.useCallback( async () => {
    const pictureSrc = webcamRef.current.getScreenshot()
    console.log(pictureSrc)
    const formData = new FormData();
    formData.append("base64", pictureSrc);

    setPicture(pictureSrc)

    try {
        sumbitImage(formData).then((data) => {
          message.success("upload successfully");
          setResStatus(true)
          setRes(data)
        })
      } catch (error) {
        message.error(error.message);
      } finally {
      }
  }
  )

  return (
    <div>
      <h2 className="mb-5 text-center">
        React Photo Capture using Webcam
      </h2>
      <div className="mb-5 text-center">
        {picture === '' ? (
          <Webcam
            audio={false}
            height={400}
            ref={webcamRef}
            width={400}
            screenshotFormat="image/jpeg"
            videoConstraints={videoConstraints}
          />
        ) : (
          <img src={picture} alt='expression'/>
        )}
      </div>
      <div className="mb-5 text-center">
        {picture !== '' ? (
          <button
            onClick={(e) => {
              e.preventDefault()
              setPicture('')
            }}
            className="btn btn-primary"
          >
            Retake
          </button>
        ) : (
          <button
            onClick={(e) => {
              e.preventDefault()
              capture()
            }}
            className="btn btn-danger"
          >
            Capture
          </button>
        )}
      </div>
    </div>
  )
}
export default WebCamera