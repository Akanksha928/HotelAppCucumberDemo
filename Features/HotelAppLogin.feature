Feature: HotelApp login Param
Description: This test is to check the login functionality of the HotelApp

Scenario: Login Successful
Given User is on HotelApp homepage 
When User enters Username as "akanksha28"
And User enters Password as "akanksha"
And User clicks on login button 
Then Login is successful
