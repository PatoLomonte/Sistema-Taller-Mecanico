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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pato
 */
public class NuevoArreglo extends javax.swing.JFrame {

    
    
        private ArregloData arregloData = new ArregloData();
    
        private Auto autoActual;

    private DefaultTableModel modeloDetalle = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private int total = 0;
    
    
    
    public NuevoArreglo(Auto auto) {

    initComponents();
    
    this.autoActual = auto;
    armarCabeceraDetalle();
    cargarDatosAuto();
    cargarFechaActual();

    aplicarEstiloTabla();
    aplicarEstiloBotones();
    
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Llave.png")));
    setLocationRelativeTo(null);
    this.setTitle("Nuevo Arreglo");
}

    

    
    
    private void cargarDatosAuto() {

    jlCliente.setText(autoActual.getCliente().getNombre());
    jlTelefono.setText(autoActual.getCliente().getTelefono());
    jlVehiculo.setText(autoActual.getVehiculo());
    jlPatente.setText(autoActual.getPatente());
}
    
    
    private void cargarFechaActual() {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    jtFecha.setText(LocalDate.now().format(formato));
}
    
    
    
    
    private void armarCabeceraDetalle() {

    modeloDetalle.addColumn("Detalle");
    modeloDetalle.addColumn("Importe");

    TablaDetalle.setModel(modeloDetalle);
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


    jbAgregar.setBackground(new java.awt.Color(60, 130, 70));
    jbAgregar.setForeground(java.awt.Color.WHITE);
    
    jbGuardar.setBackground(new java.awt.Color(60, 130, 70));
    jbGuardar.setForeground(java.awt.Color.WHITE);

    jbQuitar.setBackground(new java.awt.Color(150, 60, 60));
    jbQuitar.setForeground(java.awt.Color.WHITE);

    jbVolver.setBackground(new java.awt.Color(70, 70, 70));
    jbVolver.setForeground(java.awt.Color.WHITE);
}
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        jlVehiculo = new javax.swing.JLabel();
        jlPatente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtKilometros = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtObservacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtDetalle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtImporte = new javax.swing.JTextField();
        jbAgregar = new javax.swing.JButton();
        jbQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Nuevo Arreglo");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Cliente:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Teléfono:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 220, 220));
        jLabel5.setText("Vehículo:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 220, 220));
        jLabel6.setText("Patente:");

        jlCliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlCliente.setForeground(new java.awt.Color(220, 220, 220));

        jlTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlTelefono.setForeground(new java.awt.Color(220, 220, 220));

        jlVehiculo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlVehiculo.setForeground(new java.awt.Color(220, 220, 220));

        jlPatente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlPatente.setForeground(new java.awt.Color(220, 220, 220));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(220, 220, 220));
        jLabel7.setText("Fecha:");

