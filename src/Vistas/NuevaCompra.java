package Vistas;

import Entidades.Casa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import AccesoDatos.CompraData;
import AccesoDatos.CasaData;
import Entidades.Compra;
import Entidades.DetalleCompra;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class NuevaCompra extends javax.swing.JFrame {

    
    
    private Casa casaActual;

private DefaultTableModel modeloDetalles = new DefaultTableModel() {

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
};

private int total = 0;
private CompraData compraData = new CompraData();
private CasaData casaData = new CasaData();
    




public NuevaCompra(Casa casa) {
    initComponents();
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Llave.png")));
    this.casaActual = casa;
    jspCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
    aplicarEstiloTabla();
    aplicarEstiloBotones();
    armarCabeceraTabla();
    cargarDatosCasa();
    setLocationRelativeTo(null);
    this.setTitle("Nueva Compra");
}

    
    

private void cargarDatosCasa() {

    jtCasa.setText(casaActual.getNombre());
    jtSaldoActual.setText("$ " + casaActual.getSaldo());
}

private void armarCabeceraTabla() {

    modeloDetalles.addColumn("Cantidad");
    modeloDetalles.addColumn("Código");
    modeloDetalles.addColumn("Descripción");
    modeloDetalles.addColumn("Precio Unitario");
    modeloDetalles.addColumn("Subtotal");

    TablaDetalles.setModel(modeloDetalles);
}



private void calcularSubtotal() {

    try {

        int cantidad = (Integer) jspCantidad.getValue();

        int precio = 0;

        if (!jtPrecio.getText().trim().isEmpty()) {
            precio = Integer.parseInt(jtPrecio.getText().trim());
        }

        int subtotal = cantidad * precio;

        jtSubtotal.setText(String.valueOf(subtotal));

    } catch (NumberFormatException ex) {

        jtSubtotal.setText("0");
    }
}



private void actualizarTotal() {

    total = 0;

    for (int i = 0; i < modeloDetalles.getRowCount(); i++) {

        int subtotal = Integer.parseInt(
            modeloDetalles.getValueAt(i, 4).toString()
        );

        total += subtotal;
    }

    jtTotal.setText("$ " + total);
}





private void limpiarDetalle() {

    jspCantidad.setValue(1);
    jtCodigo.setText("");
    jtDescripcion.setText("");
    jtPrecio.setText("");
    jtSubtotal.setText("");

    jtCodigo.requestFocus();
}




private void aplicarEstiloTabla() {

        TablaDetalles.setRowHeight(28);
        TablaDetalles.setFont(new java.awt.Font("Segoe UI", 0, 14));

        TablaDetalles.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", 1, 14)
        );

        TablaDetalles.setSelectionBackground(new java.awt.Color(180, 205, 235));
        TablaDetalles.setSelectionForeground(java.awt.Color.BLACK);

        TablaDetalles.setGridColor(new java.awt.Color(220, 220, 220));
}




