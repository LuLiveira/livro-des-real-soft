package dev.lucas.exemplos.livro;

import java.time.Month;

class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth().equals(Month.FEBRUARY)
                && bankTransaction.getAmount() >= 1_000;
    }
}
