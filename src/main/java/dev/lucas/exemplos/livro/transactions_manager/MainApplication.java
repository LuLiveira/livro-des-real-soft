package dev.lucas.exemplos.livro.transactions_manager;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        
        var analyzer = new BankTransactionAnalyzerSimple();
        analyzer.analyze(null, new BankStatementCSVParser());


    }
    
}
