package com.longge.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longge.domain.Province;
import com.longge.service.ProvinceService;
import com.longge.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author longge
 * @create 2019-12-02 下午4:29
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        //响应结果
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
