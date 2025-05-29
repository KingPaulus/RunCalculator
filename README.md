![Firmenlauf Eibelstadt](img/RunCalculator.png)

# RunCalculator

RunCalculator ist eine in Java entwickelte Anwendung, die dabei hilft, Tabellen ohne integrierte Auswertungsfunktionen effizienter zu analysieren und auszuwerten. Die Software wurde speziell entwickelt, um Berechnungen und Analysen von tabellarischen Daten zu erleichtern und zu automatisieren, sodass zeitaufwändige manuelle Arbeit reduziert wird.

> 📊 Dieses Projekt enthält Laufzeiten vom **Firmenlauf Eibelstadt** der Jahre **2024 und 2025**.
> 🔗 [https://www.firmenlauf-eibelstadt.de/](https://www.firmenlauf-eibelstadt.de/)

## Features

* ✅ **Benutzerfreundlich**: Einfach zu bedienen mit einer klaren und intuitiven Struktur.
* 🔁 **Flexibel**: Funktioniert mit verschiedenen tabellarischen Datenformaten.
* ⚡ **Effizient**: Führt komplexe Berechnungen schnell und präzise durch.
* 🔧 **Anpassbar**: Ermöglicht individuelle Anpassungen und Berechnungslogiken.

## Einsatzmöglichkeiten

RunCalculator eignet sich für:

* Tabellen, die keine eingebaute Auswertung oder Analyse bieten.
* Situationen, in denen Datenanalyse manuell durchgeführt werden muss.
* Nutzer, die schnelle und automatisierte Berechnungen durchführen möchten.

## 🛠️ Installation

> 💡 **Hinweis**: Stelle sicher, dass du Java **Version 11 oder höher** installiert hast.

### ✅ Schritte zur Einrichtung:

1. ☕ **Java installieren**
   Stelle sicher, dass Java 11 oder höher auf deinem System installiert ist.  
   Du kannst deine Version im Terminal überprüfen mit:

   ```bash
   java -version
   ```

   > Beispielausgabe: `openjdk version "11.0.18"` (oder neuer)

2. 🧪 **Java-Version prüfen**
   Falls keine Java-Version installiert ist oder sie zu alt ist, lade die aktuelle Version von der offiziellen Seite herunter:
   🔗 [https://www.java.com](https://www.java.com)

3. 🌀 **Projekt herunterladen (clonen)**
   Klone dieses Repository mit folgendem Befehl:

   ```bash
   git clone https://github.com/KingPaulus/RunCalculator
   ```

4. 🧠 **Projekt öffnen**
   Öffne das Projekt in einer Java-IDE – **empfohlen: IntelliJ IDEA**
   🔗 [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)

5. ▶️ **Programm ausführen**
   Navigiere in deiner IDE zur Datei `Main.java`
   und führe die `main()`-Methode direkt aus.

## 🧾 Bedienung

1. Lege eine separate Java-Datei an (z. B. `Results2024.java`) mit einem **zweidimensionalen Array**, das alle Teilnehmer mit ihrem Namen und der jeweiligen Zeit enthält.
   Beispiel:

   ```java
   public class Results2024 {
       public static final String[][] RESULTS = {
           {"Merget, Paul", "00:32:13"},
           {"Manke, Maik", "00:32:34"},
           // weitere Teilnehmer ...
       };
   }
   ```

2. In `Main.java` kannst du nun über eine Auswahl (z. B. per Scanner oder direkt) entscheiden, welche Jahresdaten du analysieren möchtest.

3. Starte das Programm, um die Zeiten zu sortieren und die Ergebnisse auszugeben.

## Anforderungen

* Java 11 oder höher
* Betriebssystem: Windows, macOS oder Linux

## Lizenz

Dieses Projekt steht unter der [MIT-Lizenz](LICENSE).
