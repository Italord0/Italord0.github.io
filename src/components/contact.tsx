import React, { useState } from 'react'
import "../styles/contact.css"
import {
    BrowserRouter as Router
} from "react-router-dom";
const Contact = () => {
    const [copySuccess, setCopySuccess] = useState('');
    const [show, setShow] = useState(true)

    const copyToClipBoard = async (copyMe: string) => {
        await navigator.clipboard.writeText(copyMe);
        setCopySuccess('Copied!');
        setShow(!show)

        setTimeout(() => {
            setCopySuccess('');
        }, 5000);

    };

    return (
        <Router>
            <div id="contact" className='contact-container'>
                <div className='contact-section'>
                    <h2>Contact me</h2>
                    <div className="contact-text">
                        <p>Don't be shy! Hit me up! 👇</p>
                    </div>
                    <div className="container-location">
                        <div className="contact-flex">
                            <div className="simbols">
                                <i className="fa-solid fa-map-location-dot"></i>
                                <div className="text">
                                    <h5>Location</h5>
                                    <p>Recife, Brazil</p>
                                </div>
                            </div>
                        </div>
                        <div className="contact-flex">
                            <div className="simbols">
                                <i className="fa-solid fa-envelope-open-text"></i>
                                <div className="text">
                                    <h5>Mail</h5>
                                    <p onClick={() => copyToClipBoard("italord.melo@gmail.com")}>italord.melo@gmail.com</p>
                                </div>
                                {!show && <span>{copySuccess}</span>}
                            </div>
                        </div>
                    </div>
                </div>
            </div >
        </Router >
    )
}

export default Contact