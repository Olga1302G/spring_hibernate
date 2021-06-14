import java.io.*;
import java.util.Objects;

class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    public static Animal[] deserializeAnimalArray(byte[] data) throws EOFException {
        Animal[] animals = new Animal[0];
        int size = 0;

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            size = objectInputStream.readInt();
            animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }



        } catch (RuntimeException | IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return animals;//Твой код здесь
    }
    }

