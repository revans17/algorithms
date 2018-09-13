import java.util.*;
public class electionWinner{
     // Complete the electionWinner function below.
     static String electionWinner(String[] votes) {
         //Create a HashMap to store all names so they do not repeat
         Map<String, Integer> votersAndVotes = new TreeMap<>(Collections.reverseOrder());
         //Loop through the intput array of votes
         for(int i = 0; i < votes.length; i++){
            //Check to see if the map has that name already
            if(votersAndVotes.containsKey(votes[i])){
                 //If it does then add one to the number of votes to that name
                 votersAndVotes.put(votes[i], votersAndVotes.get(votes[i])+1);
            }else{
                 //If not put the name and a vote in there
                 votersAndVotes.put(votes[i], 1);
            }
         }
         //Get the max value and return the key matching that value
         return (Collections.max(votersAndVotes.entrySet(), Map.Entry.comparingByValue()).getKey());
     }
}
