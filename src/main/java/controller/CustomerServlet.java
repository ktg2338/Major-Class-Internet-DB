package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.ProductDAO;
import dto.CustomerDTO;
import dto.ProductDTO;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
          PrintWriter out=response.getWriter();    
          CustomerDAO dao=new CustomerDAO(); 
          List<CustomerDTO> list=dao.listproduct(); 
          
          out.print("<html><body>");
          out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
          out.print("<td>아이디</td><td>이름</td><td>주소</td><td>사이트</td><td>신용 한도</td></tr>");
         
         for (int i=0; i<list.size();i++){
        	 CustomerDTO customerVO=(CustomerDTO) list.get(i);
            String id=customerVO.getId();
            String name = customerVO.getName();
            String des=customerVO.getAddress();
            String cost=customerVO.getWebsite();
            String price = customerVO.getCreditlimit();
            out.print("<tr><td>"+id+"</td><td>"+
                                name+"</td><td>"+
                                des+"</td><td>"+
                                cost+"</td><td>"+
                                price+"</td></tr>");        
          }
          out.print("</table></body></html>");
    }
          
    }
    