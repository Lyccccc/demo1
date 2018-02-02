package net.coderchen.demo1.model;

public class Account {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_id
     *
     * @mbg.generated
     */
    private Integer accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_name
     *
     * @mbg.generated
     */
    private String accountName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_money
     *
     * @mbg.generated
     */
    private Long accountMoney;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_id
     *
     * @return the value of account.account_id
     *
     * @mbg.generated
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_id
     *
     * @param accountId the value for account.account_id
     *
     * @mbg.generated
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_name
     *
     * @return the value of account.account_name
     *
     * @mbg.generated
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_name
     *
     * @param accountName the value for account.account_name
     *
     * @mbg.generated
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_money
     *
     * @return the value of account.account_money
     *
     * @mbg.generated
     */
    public Long getAccountMoney() {
        return accountMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_money
     *
     * @param accountMoney the value for account.account_money
     *
     * @mbg.generated
     */
    public void setAccountMoney(Long accountMoney) {
        this.accountMoney = accountMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountMoney=" + accountMoney +
                '}';
    }
}