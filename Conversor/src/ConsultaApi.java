import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public String Pair(String origen, String destino, double cantidad){

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/65d799af03b73b7e4ddb3e6e/pair/"+origen+"/"+destino+"/"+cantidad);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);
            Pair pares = gson.fromJson(json, Pair.class);
            System.out.println(pares);
            return "El valor " + cantidad + "[" + origen + "] corresponde al valor final de =>>> " + pares.conversion_result()+"["+ destino +"]\n";
        } catch (Exception e) {
            throw new RuntimeException("Error Inesperado!");
        }

    }
}
