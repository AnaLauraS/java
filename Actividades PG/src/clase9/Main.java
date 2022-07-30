package clase9;

public class Main {
    public static void main(String[] args) {
        Ropa r1=RopaFactory.getRopa("pantalon");
        Ropa r2=RopaFactory.getRopa("pantalon");
        Ropa r3=RopaFactory.getRopa("short");
        Ropa r4=RopaFactory.getRopa("short");
        Ropa r5=RopaFactory.getRopa("saco");
        Ropa r6=RopaFactory.getRopa("saco");
        Ropa r7=RopaFactory.getRopa("remera");

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
