import java.util.*;

public class Geek {
    private String name;
    private String gender;
    private int age;
    private String sport;
    private String status;
    private Set<String> favoriteDesserts;

    // Compatibility sets
    private static final Set<String> SPORT_COMPATIBILITY_GROUPS = new HashSet<>();
    private static final Set<String> DESSERT_COMPATIBILITY_GROUPS = new HashSet<>();

    // Constructors
    public Geek(String name) {
        this.name = name;
        initializeCompatibilityGroups();
    }

    public Geek(String name, String gender, int age, String sport, String status, Set<String> favoriteDesserts) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.sport = sport;
        this.status = status;
        this.favoriteDesserts = favoriteDesserts;
        initializeCompatibilityGroups();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }

    public String getStatus() {
        return status;
    }

    public Set<String> getFavoriteDesserts() {
        return favoriteDesserts;
    }

    // Setter methods
    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setFavoriteDesserts(Set<String> favoriteDesserts) {
        this.favoriteDesserts = favoriteDesserts;
    }

    // Additional methods
    public void addFavoriteDessert(String dessert) {
        if (favoriteDesserts == null) {
            favoriteDesserts = new HashSet<>();
        }
        favoriteDesserts.add(dessert);
    }

    public boolean isSameSportGroup(Geek otherGeek) {
        return SPORT_COMPATIBILITY_GROUPS.contains(this.sport) && SPORT_COMPATIBILITY_GROUPS.contains(otherGeek.getSport());
    }

        public boolean hasCommonDesserts(Geek otherGeek) {
        for (String dessert : favoriteDesserts) {
            if (otherGeek.getFavoriteDesserts().stream().anyMatch(d -> d.equalsIgnoreCase(dessert))) {
                return true; // Found a common dessert
            }
        }
        return false; // No common desserts
    }

    public boolean isCompatible(Geek otherGeek) {
        return isSameSportGroup(otherGeek) && !commonFavoriteDesserts(otherGeek).isEmpty();
    }

    private void initializeCompatibilityGroups() {
        // Initialize compatibility groups for sports and desserts
        // Modify or expand as needed
        SPORT_COMPATIBILITY_GROUPS.add("Football");
        SPORT_COMPATIBILITY_GROUPS.add("Basketball");
        SPORT_COMPATIBILITY_GROUPS.add("Tennis");
        SPORT_COMPATIBILITY_GROUPS.add("Taekwondo");
        SPORT_COMPATIBILITY_GROUPS.add("Water Polo");
        SPORT_COMPATIBILITY_GROUPS.add("Skateboarding");
        SPORT_COMPATIBILITY_GROUPS.add("Athletics");
        SPORT_COMPATIBILITY_GROUPS.add("Wrestling");
        SPORT_COMPATIBILITY_GROUPS.add("Surfing");
        SPORT_COMPATIBILITY_GROUPS.add("Golf");
        SPORT_COMPATIBILITY_GROUPS.add("Bridge");
        SPORT_COMPATIBILITY_GROUPS.add("BMX");
        SPORT_COMPATIBILITY_GROUPS.add("Golf");
        SPORT_COMPATIBILITY_GROUPS.add("Snowboarding");
        SPORT_COMPATIBILITY_GROUPS.add("Football");
        SPORT_COMPATIBILITY_GROUPS.add("Skateboarding");
        SPORT_COMPATIBILITY_GROUPS.add("Swimming");
        SPORT_COMPATIBILITY_GROUPS.add("Skiing");
        SPORT_COMPATIBILITY_GROUPS.add("Taekwondo");
        SPORT_COMPATIBILITY_GROUPS.add("Cricket");
        SPORT_COMPATIBILITY_GROUPS.add("Volleyball");
        SPORT_COMPATIBILITY_GROUPS.add("Ice Skating");
    
        DESSERT_COMPATIBILITY_GROUPS.add("Cheesecake");
        DESSERT_COMPATIBILITY_GROUPS.add("Red Velvet");
        DESSERT_COMPATIBILITY_GROUPS.add("Macarons");
        DESSERT_COMPATIBILITY_GROUPS.add("Oatmeal");
        DESSERT_COMPATIBILITY_GROUPS.add("Sorbet");
        DESSERT_COMPATIBILITY_GROUPS.add("Gelato");
        DESSERT_COMPATIBILITY_GROUPS.add("Vanilla");
        DESSERT_COMPATIBILITY_GROUPS.add("Peanut");
        DESSERT_COMPATIBILITY_GROUPS.add("Flan");
        DESSERT_COMPATIBILITY_GROUPS.add("Pecan");
        DESSERT_COMPATIBILITY_GROUPS.add("Fudge");
        DESSERT_COMPATIBILITY_GROUPS.add("Chocolate Frozen");
        DESSERT_COMPATIBILITY_GROUPS.add("Rice");
        DESSERT_COMPATIBILITY_GROUPS.add("Cobbler");
        DESSERT_COMPATIBILITY_GROUPS.add("Crème Brûlée");
        DESSERT_COMPATIBILITY_GROUPS.add("Éclair");
        DESSERT_COMPATIBILITY_GROUPS.add("Parfait");
        DESSERT_COMPATIBILITY_GROUPS.add("Truffles");
        DESSERT_COMPATIBILITY_GROUPS.add("Danish");
        DESSERT_COMPATIBILITY_GROUPS.add("Baklava");
        DESSERT_COMPATIBILITY_GROUPS.add("Chocolate Pudding");
        DESSERT_COMPATIBILITY_GROUPS.add("Carrot");
        DESSERT_COMPATIBILITY_GROUPS.add("Croissant");
        DESSERT_COMPATIBILITY_GROUPS.add("Apple");
        DESSERT_COMPATIBILITY_GROUPS.add("Crumble");
        DESSERT_COMPATIBILITY_GROUPS.add("Meringue");
        DESSERT_COMPATIBILITY_GROUPS.add("Strawberry");
        DESSERT_COMPATIBILITY_GROUPS.add("Bananas Foster");
        DESSERT_COMPATIBILITY_GROUPS.add("Tapioca");
        DESSERT_COMPATIBILITY_GROUPS.add("Pumpkin");
        DESSERT_COMPATIBILITY_GROUPS.add("Bread");
        DESSERT_COMPATIBILITY_GROUPS.add("Cherry/Blueberry");
        DESSERT_COMPATIBILITY_GROUPS.add("Salad");
        DESSERT_COMPATIBILITY_GROUPS.add("Pralines");
        DESSERT_COMPATIBILITY_GROUPS.add("Shortbread");
        DESSERT_COMPATIBILITY_GROUPS.add("Sorbet");
        DESSERT_COMPATIBILITY_GROUPS.add("Toffee");
        DESSERT_COMPATIBILITY_GROUPS.add("Rice");
        DESSERT_COMPATIBILITY_GROUPS.add("Chocolate Cookies");
        DESSERT_COMPATIBILITY_GROUPS.add("Pecan");
        DESSERT_COMPATIBILITY_GROUPS.add("Bananas Foster");
        DESSERT_COMPATIBILITY_GROUPS.add("Chocolate Cake");
        DESSERT_COMPATIBILITY_GROUPS.add("Meringue");
        DESSERT_COMPATIBILITY_GROUPS.add("Churros");
        DESSERT_COMPATIBILITY_GROUPS.add("Bread");
        DESSERT_COMPATIBILITY_GROUPS.add("Tart");
        DESSERT_COMPATIBILITY_GROUPS.add("Kulfi");
    }
}
