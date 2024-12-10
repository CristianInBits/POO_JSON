import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModificarJSON {
    public static void main(String[] args) {
        String archivo = "empleados.json";

        try (JsonReader reader = Json.createReader(new FileReader(archivo))) {
            // Leer el archivo como un arreglo JSON
            JsonArrayBuilder empleadosModificados = Json.createArrayBuilder();

            for (JsonObject empleado : reader.readArray().getValuesAs(JsonObject.class)) {
                JsonObjectBuilder builder = Json.createObjectBuilder(empleado);

                // Aumentar el salario de Pedro
                if (empleado.getString("nombre").equals("Pedro")) {
                    double nuevoSalario = empleado.getJsonNumber("salario").doubleValue() + 500.00;
                    builder.add("salario", nuevoSalario); // Modifica el salario
                }

                empleadosModificados.add(builder);
            }

            // Guardar los cambios en el archivo
            try (JsonWriter writer = Json.createWriter(new FileWriter(archivo))) {
                writer.writeArray(empleadosModificados.build());
            }

            System.out.println("Archivo modificado y guardado: " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}