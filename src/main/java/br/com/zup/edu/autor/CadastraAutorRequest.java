package br.com.zup.edu.autor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastraAutorRequest {

    @NotBlank
    private String nome;

    @Size(max = 2500)
    private String descricao;

    public CadastraAutorRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public CadastraAutorRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel(){
        return new Autor(nome, descricao);
    }

}
