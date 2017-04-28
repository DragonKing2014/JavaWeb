package zxn.ws.service;
import org.apache.cxf.endpoint.Client;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class ServiceClient {

	public static void main(String[] args) throws Exception {

		// 不依赖服务器端接口来完成调用的，也就是不仅仅能调用Java的接口
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory
				.newInstance();
		Client client = clientFactory
				.createClient("http://localhost:3307/CXFWS/services/Regedit?wsdl");
		Object[] result = client.invoke("regedit","Dragon","King");
		System.out.println(result[0]);

	}
}