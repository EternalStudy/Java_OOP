package Home_work;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements SaveRead, Serializable  {

    public void SaveTo(FamilyTree tree, Object[] s) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(s[0].toString()));
                objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }
    public Object LoadFrom(Object[] s) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(s[0].toString()));
                Object result = objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
	@Override
	public Object LoadFrom(String obj, Object[] s) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'LoadFrom'");
	}
	@Override
	public void SaveTo(String obj, Object[] s) throws IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'SaveTo'");
	}
}
