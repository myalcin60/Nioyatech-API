@UserServices @Team
Feature: User Services  Parts


  @GetAllUsers @Smoke
  Scenario: User gets all users list

    Given user set the url for users list
    When user send the request and get the response for users list
    Then user assert the users list is succesfull


  @GetAllUsersNegative
  Scenario: Users can not get users list if they dont have readall permission

    Given  user set the url for users list with different user
    When user send the request and get the response for users list with different user
    Then user assert the users list is succesfull and different with different user


  @UpdateAUser @Smoke
  Scenario: Update a user

    Given  user set the url to update a user
    When send the request and get the response to update a user
    Then user assert the user is updated as expected


  @Update_for_non_existing_ID
  Scenario: Update a user for invalid ID
    Given  user set the url for users list
    When send the request and get the response with nonexistingID
    Then user assert the user is updated as expected with nonexistingID


  @GetUsersWithGroupId
  Scenario Outline: Users shouldnt get any userlist if they dont have read all permission
##( I dont have any user with read all permission)
    Given  user set the url for users list with "<groupId>" and with no readall permission
    When user send the request and get the response for users list  without readall permission
    Then user assert the status code is 403


    Examples:
      | groupId |
      | 1       |
      | 2       |
      | 3       |

  @GetAUser
    # two positive and one negative scenario in the same future
  Scenario Outline: User can get one user with userid

    Given user set the url for one user "<userid>"
    When user send the request and get the response for one user
    Then user assert the user is shown up succesfull

    Examples:
      | userid    |
      | 35      |
      | 36       |
      | 987654321 |




  @DeleteAUser @Smoke
  Scenario Outline: User can  delete a user with userid

    Given user set the url for delete one user "<userid>"
    When user send the request and get the response for delete one user
    Then user assert the user is deleted succesfully

    Examples:
      | userid |
      | 189    |


  @DeletNonExistingUser
  Scenario Outline: User can not  delete non existing  user

    Given user set the url for delete one user "<userid>"
    When user send the request and get the response for delete one user
    Then user assert the status code is user not found

    Examples:
      | userid    |
      | 987654321 |

  @CreateUserRegisterManually  @Smoke
  Scenario: user creates a user
    Given user sets the url to create a user
    When send the request and get the response to create a user
    Then user verifies that user is created succesfully


  @CreateUserRegisterManuallyWithSameDataAgain  @Smoke
  Scenario: user can not  create a user with the same email
    Given user sets the url to create a user
    When send the request and get the response to create a user
    Then user verifies that user is not created and get not acceptable message








