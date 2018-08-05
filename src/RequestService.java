import java.util.concurrent.TimeUnit;

/**
 * The fake request service that supports a callback function.
 *
 * @author afernandez
 */
public class RequestService {

    private String url;

    public RequestService(String url) {
        this.url = url;
    }

    public void invoke(Callback callback) {

        // Simulate a request that takes 5 seconds to complete
        System.out.println("Before invoke request to URL: " + url);
        String response = runFakeRequest();
        System.out.println("After invoke request to URL: " + url);

        // The callback to run after the invoke is executed now with the response
        callback.thenRun(response);
    }

    private String runFakeRequest() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println("Something went wrong during the request invoke");
        }

        // Fake response retrieved from the fake request
        return String.format("URL [%s] request status 200", url);
    }
}
