package com.twotoasters.servos.util.ottoretrofit;

import com.twotoasters.servos.util.otto.BusProvider;

import java.io.IOException;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;

/**
 * A simple implementation of a Retrofit Client that posts two Otto events. The first event is posted
 * just prior to a request being executed, and the second event is posted immediately after the request
 * is completed.
 *
 * This implementation requires another Client be passed to it, as it is merely meant to be a wrapper
 * around a "real" Client class.
 */
public class NotifyingRetrofitClient implements Client {

    private Client wrappedClient;

    public NotifyingRetrofitClient(Client wrappedClient) {
        this.wrappedClient = wrappedClient;
    }

    @Override
    public Response execute(Request request) throws IOException {
        BusProvider.post(new RequestStartingEvent(request.getUrl()));
        Response response = wrappedClient.execute(request);
        BusProvider.post(new RequestFinishedEvent(request.getUrl()));
        return response;
    }

    /**
     * Otto Bus event classes
     */

    private static class RequestNotificationEventBase {

        private String endpoint;

        /**
         * Base constructor for request notifications.
         * @param endpoint The endpoint of the Request
         */
        public RequestNotificationEventBase(String endpoint) {
            this.endpoint = endpoint;
        }

        /**
         * Provides access to the corresponding Request's endpoint, in case a distinction needs to be
         * made between several different Requests prior to or after execution.
         *
         * @return the endpoint of the associated Request
         */
        public String getEndpoint() {
            return endpoint;
        }
    }

    public static class RequestStartingEvent extends RequestNotificationEventBase {

        public RequestStartingEvent(String endpoint) {
            super(endpoint);
        }

    }

    public static class RequestFinishedEvent extends RequestNotificationEventBase {

        public RequestFinishedEvent(String endpoint) {
            super(endpoint);
        }

    }
}
