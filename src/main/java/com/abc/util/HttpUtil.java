package com.abc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpUtil {

    private static PoolingHttpClientConnectionManager poolConnManager = null;
    private static RequestConfig requestConfig = null;

    static {
        try {
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", trustAllHttpsCertificates()).build();
            poolConnManager = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            poolConnManager.setMaxTotal(200);
            poolConnManager.setDefaultMaxPerRoute(2);
            int socketTimeout = 10000;
            int connectTimeout = 10000;
            int connectionRequestTimeout = 10000;
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();
        } catch (Exception e) {
            log.error("init http client pool failed", e);
        }
    }

    private static CloseableHttpClient getHttpClient() throws Exception {
        return HttpClients.custom()
                .setConnectionManager(poolConnManager)
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
    }

    public static JSONObject getJson(String url, Map<String, Object> params) throws Exception {
        HttpGet httpGet = new HttpGet(buildUrl(url, params));
        CloseableHttpResponse response = getHttpClient().execute(httpGet);
        return getJSONObject(response);
    }

    public static JSONObject postJson(String url, JSONObject body) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        HttpEntity entity = new StringEntity(body.toString(), "utf-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = getHttpClient().execute(httpPost);
        return getJSONObject(response);
    }

    private static JSONObject getJSONObject(CloseableHttpResponse response) throws Exception {
        int statusCode = response.getStatusLine().getStatusCode();
        String body = EntityUtils.toString(response.getEntity(), "utf-8");
        log.info("rsp status:{} body:{}", statusCode, body);
        return JSON.parseObject(body);
    }

    private static String buildUrl(String url, Map<String, Object> params) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        return uriBuilder.build().toString();
    }

    public static JSONObject postForm(String url, List<NameValuePair> params) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        HttpEntity entity = new UrlEncodedFormEntity(params, "utf-8");
        httpPost.setEntity(entity);
        HttpEntity entity1 = new UrlEncodedFormEntity(params, "utf-8");
        log.info("postForm: url: {}, body: {}", httpPost.getURI(), IOUtils.toString(entity1.getContent(), "utf-8"));
        CloseableHttpResponse response = getHttpClient().execute(httpPost);
        JSONObject rspObj = getJSONObject(response);
        log.info("rsp: {}", rspObj.toString());
        return rspObj;
    }

    private static SSLConnectionSocketFactory trustAllHttpsCertificates() {
        SSLConnectionSocketFactory socketFactory = null;
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, null);
            socketFactory = new SSLConnectionSocketFactory(sc, NoopHostnameVerifier.INSTANCE);
        } catch (NoSuchAlgorithmException e) {
            /*no op*/
        } catch (KeyManagementException e) {
            /*no op*/
        }
        return socketFactory;
    }

    static class miTM implements TrustManager, X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            //don't check
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            //don't check
        }
    }


}