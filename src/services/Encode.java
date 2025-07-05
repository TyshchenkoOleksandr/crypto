package services;

import entity.Result;
import exception.ApplicationException;

import java.io.*;

import static constants.CryptoAlphabet.FULL_ALPHABET;
import static repository.ResultCode.ERROR;
import static repository.ResultCode.OK;

public class Encode implements Function {
    @Override
    public Result execute(String[] parameters) {
        String filePath = parameters[1];
        String key = parameters[2];
        File originalFile = new File(filePath);
        File file = CryptoUtils.generateOutputFile(originalFile, "(ENCRYPTED)");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    if (FULL_ALPHABET.contains(String.valueOf(currentChar))) {
                        int currentCharIndex = FULL_ALPHABET.indexOf(currentChar);
                        int codedCharIndex = (currentCharIndex + Integer.parseInt(key)) % FULL_ALPHABET.length();
                        char coddedChar = FULL_ALPHABET.charAt(codedCharIndex);
                        writer.write(coddedChar);
                    } else {
                        writer.write(currentChar);
                    }
                }
                writer.newLine();
            }
        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Encode operation finish with exception" + e));
        }
        return new Result(OK);
    }
}
