/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.persistencia;

import com.nohair.modelos.admin;
import com.nohair.controle.AdminControle;
import com.nohair.controle.IAdminControle;
import com.nohair.persistencia.AdminDao;
import com.nohair.persistencia.IAdminDao;
import com.nohair.util.id.GeradorID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class AdminDao implements IAdminDao {
    
    private String nomeDoArquivoNoDisco;
    public AdminDao() {
        nomeDoArquivoNoDisco = "./src/com/nohair/dados/txt/Admin.txt";
    }
    
    @Override
    public void incluir(admin objeto) throws Exception {
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
    public void alterar(admin objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<admin> listagem() throws Exception {
        try {
            ArrayList<admin > listaDeAdmin = new ArrayList<admin>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null){
                admin objetoAdmin = new admin();
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
