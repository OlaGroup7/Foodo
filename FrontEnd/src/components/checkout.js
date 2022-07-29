import React from 'react'
import NavigationBar from './NavBar'
function CheckOut() {
    //console.log("checkout rendered");
    return (
        <>
        <NavigationBar/>
        <div className="checkOutOrder">
            <section class="home" id="home">
                            <div class="content"style={{marginLeft:100}}>
                                <h2>
                                    Yayyy!! We have received your order 
                                </h2>
                                <br>
                                </br>
                                <br>
                                </br>
                                <br>
                                </br>
                                <br>
                                </br>
                                <p>Order Number</p>
                                <p>7262388363</p>
                                <p>Payment</p>
                                <p>Paid: Using Cash Payment</p>
                            </div>
                            <div class="image">
                            <img className="checkOutOrderImg img-responsive" src="https://assetcdn.pickupp.io/prime/8a01a8893881250a47cee80100a73ff5ac5bd4fe_Ramadan-Food-Delivery.jpg" alt="" height = "610px" width = "700px"/> 
                            </div>
                        </section>
        </div> 
        </>
    )
}
export default React.memo(CheckOut)