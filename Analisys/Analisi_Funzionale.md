# **ANALISI FUNZIONALE**

---

## **1 Dati iniziali**

La prima parte del progetto e’ generare un set di dati casuale in un file json.  
Questo e’ un file di esempio:

```json  
[
    {
        "timezone": "UTC-12:00",
        "countries": [
            {
                "name": "Kiribati (Isole della Linea)",
                "population": 119449,
                "good_children_percentage": 0.87
            }
        ]
    },
    ...
]
```

Il programma leggera' questo file a ogni simulazione e istanziare l'oggetto Country con i dati corretti.

**Dati da leggere:**

- Nome dello stato  
- Popolazione totale (numerica).
- Percentuale di bambini buoni (un valore casuale tra 70% e 90%).

## **2 Gestione delle Consegne**

La funzione principale del sistema e' la **gestione delle consegne** dei regali da parte di Babbo Natale e Rudolph. Per farlo, il sistema dovra' tenere conto di:

**Programmazione delle consegne**:  
Le consegne devono essere organizzate in base ai **fusi orari**.

**L’ordine dei fuso orari**  
La consegna iniziera’ dal fuso orario che viene prima colpito dal sole: UTC-12:00

## **3 Cambio delle Renne**

Una volta che Babbo Natale e Rudolph hanno consegnato un certo numero di regali (250 milioni), o hanno attraversato più di 3 fusi orari, e' necessario effettuare un **cambio delle renne**. Le due squadre di renne sono disponibili per alternarsi, mentre Rudolph non e' mai sostituito e resta sempre operativo.

**Controllo per cambio delle renne**:  
Ogni volta che il numero di consegne supera 200 milioni, o si attraversano più di 3 fusi orari, il sistema deve determinare che e' necessario il cambio delle renne.

**Gestione delle due squadre**:  
Ogni squadra di renne e' composta da una squadra attiva e una squadra di riserva.  
Rudolph resta sempre operativo, mentre una delle due squadre viene sostituita mentre riposa.

## **4 Interfaccia e Funzionalita' per gli Utenti**

Ad ogni stop del programma viene stampato un messaggio contenente:

- Fuso orario corrente  
- Fuso orario successivo  
- Fusi orari passati  
- Numero di regali consegnati  
- Cambi di renne effettuati  
- Squadra di renne attiva  
- Squadra di renne a riposo

Dopo aver stampato le informazioni il programma aspetta la pressione del tasto invio per continuare con la simulazione.

## **5 Report e Documentazione**

Il sistema deve generare e salvare un **report** che contenga informazioni dettagliate sul progresso delle consegne, sulle squadre di renne e sullo stato del sistema. Il report deve includere:

- Un **diario delle consegne**.
- Lo storico **dei cambi delle renne**
