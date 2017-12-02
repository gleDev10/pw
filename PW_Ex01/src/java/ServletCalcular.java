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
@WebServlet(urlPatterns = {"/ServletCalcular"})
public class ServletCalcular extends HttpServlet {

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

        String nome = request.getParameter("nome");
        String salario = request.getParameter("salario");
        String sexo = request.getParameter("sexo");

        double sal = 0;

        try (PrintWriter out = response.getWriter()) {

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
                if (sexo == null || sexo.isEmpty()) {
                    out.print("Selecione o sexo do usuario");
                    erro = true;

                }
                if (!erro) {
                    if (sexo.equals("M")) {
                        out.print("Prezado Sr. " + nome + ", <br/>");
                    } else {
                        out.print("Prezada Sra. " + nome + ", <br/>");
                    }

                    double imposto = 0;

                    if (sal >= 4664.69) {
                        imposto = (sal * 0.275) - 869.36;
                    } else if (sal >= 3751.06) {
                        imposto = (sal * 0.225) - 636.13;
                    } else if (sal >= 2826.66) {
                        imposto = (sal * 0.15) - 354.80;
                    } else if (sal >= 1903.99) {
                        imposto = (sal * 0.075) - 142.80;
                    }

                    out.print("O imposto a pagar é de R$" + imposto + "<br/><br/>");
                    
                    
                    out.print("<table border=\"1\">");
                    out.print("<tr>");
                    out.print("<td>Base de Cálculo</td>");
                    out.print("<td>Alíquota</td>");
                    out.print("<td>Parcela a Deduzir</td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                    out.print("<td>Até 1903.98</td>");
                    out.print("<td>Isento</td>");
                    out.print("<td>   - </td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                    out.print("<td>De 1903.99 a 2826.65</td>");
                    out.print("<td>7.5</td>");
                    out.print("<td>R$ 142.80 </td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                    out.print("<td>De 2826.66 a 3751.05</td>");
                    out.print("<td>15%</td>");
                    out.print("<td>R$ 354.80 </td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                    out.print("<td>De 3751.06 a 4664.68</td>");
                    out.print("<td>22.5%</td>");
                    out.print("<td>R$ 636.13 </td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                    out.print("<td>Acima de 4664.69</td>");
                    out.print("<td>27.5%</td>");
                    out.print("<td>R$ 869.36 </td>");
                    out.print("</tr>");
                    
                    
                    
                   
                    
                    out.print("</table>");
                    
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
    }

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
