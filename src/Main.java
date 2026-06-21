import java.util.*;

public class Main {

    /**
     * Konvertiert eine Zeitangabe im Format hh:mm:ss in die Gesamtanzahl der Sekunden.
     * @param time Die Zeit als String im Format hh:mm:ss.
     * @return Die Gesamtanzahl der Sekunden als int, oder Integer.MAX_VALUE wenn die Zeitangabe leer oder ungültig ist.
     */
    private static int convertTimeToSeconds(String time) {
        if (time == null || time.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        try {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            return hours * 3600 + minutes * 60 + seconds;
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * Druckt die Namen und Laufzeiten sortiert nach der Laufzeit mit Platzierung.
     *
     * @param results Ein 2D-Array, wobei jedes Element ein Array der Form {Name, Laufzeit} ist.
     * @param year
     */
    public static void printSortedResults(String[][] results, String year) {
        // Sortieren des Arrays basierend auf der umgewandelten Laufzeit in Sekunden
        Arrays.sort(results, (a, b) -> Integer.compare(convertTimeToSeconds(a[1]), convertTimeToSeconds(b[1])));

        // Ausgabe der sortierten Liste mit Platzierungen
        System.out.println("Platzierung | Name | Laufzeit");
        for (int i = 0; i < results.length; i++) {
            String timeDisplay = results[i][1].isEmpty() ? "Keine Zeit" : results[i][1];
            System.out.printf("%d. Platz: %s - %s\n", i + 1, results[i][0], timeDisplay);
        }
    }

    public static void printAllParticipants() {
        Map<Integer, String[][]> data = new HashMap<>();

        data.put(2024, Data2024.getRunners());
        data.put(2025, Data2025.getRunners());
        data.put(2026, Data2026.getRunners());

        Map<String, Set<Integer>> result =
                RunnerAnalyzer.analyzeRunners(data);

        RunnerAnalyzer.printResult(result);
    }

    /**
     * Main Methode zum starten der Anwendung
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Jahr eingeben (2024, 2025, 2026): ");
        String input = scanner.next();

        String[][] runners;
        switch (input) {
            case "2024":
                System.out.println("Firmenlauf Eibelstadt am 8. Mai 2024 - 6,5km");
                runners = Data2024.getRunners();
                break;
            case "2025":
                System.out.println("Firmenlauf Eibelstadt am 28. Mai 2025 - 6,5km");
                runners = Data2025.getRunners();
                break;
            case "2026":
                System.out.println("3. WVV Energie Firmenlauf Würzburg am 18. Juni 2026 - 8,5km");
                runners = Data2026.getRunners();
                break;
            case "Runners":
                printAllParticipants();
                runners = new String[][]{new String[]{"Merget Paul"}, new String[]{"0:00:00"}};
                break;
            default:
                System.out.println("Kein Datensatz für das Jahr " + input + " gefunden.");
                return;
        }

        if(!"Runners".equals(input)) {
            printSortedResults(runners, input);
        }
    }
}