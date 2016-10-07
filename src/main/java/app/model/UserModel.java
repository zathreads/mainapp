package app.model;

import java.util.HashMap;

public class UserModel extends DatabaseModel{
    private long id;
    private String name, surname, email, avatar_url, password;

    public UserModel(long id, String name, String surname, String email, String avatar_url) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.avatar_url = avatar_url;
    }

    public UserModel(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public HashMap<String, Object> tableParams(){
        HashMap map = new HashMap<String, Object>();
        map.put("name", getName());
        map.put("surname", getSurname());
        map.put("email", getEmail());
        map.put("encrypted_password", getPassword());
        map.put("avatar_url", getAvatar_url());
        return map;
    }

    @Override
    public String toString() {
        return "User: " + getName() + " " + getSurname() + " ";
    }
}
