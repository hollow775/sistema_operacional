package filosofos;


public class Filosofos implements Runnable {
    private Object garfoEsquerdo;
    private Object garfoDireito;

    public Filosofos(Object garfoEsquerdo, Object garfoDireito){
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }
    @Override
    public void run() {
        try {
            while (true) {

                // Pensando
                fazAcao(System.nanoTime() + ": Pensando");
                synchronized (garfoEsquerdo) {
                    fazAcao(
                            System.nanoTime()
                                    + ": Pegou o garfo esquerdo");
                    synchronized (garfoDireito) {
                        // eating
                        fazAcao(
                                System.nanoTime()
                                        + ": Pegou garfo direito - comendo");

                        fazAcao(
                                System.nanoTime()
                                        + ": Devolveu garfo direito");
                    }

                    // Back to thinking
                    fazAcao(
                            System.nanoTime()
                                    + ": Devolveu garfo esquerdo. Pensando...");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void fazAcao(String acao) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +""+acao);
        Thread.sleep((int)(Math.random()*100));
    }
}