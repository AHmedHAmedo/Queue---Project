
package detrmnistic;

import help.HelpTool;
//import java.math.BigDecimal;
/**
 *
 * @author Abdalla
 */
public class ProblemType1 {
     help.HelpTool use =new HelpTool();

     
    private double arivaleRate=0.0;
    private double serviceRate=0.0;
    private double inputTime=0;
    private double capacity=0;
    private double timeBalk=0;
    private double numberN=0;
    private double resultCoustmer=0;
    private double resultTime=0;
    
    
      /* calculateTimeBalk : calculate time when the first client balck
      * arguments          : arivale rate,service rate , capacity  
      * return             : time when the first client balck
      */
    public double calculateTimeBalk(String arivale,String service,String capacity ){
        int capcity=0;
        arivaleRate = use.convertToDouble(arivale);
        serviceRate = use.convertToDouble(service);
        this.capacity=use.convertToDouble(capacity);
     
      
              
        timeBalk =(this.capacity-(serviceRate/arivaleRate))/(arivaleRate-serviceRate);
      
        timeBalk= Math.round( timeBalk );
        
         capcity = (int)((arivaleRate * timeBalk) - ((serviceRate* timeBalk) - (serviceRate/arivaleRate))); 
         while((int)this.capacity == capcity){
            
            timeBalk-=(1/arivaleRate);
            capcity = ((int)(arivaleRate * timeBalk)) - ((int)((serviceRate* timeBalk) - (serviceRate/arivaleRate)));   
            
        }  
        
       
         timeBalk+=(1/arivaleRate);
         
        return timeBalk;
    }
    
     /* numberOfCoustmer: calculate number of coustmer in the system in specific time
      * arguments       : arivale rate,service rate , specific time , capacity of system 
      * return          : number of coustmer in the system in specific time
      */
     public double numberOfCoustmer(String arivale,String service,String time,String capacity){
       
        
        arivaleRate = use.convertToDouble(arivale);
        serviceRate = use.convertToDouble(service);
        inputTime = use.convertToDouble  ( time);
        this.capacity=use.convertToDouble(capacity);
        
        timeBalk=calculateTimeBalk(arivale, service,  capacity );
        
        if(inputTime <= (1/arivaleRate)){
             resultCoustmer=0;
             return resultCoustmer;
        }
        else if(( 1/arivaleRate) < inputTime && inputTime < timeBalk ){
            
             resultCoustmer= ((int)(arivaleRate * inputTime)) - ((int)((serviceRate* inputTime) - (serviceRate/arivaleRate)));
           return resultCoustmer;
        }
        else{
            resultCoustmer= this.capacity-1;
            return resultCoustmer;
        }
     }
     
     
    /* calculateWatingTime: calculate wating time for client number N
      * arguments         : arivale rate,service rate , number N 
      * return            : wating time for client number N
      */
      public double calculateWatingTime(String arivale,String service,String numberN,String capacity){
           arivaleRate = use.convertToDouble(arivale);
           serviceRate = use.convertToDouble(service);
           this.numberN = use.convertToDouble(numberN);
            
           timeBalk=calculateTimeBalk(arivale, service, capacity);
          
           
           if(this.numberN==0||this.numberN==1){
              resultTime=0;
              return resultTime;
           }
           else if(this.numberN <(arivaleRate*timeBalk)){
                resultTime=(int)((1/serviceRate)-(1/arivaleRate))*(this.numberN-1);
          
                 return resultTime; 
           }
           else{
              resultTime=(int)((1/serviceRate)-(1/arivaleRate))*((arivaleRate*timeBalk)-1);
             
               return resultTime; 
           }
            
          
      }

    
    
}
