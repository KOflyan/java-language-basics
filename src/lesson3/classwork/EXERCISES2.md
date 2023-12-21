# Lesson 3.1 exercises


## EX 4 - Strings


1. Given two strings, append them together (known as "concatenation") and return the result. However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".

```
conCat("abc", "cat") → "abcat"
conCat("dog", "cat") → "dogcat"
conCat("abc", "") → "abc"
```

2. Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".

```
lastTwo("coding") → "codign"
lastTwo("cat") → "cta"
lastTwo("ab") → "ba"
```

3. Return the number of times that the string "hi" appears anywhere in the given string.

```
countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2
```

4. Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).

```
equalIsNot("This is not") → false
equalIsNot("This is notnot") → true
equalIsNot("noisxxnotyynotxisi") → true
```

# EX 5 - Arrays

1. Given an array of ints, return the sum of the first 2 elements in the array. If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.

```
sum2([1, 2, 3]) → 3
sum2([1, 1]) → 2
sum2([1, 1, 1, 1]) → 2
```

2. Given an array of ints, return true if the array contains no 1's and no 3's.

```
lucky13([0, 2, 4]) → true
lucky13([1, 2, 3]) → false
lucky13([1, 2, 4]) → false
```

3. Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.

```
tripleUp([1, 4, 5, 6, 2]) → true
tripleUp([1, 2, 3]) → true
tripleUp([1, 2, 4]) → false
```


# EX 6 - Maps

1. Given a map of food keys and their topping values, modify and return the map as follows: if the key "ice cream" has a value, set that as the value for the key "yogurt" also. If the key "spinach" has a value, change that value to "nuts".

```
topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
topping2({"yogurt": "salt"}) → {"yogurt": "salt"}
```

2. Modify and return the given map as follows: if exactly one of the keys "a" or "b" has a value in the map (but not both), set the other to have that same value in the map.

```
mapAB3({"a": "aaa", "c": "cake"}) → {"a": "aaa", "b": "aaa", "c": "cake"}
mapAB3({"b": "bbb", "c": "cake"}) → {"a": "bbb", "b": "bbb", "c": "cake"}
mapAB3({"a": "aaa", "b": "bbb", "c": "cake"}) → {"a": "aaa", "b": "bbb", "c": "cake"}
```

3. The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.

```
wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
wordCount(["c", "c", "c", "c"]) → {"c": 4}
```

4. Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.

```
wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
```