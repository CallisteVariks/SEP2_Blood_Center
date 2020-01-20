package Singleton;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Ghost on 09/11/2016.
 */
public class SingletonRegistry implements Serializable {

    private static SingletonRegistry ourInstance;
    private Registry temp;

    /**
     * Zero-argument Constructor initializing the Registry
     *
     * @throws RemoteException
     */
    private SingletonRegistry() throws RemoteException {
        temp = LocateRegistry.createRegistry(1099);
    }

    /**
     * returns an instance of this and if instanc = null,initializes it as a new instance
     *
     * @return SingletonRegistry instance
     * @throws RemoteException
     */
    public static SingletonRegistry getInstance() throws RemoteException {
        if (ourInstance == null) {
            ourInstance = new SingletonRegistry();
        }
        return ourInstance;
    }

    /**
     * gets the instance
     *
     * @return Registry
     */
    public Registry getRegistry() {
        return temp;
    }
}
