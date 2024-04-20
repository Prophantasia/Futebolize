package br.com.futebolize.model;


//Desenvolvido por: Rafael Soares
public class User {
    private String id;
    private String name;
    private String adress;
    private String email;
    private String password;
    private String phone;
    private String cpf;


    //Método construtor sem ID
    public User(String userName, String password, String email, String adress, String cpf, String phone) {
        this.name = userName;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.cpf = cpf;
        this.phone = phone;
    }

    //Método Construtor com ID
    public User(String id, String userName, String adress, String email, String password, String phone, String cpf) {
        this.id = id;
        this.name = userName;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.cpf = cpf;
        this.phone = phone;
    }

    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
