/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Máquina
 */
@WebServlet(urlPatterns = {"/SalarioLiquido"})
public class SalarioLiquido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String salario = request.getParameter("salario");
            
            double sal = 0;
         boolean erro = false;
         
         
          if (nome == null || nome.isEmpty()) {
                out.print("Preencha o nome do usuário");
                erro = true;
            }
         if (salario == null || salario.isEmpty()) {
                out.print("Preencha o salário do usuário");
                erro = true;
            } else {
                try {
                    sal = Double.parseDouble(salario);
                } catch (Exception e) {
                    out.print("Preencha um salario válido<br/>");
                    erro = true;
                }   
            double desconto = 0;
            
            
            if(sal >= 5531.32){
                desconto = sal - 608.44;
            }
            else if(sal >= 2765.67){
                desconto = (sal * 0.11);  
                 sal -=desconto;
            }else if (sal >=1639.59){
                 desconto = sal * 0.09;
                 sal -=desconto;
            }else{
                desconto = sal * 0.05;  
                sal -=desconto;
            }
            
         
          
            out.print("O seu salario líquido é: "+sal+"<br/>");
            out.print("Desconto de: "+desconto );
         }
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
