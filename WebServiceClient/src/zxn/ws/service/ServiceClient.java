package zxn.ws.service;
import org.apache.cxf.endpoint.Client;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class ServiceClient {

	public static void main(String[] args) throws Exception {

		// �������������˽ӿ�����ɵ��õģ�Ҳ���ǲ������ܵ���Java�Ľӿ�
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory
				.newInstance();
		Client client = clientFactory
				.createClient("http://localhost:3307/CXFWS/services/Regedit?wsdl");
		Object[] result = client.invoke("regedit","Dragon","King");
		System.out.println(result[0]);

	}
}