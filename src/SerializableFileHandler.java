import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableFileHandler {
    private String path;

    public SerializableFileHandler(String path) {
        this.path = path;
    }

    public void write(Serializable obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
}
