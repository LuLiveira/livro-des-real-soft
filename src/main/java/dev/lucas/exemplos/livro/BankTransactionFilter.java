package dev.lucas.exemplos.livro;


@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}
