public class Staff {
    private String name;
    private String surname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Staff(String name, String surname, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printStaff() {
        System.out.println(name + " " + surname + " " + position + " " + email + " " + phone + " " + salary + " " + age);
    }

    public static void main(String[] args) {
        Staff[] staffArray = new Staff[5];
        staffArray[0] = new Staff("Иван", "Петров", "Директор", "petrov_i@roga.ru", "89215468878", 100000, 37);
        staffArray[1] = new Staff("Егор", "Семёнов", "Бригадир", "semenov@roga.ru", "89116533255", 50000, 40);
        staffArray[2] = new Staff("Юлия", "Дебетова", "Бухгалтер", "debet@roga.ru", "89524565566", 50000, 41);
        staffArray[3] = new Staff("Сергей", "Хитров", "Программист", "hitrov@roga.ru", "89052236565", 100000, 27);
        staffArray[4] = new Staff("Василий", "Бобров", "Грузчик", "gruz@roga.ru", "89811154787", 40000, 47);

        for (int i = 0; i < staffArray.length; i++) {
            if (staffArray[i].age > 40) {
                staffArray[i].printStaff();
            }
        }
    }
}
