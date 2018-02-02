package net.coderchen.demo1.service.impl;

import net.coderchen.demo1.dao.AccountMapper;
import net.coderchen.demo1.model.Account;
import net.coderchen.demo1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Liuyuchen on 2018/02/01.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int setMoney(Account account) {
        return accountMapper.setMoney(account);
    }

    @Override
    public Account selectAccount(String accountName) {
        return accountMapper.selectAccount(accountName);
    }
}
