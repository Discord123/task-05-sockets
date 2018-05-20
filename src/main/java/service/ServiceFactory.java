package service;

import service.impl.ServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final Service service = new ServiceImpl();

    private ServiceFactory() {
    }

    public Service getService() {
        return service;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
