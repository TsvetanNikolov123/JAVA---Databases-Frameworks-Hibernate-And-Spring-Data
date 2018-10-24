package p05_SayHelloExtend;

public class Chinese extends BasePerson implements Person {

    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello(){
        return "Djydjydjy";
    }
}
