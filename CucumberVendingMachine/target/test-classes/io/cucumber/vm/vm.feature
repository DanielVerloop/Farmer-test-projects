#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Vending Machine

  @tag1
  Scenario Outline: Have Product and user have exact amount of money
    Given there exists a vending machine
    And it has 10 <product> in its inventory
    When inserts the <money> pounds
    And presses the button with the code for <product>
    Then the stock reduces in 1 unit
    And the <product> leaves the machine

    Examples:
      | product     | money | status  |
      | "chips"     |  2.00 | success |
      | "chocolate" |  2.50 | Fail    |
      | "cookie"    |  1.75 | Fail    |
      | "candy"     |  1.50 | Fail    |
      | "juice"     |  3.25 | Fail    |
      | "water"     |  1.50 | Fail    |
      | "coke"      |  2.25 | Fail    |
      | "pepsi"     |  2.25 | Fail    |

  @tag2
  Scenario Outline: Have Product and user to receive change
    Given there exists a vending machine
    And it has 10 <product> in its inventory
    When the user inserts the <money> dollars
    And selects the <product>
    And the vending machine removes <product> from inventory
    Then the inventory stock of <product> must be equal to 9 units
    And the vending machine gives <change> back

    Examples:
      | product     | money | change |
      | "chips"     |  2.50 |   0.50 |
      | "chocolate" |  3.50 |   1.00 |
      | "cookie"    |  2.00 |   0.25 |
      | "candy"     |  2.00 |   0.50 |
      | "juice"     |  5.00 |   1.75 |
      | "water"     |  3.00 |   1.50 |
      | "coke"      |  3.00 |   0.75 |
      | "pepsi"     |  2.25 |   0.00 |

  @tag3
  Scenario Outline: user give less money than the price of the product
    Given there exists a vending machine
    And it has 10 <product> in its inventory
    When the user insert the <money>
    And presses the button with the code for the product
    Then the vending machine asks for <missing> dollars

    Examples:
      | product     | money | missing |
      | "chips"     |  1.00 |    1.00 |
      | "chocolate" |  2.00 |    0.50 |
      | "cookie"    |  1.50 |    0.25 |
      | "candy"     |  0.50 |    1.00 |
      | "juice"     |  1.25 |    2.00 |
      | "water"     |  0.75 |    0.75 |
      | "coke"      |  2.00 |    0.25 |
      | "pepsi"     |  1.25 |    1.00 |
