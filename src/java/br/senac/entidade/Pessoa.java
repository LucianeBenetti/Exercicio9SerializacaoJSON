/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.entidade;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Pessoa implements Serializable {
    private String nome;
    private String sobreNome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;

    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sobreNome=" + sobreNome + '}';
    }
    
    

    
}
