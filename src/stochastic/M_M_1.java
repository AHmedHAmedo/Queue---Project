package stochastic;

public class M_M_1 extends ParentClass {

    public M_M_1(double lambda, double mu) {
        super(lambda, mu);
        raw = lambda/mu;
    }


    public double P0(){
        double p0 = 1 - raw;
        return p0;
    }
    public double Pn(int n){
        double pn = (1 - raw) * Math.pow(raw, n);
        return pn;
    }
    public double L(){
        double l = lambda/(mu - lambda);
        return l;
    }
    public double Lq(){
        double lq = raw * L();
        return lq;
    }
    public double W(){
        double w = L()/lambda;
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









}
