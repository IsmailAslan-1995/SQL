@db
Feature:Find the exact address, the city and the country of store 2

  Scenario Outline:  Verify the homework third question's answer with DB

    Given "<address>" "<city>" "<country>" should match with database data

    Examples:
      |address            |city       |country    |
      |28 MySQL Boulevard |Woodridge  |Australia  |