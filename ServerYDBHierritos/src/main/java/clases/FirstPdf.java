import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;

public class FirstPdf implements Serializable {
    String numFactura, fechaFactura, totalFactura, formaPago, consecutivoDIAN;
    Cliente cliente;
    Vendedor vendedor;
    Ferreteria ferreteria;
    List<Producto> listaProductos;

    public FirstPdf(String numFactura, String fechaFactura, String consecutivoDIAN, String totalFactura,
            String formaPago, Cliente cliente, Vendedor vendedor, Ferreteria ferreteria,
            List<Producto> listaProductos) {
        this.numFactura = numFactura;
        this.fechaFactura = fechaFactura;
        this.listaProductos = listaProductos;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.totalFactura = totalFactura;
        this.formaPago = formaPago;
        this.ferreteria = ferreteria;
        this.consecutivoDIAN = consecutivoDIAN;
    }

    public void getPDF() throws FileNotFoundException, MalformedURLException {
        String path = "src\\images\\" + numFactura + ".pdf";
        String paraText = ferreteria.getNombre();
        String imString = "src\\images\\icono.png";
        ImageData data = ImageDataFactory.create(imString);
        Image icono = new Image(data);
        Paragraph paragraph1 = new Paragraph(paraText).setFontColor(Color.DARK_GRAY).setBold().setFontSize(20);
        paragraph1.setTextAlignment(TextAlignment.CENTER);
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);
        float[] pointColumnWidths = { 150F, 150F, 150F, 150F, 150F };
        float[] tamañoTablaDatos = { 200F, 200F, 200F, 200F };
        Table encabezado = new Table(tamañoTablaDatos);

        Cell datosFactura = new Cell();
        datosFactura.add("N° Factura");
        datosFactura.add("Fecha Factura ");
        datosFactura.add("Consecutivo DIAN ");
        datosFactura.setBorder(Border.NO_BORDER);
        encabezado.addCell(datosFactura);

        Cell datosFacturCell = new Cell();
        datosFacturCell.add(numFactura);
        datosFacturCell.add(fechaFactura);
        datosFacturCell.add(consecutivoDIAN);
        datosFacturCell.setBorder(Border.NO_BORDER);
        datosFacturCell.setTextAlignment(TextAlignment.CENTER);
        encabezado.addCell(datosFacturCell);
        Cell cellEspacio = new Cell().setHeight(20).setBackgroundColor(DeviceRgb.WHITE).setBorder(Border.NO_BORDER);

        Cell informacionFerreteria = new Cell();
        informacionFerreteria.add(paragraph1);
        informacionFerreteria.add(ferreteria.getDireccion());
        informacionFerreteria.add("Cel. " + ferreteria.getTelefono());
        informacionFerreteria.add("NIT: " + ferreteria.getNit());
        informacionFerreteria.add(ferreteria.getCorreo());
        informacionFerreteria.setBorder(Border.NO_BORDER);
        encabezado.addCell(informacionFerreteria);
        encabezado.setBorder(Border.NO_BORDER);
        encabezado.setTextAlignment(TextAlignment.RIGHT);

        Cell iconoCell = new Cell();
        iconoCell.add(icono);
        iconoCell.setBorder(Border.NO_BORDER);
        encabezado.addCell(iconoCell);

        encabezado.addCell(cellEspacio);
        document.add(encabezado);

        // Segunda parte del PDF
        Table tableDatos = new Table(tamañoTablaDatos);
        Cell datosCliente = new Cell();
        datosCliente.add("Datos Cliente").setBold();
        datosCliente.setBorder(Border.NO_BORDER);
        tableDatos.addCell(datosCliente);
        Cell casillasVacias01 = new Cell();
        casillasVacias01.add("");
        casillasVacias01.setBorder(Border.NO_BORDER);
        tableDatos.addCell(casillasVacias01);

        Cell casillasvacias02 = new Cell();
        casillasvacias02.add("");
        casillasvacias02.setBorder(Border.NO_BORDER);
        tableDatos.addCell(casillasvacias02);

        Cell vendedorCell = new Cell();
        vendedorCell.add("Datos del vendedor").setBold();
        vendedorCell.setBorder(Border.NO_BORDER);
        tableDatos.addCell(vendedorCell);

        Cell listaDatosCliente = new Cell();
        listaDatosCliente.add(cliente.getNombres());
        listaDatosCliente.add(cliente.getTelefono());
        listaDatosCliente.add(cliente.getTipoDocumento() + "");
        listaDatosCliente.add(cliente.getNumDocumento());
        listaDatosCliente.add(cliente.getDireccion());
        listaDatosCliente.add(cliente.getCorreo());
        listaDatosCliente.setBorder(Border.NO_BORDER);
        tableDatos.addCell(listaDatosCliente);

        Cell listaTipoPersona = new Cell();
        listaTipoPersona.add(cliente.getTipoPersona() + "");
        if (cliente.getResponsableDeIva() == true) {
            listaTipoPersona.add("Responsable de IVA");
        } else {
            listaTipoPersona.add("No IVA");
        }
        listaTipoPersona.setBorder(Border.NO_BORDER);
        tableDatos.addCell(listaTipoPersona);

