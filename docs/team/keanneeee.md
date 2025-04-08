# Overview
HealthBud is a CLI-based fitness logging assistant designed to help users track and improve their personal health
goals. It supports logging of meals, workouts, water intake, cardio sessions, and personal bests, while also offering
intelligent features such as progress status and workout recommendations.

# Summary of Contributions
## Code contributed

[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=2)

## Enhancements implemented

I took charge of the implementations of the Goal and Water functions. I was focused on designing the features such
that it would be user-friendly all the while not compromising on the user's experience as well as giving them the full 
experience that our app was meant to deliver.

I also was involved in a few major revamps that our team decided for the projects, such as the increase in teh OOP-ness
of the project by splitting the parser and command execution functions. Our project compartmentalizes functionality in
a sense that we have a function which handles its own logic (command classes), while the input is getting parsed by a 
separate, exclusive function. This drastically improved readability of our code and made our whole project much easier 
to understand.

## Contributions to the UG

I added the Goal and Water sections of the UG.

## Contributions to the DG

I added the Goals Section as well as the Architecture Diagram.

## Contributions to team-based tasks

I ensured that there was in depth testing being done for all our functions. Specifically:
- Wrote comprehensive tests for add goals and water.
- Helped to review and refactor existing test cases to align with our new parser-logic separation

In terms of the entire project:
- I reviewed parts of our teams code and spotted a few bugs which I proceeded to fix
- Reviewed and linked PRs to branch such that the entire process ran smoothly

## Review/mentoring contributions
Here are some of the PRs I reviewed:

https://github.com/AY2425S2-CS2113-W13-4/tp/pull/230 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/145 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/125 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/118 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/116 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/97 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/93 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/88 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/64 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/58 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/15 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/14 <br>
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/13 <br>

Working on HealthBud has been a deeply enriching experience, both technically and personally. From developing core features 
like the Goals and Water modules to driving key architectural decisions such as our parser-command separation, I’ve had 
the opportunity to contribute meaningfully to the team’s success.

Beyond coding, I made it a point to support my teammates through code reviews, bug fixes, and test coverage improvements. 
I’m proud to have played a part in shaping a well-structured, maintainable project, and even prouder of how we worked together 
to turn ideas into a robust application. This project has taught me the value of clean design, collaboration, and taking 
initiative — lessons I’ll carry forward into future endeavors.
