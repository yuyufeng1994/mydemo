package top.yuyufeng.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yuyufeng on 2017/4/25.
 */
public class TestXMLFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("TestXMLFilter.destroy");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("TestXMLFilter.doFilter");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
