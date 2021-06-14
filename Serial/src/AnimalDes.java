import java.io.*;

public class AnimalDes {
    public static void main(String[] args) throws IOException {
        Animal[] animals = new Animal[10];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Animal("This is animal #" + i);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try (ObjectOutputStream stream = new ObjectOutputStream(bos)) {
            stream.writeInt(animals.length);
            for (int i = 0; i < animals.length; i++) {
                stream.writeObject(animals[i]);
            }
        } catch (IOException e) {
            System.out.println("Exception was created during writing some animal");
        } finally {
            bos.close();
        }

        byte[] data = bos.toByteArray();
        Animal[] deSerAnimals = deserializeAnimalArray(data);
        for (Animal s : deSerAnimals) {
            System.out.println(s);
        }

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = new Animal[0];
        int size = 0;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            size = objectInputStream.readInt();
            animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
            objectInputStream.close();

        } catch (EOFException e) {
            throw new java.lang.IllegalArgumentException();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
        } catch (ClassCastException e) {

        } catch (NegativeArraySizeException e) {
            throw new java.lang.IllegalArgumentException();
    } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
        return animals;
    }
}
