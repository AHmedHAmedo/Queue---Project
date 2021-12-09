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
    private double time=0;                  // t
    private double timeStesdyState=0;       // ti
    private double numberOfCoustomer=0;     //  n(t) at time 
    private double watingTime=0;            //Wq(n) for coustmoer number n
    private double nCustomer=0;           
    /* findTimeStesdyState : find Time of the steady state of the system 
     *  arguments          : initialCustomers,arivaleRate,serviseRate
     *  return             : time of the steady state 
     */ 
    
    
    public double findTimeStesdyState(double initialCustomers,double arivaleRate,double serviseRate){
        int intialM=0;
        timeStesdyState=(int)((initialCustomers)/((serviseRate)-(arivaleRate)));
        
        
        intialM= (int)(serviseRate*timeStesdyState)-(int)(arivaleRate*timeStesdyState);
 
        while( initialCustomers == intialM ){
            timeStesdyState-=(1/arivaleRate);
             intialM= (int)(serviseRate*timeStesdyState)-(int)(arivaleRate*timeStesdyState);
        }
        
          timeStesdyState+=(1/arivaleRate);
        
        return timeStesdyState;
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
     
        timeStesdyState=findTimeStesdyState(initialCustomers, arivaleRate, serviseRate);
        
        if( time < timeStesdyState){
        numberOfCoustomer= initialCustomers +(int)(arivaleRate*time)-(int)(serviseRate*time);
        }else{
            numberOfCoustomer=0;
        }
       
            return numberOfCoustomer;
    } 
    
     /* watingTime  : calculate wating time for custome number n
     *  arguments   : initialCustomers,arivaleRate,serviseRate,nCustomer
     *  return      : wating time for custome number n
     */ 
    
    public double watingTime(String initialCustomers,String arivaleRate,String serviseRate,String nCustomer){
        this.arivaleRate=use.convertToDouble(arivaleRate);
        this.serviseRate=use.convertToDouble(serviseRate);
        this.initialCustomers=use.convertToDouble(initialCustomers);
        this.nCustomer=use.convertToDouble(nCustomer);
     
        timeStesdyState=findTimeStesdyState(this.initialCustomers, this.arivaleRate, this.serviseRate);
        
        if(this.nCustomer==0){
            watingTime=(this.initialCustomers-1)/(2*this.serviseRate);
        }else if(this.nCustomer < (this.arivaleRate*timeStesdyState)){
            watingTime=(int)((this.initialCustomers-1+this.nCustomer)*(1.0/this.serviseRate))-(this.nCustomer*(1.0/this.arivaleRate));
        }
        else{
            watingTime=0;
        }
            return watingTime;
    }
    
    
}
