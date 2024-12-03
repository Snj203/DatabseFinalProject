import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class QueryService {
//    public static final String url = "jdbc:postgresql://localhost:5432/University";
    public static final String url = "jdbc:postgresql://localhost:5432/BookStore";
    public static final String username = "postgres";
    public static final String password = "qwerty123";

    private Viewer viewer;

    public QueryService(Viewer viewer){
        this.viewer = viewer;
    }
    /* --- */

    public void executeQuery(String filePath,String value, String placeholder){
        String query = loadQueryFromFile(filePath);
        query = query.replace(placeholder, "'" + value + "'");
        doQuery(query);
    }

    public void executeQuery(String filePath){
        String query = loadQueryFromFile(filePath);
        doQuery(query);
    }

    private void doQuery(String query){
        Connection connection = null;
        Statement statement = null;

        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение установлено!");

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            updateTableFromResultSet(resultSet);

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

    private void updateTableFromResultSet(ResultSet resultSet){
        DefaultTableModel model = null;
        try{
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            model = new DefaultTableModel(columnNames, 0);
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                    System.out.println(resultSet.getObject(i));
                }
                model.addRow(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        viewer.setNewTableModel(model);
    }

}
