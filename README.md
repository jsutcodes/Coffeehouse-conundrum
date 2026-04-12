# Coffeehouse-conundrum

Code challenge:

Write a software program to help the coworkers fairly decide who should pay for coffee. Keep in mind
that not all drinks cost the same, so your solution should account for the cost differences to ensure
fairness.

Please [read the Design Decisions](docs/DESIGN.md)
or [read the prompts to see AI usage](docs/PROMPTS.md)


## How to Build the Project

TBD...

## Running the Application



## Assumptions
```
1. New Members either adding or dropping would affect the debt schedule, so whoever drops out either needs to pay out/ or everyone agrees to forget all debt and create a new schedule.
2. Skipping Turns could affect the schedule so for simple solution we assume no one skips and everyone is present every single day.
3. Solution will Attempt to solve the Schedule in 90 days. Program will notify how long it would take to solve the problem if over 90.
4. At the end of the 90 Days all payers will "square up" and start the schedule back at round 1 with 0 debt balances again to keep payments fair.
```

## HOW-TO: Input data
