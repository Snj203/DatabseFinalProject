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

    /**
     * Class responsible for executing queries
     * contains connection setting for database.
     * */

    public static final String url = "jdbc:postgresql://localhost:5432/BookStore";
    public static final String username = "postgres";
    public static final String password = "qwerty123";

    private StringBuilder sb;

    private Viewer viewer;

    public QueryService(Viewer viewer){
        this.viewer = viewer;
        sb = new StringBuilder();
    }

    /**
     * Method to modify queries that will have only
     * one managed attribute
     * @param filePath The File Path to query .sql file
     * @param value Value changed by user
     * @param placeholder The placeholder for that value in .sql file
     */

    public void executeQuery(String filePath,String value, String placeholder){
        String query = loadQueryFromFile(filePath);
        query = query.replace(placeholder, "'" + value + "'");
        doQuery(query);
    }

    /**
     *  Utility Method that allows to provide custom number and length modification to prepared queries
     *  while now having lots of repeated code
     *  Method it self just gets query as String and sends it to doQuery Method
     * @param filePath The File Path to query .sql file
     */

    public void executeQuery(String filePath){
        String query = loadQueryFromFile(filePath);
        doQuery(query);
    }

    /**
     * Method to modify queries with multiple changes from user
     * or/and queries that create objects in database.
     * @param filePath The File Path to query .sql file
     * @param replacers Value given by user
     */
    public void executeQuery(String filePath,String[] replacers){
        String query = loadQueryFromFile(filePath);
        for(int i= 0; i < replacers.length;i++){
            sb.setLength(0);
            sb.append("{placeholder").append(i).append("}");
            query = query.replace(sb, "'" + replacers[i] + "'");
        }
        doQuery(query);
    }

    /**
     * Method to execute final query
     * Establishes connection to the database,
     * Here also gui displaying table method is being called
     * @param query A String representation of a query
     */
    private void doQuery(String query){
        Connection connection = null;
        Statement statement = null;

        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            updateTableFromResultSet(resultSet);

        }catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());

        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Closing Error: " + e.getMessage());
            }
        }
    }

    /**
     * Method responsible for taking query as a String
     * from provided filePath
     * @param filePath The file path to sql query
     * @return A String representation of an sql query
     */
    private static String loadQueryFromFile(String filePath)  {
        StringBuilder query = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
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

    /**
     * Method responsible for proper displaying of sql query result set
     * @param resultSet An output from sql query
     */
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
