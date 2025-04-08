# Overview
HealthBud is a CLI-based fitness logging assistant designed to help users track and improve their personal health goals.
It enables users to log various health metrics—such as meals, workouts, water intake, personal bests, and cardio sessions—using an intuitive command interface. 
The application incorporates robust command parsing, in-memory log management, and persistent storage via text files, all structured in a modular design to support easy maintenance and future enhancements.


# Summary of Contributions
## Code contributed

[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=1)

## Enhancements implemented

I laid the groundwork of the project by implementing the base log classes, which provide a foundation for meal, workout, and other log types to be extended. I implemented the LogList class to manage the collection of logs in memory. 
I then created the meal logs as a proof-of-concept and template—enabling my teammates to later implement their own versions of log types for workout, cardio, and other categories. 
Additionally, I developed the storage system that reads from and writes to a text file, ensuring data persistence across sessions.

On the user interface side, I implemented the Ui component to display information to users in a clean and organized manner. 
In terms of feature development, I contributed to the meal log functionalities by implementing delete, list, and clear commands, as well as a find feature that was later merged into the search functionality.

Furthermore, I created the ParserParameters utility, which utilizes hashing to allow users to input parameters (e.g., /t, /d) in any order, improving the flexibility of the command parsing process.

In addition to these individual contributions, I continuously sought ways to make the codebase less messy and more concise. 
I have actively contributed to refining both my own code and that of my teammates, ensuring that the overall quality of our project remains high.

## Contributions to the UG

I contributed significantly to the UG by writing and standardizing the sections on delete, clear and meal logs. 
My focus was on ensuring that these sections were clear, concise, and consistent, which greatly improved the overall quality and readability of our documentation.


## Contributions to the DG

For the DG, I added and updated the class diagrams for the UI component. 
I also provided detailed sequence diagrams illustrating the execution flow of commands – for example, 
I included a sequence diagram for the "delete meal" command that explains step-by-step how the delete operation is performed.

## Contributions to team-based tasks
I actively participated in team discussions, contributed to code reviews, and assisted teammates in refining their code. 
My efforts included collaborating on design decisions and ensuring that our project documentation was consistent and maintained a high quality across the board.

I played a key role in ensuring that our team always adhered to the principles of OOP. 
Specifically, I revamped the command classes and wrote comprehensive tests for the add meal, delete, and clear functionalities, achieving 100% code coverage.

In terms of project management, I took ownership of initiating the project and setting a clear direction, ensuring that my teammates were aligned with the overall vision. 
I also ensured smooth merges with no loss of data and provided ongoing support with tools such as SourceTree and GitHub whenever teammates encountered difficulties.

## Review/mentoring contributions
Links to PRs reviewed, instances of helping team members in other ways.

- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/239
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/238
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/235
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/232
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/231
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/229
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/227
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/223
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/219
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/218
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/217
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/216
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/215
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/214
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/204
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/142
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/139
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/137
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/134
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/129
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/123
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/113
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/110
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/90
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/73
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/70
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/66
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/52
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/51
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/47
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/38
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/29
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/22
- https://github.com/AY2425S2-CS2113-W13-4/tp/pull/4


## Contributions beyond the project team:
I reviewed other teams' code and developer guides, offering constructive tips for improvement, and provided help during tutorial sessions to assist other groups.

https://github.com/nus-cs2113-AY2425S2/tp/pull/47/files/abeed9984adccad0e277d2158466071b33b8a665..d4f97488ed10b50e5ba6bd156a3b3802bd05cc85