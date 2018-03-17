/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.projeto2web.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cefetrj.br.projeto2web.model.Aluno;
import java.util.ArrayList;

/**
 * Servlet referente ao formulário da página index.html
 * @author vinicius
 */
@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {

    /**
     * Método responsável por mostrar no browser a tabela com os dados dos alunos.
     * @param req veriavel do tipo HttpServletRequest que pega as requisições
     * @param resp um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do GET não puder ser tratado
     * @throws IOException se um erro de entrada ou saída for detectado quando o servlet lida com o pedido GET
     */
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("student");
            double p1 = Double.parseDouble(req.getParameter("P1"));
            double frequency = Double.parseDouble(req.getParameter("frequency"));
            double finalWork = Double.parseDouble(req.getParameter("finalWork"));
            double classProjects = Double.parseDouble(req.getParameter("classProjects"));
            double pF = Double.parseDouble(req.getParameter("PF"));
            Aluno aluno = new Aluno(name, frequency, p1, finalWork, classProjects, pF);
            resp.getWriter().print("<!DOCTYPE html>");
            resp.getWriter().print("<html>");
                resp.getWriter().print("<head>");
                    resp.getWriter().print("<meta charset=\"ISO-8859-1\">");
                    resp.getWriter().print("<title>Histórico dos alunos de PSW</title>");
                resp.getWriter().print("</head>"); 
                resp.getWriter().print("<body>");
                    resp.getWriter().print("<table border=1>");
                        resp.getWriter().print("<tr>");
                            resp.getWriter().print("<td><b>Nome do Aluno</b></td>");
                            resp.getWriter().print("<td><b>Nota 1</b></td>");
                            resp.getWriter().print("<td><b>Frequência</b></td>");
                            resp.getWriter().print("<td><b>Trabalho final</b></td>");
                            resp.getWriter().print("<td><b>Trabalhos em aula</b></td>");
                            resp.getWriter().print("<td><b>Prova final</b></td>");
                            resp.getWriter().print("<td><b>Situação</b></td>");
                        resp.getWriter().print("</tr>");
            if(req.getServletContext().getAttribute("aluno") == null) {
                req.getServletContext().setAttribute("aluno", aluno);
                        resp.getWriter().print("<tr>");
                            resp.getWriter().print("<td>"+aluno.getName()+"</td>");
                            resp.getWriter().print("<td>"+aluno.getNota1()+"</td>");
                            resp.getWriter().print("<td>"+aluno.getFrequency()+"</td>");
                            resp.getWriter().print("<td>"+aluno.getFinalWork()+"</td>");
                            resp.getWriter().print("<td>"+aluno.getClassProject()+"</td>");
                            resp.getWriter().print("<td>"+aluno.getpF()+"</td>");
                            resp.getWriter().print("<td>"+aluno.situation()+"</td>");
                        resp.getWriter().print("</tr>");
                    resp.getWriter().print("</table>");
                resp.getWriter().print("</body>");
            resp.getWriter().print("</html");
            }
            else {
                ArrayList<Aluno> alunos = new ArrayList<Aluno>();
                if (req.getServletContext().getAttribute("alunos") != null) {
                    alunos.addAll((ArrayList<Aluno>) req.getServletContext().getAttribute("alunos"));
                }else {
                    alunos.add((Aluno) req.getServletContext().getAttribute("aluno"));
                }
                alunos.add(aluno);
                for (int i = 0; i < alunos.size(); i++) {
                        resp.getWriter().print("<tr>");
                            resp.getWriter().print("<td>"+alunos.get(i).getName()+"</td>");
                            resp.getWriter().print("<td>"+alunos.get(i).getNota1()+"</td>");
                            resp.getWriter().print("<td>"+alunos.get(i).getFrequency()+"</td>");
                            resp.getWriter().print("<td>"+alunos.get(i).getFinalWork()+"</td>");
                            resp.getWriter().print("<td>"+alunos.get(i).getClassProject()+"</td>");
                            resp.getWriter().print("<td>"+alunos.get(i).getpF()+"</td>");
                            resp.getWriter().print("<td>"+alunos.get(i).situation()+"</td>");
                        resp.getWriter().print("</tr>");
                }
                req.getServletContext().setAttribute("alunos", alunos);
                    resp.getWriter().print("</table>");
                resp.getWriter().print("</body>");
            resp.getWriter().print("</html");
            }
            
        }catch (Exception e) {
            resp.getWriter().print("Dados Invalidos.");
            return;
        }
    }
    
    /**
     * Métod que recebe os dados do formulario e redireciona para o método GET.
     * @param req um objeto HttpServletRequest que contém a solicitação feita pelo cliente do servlet.
     * @param resp um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do POST não puder ser tratado
     * @throws IOException  se um erro de entrada ou saída for detectado quando o servlet manipula o pedido
     */
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