private void aplicarEstiloBotones() {

    jbGuardar.setBackground(new java.awt.Color(60, 130, 70));
    jbGuardar.setForeground(java.awt.Color.WHITE);

    jbAgregar.setBackground(new java.awt.Color(60, 130, 70));
    jbAgregar.setForeground(java.awt.Color.WHITE);

    jbQuitar.setBackground(new java.awt.Color(70, 90, 120));
    jbQuitar.setForeground(java.awt.Color.WHITE);

    jbVolver.setBackground(new java.awt.Color(70, 70, 70));
    jbVolver.setForeground(java.awt.Color.WHITE);

}






    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtCasa = new javax.swing.JTextField();
        jtFecha = new javax.swing.JTextField();
        jtObservacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtSaldoActual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtComprobante = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtSubtotal = new javax.swing.JTextField();
        jbAgregar = new javax.swing.JButton();
        jspCantidad = new javax.swing.JSpinner();
        jbVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalles = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jbQuitar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Casa:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Observacion:");

        jtCasa.setEditable(false);
        jtCasa.setBackground(new java.awt.Color(50, 50, 50));
        jtCasa.setForeground(new java.awt.Color(220, 220, 220));

        jtFecha.setBackground(new java.awt.Color(50, 50, 50));
        jtFecha.setForeground(new java.awt.Color(220, 220, 220));

        jtObservacion.setBackground(new java.awt.Color(50, 50, 50));
        jtObservacion.setForeground(new java.awt.Color(220, 220, 220));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Saldo actual:");

        jtSaldoActual.setEditable(false);
        jtSaldoActual.setBackground(new java.awt.Color(50, 50, 50));
        jtSaldoActual.setForeground(new java.awt.Color(220, 220, 220));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(220, 220, 220));
        jLabel12.setText("N° Comporobante:");

        jtComprobante.setBackground(new java.awt.Color(50, 50, 50));
        jtComprobante.setForeground(new java.awt.Color(220, 220, 220));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jtCasa, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtSaldoActual, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(jtComprobante))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtSaldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(60, 60, 60));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 220, 220));
        jLabel5.setText("Cantidad:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 220, 220));
        jLabel6.setText("Código:");

        jtCodigo.setBackground(new java.awt.Color(50, 50, 50));
        jtCodigo.setForeground(new java.awt.Color(220, 220, 220));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(220, 220, 220));
        jLabel7.setText("Descripción:");

        jtDescripcion.setBackground(new java.awt.Color(50, 50, 50));
        jtDescripcion.setForeground(new java.awt.Color(220, 220, 220));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(220, 220, 220));
        jLabel8.setText("Precio:");

        jtPrecio.setBackground(new java.awt.Color(50, 50, 50));
        jtPrecio.setForeground(new java.awt.Color(220, 220, 220));
        jtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecioKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(220, 220, 220));
        jLabel9.setText("Subtotal:");

        jtSubtotal.setBackground(new java.awt.Color(50, 50, 50));
        jtSubtotal.setForeground(new java.awt.Color(220, 220, 220));

        jbAgregar.setBackground(new java.awt.Color(5, 5, 5));
        jbAgregar.setForeground(new java.awt.Color(51, 204, 0));
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jspCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspCantidadStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspCantidad))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jbAgregar)
                        .addGap(23, 23, 23))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar)
                    .addComponent(jspCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jbVolver.setBackground(new java.awt.Color(5, 5, 5));
        jbVolver.setForeground(new java.awt.Color(255, 102, 51));
        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        TablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaDetalles);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(200, 200, 200));
        jLabel10.setText("Detalle de la Compra");

        jbQuitar.setBackground(new java.awt.Color(5, 5, 5));
        jbQuitar.setForeground(new java.awt.Color(0, 153, 204));
        jbQuitar.setText("Quitar");
        jbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(220, 220, 220));
        jLabel11.setText("Total:");

        jtTotal.setEditable(false);
        jtTotal.setBackground(new java.awt.Color(50, 50, 50));
        jtTotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(204, 204, 0));

        jbGuardar.setBackground(new java.awt.Color(5, 5, 5));
        jbGuardar.setForeground(new java.awt.Color(51, 204, 0));
        jbGuardar.setText("Guardar Compra");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jbGuardar)
                        .addGap(183, 183, 183)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbQuitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbQuitar))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

        try {

        int cantidad = (Integer) jspCantidad.getValue();

        String codigo = jtCodigo.getText().trim();

        String descripcion = jtDescripcion.getText().trim();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la descripción del repuesto.");
            return;
        }

        int precioUnitario = Integer.parseInt(jtPrecio.getText().trim());

        int subtotal = cantidad * precioUnitario;

        modeloDetalles.addRow(new Object[]{
            cantidad,
            codigo,
            descripcion,
            precioUnitario,
            subtotal
        });

        actualizarTotal();

        limpiarDetalle();

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(null, "El precio unitario debe ser un número válido.");
    }

    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        
        GestionCasa gestion = new GestionCasa(casaActual);
        gestion.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        
        int fila = TablaDetalles.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un detalle para quitar.");
        return;
    }

    modeloDetalles.removeRow(fila);

    actualizarTotal();
        
    }//GEN-LAST:event_jbQuitarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        if (modeloDetalles.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Agregue al menos un producto a la compra.");
        return;
    }

    String comprobante = jtComprobante.getText().trim();
    String observacion = jtObservacion.getText().trim();

    if (comprobante.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese el número de comprobante.");
        return;
    }

    LocalDateTime fechaCompra;

    try {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fecha = LocalDate.parse(jtFecha.getText().trim(), formato);

        fechaCompra = fecha.atStartOfDay();

    } catch (DateTimeParseException ex) {

        JOptionPane.showMessageDialog(
            null,
            "La fecha debe tener el formato dd/MM/yyyy. Ejemplo: 10/04/2024"
        );

        return;
    }

    Compra compra = new Compra(
        casaActual,
        fechaCompra,
        comprobante,
        total,
        observacion,
        false
    );

    int idCompra = compraData.guardarCompra(compra);

    if (idCompra == -1) {
        JOptionPane.showMessageDialog(null, "No se pudo guardar la compra.");
        return;
    }

    for (int i = 0; i < modeloDetalles.getRowCount(); i++) {

        int cantidad = Integer.parseInt(
            modeloDetalles.getValueAt(i, 0).toString()
        );

        String codigo = modeloDetalles.getValueAt(i, 1).toString();

        String descripcion = modeloDetalles.getValueAt(i, 2).toString();

        int precioUnitario = Integer.parseInt(modeloDetalles.getValueAt(i, 3).toString());

        int subtotal = Integer.parseInt(modeloDetalles.getValueAt(i, 4).toString());

        DetalleCompra detalle = new DetalleCompra(
            compra,
            cantidad,
            codigo,
            descripcion,
            precioUnitario,
            subtotal
        );

        compraData.guardarDetalleCompra(detalle);
    }

    casaData.sumarSaldo(casaActual.getIdCasa(), total);

    JOptionPane.showMessageDialog(null, "Compra guardada correctamente.");

    Casa casaActualizada = casaData.buscarCasaPorId(casaActual.getIdCasa());

    GestionCasa gestion = new GestionCasa(casaActualizada);
    gestion.setVisible(true);

    this.dispose();
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioKeyReleased
        
        calcularSubtotal();
        
    }//GEN-LAST:event_jtPrecioKeyReleased

    private void jspCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspCantidadStateChanged
        
        calcularSubtotal();
        
    }//GEN-LAST:event_jspCantidadStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDetalles;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JSpinner jspCantidad;
    private javax.swing.JTextField jtCasa;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtComprobante;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtObservacion;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTextField jtSaldoActual;
    private javax.swing.JTextField jtSubtotal;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
