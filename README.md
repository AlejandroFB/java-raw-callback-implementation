# Custom implementation of the callback pattern in core Java

Functions in languages like JavaScript and Python are first-class types so it is possible to pass callbacks/functions 
as you like to other functions.

This example code is meant to explain how to use and implement from scratch the callback pattern in the Java language. 
Please, take into account that it does not use other patterns that let developers simulate similar concepts like event 
listeners implemented using Observer Pattern or Command Pattern.

Includes implementations with classes and Java Lambdas using functional interfaces. Additionally, there is an
additional implementation with the onSuccess and onError callbacks that run depending on the invoke result.