package lab2;

import lab2.logariphmic.LnCalculator;
import lab2.logariphmic.LogBaseCalculator;
import lab2.trigonometric.SecCalculator;
import lab2.trigonometric.TanCalculator;

public class Function extends Calculator{
    private final TanCalculator tan;
    private final SecCalculator sec;
    private final LnCalculator ln;
    private final LogBaseCalculator log3;
    private final LogBaseCalculator log5;

    public Function(double accuracy, TanCalculator tan,
                    SecCalculator sec, LnCalculator ln, LogBaseCalculator log3,
                    LogBaseCalculator log5) {
        super(accuracy);
        this.tan = tan;
        this.sec = sec;
        this.ln = ln;
        this.log3 = log3;
        this.log5 = log5;
    }

    public double calculate(double x) {
        if (x <= 0) {
            return (sec.calculate(x) - tan.calculate(x))*sec.calculate(x);
        } else {
            return ((Math.pow(ln.calculate(x), 2) - Math.pow(log5.calculate(x), 2))
                    - log5.calculate(x)) + log3.calculate(x);
        }
    }
}
