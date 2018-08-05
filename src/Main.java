import improved.ImprovedRequestService;
import nonfunctional.CallbackNonFunctionalImpl;
import nonfunctional.NonFunctionalRequestService;

/**
 * Functions in languages like JavaScript and Python are first-class types so is possible to pass callbacks as you like
 * to other functions.
 *
 * This example program is meant to explain how to use the callback "pattern" in the Java language. Please, take into
 * account that it does not use other patterns that let developers simulate similar concepts like event listeners
 * implemented using Observer Pattern or Command Pattern.
 *
 * @author afernandez
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Create the callback function to be executed after the request is returned. This function has to be part of an
         * object.
         *
         * As in Java functions are not first-class types or objects, it is not possible to declare/return a function
         * and assign it to a variable nor pass functions as parameters to a method.
         */
        Callback runAfterRequest = new RunAfterRequest();

        // Invoke the request passing our callback object that will be run after the request has been finished
        RequestService requestServiceGoogle = new RequestService("API Google.com");
        requestServiceGoogle.invoke(runAfterRequest);

        System.out.println("----------------------------------------");

        /**
         * Another example to invoke a request service but this time using Java Lambdas. This is more similar to other
         * language like Python where we pass the function directly to the method parameter.
         *
         * The trick here is the invoke method has to receive a Callback interface that is a Java Functional Interface
         * that includes one and only one abstract method, so the compiler knows the method to add the logic passed
         * through lambda notation.
         */
        RequestService requestServiceBlizzard = new RequestService("API Blizzard.com");
        requestServiceBlizzard.invoke(response -> System.out.println(response + " - Response processed for Blizzard"));

        System.out.println("----------------------------------------");

        /**
         * Example invoking a request service that accepts onSuccess and onError callbacks.
         *
         * Request succeeding.
         */
        ImprovedRequestService requestServiceGamehouse = new ImprovedRequestService("API Gamehouse.com");
        requestServiceGamehouse.invoke(
                response -> System.out.println(response + " - Response processed for Gamehouse - Success"),
                response -> System.out.println(response + " - Response processed for Gamehouse - Error"),
                true
        );

        requestServiceGamehouse.invoke(
                response -> System.out.println(response + " - Response processed for Gamehouse - Success"),
                response -> System.out.println(response + " - Response processed for Gamehouse - Error"),
                false
        );

        System.out.println("----------------------------------------");

        /**
         * Different way to call two callbacks without using functional interfaces. There is a big disadvantage with
         * this approach: Every different implementation of onSuccess/onError needs a new Class implementing the different
         * logic for those methods. It can be avoided by using Anonymous classes but is too old style and non-readable.
         *
         * The functional solution is better, even though we need to create a functional interface for every different
         * kind of callback function we want to use, the implementations can always be coded using lambdas or normal
         * functions in the client to call them from the lambdas expressions.
         *
         * This is much cleaner and certainly won't be necessary to create more than 3 types of callbacks with its
         * functional interfaces in a normal application, not like in this non-functional case where we could end up
         * eventually with lots and lots of dirty anonymous classes or hundreds of class files to represent different
         * callback implementations.
         *
         * Request failing.
         */
        NonFunctionalRequestService requestServiceHeroes = new NonFunctionalRequestService("API Heroes.com");
        requestServiceHeroes.invoke(new CallbackNonFunctionalImpl(), true);
        requestServiceHeroes.invoke(new CallbackNonFunctionalImpl(), false);
    }
}
