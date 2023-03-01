@db
Feature:  Find the staff’s name, username and password who is working in the store that sells “Glass Dying” film

  Scenario Outline: Verify the homework second question's answer with DB
    Given "<first_name>" "<username>" "<password>" should_match_with_database_data
    Examples:

      | first_name      |username   |password                                 |
      |      Mike       |Mike       |8cb2237d0679ca88db6464eac60da96345513964 |
