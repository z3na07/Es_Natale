# **ANALISI TECNICA**

## **MAIN**

#### **FUNZIONAMENTO**

Rappresenta il punto d'ingresso principale del programma che gestisce la consegna dei regali di Babbo Natale, il cambio delle renne e il passaggio dei fusi orari.

#### **IMPORTAZIONI**

- import country.Country = Importa la classe Country che rappresenta un Paese  
- import country.CountryManager = Importa la classe CountryManager che gestisce la lista dei Paesi  
- import reindeer.ReindeerTeam = Importa la classe ReindeerTeam che rappresenta una squadra di renne  
- import util.* = Importa tutte le classi dal pacchetto util  
- import java.util.ArrayList = Importa la classe ArrayList che rappresenta una lista dinamica di oggetti  
- import java.util.Scanner = Importa la classe Scanner che permette di ottenere l'input dall'utente

## **COUNTRY PACKAGE**

### **COUNTRY**

#### **FUNZIONAMENTO**

La classe Country rappresenta un paese con un nome, una popolazione, una percentuale di buoni bambini e un fuso orario.

#### **ATTRIBUTI**

- private String name; = Attributo per il nome del paese.   
- private long population; = Attributo per la popolazione del paese.   
- private double goodChildren; = Attributo per il tasso di buoni bambini del paese.  
- private String timeZone; = Attributo per il fuso orario del paese.

#### **METODI**

- public Country(String name, long population, double goodChildren, String timeZone) = Metodo costruttore per inizializzare gli attributi name, population, goodChildren, e timeZone.  
- public long getPopulationOfGoodChildren() = Metodo per ottenere il numero di buoni bambini moltiplicando la popolazione per la percentuale di buoni bambini.  
- public String getName() = Metodo per ottenere il nome del paese.  
- public long getPopulation() = Metodo per ottenere la popolazione del paese.   
- public double getGoodChildren() = Metodo per ottenere la percentuale di buoni bambini del paese.
- public String getTimeZone() = Metodo per ottenere il fuso orario del paese

## **COUNTRYMANAGER**

#### **FUNZIONAMENTO**

La classe CountryManager gestisce un elenco di paesi (countryArrayList) e li raggruppa per fuso orario (countryGroupByTimeZone).

#### **IMPORTAZIONI**

- import util.TimezoneManager; = Importa la classe TimezoneManager.  
- import java.util.ArrayList; = Importa la classe ArrayList.  
- import java.util.HashMap; = Importa la classe HashMap.  
- import java.util.List; = Importa la classe List.

#### **ATTRIBUTI**

- private ArrayList\<Country\> countryArrayList; = Attributo per l'elenco dei paesi.  
- private HashMap\<String, ArrayList\<Country\>\> countryGroupByTimeZone; = Attributo per raggruppare i paesi in base al fuso orario.

#### **METODI**

- public CountryManager(ArrayList\<Country\> countryArrayList) = Metodo costruttore per inizializzare l'elenco dei paesi e raggrupparli per fuso orario.  
- private void divideByTimeZone() = Metodo privato che divide i paesi in base al fuso orario e li memorizza in un HashMap.  
- public ArrayList\<Country\> getCountriesInTimezone(String timezone) = Metodo che restituisce l'elenco dei paesi in un determinato fuso orario.

## **DATA**

### **JSON**

#### **FUNZIONAMENTO**

Questa classe gestisce la lettura e la scrittura dei dati da e verso i file.

#### **IMPORTAZIONI**

- import com.google.gson.GsonBuilder; = Importa la classe GsonBuilder.  
- import com.google.gson.JsonElement; = Importa la classe JsonElement.  
- import com.google.gson.JsonParser; = Importa la classe JsonParser.  
- import com.google.gson.Gson; = Importa la classe Gson.  
- import java.io.FileReader; = Importa la classe FileReader.  
- import java.io.FileWriter; = Importa la classe FileWriter.  
- import java.io.IOException; = Importa la classe IOException.

#### **ATTRIBUTI**

- private static final Gson gson = new GsonBuilder().setPrettyPrinting().create(); = Attributo per creare un'istanza di Gson con formattazione a stampa.

#### **METODI**

- public static class Reader public static \<T\> T read(String path, Class\<T\> clazz) = Metodo che legge un file JSON e converte il suo contenuto nel tipo di classe specificato utilizzando Gson.  
- public static class Writer private static void writeFile(String path, String s) = Metodo che scrive una stringa nel percorso di file specificato.  
- public static void write(String path, JsonElement jsonElement) = Metodo che scrive un elemento JSON nel percorso di file specificato.

