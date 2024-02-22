package hw3;

public class Program {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        System.out.println(Calculator.sum(5,0.2));
        System.out.println(Calculator.multiply(5,0.2));
        System.out.println(Calculator.subtract(5,0.2));
        System.out.println(Calculator.divide(5,0.1));

        System.out.println("Task 2:");
        Cat[] cats = {new Cat("Barsik"), new Cat("Snowball")};
        Animal[] animals = {new Cat("Fatt"), new Cat("Rondo")};
        System.out.println(compareArrays(cats,animals));

        System.out.println("Task 3:");
        Pair<Integer,String> pair1 = new Pair<>(3,"three");
        System.out.println(pair1);
    }

    static <T1, T2> boolean compareArrays(T1[] arr1, T2[] arr2){
        if (arr1.length != arr2.length){
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++){
                if (arr1[i].getClass() != arr2[i].getClass()){
                    return false;
                }
            }
        }
        return true;
    }
}
