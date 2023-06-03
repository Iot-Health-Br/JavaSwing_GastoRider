/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nohair.persistencia;

import com.nohair.modelos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public interface IClienteControle {
    
    
     void incluir(Cliente objeto) throws Exception;
    void alterar(Cliente objeto)throws Exception;
    ArrayList<Cliente> listagem()throws Exception;
}
    