### **REINDEER**

#### **FUNZIONAMENTO**

Questa classe Reindeer viene utilizzata quando vogliamo creare un nuovo oggetto Reindeer.

#### **IMPORTAZIONI**

- import reindeer.Reindeer; = Importa la classe Reindeer.

#### **ATTRIBUTI**

- private String name; = Attributo per il nome della renna.  
- private boolean isActive; = Attributo booleano che indica se la renna è attiva/in lavoro o no.

#### **METODI**

- public Reindeer(String name, boolean isActive) = Costruttore della classe Reindeer che inizializza gli attributi name e isActive.
- public String toString() = Override del metodo toString per stampare in un modo diverso gli attributi name e isActive della renna.  
- public boolean isActive() = Metodo getter per ottenere il valore dell'attributo isActive.  
- public void setActive(boolean active) = Metodo setter per impostare il valore dell'attributo isActive.

**REINDEERTEAM**

***FUNZIONAMENTO***  
Questa classe gestisce le renne, gestendo il team attivo e quello a riposo.

***IMPORTAZIONI***

- import java.util.ArrayList; = Importa la classe ArrayList.

*ATTRIBUTI*

- private ArrayList\<Reindeer\> reindeerArrayList; = Attributo per l'elenco delle renne.  
- private ArrayList\<Reindeer\> activeTeam; = Attributo per il team attivo.  
- private ArrayList\<Reindeer\> restingTeam; = Attributo per il team a riposo.  
- private Rudolph rudolph; = Attributo per l'istanza di Rudolph.

***METODI***

- public ReindeerTeam(ArrayList\<Reindeer\> reindeerArrayList) = Quando viene istanziata, questa classe:  
1. Prende tutte le renne come lista.  
2. Crea un'istanza di Rudolph.  
3. Carica i team.  
- private void loadTeams() = Metodo che divide le renne in due team e aggiunge Rudolph al team attivo. public void switchTeams() = Metodo che imposta la variabile active in Reindeer al contrario del suo stato attuale. Quindi aggiunge Rudolph al team attivo.  
- private void orderTeams() = Metodo che ordina i team.  
- public ArrayList\<Reindeer\> getActiveTeam() = Metodo che restituisce il team attivo.  
- public ArrayList\<Reindeer\> getRestingTeam() = Metodo che restituisce il team a riposo.

**RUDOLPH**

***FUNZIONAMENTO***  
Questa classe è una versione estesa della classe Reindeer, utilizzata per la renna principale Rudolph. Ha tutti i metodi della classe Reindeer.

***IMPORTAZIONI***

- import reindeer.Rudolph; = Importa la classe Rudolph.

***ATTRIBUTI***

- private String name; = Attributo per il nome della renna.  
- private boolean isActive; = Attributo booleano che indica se la renna è attiva/in lavoro o no.

***METODI***

- public Rudolph() = Costruttore che utilizza il costruttore precedente e crea l'oggetto Rudolph.

**UTIL**  
**GIFTMANAGER**

***FUNZIONAMENTO***  
Questa classe GiftManager gestisce il numero di regali da consegnare e i regali rimanenti fino allo stop.

***ATTRIBUTI***

- private long giftsToDeliver; = Attributo per il numero di regali da consegnare.  
- private long giftsUntilStop; = Attributo per il numero di regali rimanenti fino allo stop.  
- private final long maxGift; = Attributo per il numero massimo di regali che possono essere consegnati.

***METODI***

- public GiftManager(long maxGift) = Costruttore che inizializza l'attributo maxGift e giftsUntilStop al valore massimo.  
- public void resetGiftUntilStop() = Metodo che resetta il numero di regali rimanenti fino allo stop al valore massimo.  
- public long getGiftsUntilStop() = Metodo che restituisce il numero di regali rimanenti fino allo stop.  
- public void setGiftsUntilStop(long n) = Metodo che imposta il numero di regali rimanenti fino allo stop. public void incrementGiftUntilStop(long n) = Metodo che incrementa il numero di regali da consegnare di una quantità specificata.  
- public void decrementGiftUntilStop(long n) = Metodo che decrementa il numero di regali da consegnare di una quantità specificata.  
- public void setGiftsToDeliver(long n) = Metodo che imposta il numero di regali da consegnare.  
- public void incrementGiftToDeliver(long n) = Metodo che incrementa il numero di regali da consegnare di una quantità specificata.  
- public void decrementGiftToDeliver(long n) = Metodo che decrementa il numero di regali da consegnare di una quantità specificata.  
- public long getGiftsToDeliver() = Metodo che restituisce il numero di regali da consegnare.  
- public long getMaxGift() = Metodo che restituisce il numero massimo di regali che possono essere consegnati.

