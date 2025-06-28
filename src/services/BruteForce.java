package services;

import entity.Result;
import exception.ApplicationException;

import static repository.ResultCode.ERROR;
import static repository.ResultCode.OK;

public class BruteForce implements Function {
    @Override
    public Result execute(String[] parameters) {
        try {
//            TODO
        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Brute force encode operation finish with exception" + e));
        }
        return new Result(OK);
    }
}
