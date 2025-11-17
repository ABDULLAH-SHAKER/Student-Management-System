package models;

public class Teacher extends Person {
    private String teacherId;

    public Teacher(String name, int age, String teacherId) {
        super(name, age);
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "Teacher: " + name + " | Age: " + age + " | ID: " + teacherId;
    }
}
