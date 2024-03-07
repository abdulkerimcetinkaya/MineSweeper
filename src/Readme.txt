##Mayın Tarlası Oyunu##

#Kullanılan Teknolojiler#
- Java 21

#Özet#
Mayın Tarlası oyununun amacı, mayınlarla dolu bir alanda tüm boş kareleri bulmak ve oyunu kazanmaktır.
Satır ve sütun sayısını girdikten sonra, kutuları açarak oyuna başlıyorsunuz. Her bir açılan kutunun
etrafındaki mayınların sayısı o kutuya yazdırılır. Diğer kutuları doğru tahmin ederek tüm mayınları
etkisiz hale getirebilir ve oyunu tamamlayabilirsiniz. İyi eğlenceler!

#Çalışma Mantığı#
Mayın Tarlası oyunu başlangıçta haritanın boyutunu ayarlamak için satır ve sütun sayılarını(int tipinde) girmenizi istiyor.
Harita boyutunu girdikten sonra, bombalar (harita boyutunun çeyreği kadar) rastgele haritaya yerleştirilir ve oyun başlar.
Oyun sırasında sizden her defasında bir satır ve bir sütun koordinatı girmeniz istenir.

- Eğer girdiğiniz koordinat bir mayına denk gelirse, oyunu kaybedersiniz.
- Eğer girdiğiniz koordinata değen bir mayın varsa (sağı, solu, yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz,
  sağ alt çapraz, sol alt çapraz), o koordinata kaç adet mayın denk geliyorsa, o sayı kutuya yazılır.
- Eğer girdiğiniz koordinatta mayın yoksa, o koordinata 0 yazdırılır.

Bu kurallara göre, haritadaki tüm boş kutuları bulmaya çalışarak oyunu tamamlayabilirsiniz. Başarılar!

----------------------------------------------------------------------------------------------------
## Oyundan Görüntüler##

Enter number of rows : 5
Enter number of column : 5
Oyun başladı!
 -  -  -  -  -
 -  -  -  -  -
 -  -  -  -  -
 -  -  -  -  -                      Oyunumuzu girdiğimiz değerlere göre boyutunu ayarlayarak başlattık
 -  -  -  -  -                      ve kullanıcıdan koordinat girmesini istedik
Satır: 2
Sütun: 2
-----------------------------------------------------------------------------------------------------
Satır: 3
Sütun: 3                            Seçtiğimiz koordinatta bomba olduğu için kaybettik
Game Over!!!
-----------------------------------------------------------------------------------------------------
Satır: 3
Sütun: 4                            Seçtiğimiz koordinat daha önce seçildiği için bizden tekrar giriş istedi.
Bu koordinat daha önce seçildi.
-----------------------------------------------------------------------------------------------------
 1  2  -  1  0
 -  3  2  1  0
 4  -  2  0  0
 -  -  2  1  1                      Hiçbir mayına basmadan oyunu tamamladığımız için oyunu kazandık.
 2  2  1  -  -
Satır: 4
Sütun: 3
Win!
-----------------------------------------------------------------------------------------------------
 -  -  -  -  -
 -  -  -  -  -
 -  -  -  -  -
 -  -  -  -  -                      Boyutumuzun dışında bir değer girdiğimiz için geçersiz koordinat yazdırdık
 -  -  -  -  -                      ve tekrar giriş istedik
Satır: 6
Sütun: 6
Geçersiz koordinat
