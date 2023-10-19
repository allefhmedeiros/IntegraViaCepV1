package br.com.alura.integraviacep.principal;

import br.com.alura.integraviacep.dependencias.GerenciadorConsultas;
import br.com.alura.integraviacep.dependencias.IntegraViaCep;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String opcaoUsuario = "";
        Scanner entradaUsuario = new Scanner(System.in);
        GerenciadorConsultas gerenciarConsulta = new GerenciadorConsultas();

        while (!opcaoUsuario.equalsIgnoreCase("sair")){
            System.out.println("======= INTEGRAÇÃO DE BUSCAS - VIA CEP =======");
            System.out.println("Informe um cep com 8 dígitos, sem espaços, letras, traços ou barras: ");
            opcaoUsuario = entradaUsuario.nextLine();
            if(opcaoUsuario.length()!=8){
                System.out.println("O cep precisa conter 8 dígitos!");
                break;
            }
            IntegraViaCep novaIntegracao = new IntegraViaCep(opcaoUsuario);
            System.out.println(novaIntegracao.Conectar());;
            gerenciarConsulta.adicionarConsulta(novaIntegracao.Conectar());
            gerenciarConsulta.escreverArquivo();
            System.out.println("-------------------------------------");
        }
        System.out.println("Essa execução foi finalizada!");
        entradaUsuario.close();

    }
}