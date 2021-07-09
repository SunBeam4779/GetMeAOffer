package yuhang.test.com;

import java.util.HashMap;

public class FindRedundantConnection {
    public static void main(String[] args) {
        int[][] data = new int[][]{{2,1}, {3,1}, {4,2},{1,4}}; // ,{1,4}}; //  , {4,1}, {1,5}};
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[] res = findRedundantConnection.findRedundantDirectedConnection(data);
        for (int item: res){
            System.out.println(item);
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();

        int row = edges.length;
        for (int[] edge : edges) {

            int countOfout = out.getOrDefault(edge[0], 0);
            out.put(edge[0], countOfout + 1);
            int countOfin = in.getOrDefault(edge[1], 0);
            in.put(edge[1], countOfin + 1);

        }
        int[] res = null;
        int count = 0;
        for(int i = row - 1; i >= 0; --i){
            if(in.get(edges[i][1]) == 1 && !out.containsKey(edges[i][1])) continue;
//            if(in.get(edges[i][1]) >= 2){
//                res = edges[i];
//                break;
//            }

            if(in.get(edges[i][1]) >= 1){
                if(in.get(edges[i][1]) > count) {
                    res = edges[i];
                    count = in.get(edges[i][1]);
                }
            }
        }
        return res;
    }
}
