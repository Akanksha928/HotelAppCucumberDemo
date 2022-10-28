Feature: HotelApp login
Description: This test is to check the login functionality of the HotelApp

Scenario: Login Successful
Given User is on HotelApp homepage 
When User enters Username and Password
| username | password |
| akanksha28 | akanksha |
| vasuvespag | vasu1234 |
And User clicks on login button 
Then Login is successful
