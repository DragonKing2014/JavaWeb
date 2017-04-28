package test;

import javax.xml.ws.Endpoint;

public class WebService {
    public static void main(String[] args) {
    	
        System.out.println("web service start");
        
        CalculatorServiceImpl implementor = new CalculatorServiceImpl();
        //����������ע�����Ѿ���������URL
        String address = "http://localhost:1230/calculator";
        
        Endpoint.publish(address, implementor);
        System.out.println("web service started");
    }
}