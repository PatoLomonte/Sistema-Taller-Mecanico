package Vistas;

import AccesoDatos.CasaData;
import AccesoDatos.CompraData;
import AccesoDatos.PagoData;
import Entidades.Casa;
import Entidades.Compra;
import Entidades.Pago;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GestionCasa extends javax.swing.JFrame {

    
    
    private Casa casaActual;

private CompraData compraData = new CompraData();
private PagoData pagoData = new PagoData();
private CasaData casaData = new CasaData();

private DefaultTableModel modeloCompras = new DefaultTableModel() {

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
};
    
    
    public GestionCasa() {
        initComponents();
    }

    
    public GestionCasa(Casa casa) {
    initComponents();
    this.casaActual = casa;
    armarCabeceraCompras();
    aplicarEstiloTabla();
    cargarDatosCasa();
    cargarCombosFecha();
    seleccionarFechaActual();
    cargarComprasCasa();
    aplicarEstiloBotones();
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Llave.png")));
    setLocationRelativeTo(null);
    this.setTitle("Gestión");
}
    
    
    
    
    private void cargarDatosCasa() {

    jlNombre.setText(casaActual.getNombre());
    jlTelefono.setText(casaActual.getTelefono());
    jlDireccion.setText(casaActual.getDireccion());
    jlSaldo.setText("$ " + casaActual.getSaldo());
}
    
    
    
    
    private void cargarComprasCasa() {

        modeloCompras.setRowCount(0);

        if (jcbMes.getSelectedItem() == null || jcbAnio.getSelectedItem() == null) {
            return;
        }

        String nombreMes = jcbMes.getSelectedItem().toString();
        String textoAnio = jcbAnio.getSelectedItem().toString();

        int mes;

        if (nombreMes.equals("Todos")) {
            mes = 0;
        } else {
            mes = obtenerNumeroMes(nombreMes);
        }

        int anio;

        if (textoAnio.equals("Todos")) {
            anio = 0;
        } else {
            anio = Integer.parseInt(textoAnio);
        }

        ArrayList<Compra> compras = compraData.listarComprasPorCasaFiltro(casaActual, mes, anio);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Compra compra : compras) {

            modeloCompras.addRow(new Object[]{compra.getIdCompra(), compra.getFecha().format(formato), compra.getNumeroComprobante(), "$ " + compra.getTotal(), compra.getObservacion()});
        }
}
    
    
    
    
    
    private void armarCabeceraCompras() {

    modeloCompras.addColumn("ID");
    modeloCompras.addColumn("Fecha");
    modeloCompras.addColumn("Comprobante");
    modeloCompras.addColumn("Total");
    modeloCompras.addColumn("Observación");

    TablaCompras.setModel(modeloCompras);

    TablaCompras.getColumnModel().getColumn(0).setMinWidth(0);
    TablaCompras.getColumnModel().getColumn(0).setMaxWidth(0);
    TablaCompras.getColumnModel().getColumn(0).setWidth(0);
}
    
    
    
    private void cargarCombosFecha() {

        jcbMes.removeAllItems();
        jcbAnio.removeAllItems();

        jcbMes.addItem("Todos");
        jcbMes.addItem("Enero");
        jcbMes.addItem("Febrero");
        jcbMes.addItem("Marzo");
        jcbMes.addItem("Abril");
        jcbMes.addItem("Mayo");
        jcbMes.addItem("Junio");
        jcbMes.addItem("Julio");
        jcbMes.addItem("Agosto");
        jcbMes.addItem("Septiembre");
        jcbMes.addItem("Octubre");
        jcbMes.addItem("Noviembre");
        jcbMes.addItem("Diciembre");

        jcbAnio.addItem("Todos");

        for (int anio = 2020; anio <= 2036; anio++) {
            jcbAnio.addItem(String.valueOf(anio));
        }
}
    
    
    
    private void seleccionarFechaActual() {

        jcbMes.setSelectedItem("Todos");
        jcbAnio.setSelectedItem("Todos");
        
}
    
    
    
    
    
    private int obtenerNumeroMes(String mes) {

    switch (mes) {

        case "Enero":
            return 1;

        case "Febrero":
            return 2;

        case "Marzo":
            return 3;

        case "Abril":
            return 4;

        case "Mayo":
            return 5;

        case "Junio":
            return 6;

        case "Julio":
            return 7;

        case "Agosto":
            return 8;

        case "Septiembre":
            return 9;

        case "Octubre":
            return 10;

        case "Noviembre":
            return 11;

        case "Diciembre":
            return 12;

        default:
            return 0;
    }
}
    
    
    
    
    
    private void aplicarEstiloTabla() {

        TablaCompras.setRowHeight(28);
        TablaCompras.setFont(new java.awt.Font("Segoe UI", 0, 14));

        TablaCompras.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", 1, 14)
        );

        TablaCompras.setSelectionBackground(new java.awt.Color(180, 205, 235));
        TablaCompras.setSelectionForeground(java.awt.Color.BLACK);

        TablaCompras.setGridColor(new java.awt.Color(220, 220, 220));
}
    
    
    
    
    
    private void aplicarEstiloBotones() {

    // Botones verdes - acciones positivas
    jbNuevaCompra.setBackground(new java.awt.Color(60, 130, 70));
    jbNuevaCompra.setForeground(java.awt.Color.WHITE);

    jbRegistrarPago.setBackground(new java.awt.Color(60, 130, 70));
    jbRegistrarPago.setForeground(java.awt.Color.WHITE);

    // Botones azules - acciones normales
    jbDetalle.setBackground(new java.awt.Color(70, 90, 120));
    jbDetalle.setForeground(java.awt.Color.WHITE);

    jbHistorial.setBackground(new java.awt.Color(70, 90, 120));
    jbHistorial.setForeground(java.awt.Color.WHITE);

    // Botones rojos - acciones delicadas
    jbSaldar.setBackground(new java.awt.Color(150, 60, 60));
    jbSaldar.setForeground(java.awt.Color.WHITE);

    jbAnularCompra.setBackground(new java.awt.Color(150, 60, 60));
    jbAnularCompra.setForeground(java.awt.Color.WHITE);

    // Botones grises - navegación
    jbVolver.setBackground(new java.awt.Color(70, 70, 70));
    jbVolver.setForeground(java.awt.Color.WHITE);

    jbMenu.setBackground(new java.awt.Color(70, 70, 70));
    jbMenu.setForeground(java.awt.Color.WHITE);
}
    
    
    
    
    private void abrirDetalleCompraSeleccionada(){
        
            int fila = TablaCompras.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una compra.");
            return;
        }

        int idCompra =
            (Integer) TablaCompras.getValueAt(fila, 0);

        String fecha =
            TablaCompras.getValueAt(fila, 1).toString();

        String comprobante =
            TablaCompras.getValueAt(fila, 2).toString();

        String totalTexto =
            TablaCompras.getValueAt(fila, 3).toString()
                .replace("$", "")
                .trim();

        int total =
            Integer.parseInt(totalTexto);

        DetalleCompraVista detalle =
            new DetalleCompraVista(
                casaActual,
                idCompra,
                fecha,
                comprobante,
                total
            );

        detalle.setVisible(true);

        this.dispose();
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCompras = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jbNuevaCompra = new javax.swing.JButton();
        jbRegistrarPago = new javax.swing.JButton();
        jbSaldar = new javax.swing.JButton();
        jbDetalle = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbMenu = new javax.swing.JButton();
        jbHistorial = new javax.swing.JButton();
        jbAnularCompra = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlDireccion = new javax.swing.JLabel();
        jlSaldo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbMes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcbAnio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Gestión de Casa");

        TablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCompras);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(200, 200, 200));
        jLabel7.setText("Historial de Compras");

        jbNuevaCompra.setBackground(new java.awt.Color(5, 5, 5));
        jbNuevaCompra.setForeground(new java.awt.Color(0, 153, 204));
        jbNuevaCompra.setText("Nueva Compra");
        jbNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaCompraActionPerformed(evt);
            }
        });

        jbRegistrarPago.setBackground(new java.awt.Color(5, 5, 5));
        jbRegistrarPago.setForeground(new java.awt.Color(0, 153, 204));
        jbRegistrarPago.setText("Registrar Pago");
        jbRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarPagoActionPerformed(evt);
            }
        });

        jbSaldar.setBackground(new java.awt.Color(5, 5, 5));
        jbSaldar.setForeground(new java.awt.Color(0, 153, 204));
        jbSaldar.setText("Saldar Cuenta");
        jbSaldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaldarActionPerformed(evt);
            }
        });

        jbDetalle.setBackground(new java.awt.Color(5, 5, 5));
        jbDetalle.setForeground(new java.awt.Color(0, 153, 204));
        jbDetalle.setText("Ver Detalle");
        jbDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetalleActionPerformed(evt);
            }
        });

        jbVolver.setBackground(new java.awt.Color(5, 5, 5));
        jbVolver.setForeground(new java.awt.Color(153, 153, 0));
        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbMenu.setBackground(new java.awt.Color(5, 5, 5));
        jbMenu.setForeground(new java.awt.Color(204, 102, 0));
        jbMenu.setText("Volver al Menu");
        jbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuActionPerformed(evt);
            }
        });

        jbHistorial.setBackground(new java.awt.Color(5, 5, 5));
        jbHistorial.setForeground(new java.awt.Color(0, 153, 204));
        jbHistorial.setText("Historial Pagos");
        jbHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistorialActionPerformed(evt);
            }
        });

        jbAnularCompra.setBackground(new java.awt.Color(5, 5, 5));
        jbAnularCompra.setForeground(new java.awt.Color(255, 0, 0));
        jbAnularCompra.setText("Anular Compra");
        jbAnularCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularCompraActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(60, 60, 60));

        jlNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(230, 230, 230));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Nombre:");

        jlTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlTelefono.setForeground(new java.awt.Color(230, 230, 230));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("Telefono:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("Direccion:");

        jlDireccion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlDireccion.setForeground(new java.awt.Color(230, 230, 230));

        jlSaldo.setFont(new java.awt.Font("Arial", 0, 21)); // NOI18N
        jlSaldo.setForeground(new java.awt.Color(204, 204, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 220, 220));
        jLabel6.setText("Saldo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jlTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jlSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jlDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jlDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jlSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(200, 200, 200));
        jLabel8.setText("Mes:");

        jcbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(200, 200, 200));
        jLabel9.setText("Año:");

        jcbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAnioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jbNuevaCompra)
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jbSaldar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbRegistrarPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(168, 168, 168)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jbDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbAnularCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbHistorial)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbMenu)
                        .addGap(76, 76, 76))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jcbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbSaldar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAnularCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaCompraActionPerformed

        NuevaCompra nueva = new NuevaCompra(casaActual);
        nueva.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jbNuevaCompraActionPerformed

    private void jbRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarPagoActionPerformed
        
        RegistrarPagoParcial pago = new RegistrarPagoParcial(casaActual);
        pago.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbRegistrarPagoActionPerformed

    private void jbSaldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaldarActionPerformed
        
        int saldoActual = casaActual.getSaldo();

        if (saldoActual <= 0) {
            JOptionPane.showMessageDialog(null, "Esta casa no tiene saldo pendiente.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Está seguro que desea saldar la cuenta de " + casaActual.getNombre() + "?\n\n"
            + "Saldo actual: $" + saldoActual + "\n"
            + "El saldo quedará en $0.",
            "Confirmar saldo",
            JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        Pago pago = new Pago(casaActual, LocalDateTime.now(), saldoActual, "Cuenta saldada", false);

        pagoData.registrarPago(pago);

        casaData.restarSaldo(casaActual.getIdCasa(), saldoActual);

        JOptionPane.showMessageDialog(null, "Cuenta saldada correctamente.");

        Casa casaActualizada = casaData.buscarCasaPorId(casaActual.getIdCasa());

        GestionCasa gestion = new GestionCasa(casaActualizada);
        gestion.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbSaldarActionPerformed

    private void jbDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetalleActionPerformed
        
        abrirDetalleCompraSeleccionada();
        
    }//GEN-LAST:event_jbDetalleActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        
        VerCasas ver = new VerCasas();
        ver.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuActionPerformed
        
        Menu menu = new Menu();
        menu.show();
        dispose();
        
    }//GEN-LAST:event_jbMenuActionPerformed

    private void jbHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistorialActionPerformed
        
        HistorialPagos historial = new HistorialPagos(casaActual);
        historial.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbHistorialActionPerformed

    private void jbAnularCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularCompraActionPerformed
        
        int fila = TablaCompras.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una compra para anular.");
            return;
        }

        int idCompra = (Integer) TablaCompras.getValueAt(fila, 0);

        String fecha = TablaCompras.getValueAt(fila, 1).toString();
        String comprobante = TablaCompras.getValueAt(fila, 2).toString();

        String totalTexto = TablaCompras.getValueAt(fila, 3).toString()
                .replace("$", "")
                .trim();

        int totalCompra = Integer.parseInt(totalTexto);

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea anular esta compra?\n\n"
                + "Fecha: " + fecha + "\n"
                + "Comprobante: " + comprobante + "\n"
                + "Total: $" + totalCompra + "\n\n"
                + "Este importe se restará del saldo de la casa.",
                "Confirmar anulación",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        compraData.anularCompra(idCompra);

        casaData.restarSaldo(casaActual.getIdCasa(), totalCompra);

        JOptionPane.showMessageDialog(null, "Compra anulada correctamente.");

        Casa casaActualizada = casaData.buscarCasaPorId(casaActual.getIdCasa());

        GestionCasa gestion = new GestionCasa(casaActualizada);
        gestion.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_jbAnularCompraActionPerformed

    private void jcbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesActionPerformed
        
        cargarComprasCasa();
        
    }//GEN-LAST:event_jcbMesActionPerformed

    private void jcbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAnioActionPerformed
        
        cargarComprasCasa();
        
    }//GEN-LAST:event_jcbAnioActionPerformed

    private void TablaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaComprasMouseClicked
        
        if (evt.getClickCount() == 2 && TablaCompras.getSelectedRow() != -1) {
        abrirDetalleCompraSeleccionada();
        
        }
    }//GEN-LAST:event_TablaComprasMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnularCompra;
    private javax.swing.JButton jbDetalle;
    private javax.swing.JButton jbHistorial;
    private javax.swing.JButton jbMenu;
    private javax.swing.JButton jbNuevaCompra;
    private javax.swing.JButton jbRegistrarPago;
    private javax.swing.JButton jbSaldar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox<String> jcbAnio;
    private javax.swing.JComboBox<String> jcbMes;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSaldo;
    private javax.swing.JLabel jlTelefono;
    // End of variables declaration//GEN-END:variables
}
