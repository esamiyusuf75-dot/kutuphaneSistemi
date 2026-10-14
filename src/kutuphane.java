import java.util.ArrayList;
import java.util.Scanner;

//kitap nesnesinin özellikleri belirlenen sınıf
class kitap {
    public String   kitapAd;
    public String yazarAd;
    public String kitapTur;
    public String yazilmaTarih;
    public int kitapId;
    public boolean oduncAlindimi;

    //CONSTRUCTOR:dışarıdan gelen verileri kitap nesnesine bağlar
    public kitap(String kitapAd,String yazarAd,String kitapTur,String yazilmaTarih,int kitapId,boolean oduncAlindimi){
        this.kitapAd = kitapAd;
        this.yazarAd = yazarAd;
        this.kitapTur = kitapTur;
        this.yazilmaTarih = yazilmaTarih;
        this.kitapId = kitapId;
        this.oduncAlindimi = oduncAlindimi;
    }
}
//projeyi çalıştıran sınıf
public class kutuphane {
    public static void main(String[] args){
        ArrayList<kitap> kutuphane = new ArrayList<>();//kütüphanedeki kitapları tutacak liste
        Scanner scanner = new Scanner(System.in);//kullanıcıdan veri almamızı sağlayan scanner nesnesi
        int secim;//menü seçimi için değişken
    }
}