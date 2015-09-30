package Algorithms;

/**
 * Created by yuhua on 9/20/15.
 */
public class parameterTest {
    public static void main(String[] args){
        Dog my = new Dog("origin");
        changeName(my);
        System.out.println(my.name);
    }

    public static void changeName(Dog d){
        d=new Dog("new name");
    }

}

class Dog{
    String name;
    public Dog(String str){
        name=str;
    }
}
