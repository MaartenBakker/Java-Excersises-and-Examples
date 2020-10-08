public class AnotherClass {

    public String doSomething(String s1, String s2){
        System.out.println("The Another Class classes name is " + getClass().getSimpleName());

        return Main.doStringStuff((ss1, ss2)-> {

                System.out.println("The Lambda Expression classes name is " + getClass().getSimpleName());
                return ss1.toUpperCase()+ss2.toUpperCase();
        }, s1, s2);

    }
}
