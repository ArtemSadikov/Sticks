package com.sticks.worker;

import com.sticks.service.SticksService;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import static constants.Constants.*;

public class SticksServiceWorker {
    public static void main(String[] args) {
        try {
            System.out.print("Enter board size (must be greater than 3): ");
            final int size = new Scanner(System.in).nextInt();
            final SticksService server = new SticksService(size);
            System.out.println("Initializing " + SERVICE_NAME);

            final Registry registry = LocateRegistry.createRegistry(SERVICE_PORT_PUBLISH);
            final Remote stub = UnicastRemoteObject.exportObject(server, SERVICE_PORT_PUBLISH);
            registry.bind(SERVICE_NAME, stub);

            System.out.println("Service \"" + SERVICE_NAME + "\" has started!");
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Remote exception acquired: " + e.getMessage());
            System.exit(1);
        }
    }
}
