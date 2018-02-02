package net.coderchen.demo1.service;

import net.coderchen.demo1.model.Account;

/**
 * Created by Liuyuchen on 2018/02/01.
 */
public interface AccountService {

    public int setMoney(Account account);

    public Account selectAccount(String accountName);
}
