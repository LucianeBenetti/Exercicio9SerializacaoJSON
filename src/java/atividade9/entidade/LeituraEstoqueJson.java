/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade9.entidade;

import atividade9.dao.EstoqueDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author 80119050
 */
public class LeituraEstoqueJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       
        BufferedReader br = new BufferedReader (new FileReader("D:\\Users\\80119050\\Desktop\\Tecnólogo_ADS\\2019_1\\webProgramming\\exemplos\\serializacaoServicoJson\\estoqueJson"));
        Gson gson = new Gson();
        ArrayList<Estoque> listaFromJSON = (ArrayList<Estoque>)gson.fromJson(br,new TypeToken<ArrayList<Estoque>>(){}.getType());
        System.out.println("Lista JSON: "+ listaFromJSON);
    }

    public static ArrayList<Estoque> carregarEstoque() {
        ArrayList<Estoque> listaDeItens = new ArrayList<Estoque>();
        EstoqueDao estoqueDao = new EstoqueDao();
        listaDeItens = estoqueDao.listarEstoque();
        
        return listaDeItens;
    }
    
}
