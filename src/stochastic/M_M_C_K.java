package stochastic;

public class M_M_C_K extends ParentClass{
    private int c;
    private int k;
    private double r;
    private double lambda_dash;

    public M_M_C_K(double lambda, double mu, int c, int k) {
        super(lambda, mu);
        this.c = c;
        this.k = k;
        r = (lambda/mu);
        raw = r / c ;
        lambda_dash = lambda * (1 - Pn(k));
    }

    public double P0(){
        double p0;

        if(raw != 1){
            p0 = getSummation(0, c-1) + ((Math.pow(r, c))/(factorial(c)) * ((1 - Math.pow(raw, k-c+1)) / (1 - raw)));
        }

        else {
            p0 = getSummation(0, c-1) + ((Math.pow(r, c)/factorial(c)) * (k - c + 1));
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
        double l = Lq() + c - (P0() * getSummation1(0, c-1));
        return l;
    }

    public double Lq(){
        double lq;
        double p1 = (raw * Math.pow(r, c) * P0())/(factorial(c) * Math.pow(1-raw, 2));
        double p2 = (1 - Math.pow(raw, k - c + 1) - ((1 - raw)*(k-c+1)*Math.pow(raw, k-c)));

        lq = p1 * p2;
        return lq;
    }

    public double W(){
        double w = L() / lambda_dash;
        return w;
    }

    public double Wq(){
        double wq = Lq()/lambda_dash;
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

    public double getSummation1(int st, int en){
        double result = 0;
        while(st <= en){
            result += (Math.pow(r, st))/(factorial(st)) * (c - st);
            st++;
        }
        return result;
    }



}
