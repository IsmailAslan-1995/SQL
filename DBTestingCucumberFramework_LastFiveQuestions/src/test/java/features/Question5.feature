@db
Feature: How much will store-2 earn when all the rented films are returned?

  Scenario Outline: Verify the homework fifth question's answer with DB
    Given "<total_earned_amount>" should_match_with_database_data
    Examples:

      | total_earned_amount |
      |      31059.92       |
