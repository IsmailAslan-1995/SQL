@db
Feature: How much will store-2 earn when all the rented films are returned?

  Scenario Outline: Verify the homework first question's answer with DB
    Given "<customer_id>" "<first_name>" "<last_name>" "<amount>"  should match with the result

    Examples:

      | customer_id |first_name|last_name|amount|
      |116	        |Victoria  |Gibson   |11.99 |
      |195	        |Vanessa   |Sims	 |11.99 |
      |592	        |Terrance  |Roush	 |11.99 |
      |204	        |Rosemary  |Schmidt	 |11.99 |
      |237	        |Tanya	   |Gilbert	 |11.99 |
      |13	        |Karen	   |Jackson	 |11.99 |
      |591	        |Kent	   |Arsenault|11.99 |
      |362	        |Nicholas  |Barfield |11.99 |