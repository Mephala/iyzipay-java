package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveBkmRequest;

public class Bkm extends PaymentResource {

    private String token;
    private String callbackUrl;

    public static Bkm retrieve(RetrieveBkmRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/bkm/auth/detail",
                getHttpHeaders(request, options),
                request,
                Bkm.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
