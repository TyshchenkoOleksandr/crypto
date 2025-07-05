package services;

import java.io.File;

public class CryptoUtils {
    public static File generateOutputFile(File originalFile, String suffix) {
        String pathToOriginal = originalFile.getParent();
        String originalName = originalFile.getName();
        int dotIndex = originalName.lastIndexOf('.');
        String baseName = (dotIndex != -1) ? originalName.substring(0, dotIndex) : originalName;
        String extension = (dotIndex != -1) ? originalName.substring(dotIndex) : "";
        return new File(pathToOriginal, baseName + suffix + extension);
    }

    public static char shiftChar(char c, int shift, String alphabet) {
        if (!alphabet.contains(String.valueOf(c))) {
            return c;
        }
        int index = alphabet.indexOf(c);
        int newIndex = (index + shift) % alphabet.length();
        return alphabet.charAt(newIndex);
    }
}
