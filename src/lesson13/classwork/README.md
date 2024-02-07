# Javascript, Typescript


## Javascript

1. Change the `exercise1.html` file so that when a user clicks `Switch background color` button, 
background color of the whole document randomly changes.
Add an alert which pops up and `Background color was changed!` when it happens.
Hints: `document.getElementById`, `element.style.backgroundColor`, `alert()`.

2.  Change the `exercise2.html` file so that when a user clicks `Change header background color` button,
header background color is changed to `red`. If it is already red, it changes to `white`.
When a user presses `Change header text` button, change the header element text to say `eader text magically changed!`
instead of `My first heading`.
Hints: `document.getElementById`, `element.style.backgroundColor`, `element.textContent`.

3. Change the `exercise3.html` file so that when a user clicks `Roll` button,
**a new \<p\> element is added inside the \<div id="container"\>** element as such:

After 1 click:
```html
<div class="container">
    <p>Your roll: 1</p>
</div>
```
After 2 click:
```html
<div class="container">
    <p>You rolled: 1</p>
    <p>You rolled: 4</p>
</div>
```
Dice value should be randomly picked (random value between 1 and 6).
Hints: `document.getElementById`, `document.createElement()`, `document.appendChild()`.


4. Change the `exercise4.html` so that it is possible to add new animals to the list.
If nothing is entered into the text input, show alert with the message "Name cannot be empty!" and don't do anything else.
Hints: `element.value`, `element.textContent`, `document.createElement`.

5. (optional) Add quantity to each animal and display it (e.g. Parrots x2). If animal already exists in he list of animals,
increase the counter instead of adding a duplicate.

6. Investigate `typescript` folder. Write the code for adding new animals to the table in TS.
Handle case when empty values are specified, show respective `alert` messages. 
Optionally, prevent inserting duplicates (increase amount instead).