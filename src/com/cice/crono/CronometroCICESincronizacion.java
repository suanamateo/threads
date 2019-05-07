package com.cice.crono;

// Ejercicio de Sincronización de Hilos

public class CronometroCICESincronizacion implements Runnable {

    private volatile boolean control = true;
    public int segundos = 0, minutos = 0, horas = 0;

    @Override
    public void run() {

        while (true){
            if(control)
            try {
                System.out.println(horas + ":" + minutos + ":" + segundos);

                Thread.sleep(1000);
                //sumo segundos después de para el hilo 1000 milisegundos
                ++segundos;

                //Si segundos llega a 59
                if (segundos == 60){
                    minutos++;
                    segundos = 0;
                }
                if (minutos == 60){
                    horas++;
                    minutos = 0;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }
}



