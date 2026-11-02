package Polizas.Marcas;

import Polizas.General.Conexion;
import Polizas.General.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcasModelo extends Conexion implements DAO {
    
    @Override
    public List<Marca> read() {
        List<Marca> lista = new ArrayList<>();
        try {
            conectar();
            ps = cnx.prepareStatement("SELECT * FROM marcas");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Marca(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error Read: " + ex.getMessage());
        } finally {
            close();
        }
        return lista;
    }
    
    @Override
    public int create(Object obj) {
        int resultado = 0;
        try {
            conectar();
            ps = cnx.prepareStatement("INSERT INTO marcas (nombre) VALUES (?)");
            ps.setString(1, ((Marca) obj).getNombre());
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error Create: " + ex.getMessage());
        } finally {
            close();
        }
        return resultado;
    }
    
    @Override
    public int update(Object obj) {
        int resultado = 0;
        try {
            conectar();
            ps = cnx.prepareStatement("UPDATE marcas SET nombre = ? WHERE id = ?");
            ps.setString(1, ((Marca) obj).getNombre());
            ps.setInt(2, ((Marca) obj).getId());
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error Update: " + ex.getMessage());
        } finally {
            close();
        }
        return resultado;
    }
    
    @Override
    public int delete(Object obj) {
        int resultado = 0;
        try {
            conectar();
            ps = cnx.prepareStatement("DELETE FROM marcas WHERE id = ?");
            ps.setInt(1, ((Marca) obj).getId());
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error Delete: " + ex.getMessage());
        } finally {
            close();
        }
        return resultado;
    }
}