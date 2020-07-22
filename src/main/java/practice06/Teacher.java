package practice06;

public class Teacher extends Person  {
    private int klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name,age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(int klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce()+" I am a Teacher. " + (klass != 0 ? "I teach Class "+this.klass+"." : "I teach No Class.");
    }

}
