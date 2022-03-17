package lab2;

import lab2.logariphmic.LnCalculator;
import lab2.logariphmic.LogBaseCalculator;
import lab2.logariphmic.LogMock;
import lab2.trigonometric.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value=PER_CLASS)
public class FunctionTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Function function;

    @AfterAll
    public void logInCSV() {
        CsvLogger csvLogger = new CsvLogger("csv_output/function.csv");
        csvLogger.log(function);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void stubsTest(double expected, double num, double den) {
        function = new Function(ACCURACY, TrigonomMock.getTanMock(),
                TrigonomMock.getSecMock(), LogMock.getLnMock(),
                LogMock.getLog3Mock(), LogMock.getLog5Mock());
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void sinStubTest(double expected, double num, double den) {
        SinCalculator sin = TrigonomMock.getSinMock();
        CosCalculator cos = new CosCalculator(ACCURACY, sin);
        TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
        SecCalculator sec = new SecCalculator(ACCURACY, cos);
        LnCalculator ln = new LnCalculator(ACCURACY);
        LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
        LogBaseCalculator log5 = new LogBaseCalculator(ACCURACY, 5, ln);

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void cosStubTest(double expected, double num, double den) {
        SinCalculator sin = new SinCalculator(ACCURACY);
        CosCalculator cos = TrigonomMock.getCosMock();
        TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
        SecCalculator sec = new SecCalculator(ACCURACY, cos);
        LnCalculator ln = new LnCalculator(ACCURACY);
        LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
        LogBaseCalculator log5 = new LogBaseCalculator(ACCURACY, 5, ln);

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void tanStubTest(double expected, double num, double den) {
        SinCalculator sin = new SinCalculator(ACCURACY);
        CosCalculator cos = new CosCalculator(ACCURACY, sin);
        TanCalculator tan = TrigonomMock.getTanMock();
        SecCalculator sec = new SecCalculator(ACCURACY, cos);
        LnCalculator ln = new LnCalculator(ACCURACY);
        LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
        LogBaseCalculator log5 = new LogBaseCalculator(ACCURACY, 5, ln);

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void cosecStubTest(double expected, double num, double den) {
        SinCalculator sin = new SinCalculator(ACCURACY);
        CosCalculator cos = new CosCalculator(ACCURACY, sin);
        TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
        SecCalculator sec = TrigonomMock.getSecMock();
        LnCalculator ln = new LnCalculator(ACCURACY);
        LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
        LogBaseCalculator log5 = new LogBaseCalculator(ACCURACY, 5, ln);

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void lnStubTest(double expected, double num, double den) {
        SinCalculator sin = new SinCalculator(ACCURACY);
        CosCalculator cos = new CosCalculator(ACCURACY, sin);
        TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
        SecCalculator sec = new SecCalculator(ACCURACY, cos);
        LnCalculator ln = LogMock.getLnMock();
        LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
        LogBaseCalculator log5 = new LogBaseCalculator(ACCURACY, 5, ln);

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void log2StubTest(double expected, double num, double den) {
        SinCalculator sin = new SinCalculator(ACCURACY);
        CosCalculator cos = new CosCalculator(ACCURACY, sin);
        TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
        SecCalculator sec = new SecCalculator(ACCURACY, cos);
        LnCalculator ln = new LnCalculator(ACCURACY);
        LogBaseCalculator log3 = LogMock.getLog3Mock();
        LogBaseCalculator log5 = new LogBaseCalculator(ACCURACY, 5, ln);

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void log5StubTest(double expected, double num, double den) {
        SinCalculator sin = new SinCalculator(ACCURACY);
        CosCalculator cos = new CosCalculator(ACCURACY, sin);
        TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
        SecCalculator sec = new SecCalculator(ACCURACY, cos);
        LnCalculator ln = LogMock.getLnMock();
        LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
        LogBaseCalculator log5 = LogMock.getLog5Mock();

        function = new Function(ACCURACY, tan, sec, ln, log3, log5);
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

}