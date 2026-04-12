# DESIGN

Upon reading the programming challenge it became clear that to find the solution, The best course of action was to implement some type of scheduler.
Not only that but to find a sequential payment responsibility schedule (i.e. something along the lines of a [weighted] round robin scheduler).

The first step is to work through a simple example on paper and begin creating a TDD in order to prove out my logic.

### Steps for simplest solution
```
1. List each individuals costs.
2. Calculate Sum of Total Bill.
3. Calculate Shared % for each Person.
4. Whatever fraction is what someone pays.
```
#### Example

Using the steps above, a simplest test case of the solution:

```
1. Given 3 People (A, B, and C), Where A cost is 1$, B cost is 3$ and C cost is 6$.
2. Sum of Total Bill = 1$+3$+6$ = $10.
3. Shared Percentage: A = 10%, B = 30%, C = 60%.
4. Solution: If Schedule is followed for 10 days:
┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐
│ C ││ B ││ C ││ B ││ C ││ B ││ C ││ A ││ C ││ C │
└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘

Note: Order does not matter
At the end of the 10 days the debt is 0 as this example is perfectly even scenario.
```

This allowed me to start with my Assumptions:
```
1. Assume Whole numbers only (for now. Question how decimals and java floating math may affect the solution)
2. There will need to be some sort of Rounding protocol (Can either round up to whole number or do whoever pays takes the extra payment.)
3. New Members either adding or dropping would affect the debt schedule, so whoever drops out either needs to pay out/ or everyone agrees to forget all debt and create a new schedule.
4. Skipping Turns could affect the schedule so for simple solution we assume no one skips and everyone is present every single day.
```
