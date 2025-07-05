package services;

import entity.Result;
import exception.ApplicationException;

import java.io.*;
import java.util.ArrayList;

import static constants.CryptoAlphabet.FULL_ALPHABET;
import static constants.CryptoDictionary.COMMON_WORDS;
import static repository.ResultCode.ERROR;
import static repository.ResultCode.OK;

public class BruteForce implements Function {
    @Override
    public Result execute(String[] parameters) {
        String filePath = parameters[1];
        File originalFile = new File(filePath);
        File file = CryptoUtils.generateOutputFile(originalFile, "(BRUT_FORCE)");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
        ) {
            StringBuilder fullContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fullContent.append(line).append(System.lineSeparator());
            }
            
            ArrayList<String> resultsArray = new ArrayList<String>();
            for (int i = 0; i < FULL_ALPHABET.length(); i++) {
                String decodedString = "";
                for (int j = 0; j < fullContent.length(); j++) {
                    char currentChar = fullContent.charAt(j);
                    if (FULL_ALPHABET.contains(String.valueOf(currentChar))) {
                        int currentCharIndex = FULL_ALPHABET.indexOf(currentChar);
                        int codedCharIndex = (currentCharIndex + i) % FULL_ALPHABET.length();
                        char coddedChar = FULL_ALPHABET.charAt(codedCharIndex);
                        decodedString = decodedString + coddedChar;
                    } else {
                        decodedString = decodedString + currentChar;
                    }
                }
                resultsArray.add(i, decodedString);
            }
            int bestWordMatchCount = 0;
            String bestResult = "";
            for (int i = 0; i < resultsArray.size(); i++) {
                int localMatchCounter = 0;
                String currentResultString = resultsArray.get(i);
                String[] words = currentResultString.split("\\s+");
                for (String word : words) {
                    for (int j = 0; j < COMMON_WORDS.size(); j++) {
                        String currentCommonWord = COMMON_WORDS.get(j);
                        if (currentCommonWord.equals(word)) {
                            localMatchCounter++;
                        }
                    }

                }
                if (localMatchCounter > bestWordMatchCount) {
                    bestResult = currentResultString;
                    bestWordMatchCount = localMatchCounter;
                }
            }
            writer.write(bestResult);
        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Brute force encode operation finish with exception" + e));
        }
        return new Result(OK);
    }
}
