package dev.lucas.exemplos.livro.document_manager;

import java.io.File;
import java.io.IOException;

public interface Importer {

    Document importFile(File file) throws IOException;
}
