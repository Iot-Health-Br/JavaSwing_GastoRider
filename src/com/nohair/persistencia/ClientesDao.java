/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.persistencia;

import com.nohair.modelos.Clientes;
import com.nohair.util.id.GeradorID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.AbstractAction;
import telaVisao.TelaDeClientes;
import java.util.Iterator;


public class ClientesDao implements IClientesDao{
      
    private String nomeDoArquivoNoDisco;
    
    public ClientesDao() {
        nomeDoArquivoNoDisco = "./src/com/nohair/dados/txt/Clientes.txt";
    }
    
    @Override
    public void incluir(Clientes objeto) throws Exception {
        
        try{
            //cria o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco,true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            objeto.setId(GeradorID.getID());
            //Escreve no arquivo
            bw.write(objeto.toString()+"\n");
            //fecha o arquivo
            bw.close();		
        }
        catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public void alterar(Clientes objeto) throws Exception {
        try {
            Iterator<Clientes> lista = listagem().iterator();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            //Criar o buffer do arquivo
           BufferedWriter bw =new BufferedWriter(fw);
            while(lista.hasNext()){
                Clientes aux = lista.next();
                if(aux.getId()== objeto.getId()){
                     bw.write(objeto.toString()+"\n");
                }
                else{
                    bw.write(aux.toString()+"\n");
                }
               }// GRAVAR NO ARQUIVO OBJETO
            bw.close();
         } catch(Exception erro){
         throw erro;
        }   
    }

    @Override
    public void procurar(Clientes objeto) throws Exception {
        try{
            
        }
        catch(Exception erro){
            
        }
    }    
   

    @Override
    public ArrayList<Clientes> listagem() throws Exception {
        try {
            ArrayList<Clientes> listaDeClientes = new ArrayList<Clientes>();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
                while((linha=br.readLine())!=null){
                
                    Clientes objetoClientes = new Clientes();
                
                    String vetorString[] = linha.split(";");
                
                    objetoClientes.setId(Integer.parseInt(vetorString[0]));
                
                    objetoClientes.setNomeCompleto(vetorString[1]); 
                
                    objetoClientes.setCPF(vetorString[2]);
                
                    objetoClientes.setRG(vetorString[3]);
                               
                    objetoClientes.setData_Nasc(vetorString[4]);
                
                    objetoClientes.setTelefone(vetorString[5]);
                    
                    objetoClientes.setEmail(vetorString[6]);
                
                    objetoClientes.setEndereco(vetorString[7]);
                
                    objetoClientes.setBairro(vetorString[8]);
                
                    objetoClientes.setCEP(vetorString[9]);
                
                    objetoClientes.setCidade(vetorString[10]);
                
                    objetoClientes.setEstado(vetorString[11]);
                    
                    objetoClientes.setCaminho_Foto(vetorString[12]);
                
                    listaDeClientes.add(objetoClientes);
                }
         br.close();
         return listaDeClientes;
        } 
        catch(Exception erro){
            throw erro;
        }
    }
    
    public void ChecarTxt(){
        try{
            File Clientes = new File("./src/com/nohair/dados/txt/Clientes.txt");
                if(!Clientes.exists()){
                    Clientes.createNewFile();
                }
            }
        catch(IOException ex){              
        }
    }  
    
}
