package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insercion {

    public static Connection connection;
    public static void conectar(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_hierritos?serverTimezone=UTC",
                    "root",
                    "root"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean nuevoUsuario(String nombres,String telefono,
                                       String tipoDocumento,String numDocumento,String direccion,
                                       String correo,String tipoUsuario,String nombreUsuario,
                                       String contrasena
    ) {
        conectar();

        String sql = "INSERT INTO usuarios (nombres,telefono,tipoDocumento,numDocumento," +
                "direccion,correo,tipoUsuario,nombreUsuario,contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombres);
            statement.setString(2, telefono);
            statement.setString(3, tipoDocumento);
            statement.setString(4, numDocumento);
            statement.setString(5, direccion);
            statement.setString(6, correo);
            statement.setString(7, tipoUsuario);
            statement.setString(8, nombreUsuario);
            statement.setString(9, contrasena);

            // Ejecutar la consulta de inserción
            int filasAfectadas = statement.executeUpdate();

            connection.close();
            // Si al menos una fila se vio afectada, se considera exitoso
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean nuevoCliente(String nombres,String telefono,
                                       String tipoDocumento,String numDocumento,String direccion,
                                       String correo,String tipoPersona,String responsableDeIva, String clienteFrecuente)

    {
        conectar();
        // TODO Verificar que los argumentos no sean nulos o vacíos


        // Consulta SQL para insertar un nuevo cliente
        String sql = "INSERT INTO clientes (nombres,telefono,tipoDocumento,numDocumento," +
                "direccion,correo,tipoPersona,responsableDeIva,clienteFrecuente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombres);
            statement.setString(2, telefono);
            statement.setString(3, tipoDocumento);
            statement.setString(4, numDocumento);
            statement.setString(5, direccion);
            statement.setString(6, correo);
            statement.setString(7, tipoPersona);
            statement.setString(8, responsableDeIva);
            statement.setString(9, clienteFrecuente);

            // Ejecutar la consulta de inserción
            int filasAfectadas = statement.executeUpdate();

            connection.close();
            // Si al menos una fila se vio afectada, se considera exitoso
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean empresas_proveedoras(
            String nombre,String nit,
            String banco,String cuentaBancaria,String formasDePago)

    {
        conectar();
        // TODO Verificar que los argumentos no sean nulos o vacíos


        // Consulta SQL para insertar un nuevo cliente
        String sql = "INSERT INTO empresas_proveedoras (nombre,nit,banco,cuentaBancaria,formasDePago" +
                ")VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, nit);
            statement.setString(3, banco);
            statement.setString(4, cuentaBancaria);
            statement.setString(5, formasDePago);


            // Ejecutar la consulta de inserción
            int filasAfectadas = statement.executeUpdate();

            connection.close();
            // Si al menos una fila se vio afectada, se considera exitoso
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean facturasDeCompra(String nombreVendedor,
                                           String formasDePago,String fechaYHora,String total)
    {
        conectar();

        String sql = "INSERT INTO facturas_de_compra (nombreVendedor,formasDePago,fechaYHora,total"+
                ")VALUES ( ?, ?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, nombreVendedor);
            statement.setString(2, formasDePago);
            statement.setString(3, fechaYHora);
            statement.setString(4, total);

            int filasAfectadas = statement.executeUpdate();

            connection.close();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean facturasDeVenta(String fechaYHora,
                                          String consecutivoDian,String formaDePago,String idFerretería,String idUsuario,String idCliente,String total)
    {
        conectar();

        String sql = "INSERT INTO facturas_de_venta (fechaYHora,consecutivoDian,formaDePago,FERRETERIA_idferreteria," +
                "USUARIOS_idusuario," +
                "CLIENTES_idcliente,total"+
                ")VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, fechaYHora);
            statement.setString(2, consecutivoDian);
            statement.setString(3, formaDePago);
            statement.setString(4, "1");
            statement.setString(5, idUsuario);
            statement.setString(6, idCliente);
            statement.setString(7, total);


            int filasAfectadas = statement.executeUpdate();

            connection.close();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean ferreterias(String nombre, String telefono,String nit,String direccion,String correo)
    {
        conectar();

        String sql = "INSERT INTO ferreterias (nombre,telefono,nit,direccion,"+
                "correo)VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            statement.setString(3, nit);
            statement.setString(4, direccion);
            statement.setString(5, correo);


            int filasAfectadas = statement.executeUpdate();

            connection.close();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean inventarios(String valorVentas, String fecha)
    {
        conectar();

        String sql = "INSERT INTO inventarios (valorVentas,fecha"+")VALUES ( ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, valorVentas);
            statement.setString(2, fecha);

            int filasAfectadas = statement.executeUpdate();

            connection.close();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean productos(String codigo,String nombre,
                                    String descripcion,String existencia,String pDescuento,
                                    String pIva,String precioCompra,String precioVenta,
                                    String cantidadMinima,String cantidadMaxima)
    {
        conectar();

        String sql = "INSERT INTO productos (codigo,nombre,descripcion,existencia," +
                "pDescuento,pIva,precioCompra,precioVenta,cantidadMinima,cantidadMaxima) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codigo);
            statement.setString(2, nombre);
            statement.setString(3, descripcion);
            statement.setString(4, existencia);
            statement.setString(5, pDescuento);
            statement.setString(6, pIva);
            statement.setString(7, precioCompra);
            statement.setString(8, precioVenta);
            statement.setString(9, cantidadMinima);
            statement.setString(10, cantidadMaxima);


            int filasAfectadas = statement.executeUpdate();

            connection.close();
            // Si al menos una fila se vio afectada, se considera exitoso
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean empresas_proveedoras_has(){

        int idEmpresaProveedora = 1;
        int idFormaDePago = 2;

        conectar();
        String sql = "INSERT INTO empresas_proveedoras_has_formas_de_pago(EMPRESAS_PROVEEDORAS_idempresaProveedora," +
                " FORMAS_DE_PAGO_idforma_de_pago) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idEmpresaProveedora);
            statement.setInt(2, idFormaDePago);

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("Error al insertar datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());

        }
        return false;
    }

    public static boolean facturas_de_compra_has(String cantidadProducto){

        int idFacturaDeCompra = 1;
        int idProducto = 2;

        conectar();
        String sql = "INSERT INTO facturas_de_compra_has_productos(FACTURAS_DE_COMPRA_idfacturaDeCompra," +
                " PRODUCTOS_idproducto,cantidadProducto) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idFacturaDeCompra);
            statement.setInt(2, idProducto);
            statement.setDouble(3, Double.parseDouble(cantidadProducto));

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("Error al insertar datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());

        }
        return false;
    }

    public static boolean productos_has_facturas_de_venta(String idFactura,String idProducto,String cantidadProducto){

        conectar();
        String sql = "INSERT INTO productos_has_facturas_de_venta (PRODUCTOS_idproducto," +
                " FACTURAS_DE_VENTA_idfacturaDeVenta,cantidadProducto) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, idProducto);
            statement.setString(2, idFactura);
            statement.setDouble(3, Double.parseDouble(cantidadProducto));

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("Error al insertar datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());

        }
        return false;
    }

/*    public static boolean facturas_de_compra_has(String cantidadProductos
    ){

        int idInventario = 1;
        int idProducto = 2;

        conectar();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO facturas_de_compra_has_productos(INVENTARIO_idinventario," +
                " PRODUCTOS_idproducto,cantidadProductos) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idInventario);
            preparedStatement.setInt(2, idProducto);
            preparedStatement.setDouble(3, Double.parseDouble(cantidadProducto));

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("Error al insertar datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());

        }
        return false;
    }*/



    public static void main(String[] args) {
        Insercion.nuevoUsuario("nombres","telefono","tipoDocumento","numDocumento",
                "direccion","correo","tipoUsuario","nombreUsuario","contrasena");
    }

}