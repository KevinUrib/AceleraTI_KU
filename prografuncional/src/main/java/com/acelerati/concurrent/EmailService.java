package com.acelerati.concurrent;

public class EmailService {

    public void sendEmail(){
        System.out.println("Empece a enviar el correo");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
        }
        System.out.println("Correo enviado exitosamente");
    }
}
