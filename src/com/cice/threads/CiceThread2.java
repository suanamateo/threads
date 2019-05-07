package com.cice.threads;

public class CiceThread2 extends Thread{

    @Override
    public void run() {
        try{
            long start = System.currentTimeMillis();
            int contador = 0;
            while(contador <= 20){
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ": " + (contador+=2) + " segundos");
            }
            long finalTime = System.currentTimeMillis() - start;
            System.out.println("Tiempo de ejecucion: " + finalTime/1000 + " segundos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}