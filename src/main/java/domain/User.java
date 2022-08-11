package domain;

public class User {
    
    
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String password;
    private boolean valid = true;
    
    
    public User () {
        
    }
    
    public User (int id) {
        this.id = id;
    }
    
    public User (String nombre, String apellido, String email, String genero, String password) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.genero = genero;
        this.password = password;
    }
    
    public User (int id, String apellido, String nombre, String email, String genero, String password) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.genero = genero;
        this.password = password;
    }
    
        public User (String email, String password) {
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
}
