/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.modelos;

/**
 *
 * @author ejmcc
 */
public class Clientes {
    // 14 Variaveis de Atributos
    
    private int id = 0;
    private String NomeCompleto = "";
    private String CPF = "";
    private String RG = "";
    private String Data_Nasc = "";
    private String Telefone = "";
    private String email = "";
    private String Endereco = "";
    private String Bairro = "";
    private String CEP = "";
    private String Cidade = "";
    private String Estado = "";
    private String Caminho_Foto = "";
        
    public Clientes(){
    }
    
    public Clientes(int id, String NomeCompleto, String CPF, String RG, String Data_Nasc, String Telefone, String email,
            String Endereco, String Bairro, String CEP, String Cidade, String Estado, String Caminho_Foto){
        
        this.id = id;
        this.NomeCompleto = NomeCompleto;
        this.CPF = CPF;
        this.RG = RG;
        this.Data_Nasc = Data_Nasc;
        this.Telefone = Telefone;
        this.email = email;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Caminho_Foto = Caminho_Foto;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getData_Nasc() {
        return Data_Nasc;
    }

    public void setData_Nasc(String Data_Nasc) {
        this.Data_Nasc = Data_Nasc;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCaminho_Foto() {
        return Caminho_Foto;
    }

    public void setCaminho_Foto(String Caminho_Foto) {
        this.Caminho_Foto = Caminho_Foto;
    }

    @Override
    public String toString() {
        return id + ";" + NomeCompleto + ";" + CPF + ";" + RG + ";"+ Data_Nasc + ";" + Telefone + ";"+ email + ";"+ Endereco + 
                ";" + Bairro + ";" + CEP + ";" + Cidade + ";" + Estado + ";"+ Caminho_Foto + ";";
    }
    
}
