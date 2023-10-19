package br.com.alura.integraviacep.dependencias;

import br.com.alura.integraviacep.modelos.Cep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IntegraViaCep {

    private String cep = "";

    public IntegraViaCep(String cep) {
        this.cep = cep;
    }

    public String Conectar () throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        String endereco = "https://viacep.com.br/ws/" + this.cep.replace(" ", "+") + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //return (response.body());
            Cep novoCep = gson.fromJson(response.body(), Cep.class);
            return (gson.toJson(novoCep));
        } catch (IOException e){
            return(e.getMessage());
        } catch (InterruptedException e){
            return(e.getMessage());
        }
    }

}
