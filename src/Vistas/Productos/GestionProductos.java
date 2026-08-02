package Vistas.Productos;

import AccesoDatos.ProductoData;
import AccesoDatos.VentaProductoData;
import Entidades.DetalleVentaProducto;
import Entidades.Producto;
import Entidades.VentaProducto;
import Vistas.Menu;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GestionProductos extends javax.swing.JFrame {

    
        private ProductoData productoData = new ProductoData();
        private VentaProductoData ventaProductoData = new VentaProductoData();

                private DefaultTableModel modeloProductos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            // Editable: Código, Producto, Precio
            // No editable: ID, Stock y Categoría
            return columna == 1 || columna == 2 || columna == 4;
        }
    };

        private DefaultTableModel modeloVenta = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        private boolean cargandoTabla = false;
        private int totalVenta = 0;
    
    
    
    
    
    public GestionProductos() {
        initComponents();

        armarCabeceraProductos();
        armarCabeceraVenta();
        cargarCategoriasFiltro();

        cargarProductos();
        agregarListenerTablaProductos();

        aplicarEstiloTablaProductos();
        aplicarEstiloTablaVentas();
        aplicarEstiloBotones();

        setLocationRelativeTo(null);
        this.setTitle("Productos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Llave.png")));

        jtBuscar.requestFocus();
    }

    
    
    
    private void cargarCategoriasFiltro() {

        jcbCategoria.removeAllItems();

        jcbCategoria.addItem("Todas");
        jcbCategoria.addItem("Filtros");
        jcbCategoria.addItem("Lubricantes");
        jcbCategoria.addItem("Correas");
        jcbCategoria.addItem("Aditivos");
        jcbCategoria.addItem("Refrigerantes");
        jcbCategoria.addItem("Accesorios");
        jcbCategoria.addItem("Otros");
}
    
    
    
    
        private void armarCabeceraProductos() {

        modeloProductos.addColumn("ID");
        modeloProductos.addColumn("Código");
        modeloProductos.addColumn("Producto");
        modeloProductos.addColumn("Categoría");
        modeloProductos.addColumn("Precio");
        modeloProductos.addColumn("Stock");

        TablaProductos.setModel(modeloProductos);

        TablaProductos.getColumnModel().getColumn(0).setMinWidth(0);
        TablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaProductos.getColumnModel().getColumn(0).setWidth(0);
    }
    
    
    
    
    
        private void armarCabeceraVenta() {

        modeloVenta.addColumn("ID");
        modeloVenta.addColumn("Cantidad");
        modeloVenta.addColumn("Producto");
        modeloVenta.addColumn("Precio");

        TablaVentas.setModel(modeloVenta);

        TablaVentas.getColumnModel().getColumn(0).setMinWidth(0);
        TablaVentas.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaVentas.getColumnModel().getColumn(0).setWidth(0);
    }
        
        
        
        
        
        private void cargarProductos() {

        cargandoTabla = true;

        modeloProductos.setRowCount(0);

        String categoria = jcbCategoria.getSelectedItem().toString();

        ArrayList<Producto> productos = productoData.listarProductos(categoria);

        for (Producto p : productos) {
            modeloProductos.addRow(new Object[]{
                p.getIdProducto(),
                p.getCodigoBarra(),
                p.getNombre(),
                p.getCategoria(),
                p.getPrecio(),
                p.getStock(),
            });
        }

        cargandoTabla = false;
    }
    
    
    
    
    private void limpiarVenta() {

        modeloVenta.setRowCount(0);
        totalVenta = 0;
        jlTotal.setText("$ 0");

        jtBuscar.setText("");
        jtBuscar.requestFocus();
}
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jbNuevoProducto = new javax.swing.JButton();
        jbQuitar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtBuscar = new javax.swing.JTextField();
        jbStock = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbMenu = new javax.swing.JButton();
        jbHistorial = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox<>();
        jbActualizarPrecio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosMouseClicked(evt);
            }
        });
        TablaProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Buscar:");

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Productos");

        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaVentas);

        jbNuevoProducto.setBackground(new java.awt.Color(5, 5, 5));
        jbNuevoProducto.setForeground(new java.awt.Color(0, 153, 204));
        jbNuevoProducto.setText("Nuevo Producto");
        jbNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoProductoActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Venta:");

        jtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarKeyReleased(evt);
            }
        });

        jbStock.setBackground(new java.awt.Color(5, 5, 5));
        jbStock.setForeground(new java.awt.Color(0, 153, 204));
        jbStock.setText("Ajustar Stock");
        jbStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStockActionPerformed(evt);
            }
        });

        jbBaja.setBackground(new java.awt.Color(5, 5, 5));
        jbBaja.setForeground(new java.awt.Color(0, 153, 204));
        jbBaja.setText("Dar de Baja");
        jbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Total:");

        jlTotal.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(51, 153, 0));

        jbGuardar.setBackground(new java.awt.Color(5, 5, 5));
        jbGuardar.setForeground(new java.awt.Color(0, 153, 204));
        jbGuardar.setText("Guardar Venta");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(new java.awt.Color(5, 5, 5));
        jbCancelar.setForeground(new java.awt.Color(0, 153, 204));
        jbCancelar.setText("Cancelar Venta");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbMenu.setBackground(new java.awt.Color(5, 5, 5));
        jbMenu.setForeground(new java.awt.Color(0, 153, 204));
        jbMenu.setText("Volver al Menu");
        jbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuActionPerformed(evt);
            }
        });

        jbHistorial.setBackground(new java.awt.Color(5, 5, 5));
        jbHistorial.setForeground(new java.awt.Color(0, 153, 204));
        jbHistorial.setText("Historial");
        jbHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistorialActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 220, 220));
        jLabel5.setText("Categoría:");

        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });

        jbActualizarPrecio.setBackground(new java.awt.Color(5, 5, 5));
        jbActualizarPrecio.setForeground(new java.awt.Color(0, 153, 204));
        jbActualizarPrecio.setText("Actualizar Precio");
        jbActualizarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(9, 9, 9)
                                .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbNuevoProducto)
                                .addGap(49, 49, 49)
                                .addComponent(jbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jbActualizarPrecio)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbQuitar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(891, 891, 891)
                        .addComponent(jbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(403, 403, 403)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbQuitar)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoProductoActionPerformed

        NuevoProducto nuevo = new NuevoProducto();
        nuevo.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jbNuevoProductoActionPerformed

    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        
            int fila = TablaVentas.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la venta.");
            return;
        }

        modeloVenta.removeRow(fila);
        actualizarTotalVenta();
        jtBuscar.requestFocus();
        
    }//GEN-LAST:event_jbQuitarActionPerformed

    private void jbStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStockActionPerformed
        
            int fila = TablaProductos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.");
            return;
        }

        int idProducto = Integer.parseInt(TablaProductos.getValueAt(fila, 0).toString());
        String nombreProducto = TablaProductos.getValueAt(fila, 2).toString();
        int stockActual = Integer.parseInt(TablaProductos.getValueAt(fila, 5).toString());

        String nuevoStockTexto = JOptionPane.showInputDialog(
                null,
                "Producto: " + nombreProducto + "\n"
                + "Stock actual: " + stockActual + "\n\n"
                + "Ingrese el nuevo stock:",
                stockActual
        );

        if (nuevoStockTexto == null) {
            return;
        }

        nuevoStockTexto = nuevoStockTexto.trim();

        if (nuevoStockTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un stock.");
            return;
        }

        try {

            int nuevoStock = Integer.parseInt(nuevoStockTexto);

            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea cambiar el stock de:\n\n"
                    + nombreProducto + "\n\n"
                    + "Stock actual: " + stockActual + "\n"
                    + "Nuevo stock: " + nuevoStock,
                    "Confirmar ajuste de stock",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }

            productoData.ajustarStock(idProducto, nuevoStock);

            JOptionPane.showMessageDialog(null, "Stock ajustado correctamente.");

            cargarProductos();
            jtBuscar.requestFocus();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El stock debe ser un número entero.");
        }
        
    }//GEN-LAST:event_jbStockActionPerformed

    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        
                int fila = TablaProductos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.");
            return;
        }

        int idProducto = Integer.parseInt(TablaProductos.getValueAt(fila, 0).toString());
        String nombreProducto = TablaProductos.getValueAt(fila, 2).toString();

        if (productoEstaEnVentaActual(idProducto)) {
            JOptionPane.showMessageDialog(
                    null,
                    "No puede dar de baja un producto que está cargado en la venta actual.\n"
                    + "Primero quítelo de la venta."
            );
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea dar de baja este producto?\n\n"
                + nombreProducto,
                "Dar de baja producto",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        productoData.darDeBajaProducto(idProducto);

        JOptionPane.showMessageDialog(null, "Producto dado de baja correctamente.");

        cargarProductos();

        jtBuscar.setText("");
        jtBuscar.requestFocus();
        
    }//GEN-LAST:event_jbBajaActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
            if (modeloVenta.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos cargados en la venta.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea guardar la venta?",
                "Guardar venta",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        try {

            VentaProducto venta = new VentaProducto(
                    LocalDateTime.now(),
                    totalVenta,
                    "",
                    false
            );

            int idVenta = ventaProductoData.guardarVentaProducto(venta);

            if (idVenta == -1) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la venta.");
                return;
            }

            venta.setIdVenta(idVenta);

            for (int i = 0; i < modeloVenta.getRowCount(); i++) {

                int idProducto = Integer.parseInt(modeloVenta.getValueAt(i, 0).toString());
                int cantidad = Integer.parseInt(modeloVenta.getValueAt(i, 1).toString());
                int precioTotalLinea = Integer.parseInt(modeloVenta.getValueAt(i, 3).toString());

                Producto producto = productoData.buscarProductoPorId(idProducto);

                if (producto == null) {
                    JOptionPane.showMessageDialog(null, "No se pudo cargar uno de los productos.");
                    return;
                }

                int precioUnitario = precioTotalLinea / cantidad;

                DetalleVentaProducto detalle = new DetalleVentaProducto(
                        venta,
                        producto,
                        cantidad,
                        precioUnitario,
                        precioTotalLinea
                );

                ventaProductoData.guardarDetalleVentaProducto(detalle);

                productoData.descontarStock(idProducto, cantidad);
            }

            JOptionPane.showMessageDialog(null, "Venta guardada correctamente.");

            limpiarVenta();
            cargarProductos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la venta.");
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        
            if (modeloVenta.getRowCount() == 0) {
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea cancelar la venta actual?",
                "Cancelar venta",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            limpiarVenta();
        }
        
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyReleased
        
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        return;
    }

        String texto = jtBuscar.getText().trim();

        if (texto.isEmpty()) {
            cargarProductos();
        } else {
            buscarProductos(texto);
        }
        
    }//GEN-LAST:event_jtBuscarKeyReleased

    private void TablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMouseClicked
        
        if (evt.getClickCount() == 2 && TablaProductos.getSelectedRow() != -1) {
        agregarProductoSeleccionadoAVenta(1);
    
    }
        
    }//GEN-LAST:event_TablaProductosMouseClicked

    private void jbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuActionPerformed
        
        Menu menu = new Menu();
        menu.show();
        dispose();
        
    }//GEN-LAST:event_jbMenuActionPerformed

    private void TablaProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaProductosKeyPressed
        
            if (TablaProductos.isEditing()) {
            return;
        }

        char tecla = evt.getKeyChar();

        if (tecla >= '1' && tecla <= '9') {

            int cantidad = Character.getNumericValue(tecla);

            agregarProductoSeleccionadoAVenta(cantidad);

            evt.consume();
        }
        
    }//GEN-LAST:event_TablaProductosKeyPressed

    private void jtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyPressed
        
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {

            String codigo = jtBuscar.getText().trim();

            if (codigo.isEmpty()) {
                return;
            }

            Producto producto = productoData.buscarProductoPorCodigoBarra(codigo);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "No existe un producto con ese código de barras.");
                jtBuscar.setText("");
                jtBuscar.requestFocus();
                cargarProductos();
                return;
            }

            agregarProductoAVenta(producto, 1);

            jtBuscar.setText("");
            jtBuscar.requestFocus();
            cargarProductos();

            evt.consume();
        }
        
    }//GEN-LAST:event_jtBuscarKeyPressed

    private void jbHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistorialActionPerformed
        
        HistorialVentasProductos his = new HistorialVentasProductos();
        his.show();
        dispose();
        
    }//GEN-LAST:event_jbHistorialActionPerformed

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
        
        cargarProductos();
        jtBuscar.setText("");
        jtBuscar.requestFocus();
        
    }//GEN-LAST:event_jcbCategoriaActionPerformed

    private void jbActualizarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarPrecioActionPerformed
        
            String categoria = jcbCategoria.getSelectedItem().toString();

        if (categoria.equals("Todas")) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una categoría.");
            return;
        }

        // Elegir acción
        String[] opciones = {"Aumentar", "Disminuir"};

        int opcion = JOptionPane.showOptionDialog(
                this,
                "¿Qué desea hacer con la categoría:  "+categoria+"?",
                "Actualizar precios",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (opcion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        boolean aumentar = (opcion == 0);

        // Pedir porcentaje
        String mensaje = aumentar
                ? "Ingrese el porcentaje de aumento:"
                : "Ingrese el porcentaje de disminución:";

        String dato = JOptionPane.showInputDialog(this, mensaje);

        if (dato == null) {
            return;
        }

        double porcentaje;

        try {

            porcentaje = Double.parseDouble(dato.replace(",", "."));

            if (porcentaje <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese un porcentaje mayor que cero.");
                return;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Porcentaje inválido.");
            return;
        }

        String accion = aumentar ? "aumentarán" : "disminuirán";

        int confirmar = JOptionPane.showConfirmDialog(
                this,
                "Los precios de la categoría\n\n"
                + categoria
                + "\n\nse "
                + accion
                + " un "
                + porcentaje
                + "%.\n\n¿Desea continuar?",
                "Confirmar actualización",
                JOptionPane.YES_NO_OPTION);

        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }

        int productosActualizados = productoData.actualizarPrecioCategoria(
                categoria,
                porcentaje,
                aumentar);

        if (productosActualizados > 0) {

            JOptionPane.showMessageDialog(this,
                    "Se actualizaron correctamente "
                    + productosActualizados
                    + " productos.");

            cargarProductos();

        } else {

            JOptionPane.showMessageDialog(this,
                    "No se modificó ningún producto.");
        }
        
    }//GEN-LAST:event_jbActualizarPrecioActionPerformed

    
    
    
    private void buscarProductos(String texto) {

        cargandoTabla = true;

        modeloProductos.setRowCount(0);

        ArrayList<Producto> productos =
                productoData.buscarProductosPorNombreOCodigo(texto);

        for (Producto p : productos) {
            modeloProductos.addRow(new Object[]{
                p.getIdProducto(),
                p.getCodigoBarra(),
                p.getNombre(),
                p.getCategoria(),
                p.getPrecio(),
                p.getStock(),
            });
        }

        cargandoTabla = false;
}
    
    
    
    
        private void agregarListenerTablaProductos() {

        modeloProductos.addTableModelListener(new javax.swing.event.TableModelListener() {
            @Override
            public void tableChanged(javax.swing.event.TableModelEvent e) {

                if (cargandoTabla) {
                    return;
                }

                if (e.getType() != javax.swing.event.TableModelEvent.UPDATE) {
                    return;
                }

                int fila = e.getFirstRow();

                if (fila < 0) {
                    return;
                }

                try {

                    int idProducto = Integer.parseInt(modeloProductos.getValueAt(fila, 0).toString());

                    String codigo = modeloProductos.getValueAt(fila, 1) == null
                            ? ""
                            : modeloProductos.getValueAt(fila, 1).toString().trim();

                    String nombre = modeloProductos.getValueAt(fila, 2) == null
                            ? ""
                            : modeloProductos.getValueAt(fila, 2).toString().trim();

                    
                    String precioTexto = modeloProductos.getValueAt(fila, 4).toString().trim();

                    if (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El nombre del producto no puede quedar vacío.");
                        cargarProductos();
                        return;
                    }

                    int precio = Integer.parseInt(precioTexto);

                    if (precio < 0) {
                        JOptionPane.showMessageDialog(null, "El precio no puede ser negativo.");
                        cargarProductos();
                        return;
                    }

                    Producto producto = new Producto();

                    producto.setIdProducto(idProducto);
                    producto.setCodigoBarra(codigo);
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);

                    productoData.modificarProducto(producto);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Precio y stock mínimo deben ser números enteros.");
                    cargarProductos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar producto.");
                    ex.printStackTrace();
                    cargarProductos();
                }
            }
        });
    }
    
    
    
        
        private void agregarProductoSeleccionadoAVenta(int cantidad) {

            int fila = TablaProductos.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto.");
                return;
            }

            int idProducto = Integer.parseInt(TablaProductos.getValueAt(fila, 0).toString());

            Producto producto = productoData.buscarProductoPorId(idProducto);

            if (producto == null) {
                JOptionPane.showMessageDialog(null, "No se pudo cargar el producto seleccionado.");
                return;
            }

            agregarProductoAVenta(producto, cantidad);
}
        
        
        
        
        private void agregarProductoAVenta(Producto producto, int cantidad) {

            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
                return;
            }

            for (int i = 0; i < modeloVenta.getRowCount(); i++) {

                int idTabla = Integer.parseInt(modeloVenta.getValueAt(i, 0).toString());

                if (idTabla == producto.getIdProducto()) {

                    int cantidadAnterior = Integer.parseInt(modeloVenta.getValueAt(i, 1).toString());
                    int nuevaCantidad = cantidadAnterior + cantidad;
                    int nuevoPrecioTotal = nuevaCantidad * producto.getPrecio();

                    modeloVenta.setValueAt(nuevaCantidad, i, 1);
                    modeloVenta.setValueAt(nuevoPrecioTotal, i, 3);

                    actualizarTotalVenta();
                    return;
                }
            }

            int precioTotal = cantidad * producto.getPrecio();

            modeloVenta.addRow(new Object[]{
                producto.getIdProducto(),
                cantidad,
                producto.getNombre(),
                precioTotal
            });

            actualizarTotalVenta();
}
        
    
    
        
        
        
        
        
        
        private void actualizarTotalVenta() {

        totalVenta = 0;

        for (int i = 0; i < modeloVenta.getRowCount(); i++) {
            totalVenta += Integer.parseInt(modeloVenta.getValueAt(i, 3).toString());
        }

        jlTotal.setText("$ " + totalVenta);
}
        
        
        
        
        private void aplicarEstiloTablaProductos() {

        TablaProductos.setRowHeight(28);
        TablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 14));

        TablaProductos.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", 1, 14)
        );

        TablaProductos.setSelectionBackground(new java.awt.Color(180, 205, 235));
        TablaProductos.setSelectionForeground(java.awt.Color.BLACK);

        TablaProductos.setGridColor(new java.awt.Color(220, 220, 220));
}
        
        
        
        
        
        private void aplicarEstiloTablaVentas() {

        TablaVentas.setRowHeight(28);
        TablaVentas.setFont(new java.awt.Font("Segoe UI", 0, 14));

        TablaVentas.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", 1, 14)
        );

        TablaVentas.setSelectionBackground(new java.awt.Color(180, 205, 235));
        TablaVentas.setSelectionForeground(java.awt.Color.BLACK);

        TablaVentas.setGridColor(new java.awt.Color(220, 220, 220));
}
        
        
        
        
        private void aplicarEstiloBotones() {

    // Botones verdes - acciones positivas
    jbGuardar.setBackground(new java.awt.Color(60, 130, 70));
    jbGuardar.setForeground(java.awt.Color.WHITE);

    jbNuevoProducto.setBackground(new java.awt.Color(60, 130, 70));
    jbNuevoProducto.setForeground(java.awt.Color.WHITE);

    // Botones azules - acciones normales
    jbStock.setBackground(new java.awt.Color(70, 90, 120));
    jbStock.setForeground(java.awt.Color.WHITE);
    
    jbHistorial.setBackground(new java.awt.Color(70, 90, 120));
    jbHistorial.setForeground(java.awt.Color.WHITE);
    
    jbActualizarPrecio.setBackground(new java.awt.Color(70, 90, 120));
    jbActualizarPrecio.setForeground(java.awt.Color.WHITE);

    // Botones rojos - acciones delicadas
    jbQuitar.setBackground(new java.awt.Color(150, 60, 60));
    jbQuitar.setForeground(java.awt.Color.WHITE);

    jbCancelar.setBackground(new java.awt.Color(150, 60, 60));
    jbCancelar.setForeground(java.awt.Color.WHITE);
    
    jbBaja.setBackground(new java.awt.Color(150, 60, 60));
    jbBaja.setForeground(java.awt.Color.WHITE);

    // Botones grises - navegación
    jbMenu.setBackground(new java.awt.Color(70, 70, 70));
    jbMenu.setForeground(java.awt.Color.WHITE);
}
        
        
        
        private boolean productoEstaEnVentaActual(int idProducto) {

            for (int i = 0; i < modeloVenta.getRowCount(); i++) {

                int idTabla = Integer.parseInt(modeloVenta.getValueAt(i, 0).toString());

                if (idTabla == idProducto) {
                    return true;
                }
            }

            return false;
}
        
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbActualizarPrecio;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbHistorial;
    private javax.swing.JButton jbMenu;
    private javax.swing.JButton jbNuevoProducto;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JButton jbStock;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JTextField jtBuscar;
    // End of variables declaration//GEN-END:variables
}
