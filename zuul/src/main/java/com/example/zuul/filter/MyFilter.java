package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul网关过滤
 * @author Don
 * @date 2021/7/23.
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 过滤器的类型。可选值有：
     * pre - 前置过滤
     * route - 路由后过滤
     * error - 异常过滤
     * post - 远程服务调用后过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 同种类的过滤器的执行顺序。
     * 按照返回值的自然升序执行。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回boolean类型。代表当前filter是否生效。
     * 默认值为false。
     * 返回true代表开启filter。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run方法就是过滤器的具体逻辑。
     * return 可以返回任意的对象，当前实现忽略。（spring-cloud-zuul官方解释）
     * 直接返回null即可。
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
