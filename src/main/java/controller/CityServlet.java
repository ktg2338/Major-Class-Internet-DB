package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDAO;
import dao.CustomerDAO;
import dao.ProductDAO;
import dto.CityDTO;
import dto.CustomerDTO;
import dto.ProductDTO;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
          PrintWriter out=response.getWriter();    
          CityDAO dao=new CityDAO(); 
          List<CityDTO> list=dao.listcity(); 
          
          out.print("<html><body>");
          out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
          out.print("<td>지역</td><td>상품명</td><td>수량</td></tr>");
         
         for (int i=0; i<list.size();i++){
        	 CityDTO cityVO=(CityDTO) list.get(i);
            String warehouse_name=cityVO.getWarehouse_name();
            String product_name= cityVO.getProduct_name();
            String quantity=cityVO.getQuantity();
            out.print("<tr><td>"+warehouse_name+"</td><td>"+
            					product_name+"</td><td>"+
            					quantity+"</td></tr>");        
          }
          out.print("</table></body></html>");
    }
          
    }
    