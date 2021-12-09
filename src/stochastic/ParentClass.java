package stochastic;

abstract public class ParentClass {
    public double lambda; //represent arrival rate
    public double mu;    //represent service rate
    public double raw;

    public ParentClass() {
    }

    public ParentClass(double lambda, double mu) {
        this.lambda = lambda;
        this.mu = mu;
    }

    public abstract double P0();
    public abstract double Pn(int n);
    public abstract double L();
    public abstract double Lq();
    public abstract double W();
    public abstract double Wq();

    public int factorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i++) {
            result *=i;
        }
        return result;
    }



}
