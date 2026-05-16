package ua.khpi.oop.lab16;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ThresholdFilterTest {
    private final ThresholdFilter javaFilter = new ThresholdFilter();
    private final NativeThresholdFilter nativeFilter = new NativeThresholdFilter();

    @Test
    void testJavaImplementation() {
        int[] input = {1, 5, 10, 2, 8};
        // поріг 8
        int[] expected = {0, 0, 1, 0, 1};
        assertArrayEquals(expected, javaFilter.filter(input, 8));
    }

    @Test
    void testNativeImplementation() {
        int[] input = {1, 5, 10, 2, 8};
        int[] expected = {0, 0, 1, 0, 1};
        assertArrayEquals(expected, nativeFilter.filter(input, 8));
    }

    @Test
    void testBothImplementationsAreEqual() {
        int[] input = {-5, 0, 20, 15, 7, 3};
        int threshold = 5;

        int[] javaResult = javaFilter.filter(input, threshold);
        int[] nativeResult = nativeFilter.filter(input, threshold);

        // результати java та c++ мають співпадати
        assertArrayEquals(javaResult, nativeResult);
    }
}