package com.nosto.currencyconvertorapp.util;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class HttpClient {

    public OkHttpClient createClient() {
        return new OkHttpClient().newBuilder().build();
    }

    public Response getRequest(Map<String, String> headerValues, String url, Map<String, String> pathParams) throws IOException {

        OkHttpClient okHttpClient = createClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        if (pathParams != null) {
            for (Map.Entry<String, String> entry : pathParams.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }

        Headers headers = Headers.of(headerValues);

        String baseURL = urlBuilder.build().toString();
        Request request = new Request.Builder().url(baseURL).headers(headers).build();

        return okHttpClient.newCall(request).execute();
    }

}
