package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateConnectBKMInitializeRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ConnectBKMInitialize extends IyzipayResource {

    private String htmlContent;

    public static ConnectBKMInitialize create(CreateConnectBKMInitializeRequest request, Options options) {
        ConnectBKMInitialize response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/bkm/initialize",
                getHttpHeaders(request, options),
                request,
                ConnectBKMInitialize.class)
                .getBody();
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}