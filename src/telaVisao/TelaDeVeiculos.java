/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaVisao;

//Encontrar arquivo no txt
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


import com.nohair.controle.VeiculosControle;
import com.nohair.util.id.GeradorID;
import javax.swing.JOptionPane;
import com.nohair.modelos.Veiculos;
import com.nohair.persistencia.VeiculosDao;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import com.nohair.persistencia.IVeiculosDao;
import com.nohair.controle.IVeiculosControle;
import com.nohair.modelos.Clientes;
import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Icon;


import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JComponent;

//Bliblioteca Marca
import com.nohair.controle.IMarcaControle;
import com.nohair.controle.MarcaControle;
import com.nohair.modelos.Marca;
import com.nohair.persistencia.IMarcaDao;
import com.nohair.persistencia.MarcaDao;
import com.nohair.util.renderizador.RendererIcon;

//Combobox teste
import com.nohair.controle.IModeloControle;
import com.nohair.controle.ModeloControle;
import com.nohair.modelos.Modelo;
import com.nohair.util.id.GeradorID;
import java.awt.List;
import javax.swing.table.TableCellRenderer;



public class TelaDeVeiculos extends javax.swing.JFrame {
    
    // Combo Box - Combustivel 
    String selectedValue = "";
    
    //Atributos 
    IVeiculosControle VeiculosControle = new VeiculosControle();
    
    //Combobox Marca
    IModeloControle modeloControle = new ModeloControle();
    IMarcaControle marcaControle = new MarcaControle();
    
    //Mascaras dos TextField ...
    private MaskFormatter PlacaMask;
    private MaskFormatter RNVMask;
    private MaskFormatter ANOMASK;
    private MaskFormatter VALORMASK;
    private MaskFormatter PlacaMSMask;


