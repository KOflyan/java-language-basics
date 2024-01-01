Lesson 6
========


1. Create an exception class called `IncorrectTimeException`.
2. Create a method called `getDepartureTime()`, which asks user for an input and then returns
the next time from the file `data/bus_times.txt`. User input must match the format `hh:mm` and if it does not match it,
an exception should be thrown (`IncorrectTimeException`).
Example:
* user input: `10:00`, expected output: `10:04`
* user input: `23.27`, expected output: `23:42`
* user input: `00:00`, expected output: `05:27`
