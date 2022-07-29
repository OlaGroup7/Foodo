# Foodo
Foodo

Foodo is an Online Food Ordering and Deliver Application. Customers can search for food based on Cuisine and Restaurant, and order the available food. Customers can add food to the cart as well as update the cart.

Following Endpoints are used:

#signup
POST Request URI :  http://foodobackend.herokuapp.com/signup

Request:
{
  "name": "Kishan",
  "email": "abc@gmail.com",
  "password": "password",
  "phone": 8796966557,
  "address": "Banglore",
  "role": "Customer"
}
Response:
[
  {
    "flag": false,
    "msg": "User already exists",
    "_id": null
  },
  {
    "flag": true,
    "msg": "User created successfully",
    "_id": "62e3782fa49f6f0ba1f6d063"
  }
]





#login
POST Request URI :  http://foodobackend.herokuapp.com/login

Request JSON:

{
  "email": "abc@gmail.com",
  "password": "password"
}

Response JSON:

[
  {
    "flag": false,
    "msg": "User not found! Invalid Email",
    "role": "null",
    "_id": "null"
  },
  {
    "flag": false,
    "msg": "Invalid Password",
    "role": "null",
    "_id": "null"
  },
  {
    "flag": true,
    "msg": "login successful",
    "role": "Customer",
    "_id": "62e3782fa49f6f0ba1f6d063"
  }
]

#Home-Customer
GET Request URI : http://foodobackend.herokuapp.com/home-customer/{_id}

Request URI: 
http://foodobackend.herokuapp.com/home-customer/62e3782fa49f6f0ba1f6d063

Response JSON:

{
  "name": "Kishan",
  "address": "Bangalore"
}





#Add Food
POST Request URI :  http://foodobackend.herokuapp.com/addfood

Request JSON:

{
  "userID": "62e3782fa49f6f0ba1f6d063",
  "restaurantName": "62e23a22ff4a6b0e794ae942",
  "foodName": "Aloo Paratha",
  "cuisineType": "NorthIndian",
  "price": 90
}

Response JSON:

{
  "flag": true,
  "msg": "Food Addition Successful"
}

#Cuisine Details
GET Request URI:
http://foodobackend.herokuapp.com/searchResultsbyCuisine/cuisine={cusinie}

Request URI:
http://foodobackend.herokuapp.com/searchResultsbyCuisine?cuisine=SouthIndian

Response JSON:

[
  {
    "name": "Spice Zone",
    "address": "East Bangalore",
    "owner": "Suryansh",
    "phoneno": "9356442190",
    "_id": "62e251cd609284311f8c46cc",
    "resId": 0
  },
  {
    "name": "ParkView",
    "address": "Bangalore",
    "owner": "Madhavan",
    "phoneno": "9735432190",
    "_id": "62e23a8dff4a6b0e794ae943",
    "resId": 0
  },
  {
    "name": "Alpine Restaurant",
    "address": "West Bangalore",
    "owner": "Joshep",
    "phoneno": "9266442190",
    "_id": "62e2510a609284311f8c46ca",
    "resId": 0
  },
  {
    "name": "Meghna",
    "address": "South Bangalore",
    "owner": "Santhosh",
    "phoneno": "9935442190",
    "_id": "62e24f45609284311f8c46c6",
    "resId": 0
  }
]


#Show Restaurant Details
GET Request URI: http://foodobackend.herokuapp.com/showRestaurantDetails?_id={_id}&cuisine={cusinie}

Request:

Request URI: http://foodobackend.herokuapp.com/showRestaurantDetails?_id=62e23a8dff4a6b0e794ae943&cuisine=SouthIndian


Response JSON:

[
  {
    "foodID": 8,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Masala Dosa",
    "cuisineType": "SouthIndian",
    "price": 100
  },
  {
    "foodID": 9,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Idli Sambhar",
    "cuisineType": "SouthIndian",
    "price": 80
  },
  {
    "foodID": 10,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Rawa Dosa",
    "cuisineType": "SouthIndian",
    "price": 60
  },
  {
    "foodID": 11,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Medu Vada",
    "cuisineType": "SouthIndian",
    "price": 50
  },
  {
    "foodID": 109,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Masala Dosa",
    "cuisineType": "SouthIndian",
    "price": 65
  },
  {
    "foodID": 110,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Idli",
    "cuisineType": "SouthIndian",
    "price": 40
  },
  {
    "foodID": 111,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Curd Rice",
    "cuisineType": "SouthIndian",
    "price": 100
  },
  {
    "foodID": 112,
    "restaurantID": "62e23a8dff4a6b0e794ae943",
    "foodName": "Mendu Vada",
    "cuisineType": "SouthIndian",
    "price": 55
  }
]


#Add To Cart

POST Request URI: 
http://foodobackend.herokuapp.com/addcart

Request JSON:

{
  "cartId": 2,
  "userID": "62e3782fa49f6f0ba1f6d063",
  "restaurantID": "62e23a22ff4a6b0e794ae942",
  "quantity": 5,
  "foodName": "Onion Paratha",
  "totalPrice": 125,
  "unitPrice": 25
}

Response JSON:
{
  "flag": true,
  "msg": "Items Added to Cart"
}

#Update Cart

POST Request URI: 
http://foodobackend.herokuapp.com/updatecart

Request JSON:

{
  "userID": "62e3782fa49f6f0ba1f6d063",
  "foodName": "Onion Paratha",
  "quantity": 20
}
Response JSON:
[
  {
    "flag": true,
    "msg": "Food Detail Updated in Cart"
  },
  {
    "flag": true,
    "msg": "Food Item Deleted from Cart"
  }
]

#Show Cart
GET Request URI:
http://foodobackend.herokuapp.com/showcart/{_id}    

Request URI:
http://foodobackend.herokuapp.com/showcart/62e3782fa49f6f0ba1f6d063

Response JSON:

[
  {
    "cartId": 2,
    "userID": "62e3782fa49f6f0ba1f6d063",
    "restaurantID": "62e23a22ff4a6b0e794ae942",
    "foodName": "Onion Paratha",
    "quantity": 20,
    "unitPrice": 25,
    "totalPrice": 500,
    "_id": "62e37bd439fb0c4de54b43e9"
  }
]

#Checkout
GET Request URI:
http://foodobackend.herokuapp.com/cart/confirmorder/{userId}  

Request URI:
http://foodobackend.herokuapp.com/cart/confirmorder/62e3782fa49f6f0ba1f6d063 




Response JSON:

{
  "flag": true,
  "msg": "User Order Placed Successfully"
}


















