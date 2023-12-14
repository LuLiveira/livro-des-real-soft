package dev.lucas.exemplos.livro.transactions_manager;


@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}
