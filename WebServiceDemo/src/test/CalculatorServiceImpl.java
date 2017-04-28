package test;  
  
import javax.jws.WebService;  

@WebService(endpointInterface="test.CalculatorService",serviceName="calculator")
public class CalculatorServiceImpl implements CalculatorService {
	
    @Override
    public int add(int a, int b) {
        
        System.out.println("This WebService interface is used!!!");
        
        return a + 2*b;
    }
    @Override
    public String concat(String a, String b) {
        return a + b;
    }
}