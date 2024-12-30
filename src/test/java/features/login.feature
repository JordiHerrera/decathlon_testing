Feature: Inici de sessió

Scenario: Inici de sessió desde pàgina principal

Given the user is in the index page
When clicks login button
And enters email "tqs_uab_testing@yopmail.com"
And enters password
And clicks forgot password
Then forgotten password page appears with email "tqs_uab_testing@yopmail.com"