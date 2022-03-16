package lab2.trigonometric;

import org.mockito.Mockito;

import static java.lang.Math.PI;
import static java.lang.Double.NaN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonomMock {
    public static SinCalculator getSinMock() {
        SinCalculator sin = mock(SinCalculator.class);

        when(sin.calculate(Mockito.eq(1 * PI / 6))).thenReturn(0.49999999999999994);
        when(sin.calculate(Mockito.eq(1 * PI / 4))).thenReturn(0.7071067811865475);
        when(sin.calculate(Mockito.eq(1 * PI / 3))).thenReturn(0.8660254037844386);
        when(sin.calculate(Mockito.eq(2 * PI / 3))).thenReturn(0.8660254037844387);
        when(sin.calculate(Mockito.eq(3 * PI / 4))).thenReturn(0.7071067811865476);
        when(sin.calculate(Mockito.eq(5 * PI / 6))).thenReturn(0.49999999999999994);
        when(sin.calculate(Mockito.eq(7 * PI / 6))).thenReturn(-0.4999999999999997);
        when(sin.calculate(Mockito.eq(5 * PI / 4))).thenReturn(-0.7071067811865475);
        when(sin.calculate(Mockito.eq(4 * PI / 3))).thenReturn(-0.8660254037844384);
        when(sin.calculate(Mockito.eq(5 * PI / 3))).thenReturn(-0.8660254037844386);
        when(sin.calculate(Mockito.eq(7 * PI / 4))).thenReturn(-0.7071067811865477);
        when(sin.calculate(Mockito.eq(11 * PI / 6))).thenReturn(-0.5000000000000004);
        when(sin.calculate(Mockito.eq(PI))).thenReturn(0.0);
        when(sin.calculate(Mockito.eq(2 * PI))).thenReturn(0.0);
        when(sin.calculate(Mockito.eq(1 * PI / 2))).thenReturn(1.0);
        when(sin.calculate(Mockito.eq(-1 * PI / 2))).thenReturn(-1.0);
        when(sin.calculate(Mockito.eq(-1 * PI / 4))).thenReturn(-0.7071067811865475);
        when(sin.calculate(Mockito.eq(-3 * PI / 4))).thenReturn(-0.7071067811865476);
        when(sin.calculate(Mockito.eq(-PI))).thenReturn(0.0);
        when(sin.calculate(Mockito.eq(-5 * PI / 4))).thenReturn(0.7071067811865475);
        when(sin.calculate(Mockito.eq(-7 * PI / 4))).thenReturn(0.7071067811865477);


        when(sin.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(sin.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        when(sin.calculate(NaN)).thenReturn(NaN);

        return sin;
    }
}
