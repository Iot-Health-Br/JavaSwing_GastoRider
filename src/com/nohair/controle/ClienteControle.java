/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.controle;

import com.nohair.modelos.Cliente;
import com.nohair.persistencia.ClienteControleDao;
import java.util.ArrayList;
import java.util.Iterator;
import com.nohair.persistencia.IClienteControle;

/**
 *
 * @author bruno
 */
public class ClienteControle implements IClienteControle{
    
    IClienteControle adminPersistencia = null;
    public ClienteControle(){
        this.adminPersistencia = new ClienteControleDao();
    }

    private boolean buscarAdmin(String usuarioAdm)throws Exception{
          try {
            ArrayList<Cliente> listagem = adminPersistencia.listagem();
            Iterator<Cliente> lista = listagem.iterator();
            while(lista.hasNext()){
                 Cliente aux = lista.next();
                if(aux.getUsuarioAdm().equalsIgnoreCase(usuarioAdm)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }
    @Override
    public void incluir(Cliente objeto) throws Exception {
        if(buscarAdmin(objeto.getUsuarioAdm())){
            throw new Exception("Usuario Administrador já foi cadastrado");
        }
        adminPersistencia.incluir(objeto);
    }

    @Override
    public void alterar(Cliente objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listagem() throws Exception {
        return adminPersistencia.listagem(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    

