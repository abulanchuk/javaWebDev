package com.example.finalproject.entity;

import java.math.BigDecimal;

public class Client extends CustomEntity{
   private long idClient;
    private String passwordNumber;
    private String email;
    private BigDecimal bankAccount;
    private long idUser;

    public Client(long idClient, String passwordNumber, String email, BigDecimal bankAccount, long idUser) {
        this.idClient = idClient;
        this.passwordNumber = passwordNumber;
        this.email = email;
        this.bankAccount = bankAccount;
        this.idUser = idUser;
    }

    public long getIdClient() {
        return idClient;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getBankAccount() {
        return bankAccount;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBankAccount(BigDecimal bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (idUser != client.idUser) return false;
        if (!passwordNumber.equals(client.passwordNumber)) return false;
        if (!email.equals(client.email)) return false;
        return bankAccount.equals(client.bankAccount);
    }

    @Override
    public int hashCode() {
        int result = (int) (idClient ^ (idClient >>> 32));
        result = 31 * result + (passwordNumber != null ? passwordNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (bankAccount != null ? bankAccount.hashCode() : 0);
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("idClient=").append(idClient);
        sb.append(", passwordNumber='").append(passwordNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", idUser=").append(idUser);
        sb.append('}');
        return sb.toString();
    }
}
