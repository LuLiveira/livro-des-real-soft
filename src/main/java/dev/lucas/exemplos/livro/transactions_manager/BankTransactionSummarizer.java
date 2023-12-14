package dev.lucas.exemplos.livro.transactions_manager;

import java.time.Month;

@FunctionalInterface
interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);
}
