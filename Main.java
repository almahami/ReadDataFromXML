import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {


    public static void doOperator() throws Exception{
        
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
        
        System.out.print("Enter first arg- ");  
        
        String inputFileName= sc.nextLine();  
         
        ArrayList<Double> areaNumbers = ReadNumber.readNumbers(inputFileName);
        
        System.out.print("Enter second arg- ");
        
        Double sum= 0.0;
        Double result = 0.0;
        for(Double d: areaNumbers) sum+=d;

        String operationInput = sc.nextLine(); 
        
        switch (operationInput) {
            case "average":
                System.out.println("case average: " + sum/areaNumbers.size());
                result =  sum/areaNumbers.size();
                break;
            case "sum":
                System.out.println("case sum: " + sum);
                result =  sum;
                break;
            case "min":
                System.out.println("case min: " +   Collections.min(areaNumbers));
                result =  Collections.min(areaNumbers);
                break;
            case "max":
                System.out.println("case max: " + Collections.max(areaNumbers));
                result =  Collections.max(areaNumbers);
                break;
            default:
                sc.close();
                throw new RuntimeException("Operator NOT available");
            }
        System.out.print("Enter third arg- ");  
        String outputFileName= sc.nextLine(); 

        FileOutputStream fos = new FileOutputStream(outputFileName);
        	
        DataOutputStream dos = new DataOutputStream(fos);
        	
        dos.writeDouble(result);        	
        dos.close();
        sc.close();
    }

    public static void main(String[] args) throws Exception{
            doOperator();
            
     }
    }





    
  
  