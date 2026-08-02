/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Autos;

import AccesoDatos.ArregloData;
import Entidades.Arreglo;
import Entidades.Auto;
import Entidades.DetalleArreglo;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pato
 */
public class DetalleArregloVista extends javax.swing.JFrame {

    
    
        private Auto autoActual;
    private Arreglo arregloActual;

    private ArregloData arregloData = new ArregloData();

    private DefaultTableModel modeloDetalle = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    
    
    
    public DetalleArregloVista(Auto auto, Arreglo arreglo) {

    initComponents();

    this.autoActual = auto;
    this.arregloActual = arreglo;

    armarCabeceraDetalle();
    cargarDatos();
    cargarDetalle();
    
    aplicarEstiloTabla();
    aplicarEstiloBotones();

    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Llave.png")));
    setLocationRelativeTo(null);
    this.setTitle("Detalle de Arreglo");
}

    
    
    
    private void aplicarEstiloTabla() {

        TablaDetalle.setRowHeight(28);
        TablaDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14));

        TablaDetalle.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", 1, 14)
        );

        TablaDetalle.setSelectionBackground(new java.awt.Color(180, 205, 235));
        TablaDetalle.setSelectionForeground(java.awt.Color.BLACK);

        TablaDetalle.setGridColor(new java.awt.Color(220, 220, 220));
}
    
    
    
    
    
    private void aplicarEstiloBotones() {

    jbPDF.setBackground(new java.awt.Color(70, 90, 120));
    jbPDF.setForeground(java.awt.Color.WHITE);
        
    jbVolver.setBackground(new java.awt.Color(70, 70, 70));
    jbVolver.setForeground(java.awt.Color.WHITE);
    
}
    
    
    
    
    
    private void cargarDatos() {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    jlAuto.setText(autoActual.getPatente() + " - " + autoActual.getVehiculo());

    jlFecha.setText(arregloActual.getFecha().format(formato));
    jlKm.setText(String.valueOf(arregloActual.getKilometros()));
    jlObs.setText(arregloActual.getObservacion());
    jlTotal.setText("$ " + arregloActual.getTotal());
}
    
    
    
    private void armarCabeceraDetalle() {

    modeloDetalle.addColumn("Detalle");
    modeloDetalle.addColumn("Importe");

    TablaDetalle.setModel(modeloDetalle);
}
    
    
    
    
    private void cargarDetalle() {

    modeloDetalle.setRowCount(0);

    ArrayList<DetalleArreglo> detalles =
            arregloData.obtenerDetalleArreglo(arregloActual.getIdArreglo());

    for (DetalleArreglo detalle : detalles) {

        modeloDetalle.addRow(new Object[]{
            detalle.getDescripcion(),
            "$ " + detalle.getImporte()
        });
    }
}
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlAuto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlObs = new javax.swing.JLabel();
        jlKm = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        jbVolver = new javax.swing.JButton();
        jbPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Detalle Arreglo");

        jPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jlAuto.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jlAuto.setForeground(new java.awt.Color(220, 220, 220));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Fecha:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Kilómetros:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(220, 220, 220));
        jLabel8.setText("Observacion:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(220, 220, 220));
        jLabel9.setText("Total:");

        jlFecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(220, 220, 220));

        jlObs.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlObs.setForeground(new java.awt.Color(220, 220, 220));

        jlKm.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlKm.setForeground(new java.awt.Color(220, 220, 220));

        jlTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(220, 220, 220));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlObs, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlKm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jlKm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addComponent(jlObs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaDetalle);

        jbVolver.setBackground(new java.awt.Color(5, 5, 5));
        jbVolver.setForeground(new java.awt.Color(0, 153, 204));
        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbPDF.setBackground(new java.awt.Color(5, 5, 5));
        jbPDF.setForeground(new java.awt.Color(0, 153, 204));
        jbPDF.setText("Generar PDF");
        jbPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed

        GestionAuto gestion = new GestionAuto(autoActual);
        gestion.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPDFActionPerformed
                                            

        try {

            ArrayList<DetalleArreglo> detalles = arregloData.obtenerDetalleArreglo(arregloActual.getIdArreglo());

            if (detalles.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este arreglo no tiene detalles cargados.");
                return;
            }

            PDFArreglo pdf = new PDFArreglo();

            pdf.generarPDF(autoActual, arregloActual, detalles);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error al generar el PDF.");
            ex.printStackTrace();
        }
    
    }//GEN-LAST:event_jbPDFActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbPDF;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlAuto;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlKm;
    private javax.swing.JLabel jlObs;
    private javax.swing.JLabel jlTotal;
    // End of variables declaration//GEN-END:variables
}
