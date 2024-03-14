
package Interfaces;

import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistrarMembros extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    
    Connection conn;
    String name;
    boolean isMin;
    
    public RegistrarMembros(Connection conn, String name, boolean isMin) {
        this.conn = conn;
        this.isMin = isMin;
        this.name = name;
        model.setColumnIdentifiers(new String[] {"ID", "Nome cargo"});
        model2.setColumnIdentifiers(new String[] {"ID", "Nome departamento", "Sigla"});
        initComponents();
        table.setModel(model);
        tableDep.setModel(model2);
        //Fecha conexão com o BD após fechar janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try{
                    conn.close();
                    System.out.println("Conexao encerrada");
                }catch(SQLException ex) {/*Não faz nada*/}
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        logoText = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        RAText = new javax.swing.JLabel();
        cargo = new javax.swing.JTextField();
        IDDepartamento = new javax.swing.JTextField();
        nomeText = new javax.swing.JLabel();
        IDDepartamentoText = new javax.swing.JLabel();
        senha = new javax.swing.JTextField();
        SenhaText = new javax.swing.JLabel();
        IDCargoText = new javax.swing.JLabel();
        RA = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        insertButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDep = new javax.swing.JTable();
        departamentosText = new javax.swing.JLabel();
        cargostext = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Images/logoUTF.png"))); // NOI18N

        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RAText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RAText.setText("RA");

        nomeText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeText.setText("Nome");

        IDDepartamentoText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDDepartamentoText.setText("Departamento (ID)");

        SenhaText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SenhaText.setText("Senha");

        IDCargoText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDCargoText.setText("Cargo (ID)");

        returnButton.setText("voltar");
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
        });

        insertButton1.setText("Cadastrar");
        insertButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Registar membro");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(SenhaText)
                        .addComponent(RAText)
                        .addComponent(nomeText)
                        .addComponent(IDCargoText)
                        .addComponent(IDDepartamentoText)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(senha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDDepartamento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(returnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(RAText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDCargoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(IDDepartamentoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenhaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        searchButton.setText("Buscar");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        tableDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableDep);

        departamentosText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        departamentosText.setText("Departamentos");

        cargostext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cargostext.setText("Cargos");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargostext)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(departamentosText)
                                .addContainerGap(135, Short.MAX_VALUE))))))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departamentosText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cargostext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoText)
                        .addGap(257, 257, 257))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        model.setRowCount(0);
        model2.setRowCount(0);
        try{
            Statement statement1 = conn.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM cargo");
            while (resultSet1.next()) {
                String idCargo = resultSet1.getString("IDCargo");
                String nomeCargo = resultSet1.getString("NomeCargo");
                model.addRow(new Object[] {idCargo, nomeCargo});
            }
            
            
            table.setModel(model);
            jScrollPane1.setViewportView(table);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!!!");
        }
        
        try{
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM departamento");
            while (resultSet2.next()) {
                String idDep = resultSet2.getString("IDDepartamento");
                String nomeDep = resultSet2.getString("NomeDepartamento");
                String sigla = resultSet2.getString("Sigla");
                model2.addRow(new Object[] {idDep, nomeDep, sigla});
            }
            tableDep.setModel(model2);
            jScrollPane2.setViewportView(tableDep);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!!!");
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void insertButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertButton1MouseClicked
        try{
            
            int ra = Integer.parseInt(RA.getText());
            String nom = nome.getText();
            int carg = Integer.parseInt(cargo.getText());
            int dep = Integer.parseInt(IDDepartamento.getText());
            String sen = senha.getText();
            
            PreparedStatement stat = conn.prepareStatement("INSERT INTO membro VALUES("+ra+","+"'"+nom+"'"+","+carg+","+dep+","+"'"+sen+"'"+")");
            stat.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!!!");
            e.printStackTrace();
        }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null, "O formato dos campos é inválido!!!");
        }
    }//GEN-LAST:event_insertButton1MouseClicked

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        MenuPrincipal m = new MenuPrincipal(this.conn, this.name, isMin);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButtonMouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDCargoText;
    private javax.swing.JTextField IDDepartamento;
    private javax.swing.JLabel IDDepartamentoText;
    private javax.swing.JTextField RA;
    private javax.swing.JLabel RAText;
    private javax.swing.JLabel SenhaText;
    private javax.swing.JTextField cargo;
    private javax.swing.JLabel cargostext;
    private javax.swing.JLabel departamentosText;
    private javax.swing.JButton insertButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logoText;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomeText;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField senha;
    private javax.swing.JTable table;
    private javax.swing.JTable tableDep;
    // End of variables declaration//GEN-END:variables
}