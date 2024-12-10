import javax.json.Json;
import javax.json.JsonArray;
//import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearJSON {
    public static void main(String[] args) {
        String archivo = "empleados.json";

        // Crear un arreglo JSON con datos de empleados
        JsonArray empleados = Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                        .add("nombre", "Juan")
                        .add("posicion", "Desarrollador")
                        .add("salario", 3000.00))
                .add(Json.createObjectBuilder()
                        .add("nombre", "Ana")
                        .add("posicion", "Diseñadora")
                        .add("salario", 3500.00))
                .add(Json.createObjectBuilder()
                        .add("nombre", "Pedro")
                        .add("posicion", "Administrador")
                        .add("salario", 4000.00))
                .build();

        // Escribir el arreglo JSON en un archivo
        try (JsonWriter writer = Json.createWriter(new FileWriter(archivo))) {
            writer.writeArray(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo JSON creado: " + archivo);
    }
}