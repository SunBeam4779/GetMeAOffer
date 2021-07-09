package yuhang.test.com;

import java.util.ArrayList;
import java.util.List;

public class FindItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("ATL");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO");
        ticket3.add("ATL");
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL");
        ticket4.add("JFK");
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ATL");
        ticket5.add("SFO");
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        FindItinerary findItinerary = new FindItinerary();
        List<String> result = findItinerary.findItinerary(tickets);
        for(String item: result){
            System.out.print(item + " ");
        }
    }
    List<String> result = new ArrayList<>();
    String from = "JFK";
    public List<String> findItinerary(List<List<String>> tickets) {

        List<Integer> index = getTo(from, tickets);
        int target = index.get(0);
        if(index.size() > 1){

            for(int i = 1; i < index.size(); i++){
                if(tickets.get(index.get(i)).get(1).compareTo(tickets.get(target).get(1)) < 0){
                    target = index.get(i);
                }
            }
        }
        result.add(from);
        from = tickets.get(target).get(1);
        if(tickets.size() == 1) {
            result.add(from);
            return result;
        }
        tickets.remove(target);
        return findItinerary(tickets);
    }
    public List<Integer> getTo(String from, List<List<String>> tickets){
        List<Integer> indexs = new ArrayList<>();
        for(int i = 0; i < tickets.size(); i++){
            if(tickets.get(i).get(0).equals(from)){
                indexs.add(i);
            }
        }
        return indexs;
    }
}
