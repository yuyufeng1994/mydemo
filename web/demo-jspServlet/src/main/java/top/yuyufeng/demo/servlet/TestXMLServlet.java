package top.yuyufeng.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author yuyufeng
 * @date 2017/4/24
 */
public class TestXMLServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestXMLServlet.doPost");
        request.getRequestDispatcher("/WEB-INF/jsp/test/testXML.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestXMLServlet.doGet");
        this.doPost(request,response);
    }
}
