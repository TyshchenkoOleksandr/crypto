package app;

import controller.MainController;
import entity.FunctionCode;
import entity.Result;
import services.Function;

import static constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run() {
        String[] parameters = mainController.getView().getParameters();
        String mode = parameters[0];
        Function function = getFunction(mode);
        return function.execute(parameters);
    }

    private Function getFunction(String mode) {
        return switch (mode) {
            case "ENCRYPT" -> FunctionCode.valueOf(ENCODE).getFunction();
            case "DECRYPT" -> FunctionCode.valueOf(DECODE).getFunction();
            case "BRUTE_FORCE" -> FunctionCode.valueOf(BRUTE_FORCE).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
        };
    }

    public void printResult (Result result) {
        mainController.getView().printResult(result);
    }
}
