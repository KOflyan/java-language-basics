# Lesson 3 exercises

---


## EX 1 - Loops
1. Define a for loop which prints out numbers from 1 to 10.
2. Define a for loop which loops over a given string and prints all its characters by one like so: `Character: <character>`.
For example, when given a string `abcd`, your program should print out the following:
```
Character: a
Character: b
Character: c
Character: d
```
3. Define a for loop which prints out even numbers until 36.
4. Define a while loop which generates a random number and prints it out until the number is divisible by 5.
5. Write a program which will generate a random number and then will ask the user to guess it until it is guessed correctly.

## EX 2 - Loops + Arrays, lists, sets

1. Define an array which holds names of 3 fruits. Print the contents of the array.
2. Define a method `String[] deletefromArray(String[] array, String value)` which would delete value from the given array.
3. Define a method `boolean existsInArray(String[] array, String value)` which would check if the given value exists in the array.
4. Define a method `String[] addToArray(String[] array, String value, int index)` which adds a value to the specified array under the specified index.
5. Define an empty array of size 10, which will hold `char`. Populate the array with the characters `v`, `k`, `a`, `s`, `d`. Sort the array alphabetically.
6. Repeat the same exercises with `ArrayList`
7. Create an array list with values `1,1,2,3,4,4,5,6`. Convert it to set. Try adding duplicate records to the set, print its contents afterwards.

## EX 3 - Maps

1. Define a `HashMap` called `studentGrades` which holds student names and respective grades.
1.1 Add records to it.
1.2 Delete records from it.
1.3 Find a grade for specific student.
2. Iterate over the previously created `Map` and filter out students with grades >= 4. Save those students to the list `topPerformingStudents` and print it out.
