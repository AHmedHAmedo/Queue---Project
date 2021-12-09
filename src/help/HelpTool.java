
package help;

/**
 *
 * @author Abdalla
 */
public class HelpTool {
    
        /* isValied  :check input is valid or not
     * argument  : String check it 
     * return    : true if input is valid , false if no't
     */
    
    public boolean isValied(String input){
        
       char []c = input.toCharArray();
       int coun = 0;
       if(c.length==0){
           return false; 
          }
       if(c[0]=='/')
           return false;
       
       
       if(c.length==0){
           return false;   
        }else{
            for(char i:c){
                if(i=='.' || i=='/')
                        coun++;
                if(coun>1){
                    return false;
                }
                if( !(Character.isDigit(i) || i=='.' || i=='/' ) ){
                  return false;   
                }
            }
            return true;     
        }
    }
    /* convertToDouble : Converting from string to double 
     * argument        : String input 
     * return          : double number
     */
    
    
    public double convertToDouble(String input){
        
      char [] arrinput = input.toCharArray();
      double number = 0.000000000000;
      double decimal= 0.000000000000;
      char operand  = '0' ;
      double j=10.0000000;
      
      for(char i : arrinput){
          
            if(i== '.' || i== '/')
                operand = i;
            
            if(Character.isDigit(i) && operand == '0'){
                number = (number*10.00000000)+ ( (double)i-'0');
                
            }else if (Character.isDigit(i) && operand == '.'){

                decimal = decimal + (( (double)i-'0' )/j);
                j*=10.000000000;
                
           }else if(Character.isDigit(i) && operand == '/'){
                  decimal = decimal*10.0000000000 + ((double) i-'0') ;

           }

       }
       if(operand == '.'){
          number = number+decimal; 
       }else if(operand == '/'){
           number =number/decimal;
       }
      
    
     return number;
    }
    
    
    
    
}
