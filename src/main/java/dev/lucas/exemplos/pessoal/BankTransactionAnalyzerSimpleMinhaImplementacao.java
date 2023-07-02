package dev.lucas.exemplos.pessoal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
@Service
public class BankTransactionAnalyzerSimpleMinhaImplementacao {


    private final static BankStatementCSVParserMinhaImplementacao bankStatementCSVParserMinhaImplementacao = BankStatementCSVParserMinhaImplementacao.newInstance();

    public static void main(String[] args) throws IOException {
        var mes = "01";
        var transactions = bankStatementCSVParserMinhaImplementacao.getTransactions();

        selectInMonth(transactions, Month.JANUARY);
        calculateTotalAmount(transactions);

    }

    public static void calculateTotalAmount(List<BankTransactionMinhaImplementacao> list) {
        double total = 0d;
        for (BankTransactionMinhaImplementacao bankTransaction : list) {
            total += bankTransaction.amount();
        }

        System.out.println("The total for all transactions is " + total);
    }

    public static void selectInMonth(List<BankTransactionMinhaImplementacao> lines, Month mes) {
        double total = 0d;

        for (final BankTransactionMinhaImplementacao bankTransaction : lines) {

            if (bankTransaction.date().getMonth().getValue() == mes.getValue()) {
                final double amount = bankTransaction.amount();
                total += amount;
            }
        }
        System.out.println("The total for all transactions in month " + mes + " is " + total);
    }
}


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