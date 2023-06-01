/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.persistencia;

import com.nohair.modelos.Veiculos;
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
import telaVisao.TelaDeVeiculos;
import java.util.Iterator;


public class VeiculosDao implements IVeiculosDao{
      
    private String nomeDoArquivoNoDisco;
    
    public VeiculosDao() {
        nomeDoArquivoNoDisco = "./src/com/nohair/dados/txt/Veiculos.txt";
    }
    
    @Override
    public void incluir(Veiculos objeto) throws Exception {
        
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
    public void alterar(Veiculos objeto) throws Exception {
        try {
            Iterator<Veiculos> lista = listagem().iterator();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
                while(lista.hasNext()){
                    Veiculos aux = lista.next();
                        if(aux.getId()== objeto.getId()){
                            bw.write(objeto.toString()+"\n");
                        }
                        else{
                            bw.write(aux.toString()+"\n");
                        }
                }// GRAVAR NO ARQUIVO OBJETO
            bw.close();
         } 
         catch(Exception erro){
               throw erro;
         }   
    }

    @Override
    public void procurar(Veiculos objeto) throws Exception {
        try{
            
        }
        catch(Exception erro){
            
        }
    }    
   

    @Override
    public ArrayList<Veiculos> listagem() throws Exception {
        try {
            ArrayList<Veiculos> listaDeVeiculos = new ArrayList<Veiculos>();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
                while((linha=br.readLine())!=null){
                
                    Veiculos objetoVeiculos = new Veiculos();
                
                    String vetorString[] = linha.split(";");
                
                    objetoVeiculos.setId(Integer.parseInt(vetorString[0]));
                    
                    objetoVeiculos.setMarca(vetorString[1]);
                
                    objetoVeiculos.setPlaca(vetorString[2]); 
                
                    objetoVeiculos.setRenavam(vetorString[3]);
                
                    objetoVeiculos.setPr_Compra(vetorString[4]);
                               
                    objetoVeiculos.setPr_Venda(vetorString[5]);
                
                    objetoVeiculos.setAno_Fab(vetorString[6]);
                    
                    objetoVeiculos.setAno_Modelo(vetorString[7]);
                
                    objetoVeiculos.setCombustivel(vetorString[8]);
                
                    objetoVeiculos.setQuilometragem(vetorString[9]);
                    
                    objetoVeiculos.setCaminho_Foto(vetorString[10]);
                
                    listaDeVeiculos.add(objetoVeiculos);
                }
         br.close();
         return listaDeVeiculos;
        } 
        catch(Exception erro){
            throw erro;
        }
    }
    
    public void ChecarTxt(){
        try{
            File Veiculos = new File("./src/com/nohair/dados/txt/Veiculos.txt");
                if(!Veiculos.exists()){
                    Veiculos.createNewFile();
                }
            }
        catch(IOException ex){              
        }
    }  
    
}
