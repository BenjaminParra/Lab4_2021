/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Parra
 */
public class SocialNetwork {
    String nombreSocialNetwork; //nombre de la red social
    String fecha; // fecha actual
    ArrayList<Usuario> usuarios = new ArrayList(); //lista de usuarios registrados
    ArrayList<Post> publicaciones = new ArrayList(); //lista de publicaciones realizadas por usuarios
    //ArrayList<Reaccion> reacciones = new ArrayList(); -> no se implementa
    public SocialNetwork(String nombreSocialNetwork, String fecha) {
        this.nombreSocialNetwork = nombreSocialNetwork;
        this.fecha = fecha;
    }

    public String getNombreSocialNetwork() {
        return nombreSocialNetwork;
    }

    public ArrayList<Post> getPublicaciones() {
        return publicaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    /**
     * Se encarga de concatenar las "traducciones" de las publicaciones
     * a string en un solo String
     * @return String representativo de las publicaciones
     */
    public String traducePosts(){
        String aux = ""; //string vacio al que se concatenará
        /*se recorre la lista de publicaciones
        */
        if (publicaciones.isEmpty()) {
            aux = aux + "Nadie aun ha realizado alguna publicacion";
            return aux;
        }
        for (int i = 0; i < publicaciones.size(); i++) {
            //se concatena la traduccion de una publicacion
            aux = aux + "\n" + publicaciones.get(i).toString();
        }
        return aux;
    }
    
    /**
     * Se encarga de concatenar las "traducciones" de los usuarios
     * a un solo string
     * @param userList
     * @return String representativo de los usuarios
     */
    public String usuariosToString(ArrayList<Usuario> userList){
        String outPut = ""; //string vacio al que se concatenará
        for (int i = 0; i < userList.size(); i++) {
            //si solo existe un usuario se concatena
            if (i==0) {
                outPut = outPut + userList.get(i).toString();
                i= i + 1;
                
            }
            /* Si existe más de un usuario registrado se creará una separacion 
            entre usuarios*/
            outPut = outPut +"\n"+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    + ""+"\n"+ userList.get(i).toString();
            
            
            
        }
        return outPut;
    }
    /**
     * Se utiliza para mostrar las publicaciones disponibles
     * antes de compartir una publicaciones
     * en caso de que no existan publicaciones se muestra un mensaje indicandolo
     * @return String informativo para el usuario 
     */
    public  String muestraPost(){
        String retorno = "";
        /*se verifica si la lista de publicaciones esta vacia
        */
        if (publicaciones.isEmpty()) { 
            retorno = retorno + "No existen publicaciones para compartir";
            return retorno;
        }
        /* se recorre la lista de publicaciones
        */
        for (int i = 0; i < publicaciones.size(); i++) {
            /* Si solo existe una publicacion se muestra un unico mensaje
            */
            if (publicaciones.size()==1) {
                retorno = retorno +"Esta es la publicacion disponibles \n"+ (i+1) +") "+ publicaciones.get(i).toString();
                return retorno;
            }else{ 
                /* si es la pimera publicaciones se muestra un mensaje determinado
                */
                if (i == 0) {
                    retorno = retorno +"Estos son las publicaciones disponibles \n"+ (i+1) +") "+ publicaciones.get(i).toString();
                    i = i + 1;
                }
                //se concatena la traduccion de una publicacion
                retorno = retorno + "\n" + (i+1) +") "+ publicaciones.get(i).toString();
            }
            
        }
        
        return retorno;
    }
    
   
    
    /**
     * Retorna un mensaje informativo al usuario luego de realizar una publicacion a otros usuarios
     * indica a quienes realizo la publicacion e
     * indica que usuarios no pertenecen a la lista de amigos o pertenecen al socialnetwork
     * @param usuarios //usuarios destinatarios 
     * @return String informativo luego realizar publicacion a otros usuarios
     */
    public String mensajePostAmigos(String[] usuarios){
        String retorno = "";
        /*
        Si no existen usuario que no sean amigos y 
        */
        if (getUserOnline().getUnfriends(usuarios).equals("Los siguientes usuarios no encuentran en la lista de usuarios ") && !getUserOnline().dejaAmigos(usuarios).isEmpty()) {
            retorno = retorno + "El usuario "+ getUserOnline().getNombreUsuario()+" realizo una publlicacion dirigida a "+ getUserOnline().eliminaRepetidos(usuarios);
            return retorno;
            //System.out.println("El usuario "+socialNetwork.getUserOnline().getNombreUsuario()+" publico dirigido a "+ socialNetwork.getUserOnline().eliminaRepetidos(receptores)+"\n");
            //System.out.println("Los siguientes usuarios no se encuentran registrados en la red social o no pertenecen a la lista de amigos "+socialNetwork.getUserOnline().getUnfriends(receptores));
        /* Si existe usuarios que no sean amigos del usuario online y publica en otro perfil
            */   
        }if (!getUserOnline().getUnfriends(usuarios).equals("Los siguientes usuarios no encuentran en la lista de usuarios ") && !getUserOnline().dejaAmigos(usuarios).isEmpty()) {
            retorno = retorno + "El usuario "+ getUserOnline().getNombreUsuario()+" realizo una publlicacion dirigida a "+ getUserOnline().eliminaRepetidos(usuarios)+"\n"+
                "pero los siguientes usuarios no se encuentran registrados en la red social o no pertenecen a la lista de amigos "+ getUserOnline().getUnfriends(usuarios);
        return retorno;
        }
        return  retorno;
        }
    
    /**
     * Retorna un mensaje informativo al usuario luego de compartir una publicacion a otros usuarios
     * indica a quienes se les compartio la publicacion e
     * indica que usuarios no pertenecen a la lista de amigos o pertenecen al socialnetwork
     * @param usuarios //usuarios destinatarios
     * @return String informativo luego compartir la publicacion a otros usuarios
     */
     public String mensajeShareAmigos(String[] usuarios){
        String retorno = "";
        if (getUserOnline().getUnfriends(usuarios).equals("Los siguientes usuarios no encuentran en la lista de usuarios ") && !getUserOnline().dejaAmigos(usuarios).isEmpty()) {
            retorno = retorno + "El usuario "+ getUserOnline().getNombreUsuario()+" compartio una publlicacion dirigida a "+ getUserOnline().eliminaRepetidos(usuarios);
            return retorno;
            //System.out.println("El usuario "+socialNetwork.getUserOnline().getNombreUsuario()+" publico dirigido a "+ socialNetwork.getUserOnline().eliminaRepetidos(receptores)+"\n");
            //System.out.println("Los siguientes usuarios no se encuentran registrados en la red social o no pertenecen a la lista de amigos "+socialNetwork.getUserOnline().getUnfriends(receptores));
        }if (!getUserOnline().getUnfriends(usuarios).equals("Los siguientes usuarios no encuentran en la lista de usuarios ") && !getUserOnline().dejaAmigos(usuarios).isEmpty()) {
            retorno = retorno + "El usuario "+ getUserOnline().getNombreUsuario()+" compartio una publlicacion dirigida a "+ getUserOnline().eliminaRepetidos(usuarios)+"\n"+
                "pero los siguientes usuarios no se encuentran registrados en la red social o no pertenecen a la lista de amigos "+getUserOnline().getUnfriends(usuarios);
        return retorno;
        }
        return  retorno;
        }
            
        
        
        
    /**
     * Convierte la resSocial en un string entendible para el usuario
     * En caso de que exista un usuario en linea se moestrará el perfil del usuario
     * En caso de que no exista un usuario en linea se mostrará todos los perfiles registrados
     * @return String representativo de la redsocial
     */

    @Override
    public String toString() {
        if (existeUserOnline()) {
            return  nombreSocialNetwork + "   " + fecha + "\n"+
                    "Perfil del usuario online "+getUserOnline().nombreUsuario + "\n"+
                    getUserOnline().toString();
            
        }
        return nombreSocialNetwork+"    "+fecha+"\n"+
                usuariosToString(usuarios)+"\n"+
                "______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________"+"\n"+
                traducePosts();
        //return "SocialNetwork{" + "nombreSocialNetwork=" + nombreSocialNetwork + ", fecha=" + fecha + ", usuarios=" + usuariosToString(usuarios) + ", publicaciones=" + /*traducePosts()*/publicaciones + '}';
        
        
    }
    
   /**
    * Entrega un verdadero en caso de que el nombre de usuario se encuentre registrado
    * falso en caso contrario
    * @param nombreUsuario // nombre del usuario a chequear
    * @return 
    */
    public boolean estaRegistrado(String nombreUsuario){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Entrega un verdadero en caso de que se encuentre un usuario
     * que haga coincidencia con la contraseña y nombre de usuario
     * entrega falso en caso de que no exista ninguna coincidencia
     * @param user //usuario
     * @param password //contraseña
     * @return 
     */
    //metodo que valida el login de un usuario dado un nombre y contraseña
    public boolean validaLogin(String user, String password){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(user) && usuarios.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Realiza la el login
     * @param nombreUsuario 
     */
    public void login(String nombreUsuario){
        Usuario user = getUsuarioConNombre(nombreUsuario);
        user.setEstado(true);
        actualizaUsuario(user);
        
    }
    /**
     * Entrega un mensaje informativo respecto a un error al momento
     * de iniciar sesion
     * @param user //
     * @param password//
     * @return 
     */
    public String errorLogin(String user, String password){
        String mensaje = "";
        if (estaRegistrado(user)) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombreUsuario().equals(user) && !usuarios.get(i).getPassword().equals(password)) {
                    mensaje = mensaje + "El usuario se encuentra registrado, pero la contraseña no es valida";
                }
            }
            
        }else{
            mensaje = mensaje + "El usuario no se encuentra registrado";
        }
        return mensaje;
    }
    
