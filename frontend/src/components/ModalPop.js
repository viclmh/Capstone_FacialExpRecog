import { Modal } from 'antd';
import { useState } from 'react';
import Emoji from './Emoji';
import emojis from './util/emojis';


const ModalPoP = ({isModalOpen, setResStatus, res, setEmoji}) => {

    const [choice, setChoice] = useState()

    const OKHandler = () => {
      setResStatus(false)
      setEmoji((previousVal) => {
        return [
          ...previousVal,
          emojis[res].symbols[choice]
        ]
      })
    }

    const CancelHandler = () => {
      setResStatus(false)
    }


    return (
        <>
        <Modal title="Emojis" open={isModalOpen} onOk={OKHandler} onCancel={CancelHandler}>
          <h2>Classification Result: {emojis[res].label}</h2>
          {emojis[res].symbols.map((emoji, index) =>
            <Emoji symbol={emoji} label={index} setChoice={setChoice}/>
          )}
        </Modal>
        </>
    )
}

export default ModalPoP;