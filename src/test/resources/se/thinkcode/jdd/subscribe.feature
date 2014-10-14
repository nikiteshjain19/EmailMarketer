Feature: Subscribe for our e-mail marketing service

  In order to be able to receive important marketing messages
  As marketing message receiver
  I should be able to register my e-mail address

  Scenario: Subscribe with a valid e-mail address
    Given I want to subscribe to receive important market information
    When I enter a valid address tsu@kth.se
    Then should I get a welcome message

  Scenario: Try to subscribe with an invalid e-mail address
    Given I want to subscribe to receive important market information
    When I enter an invalid address tsu.kth.se
    Then should I get an error message
