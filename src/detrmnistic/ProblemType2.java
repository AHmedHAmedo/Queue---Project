/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detrmnistic;

import help.HelpTool;

/**
 *
 * @author Abdalla
 */
public class ProblemType2 {
    HelpTool use =new HelpTool();
    
    
    private double arivaleRate=0.0;         // 
    private double serviseRate=0.0;         //
    private double initialCustomers =0;     // M
    private double capacity=0;              // K
    private double time=0;                 // t
    private double ti=0;                   // ti
    private double numberOfCoustomer=0;    //  n(t)
    private double watingTime=0;           //Wq(n)
    
    
    
    
    public double findTi(double initialCustomers,double arivaleRate,double serviseRate){
        
        ti=(int)((initialCustomers)/(serviseRate-arivaleRate));
        while(initialCustomers==((int)(serviseRate*ti)-(int)(arivaleRate*ti))){
            ti-=arivaleRate;
        }
          ti+=arivaleRate;
        
        return ti;
    }
    
    /* findNumberOfCustomer : find number of customer in system in time T
     *  arguments           :initialCustomers,arivaleRate,serviseRate,time
     *  return              :
     */ 
    
    public double findNumberOfCustomer(String strInitialCustomers,String strArivaleRate,String  strServiseRate,String  strTime){
        this.arivaleRate=use.convertToDouble(strArivaleRate);
        this.serviseRate=use.convertToDouble(strServiseRate);
        this.time=use.convertToDouble(strTime);
        this.initialCustomers=use.convertToDouble(strInitialCustomers);
        
        numberOfCoustomer= initialCustomers +(int)(arivaleRate*time)-(int)(serviseRate*time);
        if(numberOfCoustomer>=0) 
         return numberOfCoustomer;
        else 
            return 0;
    } 
    
     /* watingTime  : calculate wating time for custome number n
     *  arguments   : initialCustomers,arivaleRate,serviseRate,nCustomer
     *  return      : wating time for custome number n
     */ 
    
    public double watingTime(double initialCustomers,double arivaleRate,double serviseRate,double nCustomer){
        if(nCustomer==0){
            watingTime=(initialCustomers-1)/(2*serviseRate);
        }else{
            watingTime=((initialCustomers-1+nCustomer)*(1.0/serviseRate))-(nCustomer*(1.0/arivaleRate));
        }
        if(watingTime>=0)
            return watingTime; 
        else
            return 0;
    }
    
    
}
