@db
Feature: Which countries have made higher payments than 800$?(with their payment amount in desc order)

  Scenario Outline: Verify the homework fourth question's answer with DB
    Given "<country_id>" "<country>" "<total_payment_amount>" should match with database data
    Examples:

      | country_id | country          | total_payment_amount|
      | 44	       |India	          |6034.78              |
      | 23	       |China	          |5251.03              |
      | 103        |United States     |3685.31              |
      | 50	       |Japan	          |3122.51              |
      | 60	       |Mexico	          |2984.82              |
      | 15	       |Brazil	          |2919.19              |
      | 80         |Russian Federation|2765.62              |
      | 75         |Philippines       |2219.70              |
      |97	       |Turkey	          |1498.49              |
      |45	       |Indonesia         |1352.69              |
      |69	       |Nigeria	          |1314.92              |
      |6	       |Argentina         |1298.80              |
      |92	       |Taiwan	          |1155.10              |
      | 85	       |South Africa	  |1069.46              |
      |46	       |Iran	          |877.96               |
      |102	       |United Kingdom    |850.96               |