# CSDS233-Assignment-4

## What it includes

My submission includes two main classes `Main` and `HashMap`. The `Main.java` file contains a `main` method that runs and displays example usage of the `HashMap` class. 

## How it works

The `HashMap` class functions as a dictionary that allows the user to specify two hash functions as lambdas at construction, meaning that a construction call may look like

```java
new HashMap<>(20, (k) -> k, (k) -> (7 - (k % 7)));
```

Where `(k) -> k` is the first has function and `(k) -> (7 - (k % 7))` is the hash function used for double hashing. For this hash map implementation it is assumed that keys are `int`s, so `k` must be an integer. 

Adding elements is simple, requiring a key and data with the `add` method. It is theoretically possible for the double hash method to iterate forever, so the method to add elements has requires a checked `HashMap.EndlessDoubleHashException` exception catch.

For my purpose I made the keys and values the same when inputting the keys given in part 1/2 of the assignment.

## Compiling and running

I've used Maven for compiling my project, so to bundle and compile the project on your own, you would simply run `mvn package`, and then `java -cp target/Assignment4-1.0-SNAPSHOT.jar org.main.Main` to execute the Main class's main method. Alternatively you could compile `Main.java` and `HashMap.java` as usual with javac and run it that way instead. This version of the project can be found at `https://github.com/404Wolf/CSDS233-Assignment-4/`

Alternatively, if using the `Submission.java` file, both classes have been combined, since it is unadvisable to have multiple top level classes in the same java file. In this case, you can compile with `javac Submission`, and run the compiled program with `java Submission`. This will print out the various stages of execution as the program runs.