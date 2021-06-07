import java.io.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
public class Conexion {
    Connection con;
   
    public Connection conectar()
	{
       
            
            
		con = null;
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/peliculas","root",""); 
       // ("jdbc:mysql://remotemysql.com:3306/EhXHnpXShS","EhXHnpXShS","twZfG6XzB3");   
      //("jdbc:mysql://localhost:3306/peliculas","root","");                    
                                
		}

		catch(ClassNotFoundException cnfe)
		{   cnfe.printStackTrace();
			System.out.println(cnfe.getMessage());
		}

		catch(SQLException sqle)
		{sqle.printStackTrace();
			System.out.println(sqle.getMessage());
		}
		return con;

	}

	public boolean agregarPelicula(Pelicula p)
   	{
             
   		boolean resultado=false;
   		try{
   			 con=conectar();
   			PreparedStatement ps=con.prepareStatement("Insert into pelicula values (?,?,?,?,?)");
   			
                           ps.setInt(1,p.getId());
   			ps.setString(2,p.getNombre());
   			ps.setString(3,p.getGenero());
                           ps.setInt(4,p.getAnio());
                           ps.setString(5,p.getPoster());
   				int filasAfectadas=ps.executeUpdate();
   				if (filasAfectadas>0)
   				{
   					resultado=true;
   				}
                                 con.close();
   		}
   		catch(SQLException sqle)
   		{
   				sqle.printStackTrace();
   		}
   		return resultado;
   	}
     public ArrayList<Pelicula> consultarPeliculas()
      {
          ArrayList<Pelicula>  misPeliculas = new ArrayList();
      	ResultSet rs;
      	Statement stm;
      	String sentenciaSQL = "SELECT * FROM pelicula";

      	try
      	{
             con=conectar();
      		stm = con.createStatement();
      		rs = stm.executeQuery(sentenciaSQL);

      		while(rs.next())
      		{
      	Pelicula p = new Pelicula();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setGenero(rs.getString("genero"));
        p.setAnio(rs.getInt("anio"));
        p.setPoster(rs.getString("poster"));
        
        misPeliculas.add(p);

      		}
                
               
 con.close();
      	}

      	catch (SQLException sqle)
      	{
      		System.out.println(sqle.getMessage());
      		sqle.printStackTrace();
      	}
         return misPeliculas;
      	
      }

   public ArrayList<Pelicula> buscarPelicula(int id)
   	{
             ArrayList<Pelicula>  misPeliculas = new ArrayList();
   		boolean resultado=false;
   		try
   		{
   			con=conectar();
   			PreparedStatement ps=con.prepareStatement("Select * from pelicula where id = ?");
   			ps.setInt(1,id);

   			ResultSet rs =ps.executeQuery();
   			while(rs.next())
   			{
                	Pelicula p = new Pelicula();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setGenero(rs.getString("genero"));
        p.setAnio(rs.getInt("anio"));
        p.setPoster(rs.getString("poster"));
        
        misPeliculas.add(p);
   		resultado=true;		
   			}
                        
                                 con.close();
   		}
   		catch(SQLException sqle)
   		{
   			sqle.printStackTrace();
   		}
   		return misPeliculas;
   	}
   
   
   
   
     public boolean existePelicula(int id)
   	{
            
   		boolean resultado=false;
   		try
   		{
   			con=conectar();
   			PreparedStatement ps=con.prepareStatement("Select * from pelicula where id = ?");
   			ps.setInt(1,id);

   			ResultSet rs =ps.executeQuery();
   			while(rs.next())
   			{
                	
   				resultado=true;
   			}
                         con.close();
   		}
   		catch(SQLException sqle)
   		{
   			sqle.printStackTrace();
   		}
   		return resultado;
   	}
   
   
  
public boolean eliminarPelicula(int id)
   	{
   		boolean resultado=false;
   		try
   		{
                    
                    if (existePelicula(id)){
   			 con=conectar();
   			PreparedStatement ps=con.prepareStatement("delete from pelicula where id = ?");
   			ps.setInt(1,id);
                        ps.executeUpdate();
                        resultado=true;
                    }
   			 con.close();
   		}
   		catch(SQLException sqle)
   		{
   			sqle.printStackTrace();
   		}
   		return resultado;
   	}


public boolean modificarPelicula(Pelicula usi)
   	{
   		boolean resultado=false;
   		try
   		{
   			con =conectar();
   			PreparedStatement ps=con.prepareStatement("update pelicula set nombre=?, genero=?, anio=?, poster=? where id = ?");
   	    ps.setString(1,usi.getNombre());
            ps.setString(2,usi.getGenero());
            ps.setInt(3,usi.getAnio());
            ps.setString(4,usi.getPoster());
            ps.setInt(5,usi.getId());
            
            /*System.out.println(usi.getNombre());
              System.out.println(usi.getGenero());
                System.out.println(usi.getAnio());
                  System.out.println(usi.getPoster());
                    System.out.println(usi.getId()); */

   			ps.executeUpdate();


   				resultado=true;
 con.close();
   		}
   		catch(SQLException sqle)
   		{
   			sqle.printStackTrace();
   		}
                
   		return resultado;
   	}

}

