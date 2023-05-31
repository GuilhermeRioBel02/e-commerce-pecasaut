package br.unitins.ecommerce.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    private String nomeImagem;

    @OneToMany
    @JoinTable(name = "usuario_endereco",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;

    @OneToMany
    @JoinTable(name = "usuario_telefone",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "telefone_id"))
    private List<Telefone> telefones;

    @OneToMany
    @JoinTable(name = "usuario_listadesejo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "listadesejo_id"))
    private List<Produto> listaDesejo;



    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getCpf() {

        return cpf;

    }

    public void setCpf(String cpf) {

        this.cpf = cpf;

    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {

        this.enderecos = enderecos;

    }

    public List<Telefone> getTelefones() {

        return telefones;

    }

    public void setTelefones(List<Telefone> telefones) {

        this.telefones = telefones;

    }

    public List<Produto> getListaDesejo() {

        return listaDesejo;

    }

    public void setListaDesejo(List<Produto> listaDesejo) {

        this.listaDesejo = listaDesejo;

    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
}
