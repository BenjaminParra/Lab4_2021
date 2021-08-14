/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Benjamin Parra
 */
public class Usuario {
    String nombreUsuario;
    String password;
    String fechaDeCreacion; //Definir clase Fecha
    ArrayList<Usuario> amigos = new ArrayList();
    boolean estado = false; // false == offline
    ArrayList<Post> posts = new ArrayList();
    
    /**
     * crea usuario en base a:
     * @param nombreUsuario //nombre usuario 
     * @param password //contraseña
     * @param fechaDeCreacion  //fecha de creacion
     */
    public Usuario(String nombreUsuario, String password, String fechaDeCreacion) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.fechaDeCreacion = fechaDeCreacion;
    }
    
    //se crea un validator para usar sus metodos
    static Validator validator = new Validator();
    
    public ArrayList<Post> getPosts() {
        return posts;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     * Retorna un true en caso de que el nombre de usuario sea distinto a la contraseña y 
     * que el nombre sea mayor a 6
     * @return 
     */
    public boolean validaUsuario() {
        return !nombreUsuario.equals(password) && nombreUsuario.length() >= 6 && nombreUsuario.matches("[a-zA-Z0-9]*") && contieneLetras(); //&& validaPassword() && fechaDeCreacion.esValida();
    }
    
    /**
     * Retorna un string que concatena la traduccion de distintas publicaciones
     * @return String representativo de las publicaciones del usuario
     */
    public String traducePosts(){
        String aux = "";
        if (posts.size() == 1) {
            aux = aux + "<<"+posts.get(0)+">>";
            return  aux;
            
        }
        for (int i = 0; i < posts.size(); i++) {
            aux = aux + ">>"+posts.get(i).toString()+"<<\n";
        }
        
        return aux;
    }

    /**
     * Verifica que una contraseña contenga o no cierto elemento
     * en caso de que la contraseña contenga cierto elemento retorna un true
     * en caso contraio un false
     * @param Elemento //cualquier string
     * @return boolean
     */
    public boolean contieneElemento(String Elemento){
        String[] palabra = password.split("");
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].equals(Elemento)) {
                
                return true;
            }
        }
        return false;
    }
    //Metodo que verifica que la contraseña tenga al menos 3 numeros
    /**
     * Verifica que una contraseña contenga al menos 3 numeros
     * true en caso de que contenga al menos los 3 
     * false en caso contrario
     * @return boolean
     */
    public boolean contieneNumeros() {
        int contador = 0;
        String[] passwordList = password.split("");
        for (int i = 0; i < passwordList.length; i++) {
           if (validator.esNumero(passwordList[i])) {
               contador = contador + 1;
           }
       }
       return contador > 2;
   }
    
    public boolean  contieneLetras(){
        int contador = 0;
        String[] nombreList = nombreUsuario.split("");
        for (int i = 0; i < nombreList.length; i++) {
            if (!validator.esNumero(nombreList[i])) {
                contador = contador + 1;
            }
        }
        return contador>=4;
    }
    
    /**
     * Valida que una contraseña tenga un largo mayor o igual a 6, que no contenga espacios
     * y al menos 3 numeros
     * @return boolean
     */
    public boolean validaPassword() {
        return password.length() >= 6 && !password.contains(" ") && contieneNumeros();
    }
    
    
    /**
     * Valida que un usuario se encuentre registrado en la lista 
     * de amigos del usuario
     * True en caso de que sea amigo
     * false en caso contrario
     * @param usuario2 //string del nombre del usuario
     * @return boolean
     */
    public boolean esAmigo(String usuario2){
        for (int i = 0; i < amigos.size(); i++) {
            if (amigos.get(i).getNombreUsuario().equals(usuario2)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Entrega el nuevo ID para la publicacion
     * calculando el largo de la lista de publicaciones
     * @return nuevo ID
     */
    public Integer getIDNewPost(){
        return posts.size()+1;
    }
    
   
    
    /**
     * Entrega una lista de string de los nombres de los usuarios
     * @param users//lista de obejtos usuarios
     * @return  lista de los nombres de los usuarios
     */
    public String getListaAmigosString(ArrayList<Usuario> users){
        String salida = "";
        for (int i = 0; i < users.size(); i++) {
            if (i == 0) {
                salida = salida + users.get(i).getNombreUsuario();
            }else{
                salida = salida + "," + users.get(i).getNombreUsuario();
            }
            
            
        }
        return salida;
    }

    @Override
    public String toString() {
        //agrega if para ver si tiene amigos o publicaciones
        //return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", fechaDeCreacion=" + fechaDeCreacion + ", amigos=" + amigos + ", estado=" + estado + ", posts=" +posts/*+ ", posts=" + traducePosts()*/ + '}';
        if (!amigos.isEmpty() && !posts.isEmpty()) {
            return "El usuario " + nombreUsuario +  " registrado el " + fechaDeCreacion + ".\n"+
                    "Sus amigos son " + getListaAmigosString(amigos) + ".\n Se encuentra " + traduceEstado(estado) + 
                    " \ny sus publicaciones son " +traducePosts();
        }
        else if (amigos.isEmpty() && !posts.isEmpty()) {
            return "El usuario " + nombreUsuario +  " registrado el " + fechaDeCreacion + ".\n"+
                    "No tiene amigos registrados, se encuentra " + traduceEstado(estado) + 
                    "\n y sus publicaciones son " +traducePosts();
        }
        else if (!amigos.isEmpty() && posts.isEmpty()) {
            return "El usuario " + nombreUsuario +  " registrado el " + fechaDeCreacion + ".\n"+
                    "Sus amigos son " + getListaAmigosString(amigos) + ".\n Se encuentra " + traduceEstado(estado) + 
                    " y aun no tiene publicaciones en su perfil ";
            
        }
        return "El usuario " + nombreUsuario +  " registrado el " + fechaDeCreacion + ".\n"+
                    "No tiene amigos registrados, se encuentra " + traduceEstado(estado) + 
                " y aun no tiene publicaciones en su perfil ";
       
    }
    
    /**
     * Traduce el estado true -> online
     * false -> offline
     * @param estadoBoolean
     * @return 
     */
    public String traduceEstado(Boolean estadoBoolean){
        if (estadoBoolean) {
            return "online";
        }
        return "offline";
    }
    
    /**
     * Retorna un string indicando cuales son los usuarios que no son amigos
     * del usuario que realiza la publicacion
     * @param usuarios //a quienes el usuario indica que quiere realizar la publicacion
     * @return string 
     */
    public String getUnfriends(String[] usuarios){
        String aux = "Los siguientes usuarios no encuentran en la lista de usuarios ";    
        for (int i = 0; i < usuarios.length; i++) {
            if (!esAmigo(usuarios[i])) {
                aux = aux + usuarios[i]+" ,";
                
            }
            
        }
        
        return aux;
    }
    /**
     * Entrega una lista de string de los usuarios a quienes le 
     * publicara, se eliminan los repetidos
     * @param usuarios //a quienes el usuario indica que quiere realizar la publicacion
     * @return 
     */
    public ArrayList<String> eliminaRepetidos(String[] usuarios){
        ArrayList<String> amigosReturn = dejaAmigos(usuarios);
        Set<String> set = new HashSet<>(amigosReturn);
        amigosReturn.clear();
        amigosReturn.addAll(set);
        
        return amigosReturn;
        
    }
    
    /**
     * Dada una lista de string, retorna una lista de string 
     * con los nombres de los usuarios que son amigos del usuario que realiza
     * la publicacion
     * @param usuarios //a quienes el usuario indica que quiere realizar la publicacion
     * @return 
     */
    public ArrayList<String> dejaAmigos(String[] usuarios){
          ArrayList<String> amigosReturn = new ArrayList();
          for (int i = 0; i < usuarios.length; i++) {
              if (esAmigo(usuarios[i])) {
                  amigosReturn.add(usuarios[i]);
              }
          }
          return amigosReturn;
     }
    
    /**
     * Agrega un usuario dado en nombre, se busca el objeto que tenga ese nombre
     *  en la red social y se agrega al usuario online
     * @param newUsuario //usuario a seguir
     * @param socialNetwork  // red social
     */
    public void follow(String newUsuario, SocialNetwork socialNetwork){
        Usuario usuarioASeguir = socialNetwork.getUsuarioConNombre(newUsuario);
        amigos.add(usuarioASeguir);
    }
    
    /**
     * Realiza una publicacion en el perfil propio
     * @param contenido // contenido.text
     * @param socialNetwork // red social
     */
    public void post(String contenido, SocialNetwork socialNetwork){
        Post newPost = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,getIDNewPost());
        Post newPostSocial = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getIDNewPost());
        socialNetwork.getUserOnline().getPosts().add(newPost);
        socialNetwork.getPublicaciones().add(newPostSocial);
        
    }
    
    /**
     * Realiza una publicacion en el perfil de otros usuarios
     * La publicacion queda registrada en el usuario online, en el receptor y la red social
     * @param contenido //contenigo.tipo
     * @param usuarios // lista de nombres de usuarios
     * @param socialNetwork // red social
     */
     public void post(String contenido , String[] usuarios, SocialNetwork socialNetwork){
        ArrayList<Post> listaPostUser = new ArrayList();
        ArrayList<Post> listaPostSocial = new ArrayList();
        
        for (int i = 0; i < eliminaRepetidos(usuarios).size(); i++) {
            //Post(Usuario user, String fechaDePublicacion, String contenido,Usuario Receptor,Integer ID)
            Post newPostUser = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)),getIDNewPost());
            Post newPostReceptor = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)),socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)).getIDNewPost());
            Post newPostSocial = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)),socialNetwork.getIDNewPost());
            //Post newPostUser = new Post(socialNetwork.getUserOnline(),contenido,dejaAmigos(usuarios).get(i),getIDNewPost());
            //Post newPostSocial = new Post(socialNetwork.getUserOnline(),contenido,dejaAmigos(usuarios).get(i),socialNetwork.getIDNewPost());
            listaPostUser.add(newPostUser);
            listaPostSocial.add(newPostSocial);
            socialNetwork.getUserOnline().getPosts().add(listaPostUser.get(i));
            socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)).posts.add(newPostReceptor);
            socialNetwork.getPublicaciones().add(listaPostSocial.get(i));
      
        }
        
        
    }
    
    /**
     * Comparte una publicacion en el propio perfil
     * @param id //numero de la publicacion
     * @param socialNetwork // red social
     */
    public void share(String id, SocialNetwork socialNetwork){
        String contenido = "";
        Integer idInt = Integer.parseInt(id);
        contenido = socialNetwork.getPublicaciones().get(idInt - 1).toString();
        Post newPost = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,getIDNewPost());
        Post newPostSocial = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getIDNewPost());
        socialNetwork.getUserOnline().getPosts().add(newPost);
        socialNetwork.getPublicaciones().add(newPostSocial);
    }
    /**
     * Comparte una publicacion en los perfiles de los usuarios
     * @param id //numero de la publicacio
     * @param usuarios //lista de los nombres de usuarios
     * @param socialNetwork  //red social
     */
    public void share(String id,String[] usuarios, SocialNetwork socialNetwork){
        ArrayList<Post> listaPostUser = new ArrayList();
        ArrayList<Post> listaPostSocial = new ArrayList();
        String contenido = "";
        Integer idInt = Integer.parseInt(id);
        contenido = socialNetwork.getPublicaciones().get(idInt-1).toString();
        for (int i = 0; i < eliminaRepetidos(usuarios).size(); i++) {
            Post newPostUser = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)),getIDNewPost());
            Post newPostReceptor = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)),socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)).getIDNewPost());
            Post newPostSocial = new Post(socialNetwork.getUserOnline(),socialNetwork.fecha,contenido,socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)),socialNetwork.getIDNewPost());
            listaPostUser.add(newPostUser);
            listaPostSocial.add(newPostSocial);
            socialNetwork.getUserOnline().getPosts().add(listaPostUser.get(i));
            socialNetwork.getUsuarioConNombre(eliminaRepetidos(usuarios).get(i)).posts.add(newPostReceptor);
            socialNetwork.getPublicaciones().add(listaPostSocial.get(i));
            
        }
    }

    
}
