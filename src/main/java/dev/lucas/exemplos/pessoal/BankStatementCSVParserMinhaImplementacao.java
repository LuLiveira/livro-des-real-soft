package dev.lucas.exemplos.pessoal;

import java.nio.file.Path;
import java.nio.file.Paths;

@Singleton
public final class BankStatementCSVParserMinhaImplementacao {
    private static Path filePath;
    private static BankStatementCSVParserMinhaImplementacao INSTANCE;

    private BankStatementCSVParserMinhaImplementacao() {
    }

    public Path getFilePath() {
        return filePath;
    }

    public static BankStatementCSVParserMinhaImplementacao newInstance() {
        String root = "src/main/resources/";
        filePath = Paths.get(root + "extrato-modelo.csv");

        if (INSTANCE == null) {
            INSTANCE = new BankStatementCSVParserMinhaImplementacao();
            return INSTANCE;
        }
        return INSTANCE;
    }

}
