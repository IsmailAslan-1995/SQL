@db
  Feature: How many movies have 3 copies in store 2?
    Scenario Outline: Verify the homework tenth question's answer with DB
      Given "<total_copy_number>" should_match_with_database_data
      Examples:
      |total_copy_number|
      |   257           |
