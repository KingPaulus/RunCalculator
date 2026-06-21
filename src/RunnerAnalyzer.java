import java.util.*;

public class RunnerAnalyzer {

    public static Map<String, Set<Integer>> analyzeRunners(
            Map<Integer, String[][]> yearData) {

        Map<String, Set<Integer>> result = new TreeMap<>();

        for (Map.Entry<Integer, String[][]> entry : yearData.entrySet()) {
            int year = entry.getKey();
            String[][] runners = entry.getValue();

            for (String[] runner : runners) {
                String rawName = runner[0];

                String key = normalizeName(rawName);

                result.computeIfAbsent(key, k -> new TreeSet<>())
                        .add(year);
            }
        }

        return result;
    }

    private static String normalizeName(String name) {
        name = name.trim();

        // "Nachname, Vorname" -> "Nachname Vorname"
        if (name.contains(",")) {
            String[] parts = name.split(",");
            if (parts.length == 2) {
                name = parts[0].trim() + " " + parts[1].trim();
            } else {
                name = name.replace(",", "");
            }
        }

        // lowercase + spaces normalisieren
        return name.toLowerCase().replaceAll("\\s+", " ");
    }

    // ⭐ macht aus "merget paul" -> "Merget Paul"
    private static String toTitleCase(String name) {
        String[] parts = name.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            if (part.isEmpty()) continue;

            sb.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }

        return sb.toString().trim();
    }

    public static void printResult(Map<String, Set<Integer>> result) {
        result.forEach((name, years) -> {
            System.out.println(
                    toTitleCase(name) + " - " +
                            years.stream()
                                    .map(String::valueOf)
                                    .reduce((a, b) -> a + ", " + b)
                                    .orElse("")
            );
        });
    }
}