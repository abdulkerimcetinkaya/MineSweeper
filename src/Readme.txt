##Mayın Tarlası Oyunu##

#Özet#
Mayın Tarlası oyununun amacı, mayınlarla dolu bir alanda tüm boş kareleri bulmak ve oyunu kazanmaktır.
Satır ve sütun sayısını girdikten sonra, kutuları açarak oyuna başlıyorsunuz. Her bir açılan kutunun
etrafındaki mayınların sayısı o kutuya yazdırılır. Diğer kutuları doğru tahmin ederek tüm mayınları
etkisiz hale getirebilir ve oyunu tamamlayabilirsiniz. İyi eğlenceler!

#Çalışma Mantığı#
Mayın Tarlası oyunu başlangıçta haritanın boyutunu ayarlamak için satır ve sütun sayılarını girmenizi istiyor.
Harita boyutunu girdikten sonra, bombalar (girilen sayının çeyreği kadar) rastgele haritaya yerleştirilir ve oyun başlar.
Oyun sırasında sizden her defasında bir satır ve bir sütun koordinatı girmeniz istenir.

- Eğer girdiğiniz koordinat bir mayına denk gelirse, oyunu kaybedersiniz.
- Eğer girdiğiniz koordinata değen bir mayın varsa (sağı, solu, yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz,
  sağ alt çapraz, sol alt çapraz), o koordinata kaç adet mayın denk geliyorsa, o sayı kutuya yazılır.
- Eğer girdiğiniz koordinatta mayın yoksa, o koordinata 0 yazdırılır.


Bu kurallara göre, haritadaki tüm boş kutuları bulmaya çalışarak oyunu tamamlayabilirsiniz. Başarılar!