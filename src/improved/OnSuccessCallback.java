package improved;

/**
 * @author afernandez
 */
@FunctionalInterface
public interface OnSuccessCallback {

    void thenRun(String response);
}
