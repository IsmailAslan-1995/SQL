@db
Feature:What are the names of top 5 categories, that have more than 150 films in inventory of store-1?

  Scenario Outline: Verify the homework third question's answer with DB
    Given "<top_5_categories>" "<film_number>" should_match_with_database_data
    Examples:

      | top_5_categories      |film_number    |
      |Action                 |	169           |
      |Sports                 |	163           |
      |Drama                  |	162           |
      |Animation              |	161           |
      |Family                 |	157           |