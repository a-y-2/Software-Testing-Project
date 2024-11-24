# Software-Testing-Project
Introduction to Mutation Testing
What is Mutation Testing?
Mutation testing is a software testing technique used to evaluate the quality and effectiveness of test cases. It involves modifying the source code in small ways, known as "mutants," to simulate potential errors or bugs. The primary goal is to determine whether the existing test cases can detect these changes, thereby ensuring they are robust enough to catch real-world issues.
How Mutation Testing Works
Mutation Generation: Small changes, such as replacing an operator (+ with -) or altering a condition (== with !=), are introduced into the code. These changes simulate typical coding mistakes.
Test Execution: The test suite is run against the mutated code.
Result Analysis:
If the test suite fails for a mutant, the mutant is considered "killed," indicating the tests are effective.
If the test suite passes, the mutant "survives," suggesting a gap in the tests.
Purpose of Mutation Testing
Traditional code coverage metrics like line or branch coverage indicate how much of the code is executed during tests but do not ensure the quality of the test cases. Mutation testing addresses this limitation by measuring how well the tests detect faults, making it an excellent indicator of test suite effectiveness.
Benefits of Mutation Testing
Improved Test Coverage: Highlights weak or missing test cases, encouraging comprehensive coverage.
Fault Detection: Simulates real-world bugs to ensure the system behaves correctly under potential error conditions.
Confidence in Code Quality: Enhances confidence in the reliability of the software by ensuring robust testing practices.
Challenges of Mutation Testing
Performance Overhead: Running tests against multiple mutants can be time-consuming.
False Positives: Certain mutants may survive due to equivalent functionality, not because of inadequate tests.
Complexity: Requires specialized tools and setup, especially for large projects.
Role of Mutation Testing in This Project
In this project, mutation testing is applied to the banking system to:
Evaluate the effectiveness of both unit and integration tests.
Identify untested edge cases or scenarios.
Ensure the reliability of critical banking operations, such as transactions and account management, by exposing potential weaknesses in the test suite.
By combining JUnit for unit testing, Mockito for mocking in integration tests, and PIT for mutation testing, the project demonstrates a comprehensive approach to testing and validating software quality.
In Mutation Testing in Python,we used Mutpy to perform the testing.Following are the operators in python:
AOR
LOR
COR
CBR
CR
VR
SD
LBR
FCR
ER
UOI
BCR


Unit Testing and Integration Testing
Unit Testing
Unit testing focuses on testing individual components or units of code, such as methods or classes, in isolation. The goal is to ensure that each unit performs as expected.
Characteristics of Unit Testing
Isolated Testing: Tests only one class or method at a time, without dependencies on other parts of the system.
Early Detection: Helps identify bugs early in the development lifecycle.
Automated Frameworks: Frameworks like JUnit in Java enable developers to write automated tests for each unit efficiently.
Advantages of Unit Testing
Fault Localization: Errors are easier to identify because tests are isolated to specific methods or classes.
Improved Code Quality: Encourages developers to write modular and testable code.
Regression Safety: Helps catch errors introduced during code changes.

Integration Testing
Integration testing ensures that multiple components or units work together as expected. It focuses on testing the interaction between modules, APIs, or services in the system.
Characteristics of Integration Testing
End-to-End Validation: Verifies workflows across multiple units or subsystems.
Dependency Management: Includes handling real or mocked external dependencies (e.g., databases, services).
Realistic Scenarios: Tests real-world use cases, such as fund transfers between accounts.
Advantages of Integration Testing
Identifies Interface Issues: Catches bugs that arise due to mismatched or poorly integrated components.
Ensures Cohesion: Validates the proper functioning of interconnected modules.
Increases Reliability: Reduces risk in system-wide failures.


TOOLS USED
PIT (Pitest):
PIT is a mutation testing tool for Java that evaluates the effectiveness of test cases by introducing small changes (mutations) in the code. It tests whether existing test cases can detect and fail on these mutations. If a mutation is detected by a test (killed), it signifies strong test coverage. If it survives, it indicates areas of weak testing. PIT integrates seamlessly with build tools like Maven and Gradle and supports frameworks like JUnit and TestNG, making it highly efficient for Java projects.
MUTPY:
MUTPY is a mutation testing tool designed for Python projects. It mutates Python source code by altering operators, conditions, or functions and runs the test suite to verify its robustness. Similar to PIT, it categorizes mutations as killed or survived based on test performance. MUTPY works with popular Python testing frameworks like unittest and pytest, enabling developers to assess and improve test quality.
Comparison:
Both tools serve the same purpose of enhancing test quality but are designed for different languages. While PIT is highly optimized for Java projects and integrates with build tools, MUTPY provides similar capabilities for Python with standalone execution.




BANKING MANAGEMENT SYSTEM (JAVA)
Lines of code 
	Main.java : 83
	Bank.java : 40
	BankAccount.java : 68
	Transaction.java : 36
	BankingSystemTest.java : 157
	IntegrationTest.java : 92
	Total : 476 lines 






Gaussian Elimination Method (Python)
           Lines of Code
            gaussian_elimination.py: 73
            test_gaussian_elimination.py: 56



Jacobi Iteration Method  (Python)
          Lines of Code
           jacobi_iteration.py: 205
          test_jacobi_iteration.py: 68
	

LU Decomposition   (Python)
Lines of Code
lu_decomposition.py: 112
test_lu_decomposition.py: 59


     



CONTRIBUTION OF TEAM MEMBERS 
Ayushi Prasad : Java Testing
Drishti Gupta : Python Testing
