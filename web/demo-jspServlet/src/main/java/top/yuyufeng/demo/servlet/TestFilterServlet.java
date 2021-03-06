package top.yuyufeng.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yuyufeng on 2017/4/24.
 */
@WebServlet(name = "TestFilterServlet",urlPatterns = "/filter/testFilterServlet")
public class TestFilterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestFilterServlet.doPost");
        request.getRequestDispatcher("/WEB-INF/jsp/test/testFilter.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestFilterServlet.doGet");
        this.doPost(request,response);
    }
}
