/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.controle;

import com.nohair.modelos.admin;
import com.nohair.persistencia.IAdminDao;
import com.nohair.persistencia.AdminDao;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author bruno
 */
public class AdminControle implements IAdminControle{
    
    IAdminDao adminPersistencia = null;
    public AdminControle(){
        this.adminPersistencia = new AdminDao();
    }
    private boolean buscarAdmin(String usuarioAdm)throws Exception{
          try {
            ArrayList<admin> listagem = adminPersistencia.listagem();
            Iterator<admin> lista = listagem.iterator();
            while(lista.hasNext()){
                 admin aux = lista.next();
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
    public void incluir(admin objeto) throws Exception {
        if(buscarAdmin(objeto.getUsuarioAdm())){
            throw new Exception("Usuario Administrador já foi cadastrado");
        }
        adminPersistencia.incluir(objeto);
    }

    @Override
    public void alterar(admin objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<admin> listagem() throws Exception {
        return adminPersistencia.listagem(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    

