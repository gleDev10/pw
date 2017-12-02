/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.sql.ResultSet;

/**
 *
 * @author Máquina
 */
public class TOCliente {
    private int id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String email;

    public TOCliente(ResultSet rs) throws Exception{
        this.id = rs.getInt("id");
        this.nome = rs.getString("nome");
        this.sobrenome = rs.getString("sobrenome");
        this.sexo = rs.getString("sexo");
        this.email = rs.getString("email");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
