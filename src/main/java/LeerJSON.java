import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerJSON {
    public static void main(String[] args) {
        String archivo = "empleados.json";

        try (JsonReader reader = Json.createReader(new FileReader(archivo))) {
            // Leer el archivo como un arreglo JSON
            JsonArray empleados = reader.readArray();

            // Mostrar cada empleado en la consola
            for (JsonObject empleado : empleados.getValuesAs(JsonObject.class)) {
                System.out.println("Nombre: " + empleado.getString("nombre"));
                System.out.println("Posición: " + empleado.getString("posicion"));
                System.out.println("Salario: " + empleado.getJsonNumber("salario").doubleValue());
                System.out.println("----------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}