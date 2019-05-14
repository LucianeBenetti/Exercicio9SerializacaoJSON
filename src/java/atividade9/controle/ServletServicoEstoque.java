/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade9.controle;

import atividade9.dao.EstoqueDao;
import atividade9.entidade.Estoque;
import atividade9.entidade.LeituraEstoqueJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 80119050
 */
public class ServletServicoEstoque extends HttpServlet {

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
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
           //out.println("<!DOCTYPE html>");
           
           String tipoDeDado = this.getServletConfig().getInitParameter("tipoDeDado");
                      
           if(tipoDeDado.equals("JSON")){
               
               response.setContentType("application/json;charset=UTF-8");
               ArrayList<Estoque> listaDeItens = LeituraEstoqueJson.carregarEstoque();
               System.out.println(listaDeItens);               
               
               Gson gson = new GsonBuilder().create();
               String listaDeItensEmjson = gson.toJson(listaDeItens);               
               out.println(listaDeItensEmjson);
//                BufferedReader br = new BufferedReader (new FileReader("D:\\Users\\80119050\\Desktop\\Tecnólogo_ADS\\2019_1\\webProgramming\\exemplos\\serializacaoServicoJson\\estoqueJson.json"));
//                Gson gson = new Gson();
//                ArrayList<Estoque> listaFromJSON = (ArrayList<Estoque>)gson.fromJson(br,new TypeToken<ArrayList<Estoque>>(){}.getType());
//                out.println("Lista JSON: "+ listaFromJSON);

           }
           else if (tipoDeDado.equals("xml")){
               System.out.println("Arquivo XML!");
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
