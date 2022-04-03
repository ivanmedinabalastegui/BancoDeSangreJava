import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mysql_test extends mysql {

    public static void main(String[] args) {
        mysql db = new mysql();
        db.MySQLConnect();

    }
}
