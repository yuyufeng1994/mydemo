package top.yuyufeng.demo.servlet.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yuyufeng on 2017/5/25.
 */
@WebServlet(name = "Jsp2HtmlServlet",urlPatterns = "/jsp2HtmlServlet")
public class Jsp2HtmlServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userName","yuyu爱抚");
        request.getRequestDispatcher("WEB-INF/jsp/util/jsp2Html.jsp").forward(request,response);
    }
}
