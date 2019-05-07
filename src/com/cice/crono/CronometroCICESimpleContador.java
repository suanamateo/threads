package com.cice.crono;

//Ejercicio

public class CronometroCICESimpleContador implements Runnable {

    @Override
    public void run() {

        int segundos = 0, minutos = 0, horas = 0;

        while(true){

            try {
                System.out.println(horas + ":" + minutos + ":" +  segundos);

                Thread.sleep(1000);
                // sumo segundos despues de parar el hilo 1000 milisegundos
                ++segundos;

                // si segundos llega a 59
                if(segundos == 60){
                    minutos++;
                    segundos = 0;

                    if(minutos == 60){
                        horas++;
                        minutos = 0;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}