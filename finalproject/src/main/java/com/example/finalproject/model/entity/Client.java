package com.example.finalproject.model.entity;

import java.math.BigDecimal;

public class Client extends User {
    private long idClient;
    private String passwordNumber;
    private String email;
    private BigDecimal bankAccount;

    public Client(long idUser, String login, String password, UserRole role, String name, String surname,
                  String phoneNumber, long idClient, String passwordNumber, String email, BigDecimal bankAccount) {
        super(idUser, login, password, role, name, surname, phoneNumber);
        this.idClient = idClient;
        this.passwordNumber = passwordNumber;
        this.email = email;
        this.bankAccount = bankAccount;
    }

    public Client(String login, String password, UserRole role, String name, String surname, String phoneNumber,
                  String passwordNumber, String email, BigDecimal bankAccount) {
        super(login, password, role, name, surname, phoneNumber);
        this.passwordNumber = passwordNumber;
        this.email = email;
        this.bankAccount = bankAccount;
    }

    public Client(User user) {
        super(user.getIdUser(), user.getLogin(), user.getPassword(), user.getRole(), user.getName(), user.getSurname(), user.getPhoneNumber());
    }

    public Client() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (!passwordNumber.equals(client.passwordNumber)) return false;
        if (!email.equals(client.email)) return false;
        return bankAccount.equals(client.bankAccount);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (idClient ^ (idClient >>> 32));
        result = 31 * result + passwordNumber.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + bankAccount.hashCode();
        return result;
    }
// TODO toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("idClient=").append(idClient);
        sb.append(", passwordNumber='").append(passwordNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", bankAccount=").append(bankAccount);
        sb.append('}');
        return sb.toString();
    }

}
