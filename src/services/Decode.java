package services;

import entity.Result;
import exception.ApplicationException;

import static repository.ResultCode.ERROR;
import static repository.ResultCode.OK;

public class Decode implements Function {
    @Override
    public Result execute(String[] parameters) {
        try {
//            TODO
        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Decode operation finish with exception" + e));
        }
        return new Result(OK);
    }
}
