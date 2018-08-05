package nonfunctional;

/**
 *
 * @author afernandez
 */
public class CallbackNonFunctionalImpl implements CallbackNonFunctional {

    @Override
    public void onSuccess(String response) {
        System.out.println(response + " - Response processed for Heroes - Success");
    }

    @Override
    public void onError(String response) {
        System.out.println(response + " - Response processed for Heroes - Error");
    }
}
