package week1;

class Person {
    String name;
    int age;
    static int personCount = 0;

    public void introduce() {
//        System.out.println("�̸�: " + name);
//        System.out.println("����: " + age);
        System.out.println("����Դϴ�.");
    }

    public static void printPersonCount() {
        System.out.println(personCount);
    }

    public void setName(String name) {
        this.name = name;
        //this.name�� �ν��Ͻ� ���� name�� ����Ŵ.
        //name�� ���ް����� ���� name�� ����Ŵ.
    }


    Person(String name, int age) { //������
        this.name = name;
        this.age = age;
        // ���޹��� name, age�� �ʱ�ȭ.
    }

    public int getAge() { //getter
        return age;
    }

    public void setAge(int age) {//setter
        this.age = age;
    }

    Person(int age) {
        this.age = age;
    }

    Gender gender;
    public void setGender(Gender gender) {
        this.gender = gender;
    }

}

enum Gender {// ������
    MALE,
    FEMALE
}

//���
 class Student extends Person {
    String school;
    public void introduce() {
        System.out.println("�л��Դϴ�.");
    }
    Student(int age, String school) {
        super(age);//Person Ŭ������ �����ڷ� ����.
        this.school = school;//Student Ŭ������ �����ڷ� ����.
    }
}
public class ClassExample {
    public static void main(String[] args) {
        Person person = new Person("����",12);
        person.introduce();

        person.age = 20;//�ν��Ͻ� ���� ����
        Person.personCount = 10; //Ŭ���� ���� ����
        Person.printPersonCount();

        person.setName("ö��");
        person.introduce();

        person.setAge(23); //�� �����ϱ�(setter)
        System.out.println(person.getAge());// �� ��������(getter)

        person.setGender(Gender.MALE);//MALE,FEMALE
        switch (person.gender) {
            case MALE:
                System.out.println("����");
                break;
            case FEMALE:
                System.out.println("����");
                break;
        }
    }
}

