package br.com.alura.integraviacep.dependencias;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorConsultas {
    private List<String> cepConsultados = new ArrayList<>();
    public void adicionarConsulta(String consulta){
        cepConsultados.add(consulta);
    }

    public List<String> getCepConsultados() {
        return cepConsultados;
    }

    public void escreverArquivo() throws IOException {
        FileWriter escrita = new FileWriter("consultasCep.json");
        escrita.write(getCepConsultados().toString());
        escrita.close();
    }

}
