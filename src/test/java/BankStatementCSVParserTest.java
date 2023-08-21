import dev.lucas.exemplos.livro.BankStatementCSVParser;
import dev.lucas.exemplos.livro.BankTransaction;
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

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
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

        Assert.assertEquals(expected1.getDate(), result1.getDate());
        Assert.assertEquals(expected1.getAmount(), result1.getAmount(), tolerance);
        Assert.assertEquals(expected1.getDescription(), result1.getDescription());

        Assert.assertEquals(expected2.getDate(), result2.getDate());
        Assert.assertEquals(expected2.getAmount(), result2.getAmount(), tolerance);
        Assert.assertEquals(expected2.getDescription(), result2.getDescription());

    }
}
