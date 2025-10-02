# Road to AI Integration

> 🤖 **Bu README dosyası Claude Code ile oluşturulmuştur**  
> 📅 **Oluşturulma Tarihi:** 01 Ekim 2025, 15:30  
> 🔧 **AI Assistant:** Claude Code by Anthropic

```
╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║    🚀 Geliştirici: Deniz Gürer                              ║
║    💻 Software Engineer                                      ║
║    ☕ Java & Spring Boot Developer                          ║
║                                                              ║
╚══════════════════════════════════════════════════════════════╝
```

Bu proje Spring Boot ile geliştirilmiş bir REST API uygulamasıdır. Tarih hesaplamaları, string işlemleri ve çeşitli algoritma fonksiyonları sunar.

## Özellikler

- **Tarih İşlemleri**: İki tarih arasındaki gün farkını hesaplama
- **String İşlemleri**: String'i tersine çevirme
- **Algoritma Yardımcıları**: Binary search ve merge sort algoritmaları

## Teknolojiler

- Java 21
- Spring Boot 3.3.5
- Maven
- JUnit 5

## Kurulum

### Gereksinimler

- Java 21 veya üzeri
- Maven 3.6 veya üzeri

### Projeyi Çalıştırma

```bash
# Projeyi klonlayın
git clone <repository-url>
cd road-to-ai-integration

# Bağımlılıkları yükleyin ve uygulamayı çalıştırın
mvn spring-boot:run
```

Uygulama varsayılan olarak `http://localhost:8079` adresinde çalışacaktır.

## API Endpoints

### Tarih İşlemleri

#### Gün Farkı Hesaplama
```
GET /tarih/gun-farki?tarih1=01/01/2024&tarih2=15/01/2024
```

**Parametreler:**
- `tarih1`: İlk tarih (dd/MM/yyyy formatında)
- `tarih2`: İkinci tarih (dd/MM/yyyy formatında)

**Örnek Yanıt:**
```
Tarih 1: 01/01/2024, Tarih 2: 15/01/2024 arasındaki gün farkı: 14
```

### String İşlemleri

#### String Tersine Çevirme
```
GET /string/reverse?metin=deneme
```

**Parametreler:**
- `metin`: Tersine çevrilecek string

**Örnek Yanıt:**
```
Orijinal: deneme, Ters: emened
```

## Proje Yapısı

```
src/
├── main/
│   ├── java/
│   │   └── io/denizg/
│   │       ├── config/          # Konfigürasyon sınıfları
│   │       ├── tarih/           # Tarih modülü
│   │       │   ├── controller/  # REST controller'lar
│   │       │   └── service/     # İş mantığı
│   │       ├── string/          # String modülü
│   │       │   ├── controller/  # REST controller'lar
│   │       │   └── service/     # İş mantığı
│   │       ├── AlgorithmHelper.java  # Algoritma yardımcıları
│   │       └── Main.java        # Ana uygulama sınıfı
│   └── resources/
│       └── application.yml      # Uygulama konfigürasyonu
└── test/
    └── java/                    # Test sınıfları
```

## Konfigürasyon

Uygulama ayarları `src/main/resources/application.yml` dosyasında bulunur:

```yaml
server:
  port: 8079

api:
  path:
    tarih:
      base: /tarih
      gun-farki: /gun-farki
    string:
      base: /string
      reverse: /reverse
```

## Test Etme

```bash
# Tüm testleri çalıştır
mvn test

# Sadece belirli bir test sınıfını çalıştır
mvn test -Dtest=TarihUtilsTest
```

## Geliştirme

### Code Style
- Constructor injection kullanılır
- Hardcoded string'ler configuration'dan okunur
- Package structure modüler olarak organize edilmiştir

### Algoritma Fonksiyonları

Proje aşağıdaki algoritmaları içerir:
- **Binary Search**: Sıralı dizilerde eleman arama
- **Merge Sort**: Diziyi sıralama

Bu fonksiyonlar `AlgorithmHelper` sınıfında static metodlar olarak tanımlanmıştır.

## Lisans

Bu proje eğitim amaçlı geliştirilmiştir.