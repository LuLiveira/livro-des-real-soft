package dev.lucas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;

/**
 * Hello world!
 */
public class BankTransactionAnalyzerSimpleMinhaImplementacao {

    private final static String root = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        var path = Paths.get(root + "extrato-modelo.csv");

        double total = 0d;
        for (String registro : Files.readAllLines(path)) {
            total += Double.parseDouble(registro.split(",")[1]);
        }

        System.out.println("The total for all transactions is " + total);


        /**
         * A linhas comentadas são uma implementação do meu entendimento lendo o livro
         * uma primeira vez. As linhas não comentadas são a minha implementação depois
         * de ver a implementação do livro.
         */

//        var scanner = new Scanner(new FileReader("src/main/java/extrato-modelo.csv"));
//
//        List<Gastos> extrato = new ArrayList<>();
//
//        while (scanner.hasNextLine()) {
//
//            String[] split = scanner.nextLine().split(",");
//
//            extrato.add(new Gastos(split[0], split[1], split[2]));
//
//        }
//
//        var listaDeEntradas = extrato.stream().filter(e -> Integer.parseInt(e.valor) > 0).toList();
//        System.out.println("Lista de Entradas -> " + listaDeEntradas);
//
//        var listaDeSaidas = extrato.stream().filter(e -> Integer.parseInt(e.valor) < 0).toList();
//        System.out.println("Lista de Saidas -> " + listaDeSaidas);
//
//
//        var dataFiltro = "01";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        var listaMesFiltro = extrato.stream().filter(e -> LocalDate.parse(e.data,formatter).getMonth().getValue() == Integer.parseInt(dataFiltro)).toList();
//        System.out.println("Filtrando por mês -> " + listaMesFiltro);
//
//
////        Comparator<Gastos> gastosComparator = (o1, o2) -> 0;
//        var top10Gastos = extrato.stream().filter(e -> Integer.parseInt(e.valor) < 0)
//                .sorted(comparingInt(x -> Integer.parseInt(x.valor)))
//                .limit(10).toList();
//
//        System.out.println("Top 10 Gastos -> " + top10Gastos);


    }

//    record Gastos (String data, String valor, String descricao) {
//
//        @Override
//        public String toString() {
//            return "Dia: " + data + " - Valor: " + valor + " Descrição: " + descricao;
//        }
//    }
}
