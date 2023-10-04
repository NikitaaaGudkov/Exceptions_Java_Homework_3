package presenters;

import models.Model;
import models.UserData;
import models.UserDataFormatException;
import views.View;

public class Presenter {
    public void Run() {
        String[] data = View.GetData();
        int checkingCount = Model.CheckCount(data, 6);
        if (checkingCount < 0) {
            System.out.println("Вы ввели меньше данных, чем требуется");
            return;
        } else if (checkingCount > 0) {
            System.out.println("Вы ввели больше данных, чем требуется");
            return;
        }
        UserData userData = null;
        try {
            userData = Model.ParsingData(data);
        } catch (UserDataFormatException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        View.WriteToFile(userData);
    }
}
