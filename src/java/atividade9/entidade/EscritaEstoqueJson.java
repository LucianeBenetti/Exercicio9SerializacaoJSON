package atividade9.entidade;

import atividade9.dao.EstoqueDao;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 80119050
 */
public class EscritaEstoqueJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Estoque> listaDeItens = new ArrayList<Estoque>();
        EstoqueDao estoqueDao = new EstoqueDao();
        listaDeItens = estoqueDao.listarEstoque();
        //System.out.println(listaDeItens);
        
        Gson gson = new Gson();
        String listaDeItensEmjson = gson.toJson(listaDeItens);               
        System.out.println(listaDeItensEmjson);
        
        File arquivoASerCriado = new File("D:\\Users\\80119050\\Desktop\\Tecnólogo_ADS\\2019_1\\webProgramming\\exemplos\\serializacaoServicoJson\\estoqueJson");
        FileOutputStream fout = new FileOutputStream(arquivoASerCriado);
        DataOutputStream dout = new DataOutputStream(fout);
        dout.write(listaDeItensEmjson.getBytes());
        dout.close();
        fout.close();
    }
    
}
