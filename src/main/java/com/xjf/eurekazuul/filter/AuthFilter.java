package com.xjf.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器
 * @author xjf
 * @date 2019/4/3 14:51
 */
public class AuthFilter extends ZuulFilter {
    private static String TOKEN_VALUE = "xjf";

    @Override
    public String filterType() {
        //在请求被路由之前调用
        System.out.println("在请求被路由之前调用");
        return "pre";
    }

    @Override
    public int filterOrder() {
        //filter执行顺序，通过数字指定，优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //获取请求的参数
        String token = request.getParameter("token");

        //如果有token参数并且token值为xjf,才进行路由
        if (StringUtils.isNotBlank(token) && TOKEN_VALUE.equals(token)){
            //对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("code",1);
        }else {
            //不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            HttpServletResponse response = ctx.getResponse();
            response.setHeader("content-type","text/html;charset=utf8");
            ctx.setResponseBody("网关认证失败，停止路由");
            ctx.set("code",0);
        }

        return null;
    }
}
