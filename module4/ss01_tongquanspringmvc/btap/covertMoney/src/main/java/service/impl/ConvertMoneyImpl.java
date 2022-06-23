package service.impl;

import org.springframework.stereotype.Service;
import service.IConvertMoney;

@Service
public class ConvertMoneyImpl implements IConvertMoney {
    @Override
    public double transfer(double usd) {
        return 23000*usd;
    }
}
