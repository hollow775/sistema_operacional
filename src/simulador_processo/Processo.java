package simulador_processo;

public class Processo {
    int pid = 0;
    float tp = 0;
    float cp = 0;
    String ep = "Pronto";
    int nes = 0;
    int n_cpu = 0;

    float te = 0;
    public Processo(int pid, float tp, float cp, String ep, int nes, int n_cpu, float te){
        this.pid = pid;
        this.tp = tp;
        this.cp = cp;
        this.nes = nes;
        this.n_cpu = n_cpu;
        this.te = te;
    }
    public void imprimirProcesso(){
        System.out.println("PID: " + this.pid + "\nTP: " + this.tp + "\nCP: " +  this.cp +"\nEP: " +  this.ep +"\nNES: " +  this.nes +"\nN_CPU: " +  this.n_cpu +"\nTE: " +  this.te);
    }
    public void executando(){
        System.out.println(this.ep);
        this.ep = "Executando";
    }
    public void bloqueado(){
        System.out.println(this.ep);
        this.ep = "Bloqueado";
    }
    public void pronto(){
        System.out.println(this.ep);
        this.ep = "Pronto";
    }
    public void finalizado(){
        System.out.println(this.ep);
        this.ep = "Finalizado";
    }
    public int addNes(){
        return this.nes +=1;
    }
    public int reiniciarNes(){
        return this.nes = 0;
    }

    public float addTp(){
        return this.tp += 1;
    }
    public float addN_cpu(){
        return this.n_cpu += 1;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public float getTp() {
        return tp;
    }

    public void setTp(float tp) {
        this.tp = tp;
    }

    public float getCp() {
        return cp;
    }

    public void setCp(float cp) {
        this.cp = this.tp + 1;
    }

    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public int getNes() {
        return nes;
    }

    public void setNes(int nes) {
        this.nes = nes;
    }

    public int getN_cpu() {
        return n_cpu;
    }

    public void setN_cpu(int n_cpu) {
        this.n_cpu = n_cpu;
    }
    public float getTe() {
        return te;
    }

    public void setTe(float te) {
        this.te = te;
    }


}