**INITIALIZE**

***FUNZIONAMENTO***  
Rappresenta l'inizializzazione dei dati dal file all'avvio del programma, inclusi la lista dei Paesi e la lista delle renne.

***IMPORTAZIONI***

- import com.google.gson.JsonArray = Importa la classe JsonArray che rappresenta un array JSON  
- import com.google.gson.JsonElement = Importa la classe JsonElement che rappresenta un elemento JSON  
- import com.google.gson.JsonObject = Importa la classe JsonObject che rappresenta un oggetto JSON  
- import country.Country = Importa la classe Country che rappresenta un Paese  
- import data.Json = Importa la classe Json che fornisce funzioni di lettura e scrittura JSON  
- import reindeer.Reindeer = Importa la classe Reindeer che rappresenta una renna  
- import java.util.ArrayList = Importa la classe ArrayList che rappresenta una lista dinamica di oggetti

***ATTRIBUTI***

- private ArrayList\<Country\> countryArrayList = Attributo per la lista dei Paesi, inizializzata durante l'istanziazione dell'oggetto  
- private ArrayList\<Reindeer\> reindeerArrayList = Attributo per la lista delle renne, inizializzata durante l'istanziazione dell'oggetto

***METODI***

- public Initialize(String countryArrayListPath, String reindeerPath) = Costruttore della classe Initialize che riceve i percorsi dei file dei Paesi e delle renne, e li utilizza per inizializzare countryArrayList e reindeerArrayList  
- private ArrayList\<Reindeer\> loadReindeer(String reindeerPath) = Metodo privato che carica la lista delle renne dal file specificato nel percorso reindeerPath, legge i dati JSON e crea oggetti Reindeer, aggiungendoli alla lista reindeerArrayList  
- private ArrayList\<Country\> loadCountry(String countryArrayListPath) = Metodo privato che carica la lista dei Paesi dal file specificato nel percorso countryArrayListPath, legge i dati JSON, estrae le informazioni sugli attributi di ogni Paese e crea oggetti Country, aggiungendoli alla lista countryArrayList  
- public ArrayList\<Country\> getCountryArrayList() = Metodo pubblico che restituisce la lista dei Paesi  
- public ArrayList\<Reindeer\> getReindeerArrayList() = Metodo pubblico che restituisce la lista delle renne

**LOGGER**

***FUNZIONAMENTO***  
Questa classe di utilità gestisce i log relativi alle consegne dei regali e ai cambi di renne. Fornisce metodi per tenere traccia del numero di cambi di renne e generare un registro delle attività.

***IMPORTAZIONI***

- import reindeer.ReindeerTeam; = Importa la classe ReindeerTeam.

***ATTRIBUTI***

- private static long giftDelivered; = Attributo per il numero di regali consegnati.  
- private static int reindeerSwitch; = Attributo per il numero di cambi di renne.  
- private static ReindeerTeam reindeerTeam; = Attributo per l'istanza di ReindeerTeam.  
- private static TimezoneManager timezoneManager; = Attributo per l'istanza di TimezoneManager.

***METODI***

- public static void setReindeerTeam(ReindeerTeam reindeerTeam) = Metodo per impostare l'istanza di ReindeerTeam.  
- public static void setTimezoneManager(TimezoneManager timezoneManager) = Metodo per impostare l'istanza di TimezoneManager.  
- public static void setGiftDelivered(long n) = Metodo per impostare il numero di regali consegnati.  
- public static void setGiftDelivered(int n) = Metodo per impostare il numero di regali consegnati.  
- public static void incrementGiftDeliverd() = Metodo per incrementare il numero di regali consegnati di 1\. public static void incrementGiftDeliverd(long increment) = Metodo per incrementare il numero di regali consegnati di una quantità specificata.  
- public static void incrementReindeerSwitch() = Metodo per aggiungere un cambio di renne incrementando il contatore di 1\.  
- public static void incrementReindeerSwitch(int increment) = Metodo per aggiungere un numero specifico di cambi di renne.  
- public static void setReindeerSwitch(int n) = Metodo per impostare il numero di cambi di renne.  
- private static String logSanta() = Metodo che ritorna una stringa contenente il numero di regali consegnati. private static String logRudolph() = Metodo che ritorna una stringa contenente il numero di cambi di renne effettuati, la squadra attiva di renne e la squadra in riposo.  
- private static String logStopProcess() = Metodo che ritorna una stringa contenente il fuso orario corrente, il fuso orario successivo e i fusi orari passati.  
- public static String log() = Metodo che genera un registro delle attività, riportando il numero di regali consegnati e i cambi di renne effettuati.  
- public static void logReindeerSwitch(int numberOfSwitch) = Metodo che salva in un file le renne che sono state cambiate ed il suo orario di cambio  
- public static void logGiftDelivered(long giftDelivered) = Metodo che salva in un file i regali dati ai bambini e l’orario della consegna

