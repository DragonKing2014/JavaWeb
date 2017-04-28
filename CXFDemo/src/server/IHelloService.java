package server;

import javax.jws.WebService;

/**
 * <p>
 * WebService½Ó¿Ú
 * </p>
 */
@WebService
public interface IHelloService {

    public String sayHello(String username);
    
}
