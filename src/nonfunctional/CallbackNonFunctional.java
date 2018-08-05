package nonfunctional;

/**
 * This is a normal Java Interface that is not a functional interface as it has two abstract methods.
 *
 * @author afernandez
 */
public interface CallbackNonFunctional {

    void onSuccess(String response);

    void onError(String response);
}
