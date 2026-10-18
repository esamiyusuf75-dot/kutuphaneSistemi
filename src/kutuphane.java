import java.util.ArrayList;
import java.util.Scanner;

//kitap nesnesinin özellikleri belirlenen sınıf
class kitap {
    public String   kitapAd;
    public String yazarAd;
    public String kitapTur;
    public String yazilmaTarih;
    public String kitapId;
    public boolean oduncAlindimi;

    //CONSTRUCTOR:dışarıdan gelen verileri kitap nesnesine bağlar
    public kitap(String kitapAd,String yazarAd,String kitapTur,String yazilmaTarih,String kitapId){
        this.kitapAd = kitapAd;
        this.yazarAd = yazarAd;
        this.kitapTur = kitapTur;
        this.yazilmaTarih = yazilmaTarih;
        this.kitapId = kitapId;
        this.oduncAlindimi = false;//yeni bir kitap eklendıgınde otomatık olarak odunc alınmamıs olması ıcın
    }
}
//projeyi çalıştıran sınıf
public class kutuphane {
    public static void main(String[] args) {
        ArrayList<kitap> kutuphane = new ArrayList<>();//kütüphanedeki kitapları tutacak liste
        Scanner scanner = new Scanner(System.in);//kullanıcıdan veri almamızı sağlayan scanner nesnesi
        String secim = "1";//menü seçimi için değişken

        kutuphane.add(new kitap("Cennetin Doğusu","John Steinbeck","roman","1952","12"));
        kutuphane.add(new kitap("Beyaz Geceler","Fyodor Dostoyevski","roman","1848","15"));
        kutuphane.add(new kitap("Vahşetin Çağrısı","Jack London","macera","1903","20"));
        kutuphane.add(new kitap("Beyaz Diş","Jack London","roman","1906","23"));
        kutuphane.add(new kitap("Dönüşüm","Franz Kafka","roman","1915","27"));
        kutuphane.add(new kitap("Sokratesin Savunması","Platon","felsefe","MÖ 399","32"));
        kutuphane.add(new kitap("1984","George Orwell","Bilim Kurgu","1949","40"));

        do {
            System.out.println("===== KÜTÜPHANE SİSTEMİ =====");
            System.out.println("");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap Ekle");
            System.out.println("3-Kitap Ödünç Al");
            System.out.println("4-Kitap İade Et");
            System.out.println("5-Kitap Ara");
            System.out.println("0-Çıkış");
            System.out.print("LÜTFEN YUKARIDAKİ İŞLEMLERDEN BİRİNİ SEÇ : ");


            secim = scanner.nextLine().trim();

            System.out.println("");
            System.out.println("");

            if(secim.equals("1")){//menü seçimini int yerine string alıp equals kullandım
                                  //kullanıcı harf girerse hata vermek yerıne hatalı giriş yazması için

                if(kutuphane.isEmpty()) {//kitapları içeren kütüphane sınıfının boş olup olmadığını kontrol eden metod
                    System.out.println("!!!KÜTÜPHANEDE KİTAP YOK!!!");
                    System.out.println("");
                }else{
                    int toplamKitap = kutuphane.size();
                    int odunctekiler = 0;
                    int oduncteOlmayanlar = 0;
                    for(kitap k : kutuphane){
                        if(k.oduncAlindimi==true){
                            odunctekiler=odunctekiler+1;
                        }else{
                            oduncteOlmayanlar=oduncteOlmayanlar+1;
                        }
                    }
                    System.out.println("===== KÜTÜPHANEDE Kİ KİTAPLAR===== ");
                    System.out.println("");

                    System.out.println("KÜTÜPHANEDE Kİ TOPLAM KİTAP SAYISI : " + kutuphane.size() + "\nÖDÜNÇ ALINMIŞLAR : " + odunctekiler + "\nÖDÜNÇ ALINMAMIŞLAR : " + oduncteOlmayanlar);
                    System.out.println("");

                    for(kitap k : kutuphane){
                        String durum = k.oduncAlindimi ? "ödünçte" : "ödünç alınmamış";//kitaplar listelenirken durumu false yada true yerine ödünçte veya ödünçte değil şeklinde yazması için
                        System.out.println("ID : " + k.kitapId + "| " + k.kitapAd + "| " + k.yazarAd + "| " + k.yazilmaTarih + "|" + k.kitapTur + "| " + durum);
                    }
                System.out.println("");
                }
            }
            else if(secim.equals("2")){

                System.out.println("===== KİTAP EKLEMEK İÇİN =====");
                System.out.println("");

                System.out.print("Kitabın Adını Gir : ");
                String girilenAd = scanner.nextLine();

                System.out.print("Yazarın Adını Gir : ");
                String girilenYazarAd = scanner.nextLine();

                System.out.print("Kitabın Türünü Gir : ");
                String girilenTur = scanner.nextLine();

                System.out.print("Yazılma Tarihini Gir : ");
                String girilenYazilmaTarih = scanner.nextLine();

                System.out.print("Kitap Id Gir : ");
                String girilenKitapId = scanner.nextLine().trim();//Kullanıcı sayının başınd yada sonunda space e basarsa o boşluk yok sayılsın diye

                System.out.println("");

                boolean idVarMi = false;
                boolean kitapAdVarMi = false;

                for(kitap k : kutuphane){//kütüphanedeki her kitabı kontrol etmek için for each
                    if(k.kitapId.equals(girilenKitapId)){//girilen ıd le aynı ıd ye sahip kitap varmı bulmak için equals
                        idVarMi = true;
                        break;//kitabı bulduktan sonra gereksiz yere dıger kıtaplara bakmaması için
                    }
                    if(k.kitapAd.equalsIgnoreCase(girilenAd)){//aynı kitap girilirse ve sadece ıd farklıysa kitap eklenmesin diye kontrol
                        kitapAdVarMi = true;
                    }
                }
                if(idVarMi== true) {
                    System.out.println("!!!BU KİTAP KÜTÜPHANEDE ZATEN VAR!!!");
                    System.out.println("");
                }
                else if(kitapAdVarMi==true){
                    System.out.println("!!!BU KİTAP KÜTÜPHANEDE ZATEN VAR!!!");
                }
                else{
                    kitap yenikitap = new kitap(girilenAd, girilenYazarAd, girilenTur, girilenYazilmaTarih, girilenKitapId);
                    kutuphane.add(yenikitap);
                    System.out.println("KİTAP BAŞARIYLA EKLENDİ KÜTÜPHANEDEKİ YENİ KİTAP SAYISI : " + kutuphane.size());
                    System.out.println("");
                }
            }
            else if(secim.equals("3")){

                System.out.println("===== KİTAP ÖDÜNÇ ALMAK İÇİN =====");
                System.out.println("");

                System.out.print("Ödünç Almak İstediğiniz Kitabın İd'si : ");
                String girilenKitapId = scanner.nextLine().trim();//Kullanıcı sayının başınd yada sonunda space e basarsa o boşluk yok sayılsın diye

                System.out.println("");

                boolean kitapIdEslesdimi=false;//kitap ıd si eşleştimi diye kontrol etmek için 

                if(kutuphane.isEmpty()){
                    System.out.println("!!!KÜTÜPHANEDE ÖDÜNÇ ALINACAK BİR KİTAP YOK!!!");
                    System.out.println("");
                }else{
                    for(kitap k : kutuphane){//kütüphanedeki her kitabı kontrol etmek için for each
                        if(k.kitapId.equals(girilenKitapId)){//girilen ıd le aynı ıd ye sahip kitap varmı bulmak için equals
                            kitapIdEslesdimi=true;
                            if(k.oduncAlindimi == true){
                                System.out.println("!!!GİRDİĞİNİZ ID İLE KİTAP EŞLEŞTİ AMA BU KİTAP ZATEN ÖDÜNÇ ALINMIŞ");
                            }else{
                                k.oduncAlindimi = true;
                                System.out.println("KİTAP ID Sİ EŞLEŞTİ BAŞARIYLA " + k.kitapAd + " KİTABINI ÖDÜNÇ ALDINIZ");
                            }
                            break;//girilen ıd ile eşleşen kitap bulundugunda diğer kitaplara bakılmasın diye
                        }
                    }
                    if(kitapIdEslesdimi==false){//eğer üstteki for döngüsü tamamlandıktan sonra kitapIdEslestimi değişkeni hala false ise
                        System.out.println("!!!GİRİLEN ID DE KİTAP BULUNAMADI!!!");
                    }
                System.out.println("");
                }
            }

            else if(secim.equals("4")){

                System.out.println("===== KİTAP İADE ETMEK İÇİN =====");
                System.out.println("");

                System.out.print("Kitabın İd'sini Girin : ");
                String girilenKitapId = scanner.nextLine().trim();//Kullanıcı sayının başınd yada sonunda space e basarsa o boşluk yok sayılsın diye

                System.out.println("");

                boolean girilenKitapVarMi = false;

                if(kutuphane.isEmpty()){
                    System.out.println("!!!KÜTÜPHANEDE ZATEN ÖDÜNÇ ALINMIŞ VEYA ALINMAMIŞ KİTAP BULUNMUYOR!!!");
                    System.out.println("");
                }else{
                    for(kitap k : kutuphane){
                        if(k.kitapId.equals(girilenKitapId)){
                            girilenKitapVarMi=true;
                            if(k.oduncAlindimi==false){
                                System.out.println("!!!BU KİTAP ÖDÜNÇ ALINMAMIŞ ÖDÜNÇ ALINMAMIŞ KİTAP İADE EDİLEMEZ!!!");
                            }else{
                                k.oduncAlindimi=false;
                                System.out.println("BAŞARIYLA " + k.kitapAd + " KİTABINI İADE ETTİNİZ");
                            }
                            break;
                        }
                    }
                    if(girilenKitapVarMi==false){//kontrol edilen ilk kitap ıd si girilen ıd ile eşleşmiyorsa direkt ıd ile hiç bir kitap eşleşmedi demesin diye ayrı bir yerde kontrol ettim
                        System.out.println("!!!GİRDİĞİNİZ ID İLE Hİ BİR KİTAP EŞLEŞMEDİ!!!");
                    }
                System.out.println("");
                }
            }

            else if(secim.equals("5")){

                System.out.println("===== KİTAP ARATMAK İÇİN =====");
                System.out.println("");

                System.out.print("Aradığınız Kitabın Adı Veya Kitap Yazarının Adı : ");
                String kullaniciAramasi = scanner.nextLine().toLowerCase();//Kullanıcı büyük harfle aratma yapsa bile aramayı küçük harfe çevirip kitabı bulmak için toLowerCase

                System.out.println("");

                boolean girilenKitapBulundMu = false ;

                if(kutuphane.isEmpty()){
                    System.out.println("!!!KÜTÜPHANEDE KİTAP YOK!!!");
                    System.out.println("");
                }else{
                    for(kitap k : kutuphane){
                        if(k.kitapAd.toLowerCase().contains(kullaniciAramasi)||k.yazarAd.toLowerCase().contains(kullaniciAramasi)){//girilen kitap veya yazar adının tamamı yazılmasa bile bulunması için contain
                            girilenKitapBulundMu = true;                                                                           //girilen kitap veya yazar adının küçük veya büyük harfde olsa bile bulunması için toLowerCase v
                            String durum = k.oduncAlindimi ? "ödünçte" : "ödünç alınmamış";//kitaplar listelenirken durumu false yada true yerine ödünçte veya ödünçte değil şeklinde yazması için
                            System.out.println("ID : " + k.kitapId + "| " + k.kitapAd + "| " + k.yazarAd + "| " + k.yazilmaTarih + "|" + k.kitapTur + "| " + durum);
                        }
                    }
                    if(girilenKitapBulundMu==false){
                        System.out.println("!!!ARADIĞINIZ KİTAP BULUNAMADI!!!");
                    }
                    System.out.println("");
                }
            }
            else if(!secim.equals("0")&&!secim.equals("1")&&!secim.equals("2")&&!secim.equals("3")&&!secim.equals("4")&&!secim.equals("5")){
                System.out.println("!!!HATALI GİRİŞ!!!");
                System.out.println("");
            }

        }while (!secim.equals("0")) ;
        System.out.println("BAŞARIYLA SİSTEMDEN ÇIKIŞ YAPTINIZ");
    }
}