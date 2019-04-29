package sinalizacao;

public class Monitor {
    private Buffer buffer = new Buffer();

    String consumir() {
        synchronized (this) {
            while (buffer.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notifyAll();
            return buffer.getBuffer();
        }
    }

    void produzir(String msg){
        synchronized (this){
            while (!buffer.isEmpty()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.setBuffer(msg);
            notifyAll();
        }
    }
}
