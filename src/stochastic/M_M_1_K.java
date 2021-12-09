package stochastic;

public class M_M_1_K extends ParentClass{
    private int K;  //finite capacity of the system
    private double lambda_dash;

    public M_M_1_K(double lambda, double mu, int K) {
        super(lambda, mu);
        raw = lambda/mu;
        this.K = K;
        lambda_dash = lambda * (1 - Pn(K));
    }

    public double P0(){
        double p0;

        if(raw != 1){
            p0 = (1 - raw)/(1 - Math.pow(raw, K+1));
        }
        else {
            p0 = 1/(K + 1);
        }

        return p0;
    }


    public double Pn(int n){
        double pn;

        if(raw != 1)
            pn = P0() * Math.pow(raw, n);

        else pn = P0();

        return pn;
    }


    public double L(){
        double l;

        if(raw != 1){
            double num = 1 - (K+1)*Math.pow(raw, K) + K*Math.pow(raw, K+1);
            double demo = (1 - raw) * (1 - Math.pow(raw, K+1));

            l = raw * (num/demo);
        }

        else l = K/2;

        return l;
    }

    public double Lq(){
        double lq = lambda_dash * Wq();
        return lq;
    }

    public double W(){
        double w = L()/lambda_dash;
        return w;
    }
    public double Wq(){
        double wq = W() - (1/mu);
        return wq;
    }

    public String toString(){
        return "The average Number of Customers in system is: " + L() + " Customers.\nThe average number of Customers" +
                " in the queue is: " + Lq() + " Customers.\nThe average Waiting time in the system is: " + W()
                + " a time.\nThe average Waiting time in the queue is: " + Wq()
                + " a time.\n----------------------------------------------------------------";
    }


}
