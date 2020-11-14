Feature: Calculator

    Scenario: Calculator adds two numbers
        Given a calculator
        When adding the numbers 2 and 3
        Then calculator returns a 5

    Scenario: Calculator multiplies two number
        Given a calculator
        When multiplying the numbers 2 and 2
        Then calculator returns a 4