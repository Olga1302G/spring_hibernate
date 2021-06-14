import java.util.*;
import java.util.stream.Collectors;

public class LessOne {
    public static class Animal {
        private final String name;
        private final int age;
        private AnimalType animalType;

        public Animal(String name, int age, AnimalType animalType) {
            this.name = name;
            this.age = age;
            this.animalType = animalType;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public AnimalType getAnimalType() {
            return animalType;
        }

        public void setAnimalType(AnimalType animalType) {
            this.animalType = animalType;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", animalType=" + animalType +
                    '}';
        }
    }

    public enum AnimalType {
        HERBIVORE, PREDATOR, OMNIVORUS;
    }

    public static void main(String[] args) {
        List <Animal> animals = get();
        List <Animal> predator = animals.stream()
                .filter(animal -> animal.getAnimalType().equals(AnimalType.PREDATOR))
                .collect(Collectors.toList());
        //predator.forEach(System.out::println);
        List <Animal> ageAnimal = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge)
                        .thenComparing(Comparator.comparing(Animal::getName)).reversed())
                .collect(Collectors.toList());
        //ageAnimal.forEach(System.out::println);
        /* Map <AnimalType, List<Animal>> animalTypeListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getAnimalType));
         animalTypeListMap.forEach(((animalType, animalList) -> {
             System.out.println(animalType);
             animalList.forEach(System.out::println);
             System.out.println();
         }));*/
         Optional <String> art = animals.stream()
                 .filter(animal -> animal.animalType.equals(AnimalType.PREDATOR))
                 .max(Comparator.comparing(Animal::getAge))
                 .map(Animal::getName);
         art.ifPresent(System.out::println);
        //System.out.println(anyMath);


    }
    private static List<Animal> get () {
        return List.of(
                new Animal("Cat", 6, AnimalType.PREDATOR),
                new Animal("Lion", 21, AnimalType.PREDATOR),
                new Animal("Rabbit ", 3, AnimalType.HERBIVORE),
                new Animal("Delphin", 16, AnimalType.OMNIVORUS),
                new Animal("Gibon", 66, AnimalType.OMNIVORUS)
        );
    }
}
