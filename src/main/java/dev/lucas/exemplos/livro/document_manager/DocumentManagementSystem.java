package dev.lucas.exemplos.livro.document_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static dev.lucas.exemplos.livro.document_manager.FileExtensions.*;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionToImporter = new HashMap<>();
    private Set<Document> documents = new HashSet<>();

    void importFile(String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf(".");
        if( separatorIndex != -1 ) {
            throw new IllegalArgumentException("No extension for file=" + path);
        }

        final String extension = path.substring(separatorIndex+1);

        Importer importer = valueOf(extension).getImporter();

        if(importer == null){
            throw new IllegalArgumentException("For file=" + path);
        }

        final Document document = importer.importFile(file);
        this.documents.add(document);

    }

    Set<Document> contents() {
        return this.documents;
    }
}
