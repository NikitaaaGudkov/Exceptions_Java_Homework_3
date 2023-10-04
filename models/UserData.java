package models;
public class UserData {
    public String surname;
    public String name;
    public String patronymic;
    public String birthDate;
    public long phone;
    public String sex;

    public UserData(String surname, String name, String patronymic, String birthDate, long phone, String sex) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phone = phone;
        this.sex = sex;
    }
}