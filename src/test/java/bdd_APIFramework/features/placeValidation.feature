@Validating
Feature: Validating Place API's

  Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>"
    When user calls "AddPlaceAPI" with "post" Http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "<name>" using "getPlaceApI"

    Examples:
      | name    |
      | AAhouse |
      | Bbhouse |






