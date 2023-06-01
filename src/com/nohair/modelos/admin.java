/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.modelos;

import java.io.Serializable;

/**
 *
 * @author bruno
 */
public class admin {
    
    //Atributos
    
    private int id = 0;
    private String usuarioAdm = "";
    private String senhaAdm = "";

    
    
    
    //Construtor

    public admin(int id, String usuarioAdm, String senhaAdm) {
        this.id = id;
        this.usuarioAdm = usuarioAdm;
        this.senhaAdm = senhaAdm;
    }
    
    public admin(){
        
    }

    
   

    
    
    //Getters & Setters

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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //ToString

    @Override
    public String toString() {
        return  id + ";" + usuarioAdm + ";" + senhaAdm ;
    }

    
    
    
    
    
}
