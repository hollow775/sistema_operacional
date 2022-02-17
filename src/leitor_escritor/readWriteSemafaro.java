package leitor_escritor;
import java.util.concurrent.*;
class Shared{
    static int count = 0;
}
class ProcessadorThread extends Thread{
    Semaphore semaphore;
    String threadNome;
    public ProcessadorThread(Semaphore semaphore, String threadNome){
        super(threadNome);
        this.semaphore = semaphore;
        this.threadNome = threadNome;
    }
    @Override
    public void run(){
        //thread A
        System.out.println("Iniciando: "+threadNome);
        if (this.getName().equals("A")){
            try {
                //primeiramente o thread espera a permissão até a conseguir
                System.out.println(threadNome + " esperando permissão");
                semaphore.acquire();
                System.out.println(threadNome + " ganhou permissão");

                //Ao acessar o recurso compartilhado o for é executado
                //outros threads ficam esperando até ser liberado
                for (int i = 0; i < 5; i++) {
                    Shared.count++;
                    System.out.println("Contagem: " + threadNome + "->" + Shared.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }
            //libera o permit para outro thread poder usar o recurso
            System.out.println(threadNome + " liberado");
            semaphore.release();
        }
        //thread B
        else{
            System.out.println("Iniciando: "+threadNome);
            try{
                System.out.println(threadNome + " esperando permissão");
                semaphore.acquire();
                System.out.println(threadNome + " ganhou permissão");

                for(int i=0; i<5; i++){
                    Shared.count--;
                    System.out.println("Contagem: "+threadNome + "->" + Shared.count);
                    Thread.sleep(10);
                }
            }catch (InterruptedException exception){
                System.out.println(exception);
            }
            System.out.println(threadNome + " liberado");
            semaphore.release();
        }
    }
}

public class readWriteSemafaro {
    public static void main(String[]args) throws InterruptedException {
        //criando um objeto semáfaro, com somente 1 permit(quantidade de thread que pode usar o recurso ao mesmo tempo)
        Semaphore semaphore = new Semaphore(1);

        //criando nossos threads
        ProcessadorThread processadorThread1 = new ProcessadorThread(semaphore, "A");
        ProcessadorThread processadorThread2 = new ProcessadorThread(semaphore, "B");

        //iniciado os threads
        processadorThread1.start();
        processadorThread2.start();

        //esperando os threads
        processadorThread1.join();
        processadorThread2.join();

        System.out.println("Contagem"+Shared.count);
    }
}