        jtFecha.setBackground(new java.awt.Color(50, 50, 50));
        jtFecha.setForeground(new java.awt.Color(220, 220, 220));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(220, 220, 220));
        jLabel8.setText("Kilómetros:");

        jtKilometros.setBackground(new java.awt.Color(50, 50, 50));
        jtKilometros.setForeground(new java.awt.Color(220, 220, 220));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(220, 220, 220));
        jLabel9.setText("Observación:");

        jtObservacion.setBackground(new java.awt.Color(50, 50, 50));
        jtObservacion.setForeground(new java.awt.Color(220, 220, 220));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(220, 220, 220));
        jLabel10.setText("Detalle:");

        jtDetalle.setBackground(new java.awt.Color(50, 50, 50));
        jtDetalle.setForeground(new java.awt.Color(220, 220, 220));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(220, 220, 220));
        jLabel11.setText("Importe:");

        jtImporte.setBackground(new java.awt.Color(50, 50, 50));
        jtImporte.setForeground(new java.awt.Color(220, 220, 220));

        jbAgregar.setBackground(new java.awt.Color(5, 5, 5));
        jbAgregar.setForeground(new java.awt.Color(0, 153, 204));
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbQuitar.setBackground(new java.awt.Color(5, 5, 5));
        jbQuitar.setForeground(new java.awt.Color(0, 153, 204));
        jbQuitar.setText("Quitar");
        jbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarActionPerformed(evt);
            }
        });

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

        jbGuardar.setBackground(new java.awt.Color(5, 5, 5));
        jbGuardar.setForeground(new java.awt.Color(0, 153, 204));
        jbGuardar.setText("Guardar Arreglo");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbVolver.setBackground(new java.awt.Color(5, 5, 5));
        jbVolver.setForeground(new java.awt.Color(0, 153, 204));
        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(220, 220, 220));
        jLabel12.setText("TOTAL:");

        jtTotal.setEditable(false);
        jtTotal.setBackground(new java.awt.Color(50, 50, 50));
        jtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(24, 24, 24)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(jlTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlPatente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbGuardar))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(102, 102, 102)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(jtTotal))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addComponent(jlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(jlVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar)
                    .addComponent(jbQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        
        try {

        String descripcion = jtDetalle.getText().trim();
        String importeTexto = jtImporte.getText().trim();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el detalle del arreglo.");
            return;
        }

        if (importeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el importe.");
            return;
        }

        int importe = Integer.parseInt(importeTexto);

        if (importe <= 0) {
            JOptionPane.showMessageDialog(null, "El importe debe ser mayor a 0.");
            return;
        }

        modeloDetalle.addRow(new Object[]{
            descripcion,
            importe
        });

        actualizarTotal();

        limpiarDetalle();

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(null, "El importe debe ser un número válido.");
    }
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        
            int fila = TablaDetalle.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un detalle para quitar.");
            return;
        }

        modeloDetalle.removeRow(fila);

        actualizarTotal();
        
    }//GEN-LAST:event_jbQuitarActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        
        GestionAuto gestion = new GestionAuto(autoActual);
        gestion.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
            if (modeloDetalle.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Agregue al menos un detalle al arreglo.");
            return;
        }

        try {

            String fechaTexto = jtFecha.getText().trim();
            String kilometrosTexto = jtKilometros.getText().trim();
            String observacion = jtObservacion.getText().trim();

            if (fechaTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese la fecha.");
                return;
            }

            int kilometros = 0;

            if (!kilometrosTexto.isEmpty()) {
                kilometros = Integer.parseInt(kilometrosTexto);
            }

            if (kilometros < 0) {
                JOptionPane.showMessageDialog(null, "Los kilómetros no pueden ser negativos.");
                return;
            }

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate fecha =
                    LocalDate.parse(fechaTexto, formato);

            LocalDateTime fechaArreglo = fecha.atStartOfDay();

            Arreglo arreglo = new Arreglo(
                    autoActual,
                    fechaArreglo,
                    kilometros,
                    total,
                    observacion,
                    false
            );

            int idArreglo = arregloData.guardarArreglo(arreglo);

            if (idArreglo == -1) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el arreglo.");
                return;
            }

            for (int i = 0; i < modeloDetalle.getRowCount(); i++) {

                String descripcion = modeloDetalle.getValueAt(i, 0).toString();

                int importe = Integer.parseInt(modeloDetalle.getValueAt(i, 1).toString());

                DetalleArreglo detalle = new DetalleArreglo(arreglo, descripcion, importe);

                arregloData.guardarDetalleArreglo(detalle);
            }

            JOptionPane.showMessageDialog(null, "Arreglo guardado correctamente.");

            GestionAuto gestion = new GestionAuto(autoActual);
            gestion.setVisible(true);

            this.dispose();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Los kilómetros deben ser un número válido.");

        } catch (DateTimeParseException ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "La fecha debe tener el formato dd/MM/yyyy. Ejemplo: 10/07/2026"
            );
        }
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    
    private void actualizarTotal() {

    total = 0;

    for (int i = 0; i < modeloDetalle.getRowCount(); i++) {

        int importe = Integer.parseInt(
                modeloDetalle.getValueAt(i, 1).toString()
        );

        total += importe;
    }

    jtTotal.setText("$ " + total);
}
    

    private void limpiarDetalle() {

    jtDetalle.setText("");
    jtImporte.setText("");

    jtDetalle.requestFocus();
}
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlPatente;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JLabel jlVehiculo;
    private javax.swing.JTextField jtDetalle;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtImporte;
    private javax.swing.JTextField jtKilometros;
    private javax.swing.JTextField jtObservacion;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
