package com.iu.application.logic;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.iu.application.entity.Artikel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.stream.Stream;

public class AbschreibungLogic {
    private Artikel artikel;
    //Variables
    private LocalDate heute = LocalDate.now();
    private double gesamtPreis;
    //PDF Components
    private final String[] artikelTableColumns= {"Artikel", "Preis", "Anzahl","Preis Gesamt","Anschaffungdatum","Nutzungsdauer"};
    private final String[] abschreibungTableColumns= {"Jahr","Restabschreibungssumme","Afa 7,7%","Restbetrag Ende des Jahres"};

    /**
     * Startet nach der Überprüfung das erzeugen der Abschreibung
     * @param artikel
     * @return ja=abschreibung erfolgreich / nein = abschreibung nicht möglich
     */
    public Boolean createAbschreibung(Artikel artikel){
        this.artikel = artikel;
        if(checkKaufDatum()&&checkPreis()){
            createAbschreibungPDF();
            return true;
        }
        return false;
    }

    /**
     * Überprüft ob das Kaufdatum minedestns 1 Jahr zurückliegt
     * @return Ja / Nein
     */
    private Boolean checkKaufDatum(){
        return artikel.getKaufDatum().isBefore(heute.minusYears(1))? true:false;
    }

    /**
     * Überprüft ob der Preis hoch genug für eine Abschreibung ist.
     * @return
     */
    private boolean checkPreis() {
        gesamtPreis = artikel.getAnzahl()*artikel.getPreis();
        return gesamtPreis >= 800 ? true:false;
    }

    /**
     * Erstellt das Dokument für die Abschreibung.
     */
    private void createAbschreibungPDF() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("c:/temp/Abschreibung_"+artikel.getName()+".pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();

        //Header PDF Dokument
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25, BaseColor.BLACK);
        Chunk header = new Chunk("Abschreibung für Artikel:"+artikel.getName(), font);

        //Body PDF Dokument
        PdfPTable artikelTabelle = createTabelle(6,artikelTableColumns,false);
        PdfPTable abschreibungsTabelle = createTabelle(4,abschreibungTableColumns,true);

        //Hinzufügen der Componenten
        try {
            document.add(header);
            document.add(new Phrase("\n"));
            document.add(artikelTabelle);
            document.add(new Phrase("\n"));
            document.add(abschreibungsTabelle);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }

    /**
     * Ersetllet eine Tabelle für Artikel oder eine Abschreibung
     * @param columnAnzahl
     * @param tableCoumns
     * @param isAbschreibungsTabelle
     * @return Tabelle
     */
    private PdfPTable createTabelle(int columnAnzahl, String[] tableCoumns,Boolean isAbschreibungsTabelle) {
        PdfPTable table = new PdfPTable(columnAnzahl);
        addTableHeader(table,tableCoumns);
        if(isAbschreibungsTabelle){
            berechneAbschreibung(table);
        }else {
            addRows(table);
        }
        table.completeRow();
        return table;
    }

    /**
     * Fügt den Tabellen aus dem Document den header hinzu.
     * @param table
     * @param columns
     */
    private void addTableHeader(PdfPTable table, String[] columns) {
        Stream.of(columns)
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    /**
     * Befüllt die Zellen der einzelnen Tabellen Reihen
     * @param table
     */
    private void addRows(PdfPTable table) {
        table.addCell(artikel.getName());
        table.addCell(String.valueOf(artikel.getPreis())+"€");
        table.addCell(String.valueOf(artikel.getAnzahl()));
        table.addCell(String.valueOf(gesamtPreis)+"€");
        table.addCell(String.valueOf(artikel.getKaufDatum()));
        table.addCell("13 Jahre");
    }

    /**
     * Methode zum berechnen und befüllen der AbschreibungsTabelle
     * @param table AbschreibungsTabelle
     */
    private void berechneAbschreibung(PdfPTable table) {
        DecimalFormat decimalFormat =  new DecimalFormat("####.##");
        double restbetrag = gesamtPreis;
        double afaSatz;
        for(int i = 1 ; i<=13;i++) {
            if(restbetrag != 0) {
                table.addCell(String.valueOf(i));
                table.addCell(String.valueOf(decimalFormat.format(restbetrag)) + "€");
                table.addCell(String.valueOf(decimalFormat.format(afaSatz = restbetrag * 0.2)) + "€");
                table.addCell(String.valueOf(decimalFormat.format(restbetrag = restbetrag - afaSatz)) + "€");
            }else {
                break;
            }
        }
    }
}
