package com.yak.yakzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 *  网关认证过滤器（Demo演示，实际根据自身业务考虑实现）
 */
@Component
public class MyFilter extends ZuulFilter {

    /**
     * per：路由之前，如实现认证、记录调试信息等
     * routing：路由时
     * post：路由后，比如添加HTTP Header
     * error：发生错误时调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器顺序，类似@Filter中的order
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if(token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
            ctx.setResponseBody("token cannot be empty");
        }
        return null;
    }
}
