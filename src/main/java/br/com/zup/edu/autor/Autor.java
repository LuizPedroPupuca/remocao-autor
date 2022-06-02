package br.com.zup.edu.autor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 2500)
    private String descricao;

    public Autor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor() {
    }

    public Long getId() {
        return id;
    }
}
