public class roles {
    private int id;
    private String nombre;

    //constructor
    public roles(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    //base de getters y setters

    public int getId(){return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
