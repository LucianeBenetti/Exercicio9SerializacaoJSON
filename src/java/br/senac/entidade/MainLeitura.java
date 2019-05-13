package br.senac.entidade;


import br.senac.entidade.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainLeitura {
 
    public static void main (String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{

//        File f = new File("meu_objeto_pessoa");
//        FileInputStream fin = new FileInputStream(f);
//        ObjectInputStream oin = new ObjectInputStream(fin);
//        ArrayList<Pessoa> p = (ArrayList<Pessoa>) oin.readObject();
//        System.out.println(p);
//        oin.close();
//        fin.close();
        
        
//        f = new File("meu_objeto_pessoa_json");
//        fin = new FileInputStream(f);
//        DataInputStream din = new DataInputStream(fin);
//        byte[] dadosArquivo = new byte[din.available()];
//        din.read(dadosArquivo);
//        String jsonString = new String(dadosArquivo);
        
        BufferedReader br = new BufferedReader (new FileReader("meu_objeto_pessoa_json"));
        Gson gson = new Gson();
        ArrayList<Pessoa> listaFromJSON = (ArrayList<Pessoa>)gson.fromJson(br,new TypeToken<ArrayList<Pessoa>>(){}.getType());
        System.out.println("Lista JSON: "+ listaFromJSON);
        
        
    }    
    
    public static ArrayList<Pessoa> carregaPessoas() throws FileNotFoundException, IOException{
        
        ArrayList<Pessoa> lista= new ArrayList<Pessoa>();
        
        Pessoa p= new Pessoa();
        p.setNome("Rafael");
        p.setSobreNome("Queiroz Gonçalves");
        
        lista.add(p);
        
        p= new Pessoa();
        p.setNome("Marco");
        p.setSobreNome("Sena");
        lista.add(p);
         
        p= new Pessoa();
        p.setNome("Luciane");
        p.setSobreNome("Benetti");
        lista.add(p);
         
        return lista;
    }
    
}
