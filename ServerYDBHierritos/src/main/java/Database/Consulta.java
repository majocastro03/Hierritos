package Database;
import clases.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Consulta {

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

    public static String obtenerContraseñaPorNombre(String nombreDeUsuario) {
        String contrasena = null;
//        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

/*          String url = "jdbc:mysql://localhost:3306/db_hierritos?serverTimezone=UTC";
            String usuarioDB = "root";
            String contrasenaDB = "root";

            connection = DriverManager.getConnection(url, usuarioDB, contrasenaDB);*/
            conectar();

            String sql = "SELECT contrasena FROM usuarios WHERE nombreUsuario = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nombreDeUsuario);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                contrasena = resultSet.getString("contrasena");
                //TODO recibir tipoUsuario
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return contrasena;
        }

    }


    public static Usuario obtenerUsuarioPorNombre(String nombreUsuario, String contrasena) {
        Usuario usuario = new Usuario();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM usuarios WHERE nombreUsuario = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nombreUsuario);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                usuario.setId(resultSet.getString("idusuario"));
                usuario.setNombres(resultSet.getString("nombres"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setTipoDocumento(Enum.valueOf(Persona.TipoDocumento.class,resultSet.getString("tipoDocumento")));
                usuario.setNumDocumento(resultSet.getString("numDocumento"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setTipoUsuario(Enum.valueOf(Usuario.TipoUsuario.class,resultSet.getString("tipoUsuario")));
                usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                usuario.setContrasena(contrasena);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return usuario;
        }

    }

    public static String ultimaFacturaVenta(){
        String id = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT MAX(idfacturaDeVenta) AS idfacturaDeVenta FROM facturas_de_venta";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = ""+resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id;
        }
    }


    public static Cliente obtenerClientePorTelefono(String telefono) {
        Cliente cliente  = new Cliente();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM clientes WHERE telefono = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,telefono);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                cliente.setId(resultSet.getString("idcliente"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setNumDocumento(resultSet.getString("numDocumento"));
                cliente.setTipoDocumento(Enum.valueOf(Persona.TipoDocumento.class,resultSet.getString("tipoDocumento")));
                cliente.setTipoPersona(Enum.valueOf(Cliente.TipoPersona.class,resultSet.getString("tipoPersona")));
                cliente.setResponsableDeIva(resultSet.getBoolean("responsableDeIva"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return cliente;
        }

    }

    public static Cliente obtenerClientePorCedula(String cedula) {
        Cliente cliente  = new Cliente();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM clientes WHERE numDocumento = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cedula);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                cliente.setId(resultSet.getString("idcliente"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setNumDocumento(resultSet.getString("numDocumento"));
                cliente.setTipoDocumento(Enum.valueOf(Persona.TipoDocumento.class,resultSet.getString("tipoDocumento")));
                cliente.setTipoPersona(Enum.valueOf(Cliente.TipoPersona.class,resultSet.getString("tipoPersona")));
                cliente.setResponsableDeIva(resultSet.getBoolean("responsableDeIva"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return cliente;
        }

    }

    public static Cliente obtenerClientePorId(String idcliente) {
        Cliente cliente  = new Cliente();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM clientes WHERE idcliente = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.valueOf(idcliente));
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                cliente.setId(resultSet.getString("idcliente"));
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setNumDocumento(resultSet.getString("numDocumento"));
                cliente.setTipoDocumento(Enum.valueOf(Persona.TipoDocumento.class,resultSet.getString("tipoDocumento")));
                cliente.setTipoPersona(Enum.valueOf(Cliente.TipoPersona.class,resultSet.getString("tipoPersona")));
                cliente.setResponsableDeIva(resultSet.getBoolean("responsableDeIva"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return cliente;
        }

    }

    public static EmpresaProveedora obtenerEmpresaProveedoraPorId(String idempresaProveedora) {
        EmpresaProveedora empresaProveedora  = new EmpresaProveedora();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM empresas_proveedoras WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idempresaProveedora);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                empresaProveedora.setNombre(resultSet.getString("nombre"));
                empresaProveedora.setNit(resultSet.getString("nit"));
                empresaProveedora.setBanco(resultSet.getString("banco"));
                empresaProveedora.setCuentaBancaria(resultSet.getString("cuentaBancaria"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return empresaProveedora;
        }

    }

    public static FacturaCompra obtenerFacturaCompraPorId(String idfacturaDeCompra) {
        FacturaCompra facturaCompra  = new FacturaCompra();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM facturas_de_compra WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idfacturaDeCompra);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                facturaCompra.setNombreVendedor(resultSet.getString("nombreVendedor"));
//              facturaCompra.setFormaDePago(resultSet.getString("formaDePago"));
//              facturaCompra.setFechaYHora(resultSet.getString("fechaYHora"));
                facturaCompra.setTotal(Double.parseDouble(resultSet.getString("total")));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return facturaCompra;
        }

    }

    public static FacturaVenta obtenerFacturaVentaPorId(String idfacturaDeVenta) {
        FacturaVenta facturaVenta  = new FacturaVenta();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM facturas_de_venta WHERE idfacturaDeVenta = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idfacturaDeVenta);
            resultSet = preparedStatement.executeQuery();

            String idCliente=null;
            String idVendedor=null;
            if (resultSet.next()) {
                facturaVenta.setIdFacturaVenta(resultSet.getInt("idfacturaDeVenta"));
                facturaVenta.setFechaYHora(resultSet.getString("fechaYHora"));
                facturaVenta.setConsecutivoDian(Integer.parseInt(resultSet.getString("consecutivoDian")));
                facturaVenta.setFormaDePago(Enum.valueOf(EmpresaProveedora.FormaDePago.class,resultSet.getString("formaDePago")));
                facturaVenta.setTotal(Double.parseDouble(resultSet.getString("total")));
                idCliente = resultSet.getString("CLIENTES_idcliente");
                idVendedor = resultSet.getString("USUARIOS_idusuario");
            }
            facturaVenta.setCliente(Consulta.obtenerClientePorId(idCliente));
            facturaVenta.setVendedor(Consulta.obtenerUsuarioPorId(idVendedor));
            facturaVenta.setFerreteria(Consulta.obtenerFerreteriaPorId("1"));
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return facturaVenta;
        }

    }

    public static Ferreteria obtenerFerreteriaPorId(String idferreteria) {
        Ferreteria ferreteria  = new Ferreteria();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM ferreterias WHERE idferreteria = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idferreteria);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                ferreteria.setIdFerreteria(resultSet.getInt("idferreteria"));
                ferreteria.setNombre(resultSet.getString("nombre"));
                ferreteria.setTelefono(resultSet.getString("telefono"));
                ferreteria.setNit(resultSet.getString("nit"));
                ferreteria.setDireccion(resultSet.getString("direccion"));
                ferreteria.setCorreo(resultSet.getString("correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ferreteria;
        }

    }

//    public static EmpresaProveedora.FormaDePago obtenerFerreteriaPorId(String id_forma_de_pago) {
//        EmpresaProveedora.FormaDePago formaDePago;
//        formaDePago = new EmpresaProveedora.FormaDePago();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            conectar();
//
//            String sql = "SELECT * FROM formas_de_pago WHERE id = ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,id_forma_de_pago);
//            resultSet = preparedStatement.executeQuery();
//
//
//            if (resultSet.next()) {
//                formaDePago.setforma(resultSet.getString("nombre"));
//
//
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        } finally {
//
//
//            try {
//                if (resultSet != null) resultSet.close();
//                if (preparedStatement != null) preparedStatement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return facturaVenta;
//        }
//
//    }

    public static Producto obtenerProductoPorId(String idproducto) {
        Producto producto = new Producto();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM productos WHERE idproducto = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.valueOf(idproducto));
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                producto.setIdProducto(resultSet.getInt("idproducto"));
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setExistencias(Double.parseDouble(resultSet.getString("existencia")));
                producto.setpDescuento(Double.parseDouble(resultSet.getString("pDescuento")));
                producto.setpIva(Double.parseDouble(resultSet.getString("pIva")));
                producto.setPrecioCompra(Double.parseDouble(resultSet.getString("precioCompra")));
                producto.setPrecioVenta(Double.parseDouble(resultSet.getString("precioVenta")));
                producto.setCantidadMinima(Double.parseDouble(resultSet.getString("cantidadMinima")));
                producto.setCantidadMaxima(Double.parseDouble(resultSet.getString("cantidadMaxima")));
//                producto.setPrecioTotal(Double.parseDouble(resultSet.getString("precioTotal")));
                //TODO No esta la columna precioTotal dentro de la base de datos

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return producto;
        }

    }

    public static Usuario obtenerUsuarioPorId(String idusuario) {
        Usuario usuario = new Usuario();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conectar();

            String sql = "SELECT * FROM usuarios WHERE idusuario = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.valueOf(idusuario));
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                usuario.setId(resultSet.getString("idusuario"));
                usuario.setNombres(resultSet.getString("nombres"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setTipoDocumento(Enum.valueOf(Persona.TipoDocumento.class,resultSet.getString("tipoDocumento")));
                usuario.setNumDocumento(resultSet.getString("numDocumento"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setTipoUsuario(Enum.valueOf(Usuario.TipoUsuario.class,resultSet.getString("tipoUsuario")));
                usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                usuario.setContrasena(resultSet.getString("contrasena"));




            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return usuario;
        }

    }

    public static LinkedList<Producto> listaProductosStock() {
        LinkedList<Producto> productos = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            conectar();

            String sql = "SELECT * FROM productos";
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Producto producto = new Producto();
                producto.setIdProducto(resultSet.getInt("idproducto"));
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setExistencias(Double.parseDouble(resultSet.getString("existencia")));
                producto.setpDescuento(Double.parseDouble(resultSet.getString("pDescuento")));
                producto.setpIva(Double.parseDouble(resultSet.getString("pIva")));
                producto.setPrecioCompra(Double.parseDouble(resultSet.getString("precioCompra")));
                producto.setPrecioVenta(Double.parseDouble(resultSet.getString("precioVenta")));
                producto.setCantidadMinima(Double.parseDouble(resultSet.getString("cantidadMinima")));
                producto.setCantidadMaxima(Double.parseDouble(resultSet.getString("cantidadMaxima")));
                productos.add(producto);

            }


        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return productos;

        }
    }

    public static LinkedList<Producto> listaIdProductosFacturaVentaHasProductos(String idFacturaVenta) {
        LinkedList<Producto> productos = new LinkedList<>();
        ResultSet resultSet = null;

        PreparedStatement statement = null;
        try {
            conectar();

            String sql = "SELECT * FROM productos_has_facturas_de_venta WHERE FACTURAS_DE_VENTA_idfacturaDeVenta = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,Integer.valueOf(idFacturaVenta));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setExistencias(resultSet.getInt("cantidadProducto"));
                producto.setIdProducto(resultSet.getInt("PRODUCTOS_idproducto"));
                productos.add(producto);
            }


        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return productos;

        }
    }

    public static void main(String[] args) {
        System.out.println(Consulta.obtenerProductoPorId("7").getExistencias());
    }

/*    public static void main(String[] args) {
//        Insercion.facturasDeVenta("10-10-10","3","1","1","1","1","1");
        System.out.println(Consulta.ultimaFacturaVenta());
    }*/

/*    public static void main(String[] args) {
        Cliente cliente = Consulta.obtenerClientePorTelefono("3016995315");
        System.out.println(cliente.getNombres()+" "+cliente.getResponsableDeIva()+" "+cliente.getTipoDocumento()+cliente.getTipoPersona());
    }*/

/*    public static void main(String[] args) {
        String nombreDeUsuario = "Juan";

        String contrasena = Consulta.obtenerContraseñaPorNombre(nombreDeUsuario);

        if (contrasena != null) {
            System.out.println("La contraseña para " + nombreDeUsuario + " es: " + contrasena);
        } else {
            System.out.println("El usuario no se encontró en la base de datos.");
        }
    }*/



}
