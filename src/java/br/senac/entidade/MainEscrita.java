package br.senac.entidade;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MainEscrita {
 
    public static void main (String args[]) throws FileNotFoundException, IOException{
        
        ArrayList<Pessoa> listaDePessoas = new ArrayList<Pessoa>();        
        Pessoa p = new Pessoa();
        p.setNome("Tarcísio");
        p.setSobreNome("Neves");
        
        listaDePessoas.add(p);
        
        p = new Pessoa();
        p.setNome("Marco");
        p.setSobreNome("Sena");
        listaDePessoas.add(p);
         
        p = new Pessoa();
        p.setNome("Luciane");
        p.setSobreNome("Benetti");
        listaDePessoas.add(p);
        
        File arquivoASerCriado = new File("meu_objeto_pessoa");
        FileOutputStream fout = new FileOutputStream(arquivoASerCriado);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
            
        oout.writeObject(listaDePessoas);
        oout.close();
        fout.close();
       
       Gson gson = new Gson();
       String json = gson.toJson(listaDePessoas);
        
       arquivoASerCriado = new File("meu_objeto_pessoa_json");
       fout = new FileOutputStream(arquivoASerCriado);
       DataOutputStream dout = new DataOutputStream(fout);
       dout.write(json.getBytes());
       dout.close();
       fout.close();
    }
}
