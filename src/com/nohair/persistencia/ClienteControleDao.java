/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.persistencia;

import com.nohair.modelos.Cliente;
import com.nohair.controle.ClienteControle;
import com.nohair.persistencia.ClienteControleDao;
import com.nohair.util.id.GeradorID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.nohair.controle.IClienteControle;

/**
 *
 * @author bruno
 */
public class ClienteControleDao implements IClienteControle {
    
    private String nomeDoArquivoNoDisco;
    public ClienteControleDao() {
        nomeDoArquivoNoDisco = "./src/com/nohair/dados/txt/Admin.txt";
    }

    
    @Override
    public void incluir(Cliente objeto) throws Exception {
        try{
            //Escreve o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco,true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            objeto.setId(GeradorID.getID());
            //Escreve no arquivo
            bw.write(objeto.toString()+"\n");
            //fecha o arquivo
            bw.close();		
      }catch(Exception erro){
          
         throw erro;
      }
    }

    @Override
    public void alterar(Cliente objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listagem() throws Exception {
        try {
            ArrayList<Cliente > listaDeAdmin = new ArrayList<Cliente>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null){
                Cliente objetoAdmin = new Cliente();
                String vetorString[] = linha.split(";");
                objetoAdmin.setId(Integer.parseInt(vetorString[0]));
                objetoAdmin.setUsuarioAdm(vetorString[1]);
                objetoAdmin.setSenhaAdm(vetorString[2]);
                listaDeAdmin.add(objetoAdmin);
            }
         br.close();
         return listaDeAdmin;
        } catch(Exception erro){
         throw erro;
        }
        
        
        }
        public void ChecarTxt(){
            try{
                File Admin = new File("./src/com/nohair/dados/txt/Admin.txt");
                if(!Admin.exists()){
                    Admin.createNewFile();
                }
            }catch(IOException ex){
                
            }
    }
    
    
}
