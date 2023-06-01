/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.controle;

import com.nohair.modelos.Veiculos;
import com.nohair.persistencia.VeiculosDao;

import java.util.ArrayList;
import java.util.Iterator;

import com.nohair.persistencia.IVeiculosDao;
import javax.swing.JOptionPane;

/**
 *
 * @author ejmcc
 */
public class VeiculosControle implements IVeiculosControle{
    IVeiculosDao VeiculosPersistencia = null;
    
    public VeiculosControle(){
        this.VeiculosPersistencia = new VeiculosDao();
    }
    
    private boolean buscarVeiculos(String Placa)throws Exception{
        try {
            ArrayList<Veiculos> listagem = VeiculosPersistencia.listagem();
            Iterator<Veiculos> lista = listagem.iterator();
            while(lista.hasNext()){
                 Veiculos aux = lista.next();
                 
                if(aux.getPlaca().equalsIgnoreCase(Placa)){
                    
                    return true;
                }
            }
            return false;
        } 
        catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public void incluir(Veiculos objeto) throws Exception {
        
        if(buscarVeiculos(objeto.getPlaca())){
            
            throw new Exception("Este Veiculo já foi cadastrado !");
        }
        VeiculosPersistencia.incluir(objeto);
    }
         
    @Override
    public void alterar(Veiculos objeto) throws Exception {
        VeiculosPersistencia.alterar(objeto);
    }
    
    @Override
    public void procurar(Veiculos objeto) throws Exception {
        
        if(buscarVeiculos(objeto.getPlaca())){
            throw new Exception("Veiculo encontrado !");
        }
    }

    @Override
    public ArrayList<Veiculos> listagem() throws Exception {
        return VeiculosPersistencia.listagem(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
