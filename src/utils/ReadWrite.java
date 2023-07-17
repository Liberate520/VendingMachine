package utils;
import java.io.IOException;
import java.io.Serializable;

public interface ReadWrite {
    void write(Serializable obj) throws IOException;

    Object read() throws IOException, ClassNotFoundException;
}
