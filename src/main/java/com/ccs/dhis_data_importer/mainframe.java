/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccs.dhis_data_importer;

import java.io.BufferedReader;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


/**
 *
 * @author Agnaldo Samuel
 */
public class mainframe extends javax.swing.JFrame {

    /**
     * Creates new form mainframe
     */
    File selectedFile;
    Process mProcess; // 
    Process process;
   ReadWriteTextFile rwTextFile;
   List<String> logs;
   ReadStream s1;
   ReadStream s2;
   Helper help;
   String filePath= "C:\\py-dhis-data-entry\\config\\extra_config.py";
   List <String> formNames ;
   List <String> periodNames;
   
    public mainframe() {
        
        initComponents();
        help = new Helper();
 
        rwTextFile = new ReadWriteTextFile();
        logs = new ArrayList<>();
        PrintStream printStream = new PrintStream(new CustomOutputStream(txt_logs));
        System.setOut(printStream);
        System.setErr(printStream);
         AutoCompletion.enable(cmb_unidade_sanitaria);
        FillFormCombo();
        FillPeriodCombo();
       
       
    }
    
     private void FillPeriodCombo (){
        
           if( help.CheckFileExists(filePath)){
                   try {
               periodNames =Helper.GetPeriods(filePath);
               cmb_periodo.setModel(new DefaultComboBoxModel(periodNames.toArray()));
               AutoCompletion.enable(cmb_periodo);
      } catch ( IOException e) {
                System.out.println("Erro ao ler as configuracoes extras: verifique se existe o ficheiro C:\\py-dhis-data-entry\\config\\extra_config.py " + e.getMessage());
            }
        } else {
               
                     System.out.println("Erro ao ler as configuracoes extras: verifique se existe o ficheiro C:\\py-dhis-data-entry\\config\\extra_config.py ");
               
           }
    }
     private void FillFormCombo (){
        
           if( help.CheckFileExists(filePath)){
            try {
                formNames = Helper.GetFormNames(filePath);
                cmb_formulario.setModel(new DefaultComboBoxModel(formNames.toArray()));
                 AutoCompletion.enable(cmb_formulario);
            } catch ( IOException e) {
                System.out.println("Erro ao ler as configuracoes extras: verifique se existe o ficheiro C:\\py-dhis-data-entry\\config\\extra_config.py " + e.getMessage());
            }
            
        } else {
               
                     System.out.println("Erro ao ler as configuracoes extras: verifique se existe o ficheiro C:\\py-dhis-data-entry\\config\\extra_config.py ");
               
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

        jPanel1 = new javax.swing.JPanel();
        bnt_load_file = new javax.swing.JButton();
        lbl_file_location = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb_distritos = new javax.swing.JComboBox<>();
        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_unidade_sanitaria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmb_periodo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmb_formulario = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmb_override = new javax.swing.JComboBox<>();
        btn_import = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_logs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bnt_load_file.setText("Carregar ficheiro");
        bnt_load_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_load_fileActionPerformed(evt);
            }
        });

        lbl_file_location.setText("Ficheiro:");

        jLabel1.setText("Distrito:");

        cmb_distritos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kamaxakeni", "Kampfumu", "Kamubukwana", "Kanyaka", "Katembe", "Nlhamankulu", "Kamavota" }));

        jLabel2.setText("Username:");

        lbl_password.setText("Password:");

        jLabel4.setText("Unidade Sanitaria:");

        cmb_unidade_sanitaria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1_de_junho_cs", "albasine_cs", "hulene_psa", "mavalane_cs", "mavalane_hg", "pescadores_ps", "romao_psa", "1_de_maio_cs   ", "polana_canico_cs", "1_alto_mae_csurb", "hospital_central_de_mapito_hc", "hospital_central_pediatrico_de_maputo_hc", "malhangalene_cs", "maxaquene_csurb", "Hospital_militar_de_maputo", "polana_cimento_csurb", "porto_csurb", "bagamoio_cs", "hospital_psiquiatrico_do_infulene_cs", "inhagoia_ps", "magoanine_ps", "magoanine_tenda_psa", "zimpeto_ps", "inhaca_ps", "catembe_cs", "chamissava_cs", "incassane_cs", "mutsekwa_ps", "centro_de_saude_do_chamanculo_cs   ", "chamanculo_hg", "jose_macamo_cs", "jose_macamo_HG", "xipamanine_csurb" }));

        jLabel5.setText("Periodo: ");

        jLabel6.setText("Formulario:");

        cmb_formulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_formularioActionPerformed(evt);
            }
        });

        jLabel7.setText("Override:");

        cmb_override.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nao", "Sim" }));

        btn_import.setText("Importar");
        btn_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importActionPerformed(evt);
            }
        });

        txt_logs.setColumns(20);
        txt_logs.setRows(5);
        jScrollPane1.setViewportView(txt_logs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_import, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))))
                            .addGap(57, 57, 57)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmb_unidade_sanitaria, javax.swing.GroupLayout.Alignment.TRAILING, 0, 327, Short.MAX_VALUE)
                                .addComponent(cmb_distritos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb_override, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(lbl_password))
                                    .addGap(57, 57, 57)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_username)
                                        .addComponent(txt_password)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(lbl_file_location, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bnt_load_file, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnt_load_file)
                    .addComponent(lbl_file_location))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_distritos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_unidade_sanitaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_override, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_import, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importActionPerformed
        // TODO add your handling code here:

        Charset charset = StandardCharsets.UTF_8;

        String distrito = cmb_distritos.getSelectedItem().toString();
        String periodo = cmb_periodo.getSelectedItem().toString();
        String us = cmb_unidade_sanitaria.getSelectedItem().toString();
        String formulario = cmb_formulario.getSelectedItem().toString();
        String override = cmb_override.getSelectedItem().toString();
        String username = txt_username.getText();
        String password = new String(txt_password.getPassword());
        String[] array_config = {"distrito", "periodo", "us", "formulario", "override", "username", "password"};

        Path path;
        // check if its an exxcell file
        int i = lbl_file_location.getText().lastIndexOf('.');
        String extension;
        if (i > 0  ) {

            try {
                txt_logs.setText("");
                txt_logs.setText("Loading configuration parameters ...");
                txt_logs.append("\n");
                extension = lbl_file_location.getText().substring(i + 1);
                if(extension.contains("xlsx")){
                    
               
                File empty_file = new File("C:\\py-dhis-data-entry\\config\\empty_config.yaml");
		File config_file = new File("C:\\py-dhis-data-entry\\config\\dhis_config.yaml");
                com.google.common.io.Files.copy(empty_file,config_file);
                
                //username
                path = Paths.get("C:\\py-dhis-data-entry\\config\\dhis_config.yaml");
                String content = new String(Files.readAllBytes(path), charset);
                content = content.replaceAll("dhis2_username:", "dhis2_username: " + username);
                Files.write(path, content.getBytes(charset));
                
                //password
                String content_1 = new String(Files.readAllBytes(path), charset);
                content_1 = content_1.replaceAll("dhis2_password:", "dhis2_password: " + password);
                Files.write(path, content_1.getBytes(charset));
                
                //distrito
                String content_2 = new String(Files.readAllBytes(path), charset);
                content_2 = content_2.replaceAll("distrito:", "distrito: " + distrito);
                Files.write(path, content_2.getBytes(charset));
                
                //unidade sanitaria
                String content_3 = new String(Files.readAllBytes(path), charset);
                content_3 = content_3.replaceAll("unidade_sanitaria:", "unidade_sanitaria: " + us);
                Files.write(path, content_3.getBytes(charset));
                
                //periodo
                String content_4 = new String(Files.readAllBytes(path), charset);
                content_4 = content_4.replaceAll("periodo:", "periodo: " + periodo);
                Files.write(path, content_4.getBytes(charset));
                
                //formulario
                String content_5 = new String(Files.readAllBytes(path), charset);
                content_5 = content_5.replaceAll("formulario:", "formulario: " + formulario);
                Files.write(path, content_5.getBytes(charset));
                
                 //excell location
                String content_6 = new String(Files.readAllBytes(path), charset);
                content_6 = content_6.replaceAll("excell_location:", "excell_location: " + selectedFile.getName());
                Files.write(path, content_6.getBytes(charset));
                
                  //override
                String content_7 = new String(Files.readAllBytes(path), charset);
                content_7 = content_7.replaceAll("override:", "override: " + override);
                Files.write(path, content_7.getBytes(charset));
                
                
                 txt_logs.append("Config ok...");
                     txt_logs.append("\n");
                 txt_logs.append("Abrindo Navegador...");
                     txt_logs.append("\n");
                     
                     runScript();
                     
                     
                } else {
                    
                      JOptionPane.showMessageDialog(rootPane, "Ficheiro Incorreto");
                
                }


            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
                   txt_logs.append("IOException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
                txt_logs.append("Exception: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ficheiro Incorreto");
        }


    }//GEN-LAST:event_btn_importActionPerformed

    private void bnt_load_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_load_fileActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            if (selectedFile.getName().length() > 20) {

                lbl_file_location.setText(selectedFile.getName().substring(selectedFile.getName().length() - 20, selectedFile.getName().length()));
            } else {
              lbl_file_location.setText(selectedFile.getName());
            }

        }
    }//GEN-LAST:event_bnt_load_fileActionPerformed

    private void cmb_formularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_formularioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_formularioActionPerformed

    
    
    public void runScript(){

       try{
             txt_logs.setText("");
             
             process = Runtime.getRuntime().exec("python C:\\py-dhis-data-entry\\navigate.py");
             // process = Runtime.getRuntime().exec(new String[]{"python C:\\py-dhis-data-entry\\navigate.py","arg1","arg2"});
             mProcess = process;
             
            s1 = new ReadStream("stdin", process.getInputStream ());
            s2 = new ReadStream("stderr", process.getErrorStream ());
            s1.start ();
            s2.start ();
            int status=  process.waitFor();
            System.out.println("status :" + status);
            
            // logs = rwTextFile.readSmallTextFile("C:\\py-dhis-data-entry\\logs.txt");
            // for (String log : logs) {
            // txt_logs.append(log + "\n");
        
            //  }
//             InputStream stdout = mProcess.getInputStream();
//      BufferedReader reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
//      String line;
//        while ((line = reader.readLine()) != null ) {
//            
//            if(line.contains("J144")){
//                break;
//            }else {
//            
//            txt_logs.append(line.toString()+ "\n");
//
//            } 
//            }
       }catch(Exception e) {
          System.out.println("Exception Raised" + e.toString());
             txt_logs.append("Exception Raised" + e.toString());
       } finally {
            if(process != null){
                            process.destroy();
            
            }

}
//      InputStream stdout = mProcess.getInputStream();
//      BufferedReader reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
//      String line;
//       try{
//            while ((line = reader.readLine()).length()> 0) {
//                 txt_logs.append(line);
//                 txt_logs.append("\n");
//            }
//           logs = rwTextFile.readSmallTextFile("C:\\py-dhis-data-entry\\logs.txt");
//           for (String log : logs) {
//             txt_logs.append(log);
//             txt_logs.append("\n");
//           }
//       }catch(IOException e){
//             System.out.println("Exception in reading output"+ e.toString());
//             txt_logs.append("Exception in reading output"+ e.toString());
//       }
}

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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_load_file;
    private javax.swing.JButton btn_import;
    private javax.swing.JComboBox<String> cmb_distritos;
    private javax.swing.JComboBox<String> cmb_formulario;
    private javax.swing.JComboBox<String> cmb_override;
    private javax.swing.JComboBox<String> cmb_periodo;
    private javax.swing.JComboBox<String> cmb_unidade_sanitaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_file_location;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JTextArea txt_logs;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
