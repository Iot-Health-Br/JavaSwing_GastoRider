/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.modelos;

public class Veiculos {
    // 8 Variaveis de Atributos
    
    private int id = 0;
    private String Marca = "";
    private String Modelo = "";
    private String Tipo = "";
    private String Placa = "";
    private String Renavam = "";
    private String Pr_Compra = "";
    private String Pr_Venda = "";
    private String Ano_Fab = "";
    private String Ano_Modelo = "";
    private String Combustivel = "";
    private String Quilometragem = "";
    private String Caminho_Foto = "";
        
    public Veiculos(){
    }
    
    public Veiculos(int id,String Marca, String Placa, String Renavam, String Pr_Compra, String Pr_Venda, String Ano_Fab, String Ano_Modelo,
            String Combustivel, String Quilometragem, String Caminho_Foto){
        
        this.id = id;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Tipo = Tipo;
        this.Placa = Placa;
        this.Renavam = Renavam;
        this.Pr_Compra = Pr_Compra;
        this.Pr_Venda = Pr_Venda;
        this.Ano_Fab = Ano_Fab;
        this.Ano_Modelo = Ano_Modelo;
        this.Combustivel = Combustivel;
        this.Quilometragem = Quilometragem;
        this.Caminho_Foto = Caminho_Foto;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getRenavam() {
        return Renavam;
    }

    public void setRenavam(String Renavam) {
        this.Renavam = Renavam;
    }

    public String getPr_Compra() {
        return Pr_Compra;
    }

    public void setPr_Compra(String Pr_Compra) {
        this.Pr_Compra = Pr_Compra;
    }

    public String getPr_Venda() {
        return Pr_Venda;
    }

    public void setPr_Venda(String Pr_Venda) {
        this.Pr_Venda = Pr_Venda;
    }

    public String getAno_Fab() {
        return Ano_Fab;
    }

    public void setAno_Fab(String Ano_Fab) {
        this.Ano_Fab = Ano_Fab;
    }

    public String getAno_Modelo() {
        return Ano_Modelo;
    }

    public void setAno_Modelo(String Ano_Modelo) {
        this.Ano_Modelo = Ano_Modelo;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    public void setCombustivel(String Combustivel) {
        this.Combustivel = Combustivel;
    }

    public String getQuilometragem() {
        return Quilometragem;
    }

    public void setQuilometragem(String Quilometragem) {
        this.Quilometragem = Quilometragem;
    }

    public String getCaminho_Foto() {
        return Caminho_Foto;
    }

    public void setCaminho_Foto(String Caminho_Foto) {
        this.Caminho_Foto = Caminho_Foto;
    }
    



    @Override
    public String toString() {
        return id + ";" + Marca + ";" + Placa + ";" + Renavam + ";" + Pr_Compra + ";"+ Pr_Venda + ";" + Ano_Fab + ";"+ Ano_Modelo
                + ";"+ Combustivel + ";" + Quilometragem + ";" + Caminho_Foto + ";";
    }
    
}
