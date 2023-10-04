package models;

public class Model {
    public static int CheckCount(String[] data, int expectedNumber) {
        int size = data.length;
        if(size < expectedNumber) {
            return -1;
        } else if (size > expectedNumber) {
            return 1;
        }
        return 0;
    }

    public static UserData ParsingData(String[] data) throws UserDataFormatException {
        String surname = null;
        String name = null;
        String patronymic = null;
        String birthDate = null;
        long phone = 0;
        String sex = null;
        for(int i = 0; i < data.length; ++i) {
            if(data[i].equals("f") || data[i].equals("m")) {
                sex = data[i];
                continue;
            } else if(data[i].matches("\\d{2}.\\d{2}.\\d{4}")) {
                birthDate = data[i];
                continue;
            } else if(data[i].matches("\\d{11}")) {
                phone = Long.parseLong(data[i]);
                continue;
            } else {
                surname = data[i];
                ++i;
                if(i < data.length) {
                    name = data[i];
                    ++i;
                    if(i < data.length) {
                        patronymic = data[i];
                    }
                }
            }
        }
        UserData result = new UserData(surname, name, patronymic, birthDate, phone, sex);
        CheckUserData(result);
        return result;
    }

    public static void CheckUserData(UserData ud) throws UserDataFormatException {
        String pattern = "Не удалось разбить ";
        String message = pattern;
        if(ud.surname == null) {
            message += "фамилию, ";
        } 
        if (ud.name == null) {
            message += "имя, ";
        } 
        if (ud.patronymic == null) {
            message += "отчество, ";
        } 
        if (ud.birthDate == null) {
            message += "дату рождения, ";
        } 
        if (ud.phone == 0) {
            message += "номер телефона, ";
        } 
        if (ud.sex == null) {
            message += "пол, ";
        }
        if(message != pattern) {
            message += "у пользователя";
            message = message.replace(", у пользователя", " у пользователя");
            throw new UserDataFormatException(message);
        }
    }
}
