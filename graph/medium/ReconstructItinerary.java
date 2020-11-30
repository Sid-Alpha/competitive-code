package graph.medium;

import utils.info.NewAlgo;
import utils.info.UsedHints;

import java.util.*;

@UsedHints
@NewAlgo(details = "Eulerian Path")
public class ReconstructItinerary {

//    public static List<String> findItineraryDFS(List<List<String>> tickets) {
//        if(tickets == null || tickets.size() == 0) return Collections.emptyList();
//        LinkedList<String> path = new LinkedList<>();
//        int ticketCount = tickets.size();
//
//        HashMap<String, List<String>> graph = new HashMap<>();
//
//        for(List<String> ticket : tickets)
//            if(graph.containsKey(ticket.get(0))) graph.get(ticket.get(0)).add(ticket.get(1));
//            else graph.put(ticket.get(0), new ArrayList<>(Arrays.asList(ticket.get(1))));
//
//        graph.values().forEach(Collections::sort);
//        path.add("JFK");
//        dfs("JFK", graph, path, ticketCount,0);
//
//        return path;
//    }

    public static List<String> findItineraryEuler(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) graph.put(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> itinerary = new LinkedList<>();
        // euler path
        eulerPath("JFK", graph, itinerary);
//        Collections.reverse(itinerary);
        return itinerary;
    }

    private static void eulerPath(String node, HashMap<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> minPriority = graph.get(node);
        System.out.println(node);
        while (minPriority != null && !minPriority.isEmpty())
            eulerPath(minPriority.poll(), graph, itinerary);

        itinerary.add(0, node);
    }

    private static int dfs(String node, HashMap<String, List<String>> graph, LinkedList<String> itinerary, int totalTickets, int currentTickets) {
        if(!graph.containsKey(node)) return currentTickets;
        List<String> adjList = graph.get(node);
        for(int pos = 0; pos < adjList.size(); pos++) {
            String nextNode = adjList.get(pos);
            itinerary.add(nextNode);
            adjList.remove(pos);

            int t = dfs(nextNode, graph, itinerary, totalTickets, currentTickets+1);

            if(t == totalTickets) return totalTickets;
            itinerary.removeLast();
            adjList.add(pos, nextNode);
        }
        return currentTickets;
    }


    public static void main(String[] args) {
        List<List<String>> tickets1 = new ArrayList<>();
        tickets1.add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
        tickets1.add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
        tickets1.add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
        tickets1.add(new ArrayList<>(Arrays.asList("LHR", "SFO")));

//        System.out.println(Arrays.toString(findItineraryEuler(tickets1).toArray()));

        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(new ArrayList<>(Arrays.asList("JFK", "KUL")));
        tickets2.add(new ArrayList<>(Arrays.asList("JFK", "NRT")));
        tickets2.add(new ArrayList<>(Arrays.asList("NRT", "JFK")));

        System.out.println(Arrays.toString(findItineraryEuler(tickets2).toArray()));
    }
}
