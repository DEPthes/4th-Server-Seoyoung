package week1;

class Person {
    String name;
    int age;
    static int personCount = 0;

    public void introduce() {
//        System.out.println("이름: " + name);
//        System.out.println("나이: " + age);
        System.out.println("사람입니다.");
    }

    public static void printPersonCount() {
        System.out.println(personCount);
    }

    public void setName(String name) {
        this.name = name;
        //this.name은 인스턴스 변수 name을 가리킴.
        //name은 전달값으로 받은 name을 가리킴.
    }


    Person(String name, int age) { //생성자
        this.name = name;
        this.age = age;
        // 전달받은 name, age로 초기화.
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

enum Gender {// 열거형
    MALE,
    FEMALE
}

//상속
 class Student extends Person {
    String school;
    public void introduce() {
        System.out.println("학생입니다.");
    }
    Student(int age, String school) {
        super(age);//Person 클래스의 생성자로 정의.
        this.school = school;//Student 클래스의 생성자로 정의.
    }
}
public class ClassExample {
    public static void main(String[] args) {
        Person person = new Person("서영",12);
        person.introduce();

        person.age = 20;//인스턴스 변수 접근
        Person.personCount = 10; //클래스 변수 접근
        Person.printPersonCount();

        person.setName("철수");
        person.introduce();

        person.setAge(23); //값 설정하기(setter)
        System.out.println(person.getAge());// 값 가져오기(getter)

        person.setGender(Gender.MALE);//MALE,FEMALE
        switch (person.gender) {
            case MALE:
                System.out.println("남자");
                break;
            case FEMALE:
                System.out.println("여자");
                break;
        }
    }
}

