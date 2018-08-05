/**
 * Functional interface for Callbacks.
 *
 * @author afernandez
 */
@FunctionalInterface
public interface Callback {

    void thenRun(String response);
}