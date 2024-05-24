package Database;

import clases.Cliente;
import clases.Persona;

import java.sql.*;

public class Update {
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
    public static boolean restarExistencias(int cantidadVendida, String idproducto) {
        boolean bool = false;
        PreparedStatement preparedStatement = null;
        try {
            conectar();

            String sql = "UPDATE productos SET existencia = existencia - ? WHERE idproducto = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cantidadVendida);
            preparedStatement.setString(2,idproducto);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bool;
        }

    }

    public static boolean sumarExistencias(int cantidadComprada, String idproducto) {
        boolean bool = false;
        PreparedStatement preparedStatement = null;
        try {
            conectar();

            String sql = "UPDATE productos SET existencia = existencia + ? WHERE idproducto = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cantidadComprada);
            preparedStatement.setString(2,idproducto);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bool;
        }

    }
    public static boolean consecutivoDian(String id) {
        boolean bool = false;
        PreparedStatement preparedStatement = null;
        try {
            conectar();

            String sql = "UPDATE `db_hierritos`.`facturas_de_venta` SET `consecutivoDian` = ? WHERE (`idfacturaDeVenta` = ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bool;
        }

    }
    public static boolean cambiarFormaDePagoFacturaVenta(String id,String formaDePago) {
        boolean bool = false;
        PreparedStatement preparedStatement = null;
        try {
            conectar();

            String sql = "UPDATE `db_hierritos`.`facturas_de_venta` SET `formaDePago` = ? WHERE (`idfacturaDeVenta` = ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,formaDePago);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bool;
        }

    }
    /*UPDATE `db_hierritos`.`facturas_de_venta` SET `consecutivoDian` = '2' WHERE (`idfacturaDeVenta` = '1');*/

    public static void main(String[] args) {
        Update.restarExistencias(20,"1");
        Update.sumarExistencias(20,"1");
    }
}
