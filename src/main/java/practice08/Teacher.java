package practice08;


public class Teacher extends Person {
    private  Klass klass;


    public Teacher(int id, String name, int age,  Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public  Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce()+" I am a Teacher. " + (klass != null ? "I teach Class "+this.klass.getNumber()+"." : "I teach No Class.");
    }

    public String introduceWith(Student student) {
        if(student.getKlass().getNumber() == this.klass.getNumber()) {
            return super.introduce()+" I am a Teacher. "+"I teach "+ student.getName()+".";
        }
        return super.introduce()+" I am a Teacher. "+"I don't teach "+ student.getName()+".";
    }
}
