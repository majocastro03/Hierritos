package server;

import java.util.Properties;

public class MainServer {
    public static void main(String[] args) {
        Properties properties= new Properties();
        try {
            /*properties.load(new FileInputStream(new File("server.properties")));
            Server server = new Server(
                (String) properties.get("IP"),
                (String) properties.get("PORT"),
                (String) properties.get("SERVICENAME")
            );*/
            Server server = new Server("localhost");
            server.deployServiceAlmacen("5000","servicioAlmacen");
            server.deployServiceVentas("5001","servicioVentas");
            System.out.println("servicioAlmacen on");
        } catch (Exception e) {
            e.printStackTrace();
        } /*catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}