Feature: Unsubscribe for our e-mail marketing service

  In order to be a good marketing service, we want to allow our subscribers to unsubscribe from our messages
  As marketing message receiver
  I should be able to unregister my e-mail address

  Scenario: Unsubscribe from marketing messages with a valid e-mail address
    Given I have subscribed for a marketing service with my e-mail tsu@kth.se
    When I unsubscribe tsu@kth.se
    Then I should get a goodbye message
    And tsu@kth.se should be unsubscribed

  Scenario: Unsubscribe from marketing messages with an invalid e-mail address
    Given I have subscribed for a marketing service with my e-mail tsu@kth.se
    When I unsubscribe tsu.kth.se
    Then I should get an error message
    And tsu@kth.se should not be unsubscribed