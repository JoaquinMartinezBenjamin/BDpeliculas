
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuMain extends JFrame implements ActionListener {

    JComboBox<String> combo1;
     JComboBox<String> comboM;
      JTextField nombreM, anioM, generoM;
             
    JTextField nombre, anio, genero, busqueda,eliminacion,modificacion;
    
    JLabel foto,fotoM;
    Icon fotoUsuario,fotoUsuarioM;
    Image redimensionada,redimensionadaM;
    String rutaFoto,rutaFotoM;
      String photo,photoM;
    
    JButton buscarImagen, agregarPelicula, listar, find,findM,eliminar,buscarImagenM,modificar;
    JPanel contentPane,panel1,panel2, panel3, panel4,panel5,panelista, panelbusqueda,panelEliminar;
    JPanel panelModificar,panelbuscarmodificar;
    JTabbedPane panelDePestanas;
  


    public MenuMain() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(200, 100, 360, 520); //ancho,alto
        setSize(450, 350);
        setLocationRelativeTo(null);  //centro en pantalla
        setVisible(true);
        setTitle("Cine");
        setLayout(null);
        setResizable(true);
        // getContentPane().setLayout(new FlowLayout());
        ///////////////////////////////////////

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        ///////////////////////////////////////
        panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
        //panelDePestanas.setBounds(10, 11, 383, 174);
        contentPane.add(panelDePestanas);
        panel1 = new JPanel();
        JPanel panelAgregar = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panelDePestanas.addTab("Agregar pelicula", null, panelAgregar, null);
        panelDePestanas.addTab("Buscar", null, panel2, null);
        panelDePestanas.addTab("Eliminar", null, panel4, null);
        panelDePestanas.addTab("Listar", null, panel3, null);
         panelDePestanas.addTab("Modificar", null, panel5, null);
        ////////////////////////////////////////

        panel1.setLayout(new GridLayout(4, 2));
        panelAgregar.setLayout(new BorderLayout());
        JLabel lblnombre = new JLabel("Nombre:");
        nombre = new JTextField();
        JLabel lblgenero = new JLabel("Genero:");
        genero = new JTextField("");
        JLabel lblanio = new JLabel("Anio");
        anio = new JTextField();
        JLabel poster = new JLabel("Poster");
        ////////////////////////////////////////77
        foto = new JLabel();
        foto.setSize(130, 130);
        rutaFoto =  "usuario.jpg";
        photo= System.getProperty("user.dir") + "/img/" + rutaFoto;
        redimensionada = new ImageIcon(photo).getImage();
        redimensionada = redimensionada.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        fotoUsuario = new ImageIcon(redimensionada);
        foto.setIcon(fotoUsuario);
        buscarImagen = new JButton("Buscar poster");
        buscarImagen.addActionListener(this);
        agregarPelicula = new JButton("Agregar pelicula");
        agregarPelicula.addActionListener(this);
        combo1 = new JComboBox<String>();
        combo1.addItem("Ciencia ficcion");
        combo1.addItem("Terror");
        combo1.addItem("Super Heroes");
        combo1.addItem("Infantil");
        combo1.addItem("Accion");
        combo1.addItem("Drama");
        combo1.addItem("Comedia");
        combo1.addItem("Fantasia");
        //////////////////////////////////////
        panel1.add(lblnombre);
        panel1.add(nombre);
        panel1.add(lblgenero);
        panel1.add(combo1);
        panel1.add(lblanio);
        panel1.add(anio);
        panel1.add(poster);
        panel1.add(buscarImagen);
        //////////////////////////
        panelAgregar.add("North", panel1);
        panelAgregar.add("East", foto);
        panelAgregar.add("South", agregarPelicula);
        //////////////////////
        panelbuscarmodificar = new JPanel(new FlowLayout());
        modificacion =new JTextField(10);
        panelbuscarmodificar.add(new JLabel("ID. de pelicula a modificar: "));
        panelbuscarmodificar.add(modificacion);
       findM = new JButton("BUSCAR");
        findM.addActionListener(this);
        panelbuscarmodificar.add(findM);
        panelModificar = new JPanel();
        panelModificar.setLayout(new GridLayout(6, 2));
        panel5.setLayout(new BorderLayout());
        
        
         buscarImagenM = new JButton("Buscar poster");
        buscarImagenM.addActionListener(this);
        fotoM = new JLabel();
        fotoM.setSize(130, 130);
        rutaFotoM =  "usuarioM.jpg";
        photoM= System.getProperty("user.dir") + "/img/" + rutaFotoM;
        redimensionadaM = new ImageIcon(photoM).getImage();
        redimensionadaM = redimensionadaM.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        fotoUsuarioM = new ImageIcon(redimensionadaM);
        fotoM.setIcon(fotoUsuarioM);
        JLabel lblnombreM = new JLabel("Nombre:");
        nombreM = new JTextField();
        JLabel lblgeneroM = new JLabel("Genero:");
        generoM = new JTextField("");
        JLabel lblanioM = new JLabel("Anio");
        anioM = new JTextField();
        JLabel posterM = new JLabel("Poster");
       comboM = new JComboBox<String>();
        comboM.addItem("Ciencia ficcion");
        comboM.addItem("Terror");
        comboM.addItem("Super Heroes");
        comboM.addItem("Infantil");
        comboM.addItem("Accion");
        comboM.addItem("Drama");
        comboM.addItem("Comedia");
        comboM.addItem("Fantasia");
            panelModificar.add(new JLabel(""));
            panelModificar.add(new JLabel(""));
        panelModificar.add(lblnombreM);
        panelModificar.add(nombreM);
        panelModificar.add(lblgeneroM);
        panelModificar.add(comboM);
       panelModificar.add(lblanioM);
       panelModificar.add(anioM);
        panelModificar.add(posterM);
        panelModificar.add(buscarImagenM);
         panelModificar.add(new JLabel(""));
            panelModificar.add(new JLabel(""));
        modificar = new JButton ("Modificar");
        modificar.addActionListener(this);
        panel5.add("North",panelbuscarmodificar);
        panel5.add("Center",panelModificar);
        panel5.add("East", fotoM);
        panel5.add("South",modificar);
        ////////////////////////

        find = new JButton("BUSCAR");
        find.addActionListener(this);
        busqueda = new JTextField(10);
        panel2.setLayout(new FlowLayout());
        panel2.add(new JLabel("ID. a buscar: "));
        panel2.add(busqueda);
        panel2.add(find);
        panelbusqueda = new JPanel();
        panelbusqueda.setLayout(new BoxLayout(panelbusqueda, BoxLayout.Y_AXIS));
        panel2.add(panelbusqueda);
        /////////////////////
        
        eliminar = new JButton("Eliminar");
        eliminar.addActionListener(this);
        eliminacion =new JTextField(10);
        panel4.setLayout(new FlowLayout());
        panel4.add(new JLabel("ID. de pelicula a eliminar: "));
        panel4.add(eliminacion);
        panel4.add(eliminar);
        panelEliminar = new JPanel();
        panelEliminar.setLayout(new BoxLayout(panelEliminar, BoxLayout.Y_AXIS));
        panel4.add(panelEliminar);
        
        /////////////////////
        listar = new JButton("Listar/Actualizar");
        listar.addActionListener(this);
        panelista = new JPanel();
        panelista.setLayout(new BoxLayout(panelista, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(panelista);
        // scroll.setSize(100,100);
        panel3.setLayout(new BorderLayout());
        panel3.add("North", listar);
        panel3.add("Center", scroll);
        ////////////////
        getContentPane().setVisible(false);
        getContentPane().setVisible(true);
        //////////////////
    }

    public void actionPerformed(ActionEvent mn) {
        if (mn.getSource() == listar) {             listarPeliculas();}
        if (mn.getSource() == find) {               buscarPelicula();}
        if (mn.getSource() == agregarPelicula) {    agregarPelicula();}
        if (mn.getSource() == buscarImagen) {       busquedaImagen();}
        if (mn.getSource() == buscarImagenM) {       busquedaImagenM();}
        if (mn.getSource() == eliminar) {       eliminarPelicula();}
        if (mn.getSource() == findM) {               buscarPeliculaM();}
        if (mn.getSource() == modificar) {              modificarPelicula();}
                                              }
    
    public void busquedaImagen(){
    
            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
            fileChooser.setFileFilter(imgFilter);

            int result = fileChooser.showOpenDialog(this);
            //int result = fileChooser.showSaveDialog(this);

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    //txt.setText("...");
                    fotoUsuario = new ImageIcon(redimensionada); // la foto que tengo default
                    foto.setIcon(fotoUsuario);
                } else {
                    try {
                        //txt.setText(fileName.getAbsolutePath());

                        String Dest = System.getProperty("user.dir") + "/img/" + fileName.getName();
                        Path Destino = Paths.get(Dest);
                        String Orig = fileName.getPath();
                        Path Origen = Paths.get(Orig);
                        Files.copy(Origen, Destino, REPLACE_EXISTING);
                        //rutaFoto = Dest;
                        rutaFoto= fileName.getName();

                        /////////////
                        Image redimensionada = new ImageIcon(Dest).getImage();
                        redimensionada = redimensionada.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                        fotoUsuario = new ImageIcon(redimensionada);
                        //////////////
                        foto.setIcon(fotoUsuario);
                    } catch (IOException e) {
System.out.println("Error E/S: "+e);
                    }

                }
            }
    }
    
    public void agregarPelicula(){
    
        try {

                //obtengo los datos
                String name = nombre.getText();
                String gener = (String) combo1.getSelectedItem();
                String ruta = rutaFoto;
                int year = Integer.parseInt(anio.getText());
                
                // agrego el objeto a la bd
                Pelicula p = new Pelicula(0, name, gener, year, ruta);
                //0 en id porque es autoincrementable en la bd
                Conexion c= new Conexion();
                c.agregarPelicula(p);
               
                //limpio la entrada de datos
                nombre.setText("");
                genero.setText("");
                anio.setText("");
                rutaFoto = "usuario.jpg";
                
                //agrego el poster default al panel de entrada
                String photo= System.getProperty("user.dir") + "/img/" + rutaFoto;
                redimensionada = new ImageIcon(photo).getImage();
                redimensionada = redimensionada.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                fotoUsuario = new ImageIcon(redimensionada);
                foto.setIcon(fotoUsuario);
               
              

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Dejo un campo vacio o introdujo mal el anio");

            }
    }
    
    public void listarPeliculas(){
       panelista.removeAll();
            panelista.repaint();
            ArrayList<Pelicula> misPeliculas = new ArrayList();
            
            Conexion c = new Conexion();
            misPeliculas = c.consultarPeliculas();
            
            String aux2 = "";

            for (int i = 0; i < misPeliculas.size(); i++) {
                aux2 = "";

                aux2 = "\tID: " + misPeliculas.get(i).getId() + "\n";
                panelista.add(new JLabel(aux2));
                aux2 = "\tNombre: " + misPeliculas.get(i).getNombre() + "\n";
                panelista.add(new JLabel(aux2));
                aux2 = "\tGenero: " + misPeliculas.get(i).getGenero() + "\n";
                panelista.add(new JLabel(aux2));
                aux2 = "\tAnio de estreno: " + misPeliculas.get(i).getAnio() + "\n";
                panelista.add(new JLabel(aux2));
                String rutaFoto = misPeliculas.get(i).getPoster();
                String photo= System.getProperty("user.dir") + "/img/" + rutaFoto;
                //Image redimensionada = new ImageIcon(rutaFoto).getImage();
                Image redimensionada = new ImageIcon(photo).getImage();
                redimensionada = redimensionada.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                Icon fotoUsuario = new ImageIcon(redimensionada);
                JLabel foto = new JLabel();
                foto.setIcon(fotoUsuario);
                panelista.add(foto);
                panelista.add(new JLabel("*********************************"));

                panelista.repaint();
                panel3.setVisible(false);
                panel3.setVisible(true);
            }
    }
    
    public void buscarPelicula(){
    
            boolean encontrado = false;
            panelbusqueda.removeAll();
            panelbusqueda.repaint();

            ArrayList<Pelicula> p = new ArrayList();
            Conexion c= new Conexion();
            try {
            p = c.buscarPelicula(Integer.parseInt(busqueda.getText()));

            String aux2 = "";
            
                    if (p.size() != 0) {
                        encontrado = true;
                        aux2 = "";
                        JLabel aux = new JLabel(aux2);

                        aux2 = "\tID: " + p.get(0).getId() + "\n";
                        panelbusqueda.add(new JLabel(aux2));
                        aux2 = "\tNombre: " + p.get(0).getNombre() + "\n";
                        panelbusqueda.add(new JLabel(aux2));
                        aux2 = "\tGenero: " + p.get(0).getGenero() + "\n";
                        panelbusqueda.add(new JLabel(aux2));
                        aux2 = "\tAnio de estreno: " + p.get(0).getAnio() + "\n";
                        panelbusqueda.add(new JLabel(aux2));
                        String rutaFoto = p.get(0).getPoster();
                        
                String photo= System.getProperty("user.dir") + "/img/" + rutaFoto;
                Image redimensionada = new ImageIcon(photo).getImage();
                        
                     
                        redimensionada = redimensionada.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                        Icon fotoUsuario = new ImageIcon(redimensionada);
                        JLabel foto = new JLabel();
                        foto.setIcon(fotoUsuario);
                        panelbusqueda.add(foto);

                        //panelista.repaint();
                        panelbusqueda.setVisible(false);
                        panelbusqueda.setVisible(true);
                }

                if (encontrado == false) {
                    JOptionPane.showMessageDialog(null, "Registro no encontrado");
                }
              } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Introduzca id en formato numerico");
              }
    }
    
    public void eliminarPelicula(){
        
            boolean encontrado = false;
            panelEliminar.removeAll();
            panelEliminar.repaint();

           
            Conexion c= new Conexion();
            try {
            encontrado= c.eliminarPelicula(Integer.parseInt(eliminacion.getText()));

            String aux = "";
            
                    if (encontrado) {
      aux = "Registro: " + Integer.parseInt(eliminacion.getText())+ " elminado con exito";
                        panelEliminar.add(new JLabel(aux));
                        panelEliminar.setVisible(false);
                        panelEliminar.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Registro no encontrado");
                }
                    
              } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Introduzca id en formato numerico");
              }
        
    }

    public void busquedaImagenM(){
    
            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
            fileChooser.setFileFilter(imgFilter);

            int result = fileChooser.showOpenDialog(this);
            //int result = fileChooser.showSaveDialog(this);

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    //txt.setText("...");
                    fotoUsuarioM = new ImageIcon(redimensionadaM); // la foto que tengo default
                    fotoM.setIcon(fotoUsuarioM);
                } else {
                    try {
                        //txt.setText(fileName.getAbsolutePath());

                        String Dest = System.getProperty("user.dir") + "/img/" + fileName.getName();
                        Path Destino = Paths.get(Dest);
                        String Orig = fileName.getPath();
                        Path Origen = Paths.get(Orig);
                        Files.copy(Origen, Destino, REPLACE_EXISTING);
                        //rutaFoto = Dest;
                        rutaFotoM= fileName.getName();

                        /////////////
                        Image redimensionada = new ImageIcon(Dest).getImage();
                        redimensionada = redimensionada.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                        fotoUsuarioM = new ImageIcon(redimensionada);
                        //////////////
                        fotoM.setIcon(fotoUsuarioM);
                    } catch (IOException e) {
System.out.println("Error E/S: "+e);
                    }

                }
            }
    }
    
     public void buscarPeliculaM(){
    
            boolean encontrado = false;
            panelbusqueda.removeAll();
            panelbusqueda.repaint();

            ArrayList<Pelicula> p = new ArrayList();
            Conexion c= new Conexion();
            try {
            p = c.buscarPelicula(Integer.parseInt(modificacion.getText())); //id

            String aux2 = "";
            
                    if (p.size() != 0) {
                        encontrado = true;
                        
                        
                        nombreM.setText(p.get(0).getNombre());
                        comboM.setSelectedItem(p.get(0).getGenero());
                        anioM.setText(p.get(0).getAnio()+"");
                        
                  rutaFotoM = p.get(0).getPoster();
                  photoM= System.getProperty("user.dir") + "/img/" + rutaFotoM;
                  redimensionadaM = new ImageIcon(photoM).getImage();
                  redimensionadaM = redimensionadaM.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                  fotoUsuarioM = new ImageIcon(redimensionadaM);
                  fotoM.setIcon(fotoUsuarioM);

                        panelbusqueda.setVisible(false);
                        panelbusqueda.setVisible(true);
                     
                }

                if (encontrado == false) {
                    JOptionPane.showMessageDialog(null, "Registro no encontrado");
                  
                       //limpio la entrada de datos
                nombreM.setText("");
                anioM.setText("");
                rutaFotoM = "usuarioM.jpg";
                
                //agrego el poster default al panel de entrada
                photoM= System.getProperty("user.dir") + "/img/" + rutaFotoM;
                redimensionadaM = new ImageIcon(photoM).getImage();
                redimensionadaM = redimensionadaM.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                fotoUsuarioM = new ImageIcon(redimensionadaM);
                fotoM.setIcon(fotoUsuarioM);
               
                }
              } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Introduzca id en formato numerico");
              }
    }
    
    public void modificarPelicula(){
    
            try {
                Conexion c= new Conexion();
               int dni=Integer.parseInt(modificacion.getText());
              
                    if(c.existePelicula(dni)){
       
                    
                //obtengo los datos
               
                String name = nombreM.getText();
                String gener = (String) comboM.getSelectedItem();
                String ruta = rutaFotoM;
                int year = Integer.parseInt(anioM.getText());
                
                // creo el objeto
                Pelicula p = new Pelicula(dni, name, gener, year, ruta);
               
                
               Boolean exito= c.modificarPelicula(p);
               
               //if(exito){System.out.println("Modificacion exitosa");}
               
                //limpio la entrada de datos
                nombreM.setText("");
               // genero.setText("");
                anioM.setText("");
               
                modificacion.setText("");
                rutaFotoM = "usuarioM.jpg";
                
                //agrego el poster default al panel de entrada
                 photoM= System.getProperty("user.dir") + "/img/" + rutaFotoM;
                redimensionadaM = new ImageIcon(photoM).getImage();
                redimensionadaM = redimensionadaM.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
                fotoUsuarioM = new ImageIcon(redimensionadaM);
                fotoM.setIcon(fotoUsuarioM);
            
                    }else {JOptionPane.showMessageDialog(null, "Primero seleccione un id que exista");}
              

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Dejo un campo vacio o introdujo mal el anio");

            }
    }
    
     public static void main(String[] args) {
        MenuMain c = new MenuMain();
                                           } 
}
