package views;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import models.UserData;

public class View {
    public static String[] GetData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите следующие данные через пробел: Фамилия Имя Отчество датарождения номертелефона пол");
        String userString = scanner.nextLine();
        scanner.close();
        return userString.split(" ");
    }

    public static void WriteToFile(UserData userData) {
        try (FileWriter writer = new FileWriter(userData.surname + ".txt", true)) {
            String text = "<" + userData.surname + "><" + userData.name + "><" + userData.patronymic + "><" + userData.birthDate + "><" + userData.phone + "><" + userData.sex + ">\n";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
