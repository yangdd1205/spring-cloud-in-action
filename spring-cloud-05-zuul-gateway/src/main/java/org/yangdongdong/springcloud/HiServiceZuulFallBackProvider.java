package org.yangdongdong.springcloud;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class HiServiceZuulFallBackProvider implements FallbackProvider {

    /**
     * 指定要熔断的服务名字
     */
    @Override
    public String getRoute() {
        return "hi";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return null;
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("service error. retry...".getBytes("UTF-8"));
            }

            /**
             * 状态文本信息
             */
            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }

            /**
             * 自定义响应的状态
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            /**
             * 自定义响应的状态码
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }

            @Override
            public void close() {

            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("service error...111.... retry...".getBytes("UTF-8"));
            }

            /**
             * 状态文本信息
             */
            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }

            /**
             * 自定义响应的状态
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            /**
             * 自定义响应的状态码
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }

            @Override
            public void close() {

            }
        };
    }

}
