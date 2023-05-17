public class ConversionTemperatura {
    public static double fahrenheitACelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

public static void main(String[] args) {
        double fahrenheit = 68; // establece el valor en grados Fahrenheit
        double celsius = fahrenheitACelsius(fahrenheit); // llama al método para convertir Fahrenheit a Celsius
        System.out.println(fahrenheit + " grados Fahrenheit equivalen a " + celsius + " grados Celsius."); // imprime el resultado
    }
}

