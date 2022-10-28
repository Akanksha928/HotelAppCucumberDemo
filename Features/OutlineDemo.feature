Feature: HotelApp login
Description: This test is to check the login functionality of the HotelApp

Scenario Outline: Login Successful
Given User is on HotelApp homepage 
When User enters Username as <"<username>">
And User enters Password as <"<password>">
And User clicks on login button 
Then Login is successful

Examples: 
| username | password |
| akanksha28 | akanksha |
| vasuvespag | vasu1234 |