Feature: HotelApp
Description: This test is to check the search functionality of the HotelApp


Background: User is logged in
Given User is on HotelApp homepage 
When User enters Username
And User enters Password
And User clicks on login button 


Scenario: Search Hotel
When User selects location from dropdown
And User clicks on search button
Then List of hotels is displayed

#Scenario: Select Hotel
#When User selects location from dropdown
#And User clicks on search button
#And User selects a radiobutton
#And User clicks on continue button
#Then book a hotel page is displayed



