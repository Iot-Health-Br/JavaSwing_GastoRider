/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nohair.persistencia;

import com.nohair.controle.MarcaControle;
import com.nohair.modelos.Marca;
import com.nohair.util.id.GeradorID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import telaVisao.TelaDeMarcas;
import javax.swing.JOptionPane;
/**
 *
 * @author dhion
 */
public class MarcaDao implements IMarcaDao{
     
   private String nomeDoArquivoNoDisco;
   
    public MarcaDao() {
        nomeDoArquivoNoDisco = "./src/com/nohair/dados/txt/Marca.txt";
    }
    
    @Override
    public void incluir(Marca objeto) throws Exception {
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
      }catch(Exception erro){
         throw erro;
      }
    }

    @Override
    public void alterar(Marca objeto) throws Exception {
        try {
            Marca objetoMarca = new Marca();
            Iterator<Marca> lista = listagem().iterator();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);

            while (lista.hasNext()) {
                Marca aux = lista.next();
                if (aux.getId() == objeto.getId()) {
                    bw.write(objeto.toString() + "\n");

                } else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();

        } 
        catch (Exception e) {
        }
    }
    
    @Override
    public ArrayList<Marca> listagem() throws Exception {
        try {
            ArrayList<Marca> listaDeMarcas = new ArrayList<Marca>();
            File arquivo = new File("./src/com/nohair/dados/txt/Marca.txt");
            if(!arquivo.exists()){
                arquivo.createNewFile();
                nomeDoArquivoNoDisco = "./src/com/nohair/dados/txt/Marca.txt";
            }
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Marca objetoMarca = new Marca();
                String vetorString[] = linha.split(";");
                objetoMarca.setId(Integer.parseInt(vetorString[0]));
                objetoMarca.setDescricao(vetorString[1]);
                objetoMarca.setUrl(vetorString[2]);
                listaDeMarcas.add(objetoMarca);
            }
            br.close();
            return listaDeMarcas;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public Marca buscar( int id) throws Exception{
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {
            Marca objetomMarca = new Marca();
            String vetorString[] = linha.split(";");
            objetomMarca.setId(Integer.parseInt(vetorString[0]));
            objetomMarca.setDescricao(vetorString[1]);
            objetomMarca.setUrl(vetorString[2]);
            if (objetomMarca.getId() == id) {
                br.close();
                return new Marca((Integer.parseInt(vetorString[0])), vetorString[1], vetorString[2]);
            }
        }
        return null;
    }
    
        
    public void ChecarTxt(){
        try{
            File Clientes = new File("./src/com/nohair/dados/txt/Marca.txt");
                if(!Clientes.exists()){
                    Clientes.createNewFile();
                }
            }
        catch(IOException ex){              
        }
    }  
    
    
    
}
