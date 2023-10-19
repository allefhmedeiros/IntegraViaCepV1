package br.com.alura.integraviacep.principal;

import br.com.alura.integraviacep.dependencias.IntegraViaCep;
import br.com.alura.integraviacep.modelos.Cep;

public class Principal {
    public static void main(String[] args) {

        IntegraViaCep novaConsulta = new IntegraViaCep();
        Cep novoCep = novaConsulta.buscaCep("1");
        System.out.println(novoCep);

    }
}
