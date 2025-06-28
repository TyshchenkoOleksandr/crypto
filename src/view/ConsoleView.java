package view;

import entity.Result;

import static constants.ApplicationCompletionConstants.EXCEPTION;
import static constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View {
    @Override
    public String[] getParameters() {
        // TODO
        return new String[0];
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
