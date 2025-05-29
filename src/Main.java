import java.util.Arrays;
import java.util.Scanner;

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
    public static void printSortedResults(String[][] results, int year) {
        // Sortieren des Arrays basierend auf der umgewandelten Laufzeit in Sekunden
        Arrays.sort(results, (a, b) -> Integer.compare(convertTimeToSeconds(a[1]), convertTimeToSeconds(b[1])));

        // Ausgabe der sortierten Liste mit Platzierungen
        System.out.println("Platzierung | Name | Laufzeit");
        for (int i = 0; i < results.length; i++) {
            String timeDisplay = results[i][1].isEmpty() ? "Keine Zeit" : results[i][1];
            System.out.printf("%d. Platz: %s - %s\n", i + 1, results[i][0], timeDisplay);
        }
    }

    /**
     * Main Methode zum starten der Anwendung
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Jahr eingeben (z. B. 2024 oder 2025): ");
        int year = scanner.nextInt();

        String[][] runners;
        switch (year) {
            case 2024:
                runners = Data2024.getRunners();
                break;
            case 2025:
                runners = Data2025.getRunners();
                break;
            default:
                System.out.println("Kein Datensatz für das Jahr " + year + " gefunden.");
                return;
        }

        printSortedResults(runners, year);
    }
}