import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GeekMatcher {

    public static void main(String[] args) {
        ArrayList<Geek> allGeeks = loadGeeksFile("allGeeks.txt");

        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your sport: ");
        String sport = scanner.nextLine();

        System.out.print("Enter your favorite desserts (separated by commas): ");
        String dessertsInput = scanner.nextLine();
        String[] favoriteDesserts = dessertsInput.split(",\\s*");

        Geek individualGeek = new Geek(name);
        individualGeek.setSport(sport);
        for (String dessert : favoriteDesserts) {
            individualGeek.addFavoriteDessert(dessert);
        }

        // Continue with the rest of your code
        List<Geek> sportCompatibleGeeks = findSportCompatibleGeeks(allGeeks, individualGeek);
        List<Geek> dessertCompatibleGeeks = findDessertCompatibleGeeks(allGeeks, individualGeek);
        List<Geek> commonDessertsAndSportGeeks = findCommonDessertsAndSportGeeks(sportCompatibleGeeks, dessertCompatibleGeeks);

        // Print results
        System.out.println("Geeks with sport compatibility with " + name + ": ");
        printGeeks(sportCompatibleGeeks);

        System.out.println("Geeks with favorite dessert compatibility with " + name + ": ");
        printGeeks(dessertCompatibleGeeks);

        System.out.println("Geeks with desserts in common AND compatible sport with " + name + ": ");
        printGeeks(commonDessertsAndSportGeeks);
    }


    private static ArrayList<Geek> loadGeeksFile(String filePath) {
        ArrayList<Geek> geeksList = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String geekInfo = scanner.nextLine().trim();
                String[] geekData = geekInfo.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (geekData.length >= 3) {
                    String name = geekData[0];
                    String gender = geekData[1];

                    int age;
                    try {
                        age = Integer.parseInt(geekData[2]);
                    } catch (NumberFormatException e) {
                        // System.out.println("Invalid age format for geek " + name + ". Skipping this entry.");
                        continue;
                    }

                    String sport = geekData[3];
                    String status = geekData[4];

                    String dessertsInput = geekData[5].replaceAll("\\[|\\]|\\s", "");
                    String[] favoriteDesserts = dessertsInput.split(",");

                    Geek geek = new Geek(name, gender, age, sport, status, Set.of(favoriteDesserts));
                    geeksList.add(geek);
                } else {
                    System.out.println("Invalid data format for geek entry: " + geekInfo);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Return the loaded geeks
        return geeksList;
    }

    private static List<Geek> findSportCompatibleGeeks(List<Geek> allGeeks, Geek individualGeek) {
        List<Geek> sportCompatibleGeeks = new ArrayList<>();
        for (Geek geek : allGeeks) {
            if (individualGeek.getSport().equals(geek.getSport())) {
                sportCompatibleGeeks.add(geek);
            }
        }
        return sportCompatibleGeeks;
    }

    private static List<Geek> findDessertCompatibleGeeks(List<Geek> allGeeks, Geek individualGeek) {
        List<Geek> dessertCompatibleGeeks = new ArrayList<>();
        for (Geek geek : allGeeks) {
            // Check if the geek has at least one common dessert
            if (hasCommonDesserts(geek, individualGeek)) {
                dessertCompatibleGeeks.add(geek);
            }
        }

        // Print dessert-compatible geeks only if there are any
        if (!dessertCompatibleGeeks.isEmpty()) {
            System.out.println("Geeks with favorite dessert compatibility with " + individualGeek.getName() + ": ");
            printGeeks(dessertCompatibleGeeks);
        }

        return dessertCompatibleGeeks;
    }


    // Helper method to check if two geeks have at least one common dessert
    private static boolean hasCommonDesserts(Geek geek1, Geek geek2) {
        Set<String> desserts1 = new HashSet<>();
        for (String dessert : geek1.getFavoriteDesserts()) {
            desserts1.add(dessert.toLowerCase());
        }

        Set<String> desserts2 = new HashSet<>();
        for (String dessert : geek2.getFavoriteDesserts()) {
            desserts2.add(dessert.toLowerCase());
        }

        desserts1.retainAll(desserts2);

        return !desserts1.isEmpty(); // Return true if there are common desserts
    }

    private static List<Geek> findCommonDessertsAndSportGeeks(List<Geek> sportCompatibleGeeks, List<Geek> dessertCompatibleGeeks) {
        List<Geek> commonDessertsAndSportGeeks = new ArrayList<>(sportCompatibleGeeks);
        commonDessertsAndSportGeeks.retainAll(dessertCompatibleGeeks);
        return commonDessertsAndSportGeeks;
    }

    private static void printGeeks(List<Geek> geeks) {
        Set<String> printedGeeks = new HashSet<>();
        for (Geek geek : geeks) {
            String geekInfo = "Name: " + geek.getName() + ", Sport: " + geek.getSport();
            if (!printedGeeks.contains(geekInfo)) {
                System.out.println(geekInfo);
                printedGeeks.add(geekInfo);
            }
        }
    }
}
