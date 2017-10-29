package chapter06;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class Decorators {

    @Test
    public void decoratorPatter() throws IOException {

        final File f = new File("out", "out.bin");
        final FileOutputStream fos = new FileOutputStream(f);
        final BufferedOutputStream bos = new BufferedOutputStream(fos);
        final ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeBoolean(true);
        oos.writeInt(42);
        oos.writeObject(new ArrayList<Integer>());

        oos.flush();
        oos.close();
        bos.close();
        fos.close();

        Assert.assertTrue(f.exists());
    }

}
