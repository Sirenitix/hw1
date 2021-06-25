package org.example.entity;

public class RegisForm {
    private String username_reg;
    private String password_first;
    private String password_second;

    public RegisForm(String username_reg, String password_first,String password_second) {
        this.username_reg = username_reg;
        this.password_first = password_first;
        this.password_second = password_second;
    }



    public RegisForm() {
    }

    public String getUsername_reg() {
        return username_reg;
    }

    public void setUsername_reg(String username_reg) {
        this.username_reg = username_reg;
    }

    public String getPassword_first() {
        return password_first;
    }

    public void setPassword_first(String password_first) {
        this.password_first = password_first;
    }

    public String getPassword_second() {
        return password_second;
    }

    public void setPassword_second(String password_second) {
        this.password_second = password_second;
    }

    @Override
    public String toString() {
        return "RegisForm{" +
                "username_reg='" + username_reg + '\'' +
                ", password_first='" + password_first + '\'' +
                ", password_second='" + password_second + '\'' +
                '}';
    }
}
