import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Metni giriniz:");
        String metin = scanner.nextLine();

        String[] kelimeler = metin.split("\\s+");

        Map<String, Integer> kelimeSayilari = new HashMap<>();

        for (String kelime : kelimeler) {
            if (kelimeSayilari.containsKey(kelime)) {
                kelimeSayilari.put(kelime, kelimeSayilari.get(kelime) + 1);
            } else {
                kelimeSayilari.put(kelime, 1);
            }
        }

        int maxFrekans = 0;
        String enCokGecenKelime = "";

        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
            if (entry.getValue() > maxFrekans) {
                maxFrekans = entry.getValue();
                enCokGecenKelime = entry.getKey();
            }
        }

        System.out.println("En çok geçen kelime: " + enCokGecenKelime);
        System.out.println("Frekansı: " + maxFrekans);
    }
}
