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
public class Post {
    Integer ID; //id de referencia de la publicacion
    Usuario user; //usuario creador de la publicacion
    String fechaDePublicacion; //fecha de creacion de la publicacion
    String contenido; //contenido de la publicacion, puede ser una publicacion completa (cuando se realiza un share)
    ArrayList<Usuario> receptores = new ArrayList();// destinatarios
    
     /**
     * Crea una publicacion sin destinarios
     * @param user usuario creador de la publicacion
     * @param fechaDePublicacion fecha de creacion de la publicacion
     * @param contenido contenido de la publicacion, puede ser una publicacion completa (cuando se realiza un share)
     * @param ID id de referencia de la publicacion
     */
    public Post(Usuario user, String fechaDePublicacion, String contenido,Integer ID){
        this.ID = ID;
        this.user = user;
        this.fechaDePublicacion = fechaDePublicacion;
        this.contenido = contenido;
        
        
    }
    /**
     * Crea una publicacion con destinatarios
     * @param user usuario creador de la publicacion
     * @param fechaDePublicacion fecha de creacion de la publicacion
     * @param contenido contenido de la publicacion, puede ser una publicacion completa (cuando se realiza un share)
     * @param receptor  destinatario
     * @param ID id de referencia de la publicacion
     */
    public Post(Usuario user, String fechaDePublicacion, String contenido,Usuario receptor,Integer ID){
        this.ID = ID;
        this.user = user;
        this.fechaDePublicacion = fechaDePublicacion;
        this.contenido = contenido;
        receptores.add(receptor);
        
    }

    public Integer getID() {
        return ID;
    }

    public Usuario getUser() {
        return user;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public ArrayList<Usuario> getReceptores() {
        return receptores;
    }
    
    public Usuario getReceptor(ArrayList<Usuario> entrada){
        return entrada.get(0);
    }

    
    
    
    public String getContenido() {
        return contenido;
    }


    
    /**
     * Valida que el tipo de la publicacion sea los estipulados
     * @return Verdadero en caso de que sea valido y false en caso contrario
     */
    public boolean validaTipo(){
        return (contenido.contains(".text"))|| (contenido.contains(".video"))||(contenido.contains(".audio"))||(contenido.contains(".url"))||(contenido.contains(".photo"));
    }
    
    /**
     * Valida que el contenido no sea nulo y que el tipo de la publicacion sea valido
     * @return Verdadero en caso de que sea valido y no vacio y false en caso contrario
     */
    public boolean ValidaContenido(){
        return !contenido.isEmpty() && validaTipo(); /*&& !contenido.split("\\.")[1].contains(" ");*/
    }
    
    /**
     * 
     * @param conStrings une la publicacion [contenido, .tipo]
     * @return Un string con la publicacion unida contenido.tipo     */
    public String contenidoPostString(String[] conStrings){
        return conStrings[0]+"."+conStrings[1];
    }
    
   

    /**
     * Convierte la publicacion en un string entendible para el usuario
     * @return  String representativo de la publicacion
     */
    @Override
    public String toString() {
        if (receptores.isEmpty()) {
            if (contenido.contains("El usuario ")) {
                return "El usuario "+user.nombreUsuario +" ha compartido la publicacion <<"+contenido+">> con el ID-"+ID +" el dia "+fechaDePublicacion;
                
            }
            return "El usuario "+user.nombreUsuario +" ha realizado la publicacion >>"+contenido+"<< con el ID-"+ID +" el dia "+fechaDePublicacion;
        }else{
            if (contenido.contains("El usuario ")) {
                return "El usuario "+user.nombreUsuario +" ha compartido la publicacion <<"+contenido+">> con el ID-"+ID +" en el muro de "+receptores.get(0).nombreUsuario+" el dia "+fechaDePublicacion;
                
            }
            return "El usuario "+user.nombreUsuario +" ha realizado la publicacion >>"+contenido+"<< con el ID-"+ID +" en el muro de "+receptores.get(0).nombreUsuario+" el dia "+fechaDePublicacion;
            //return "Post{" + "ID=" + ID + ", user=" + user.nombreUsuario + ", fechaDePublicacion=" + fechaDePublicacion + ", contenido=" + contenido + ", receptor=" + receptor + '}';
        }
        
    }
    
}
