package com.web_work.web;

import com.web_work.pojo.SoftWare;
import com.web_work.service.SoftwareService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailServlet")
public class DetailServlet extends HttpServlet {
    private final SoftwareService service = new SoftwareService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String name = request.getParameter("name");
        //2. 调用service查询
        SoftWare softWare = service.selectByName(name);
        //3. 存储到request中
        request.setAttribute("software",softWare);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/detail.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}