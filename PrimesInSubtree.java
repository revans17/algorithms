import java.util.*;

public class PrimesInSubtree{
     // Complete the primeQuery function below.
     static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
         //Output to return
         List<Integer> output = new ArrayList<>();
         //Count of primes
         List<Integer> count = new ArrayList<>();
         //List of indexs
         List<Integer> index = new ArrayList<>();
         //Check if the values are prime then put them in the count list
         for(int i = 0; i < values.size(); i++){

            count.add(i, isPrime(values.get(i)) ? 1 : 0);
         }
         //Set the indexes in the list
         for(int i = 0; i < n; i++){
            index.add(i, i);
         }
         //Account for the first and second list of values
         for(int i = 0; i < first.size(); i++){
            int idx = second.get(i) - 1;
            int val = first.get(i) - 1;
            //Remove the value at that index before you remove it
            index.remove(idx);
            //Add that value at the specific index
            index.add(idx, val);
         }
         //Fill in the number of primes
         for(int i = 0; i < n; i++){
            int place = i;
            //Loop thorugh and add to the count list
            while(index.get(place) != place){
                 place = index.get(place);
                 int temp = count.get(place) + count.get(i);
                 //remove the current list item after getting it in the calculation
                 count.remove(place);
                 count.add(place, temp);
            }
         }
         //Account for the queries
         for(int i = 0; i < queries.size(); i++){
            //Add them to the output
            output.add(i, count.get(queries.get(i)-1));
         }
         return output;
     }
     //Check to see if the value passed is prime
     public static boolean isPrime(int n){
         boolean check = false;
         if(n <= 3){ return true;}
         if(n % 2 == 0){ return false;}
         for(int i = 2; i * i <= n; i++){
            if(n % i == 0){ return false;}
         }
         return true;
     }
}
