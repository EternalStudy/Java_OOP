package Home_work;

import java.io.IOException;
import java.io.Serializable;

public interface SaveRead{
    public void SaveTo(String obj, Object[] s) throws IOException;

    public Object LoadFrom(String obj, Object[] s) throws IOException, ClassNotFoundException;
}
