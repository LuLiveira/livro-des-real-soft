import dev.lucas.exemplos.livro.transactions_manager.BankStatementCSVParser;
import dev.lucas.exemplos.livro.transactions_manager.BankTransaction;
import junit.framework.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementCSVParserTest {


    private final BankStatementCSVParser statementCSVParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() {
        final var line = "30-01-2017,-50,Tesco";
        final var result = statementCSVParser.parseFrom(line);
        final var expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final var tolerance = 0.0d;

        Assert.assertEquals(expected.date(), result.date());
        Assert.assertEquals(expected.amount(), result.amount(), tolerance);
        Assert.assertEquals(expected.description(), result.description());
    }

    @Test
    public void shouldParseTwoCorrectLine() {
        final var lines = List.of("30-01-2017,-50,Tesco", "25-02-2017,150,Desco");
        final var results = statementCSVParser.parseLinesFrom(lines);
        final var expected1 = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final var expected2 = new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 25), 150, "Desco");
        final var tolerance = 0.0d;


        var result1 = results.get(0);
        var result2 = results.get(1);

        Assert.assertEquals(expected1.date(), result1.date());
        Assert.assertEquals(expected1.amount(), result1.amount(), tolerance);
        Assert.assertEquals(expected1.description(), result1.description());

        Assert.assertEquals(expected2.date(), result2.date());
        Assert.assertEquals(expected2.amount(), result2.amount(), tolerance);
        Assert.assertEquals(expected2.description(), result2.description());

    }
}
