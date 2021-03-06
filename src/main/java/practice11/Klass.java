package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> studentList;
    private List<TeacherWatcher> teacherWatcherList = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
        studentList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student student) {

        if (checkStudent(student)) {
            this.leader = student;
            hasStudentBecomeLeader(student, this.number);
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        studentList.add(student);
        hasStudentJoinClass(student, this.number);
    }

    private boolean checkStudent(Student student) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (student.equals(this.studentList.get(i))) {
                return true;
            }
        }
        return false;
    }

    protected void addTeacherWatcher(TeacherWatcher teacherWatcher) {
        this.teacherWatcherList.add(teacherWatcher);
    }

    private void hasStudentJoinClass(Student student, int classId) {
        teacherWatcherList.forEach(teacherWatcher -> teacherWatcher.hasStudentJoinClassResponse(student, classId));
    }

    private void hasStudentBecomeLeader(Student student, int classId) {
        teacherWatcherList.forEach(teacherWatcher -> teacherWatcher.hasStudentBecomeLeaderResponse(student, classId));
    }


}
