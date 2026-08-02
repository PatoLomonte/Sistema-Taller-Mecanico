package Vistas.Autos;

import Entidades.Arreglo;
import Entidades.Auto;
import Entidades.DetalleArreglo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.itextpdf.text.Image;


    public class PDFArreglo {

        public void generarPDF(Auto auto, Arreglo arreglo, ArrayList<DetalleArreglo> detalles) {

            Document documento = new Document(PageSize.A4, 40, 40, 35, 35);

            try {

                String escritorio = System.getProperty("user.home") + "/Desktop";

                File carpeta = new File(escritorio + "/Arreglos-Taller");

                if (!carpeta.exists()) {
                    carpeta.mkdirs();
                }

                DateTimeFormatter formatoArchivo =
                        DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");

                String fechaHora =
                        LocalDateTime.now().format(formatoArchivo);

                String patenteLimpia =
                        auto.getPatente()
                        .replaceAll("[\\\\/:*?\"<>|]", "")
                        .replace(" ", "_");

                String nombreArchivo =
                        patenteLimpia + "_" + fechaHora + ".pdf";

                String rutaPDF =
                        escritorio + "/Arreglos-Taller/" + nombreArchivo;

                PdfWriter.getInstance(
                        documento,
                        new FileOutputStream(rutaPDF)
                );

                documento.open();

                Font tituloFont =
                        new Font(
                                Font.FontFamily.TIMES_ROMAN,
                                26,
                                Font.BOLDITALIC,
                                new BaseColor(150, 40, 40)
                        );

                Font subtituloFont =
                        new Font(
                                Font.FontFamily.TIMES_ROMAN,
                                14,
                                Font.BOLDITALIC,
                                new BaseColor(150, 40, 40)
                        );

                Font normalFont =
                        new Font(
                                Font.FontFamily.HELVETICA,
                                11,
                                Font.NORMAL
                        );
                
                Font textoFont =
                        new Font(
                                Font.FontFamily.HELVETICA,
                                8,
                                Font.NORMAL
                        );

                Font negritaFont =
                        new Font(
                                Font.FontFamily.HELVETICA,
                                11,
                                Font.BOLD
                        );

                Font totalFont =
                        new Font(
                                Font.FontFamily.HELVETICA,
                                13,
                                Font.BOLD
                        );

                agregarEncabezado(documento, arreglo, textoFont, subtituloFont, normalFont);

                agregarDatosClienteAuto(
                        documento,
                        auto,
                        arreglo,
                        normalFont,
                        negritaFont
                );

                agregarTablaDetalle(
                        documento,
                        detalles,
                        arreglo.getTotal(),
                        normalFont,
                        negritaFont,
                        totalFont
                );

                documento.close();

                JOptionPane.showMessageDialog(
                        null,
                        "PDF generado correctamente en:\n" + rutaPDF
                );

            } catch (Exception ex) {

                if (documento.isOpen()) {
                    documento.close();
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Error al generar PDF: " + ex.getMessage()
                );

                ex.printStackTrace();
            }
        }

        
        
        
        private void agregarEncabezado(
        Document documento,
        Arreglo arreglo,
        Font textoFont,
        Font subtituloFont,
        Font normalFont
) throws Exception {

    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fechaTexto = arreglo.getFecha().format(formatoFecha);
    String[] partes = fechaTexto.split("/");

    String diaTexto = partes[0];
    String mesTexto = partes[1];
    String anioTexto = partes[2];

    PdfPTable tablaEncabezado = new PdfPTable(2);
    tablaEncabezado.setWidthPercentage(100);
    tablaEncabezado.setWidths(new float[]{3f, 1.2f});

    PdfPCell celdaTitulo = new PdfPCell();
    celdaTitulo.setBorder(Rectangle.BOX);
    celdaTitulo.setPadding(8);

        Image logo = Image.getInstance(
            PDFArreglo.class.getResource("/Imagenes/Logo.png")
            );

            logo.scaleToFit(300, 90);
            logo.setAlignment(Element.ALIGN_CENTER);

    Paragraph subtitulo = new Paragraph("AUTOMECÁNICA", subtituloFont);
    subtitulo.setAlignment(Element.ALIGN_RIGHT);

    Paragraph descripcion = new Paragraph(
            "GNC - RENOVACIÓN DE OBLEAS / PRUEBAS HIDRÁULICAS\n"
            + "INYECCIÓN ELECTRÓNICA - TREN DELANTERO - LUBRICENTRO - CAJAS AUTOMÁTICAS\n"
            + "LAVALLE 754 - ACEBAL (SANTA FE) / TEL: 3469693441",
            textoFont
    );
    descripcion.setAlignment(Element.ALIGN_CENTER);

    celdaTitulo.addElement(logo);
    celdaTitulo.addElement(subtitulo);
    celdaTitulo.addElement(descripcion);

    PdfPCell celdaPresupuesto = new PdfPCell();
    celdaPresupuesto.setBorder(Rectangle.BOX);
    celdaPresupuesto.setPadding(8);

    Paragraph presupuesto = new Paragraph("PRESUPUESTO", subtituloFont);
    presupuesto.setAlignment(Element.ALIGN_CENTER);

    PdfPTable tablaFecha = new PdfPTable(3);
    tablaFecha.setWidthPercentage(100);

    // Encabezados
    PdfPCell dia = crearCeldaCentrada("DÍA", normalFont);
    PdfPCell mes = crearCeldaCentrada("MES", normalFont);
    PdfPCell anio = crearCeldaCentrada("AÑO", normalFont);

    // Valores
    PdfPCell valorDia = crearCeldaCentrada(diaTexto, normalFont);
    PdfPCell valorMes = crearCeldaCentrada(mesTexto, normalFont);
    PdfPCell valorAnio = crearCeldaCentrada(anioTexto, normalFont);

    tablaFecha.addCell(dia);
    tablaFecha.addCell(mes);
    tablaFecha.addCell(anio);

    tablaFecha.addCell(valorDia);
    tablaFecha.addCell(valorMes);
    tablaFecha.addCell(valorAnio);

    celdaPresupuesto.addElement(presupuesto);
    celdaPresupuesto.addElement(Chunk.NEWLINE);
    celdaPresupuesto.addElement(tablaFecha);

    tablaEncabezado.addCell(celdaTitulo);
    tablaEncabezado.addCell(celdaPresupuesto);

    documento.add(tablaEncabezado);
    documento.add(new Paragraph(" "));
}
        
        
        

        private void agregarDatosClienteAuto(
                Document documento,
                Auto auto,
                Arreglo arreglo,
                Font normalFont,
                Font negritaFont
        ) throws Exception {

            String cliente =
                    auto.getCliente().getNombre();

            String telefono =
                    auto.getCliente().getTelefono();

            String vehiculo =
                    auto.getVehiculo();

            String patente =
                    auto.getPatente();

            String km =
                    String.valueOf(arreglo.getKilometros());

            PdfPTable tablaDatos = new PdfPTable(2);
            tablaDatos.setWidthPercentage(100);
            tablaDatos.setWidths(new float[]{1f, 1f});

            PdfPCell celdaIzquierda = new PdfPCell();
            celdaIzquierda.setBorder(Rectangle.BOX);
            celdaIzquierda.setPadding(8);

            celdaIzquierda.addElement(crearLineaDato("Cliente: ", cliente, negritaFont, normalFont));
            celdaIzquierda.addElement(crearLineaDato("Vehículo: ", vehiculo, negritaFont, normalFont));
            celdaIzquierda.addElement(crearLineaDato("Teléfono: ", telefono, negritaFont, normalFont));

            PdfPCell celdaDerecha = new PdfPCell();
            celdaDerecha.setBorder(Rectangle.BOX);
            celdaDerecha.setPadding(8);

            celdaDerecha.addElement(crearLineaDato("Patente: ", patente, negritaFont, normalFont));
            celdaDerecha.addElement(crearLineaDato("Km: ", km, negritaFont, normalFont));

            if (arreglo.getObservacion() != null && !arreglo.getObservacion().trim().isEmpty()) {
                celdaDerecha.addElement(
                        crearLineaDato(
                                "Obs: ",
                                arreglo.getObservacion(),
                                negritaFont,
                                normalFont
                        )
                );
            }

            tablaDatos.addCell(celdaIzquierda);
            tablaDatos.addCell(celdaDerecha);

            documento.add(tablaDatos);
            documento.add(new Paragraph(" "));
        }

        private void agregarTablaDetalle(
                Document documento,
                ArrayList<DetalleArreglo> detalles,
                int total,
                Font normalFont,
                Font negritaFont,
                Font totalFont
        ) throws Exception {

            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{4f, 1.2f});

            PdfPCell encabezadoDetalle =
                    crearCeldaCentrada("DETALLE", negritaFont);

            PdfPCell encabezadoImporte =
                    crearCeldaCentrada("IMPORTE", negritaFont);

            encabezadoDetalle.setBackgroundColor(new BaseColor(235, 235, 235));
            encabezadoImporte.setBackgroundColor(new BaseColor(235, 235, 235));

            tabla.addCell(encabezadoDetalle);
            tabla.addCell(encabezadoImporte);

            for (DetalleArreglo detalle : detalles) {

                PdfPCell celdaDetalle =
                        new PdfPCell(
                                new Phrase(
                                        detalle.getDescripcion(),
                                        normalFont
                                )
                        );

                celdaDetalle.setMinimumHeight(24);
                celdaDetalle.setPadding(5);

                PdfPCell celdaImporte =
                        new PdfPCell(
                                new Phrase(
                                        "$ " + detalle.getImporte(),
                                        normalFont
                                )
                        );

                celdaImporte.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celdaImporte.setMinimumHeight(24);
                celdaImporte.setPadding(5);

                tabla.addCell(celdaDetalle);
                tabla.addCell(celdaImporte);
            }

            int filasDeseadas = 20;

            for (int i = detalles.size(); i < filasDeseadas; i++) {

                PdfPCell celdaVaciaDetalle =
                        new PdfPCell(new Phrase(" ", normalFont));

                celdaVaciaDetalle.setMinimumHeight(24);
                celdaVaciaDetalle.setPadding(5);

                PdfPCell celdaVaciaImporte =
                        new PdfPCell(new Phrase(" ", normalFont));

                celdaVaciaImporte.setMinimumHeight(24);
                celdaVaciaImporte.setPadding(5);

                tabla.addCell(celdaVaciaDetalle);
                tabla.addCell(celdaVaciaImporte);
            }

            PdfPCell celdaTotalTexto =
                    new PdfPCell(
                            new Phrase(
                                    "TOTAL",
                                    totalFont
                            )
                    );

            celdaTotalTexto.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaTotalTexto.setPadding(7);

            PdfPCell celdaTotalValor =
                    new PdfPCell(
                            new Phrase(
                                    "$ " + total,
                                    totalFont
                            )
                    );

            celdaTotalValor.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaTotalValor.setPadding(7);

            tabla.addCell(celdaTotalTexto);
            tabla.addCell(celdaTotalValor);

            documento.add(tabla);
        }

        private PdfPCell crearCeldaCentrada(String texto, Font font) {

            PdfPCell celda =
                    new PdfPCell(
                            new Phrase(texto, font)
                    );

            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setPadding(5);

            return celda;
        }

        private Paragraph crearLineaDato(
                String titulo,
                String valor,
                Font tituloFont,
                Font valorFont
        ) {

            Paragraph p = new Paragraph();

            Chunk cTitulo =
                    new Chunk(titulo, tituloFont);

            Chunk cValor =
                    new Chunk(valor == null ? "" : valor, valorFont);

            p.add(cTitulo);
            p.add(cValor);

            return p;
        }
}

