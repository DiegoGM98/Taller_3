import java.util.ArrayList;
import java.util.List;

class Tienda {
    private String direccion;
    private List<DispositivoTecnologico> catalogo;
    private List<Cliente> clientes;

    public Tienda(String direccion) {
        this.direccion = direccion;
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public boolean agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean agregarDispositivo(DispositivoTecnologico dispositivo) {
        catalogo.add(dispositivo);
        return true;
    }

    public List<DispositivoTecnologico> buscarDispositivosPorMarca(String marca) {
        List<DispositivoTecnologico> dispositivosEncontrados = new ArrayList<>();
        for (DispositivoTecnologico dispositivo : catalogo) {
            if (dispositivo.getMarca().equalsIgnoreCase(marca)) {
                dispositivosEncontrados.add(dispositivo);
            }
        }
        return dispositivosEncontrados;
    }

    public List<DispositivoTecnologico> buscarDispositivosPorModeloYTipo(String modelo, String tipo) {
        List<DispositivoTecnologico> dispositivosEncontrados = new ArrayList<>();
        for (DispositivoTecnologico dispositivo : catalogo) {
            if (dispositivo.getModelo().equalsIgnoreCase(modelo) && dispositivo.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                dispositivosEncontrados.add(dispositivo);
            }
        }
        return dispositivosEncontrados;
    }
}

class Cliente {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String numeroContacto;
    private String estadoCivil;
    private String ciudad;

    public Cliente(String nombre, String apellido, String correoElectronico, String numeroContacto, String estadoCivil, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.numeroContacto = numeroContacto;
        this.estadoCivil = estadoCivil;
        this.ciudad = ciudad;
    }

    // Getters y setters
}

class DispositivoTecnologico {
    private String marca;
    private String memoriaRAM;
    private String memoriaAlmacenamiento;
    private String procesador;
    private String modelo;
    private int anioFabricacion;
    private float precio;
    private int cantidadStock;

    public DispositivoTecnologico(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioFabricacion, float precio, int cantidadStock) {
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.memoriaAlmacenamiento = memoriaAlmacenamiento;
        this.procesador = procesador;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return null;
    }

    // Getters y setters
}

class ComputadoraEscritorio extends DispositivoTecnologico {
    private String tarjetaVideo;
    private String fuentePoder;
    private String chasis;
    private Pantalla pantalla;

    public ComputadoraEscritorio(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioFabricacion, float precio, int cantidadStock,
                                 String tarjetaVideo, String fuentePoder, String chasis, Pantalla pantalla) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioFabricacion, precio, cantidadStock);
        this.tarjetaVideo = tarjetaVideo;
        this.fuentePoder = fuentePoder;
        this.chasis = chasis;
        this.pantalla = pantalla;
    }

    // Getters y setters
}

class Notebook extends DispositivoTecnologico {
    private String resolucionPantalla;
    private String tipoTeclado;
    private int bateria;

    public Notebook(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioFabricacion, float precio, int cantidadStock,
                    String resolucionPantalla, String tipoTeclado, int bateria) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioFabricacion, precio, cantidadStock);
        this.resolucionPantalla = resolucionPantalla;
        this.tipoTeclado = tipoTeclado;
        this.bateria = bateria;
    }

    // Getters y setters
}

class Tablet extends DispositivoTecnologico {
    private String resolucionPantalla;
    private List<String> accesorios;

    public Tablet(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioFabricacion, float precio, int cantidadStock,
                  String resolucionPantalla, List<String> accesorios) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioFabricacion, precio, cantidadStock);
        this.resolucionPantalla = resolucionPantalla;
        this.accesorios = accesorios;
    }

    // Getters y setters
}

class Pantalla {
    private String marca;
    private String modelo;
    private int anioFabricacion;

    public Pantalla(String marca, String modelo, int anioFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    // Getters y setters
}

class Main {
    public static void main(String[] args) {
        // Ejemplo de uso
        Tienda tienda = new Tienda("Dirección de la tienda");

        Cliente cliente1 = new Cliente("John", "Doe", "john.doe@example.com", "123456789", "Soltero", "Ciudad1");
        tienda.agregarCliente(cliente1);

        Cliente cliente2 = new Cliente("Jane", "Smith", "jane.smith@example.com", "987654321", "Casado", "Ciudad2");
        tienda.agregarCliente(cliente2);

        DispositivoTecnologico dispositivo1 = new ComputadoraEscritorio("Marca1", "8GB", "1TB", "Procesador1", "Modelo1", 2022, 999.99f, 10,
                "TarjetaVideo1", "FuentePoder1", "Chasis1", new Pantalla("MarcaPantalla1", "ModeloPantalla1", 2022));
        tienda.agregarDispositivo(dispositivo1);

        DispositivoTecnologico dispositivo2 = new Notebook("Marca2", "16GB", "512GB", "Procesador2", "Modelo2", 2021, 1499.99f, 5,
                "ResolucionPantalla2", "TipoTeclado2", 5000);
        tienda.agregarDispositivo(dispositivo2);

        List<DispositivoTecnologico> dispositivosMarca1 = tienda.buscarDispositivosPorMarca("Marca1");
        System.out.println("Dispositivos de la marca 'Marca1':");
        for (DispositivoTecnologico dispositivo : dispositivosMarca1) {
            System.out.println(dispositivo.getModelo());
        }

        List<DispositivoTecnologico> dispositivosModeloTipo = tienda.buscarDispositivosPorModeloYTipo("Modelo1", "ComputadoraEscritorio");
        System.out.println("Dispositivos del modelo 'Modelo1' y tipo 'ComputadoraEscritorio':");
        for (DispositivoTecnologico dispositivo : dispositivosModeloTipo) {
            System.out.println(dispositivo.getMarca());
        }
    }
}
