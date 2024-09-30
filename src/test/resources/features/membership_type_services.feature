@MembershipTypeServices @Team
Feature: Memberships Type Services


  Scenario: The User List all MemberShip type services
    Given Set the url and Send Get request for MemberShip Type Services ("/membership-type")
    When Verify, that response size is 2
    Then Verify, that the status code 200


  Scenario: The User Lists all MemberShip type services (with content value = slim)
    Given Set the url and Send Get request for MemberShip Type Services ("/application/2/membership-type?content=slim")
    When Verify, that response id's are '5','6'
    Then Verify, that the status code 200


  Scenario: The User Lists all MemberShip type services (with content value = full).
    Given Set the url and Send Get request for MemberShip Type Services ("/application/2/membership-type?content=full")
    When Verify, that response name's are 'Company Membership','Guest Membership'
    Then Verify, that the status code 200


  Scenario: The User Lists all MemberShip type services (with content value = fullTree).
    Given Set the url and Send Get request for MemberShip Type Services ("/application/2/membership-type?content=fullTree")
    When Verify, that Company Membership has 14 and Guest Membership has 1 users
    And Verify, that Company Membership with Guest Membership has 15 users
    Then Verify, that the status code 200

