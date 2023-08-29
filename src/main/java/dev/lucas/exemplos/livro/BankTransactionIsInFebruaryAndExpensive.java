package dev.lucas.exemplos.livro;

import java.time.Month;

class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.date().getMonth().equals(Month.FEBRUARY)
                && bankTransaction.amount() >= 1_000;
    }
}
