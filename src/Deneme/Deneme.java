package Deneme;
import java.util.Scanner;

public class Deneme {
    public static void main(String[] args) {
        String[] birlerBasamagi = new String[]{"", "", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        String[] onlarBasamagi = new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] yuzlerBasamagi = new String[]{"", "", "yüz"};
        String[] katlar = new String[]{"milyon", "bin", ""};
        String[] sayiBileseni = new String[3];
        int bolen = 10;
        String sayi = "";
        boolean dongu = true;
        while (dongu) {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a number: ");
            int number = reader.nextInt();

            //verilen sayıyı 3 basamak içeren parçalara bölüyoruz
            for (int m = 2; m >= 0 && number > 0; m--) {
                //bölünen parçanın hesaplanması
                for (int i = 0; i < 3; i++) {
                    int remainder = number % bolen;
                    number /= 10;

                    //biryüz ifadesini engellemek için
                    if (i == 0)
                        birlerBasamagi[1] = "bir";
                    else
                        birlerBasamagi[1] = "";

                    if (i == 1) {
                        if (birlerBasamagi[remainder] != "" || onlarBasamagi[remainder] != "" || yuzlerBasamagi[i] != "")
                            sayi = onlarBasamagi[remainder] + " " + sayi;//on ve onun katları için
                    } else {
                        if ((birlerBasamagi[remainder] != "" || onlarBasamagi[remainder] != "" || yuzlerBasamagi[i] != "")) {
                            if (i == 2 && remainder == 0) {
                                continue;//3 basamağın yanyana sıfır geldiği durum
                            }
                            sayi = birlerBasamagi[remainder] + yuzlerBasamagi[i] + " " + sayi;//diğer durumlar
                        }
                    }

                }
                sayiBileseni[m] = sayi;
                sayi = "";
            }
            //Parçaları birleştiriyoruz
            for (int t = 0; t <= sayiBileseni.length - 1; t++) {
                if (sayiBileseni[t] != null && sayiBileseni[t] != "")
                    sayi = sayi + sayiBileseni[t] + katlar[t] + " ";
                    sayiBileseni[t]="";

            }
            System.out.println("Sayının Okunuşu => " + sayi);


            sayi="";
            System.out.println("Devam etmek istiyor musunuz? (E or H)");
            String devam = reader.next();
            if(!devam.equalsIgnoreCase("E"))
                dongu=false;
        }
    }
}
