package A03_Monitor.exercicio1;


class Buffer {
    private final int max = 5;
    private String[] buffer = new String[max];
    private int indexAdd = 0;
    private int indexRemove = 0;

    synchronized String getBuffer() {
        int index = indexRemove;
        String ret = buffer[index];
        buffer[index] = null;
        indexRemove = (indexRemove + 1) % max;
        return ret;
    }

    synchronized void setBuffer(String buffer) {
        this.buffer[indexAdd] = buffer;
        indexAdd = (indexAdd + 1) % max;
    }

    synchronized boolean isEmpty() {
        return buffer[indexRemove] == null || buffer[indexRemove].equals("");
    }
}
