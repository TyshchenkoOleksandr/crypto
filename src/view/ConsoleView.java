package view;

import entity.Result;

import java.util.Scanner;

import static constants.ApplicationCompletionConstants.EXCEPTION;
import static constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View {
    @Override
    public String[] getParameters() {
//        TODO move text into const
        System.out.println("Please, type 3 parameters in format (command path key)");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        return inputLine.split(" ");
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
