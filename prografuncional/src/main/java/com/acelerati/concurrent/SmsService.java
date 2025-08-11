package com.acelerati.concurrent;

public class SmsService {

    public void sendSms(){
        System.out.println("Mensaje de texto se enviara");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        System.out.println("Mensaje de texto enviado exitosamente");
    }
}