    public TelaDeVeiculos(){
        try{
            initComponents();
            
            //Le e mostra as Marcas e Modelos Registrados
            try {
                ArrayList<Modelo> lista = modeloControle.listagem();
                    CB_Marca.removeAll();
                    CB_Modelo.removeAll();
                    
                    for(Modelo md : lista){
                        CB_Modelo.addItem(md.getDescricao());
                    }
                    
                    ArrayList<Marca> modelo =  marcaControle.listagem();
         
                    for(Marca md1 : modelo){
                        CB_Marca.addItem(md1.getDescricao());
                    }
            } 
            catch (Exception erro) {
                JOptionPane.showMessageDialog(this, erro);  
            }
            
            //Combobox inicializa Vazia
            CB_Combustivel.setSelectedIndex(-1);
            CB_Marca.setSelectedIndex(-1);
            CB_Modelo.setSelectedIndex(-1);
            CB_Tipo.setSelectedIndex(-1);

            // Inicializa a Mascara dos TextField ...
            PlacaMask = new MaskFormatter("UUU-####");
            PlacaMSMask = new MaskFormatter("UUU-#A##");
            RNVMask = new MaskFormatter("###########");
            ANOMASK = new MaskFormatter("####");
            //VALORMASK = new MaskFormatter("R$");   
            
            //Txt_Placa.setValue(null);
            //Txt_Placa.setFormatterFactory(new DefaultFormatterFactory(PlacaMask));
            Txt_Renavam.setValue(null);
            Txt_Renavam.setFormatterFactory(new DefaultFormatterFactory(RNVMask));
            Txt_Ano_Fab.setValue(null);
            Txt_Ano_Fab.setFormatterFactory(new DefaultFormatterFactory(ANOMASK));
            Txt_Ano_Modelo.setValue(null);
            Txt_Ano_Modelo.setFormatterFactory(new DefaultFormatterFactory(ANOMASK));
            //Txt_Pr_Compra.setValue(null);
            //Txt_Pr_Compra.setFormatterFactory(new DefaultFormatterFactory(VALORMASK));
            //Txt_Pr_Venda.setValue(null);
            //Txt_Pr_Venda.setFormatterFactory(new DefaultFormatterFactory(VALORMASK));
                   
            // Inicializa Vazio e o cursor na posiçao 0
            Txt_Placa.setCaretPosition( 0 );
            Txt_Renavam.setCaretPosition( 0 ); 
            Txt_Pr_Compra.setCaretPosition( 2 );
            Txt_Pr_Venda.setCaretPosition( 2 );
            Txt_Ano_Fab.setCaretPosition( 0 );
            Txt_Ano_Modelo.setCaretPosition( 0 );
            Txt_km.setText("");
            Txt_km.setCaretPosition( 0 );

        
            // Campos Iniciam desativados
            /*Txt_Placa.setEnabled(false);
            Txt_Renavam.setEnabled(false);
            Txt_Pr_Compra.setEnabled(false);
            Txt_Pr_Venda.setEnabled(false);
            Txt_Ano_Fab.setEnabled(false);
            Txt_Ano_Modelo.setEnabled(false);
            Txt_Combustivel.setEnabled(false);
            Txt_km.setEnabled(false);*/
            
            Txt_Caminho_Foto.setEnabled(false);

        
            DefaultTableModel modelo = (DefaultTableModel) jTableVeiculos.getModel();
            jTableVeiculos.setRowSorter(new TableRowSorter(modelo));
        
            this.setLocationRelativeTo(null);
            
                try {
                    imprimirDadosNaGrid(VeiculosControle.listagem());
                } 
                catch (Exception erro) {
                    JOptionPane.showMessageDialog(this, "Erro ao Puxar a Lista de Veiculos");
                }  
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Inicializar","Erro",JOptionPane.ERROR);
        }   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Fundo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        Bt_Add_Foto = new javax.swing.JButton();
        jButtonNovoCadastro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVeiculos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        CPF_CNPJ = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Txt_Placa = new javax.swing.JFormattedTextField();
        Txt_Renavam = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CB_Marca = new javax.swing.JComboBox<>();
        CB_Tipo = new javax.swing.JComboBox<>();
        CB_Modelo = new javax.swing.JComboBox<>();
        Txt_Ano_Fab = new javax.swing.JFormattedTextField();
        Txt_Ano_Modelo = new javax.swing.JFormattedTextField();
        CB_Combustivel = new javax.swing.JComboBox<>();
        Txt_km = new javax.swing.JFormattedTextField();
        Txt_Pr_Venda = new javax.swing.JFormattedTextField();
        Txt_Pr_Compra = new javax.swing.JFormattedTextField();
        Bt_Mercosul = new javax.swing.JRadioButton();
        Bt_PAntiga = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Txt_Caminho_Foto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Area_Logo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOpcoes = new javax.swing.JMenu();
        jMenuItemLocacao = new javax.swing.JMenuItem();
        jMenuItemCadastroDeMotorista = new javax.swing.JMenuItem();
        jMenuItemCadastroDeCategorias = new javax.swing.JMenuItem();
        jMenuItemCadastroDeAcessorios = new javax.swing.JMenuItem();
        jMenuItemCadastroVeiculo = new javax.swing.JMenuItem();
        jMenuItemCadastroDeCliente = new javax.swing.JMenuItem();
        jMenuItemCadastroDeModelo = new javax.swing.JMenuItem();
        jMenuItemCadastroDeMarca = new javax.swing.JMenuItem();
        jMenuItemTelaInicial = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Cadastro de Veiculos");

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Veiculos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 153));

        jButtonBuscar.setText("BUSCAR");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        Bt_Add_Foto.setText("ADD FOTO");
        Bt_Add_Foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_Add_FotoActionPerformed(evt);
            }
        });

        jButtonNovoCadastro.setText("NOVO ");
        jButtonNovoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bt_Add_Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bt_Add_Foto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovoCadastro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MARCA", "MODELO", "TIPO", "PLACA", "RENAVAM", "PREÇO DE VENDA", "PREÇO DE COMPRA", "ANO DE FABRICAÇAO", "ANO DO MODELO", "COMBUSTIVEL", "QUILOMETRAGEM", "URL"
            }
        ));
        jTableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVeiculos);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Cadastro"));

        CPF_CNPJ.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CPF_CNPJ.setText("Placa:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Renavam:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Preco de venda:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Ano do Modelo:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Combustivel:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Quilometragem:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Tipo:");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Ano de fabricação:");

        Txt_Placa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        Txt_Placa.setMinimumSize(new java.awt.Dimension(64, 29));

        try {
            Txt_Renavam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Txt_Renavam.setMinimumSize(new java.awt.Dimension(64, 29));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Marca:");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Modelo:");

        CB_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_MarcaActionPerformed(evt);
            }
        });

        CB_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_TipoActionPerformed(evt);
            }
        });

        CB_Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ModeloActionPerformed(evt);
            }
        });

        CB_Combustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Etanol", "GNV", "Diesel", "Eletrico" }));
        CB_Combustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CombustivelActionPerformed(evt);
            }
        });

        Txt_Pr_Venda.setText("R$");

        Txt_Pr_Compra.setText("R$");

        buttonGroup1.add(Bt_Mercosul);
        Bt_Mercosul.setText("Placa Mercosul");
        Bt_Mercosul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bt_MercosulMouseClicked(evt);
            }
        });

        buttonGroup1.add(Bt_PAntiga);
        Bt_PAntiga.setText("Placa Antiga");
        Bt_PAntiga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bt_PAntigaMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nohair/dados/img/Icones/PLacaNormal.png"))); // NOI18N
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nohair/dados/img/Icones/PLacaMercoSul.png"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Preco de Compra:");

        Txt_Caminho_Foto.setEditable(false);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("URL:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(Bt_PAntiga))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(Bt_Mercosul)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(CPF_CNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CB_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel14))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel12))
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_Pr_Compra)
                            .addComponent(Txt_Pr_Venda)
                            .addComponent(Txt_Ano_Fab)
                            .addComponent(Txt_Ano_Modelo)
                            .addComponent(CB_Combustivel, 0, 130, Short.MAX_VALUE)
                            .addComponent(Txt_km, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Txt_Renavam, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CB_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Txt_Caminho_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(CB_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Caminho_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Renavam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Pr_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(CB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bt_Mercosul)
                            .addComponent(Bt_PAntiga))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Pr_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(Txt_Ano_Fab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(Txt_Ano_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CB_Combustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Txt_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CPF_CNPJ))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Txt_Ano_Fab, Txt_Ano_Modelo, Txt_Placa, Txt_Renavam});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CB_Marca, CB_Modelo, CB_Tipo});

        Area_Logo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Area_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(Area_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jMenuOpcoes.setText("Options");

        jMenuItemLocacao.setText("Locação");
        jMenuItemLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLocacaoActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemLocacao);

        jMenuItemCadastroDeMotorista.setText("Cadastro de Motorista");
        jMenuItemCadastroDeMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeMotoristaActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroDeMotorista);

        jMenuItemCadastroDeCategorias.setText("Cadastro de Categorias");
        jMenuItemCadastroDeCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeCategoriasActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroDeCategorias);

        jMenuItemCadastroDeAcessorios.setText("Cadastro de Acessorios");
        jMenuItemCadastroDeAcessorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeAcessoriosActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroDeAcessorios);

        jMenuItemCadastroVeiculo.setText("Cadastro de Veículo");
        jMenuItemCadastroVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroVeiculoActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroVeiculo);

        jMenuItemCadastroDeCliente.setText("Cadastro de Cliente");
        jMenuItemCadastroDeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeClienteActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroDeCliente);

        jMenuItemCadastroDeModelo.setText("Cadastro de Modelo");
        jMenuItemCadastroDeModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeModeloActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroDeModelo);

        jMenuItemCadastroDeMarca.setText("Cadastro de Marca");
        jMenuItemCadastroDeMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeMarcaActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemCadastroDeMarca);

        jMenuItemTelaInicial.setText("Tela Inicial");
        jMenuItemTelaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelaInicialActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(jMenuItemTelaInicial);

        jMenuBar1.add(jMenuOpcoes);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirDadosNaGrid(ArrayList<Veiculos> listaDeVeiculos){
        try {
            DefaultTableModel model =  (DefaultTableModel) jTableVeiculos.getModel();
            //Limpa a tabela 
            model.setNumRows(0);
            
            Iterator<Veiculos> lista = listaDeVeiculos.iterator();
            
            while(lista.hasNext()){
                
                String[] saida= new String[13];
                
                Veiculos aux = lista.next();
                saida[0]= aux.getId()+"";
                saida[1]= aux.getMarca();
                saida[2]= aux.getModelo();
                saida[3]= aux.getTipo();
                saida[4]= aux.getPlaca();          
                saida[5] = aux.getRenavam();
                saida[6] = aux.getPr_Compra();//
                saida[7] = aux.getPr_Venda();//
                saida[8] = aux.getAno_Fab();//
                saida[9] = aux.getAno_Modelo();
                saida[10] = aux.getCombustivel();//
                saida[11] = aux.getQuilometragem();//
                saida[12] = aux.getCaminho_Foto();
                
                model.addRow(saida);               
            } 
        } 
        catch(Exception erro){
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }              
    }
    
    private void AtivarCampos(){
                    Txt_Placa.setEnabled(true);
                    Txt_Renavam.setEnabled(true);
                    Txt_Pr_Venda.setEnabled(true);
                    Txt_Ano_Fab.setEnabled(true);
                    Txt_Ano_Modelo.setEnabled(true);
                    Txt_km.setEnabled(true);  
    }
    
    private void DesativaCampos(){
                    Txt_Placa.setEnabled(false);
                    Txt_Renavam.setEnabled(false);
                    Txt_Pr_Venda.setEnabled(false);
                    Txt_Ano_Fab.setEnabled(false);
                    Txt_Ano_Modelo.setEnabled(false);
                    Txt_km.setEnabled(false);    
    }
       
    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
                  
        try {   
            if(!Txt_Placa.getText().equals("") && !Txt_Renavam.getText().equals("") && !Txt_Pr_Venda.getText().equals("")
               && !Txt_Ano_Fab.getText().equals("") && !Txt_Ano_Modelo.getText().equals("")&& !Txt_km.getText().equals("")){
                
                    //Construtor Cliente
                    Veiculos objeto = new Veiculos(0,String.valueOf(CB_Marca.getSelectedItem()),Txt_Placa.getText(),Txt_Renavam.getText(),Txt_Pr_Compra.getText(),
                    Txt_Pr_Venda.getText(),Txt_Ano_Fab.getText(),Txt_Ano_Modelo.getText(),String.valueOf(CB_Combustivel.getSelectedItem()),Txt_km.getText(),
                    Txt_Caminho_Foto.getText());
            
                    VeiculosControle.incluir(objeto);
            
                    // Atualiza a Grid quando Incluir
                    this.imprimirDadosNaGrid(VeiculosControle.listagem());
                    
                    // Zera os Campos com Mascaras 
                    Txt_Placa.setValue(null);
                    //Txt_Placa.setFormatterFactory(new DefaultFormatterFactory(PlacaMask));
                    Txt_Renavam.setValue(null);
                    Txt_Renavam.setFormatterFactory(new DefaultFormatterFactory(RNVMask));
                    Txt_Ano_Fab.setValue(null);
                    Txt_Ano_Fab.setFormatterFactory(new DefaultFormatterFactory(ANOMASK));
                    Txt_Ano_Modelo.setValue(null);
                    Txt_Ano_Modelo.setFormatterFactory(new DefaultFormatterFactory(ANOMASK));
                    //Txt_Pr_Compra.setValue(null);
                    //Txt_Pr_Compra.setFormatterFactory(new DefaultFormatterFactory(VALORMASK));
                    //Txt_Pr_Venda.setValue(null);
                    //Txt_Pr_Venda.setFormatterFactory(new DefaultFormatterFactory(VALORMASK));
                    
                    Txt_km.setText("");
                    Txt_Caminho_Foto.setText("");
                    Txt_Pr_Compra.setText("R$");
                    Txt_Pr_Venda.setText("R$");
                    
                    //Restaura a Combobox Vazia
                    CB_Combustivel.setSelectedIndex(-1);
                    CB_Marca.setSelectedIndex(-1);
                    CB_Modelo.setSelectedIndex(-1);
                    CB_Tipo.setSelectedIndex(-1);
                    
                    //JradioButton
                    buttonGroup1.clearSelection();
                    Bt_Mercosul.setSelected(false);
                    Bt_PAntiga.setSelected(false);
       
            }
            else{
                // Se houver campo vazio no cadastro e mostrado uma mensagem !
                JOptionPane.showMessageDialog(this, "Campo Vazio");    
            }                  
        } 
        catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }                   
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void Bt_Add_FotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_Add_FotoActionPerformed
        try {        
            
            JFileChooser fc = new JFileChooser();
            
            //Title da Barra de buca da Foto
            fc.setDialogTitle("Buscar Foto");
                    
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            // Abre no diretorio especifico
            fc.setCurrentDirectory(new File ("./src/com/nohair/dados/img/Modelos Veiculos"));

            
            fc.showOpenDialog(this);
            
            File arquivo = fc.getSelectedFile();
            String nomeDoArquivo = arquivo.getPath();
            
            Txt_Caminho_Foto.setText(nomeDoArquivo);
            
            ImageIcon iconLogo = new ImageIcon(nomeDoArquivo);
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(
            Area_Logo.getWidth(),Area_Logo.getHeight(),1));
            Area_Logo.setIcon(iconLogo);
        } 
        catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_Bt_Add_FotoActionPerformed

    private void jTableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeiculosMouseClicked
      
      try{
        // Ao selecionar a linha da tabela, apresenta os valores no TextField
        
        if(jTableVeiculos.getSelectedRow() != -1){
                         
                /*Txt_ID.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),0).toString());           
                CB_Marca.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),1).toString());
                CB_Modelo.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),2).toString());                
                CB_Tipo.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),3).toString());*/
                
                Txt_Placa.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),4).toString());
                Txt_Renavam.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),5).toString());
                Txt_Pr_Compra.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),6).toString());
                Txt_Pr_Venda.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),7).toString());
                Txt_Ano_Fab.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),8).toString());
                Txt_Ano_Modelo.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),9).toString());
                //CB_Combustivel.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),10).toString());
                Txt_km.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),11).toString()); 
                
                Txt_Caminho_Foto.setText(jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),12).toString());
                
                // Apresenta a foto do cliente no Campo Logo
                String nomeArquivo = (String) this.jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(),12);
                ImageIcon iconLogo = new ImageIcon(nomeArquivo);
                iconLogo.setImage(iconLogo.getImage().getScaledInstance(Area_Logo.getWidth(), Area_Logo.getHeight(), 1));
                Area_Logo.setIcon(iconLogo);
            }       
      }
      catch (Exception ERRO){
        JOptionPane.showMessageDialog(null, "Erro ao Selecionar a Tabela","Erro",JOptionPane.ERROR);
      }    
      
    }//GEN-LAST:event_jTableVeiculosMouseClicked

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
	try {          
            Veiculos objeto = new Veiculos(0,CB_Marca.getSelectedItem().toString(),Txt_Placa.getText(),Txt_Renavam.getText(),Txt_Pr_Compra.getText(),
                    Txt_Pr_Venda.getText(),Txt_Ano_Fab.getText(), Txt_Ano_Modelo.getText(),CB_Combustivel.getSelectedItem().toString(),Txt_km.getText(),
                    Txt_Caminho_Foto.getText());
            
            VeiculosControle.alterar(objeto);
            
            imprimirDadosNaGrid(VeiculosControle.listagem());          
        } 
        catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());          
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try{
            for(int i = 0; i < jTableVeiculos.getRowCount(); i++){
                if(jTableVeiculos.getValueAt(i, 1).toString().toLowerCase().contains(Txt_Placa.getText().toLowerCase())){
                    jTableVeiculos.changeSelection(i, 0, false, false);
                }
            }
        
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar","Erro",JOptionPane.ERROR);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonNovoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoCadastroActionPerformed
        try{
           
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro Novo Cadastro","Erro",JOptionPane.ERROR);
        }
    }//GEN-LAST:event_jButtonNovoCadastroActionPerformed

    private void CB_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_MarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_MarcaActionPerformed

    private void CB_ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_ModeloActionPerformed

    private void CB_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_TipoActionPerformed

    private void CB_CombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CombustivelActionPerformed

    }//GEN-LAST:event_CB_CombustivelActionPerformed

    private void Bt_MercosulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bt_MercosulMouseClicked
        try{
            if(Bt_Mercosul.isSelected()){
                Txt_Placa.setValue(null);
                Txt_Placa.setFormatterFactory(new DefaultFormatterFactory(PlacaMSMask)); 
                JOptionPane.showMessageDialog(null, "Placa Mercosul, Selecionada");
            }
        }
        catch(Exception erro){
            
        }
    }//GEN-LAST:event_Bt_MercosulMouseClicked

    private void Bt_PAntigaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bt_PAntigaMouseClicked
        try{
            if(Bt_PAntiga.isSelected()){
                Txt_Placa.setValue(null);
                Txt_Placa.setFormatterFactory(new DefaultFormatterFactory(PlacaMask)); 
                JOptionPane.showMessageDialog(null, "Placa Antiga, Selecionada");
            }
        }
        catch(Exception erro){
            
        }
    }//GEN-LAST:event_Bt_PAntigaMouseClicked

    private void jMenuItemLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLocacaoActionPerformed
        /*
        try {
            TelaDeLocacao telaLocacao = new TelaDeLocacao();
            telaLocacao.setLocationRelativeTo(null);
            telaLocacao.setVisible(true);
            this.setVisible(false);
            telaLocacao.setResizable(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
        */
    }//GEN-LAST:event_jMenuItemLocacaoActionPerformed

    private void jMenuItemCadastroDeMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeMotoristaActionPerformed
        /*
        try {
            TelaCadastroMotorista telaMotorista = new TelaCadastroMotorista();
            telaMotorista.setLocationRelativeTo(null);
            telaMotorista.setVisible(true);
            this.setVisible(false);
            telaMotorista.setResizable(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
        */
    }//GEN-LAST:event_jMenuItemCadastroDeMotoristaActionPerformed

    private void jMenuItemCadastroDeCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeCategoriasActionPerformed
        /*
        try {

            TelaDeCategoria telaCategoria = new TelaDeCategoria();
            telaCategoria.setLocationRelativeTo(null);
            telaCategoria.setVisible(true);
            this.setVisible(false);
            telaCategoria.setResizable(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
        */
    }//GEN-LAST:event_jMenuItemCadastroDeCategoriasActionPerformed

    private void jMenuItemCadastroDeAcessoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeAcessoriosActionPerformed
        /*
        try {
            TelaDeAcessorios telaAcessorios = new TelaDeAcessorios();
            telaAcessorios.setLocationRelativeTo(null);
            telaAcessorios.setVisible(true);
            this.setVisible(false);
            telaAcessorios.setResizable(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
        */
    }//GEN-LAST:event_jMenuItemCadastroDeAcessoriosActionPerformed

    private void jMenuItemCadastroVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroVeiculoActionPerformed

        try {
            TelaDeVeiculos telaVeiculo = new TelaDeVeiculos();
            telaVeiculo.setLocationRelativeTo(null);
            telaVeiculo.setVisible(true);
            this.setVisible(false);
            telaVeiculo.setResizable(false);
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jMenuItemCadastroVeiculoActionPerformed

    private void jMenuItemCadastroDeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeClienteActionPerformed

        try {
            TelaDeClientes cadastroCliente = new TelaDeClientes();
            cadastroCliente.setLocationRelativeTo(null);
            cadastroCliente.setVisible(true);
            this.setVisible(false);
            cadastroCliente.setResizable(false);
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }

    }//GEN-LAST:event_jMenuItemCadastroDeClienteActionPerformed

    private void jMenuItemCadastroDeModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeModeloActionPerformed
        // TODO add your handling code here:
        try {
            TelaDeModelos telaModelo = new TelaDeModelos();
            telaModelo.setLocationRelativeTo(null);
            telaModelo.setVisible(true);
            this.setVisible(false);
            telaModelo.setResizable(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jMenuItemCadastroDeModeloActionPerformed

    private void jMenuItemCadastroDeMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeMarcaActionPerformed
        // TODO add your handling code here:
        try {

            TelaDeMarcas telaMarca = new TelaDeMarcas();
            telaMarca.setLocationRelativeTo(null);
            telaMarca.setVisible(true);
            this.setVisible(false);
            telaMarca.setResizable(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jMenuItemCadastroDeMarcaActionPerformed

    private void jMenuItemTelaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelaInicialActionPerformed

        try {
            telaAdminOpcoes telaInicial = new telaAdminOpcoes();
            telaInicial.setLocationRelativeTo(null);
            telaInicial.setVisible(true);
            this.setVisible(false);
            telaInicial.setResizable(false);
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jMenuItemTelaInicialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeVeiculos().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Area_Logo;
    private javax.swing.JButton Bt_Add_Foto;
    private javax.swing.JRadioButton Bt_Mercosul;
    private javax.swing.JRadioButton Bt_PAntiga;
    private javax.swing.JComboBox<String> CB_Combustivel;
    private javax.swing.JComboBox<String> CB_Marca;
    private javax.swing.JComboBox<String> CB_Modelo;
    private javax.swing.JComboBox<String> CB_Tipo;
    private javax.swing.JLabel CPF_CNPJ;
    private javax.swing.JPanel Fundo;
    private javax.swing.JFormattedTextField Txt_Ano_Fab;
    private javax.swing.JFormattedTextField Txt_Ano_Modelo;
    private javax.swing.JTextField Txt_Caminho_Foto;
    private javax.swing.JFormattedTextField Txt_Placa;
    private javax.swing.JFormattedTextField Txt_Pr_Compra;
    private javax.swing.JFormattedTextField Txt_Pr_Venda;
    private javax.swing.JFormattedTextField Txt_Renavam;
    private javax.swing.JFormattedTextField Txt_km;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovoCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCadastroDeAcessorios;
    private javax.swing.JMenuItem jMenuItemCadastroDeCategorias;
    private javax.swing.JMenuItem jMenuItemCadastroDeCliente;
    private javax.swing.JMenuItem jMenuItemCadastroDeMarca;
    private javax.swing.JMenuItem jMenuItemCadastroDeModelo;
    private javax.swing.JMenuItem jMenuItemCadastroDeMotorista;
    private javax.swing.JMenuItem jMenuItemCadastroVeiculo;
    private javax.swing.JMenuItem jMenuItemLocacao;
    private javax.swing.JMenuItem jMenuItemTelaInicial;
    private javax.swing.JMenu jMenuOpcoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVeiculos;
    // End of variables declaration//GEN-END:variables
}
