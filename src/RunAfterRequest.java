/**
 * Function to run after a request has been finished and response has been returned.
 *
 * @author afernandez
 */
public class RunAfterRequest implements Callback {

    @Override
    public void thenRun(String response) {
        System.out.println(response + " - Response processed for Google");
    }
}
