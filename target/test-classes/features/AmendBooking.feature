

  Feature: Amend Booking
    Scenario Outline: change the date of arrival
      Given Load the page
      When Click on manage bookings
      And Load the booking details "<Booking Reference>", "<Surname>" and "<Arrival Date>"
      Then Click on Amend Booking
      And In the Amend Booking page, change the arrival date to different date
      And Capture the information in the rooms available
      Then Write the information capture to a csv file
      Examples:
        |Booking Reference|Surname|Arrival Date|
        |BCVR237241       |Tester |21- Aug -22 |
        |AUUR261388       |Tester |25- Aug -22 |
        |AMOR227074       |Tester |28- Aug -22 |






