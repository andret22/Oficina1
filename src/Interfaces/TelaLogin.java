package Interfaces;

import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class TelaLogin extends javax.swing.JFrame {
    
    Connection conn;
    
    public TelaLogin(Connection conn) {
        this.conn = conn;
        initComponents();
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

        logoTexte = new javax.swing.JLabel();
        loginText = new javax.swing.JLabel();
        SenhaText = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        senha = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        modeSelector = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoTexte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Images/logoUTF.png"))); // NOI18N

        loginText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loginText.setText("Login");

        SenhaText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SenhaText.setText("Senha");

        loginButton.setText("Login");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        modeSelector.setText("Membro");
        modeSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modeSelectorMouseClicked(evt);
            }
        });

        jLabel1.setText("Tipo de usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(logoTexte))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SenhaText)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loginText)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(senha, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modeSelector)
                                    .addComponent(jLabel1))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoTexte)
                        .addGap(43, 43, 43)
                        .addComponent(loginText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modeSelector)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SenhaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
   
        try{
            int log = Integer.parseInt(login.getText());
            String sen = senha.getText();
            Statement st = conn.createStatement();
            if(modeSelector.getText().equals("Membro")){
                ResultSet rs = st.executeQuery("SELECT * FROM membro WHERE ra LIKE "+log+" AND senha LIKE "+"'"+sen+"'");
                if(rs.next()){
                    //TO-DO
                    //Substituir "MenuPrincipalMinistrante" por "MenuMembro" assim que o mesmo estiver pronto
                    MenuPrincipal m = new MenuPrincipal(conn, rs.getString("NomeMembro"), false);
                    m.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
                }
            }else if(modeSelector.getText().equals("Ministrante")){
                ResultSet rs = st.executeQuery("SELECT * FROM ministrante WHERE SIAPE LIKE "+log+ " AND senha LIKE "+"'"+sen+"'");
                if(rs.next()){
                    MenuPrincipal m = new MenuPrincipal(conn,rs.getString("NomeMinistrante"), true);
                    m.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
                }
            }         
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!!!");
            e.printStackTrace();
        }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null, "O formato dos campos é inválido!!!");
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    private void modeSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modeSelectorMouseClicked
        if (modeSelector.isSelected()) {
            modeSelector.setText("Ministrante");
        }else {
            modeSelector.setText("Membro");
        }
    }//GEN-LAST:event_modeSelectorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SenhaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField login;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginText;
    private javax.swing.JLabel logoTexte;
    private javax.swing.JToggleButton modeSelector;
    private javax.swing.JTextField senha;
    // End of variables declaration//GEN-END:variables
}