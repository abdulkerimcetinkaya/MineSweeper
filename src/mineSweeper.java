
import java.util.Random; // Rastgele sayı üretmek için gerekli kütüphane
import java.util.Scanner; // Kullanıcı girişi almak için gerekli kütüphane

public  class mineSweeper { // TEMEL FONKSİYONLAR - 5.MADDE

    int rowNumber,colNumber, mineNumber ; //Satır sayısı, sütun sayısı ve mayın sayısı değişkenleri
    boolean game = true; // Oyunun devam edip etmediğini tutan boolean değişken
    String[][] adminMap;  //Oyunun asıl haritasını tutan 2D dizi
    String[][] gameMap; // Oyuncunun gördüğü haritayı tutan 2D dizi
    Random rand = new Random(); // Rastgele sayı üretmek için Random nesnesi
    Scanner scan = new Scanner(System.in); // Kullanıcı girişi okumak için Scanner nesnesi

    // constructor metot
    mineSweeper(int rowNumber, int colNumber){ // TEMEL FONKSİYONLAR - 7.MADDE
        this.rowNumber = rowNumber; //sınıfın rowNumber değerine parametre olarak alınan değeri ata.
        this.colNumber = colNumber; // sınıfın colNumber değerine parametre olarak alınan değeri ata.
        this.adminMap = new String[rowNumber][colNumber]; // adminMap'in rowNumber ve colNumber sayısına başlangıçta istenen değeri ver
        this.gameMap = new String[rowNumber][colNumber]; // gameMap'in rowNumber ve colNumber sayısına başlangıçta istenen değeri ver
        this.mineNumber = rowNumber*colNumber/4; // Mayın sayısını hesapla
    }

    // Oyunu başlatmak için metot
    public void run(){
        prepareGame(); // Oyunu hazırla (mayınları yerleştir)
        print(adminMap); // Asıl haritayı yazdır (mayınlarla birlikte)
        gameStart(); // Oyunu başlat
    }

    // Oyun mantığını işleyen metot
    public void gameStart(){ // TEMEL FONKSİYONLAR - 6.MADDE
        int row = 0,col = 0,success = 0; // Kullanıcının seçtiği satır, sütun ve başarılı hamle sayısı değişkenleri
        System.out.println("The game begins!!");
        while (game){ // game 'true' olduğu sürece devam et
            print(gameMap); // Mevcut oyun durumunu yazdır. // TEMEL FONKSİYONLAR - 11.MADDE

            // Satır koordinatı // TEMEL FONKSİYONLAR - 9.MADDE
            System.out.print("Row Number: ");
            while(!scan.hasNextInt()){
                System.out.println("You entered the wrong value, please enter an integer!");
                System.out.print("Row Number: ");
                scan.next();
            }
            row = scan.nextInt();

            // Sütun koordinatı // TEMEL FONKSİYONLAR - 9.MADDE
            System.out.print("Column Number: ");
            while(!scan.hasNextInt()){
                System.out.println("You entered the wrong value, please enter an integer!");
                System.out.print("Column Number: ");
                scan.next();
            }
            col = scan.nextInt(); // kullanıcıdan sütun sayısı al ve col değişkenine eşitle

            // TEMEL FONKSİYONLAR - 10.MADDE
            if ((row  < 0 || row  > rowNumber - 1) || (col  < 0 || col  > colNumber - 1)){ // Geçersiz bir koordinat seçilip seçilmediğini kontrol et
                System.out.println("Invalid coordinate.");
                continue; // döngünün başına dön
            }
            // TEMEL FONKSİYONLAR - 10.MADDE
            if (!gameMap[row][col].equals(" - ")){ //Kullanıcının daha önce seçtiği bir koordinatı tekrar seçmemesi için kontrol et
                System.out.println("This coordinate you chose before");
                continue; // döngünün başına dön
            }

            // TEMEL FONKSİYONLAR - 13.MADDE - 14.MADDE - 15.MADDE
            // Kazanma ve kaybetme senaryosu
            if (!adminMap[row][col].equals(" * ")){ // Kullanıcının seçtiği koordinatın mayına denk gelip gelmediğini kontrol et
                checkMine(row ,col ); // Komşu mayınları kontrol eden metot
                success++; // başarılı hamle sayısını 1 artır.
                if (success == (rowNumber*colNumber) - mineNumber){ // Eğer hamle sayısı (Success) mayın tarlasının boyutunun mayın sayısı boyutunu çıkarınca ortaya çıkan değere eşitse
                    System.out.println("Win!");
                    break; // döngüyü kır ve oyunu sonlandır.
                }
            }else { // değilse
                game = false; // game'i false yap ve oyunu bitir
                System.out.println("Game Over!!!"); // ekrana game over yazdır
            }
        }
    }

