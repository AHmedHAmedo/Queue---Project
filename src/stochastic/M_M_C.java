package stochastic;

public class M_M_C extends ParentClass {
    private int c;  //represent number of servers in the system
    private double r;  //represent a ratio between lambda and mu


    public M_M_C(double lambda, double mu, int c) {
        super(lambda, mu);
        this.c = c;
        r = lambda/mu;
        raw = r/c;
    }

    public double P0(){
        double p0;

        if(raw < 1){
            p0 = getSummation(0, c-1) + (c * Math.pow(r, c))/(factorial(c) * (c - r));
        }

        else {
            p0 = getSummation(0, c-1) + ((Math.pow(r, c)/factorial(c)) * (c*mu)/(c*mu - lambda));
        }

        p0 = 1/p0;
        return p0;
    }

    public double Pn(int n){
        double pn;
        int fac;
        if(n >= 0 && n < c){
            fac = factorial(n);
            pn = P0() * (Math.pow(lambda, n)/(fac * Math.pow(mu, n)));
        }

        else {
            fac = factorial(c);
            pn = P0() * (Math.pow(lambda, n)/(Math.pow(c, n-c) * fac * Math.pow(mu, n)));
        }

        return pn;
    }

    public double L(){
        double l = Lq() + r;
        return l;
    }

    public double Lq(){
        double lq;
        double num = Math.pow(r, c+1) / c;
        double demo = factorial(c) * Math.pow(1-raw, 2);

        lq = P0() * (num/demo);

        return lq;
    }

    public double W(){
        double w = Wq() + (1/mu);
        return w;
    }

    public double Wq(){
        double wq = Lq()/lambda;
        return wq;
    }

    public String toString(){
        return "The average Number of Customers in system is: " + L() + " Customers.\nThe average number of Customers" +
                " in the queue is: " + Lq() + " Customers.\nThe average Waiting time in the system is: " + W()
                + " a time.\nThe average Waiting time in the queue is: " + Wq()
                + " a time.\n----------------------------------------------------------------";
    }

    public double getSummation(int st, int en){
        double result = 0;
        while(st <= en){
            result += (Math.pow(r, st))/(factorial(st));
            st++;
        }
        return result;
    }


}
