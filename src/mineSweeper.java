
import java.util.Random; // Rastgele sayı üretmek için gerekli kütüphane
import java.util.Scanner; // Kullanıcı girişi almak için gerekli kütüphane

public  class mineSweeper {
    int rowNumber,colNumber, mineNumber ; //Satır sayısı, sütun sayısı ve mayın sayısı değişkenleri
    boolean game = true; // Oyunun devam edip etmediğini tutan boolean değişken
    String[][] adminMap;  //Oyunun asıl haritasını tutan 2D dizi
    String[][] gameMap; // Oyuncunun gördüğü haritayı tutan 2D dizi
    Random rand = new Random(); // Rastgele sayı üretmek için Random nesnesi
    Scanner scan = new Scanner(System.in); // Kullanıcı girişi okumak için Scanner nesnesi

    // Oyunu başlatmak için constructor
    mineSweeper(int rowNumber, int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.adminMap = new String[rowNumber][colNumber];
        this.gameMap = new String[rowNumber][colNumber];
        this.mineNumber = rowNumber*colNumber/4; // Mayın sayısını hesapla
    }

    // Oyunu başlatmak için metot
    public void run(){
        prepareGame(); // Oyunu hazırla (mayınları yerleştir)
        print(adminMap); // Asıl haritayı yazdır (mayınlarla birlikte)
        gameStart(); // Oyunu başlat
    }

    // Oyun mantığını işleyen metot
    public void gameStart(){
        int row = 0,col = 0,success = 0; // Kullanıcının seçtiği satır, sütun ve başarılı hamle sayısı değişkenleri
        System.out.println("Oyun başladı!");
        while (game){ // game 'true' olduğu sürece devam et
            print(gameMap); // Mevcut oyun durumunu yazdır
            System.out.print("Satır: ");
            row = scan.nextInt();
            System.out.print("Sütun: ");
            col = scan.nextInt();

            if ((row  < 0 || row  > rowNumber - 1) || (col  < 0 || col  > colNumber - 1)){ // Geçersiz bir koordinat seçilip seçilmediğini kontrol et
                System.out.println("Geçersiz koordinat");
                continue;
            }

            if (!gameMap[row][col].equals(" - ")){ //Kullanıcının daha önce seçtiği bir koordinatı tekrar seçmemesi için kontrol et
                System.out.println("Bu koordinat daha önce seçildi.");
                continue;
            }

            // Kazanma ve kaybetme senaryosu
            if (!adminMap[row][col].equals(" * ")){ // Kullanıcının seçtiği koordinatın mayına denk gelip gelmediğini kontrol et
                checkMine(row ,col );
                success++;
                if (success == (rowNumber*colNumber) - mineNumber){ // Eğer hamle sayısı (Success) mayın tarlasının boyutunun mayın sayısı boyutunu çıkarınca ortaya çıkan değere eşitse
                    System.out.println("Win!");
                    break;
                }
            }else { // değilse
                game = false;
                System.out.println("Game Over!!!");
            }

        }
    }

    // Komşu mayınları kontrol eden metot
    public void checkMine(int row, int column){
        int sayac = 0; // Komşu mayın sayısı

        if (adminMap[row][column].equals(" - ")){ //Seçilen koordinatın mayına denk gelip gelmediğini kontrol et

            for (int i = row - 1; i <= row + 1; i++) {// Seçilen koordinatın etrafındaki satırları tarayarak
                for (int j = column - 1; j <= column + 1; j++) { // Seçilen koordinatın etrafındaki sütunları tarayarak
                    if (i >= 0 && i < rowNumber && j >= 0 && j < colNumber) { // Geçerli bir koordinat mı diye kontrol et
                        if (adminMap[i][j].equals(" * ")) { // Eğer komşu bir mayına denk gelinirse
                            sayac++; // Mayın sayısını artır
                        }
                    }
                }
            }
            gameMap[row][column] = " " + sayac + " "; // Koordinatın değerini komşu mayın sayısıyla güncelle

            if (gameMap[row][column].equals(" - ")){ // Eğer komşu mayın yoksa
                gameMap[row][column] = " 0 "; // Koordinatın değerini 0 yap
            }
        }
    }

    // Mayın tarlasını hazırlayan metot
    public void prepareGame(){
        for (int i = 0; i < gameMap.length; i++) { // GameMap'in tüm değerlerini '-' yap
            for (int j = 0; j < gameMap[0].length; j++) {
                gameMap[i][j] = " - ";
            }
        }

        for (int i = 0; i < adminMap.length; i++) { // AdminMap'in tüm değerlerini '-' yap
            for (int j = 0; j < adminMap[0].length; j++) {
                adminMap[i][j] = " - ";
            }
        }
        int randRow,randCol,count = 0;
        while (count!= mineNumber){ // Tüm mayınlar yerleştirilene kadar devam et
            randRow = rand.nextInt(rowNumber); // Random sınıfını kullanarak 0 ile rowNumber arasında bir sayı üret
            randCol = rand.nextInt(colNumber);  // Random sınıfını kullanarak 0 ile colNumber arasında bir sayı üret
            if (!adminMap[randRow][randCol].equals(" * ")){ // eğer adminMap'in randRow ve ranCol'u '*' a eşit değilse eşitle ve count'ı 1 artır
                adminMap[randRow][randCol] = " * ";
                count++;
            }
        }
    }

    // Mayın tarlasını ekrana yazdıran metod
    public void print(String[][] arr){
        // Verilen dizinin satırlarını gez
        for (int i = 0; i < arr.length; i++) {
            // verilen dizinin sütunlarını gez
            for (int j = 0; j < arr[0].length; j++) {
                // Ekrana arr dizisinin i ve j elamınını ekrana yaz
                System.out.print(arr[i][j]);
            }
            // bir alt satıra in
            System.out.println();

        }
        System.out.println("----------------------------");
    }
}