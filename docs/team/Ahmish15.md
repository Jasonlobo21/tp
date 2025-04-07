# Overview

HealthBud is a CLI-based fitness logging assistant designed to help users track and improve their personal health goals.
It supports logging of meals, workouts, water intake, cardio sessions, and personal bests, while also offering
intelligent features such as progress status and workout recommendations.

# Summary of Contributions
Implemented all the Add commands and their respective parser classes. Also implemented the Search and BMI Command and their parser classes. Also implemented a Time parser to make sure the time is in the correct format.
## Code contributed
[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=0)

## Enhancements implemented
Split the AddLogsCommand into 5 different classes to make it more modular and easier to read. Added the SearchCommand and BMICommand classes to allow users to search for their logs and calculate their BMI respectively. I also played a key role in implementing testing for the BMI, search and List commands. implemented a Time parser to make sure the time is in the correct format.

## Contributions to the UG

added the following commands to the user guide: SearchCommand and BMICommand

## Contributions to the DG

BMI Sequence Diagram and Storage Class Diagram. I also talked about the BMI command and Storage class in the DG.

## Contributions to team-based tasks
revamped our add commands by splitting them into their logic and parsing respectively. This made it easier to read and understand. I also actively participated in discussing how we should design other functions in the TP and also gave key inputs on how to structure the entire project to make it more OOP. Incorporated the Time parser into the add commands, and also implemented limits and checks to the various inputs in the TP to make sure all inputs make sense and inputs that do not make sense are caught by exceptions. I also did the test cases for BMI command, List Command and Search Command. After the Mock Pe I helped with fixing many of the bugs that were raised.

## Review/mentoring contributions
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/225
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/224
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/222
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/138
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/135
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/133
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/132
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/131
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/130
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/104
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/87
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/76
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/75
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/69
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/67
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/65
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/55

## Contributions beyond the project team:

Reviewed other teams Developer guide and gave them input on how to make it better.
https://github.com/nus-cs2113-AY2425S2/tp/pull/22/files/b767c44f47a64d590587c55ed2c14c0a9d5578f3