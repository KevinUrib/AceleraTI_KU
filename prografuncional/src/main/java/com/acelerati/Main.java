package com.acelerati;

import com.acelerati.concurrent.Inventario;

public class Main {
    public static void main(String[] args) {
        //TransactionService transactionService = new TransactionService();
        //transactionService.doTransaction();
        //System.out.println("Proceso de transaccion finalizado");

        //Thread thread = new Thread();
        //thread.start();
        //System.out.println("Hilo iniciado");

        Inventario inventario = new Inventario(0);
        Thread compra1 = new Thread( 
            () -> inventario.comprar(10)
        );
        Thread compra2 = new Thread( 
            () -> inventario.comprar(20)
        );
        Thread compra3 = new Thread( 
            () -> inventario.comprar(30)
        );

        Thread abastece1 = new Thread( 
            () -> inventario.abastecer(15)
        );
        Thread abastece2 = new Thread( 
            () -> inventario.abastecer(25)
        );
        Thread abastece3 = new Thread( 
            () -> inventario.abastecer(50)
        );

        compra1.start();
        abastece1.start();

        compra2.start();
        abastece2.start();

        compra3.start();
        abastece3.start();
    }
}