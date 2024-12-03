import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class QuerryService {
    private Viewer viewer;
//    public static final String url = "jdbc:postgresql://localhost:5432/University";
    public static final String url = "jdbc:postgresql://localhost:5432/BookStore";
    public static final String username = "postgres";
    public static final String password = "qwerty123";

    public QuerryService(Viewer viewer){
        this.viewer = viewer;
    }

    public void showTotalSalesForBook(){
        String placeholder = "{bookTitle}";
        String book = JOptionPane.showInputDialog("Input Book");
        String filePath = new String("src/queries/ShowTotalSalesForBook.sql");
        executeQuerry(filePath,book,placeholder);
    }

    public void doCurQuerry(){
        String filePath = new String("src/queries/curQuerry.sql");
        executeQuerry(filePath);
    }

    public void fillDB(){
        String filePath = new String("src/queries/fillDB.sql");
        executeQuerry(filePath);
    }



    /* --- */

    private void executeQuerry(String filePath,String value, String placeholder){
        String query = loadQueryFromFile(filePath);
        query = query.replace(placeholder, "'" + value + "'");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение установлено!");

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ShowResultSet(resultSet);

        }catch (SQLException e) {
            System.out.println("Ошибка выполнения SQL: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Ошибка закрытия ресурсов: " + e.getMessage());
            }
        }
    }
    private void executeQuerry(String filePath){
        String query = loadQueryFromFile(filePath);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение установлено!");

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ShowResultSet(resultSet);

        }catch (SQLException e) {
            System.out.println("Ошибка выполнения SQL: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Ошибка закрытия ресурсов: " + e.getMessage());
            }
        }
    }

    private static String loadQueryFromFile(String filename)  {
        StringBuilder query = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                query.append(line).append("\n");
            }
            reader.close();
        } catch (IOException ioe){
            System.out.println("IOException: " + ioe);
        }
        return query.toString();
    }

    private void ShowResultSet(ResultSet resultSet){
        try{
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException se){
            System.out.println("SQLException" + se);
        }
    }

}
