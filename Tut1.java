public class Tut1 {

    public static void main(String[] args) {
        int a= 2;
        int b = 3;
        var c = 9;

        byte m = 127;
        short sh = 5567;
        long lg = 78l;
        boolean bl = true;
        System.out.println("Hello World!");
        System.out.println(a + b + c);

        int num1 = 5;
        int num2 = 0b101;
        int num3 = 0X7E;
        int num4 = 1_00_00_000;
        double num5 = 12e10;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);


        //type conversion and casting
        byte bt = 127;
        int it = bt;  //conversion
        System.out.println(it);

        float f = 1.2f;
        int it2 = (int) f;
        System.out.println(it2);

        int week = 1;
        String result = switch (week) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            // case 3 : yield "Wednesday"
            default -> "Null";
        };

        System.out.println(result);
    }
}