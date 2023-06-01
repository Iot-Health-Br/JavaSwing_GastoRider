/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nohair.controle;

import com.nohair.modelos.Clientes;
import java.util.ArrayList;

/**
 *
 * @author ejmcc
 */
public interface IClientesControle {
    void incluir(Clientes objeto)throws Exception;
    void alterar(Clientes objeto)throws Exception;
    void procurar(Clientes objeto)throws Exception;
    ArrayList<Clientes> listagem()throws Exception;
}
