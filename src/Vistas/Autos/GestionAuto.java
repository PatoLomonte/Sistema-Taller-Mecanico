package Vistas.Autos;

import AccesoDatos.ArregloData;
import Entidades.Arreglo;
import Entidades.Auto;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



    

public class GestionAuto extends javax.swing.JFrame {

    
    private Auto autoActual;

    private ArregloData arregloData = new ArregloData();

    private DefaultTableModel modeloArreglos = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
};
      
    
    
    public GestionAuto(Auto auto) {

        initComponents();
        
        this.autoActual = auto;
        armarCabeceraArreglos();
        cargarDatosAuto();
        cargarArreglosAuto();

        aplicarEstiloBotones();
        aplicarEstiloTabla();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Llave.png")));
        setLocationRelativeTo(null);
        this.setTitle("Gestión de Auto");
}

    
    
    private void cargarDatosAuto() {

    jtNombre.setText(autoActual.getCliente().getNombre());
    jtTelefono.setText(autoActual.getCliente().getTelefono());
    jtAuto.setText(autoActual.getVehiculo());
    jtPatente.setText(autoActual.getPatente());
    jtKilometros.setText(String.valueOf(autoActual.getKilometros()));
}
    
    
    
    
    private void cargarArreglosAuto() {

        modeloArreglos.setRowCount(0);

        ArrayList<Arreglo> arreglos =
                arregloData.listarArreglosPorAuto(autoActual);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Arreglo arreglo : arreglos) {

            modeloArreglos.addRow(new Object[]{
                arreglo.getIdArreglo(),
                arreglo.getFecha().format(formato),
                arreglo.getKilometros(),
                "$ " + arreglo.getTotal(),
                arreglo.getObservacion()
            });
        }
}
    
    
    
    
    
    private void armarCabeceraArreglos() {

    modeloArreglos.addColumn("ID");
    modeloArreglos.addColumn("Fecha");
    modeloArreglos.addColumn("Kilómetros");
    modeloArreglos.addColumn("Total");
    modeloArreglos.addColumn("Observación");

    TablaArreglos.setModel(modeloArreglos);

    TablaArreglos.getColumnModel().getColumn(0).setMinWidth(0);
    TablaArreglos.getColumnModel().getColumn(0).setMaxWidth(0);
    TablaArreglos.getColumnModel().getColumn(0).setWidth(0);
}
    
    
    
    
    private void aplicarEstiloTabla() {

        TablaArreglos.setRowHeight(28);
        TablaArreglos.setFont(new java.awt.Font("Segoe UI", 0, 14));

        TablaArreglos.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", 1, 14)
        );

        TablaArreglos.setSelectionBackground(new java.awt.Color(180, 205, 235));
        TablaArreglos.setSelectionForeground(java.awt.Color.BLACK);

        TablaArreglos.setGridColor(new java.awt.Color(220, 220, 220));
}
    
    
    
    
    private void aplicarEstiloBotones() {

    jbNuevoArreglo.setBackground(new java.awt.Color(60, 130, 70));
    jbNuevoArreglo.setForeground(java.awt.Color.WHITE);


    jbVerDetalle.setBackground(new java.awt.Color(70, 90, 120));
    jbVerDetalle.setForeground(java.awt.Color.WHITE);

    jbVolver.setBackground(new java.awt.Color(70, 70, 70));
    jbVolver.setForeground(java.awt.Color.WHITE);
}
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtAuto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtPatente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtKilometros = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArreglos = new javax.swing.JTable();
        jbNuevoArreglo = new javax.swing.JButton();
        jbVerDetalle = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Gestión de Autos");

        jPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Datos del Cliente:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Nombre:");

        jtNombre.setEditable(false);
        jtNombre.setBackground(new java.awt.Color(50, 50, 50));
        jtNombre.setForeground(new java.awt.Color(220, 220, 220));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Teléfono:");

        jtTelefono.setEditable(false);
        jtTelefono.setBackground(new java.awt.Color(50, 50, 50));
        jtTelefono.setForeground(new java.awt.Color(220, 220, 220));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(220, 220, 220));
        jLabel8.setText("Vehiculo:");

        jtAuto.setEditable(false);
        jtAuto.setBackground(new java.awt.Color(50, 50, 50));
        jtAuto.setForeground(new java.awt.Color(220, 220, 220));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(220, 220, 220));
        jLabel9.setText("Patente:");

        jtPatente.setEditable(false);
        jtPatente.setBackground(new java.awt.Color(50, 50, 50));
        jtPatente.setForeground(new java.awt.Color(220, 220, 220));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(220, 220, 220));
        jLabel10.setText("Kilómetros:");

        jtKilometros.setEditable(false);
        jtKilometros.setBackground(new java.awt.Color(50, 50, 50));
        jtKilometros.setForeground(new java.awt.Color(220, 220, 220));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtAuto, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jtNombre))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        TablaArreglos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaArreglos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaArreglosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaArreglos);

        jbNuevoArreglo.setBackground(new java.awt.Color(5, 5, 5));
        jbNuevoArreglo.setForeground(new java.awt.Color(0, 153, 204));
        jbNuevoArreglo.setText("Nuevo Arreglo");
        jbNuevoArreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoArregloActionPerformed(evt);
            }
        });

        jbVerDetalle.setBackground(new java.awt.Color(5, 5, 5));
        jbVerDetalle.setForeground(new java.awt.Color(0, 153, 204));
        jbVerDetalle.setText("Ver Detalle");
        jbVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerDetalleActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jbNuevoArreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jbVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevoArreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        
        BuscarAutos buscar = new BuscarAutos();
        buscar.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbNuevoArregloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoArregloActionPerformed
        
        NuevoArreglo nuevo = new NuevoArreglo(autoActual);
        nuevo.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbNuevoArregloActionPerformed

    private void jbVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerDetalleActionPerformed
        
        abrirDetalleArregloSeleccionado();
        
    }//GEN-LAST:event_jbVerDetalleActionPerformed

    private void TablaArreglosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaArreglosMouseClicked
        
            if (evt.getClickCount() == 2 && TablaArreglos.getSelectedRow() != -1) {

            abrirDetalleArregloSeleccionado();
        }
        
    }//GEN-LAST:event_TablaArreglosMouseClicked

    
    
    private void abrirDetalleArregloSeleccionado() {

    int fila = TablaArreglos.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un arreglo.");
        return;
    }

    int idArreglo = (Integer) TablaArreglos.getValueAt(fila, 0);

    Arreglo arreglo = arregloData.buscarArregloPorId(idArreglo, autoActual);

    if (arreglo == null) {
        JOptionPane.showMessageDialog(null, "No se pudo cargar el arreglo seleccionado.");
        return;
    }

    DetalleArregloVista detalle =
            new DetalleArregloVista(autoActual, arreglo);

    detalle.setVisible(true);

    this.dispose();
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaArreglos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbNuevoArreglo;
    private javax.swing.JButton jbVerDetalle;
    private javax.swing.JButton jbVolver;
    private javax.swing.JTextField jtAuto;
    private javax.swing.JTextField jtKilometros;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPatente;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables
}
