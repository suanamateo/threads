package com.cice.runneble;

public class CiceRunnable implements Runnable {
    @Override
    public void run() {

        try{
            long start = System.currentTimeMillis();
            int contador = 0;
            while(contador <= 10){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": " + (++contador) + " segundos");
            }
            long finalTime = System.currentTimeMillis() - start;
            System.out.println("Tiempo de ejecucion: " + finalTime/1000 + " segundos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

