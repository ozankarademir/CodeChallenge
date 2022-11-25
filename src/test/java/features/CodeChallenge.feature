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
#@ (Tags/Labels):To group Scenariose
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Code Challenge for Mercedes

  Scenario: Adding product to shopping card and increase quantity without user account
	    Given User is on "https://www.hepsiburada.com/" hepsiburada landing page
	    Then Verify homepage is opened
	    When User Search "Apple Laptop" 
	    Then Verify product list page is opened
	    And User add first product from product list to cart
	    Then User add third product from product list to cart
	    And User goes to Cart
	    Then Verify cart is opened 
	    Then Verify product names and quantity
	    And User increases the quantity of the product in the basket
	    Then Verify that the quantity of the product is "2"
	    And User go back to Main Page
    
  Scenario: Change adress information
	    Given User is on "https://www.trendyol.com" trendyol landing page
	    And User go to Login page
	    Then User login into website with "ozankarademir.9292@gmail.com" and "J8RWw4,ArJP?dkj" cridentials
	    And User verifies whether log in successfully
	    Then User go to User Information page
	    Then Verify User Information page is opened
	    And User selects 25 th index in birthday dropdown
	    Then User selects 5 th index in birthmonth dropdown
	    And User selects 19 th index in birthyear dropdown
	    Then User press update button
	    And User close the browser
	    