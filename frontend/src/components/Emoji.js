import './css/Box.css'

const Emoji = ({symbol, label, setChoice}) => {
    const onChangeHandler = () => {
        setChoice(label)
    }

    return (
        <div className='checkboxstyle'>
            <input value={symbol} type="checkbox" onChange={onChangeHandler}/>
                {symbol}
        </div>
    )
}

export default Emoji;