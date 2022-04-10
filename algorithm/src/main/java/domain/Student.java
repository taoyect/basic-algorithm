package domain;

import lombok.experimental.SuperBuilder;

import java.util.Objects;

@SuperBuilder
public class Student implements Comparable<Student> {
    private String name;
    private int score;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s, socre:%d)", name, score);
    }
}
