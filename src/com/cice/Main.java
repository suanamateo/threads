package com.cice;

import com.cice.crono.CronometroCICESimpleContador;
import com.cice.crono.CronometroCICESincronizacion;
import com.cice.runneble.CiceRunnable;
import com.cice.threads.CiceThread;
import com.cice.threads.CiceThread2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Esto se ejecutara en 2º plano

        CiceThread ciceThread = new CiceThread();
        ciceThread.start();
        CiceThread2 ciceThread2 = new CiceThread2();
        ciceThread2.start();

        // Esto se ejecutara en 3er plano

        CiceRunnable ciceRunnable = new CiceRunnable();
        Thread hilo = new Thread(ciceRunnable);
        hilo.start();

        // Implementar con una expresión LAMBDA (Runnable)

        Thread hiloRunnable = new Thread(() -> {
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
        });
                hiloRunnable.start();

    // esto se ejecutara en 1er plano

          Thread.sleep(2000);
          System.out.println("Hola");
          Thread.sleep(1000);
          System.out.println("Que tal,");
          Thread.sleep(3000);
          System.out.println("Vamos a ver cuanto tarda en acabar el hilo paralelo");

        // Cronómetro

        CronometroCICESimpleContador cronometroCICE = new CronometroCICESimpleContador();
        Thread crono = new Thread(cronometroCICE);
        crono.start();

        // Parar el CRONÓMETRO

        CronometroCICESincronizacion cronometroCICESincronizacion = new CronometroCICESincronizacion();
        Thread cronometro = new Thread((Runnable) cronometroCICESincronizacion);
        cronometro.start();

        Thread hiloControl = new Thread(()->{

            try {
                while (true){
                    Thread.sleep(1000);
                    System.out.println(cronometroCICESincronizacion.isControl());
                    cronometroCICESincronizacion.setControl(!cronometroCICESincronizacion.isControl());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        hiloControl.start();

        // Para matar un hilo (hiloControl) y el otro hilo (crono) seguirá funcionando
        // Saliendo la excepción -

        Thread.sleep(5000);
        hiloControl.interrupt();

        // Matamos el otro hilo - (crono)

        crono.interrupt();

    }
}