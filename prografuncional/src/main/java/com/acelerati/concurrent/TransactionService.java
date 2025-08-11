package com.acelerati.concurrent;

public class TransactionService {

    private final EmailService emailService = new EmailService();
    private final SmsService smsService = new SmsService();

    public void doTransaction(){
        System.out.println("Transaccion exitosa");

        Thread t1 = new Thread(() -> {
            emailService.sendEmail();
        });
        Thread t2 = new Thread(() -> {
            smsService.sendSms();
        });

        t1.start();
        t2.start();

        System.out.println("Notificacion exitosa");
    }

}
