package ua.khpi.oop.lab16;

public class NativeThresholdFilter {
    static {
        // завантаження native-бібліотеки
        System.loadLibrary("nativefilter");
    }

    // оголошення native-методу
    public native int[] filter(int[] input, int threshold);
}