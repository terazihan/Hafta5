import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Dizi oluştur
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Kullanıcıdan indeksi al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen bir indeks girin (0-9): ");
        int index = scanner.nextInt();

        // Dizi elemanını döndüren metodu çağır ve sonucu yazdır
        try {
            int element = getElementAtIndex(array, index);
            System.out.println("Indeksteki eleman: " + element);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hata: Geçersiz indeks. Dizi boyutunu aşmayın.");
        }
    }

    // Belirli bir indeksteki dizi elemanını döndüren metot
    public static int getElementAtIndex(int[] array, int index) {
        return array[index];
    }
}
