public class AnimalLaif {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        System.out.println("totalAnimal: " + animal1.getTotalAnimal());
        animal1.printInfo();

        Animal animal2 = new Animal("a2", 5);
        System.out.println("totalAnimal: " + animal2.getTotalAnimal());
        animal2.printInfo();

        Animal a3 = new Animal("a3");
        System.out.println("totalAnimal: " + a3.getTotalAnimal());
        a3.printInfo();

        Animal a4;
        Dog d = new Dog("a4");
        a4 = d;
        System.out.println("totalAnimal: " + a4.getTotalAnimal());
        System.out.println("totalDog: " + a4.run(300));
        a4.printInfo();

        Dog dog1 = new Dog();
        System.out.println("totalAnimal: " + dog1.getTotalAnimal());
        System.out.println("totalDog: " + dog1.getTotalDog());

        Dog dog2 = new Dog("d2", 8, 5);
        System.out.println("totalAnimal: " + dog2.getTotalAnimal());
        System.out.println("totalDog: " + dog2.getTotalDog());
        dog2.printInfo();

        Animal cat1 = new Cat();
        System.out.println("totalAnimal: " + cat1.getTotalAnimal());
        System.out.println(cat1.getClass());

        Cat cat2 = new Cat("c2", 3, 4);
        System.out.println("totalAnimal: " + cat2.getTotalAnimal());
        System.out.println("totalCat: " + cat2.getTotalCat());
    }
}
