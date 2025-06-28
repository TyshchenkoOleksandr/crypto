package services;

import entity.Result;
import exception.ApplicationException;

import static repository.ResultCode.ERROR;
import static repository.ResultCode.OK;

public class Encode implements Function {
    @Override
    public Result execute(String[] parameters) {
        try {
//            TODO
        } catch (Exception e) {
            return new Result(ERROR, new ApplicationException("Encode operation finish with exception" + e));
        }
        return new Result(OK);
    }
}
