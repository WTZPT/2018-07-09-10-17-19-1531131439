package practice11;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements TeacherWatcher{

    private List<Klass> classes;

    public Teacher(int id, String name, int age,  List< Klass> klass) {
        super(id, name, age);
        this.classes = klass;
        klass.forEach(klasss -> klasss.addTeacherWatcher(this));
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new ArrayList<>();
    }

    public  List< Klass> getClasses() {
        return classes;
    }

    public void setClasses(List< Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        String introduceMsg = super.introduce();
        StringBuilder klassStr = new StringBuilder("");
        if(classes.size() == 0) {
            return introduceMsg.concat(" I am a Teacher. I teach No Class.");
        }
        for(int i = 0; i < classes.size(); i++) {
            if(i != 0) {
                klassStr.append(", ") ;
            }
            klassStr.append( classes.get(i).getNumber());
        }

        Integer[] list =    classes.stream().map(Klass::getNumber).toArray(Integer[]::new);

        return introduceMsg.concat(MessageFormat.format(" I am a Teacher. I teach Class {0}.",klassStr));
    }

    public String introduceWith( Student student) {

        return isIn(student) ? super.introduce().concat(MessageFormat.format(" I am a Teacher. I teach {0}.",student.getName())) : super.introduce().concat(" I am a Teacher. I don't teach ").concat(MessageFormat.format("{0}.",student.getName()));
    }

    public boolean isTeaching( Student student){
        return isIn(student);

    }

    private boolean isIn( Student student) {

        return classes.stream().anyMatch(o -> o.getNumber() == student.getKlass().getNumber());
    }

    @Override
    public void hasStudentJoinClassResponse(Student student,int classId) {
        String str = MessageFormat.format(
                "I am {0}. I know {1} has joined Class {2}.\n",
                getName(),student.getName(),classId
        );

        System.out.print(str);
    }

    @Override
    public void hasStudentBecomeLeaderResponse(Student student,int classId) {
        System.out.print(MessageFormat.format(
                "I am {0}. I know {1} become Leader of Class {2}.\n",
                getName(),student.getName(),classId
        ));
    }
}
