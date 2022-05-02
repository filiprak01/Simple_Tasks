import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int size = player.size();
        List<Integer> place = Arrays.asList(new Integer[size]);
        for (int j = size - 1; j >= 0; j--) {
            Integer ret = 1;
            int i = 0;
            boolean added = false;
            int position = player.get(j);
            int len = ranked.size();
            while (i < len) {
                if (position >= ranked.get(i)) {
                    place.set(j, ret);
                    added = true;
                    break;
                }
                while (i + 1 < len && ranked.get(i).intValue() == ranked.get(i + 1).intValue()) {
                    i++;
                }
                i++;
                ret++;
            }
            if (!added) {
                place.set(j, ret);
            }
        }
        return place;
    }


    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>();
        List<Integer> player = new ArrayList<>();
        ranked.add(100);
        ranked.add(100);
        ranked.add(50);
        ranked.add(40);
        ranked.add(40);
        ranked.add(20);
        ranked.add(10);
        player.add(5);
        player.add(25);
        player.add(50);
        player.add(120);
        ranked = climbingLeaderboard(ranked, player);
        for (Integer i : ranked
        ) {
            System.out.println(i);
        }
    }

}

