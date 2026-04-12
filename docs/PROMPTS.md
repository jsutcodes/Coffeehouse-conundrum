# PROMPTS

lists any prompts or queries from AI tools while developing the application and explanation of how they contributed to the solution.


### Query: Generate a java method that takes in an array of Objects and prints them in a box as a visual representation of data.
Result:
```
  Allows for the printing and easier debugging of return from the scheduler.
  i.e.
  ┌───┐
  │ C │
  └───┘
```  

### Query: If i have a List of Person objects and that object has a List of MenuItems that have a Price, how can i use streams to sum the total of all the menuItems for all Persons.
Result:
```
Allows the smaller totalBillSum instead of having double forloops.

int totalBillSum = list.stream()
    .flatMap(person -> person.getItems().stream())
    .filter(Number.class::isInstance)
    .map(Number.class::cast)
    .mapToInt(Number::intValue)
    .sum();

```

### Query: how to calculate the exact number of days the cycle will last based on the inputs before you even start the loop?
Result:
```
Allows for code generation of the predictCycleLength() which will tell how many cycles it would take to reach zero.
```

### Query: How can I add an UI with bootstrap to a spring boot project?
```
Allowed for the WebJar recommendation and steps to include UI in packaged Jar.  
Note: the Ui was primarily generated using AI queries. Examples being: how to Add the table of items in the Order Table.
I will not list all the small queries that were used to generate and help create the UI to save space in this document.
```
