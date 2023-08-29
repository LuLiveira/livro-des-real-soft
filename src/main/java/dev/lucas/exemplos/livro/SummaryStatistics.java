package dev.lucas.exemplos.livro;

public class SummaryStatistics {

    private final double sum;
    private final double min;
    private final double max;
    private final double average;

    public SummaryStatistics(double sum, double min, double max, double average) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.average = average;
    }

    public double getSum() {
        return sum;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAverage() {
        return average;
    }
}
