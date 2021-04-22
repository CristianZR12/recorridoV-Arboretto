package datos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Usuario;

public class DTUsuario {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Método para llenar el resultset usuario
	public void llenarRsUsuario(Connection c) {
		String sql = "SELECT * FROM recorrido_v.user";
		try {
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
		}
		catch(Exception e) {
			System.err.println("DT USUARIO: Error en listar usuarios " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Lista de Usuario
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM recorrido_v.user WHERE estado <> 3";
		try {
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setPwd(rs.getString("pwd"));
				u.setCreatedAt(rs.getTimestamp("created_at"));
				u.setEstado(rs.getInt("estado"));
				u.setFullName(rs.getString("fullname"));
				listaUsuarios.add(u);
			}
		}
		catch (Exception e) 
		{
			System.err.println("DT USUARIO: Error en listar usuarios " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs != null)
					rs.close();
				
				if(ps != null)
					ps.close();
				
				if(c != null)
					PoolConexion.closeConnection(c);
			} 
			catch (Exception e2) 
			{
				System.err.println("DT USUARIO: Error en listar usuarios " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return listaUsuarios;
	}
	
	//Guardar Usuario
	public boolean agregarUsuario(Usuario u) {
		boolean guardado = false;
		try {
			c = PoolConexion.getConnection();
			this.llenarRsUsuario(c);
			//Aquí Comienza el Guardar
			rsUsuario.moveToInsertRow();
			rsUsuario.updateString("fullname", u.getFullName());
			rsUsuario.updateString("username", u.getUsername());
			rsUsuario.updateString("email", u.getEmail());
			rsUsuario.updateString("pwd", md5(u.getPwd()));
			rsUsuario.updateInt("estado", 1);
			
			rsUsuario.insertRow();
			rsUsuario.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("DTUSUARIO: Error al guardar usuario " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsUsuario != null)
				{
					rsUsuario.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DTUSUARIO: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	//Método para encriptar con MD5
	public String md5(String input)
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
				
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) 
			{
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} 
		catch (NoSuchAlgorithmException e) 
		{
			throw new RuntimeException(e);
		}
	}
}