    /**
     * Registra un usuario a una red social siempre y cuando no este registrado
     * @param datosUsuario //Nombre y contraseña del usuario en una lista
     * @param fechaFormateada //Fecha del sistema
     */
    public void registerUser(String[] datosUsuario, String fechaFormateada){
        Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaFormateada);
        if (!estaRegistrado(usuario.getNombreUsuario())) {
            usuarios.add(usuario);
        }
    }
    
    /**
     * Retorna un objeto usuario solo ingresando el nombre de este ultimo
     * @param user //nombre del usuario a buscar
     * @return objeto usuario
     */
    public Usuario getUsuarioConNombre(String user){
        if (estaRegistrado(user)) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombreUsuario().equals(user)) {
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }
    
    /**
     * Actualiza a un usuario 
     * @param usuario //objeto usuario
     */
    public void actualizaUsuario(Usuario usuario){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())) {
                usuarios.set(i, usuario);
            }
        }
    }
    
    
    /**
     * Obtiene el usuario online dentro de una redsocial
     * @return usuario con sesion iniciada
     */
    public Usuario getUserOnline(){
        if (existeUserOnline()) {
            for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).isEstado()) {
                return usuarios.get(i);
            }
            }
        }
        
        return usuarios.get(0);
    }
    
    /**
     * Verifica la existencia de una usuario online
     * @return //boolean
     * true en caso de que exista
     * false en caso contrario
     */
    public boolean existeUserOnline(){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).isEstado()) {
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
        return publicaciones.size()+1;
    }
    /**
     * Cambia el estado del usuario a offline
     */
    public void turnOffUser(){
        
        getUserOnline().setEstado(false);
    }
    
    public ArrayList<String> getSeguidores(Usuario user){
        ArrayList<String> seguidores = new ArrayList();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getListaAmigosString(usuarios.get(i).getAmigos()).contains(user.nombreUsuario)) {
                seguidores.add(usuarios.get(i).nombreUsuario);
            }
        }
        return seguidores;
    }
    
    public String seguidoresString(Usuario user){
        String salida = "";
        if (getSeguidores(user).size()==1) {
            salida = getSeguidores(user).get(0);
        }else{
            for (int i = 0; i < getSeguidores(user).size(); i++) {
                if (i==0) {
                    salida = getSeguidores(user).get(i);
                }else{
                    salida = salida + ","+getSeguidores(user).get(i);
                }
            }
        }
        return salida;
        
    }
    
    public ArrayList<Usuario> usuariosRegistrados(String nombreString){
        ArrayList<Usuario> usuariosStrings = new ArrayList();
        for (int i = 0; i < usuarios.size(); i++) {
            if (!nombreString.equals(usuarios.get(i).getNombreUsuario())) {
                usuariosStrings.add(usuarios.get(i));
            }
            
        }
        return usuariosStrings;
    }
    
    
    public String getListaUserString(ArrayList<Usuario> users){
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
    
    
    public void ayudaInput(){
        System.out.println("Formatos de entrada.");
        System.out.println("1. Registrar un usuario\n A) El nombre del usuario debe contener 6 caracteres (minimo 4 de ellos deben ser letras) y solo caracteres alfanumericos \n B) La contrasena debe tener un largo de 6 caracteres, debe contener al menos 3 numeros y no puede contener espacios \n C) La contrasena no puede ser igual que el nombre de usuario\n");
        System.out.println("2. Seguir a un usuario registrado \n A) Asegurese de solo escribir el nombre del usuario\n");
        System.out.println("3. Realizar una publicacion \n A) Los tipos de publicacion son text, video, audio, url y photo \n");
        System.out.println("4. Salir de una opcion seleccionada \n A) Para salir de una opcion que le pida ingresar texto, usted puede escribir salir y volvera atras\n");
        System.out.println("5. Visualizar redSocial \n A) Con esta opcion podra ver que usuarios se encuentra registrados\n");
        
    }
}
