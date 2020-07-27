package practice11;


import java.text.MessageFormat;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String introduceMessage = null;
        if (this.klass.getLeader() == this) {
            introduceMessage = super.introduce()
                    .concat(
                            MessageFormat.format(
                                    " I am a Student. I am Leader of Class {0}.",
                                    this.klass.getNumber()
                            )
                    );
        } else {
            introduceMessage = super.introduce()
                    .concat(
                            MessageFormat.format(
                                    " I am a Student. I am at Class {0}.",
                                    this.klass.getNumber()
                            )
                    );
        }

        return introduceMessage;
    }
}
