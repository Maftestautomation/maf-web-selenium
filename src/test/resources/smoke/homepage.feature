
Feature: Crateandbarrel System Smoke Test

  Background:
    Given I navigate to crateandbarrel homepage

    @smoke @MAF_01
  Scenario: Verify HomePage
    Then I check 'components' on HomePage
    And I check 'categories menu' on HomePage
    And I check 'footer' on HomePage

    @smoke @MAF_02
  Scenario: Verify Product Detail Page
    Given I navigate to product detail page
    Then I check product on product detail page
    And I check breadcrumb on product detail page

    @smoke @MAF_03
  Scenario: Verify Product Details section
    Given I navigate to product detail page
    When I expand product details section
    Then I should see details information on product detail page
    And I should see algonomy component on product detail page

    @smoke @MAF_04
  Scenario: Verify SKU component
    Given I navigate to product detail page
    When I expand product details section
    Then I should see product SKU on product detail page

    @smoke @MAF_05
  Scenario: Verify contact us section
    Given I navigate to product detail page
    Then I should see contact us component on product detail page
