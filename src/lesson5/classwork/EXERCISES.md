Lesson 5
========

EX 1
-----


1. Define class `Animal` with the following methods and constructor:
```
void speak  -- prints 'I cannot!'
void greet  -- prints '{name} greets you!'
boolean isFriendly() -- returns `isPet`
toString() 

Animal(String name, boolean isPet)
```

2. Define class `Dog` which extends `Animal` with the following methods (constructor is the same):
```
void roll() -- print "**rolling**"
void speak() -- print "Bark!"
```

3. Define class `Dolphin` which extends `Animal` with the following methods and constructor:

```
boolean isFriendly() -- smart or playful
void greet() -- "*water splash*"
void perform_jump() -- if playful, print "*Jumps*". If smart, print "I will jump.. for food.". 
In other cases print "No.".
```

4. Create different animal objects and call the methods.


EX 2
-----

1. Imagine that you need to build a system which would sort and filter packages to be delivered to customers.
You would need to consider priority of customers, addresses and so on.
Investigate folder `packagecenter`.
2. Create a class named `Customer`. This class should have the following properties with getters & setters:
```
    /**
     * Customer priority.
     * 0 < priority < 1000
     */
    private int priority;
    /**
     * Customer name.
     */
    private String name;
    /**
     * Customer address.
     */
    private String address;
```

1 static function, which checks if the customer is valid (not null, priority in correct range, name and address are not empty):

```
public static boolean isValid(Customer c) {
}
```

2. Create a class `Package` with the following properties & constructors (don't forget getters and setters):
```
    /**
     * Package number printed on page.
     */
    protected String packageNumber;
    /**
     * Package width in cm.
     */
    protected int width;
    /**
     * Package height in cm.
     */
    protected int height;
    /**
     * Package sender.
     */
    protected Customer sender;
    /**
     * Package receiver.
     */
    protected Customer receiver;

    /**
     * Package constructor.
     *
     * @param packageNumber Package number printed on package
     * @param width         Package width in cm
     * @param height        Package height in cm
     */
    public Package(String packageNumber, int width, int height) {
        this.packageNumber = packageNumber;
        this.width = width;
        this.height = height;
    }
```
And one method `protected int getTotalPriority()` which returns the sum of sender and receiver priorities.

3. Create a class `PremiumPackage` which would extend `Package class`.
It should have 1 additional property: `private int priority`, as well as getter & setter for it.

4. Create a class `OrderedPackageFilter` which implements interface `PackageFilter`. `isValid(Package p)` 
method should check the following:
* package is not null
* package width and height are bigger than 0
* if package is a `PremiumPackage` instance (hint: `instanceof`), then priority is in correct range (0 and 1000 inclusive)
* both receiver and sender are valid

5. Create a class `OrderedPAckageProvider` which implements interface `OrderedPackageProvider`.
* `getNextPackage()` should return the package with the maximum priority from the list of packages and remove ift from the list.
If there are premium packages in the list, those should come first. E.g. if you have 4 packages:
```
1. regular, priority 300
2. premium, priority 200
3. regular, priority 800
4. premium, priority 500
```

then the order of the packages should be as follows: 4, 2, 3, 1.

* `addPackage(Package p)` should add package to the list if 
it satisfies the `PackageFilter` conditions, does not already exist and 
* `findAllPackagesByReceiver` should return all packages which have the specified receiver set
* `findAllPackagesBySender` should return all packages which have the specified sender set