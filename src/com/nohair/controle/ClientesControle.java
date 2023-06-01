/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.controle;

import com.nohair.modelos.Clientes;
import com.nohair.persistencia.ClientesDao;

import java.util.ArrayList;
import java.util.Iterator;

import com.nohair.persistencia.IClientesDao;
import javax.swing.JOptionPane;

/**
 *
 * @author ejmcc
 */
public class ClientesControle implements IClientesControle{
    IClientesDao ClientesPersistencia = null;
    
    public ClientesControle(){
        this.ClientesPersistencia = new ClientesDao();
    }
    
    private boolean buscarClientes(String NomeCompleto)throws Exception{
        try {
            ArrayList<Clientes> listagem = ClientesPersistencia.listagem();
            Iterator<Clientes> lista = listagem.iterator();
            while(lista.hasNext()){
                 Clientes aux = lista.next();
                 
                if(aux.getNomeCompleto().equalsIgnoreCase(NomeCompleto)){
                    
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
    public void incluir(Clientes objeto) throws Exception {
        
        if(buscarClientes(objeto.getNomeCompleto())){
            
            throw new Exception("Este Cliente já foi cadastrado !");
        }
        ClientesPersistencia.incluir(objeto);
    }
         
    @Override
    public void alterar(Clientes objeto) throws Exception {
        ClientesPersistencia.alterar(objeto);
    }
    
    @Override
    public void procurar(Clientes objeto) throws Exception {
        
        if(buscarClientes(objeto.getNomeCompleto())){
            throw new Exception("Cliente encontrado !");
        }
    }

    @Override
    public ArrayList<Clientes> listagem() throws Exception {
        return ClientesPersistencia.listagem(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
