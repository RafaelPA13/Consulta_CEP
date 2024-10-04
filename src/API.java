import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private String url;

    public API(String url, String cep) {
        if (cep.length() > 8) {
            throw new ErroCEPComMaisDeOitoDigitos("Erro: O CEP digitado tem mais que 8 digitos");
        }
        this.url = url + cep + "/json/";
    }

    //Requisição com API
    public void requisicao() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            FileWriter escrever = new FileWriter("Endereco.json");
            escrever.write(json);
            escrever.close();

            System.out.println("Os dados do endereço estão no arquivo Endereco.json");
        } catch (ErroCEPComMaisDeOitoDigitos e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Não consegui obter o endereço a partir desse CEP");
        } finally {
            System.out.println("Programa Finalizado.");
        }
    }
}
