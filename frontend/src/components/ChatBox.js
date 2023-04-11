import { Card } from 'antd';
import './css/Box.css'


const ChatBox = ({emoji}) => {
    return (
        <div className='chatboxstyle'>
            <Card title="Chat Box" bordered={false}>
                {emoji.map((item, index) => <p>{item}</p>)}
            </Card>
        </div>
    )
}

export default ChatBox;