        Cell c2 = new Cell();
        c2.add("");
        c2.setBorder(Border.NO_BORDER);
        tableDatos.addCell(c2);

        Cell datosVendedorCell = new Cell();
        datosVendedorCell.add(vendedor.getNombres());
        datosVendedorCell.add(vendedor.getId());
        datosVendedorCell.add(fechaFactura);
        datosVendedorCell.setBorder(Border.NO_BORDER);
        datosVendedorCell.setTextAlignment(TextAlignment.LEFT);
        tableDatos.addCell(datosVendedorCell);
        tableDatos.addCell(cellEspacio);

        Table table1 = new Table(pointColumnWidths);

        Cell descripcionCell = new Cell();
        descripcionCell.add("DESCRIPCIÓN");
        descripcionCell.setBackgroundColor(Color.GRAY);
        descripcionCell.setBorder(Border.NO_BORDER);
        descripcionCell.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(descripcionCell);

        Cell cantidadCell = new Cell();
        cantidadCell.add("CANTIDAD");
        cantidadCell.setBackgroundColor(Color.GRAY);
        cantidadCell.setBorder(Border.NO_BORDER);
        cantidadCell.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(cantidadCell);

        Cell ivaCell = new Cell();
        ivaCell.add("IVA");
        ivaCell.setBackgroundColor(Color.GRAY);
        ivaCell.setBorder(Border.NO_BORDER);
        ivaCell.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(ivaCell);

        Cell precioUnitarioCell = new Cell();
        precioUnitarioCell.add("PRECIO UNITARIO ");
        precioUnitarioCell.setBackgroundColor(Color.GRAY);
        precioUnitarioCell.setBorder(Border.NO_BORDER);
        precioUnitarioCell.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(precioUnitarioCell);

        Cell precioCell = new Cell();
        precioCell.add("PRECIO TOTAL");
        precioCell.setBackgroundColor(Color.GRAY);
        precioCell.setBorder(Border.NO_BORDER);
        precioCell.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(precioCell);

        Cell descripcionProductos = new Cell();
        for (Producto producto : listaProductos) {
            descripcionProductos.add(producto.getDescripcion());
        }
        descripcionProductos.setBorder(Border.NO_BORDER);
        descripcionProductos.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(descripcionProductos);

        Cell cantidadProductos = new Cell();
        for (Producto producto : listaProductos) {
            cantidadProductos.add(producto.getExistencias() + "");
        }
        cantidadProductos.setBorder(Border.NO_BORDER);
        cantidadProductos.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(cantidadProductos);

        Cell ivaProducto = new Cell();
        for (Producto producto : listaProductos) {
            double doubleTemporal = producto.getpIva();
            String stringTemporal = Double.toString(doubleTemporal);
            ivaProducto.add(stringTemporal);
        }
        ivaProducto.setBorder(Border.NO_BORDER);
        ivaProducto.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(ivaProducto);

        Cell precioUnitarioProducto = new Cell();
        for (Producto producto : listaProductos) {
            double doubleTemporal = producto.getPrecioTotal();
            String stringTemporal = Double.toString(doubleTemporal);
            precioUnitarioProducto.add(stringTemporal);
        }
        precioUnitarioProducto.setBorder(Border.NO_BORDER);
        precioUnitarioProducto.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(precioUnitarioProducto);

        Cell precioTotalProducto = new Cell();
        precioTotalProducto.add("134234");
        precioTotalProducto.add("123455");
        precioTotalProducto.add("42332");
        precioTotalProducto.add(totalFactura);
        precioTotalProducto.setBorder(Border.NO_BORDER);
        precioTotalProducto.setTextAlignment(TextAlignment.CENTER);
        table1.addCell(precioTotalProducto);
        table1.addCell(cellEspacio);

        Paragraph formaDePago = new Paragraph("Forma de pago: " + formaPago).setTextAlignment(TextAlignment.LEFT);

        document.add(tableDatos);
        document.add(table1);
        document.add(formaDePago);
        document.close();
        System.out.println("PDF CREATED");
    }

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        List<Producto> listaProductos = List.of(
                new Producto("Producto1", 19, 15000),
                new Producto("Producto2", 19, 25000),
                new Producto("Producto3", 19, 5000));
        Cliente clientePrueba = new Cliente(Cliente.TipoPersona.NATURAL, false, "Maria Jose Romero", "3167836748",
                Persona.TipoDocumento.CEDULA_CIUDADANIA, "1100950146",
                "Calle 1N #19-24", "mariajoseromero2018@gmail.com");
        Vendedor vendedorPrubea = new Vendedor(Usuario.TipoUsuario.VENDEDOR, "Vendedor 1", "1234",
                "Nombres del vendedor", Persona.TipoDocumento.CEDULA_CIUDADANIA,
                "Documento vendedor");
        vendedorPrubea.setId("1234");
        Ferreteria ferreteriaPrueba = new Ferreteria("Ferreteria Hierritos", "3002156030", "8-8383828",
                "Calle 23 # 32-13", "estudiantes.2023@upb.edu.co");
        
        FirstPdf createPDF = new FirstPdf("000001", "16/10/2022", "123456", "40.000", "Con tarjeta", clientePrueba,
                vendedorPrubea, ferreteriaPrueba, listaProductos);
        createPDF.getPDF();
    }
}
