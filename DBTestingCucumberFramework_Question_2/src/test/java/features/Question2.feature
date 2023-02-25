@db
Feature:  Find the total sales of each staff for each month

  Scenario Outline: Verify the homework second question's answer with DB
    Given "<month>" "<total_sales>" "<staff_id>" should match with database data

    Examples:
      |month    |total_sales  |staff_id  |
      |August   |	2892      |	1        |
      |February |	85        |	1        |
      |July     |	3342      |	1        |
      |June     |	1163      |	1        |
      |May      |	558       |	1        |
      |August   |	2794      |	2        |
      |February |	97        |	2        |
      |July     |	3367      |	2        |
      |June     |	1148      |	2        |
      |May      |	598       |	2        |