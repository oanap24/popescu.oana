package cap1;
//INNER CLASSES
public class Main {

    public static void main(String []args){

    }
}

 class A {
    String nameA;
    private static String nameAA;


   protected  static class B{
       private String nameB;
       //poate sa aiba membri privati
       //poate sa aiba orice tip de modificator de acces clasa
       //vizibilitate la nivel de pachet - celelalte clase din pachet pot accesa clasa
       //static String c; inner class cannot have static declarations
       //? poate accesa membrii clasei outer? Da, si aia privati
       //pot sa extinda orice clasa si sa implementeze interfete
       protected String getCrazy(){
           A.nameAA = "alala";
           return A.nameAA;
       }
    }


}