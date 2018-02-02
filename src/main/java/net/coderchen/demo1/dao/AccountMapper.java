package net.coderchen.demo1.dao;

import net.coderchen.demo1.model.Account;

public interface AccountMapper {
    int insert(Account record);

    int insertSelective(Account record);

    int setMoney(Account record);

    Account selectAccount(String accountName);
}