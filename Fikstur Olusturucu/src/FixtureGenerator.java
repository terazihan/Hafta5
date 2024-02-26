import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FixtureGenerator {
    private List<String> teams;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
    }

    public List<String> generateFixtures() {
        List<String> fixtures = new ArrayList<>();
        int numTeams = teams.size();
        boolean isEven = numTeams % 2 == 0;

        if (!isEven) {
            teams.add("Bay");
            numTeams++;
        }

        List<String> homeTeams = new ArrayList<>(teams.subList(0, numTeams / 2));
        List<String> awayTeams = new ArrayList<>(teams.subList(numTeams / 2, numTeams));

        for (int i = 0; i < numTeams - 1; i++) {
            fixtures.add("Round " + (i + 1));
            for (int j = 0; j < homeTeams.size(); j++) {
                String fixture = homeTeams.get(j) + " vs " + awayTeams.get(j);
                fixtures.add(fixture);
            }
            Collections.rotate(awayTeams, 1);
        }

        return fixtures;
    }

    public static void main(String[] args) {
        List<String> teams1 = new ArrayList<>();
        teams1.add("Galatasaray");
        teams1.add("Bursaspor");
        teams1.add("Fenerbahçe");
        teams1.add("Beşiktaş");
        teams1.add("Başakşehir");
        teams1.add("Trabzonspor");

        FixtureGenerator generator1 = new FixtureGenerator(teams1);
        List<String> fixtures1 = generator1.generateFixtures();

        System.out.println("Takım sayısı çift senaryosu\n");
        for (String fixture : fixtures1) {
            System.out.println(fixture);
        }

        List<String> teams2 = new ArrayList<>();
        teams2.add("Galatasaray");
        teams2.add("Bursaspor");
        teams2.add("Fenerbahçe");
        teams2.add("Beşiktaş");
        teams2.add("Başakşehir");
        teams2.add("Boluspor");
        teams2.add("Bay");

        FixtureGenerator generator2 = new FixtureGenerator(teams2);
        List<String> fixtures2 = generator2.generateFixtures();

        System.out.println("\nTakım sayısı tek senaryosu\n");
        for (String fixture : fixtures2) {
            System.out.println(fixture);
        }
    }
}
