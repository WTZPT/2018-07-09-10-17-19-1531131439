package practice10;


import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private  Student leader;
    private List<Student> studentList;
    public Klass(int number) {
        this.number = number;
        studentList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return "Class "+this.number;
    }

    public void assignLeader(Student student) {

        if(checkStudent(student)) {
            this.leader = student;
        } else {
            System.out.print("It is not one of us.");
        }
    }

    public  Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public void appendMember(Student student) {
        studentList.add(student);
    }

    private boolean checkStudent(Student student) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if(student.equals(this.studentList.get(i))) {
                return true;
            }
        }
        return false;
    }
}
