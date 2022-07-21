
@tagFinal
Feature: Background color change functionality

Background:
Given User is on the Techfios automation project testing page
And Set SkyBlue Background button exists
And Set White Background button exists
  
  @tag1
  Scenario: 1 User should be able to change bakground color to sky blue
    When User clicks on the: Set SkyBlue Background button
    Then The background color will change to sky blue

 @tag2
  Scenario: 2 User should be able to change bakground color to white
    When User clicks on the: Set White Background button
    Then The background color will change to white
