package dev.lucas.exemplos.livro;

import java.time.Month;

@FunctionalInterface
interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);
}
