package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
          PrintWriter out=response.getWriter();    
          ProductDAO dao=new ProductDAO(); 
          List<ProductDTO> list=dao.listproduct(); 
          


          
          out.print("<html><body>");
          out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
          out.print("<td>아이디</td><td>제품명</td><td>스펙</td><td>standard cost</td><td>list price</td></tr>");
         
         for (int i=0; i<list.size();i++){
        	 ProductDTO productVO=(ProductDTO) list.get(i);
            String id=productVO.getId();
            String name = productVO.getName();
            String des=productVO.getDes();
            String cost=productVO.getCost();
            String price = productVO.getPrice();
            out.print("<tr><td>"+id+"</td><td>"+
                                name+"</td><td>"+
                                des+"</td><td>"+
                                cost+"</td><td>"+
                                price+"</td></tr>");    
         }
          out.print("</table></body></html>");
    }
          
    }
    