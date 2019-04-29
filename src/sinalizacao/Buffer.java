package sinalizacao;

public class Buffer {
    private String buffer;
    private boolean empty = true;

    public synchronized String getBuffer() {
        this.empty= true;
        return buffer;
    }

    public synchronized void setBuffer(String buffer) {
        this.buffer = buffer;
        this.empty = false;
    }

    public boolean isEmpty() {
        return empty;
    }
}
