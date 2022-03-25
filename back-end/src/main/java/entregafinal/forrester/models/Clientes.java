package entregafinal.forrester.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import entregafinal.forrester.util.DateUtil;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    private String telefone;
    private String dataNascimento;
    private String cpf;
    private String data_nascimento;

    public Clientes() {
    }
    public Clientes(String nome, String email, String telefone, String data_nascimento, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
    }
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDataNascimento() {
        return data_nascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = data_nascimento;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
