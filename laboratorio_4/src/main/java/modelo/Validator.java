/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Benjamin Parra
 */
public class Validator {
    /**
     * Valida los datos ingresados cumplan las condiciones para registrar un usuario 
     * @param usuario
     * @param socialNetwork
     * @return 
     */
    public ValidationResponse validadorUsuario(String[] usuario,SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        if (!esUsuario(usuario)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: Asegurese de no dejar campos en blanco";
            
        }
        if (socialNetwork.estaRegistrado(usuario[0])) {
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: El usuario "+ usuario[0]+" se encuentra registrado\n";
        }
        if (!usuario[0].matches("[a-zA-Z0-9]*")) {
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: El usuario solo debe contener letras y numeros , ningun otro simbolo esta permitido\n";
            
        } 
        
        if (esUsuario(usuario)) {
            //String[] datosFecha = usuario[2].split("/");
            //Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
            String fechaUser = socialNetwork.fecha;
            Usuario usuario1 = new Usuario(usuario[0],usuario[1],fechaUser);
            if (!usuario1.validaUsuario()&&usuario1.validaPassword()) {
                if (usuario1.getNombreUsuario().equals(usuario1.getPassword())) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña es valida, pero:\n"+ "La contraseña y NombreUsuario no pueden ser iguales\n";
                }if (usuario1.getNombreUsuario().length()<6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña es valida, pero:\n"+ "El Nombre de usuario debe contener al menos 6 caracteres\n";
                }
                if (!usuario1.contieneLetras()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña es valida, pero:\n" + "El nombre de usuario debe contener al menos 4 caracteres alfabeticos";
                    
                }
            } if (usuario1.validaUsuario() && !usuario1.validaPassword()) {
                if (usuario1.getPassword().equals(usuario1.getNombreUsuario())) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: El usuario es valido, pero:\n"+ "La contraseña y NombreUsuario no pueden ser iguales\n";
                }if (usuario1.getPassword().length() < 6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: El usuario es valido, pero:\n"+ "La contraseña debe contener al menos 6 caracteres y al menos 3 numeros\n";
                }if (usuario1.getPassword().contains(" ")) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: El usuario es valido, pero:\n"+ "La contraseña no debe contener espacios\n";
                }if (!usuario1.contieneNumeros()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: El usuario es valido, pero:\n"+ "La contraseña debe contener al menos 3 numeros\n";
                }
            } if (!usuario1.validaUsuario() && !usuario1.validaPassword()) {
                if (usuario1.getNombreUsuario().equals(usuario1.getPassword())) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña y NombreUsuario no pueden ser iguales\n";
                }if (usuario1.getNombreUsuario().length()<6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: El Nombre de usuario debe contener al menos 6 caracteres\n";
                } if (usuario1.getPassword().length() < 6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña debe contener al menos 6 caracteres\n";
                }if (usuario1.getPassword().contains(" ")) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña no debe contener espacios\n";
                }if (!usuario1.contieneNumeros()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: La contraseña debe contener al menos 3 numeros\n";
                }
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    /**
     * Valida los datos ingresados cumplan las condiciones para publicar en el propio peril
     * @param post
     * @param socialNetwork
     * @param fechita
     * @return 
     */
    public ValidationResponse validadorPostSolo(String[] post,SocialNetwork socialNetwork,String fechita){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        if (!esPostSolo(post)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nERROR: Asegurese de ingresar todos los datos para realizar la publicación";
            }else{
            Post postSolo = new Post(socialNetwork.getUserOnline(), fechita, post[0]+"."+post[1],socialNetwork.getIDNewPost());
            if (!postSolo.ValidaContenido()) {
                if (!postSolo.validaTipo()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: Recuerde que los tipo de la publicación son: \".text\", \".video\", \".audio\", \".url\" o \".photo\"";
                }
            }if (postSolo.getContenido().isEmpty()) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: Por favor ingrese contenido a su publicación";
                
            }
{
                
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    /**
     * Valida los datos ingresados cumplan las condiciones para publicar en el perfil de otro usuario
     * @param postAmigosSplit
     * @param socialNetwork
     * @return 
     */
    public ValidationResponse validadorPost(String[] postAmigosSplit,SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        if (!esPostAmigos(postAmigosSplit)) {
            esValido = false;
             mensajeValidacion = mensajeValidacion + "\nERROR: Asegurese de ingresar todos los datos para realizar la publicación";
        }else{
            String[] post2 = postAmigosSplit[0].split("\\.");
            String[] receptores = postAmigosSplit[1].split(",");
            if (esPostReceptor(receptores)&&!esPostSolo(post2)) {
                validationResponse = validadorPostSolo(post2, socialNetwork, socialNetwork.fecha);
                esValido = validadorPostSolo(post2, socialNetwork, socialNetwork.fecha).isEsValido();
            }
            if (!esPostReceptor(receptores)&& esPostSolo(post2)) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: Asegurese de que la lista de destinarios no este vacia";
            }
            if (esPostReceptor(receptores)&& esPostSolo(post2)) {
                if (socialNetwork.getUserOnline().dejaAmigos(receptores).isEmpty()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: Ninguno de los usuarios a quienes le desea escribir un post se encuentra registrado, \n "
                            + " y recuerde que para publicar en su muro existe una opcion dedicada";
                }
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    /**
     * Valida los datos ingresados para realizar post a otros perfiles 
     * @param postAmigosSplit
     * @return 
     */
    public boolean esPostAmigos(String[] postAmigosSplit){
        String[] post2 = postAmigosSplit[0].split("\\.");
        return postAmigosSplit.length == 2 && !postAmigosSplit[0].isEmpty() && !postAmigosSplit[1].isEmpty() && !soloEspacios(post2[0]);
    }
    
    
    /**
     * Valida los datos ingresados para publicar en el propio perfil
     * @param postSplit
     * @return 
     */
    public boolean esPostSolo(String[] postSplit){
        return postSplit.length == 2 && !postSplit[0].isEmpty() && !postSplit[1].isEmpty()&& !soloEspacios(postSplit[0]);
    }
    
    public boolean soloEspacios(String palabra){
        String[] palabraList = palabra.split("");
        Integer contador = 0;
        for (int i = 0; i < palabraList.length; i++) {
            if (palabraList[i].equalsIgnoreCase(" ")) {
                contador = contador + 1;
            }
        }
        return contador==palabraList.length;
        
    }
    
    /**
     * Valida los datos ingresados para compartir en otros perfiles
     * @param postSplit
     * @return 
     */
    public boolean esPostShare(String[] postSplit){
        return postSplit.length == 2 && !postSplit[0].isEmpty() && !postSplit[1].isEmpty();
    }
    
    /**
     * Valida los datos ingresados no sean nulos
     * @param receptores
     * @return 
     */
    public boolean esPostReceptor(String[] receptores){
        //return strSplit.length == 2 && !strSplit[0].isEmpty() && !strSplit[1].isEmpty() && !esNumero(strSplit[0]) && !esNumero(strSplit[1]);
        return receptores.length > 0; 
    }
    
    /**
     * Valida los datos ingresados cumplan las condiciones para compartir en el propio perfil
     * @param id
     * @param socialNetwork
     * @return 
     */
    public ValidationResponse validadorShareSolo(String id, SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        Integer idInt = Integer.parseInt(id);
        if (!isNumeric(id)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nERROR: Por favor solo ingrese números";
            
        }else{
            if (socialNetwork.getPublicaciones().size()<idInt || idInt <= 0) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nERROR: La publicacion con ID "+id+" no existe";
            
        }
        if (socialNetwork.getPublicaciones().isEmpty()) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nERROR: No existen publicaciones para compartir";
            
        }
        }
        
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
        
    }
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (java.lang.NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    /**
     * Valida los datos ingresados cumplan las condiciones para compartir en otros perfiles
     * @param postShare
     * @param socialNetwork
     * @return 
     */
    public ValidationResponse validadorShareAmigos(String[] postShare, SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        if (!esPostShare(postShare)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nERROR: Asegurese de ingresar los datos con el siguiente formato: >>Id/user1,user2,user3...";
        }else{
            Integer idInt = Integer.parseInt(postShare[0]);
            if (postShare[0].isEmpty() && !postShare[1].isEmpty()) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: Ingrese un Id por favor";
            }
            if (!postShare[0].isEmpty() && postShare[1].isEmpty()) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: Ingrese al menos un destinario y recuerde que existe una opcion para compartir una publicacion en su perfil";
            }

            if (socialNetwork.getPublicaciones().size()<idInt) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: La publicacion con ID "+postShare[0]+" no existe";

            }

            if (!postShare[0].isEmpty() && !postShare[1].isEmpty()) {
                String[] receptores = postShare[1].split(",");
                if (socialNetwork.getUserOnline().eliminaRepetidos(receptores).isEmpty()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: Ninguno de los usuarios a quienes le desea compartir un post se encuentra registrado en la red social o\n"
                            + "se encuentra en su lista de amigos y recuerde que para publicar en su muro existe una opcion dedicada";
                }
            }
       
            
        }
        
        
        
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    /**
     * Valida los datos ingresados cumplan las condiciones para ingresar al perfil
     * @param usuario
     * @param socialNetwork
     * @return 
     */
    public ValidationResponse validadorLogin(String[] usuario,SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        String mensajeValidacion = "";
        boolean esValido = true;
        if (!esLogin(usuario)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: Asegurese no dejar ninguno de los 2 campos en blanco.\n";
        }else{
            if (!socialNetwork.validaLogin(usuario[0], usuario[1])) {
                esValido = false;
                mensajeValidacion = mensajeValidacion +socialNetwork.errorLogin(usuario[0], usuario[1]);
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
//    
    /**
     * Valida los datos ingresados cumplan las condiciones para poder seguir a un usuario
     * @param usuario
     * @param socialNetwork
     * @return 
     */
    public ValidationResponse validadorSeguir(String usuario, SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        String mensajeValidacion = "";
        boolean esValido = true;
        if (esNumero(usuario)||usuario.isEmpty()) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nERROR: Asegurese de ingresar el nombre de un usuario";
        }else{
            if (usuario.length()<6) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: Recuerde que todo usuario debe contener al menos 6 caracteres";
            }
            if (!socialNetwork.estaRegistrado(usuario)) {
                esValido = false;
                mensajeValidacion = mensajeValidacion + "\nERROR: El usuario no se encuentra registrado";
            }
            if (socialNetwork.estaRegistrado(usuario)) {
                if (socialNetwork.getUserOnline().getAmigos().contains(socialNetwork.getUsuarioConNombre(usuario))) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: El usuario:"+usuario+" ya se encuentra en la lista de amigos de "+socialNetwork.getUserOnline().getNombreUsuario();
                }
                if (socialNetwork.getUserOnline().getNombreUsuario().equals(usuario)) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\nERROR: No puede seguirse así mismo";
                }
                
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
//    
    /**
     * Valida los datos ingresados cumplan las condiciones para las opciones
     * @param opcion
     * @return 
     */
    public ValidationResponse validadorOpciones(String opcion){
        ValidationResponse validationResponse = new ValidationResponse();
        String mensajeValidacion = "";
        boolean esValido = true;
        if (!esNumero(opcion)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nPor favor solo ingrese números\n";
            
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
        
    }
   
    /**
     * Valida los datos ingresados para validar usuario
     * @param strSplit
     * @return 
     */
    public boolean esUsuario(String[] strSplit){
        //String[] fecha = strSplit[2].split("/");
        return strSplit.length==2 /*&& esFecha(fecha)*/ && !(strSplit[0]).isEmpty() && !strSplit[1].isEmpty();
        
    }
    /**
     * //Metodo que verifica si el elemento es un numero
     * @param str
     * @return 
     */
    public boolean esNumero(String str) {
        try {
            Double.parseDouble(str);  
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
//    
    
//    
   
    /**
     * Valida los datos ingresados para ingresar al perfil
     * @param strSplit
     * @return 
     */
    public boolean esLogin(String[] strSplit){
        return strSplit.length == 2 && !strSplit[0].isEmpty() && !strSplit[1].isEmpty();
    }
    
}
