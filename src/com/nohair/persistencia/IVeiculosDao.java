/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nohair.persistencia;
import com.nohair.modelos.Veiculos;
import java.util.ArrayList;
/**
 *
 * @author ejmcc
 */
public interface IVeiculosDao {
    void incluir(Veiculos objeto)throws Exception;
    void alterar(Veiculos objeto)throws Exception;
    void procurar(Veiculos objeto)throws Exception;
    ArrayList<Veiculos> listagem()throws Exception;
}
