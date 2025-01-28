import java.util.Arrays;

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
     * @param results Ein 2D-Array, wobei jedes Element ein Array der Form {Name, Laufzeit} ist.
     */
    public static void printSortedResults(String[][] results) {
        // Sortieren des Arrays basierend auf der umgewandelten Laufzeit in Sekunden
        Arrays.sort(results, (a, b) -> Integer.compare(convertTimeToSeconds(a[1]), convertTimeToSeconds(b[1])));

        // Ausgabe der sortierten Liste mit Platzierungen
        System.out.println("Platzierung | Name | Laufzeit");
        for (int i = 0; i < results.length; i++) {
            String timeDisplay = results[i][1].isEmpty() ? "Keine Zeit" : results[i][1];
            System.out.printf("%d. Platz: %s - %s\n", i + 1, results[i][0], timeDisplay);
        }
    }

    public static void main(String[] args) {
        // Beispiel für ein 2D-Array mit Namen und Laufzeiten im Format hh:mm:ss
        String[][] runners = {
                {"Arweiler, Klaus ", "00:32:07"},
                {"Bötsch, Christina ", "00:36:52"},
                {"Brux, Tobias ", "00:27:22"},
                {"Dellermann, Daniela ", "00:47:23"},
                {"Diemer, Valeriya ", "00:39:15"},
                {"Dinkel, Frank ", "00:39:25"},
                {"Doan, Hang ", "00:50:44"},
                {"Freitag, Matthias ", "00:34:48"},
                {"Fuss, Christian ", "00:31:38"},
                {"Geißendörfer, Markus ", "00:34:59"},
                {"Hehn, Albert ", "00:44:16"},
                {"Heinz, Anton ", "00:45:02"},
                {"Hüller, Sebastian ", "00:25:03"},
                {"Klein, Clemens ", "00:35:28"},
                {"Kohler, Jörg ", "00:39:19"},
                {"Kriester, Uwe ", "00:27:12"},
                {"Lukoschek, Kester ", "00:36:37"},
                {"Lurz, Frank ", "00:27:32"},
                {"Mählich, Robert ", "00:43:43"},
                {"Manke, Maik ", "00:32:34"},
                {"Manske, Julian ", "00:25:38"},
                {"Merget, Paul ", "00:32:13"},
                {"Nangue Tankoua, Elodie ", "00:50:36"},
                {"Pfister, Jens ", "00:33:12"},
                {"Plume, Monika ", "00:39:18"},
                {"Pöhler, Simone ", "00:41:22"},
                {"Reichert, Johannes ", "00:39:04"},
                {"Rincker, Yannik ", ""},
                {"Schadewaldt, Joshua ", "00:31:45"},
                {"Schmäling, Uwe ", "00:25:29"},
                {"Schraud, Stefan ", "00:31:22"},
                {"Schuck, Julian ", "00:29:13"},
                {"Schuler, Karin ", "00:39:15"},
                {"Schulze, Karsten ", "00:30:50"},
                {"Schumacher, Kristian ", "00:36:46"},
                {"Stelter, Benjamin ", "00:48:44"},
                {"Stürmer, Jan ", "00:53:16"},
                {"Teister, Damian ", "00:39:33"},
                {"Thomae, Enrico ", "00:22:53"},
                {"Veeh, Johannes ", "00:32:33"},
                {"Weber, Sita ", "00:45:17"},
                {"Wendel, Fabian ", "00:39:24"},
                {"Zimmermann, Mandy ", "00:52:42"},
        };

        // Funktion aufrufen, um Ergebnisse zu drucken
        printSortedResults(runners);
    }
}