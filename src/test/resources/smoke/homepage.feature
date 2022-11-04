@browser
Feature: Search Product Smoke Test

  Background:
    Given I login with username 'test@test.com' and password 'test'

  @smoke
  Scenario: Heading to website
    Given I navigate to Amazon Home Page

  @smoke
  Scenario: Search a product from search bar
    Given I navigate to Amazon Home Page
    When I search 'macbook' product from search bar
    And I select a product from search result


  @wip
  Scenario Outline: Check products are displayed on result page
    Given I navigate to Amazon Home Page
    When I search '<product>' product from search bar
    Then I check the '<result>'

    Examples:
      |product               |result
      |macbook               |true
      |iphone                |true
      |s3234%dg+$sdgxdvxd    |false

  @smoke
  Scenario: Search a product from search bar
    Given I search blabla