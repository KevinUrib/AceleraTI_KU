package com.acelerati.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Inventario {

    private AtomicInteger stock = new AtomicInteger();
    
    public Inventario(int stock) {
        this.stock = new AtomicInteger(stock);
    }

    

    public void comprar(int cantidad){
        if(stock.get() < cantidad) {
            System.out.println("No hay suficiente stock para completar la compra.");
            return;
        }
        this.stock.addAndGet(-cantidad);
        System.out.println("Se ha comprado " + cantidad + " unidades. Stock actual: " + stock.get());
    }

    public void abastecer(int cantidad){
        this.stock.addAndGet(cantidad);
        System.out.println("Se ha abastecido " + cantidad + " unidades. Stock actual: " + stock);
    }

}
