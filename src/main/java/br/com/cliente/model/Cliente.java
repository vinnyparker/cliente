package br.com.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author vinny em 07/08/2020
 * @project cliente
 **/

@Entity
public class Cliente extends AbstractModel<Long> {

    @Column(name = "nome", length = 250, nullable = false)
    private String nome;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "cnpjcpf", length = 14)
    private String cnpjCpf;

    @Column(name = "telefone", length = 13)
    private int telefone;

    @Column(name="datanascimento")
    private Date dataNascimento;

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

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjcpf) {
        this.cnpjCpf = cnpjcpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
