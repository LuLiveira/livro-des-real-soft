package dev.lucas.exemplos.livro;

import java.time.Month;
import java.util.List;

/**
 * Hello world!
 */
public class BankTransactionProcessor {

    private final List<BankTransaction> bankTransactionsList;

    private BankTransactionProcessor(List<BankTransaction> bankTransactionsList) {
        this.bankTransactionsList = bankTransactionsList;
    }

    public static BankTransactionProcessor newInstance(List<BankTransaction> bankTransactionsList) {
        if (bankTransactionsList.isEmpty())
            throw new IllegalStateException("Não há dados para calcular.");
        return new BankTransactionProcessor(bankTransactionsList);
    }

    public double calculateTotalInMonth(final Month month) {
        return this.summarizeTransaction((
                (accumulator, bankTransaction) -> bankTransaction.getDate().getMonth() == month
                        ? accumulator + bankTransaction.getAmount() : accumulator));
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactionsList) {
            final double amount = bankTransaction.getAmount();
            total += amount;
        }

        //System.out.println("The total for all transactions is " + total);
        return total;
    }

    public double calculateTotalForCategory(String category) {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactionsList) {
            if (bankTransaction.getDescription().equals(category)) {
                final double amount = bankTransaction.getAmount();
                total += amount;
            }
        }

        //System.out.println("The total for all transactions in January is " + total);
        return total;
    }


    /**
     * 
     * @param filter filter implementation that go be apply in bankTransactionList
     * @return return a list of BankTransaction
     * this method is a implementation from the book
     */
    public List<BankTransaction> findTransactions(final BankTransactionFilter filter){
        return bankTransactionsList.stream().filter(filter::test).toList();
    }

//    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
//        return this.findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
//    }

    private double summarizeTransaction(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0d;
        for (final BankTransaction bankTransaction:
             bankTransactionsList) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

//    /**
//     *
//     * @param filter
//     * @return return a filter list of BankTransaction
//     * this method is an option in java8 it use a Predicate interface.
//     */
//    public List<BankTransaction> findTransactions(final Predicate<BankTransaction> filter){
//        return bankTransactionsList.stream().filter(filter::test).toList();
//    }
}