**SANTACLAUS**

***FUNZIONAMENTO***  
Rappresenta Babbo Natale e gestisce la consegna dei regali, il cambio delle renne e il passaggio dei fusi orari.

***IMPORTAZIONI***

- import reindeer.ReindeerTeam; = Importa la classe ReindeerTeam.

***ATTRIBUTI***

- private long totalGiftsDelivered; = Attributo per il numero totale di regali consegnati.  
- private int timezonePassed; = Attributo per il numero di fusi orari attraversati.  
- private int reindeerSwitches; = Attributo per il numero di cambi di squadra di renne effettuati.  
- private ReindeerTeam reindeerTeam; = Attributo per la squadra di renne utilizzata per le consegne.

***METODI***

- public SantaClaus(ReindeerTeam reindeerTeam) = Costruttore della classe SantaClaus che inizializza totalGiftsDelivered, timezonePassed, reindeerSwitches e reindeerTeam.  
- public void switchTeam() = Metodo che cambia la squadra di renne attiva con quella di riserva, incrementa il numero di cambi effettuati e aggiorna il registro.  
- public long getTotalGiftsDelivered() = Metodo che restituisce il numero totale di regali consegnati.  
- public void addTotalGiftsDelivered(long giftsToAdd) = Metodo che aggiunge un numero specifico di regali al totale dei regali consegnati e aggiorna il logger.  
- public int getTimezonePassed() = Metodo che restituisce il numero di fusi orari attraversati.  
- public void setTimezonePassed(int timezonePassed) = Metodo che imposta il numero di fusi orari attraversati.  
- public int getReindeerSwitches() = Metodo che restituisce il numero di cambi di squadra di renne effettuati. 

**TIMEZONEMANAGER**

***FUNZIONAMENTO***  
Gestisce il conteggio dei fusi orari attraversati. Questa classe tiene traccia del numero di fusi orari attraversati e verifica quando è il momento di cambiare il fuso orario.

***ATTRIBUTI***

- private int timezonePassed; = Attributo per il numero di fusi orari attraversati.  
- private int timezoneToChange; = Attributo per il numero di fusi orari da cambiare.  
- private final int maxTimezone; = Attributo per il numero massimo di fusi orari che possono essere attraversati.  
- private int currentTimezone; = Attributo per il fuso orario corrente.

***METODI***

- public TimezoneManager(int maxTimezone) = Costruttore per la classe TimezoneManager.  
- public boolean isTimeToChange() = Metodo che controlla se è il momento di cambiare il fuso orario.  
- public static String getTimezoneString(int i) = Metodo che restituisce la stringa del fuso orario dato l'indice. public void incrementTimezonePassed() = Metodo che incrementa il numero di fusi orari attraversati di 1\. public void incrementTimezonePassed(int n) = Metodo che incrementa il numero di fusi orari attraversati di una quantità specificata.  
- public void setTimezonePassed(int n) = Metodo che imposta il numero di fusi orari attraversati.  
- public int getTimezonePassed() = Metodo che restituisce il numero di fusi orari attraversati.  
- public void setCurrentTimezone(int t) = Metodo che imposta il fuso orario corrente.  
- public String getCurrentTimezoneString() = Metodo che restituisce la stringa del fuso orario corrente. public int getCurrentTimezoneInteger() = Metodo che restituisce il valore intero del fuso orario corrente.

**UTIL**

***FUNZIONAMENTO***   
In questa classe abbiamo il metodo che ferma il programma e mostra tutte le statistiche.

***IMPORTAZIONI***

- import java.util.Scanner; = Importa la classe Scanner.

***METODI***

-   
-   
- public static void stopProcess(Scanner scanner, SantaClaus santaClaus, GiftManager giftManager, boolean resetGiftUntilStop) = Questo metodo ferma il processo del programma, mostra tutti i regali che abbiamo consegnato e cambia il team di renne.

