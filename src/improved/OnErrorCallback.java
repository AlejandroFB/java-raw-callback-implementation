package improved;

/**
 * @author afernandez
 */
@FunctionalInterface
public interface OnErrorCallback {

    void thenRun(String response);
}
