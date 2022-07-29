import React from 'react'
import signin from '../user/signin.jpg'
const Signimg = () => {
    return (
        <>
            <div className="right_data mt-5" style={{ width: "100%"}}>
                <div className="sign_img mt-4">
                    <img src={signin} style={{ maxWidth: 400 ,marginLeft:100,borderRadius: 150 / 2}} alt="" />
                </div>
            </div>
        </>
    )
}

export default Signimg