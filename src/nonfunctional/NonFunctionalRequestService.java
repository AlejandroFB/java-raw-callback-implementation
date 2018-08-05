package nonfunctional;

import improved.OnErrorCallback;
import improved.OnSuccessCallback;

import java.util.concurrent.TimeUnit;

/**
 * Fake equest service that does not use functional capabilities.
 *
 * @author afernandez
 */
public class NonFunctionalRequestService {

    private String url;

    public NonFunctionalRequestService(String url) {
        this.url = url;
    }

    public void invoke(CallbackNonFunctional callback, boolean success) {

        // Simulate a request that takes 5 seconds to complete
        System.out.println("Before invoke request to URL: " + url);
        String response = runFakeRequest();
        System.out.println("After invoke request to URL: " + url);

        // Set up manually this to
        if (success) {
            // The callback to run after the invoke is executed now with the response
            callback.onSuccess(response);
        } else {
            callback.onError(response);
        }
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
