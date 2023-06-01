/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nohair.controle;

import com.nohair.modelos.admin;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public interface IAdminControle {
    
    
     void incluir(admin objeto)throws Exception;
    void alterar(admin objeto)throws Exception;
    ArrayList<admin> listagem()throws Exception;
}
    

