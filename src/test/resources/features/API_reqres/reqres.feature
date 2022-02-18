#language: en

  Feature: GET API with diff set of data

    @CHROME @FIREFOX @REGRESION @SMOKE @ID001
    Scenario Outline: Test API with data driven in https://reqres.in page
      Given the URI of the environment by testng .xml file
      When Find a specific user by "<Name>" or by a "<Length>"
      And post a user through a JsonObject with "<LeaderName>" and "<Job>"
      And  look for a "<NotExist>" user and other filters
      Then assert separately the first "<Name>" on the list and all the fields for specific person with "<FirstName>" and "<LastName>"

      Examples:
        | Name   | NotExist   | Length | FirstName | LastName | LeaderName | Job    |
        | George | Jose       | 4      | Janet     | Weaver   | Morpheus   | Leader |
        | George | Anibal     | 4      | Emma      | Wong     | Neo        | Master |





      