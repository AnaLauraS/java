package clase2;

public class Main {
    public static void main(String[] args) {
        Menu clasico1=new Clasico(5);
        Menu infantil1=new Infantil(2.5);
        Menu vegetariano1=new Vegetariano(10);

        System.out.println(clasico1.armadoDelMenu());
        System.out.println(infantil1.armadoDelMenu());
        System.out.println(vegetariano1.armadoDelMenu());
    }
}
