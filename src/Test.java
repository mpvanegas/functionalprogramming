import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Shirt> shirts = new ArrayList<>();

        shirts.add(new Shirt("RED","XL"));
        shirts.add(new Shirt("RED","XL"));
        shirts.add(new Shirt("RED","XS"));
        shirts.add(new Shirt("BLUE","XL"));
        shirts.add(new Shirt("BLUE","XS"));

        String wantedColor = "RED";
        String wantedSize = "XL";

        List<Shirt> redShirts = filter(shirts, (Shirt s) -> wantedColor.equals(s.getColor()) && wantedSize.equals(s.getSize()));
//        List<Shirt> redXLShirts = filter(redShirts, (Shirt s) -> wantedSize.equals(s.getSize()));

        System.out.println(shirts.size());
        System.out.println(redShirts.size());
    //    System.out.println(redXLShirts.size());

        TakeTwo mySum = sum();
        int res = mySum.test(3,1);
        System.out.println(res);

        TakeTwo myRest = rest();
        int res1 = myRest.test(3,1);
        System.out.println(res1);
    }

    static TakeTwo sum(){
        return (a ,b) -> a + b;
    }

    static TakeTwo rest(){
        return (a, b) -> a - b;
    }

    public static List<Shirt> filter(List<Shirt> shirts, ShirtPredicate predicate){
        List<Shirt> filteredShirts = new ArrayList<>();
        for(Shirt shirt : shirts){
            if(predicate.test(shirt)){
                filteredShirts.add(shirt);
            }
        }
        return filteredShirts;
    }
}