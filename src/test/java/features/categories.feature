Feature: Categories

Scenario: Unfold the categories section and enter a subcategory

Given the user is in the index page
When the user is on top a category 
And clicks in a subcategory
Then the subcategory is shown on screen
