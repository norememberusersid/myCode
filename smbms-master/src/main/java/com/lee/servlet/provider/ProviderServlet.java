package com.lee.servlet.provider;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.lee.pojo.Provider;
import com.lee.pojo.User;
import com.lee.service.provider.ProviderService;
import com.lee.service.provider.ProviderServiceImpl;
import com.lee.util.Constants;
import com.mysql.jdbc.StringUtils;

/**
 * 供应商Controller,实现servlet复用
 * Created by baidou on 2020/8/21.
 */
public class ProviderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //通过路由调用相应的业务
        String method = request.getParameter("method");
        System.out.println("method--->" + method);

        if (method != null && method.equals("query")) {
            this.query(request, response);
        } else if (method != null && method.equals("add")) {
            this.add(request, response);
        } else if (method != null && method.equals("view")) {
            this.getProviderById(request, response, "providerview.jsp");
        } else if (method != null && method.equals("modify")) {
            this.getProviderById(request, response, "providermodify.jsp");
        } else if (method != null && method.equals("modifysave")) {
            this.modify(request, response);
        } else if (method != null && method.equals("delprovider")) {
            this.delProvider(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * 删除供应商信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void delProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("proid");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (!StringUtils.isNullOrEmpty(id)) {
            ProviderService providerService = new ProviderServiceImpl();
            int flag = providerService.deleteProviderById(id);
            if (flag == 0) {//删除成功
                resultMap.put("delResult", "true");
            } else if (flag == -1) {//删除失败
                resultMap.put("delResult", "false");
            } else if (flag > 0) {//该供应商下有订单，不能删除，返回订单数
                resultMap.put("delResult", String.valueOf(flag));
            }
        } else {
            resultMap.put("delResult", "notexit");
        }
        //把resultMap转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    /**
     * 修改供应商信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");
        String id = request.getParameter("id");
        Provider provider = new Provider();
        provider.setId(Integer.valueOf(id));
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProFax(proFax);
        provider.setProAddress(proAddress);
        provider.setProDesc(proDesc);
        provider.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        provider.setModifyDate(new Date());
        boolean flag = false;
        ProviderService providerService = new ProviderServiceImpl();
        flag = providerService.modify(provider);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/jsp/provider.do?method=query");
        } else {
            request.getRequestDispatcher("providermodify.jsp").forward(request, response);
        }
    }

    /**
     * 通过id获取供应商
     *
     * @param request
     * @param response
     * @param url
     * @throws ServletException
     * @throws IOException
     */
    private void getProviderById(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        String id = request.getParameter("proid");
        System.out.println("id-->" + id);
        Provider provider = null;
        if (!StringUtils.isNullOrEmpty(id)) {
            ProviderService providerService = new ProviderServiceImpl();
            provider = providerService.getProviderById(id);
            request.setAttribute("provider", provider);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    /**
     * 添加供应商
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag = false;
        String proCode = request.getParameter("proCode");
        String proName = request.getParameter("proName");
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");

        Provider provider = new Provider();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProFax(proFax);
        provider.setProAddress(proAddress);
        provider.setProDesc(proDesc);
        provider.setCreatedBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        provider.setCreationDate(new Date());

        ProviderService providerService = new ProviderServiceImpl();
        flag = providerService.add(provider);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/jsp/provider.do?method=query");
        } else {
            request.getRequestDispatcher("provideradd.jsp").forward(request, response);
        }
    }

    /**
     * 获取供应商列表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String queryProName = request.getParameter("queryProName");
        String queryProCode = request.getParameter("queryProCode");
        if (StringUtils.isNullOrEmpty(queryProName)) {
            queryProName = "";
        }
        if (StringUtils.isNullOrEmpty(queryProCode)) {
            queryProCode = "";
        }
        List<Provider> providerList = new ArrayList<Provider>();
        ProviderService providerService = new ProviderServiceImpl();
        providerList = providerService.getProviderList(queryProName, queryProCode);
        request.setAttribute("providerList", providerList);
        request.setAttribute("queryProName", queryProName);
        request.setAttribute("queryProCode", queryProCode);
        request.getRequestDispatcher("providerlist.jsp").forward(request, response);
    }

}
