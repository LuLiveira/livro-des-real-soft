package dev.lucas.exemplos.livro.document_manager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static dev.lucas.exemplos.livro.document_manager.Attributes.*;

public class ImageImporter implements Importer {
    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH.value, file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH.value, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT.value, String.valueOf(image.getHeight()));
        attributes.put(TYPE.value, "IMAGE");

        return new Document(attributes);
    }
}
