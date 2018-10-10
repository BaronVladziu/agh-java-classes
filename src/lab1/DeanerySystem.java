package lab1;

public class DeanerySystem {

    private static String[] dayShortcuts = {"PT", "SB", "ND"};

    public static void main(String[] args) {
        print(3);
        print("hello");

        print(dayShortcuts);
    }

    static void print(int liczba) {
        System.out.println("Argument metody jest liczbą całkowitą");
    }

    static void print(String napis) {
        System.out.println("Argument metody jest napisem");
    }

    static void print(String[] tablica) {
        print(str2dayID(tablica));
    }

    static void print(DayID[] tablica) {
        for (final DayID s : tablica) {
            switch (s) {
                case PT: {
                    System.out.println("PT --> Piątek");
                    break;
                }case SB: {
                    System.out.println("SB --> Sobota");
                    break;
                }case ND: {
                    System.out.println("ND --> Niedziela");
                    break;
                }
            }
        }
    }

    static DayID[] str2dayID(String[] tablica) {
        DayID[] resultTab = new DayID[tablica.length];
        for (int i = 0; i < tablica.length; i++) {
            switch (tablica[i]) {
                case "PT": {
                    resultTab[i] = DayID.PT;
                    break;
                }case "SB": {
                    resultTab[i] = DayID.SB;
                    break;
                }case "ND": {
                    resultTab[i] = DayID.ND;
                    break;
                }
            }
        }
        return resultTab;
    }

}
