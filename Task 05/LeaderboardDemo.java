import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Team {

    final String name;
    final int points;
    final int goalDiff;

    Team(String name, int points, int goalDiff) {
        this.name = name;
        this.points = points;
        this.goalDiff = goalDiff;
    }

    @Override
    public String toString() {
        return name + " (" + points + ", " + goalDiff + ")";
    }
}

class Leaderboard<T> {

    private final List<T> items = new ArrayList<>();
    private final Comparator<? super T> order;

    Leaderboard(Comparator<? super T> order) {
        this.order = order;
    }

    void add(T item) {
        items.add(item);
    }

    List<T> ranking() {

        // Create a new copy so the original list is not modified
        List<T> sortedItems = new ArrayList<>(items);

        // Sort using the given comparator
        sortedItems.sort(order);

        return sortedItems;
    }
}

public class LeaderboardDemo {

    public static void main(String[] args) {

        Comparator<Team> teamOrder =
                Comparator.comparingInt((Team t) -> t.points)
                        .reversed()
                        .thenComparing(
                                Comparator.comparingInt(
                                        (Team t) -> t.goalDiff)
                                        .reversed()
                        )
                        .thenComparing(t -> t.name);

        Leaderboard<Team> leaderboard =
                new Leaderboard<>(teamOrder);

        leaderboard.add(new Team("Lions", 20, 10));
        leaderboard.add(new Team("Tigers", 20, 8));
        leaderboard.add(new Team("Eagles", 18, 12));
        leaderboard.add(new Team("Panthers", 20, 10));
        leaderboard.add(new Team("Bulls", 15, 5));

        System.out.println("=== TEAM LEADERBOARD ===");

        int rank = 1;

        for (Team team : leaderboard.ranking()) {
            System.out.println(rank + ". " + team);
            rank++;
        }
    }
}