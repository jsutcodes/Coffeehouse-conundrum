# Coffeehouse-conundrum

Code challenge:

Write a software program to help the coworkers fairly decide who should pay for coffee. Keep in mind
that not all drinks cost the same, so your solution should account for the cost differences to ensure
fairness.

Please [read the Design Decisions](docs/DESIGN.md)
or [read the prompts to see AI usage](docs/PROMPTS.md)


## How to Build the Project
To build the Jar run the mvnw script if on windows
Prereq: Have Java 21 installed and maven.  
```
PS ~\git\Coffeehouse-conundrum\coffeehouse-scheduler> ./mvnw clean package
```

This will use maven to build the jar and in this example can be found in the following directory (named coffeehouse-scheduler-0.0.1-SNAPSHOT.jar):
```
PS ~\git\Coffeehouse-conundrum\coffeehouse-scheduler\target> ls

    Directory: C:\Users\jorsu\git\Coffeehouse-conundrum\coffeehouse-scheduler\target


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
d-----         4/12/2026   4:54 PM                classes
d-----         4/12/2026   4:54 PM                generated-sources
d-----         4/12/2026   4:54 PM                generated-test-sources
d-----         4/12/2026   4:54 PM                maven-archiver
d-----         4/12/2026   4:54 PM                maven-status
d-----         4/12/2026   4:54 PM                test-classes
-a----         4/12/2026   4:54 PM       61983964 coffeehouse-scheduler-0.0.1-SNAPSHOT.jar
```

## Running the Application: Coffeehouse Scheduler
To run the Application go to your terminal and run:
```
 java -jar .\coffeehouse-scheduler-0.0.1-SNAPSHOT.jar
```
double clicking the jar will also run it (but as a background process. Highly suggested to run in the terminal to avoid port collisions when forgetting to kill the jar before running again.)


Things to note:

A simple, efficient tool to manage group coffee orders and calculate a fair rotation for who pays each round.


#### Getting Started
The application comes pre-populated with a default Menu and a list of Orders. You can use these to test the functionality immediately or clear them to start fresh.


1. Customize the Menu: Add your local coffee shop's items and prices, or remove the defaults.
2. Manage Orders: Add your coworkers and assign them items from the menu. You can easily add or remove items for each person.
3. Calculate the Schedule: Once your group and orders are set, click "Calculate Pay Schedule."

#### The Pay Schedule
After calculating, a Pay Schedule section will appear at the bottom of the page. This table displays:
- Rounds: How many rounds are needed to settle everyone's tabs.
- Payer Order: A fair rotation of who should pay for each round.
- Balances: The current standing of each person's balance as the rounds progress.

Note: After Customizing the Menu, when the jar is terminated, the DB will be reset to the original configurations, so any custom DB items will disappear.

## Assumptions
```
1. New Members either adding or dropping would affect the debt schedule, so whoever drops out either needs to pay out/ or everyone agrees to forget all debt and create a new schedule.
2. Skipping Turns could affect the schedule so for simple solution we assume no one skips and everyone is present every single day.
3. Solution will Attempt to solve the Schedule in 90 days. Program will notify how long it would take to solve the problem if over 90.
4. At the end of the 90 Days all payers will "square up" and start the schedule back at round 1 with 0 debt balances again to keep payments fair.
5. The same as above: But if the schedule seems to repeat itself it will terminate early (assuming other will pay out and repeat the schedule).  
```

## HOW-TO: Input data
### 📋 Managing Your Coffeehouse Data

<img width="872" height="1018" alt="demo" src="https://github.com/user-attachments/assets/b7bee30f-2d9f-47b5-b47b-25d77efa393f" />

#### 1. Adding Custom Items
**Menu Items**
* Locate the **Menu** card on the right side of the screen.
* Click the **"Add Item"** button at the bottom of the list.
* Enter the item name, size, and price in the modal and save to update the master menu.

**Assigning Items to People**
* In the **Orders** table, find the person you wish to update.
* Click the **"Items (#)"** button to expand their personal order list.
* Use the **dropdown menu** that appears below their name to select a drink from the master menu.
* Click the green **"Add Item"** button next to the dropdown to instantly add it to their tab.

#### 2. Removing Items and People
**Removing Specific Drinks**
* Expand a person's order by clicking **"Items (#)"**.
* Click the red **minus (−) or (×)** button next to the specific item you want to delete. The "Total Cost" for that person will update automatically.

**Removing People**
* In the main **Orders** table, locate the red **(×)** button on the far right of the person's row.
* Click it and confirm the prompt to completely remove that person and their entire order from the session.

**Removing Menu Master Items**
* In the **Menu** card, click the small red **(×)** next to any drink price to permanently remove that option from the coffeehouse offerings.
