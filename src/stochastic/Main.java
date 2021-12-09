package stochastic;

public class Main {

    public static void main(String[] args) {

        /*
        M_M_1 m1 = new M_M_1(2,2.4);
        System.out.println(m1.toString());

        M_M_1_K m2 = new M_M_1_K(2, 2.4, 5);
        System.out.println(m2.toString());

        M_M_C m3 = new M_M_C(6, 3, 3);
        System.out.println(m3.toString());
        */

        M_M_C_K m4 = new M_M_C_K(1, 1.0/6, 3, 7);
        System.out.println(m4.toString());

    }
}
