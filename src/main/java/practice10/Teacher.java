package practice10;


import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private List<Klass> classes;


    public Teacher(int id, String name, int age,  List<Klass> klass) {
        super(id, name, age);
        this.classes = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new ArrayList<>();
    }

    public  List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
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

    public String introduceWith(Student student) {
        for(Klass klass : classes) {
            if(student.getKlass().getNumber() == klass.getNumber()) {
                return super.introduce()+" I am a Teacher. "+"I teach "+ student.getName()+".";
            }
        }

        return super.introduce()+" I am a Teacher. "+"I don't teach "+ student.getName()+".";
    }

    public boolean isTeaching(Student student){
        return isIn(student);

    }

    private boolean isIn(Student student) {
        for (Klass klass : classes){
            if(klass.getNumber() == student.getKlass().getNumber()){
                return true;
            }
        }
        return false;
    }
}
