@Navigation
Feature: Navigation Bar
  To see the subpages
  Without logging in
  I can click the navigation bar links

  Background: I am on www.freerangetesters.com without logging in.
    Given I navigates to to www.freerangetesters.com

  Scenario Outline: I can access the subpages though the navigation bar
#    Given I navigates to to www.freerangetesters.com
    When I go to the <section> using the navigation bar
    Examples:
      | section   |
      | Cursos    |
      | Recursos  |
      | Udemy     |
      | Mentorías |
      | Blog      |

  @Courses
  Scenario: Courses are presented correctly to potential customers
#    Given I navigates to to www.freerangetesters.com
    When I go to the Cursos using the navigation bar
    And I select Introduccion al testing

  @Plan @Courses
  Scenario: Users can select a plan when signing up
#    Given I navigates to to www.freerangetesters.com
    When I select elegir Plan
    Then The user can validate the options in the checkout page
