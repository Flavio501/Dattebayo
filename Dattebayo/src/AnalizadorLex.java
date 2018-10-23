
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import javax.swing.table.DefaultTableModel;
public class AnalizadorLex extends javax.swing.JFrame {

    ArrayList<String> tipo = new ArrayList<>();
    ArrayList<String> tipotoken = new ArrayList<>();
    ArrayList<String> errores = new ArrayList<>();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();
    DefaultTableModel dtm3 = new DefaultTableModel();

    public AnalizadorLex() {
        initComponents();
        setLocationRelativeTo(this);
        mostrar();
    }
    int k = 0;

    private ArrayList<Token> lex(String input) {
        final ArrayList<Token> tokens = new ArrayList<Token>();
        StringTokenizer st = new StringTokenizer(input,"\t\n\r\f()[]{}+/-*; ",true);
        
        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            System.out.println(palabra);
            boolean matched = false;

            int cont = 0;
            for (Tipo tokenTipo : Tipo.values()) {
            	
                if (palabra.matches(tokenTipo.patron)) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tk.setEntrada(cont);
                    tokens.add(tk);
                    matched = true;
                    cont++;
                    //palabra = palabra.replaceFirst(matcher.group(),"");
                    //st = new StringTokenizer(input.replaceFirst(matcher.group(),""));
                    //break;
                }
            }
            if (!matched && palabra.trim().length() != 0) {
                errores.add(palabra);
                for (int i = 0; i < errores.size(); i++) {
                    dtm2.addRow(new Object[]{errores.get(i)});
                }
                errores.clear();
            }
        }
        return tokens;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        btnanalizar = new javax.swing.JButton();
        btnsubir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtentrada = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnanalizar.setText("analizar");
        btnanalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanalizarActionPerformed(evt);
            }
        });

        btnsubir.setText("subir archivo");
        btnsubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubirActionPerformed(evt);
            }
        });

        txtentrada.setColumns(20);
        txtentrada.setRows(5);
        jScrollPane1.setViewportView(txtentrada);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        jButton1.setText("Limpiar Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);
        
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
            jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnanalizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnsubir)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    			.addGap(18, 18, 18)
                    			.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnanalizar)
                    .addComponent(btnsubir)
                    .addComponent(jButton1))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                		.addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)	
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
   int j = 0;
    int i = 0;
    private void btnanalizarActionPerformed(java.awt.event.ActionEvent evt) {


        if (txtentrada.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite caracteres en el campo");
        }
        ArrayList<Token> tokens = lex(txtentrada.getText());
        for (Token token : tokens) {
            String a = ("" + token.getTipo());
            String b = ("" + token.getValor());

            tipo.add(a);
            tipotoken.add(b);
            dtm.addRow(new Object[]{tipo.get(j), tipotoken.get(j)});
            j++;

        }

    }

    public void abrir() {
        FileReader fr = null;
        BufferedReader bf = null;
        File archivo = null;
        try {
            
            archivo = new File("/home/flavio501/Documents/codeTest.txt");
            fr = new FileReader(archivo);
            bf = new BufferedReader(fr);


            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                txtentrada.setText(linea);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void  mostrar() {

        try {
            dtm.addColumn("TIPO");
            dtm.addColumn("TOKEN");
            dtm2.addColumn("ERRORES");
            dtm3.addColumn("Regla");
            
            jTable2.setModel(dtm2);
            jTable1.setModel(dtm);
            jTable3.setModel(dtm3);


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error mostrar" + ex);
        }
    }

    private void btnsubirActionPerformed(java.awt.event.ActionEvent evt) {
     
        abrir();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int a = dtm.getRowCount();
        int b= dtm2.getRowCount();
        for (int i = 0; i < a; i++) {
            dtm.removeRow(0);  
        }
        for (int i = 0; i < b; i++) {
            dtm2.removeRow(0);  
        }
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalizadorLex().setVisible(true);
            }
        });
    }


    private javax.swing.JButton btnanalizar;
    private javax.swing.JButton btnsubir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea txtentrada;

}
