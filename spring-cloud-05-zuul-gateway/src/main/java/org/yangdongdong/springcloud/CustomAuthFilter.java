package org.yangdongdong.springcloud;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomAuthFilter extends ZuulFilter {

    private static final String TOKEN_AUTH = "123456";

    /**
     * filter 具体的逻辑
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        if (uri.equals("/hi-service/upload") || uri.equals("/zuul/hi-service/upload")) {
            return ctx;
        }
        String token = request.getHeader("x-auth-token");
        if (StringUtils.isEmpty(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("no token");
            return null;
        }
        if (!TOKEN_AUTH.equals(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token auth fail");
            return null;
        }
        ctx.addZuulRequestHeader("userInfo", "{\"name\":\"Tom\",\"age\":18}");
        return ctx;
    }

    /**
     * filter 是否执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter 的优先级，值越小优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * filter 执行的时机
     *
     * pre 表示在请求被路由之前执行
     * 
     * route 表示在请求被路由中执行
     * 
     * post 表示在请求被路由之后执行
     * 
     * error 表示在请求发生错误时执行
     * 
     * static 特殊的 Filter 具体的可以看 StaticResponseFilter，它允许从 Zuul 本身生成响应，而不是将请求转发到源。
     */
    @Override
    public String filterType() {
        return "pre";
    }

}
