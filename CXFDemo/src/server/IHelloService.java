package server;

import javax.jws.WebService;

/**
 * <p>
 * WebService�ӿ�
 * </p>
 */
@WebService
public interface IHelloService {

    public String sayHello(String username);
    
}
