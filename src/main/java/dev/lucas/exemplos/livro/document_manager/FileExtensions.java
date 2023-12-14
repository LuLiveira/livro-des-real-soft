package dev.lucas.exemplos.livro.document_manager;

public enum FileExtensions {

    LETTER("letter", new LetterImporter()),
    REPORT("report",new ReportImporter()),
    JPG("jpg", new ImageImporter());

    private final String importerType;
    private final Importer importer;

    FileExtensions(String importerType, Importer importer) {
        this.importerType = importerType;
        this.importer = importer;
    }

    public String getImporterType() {
        return importerType;
    }

    public Importer getImporter() {
        return importer;
    }
}
