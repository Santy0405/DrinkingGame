package Logica;
import Objetos.Tarjeta;
import java.sql.*;
import java.util.ArrayList;
public class DBConexion {

    String url = "jdbc:sqlite:C:\\Users\\57320\\OneDrive\\Documentos\\Trabajos UD\\FIS\\Proyecto_FIS\\identifier.sqlite";
    Connection conexion;
    public DBConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Tarjeta> DevolverListaTarjeta(){
        ArrayList<Tarjeta> tarjetasJugar = new ArrayList<Tarjeta>();
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Tarjeta");
            ResultSet Result = st.executeQuery();
            while (Result.next()){
                tarjetasJugar.add(new Tarjeta(Result.getString("Contenido"), Result.getInt("Puntos")));
            }
            return tarjetasJugar;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
