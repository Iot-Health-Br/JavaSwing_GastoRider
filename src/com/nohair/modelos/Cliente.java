/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.modelos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bruno
 */
public class Cliente {
    
    //Atributos
    private int id = 0;
    private String usuarioAdm = "";
    private String senhaAdm = "";
    private String CPF ="";
    private String telefone ="";
    private String email ="";
    private String nascimento = "";
   
    
    //Construtor
    public Cliente(int id, String usuarioAdm, String senhaAdm, String CPF, String telefone, String email, String nascimento ) {
        this.id = id;
        this.usuarioAdm = usuarioAdm;
        this.senhaAdm = senhaAdm;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
    }
    
    public Cliente(){
        
    }   
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioAdm() {
        return usuarioAdm;
    }

    public void setUsuarioAdm(String usuarioAdm) {
        this.usuarioAdm = usuarioAdm;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }


    //ToString

    @Override
    public String toString() {

        return id + ";" + usuarioAdm + ";" + senhaAdm +";" + CPF + ";" 
    + telefone + ";"+ email + ";" + nascimento + ";";
    }   
}
