package test;

import javax.jws.WebService;

@WebService
public interface CalculatorService {
	
	int add(int a, int b);

	String concat(String a, String b);
}