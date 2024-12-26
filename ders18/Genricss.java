
public class Genricss {

    public static void main(String[] args) {
        GenericHolder<String> myHolder = new GenericHolder();

        myHolder.val = "naber";

        GenericHolder<Boolean> myHolder3 = new GenericHolder();
        myHolder3.val = true;

        GenericHolder<Integer> myHolder2 = new GenericHolder();
        myHolder2.val = 19;

        GenericHolder<Mahmut> myHolder5Holder = new GenericHolder();

    }
}

class GenericHolder<Type> {
    public Type val;
}

class Mahmut {

}