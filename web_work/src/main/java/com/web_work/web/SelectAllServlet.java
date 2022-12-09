package com.web_work.web;

import com.web_work.pojo.SoftWare;
import com.web_work.service.SoftwareService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private final SoftwareService service = new SoftwareService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 调用BrandService完成查询
        List<SoftWare> softWare = service.selectAll();

        //2. 存入request域中
        request.setAttribute("softwares",softWare);

        //3. 转发到brand.jsp
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}