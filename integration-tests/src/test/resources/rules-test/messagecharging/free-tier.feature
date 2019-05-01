@messagecharging
Feature: Calculate charge for free tier customers
Description: The purpose of this feature is to calculate the message charge for free tier customers
  Background:
    Given the license type is LIC-FREE
  @important
  Scenario: Calculate the charge for message count < 100000
    When the message count is 30000
    Then calculate the charge
    Then the charge is 0.0
  Scenario: Calculate the charge for message count = 100000
    When the message count is 100000
    Then calculate the charge
    Then the charge is 0.0
