Feature: Inici de sessió

Scenario: Inici de sessió desde pàgina principal

Given the user is in the starting page
When clicks login button
And enters email
And enters password
And clicks login
Then user dashboard appears