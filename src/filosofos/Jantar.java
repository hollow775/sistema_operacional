package filosofos;

public class Jantar {
    public static void main(String[] args){
        Filosofos[] filosofos = new Filosofos[5];
        Object[] garfos = new Object[filosofos.length];

        for(int i = 0; i< garfos.length; i++){
            garfos[i] = new Object();
        }

        for(int i=0; i<filosofos.length; i++){
            Object garfoEsquerdo = garfos[i];
            Object garfoDireito = garfos[(i+1)%garfos.length];

            if(i == filosofos.length -1 ) {
                filosofos[i] = new Filosofos(garfoDireito, garfoEsquerdo);
            }else {
                filosofos[i] = new Filosofos(garfoEsquerdo, garfoDireito);
            }

            Thread thread = new Thread(filosofos[i], "Filosofo["+(i+1)+"]");
            thread.start();
        }
    }
}