    // Komşu mayınları kontrol eden metot
    public void checkMine(int row, int column){ // TEMEL FONKSİYONLAR - 12.MADDE
        int counter = 0; // Komşu mayın sayısı

        if (adminMap[row][column].equals(" - ")){ //Seçilen koordinatın mayına denk gelip gelmediğini kontrol et

            for (int i = row - 1; i <= row + 1; i++) {// Seçilen koordinatın etrafındaki satırları tarayarak
                for (int j = column - 1; j <= column + 1; j++) { // Seçilen koordinatın etrafındaki sütunları tarayarak
                    if (i >= 0 && i < rowNumber && j >= 0 && j < colNumber) { // Geçerli bir koordinat mı diye kontrol et
                        if (adminMap[i][j].equals(" * ")) { // Eğer komşu bir mayına denk gelinirse
                            counter++; // Mayın sayısını artır
                        }
                    }
                }
            }
            gameMap[row][column] = " " + counter + " "; // Koordinatın değerini komşu mayın sayısıyla güncelle

            if (gameMap[row][column].equals(" - ")){ // Eğer komşu mayın yoksa
                gameMap[row][column] = " 0 "; // Koordinatın değerini 0 yap
            }
        }
    }

    // Mayın tarlasını hazırlayan metot
    public void prepareGame(){
        for (int i = 0; i < gameMap.length; i++) { // gameMap'in satırlarını gez
            for (int j = 0; j < gameMap[0].length; j++) { // gameMap'in sütunlarını gez
                gameMap[i][j] = " - "; //gameMap'in i,j indeksine '-' koy
            }
        }

        for (int i = 0; i < adminMap.length; i++) { // AdminMap'in satırlarını gez
            for (int j = 0; j < adminMap[0].length; j++) { // adminMap'in sütünlarını gez
                adminMap[i][j] = " - "; // adminMap'in i,j indeksine '-' koy
            }
        }
        // TEMEL FONKSİYONLAR - 8.MADDE
        int randRow,randCol,count = 0; // rastgele oluşturulacak satır ve sütun değişkenleri oluşturuldu ve count'a default olarak 0 atandı.
        while (count!= mineNumber){ // Tüm mayınlar yerleştirilene kadar devam et
            randRow = rand.nextInt(rowNumber); // Random sınıfını kullanarak 0 ile rowNumber arasında bir sayı üret
            randCol = rand.nextInt(colNumber);  // Random sınıfını kullanarak 0 ile colNumber arasında bir sayı üret
            if (!adminMap[randRow][randCol].equals(" * ")){ // eğer adminMap'in randRow ve ranCol'u '*' a eşit değilse eşitle ve count'ı 1 artır
                adminMap[randRow][randCol] = " * "; // adminMap'in raastgele satır ve sütununa bomba '*' koy
                count++; // count değişkenini 1 artır.
            }
        }
    }

    // Mayın tarlasını ekrana yazdıran metod
    public void print(String[][] arr){
        for (int i = 0; i < arr.length; i++) { // Verilen dizinin satırlarını gez
            for (int j = 0; j < arr[0].length; j++) { // verilen dizinin sütunlarını gez
                System.out.print(arr[i][j]); // Ekrana arr dizisinin i ve j elamınını ekrana yaz
            }
            System.out.println(); // bir alt satıra in
        }
        System.out.println("----------------------------");
    }
}