package practice11;



import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

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
        String klassStr = "";
        if(classes.size() == 0) {
            return super.introduce()+" I am a Teacher. " +"I teach No Class.";
        }
        for(int i = 0; i < classes.size(); i++) {
            if(i != 0) {
                klassStr += ", ";
            }
            klassStr += classes.get(i).getNumber();
        }
        return super.introduce()+" I am a Teacher. " + (  "I teach Class "+klassStr+"." );
    }

    public String introduceWith( Student student) {
        for( Klass klass : classes) {
            if(student.getKlass().getNumber() == klass.getNumber()) {
                return super.introduce()+" I am a Teacher. "+"I teach "+ student.getName()+".";
            }
        }

        return super.introduce()+" I am a Teacher. "+"I don't teach "+ student.getName()+".";
    }

    public boolean isTeaching( Student student){
        return isIn(student);

    }

    private boolean isIn( Student student) {
        for (Klass klass : classes){
            if(klass.getNumber() == student.getKlass().getNumber()){
                return true;
            }
        }
        return false;
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
