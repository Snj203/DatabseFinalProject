import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Model {

    private Viewer viewer;
    QueryService qService;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        qService = new QueryService(viewer);
    }

    public void showActiveCustomers(){
        String placeholder = "{bought_count}";
        String boughtCount = JOptionPane.showInputDialog("Input how many books bought");
        String filePath = new String("src/queries/SelectActiveCustomers.sql");
        qService.executeQuery(filePath,boughtCount,placeholder);
    }

    public void showNotActiveCustomers(){
        String filePath = new String("src/queries/SelectNotActiveCustomers.sql");
        qService.executeQuery(filePath);
    }

    public void showTotalSalesForBook(){
        String placeholder = "{bookTitle}";
        String book = JOptionPane.showInputDialog("Input Book");
        String filePath = new String("src/queries/ShowTotalSalesForBook.sql");
        qService.executeQuery(filePath,book,placeholder);
    }

    public void doCurQuery(){
        String filePath = new String("src/queries/curQuery.sql");
        qService.executeQuery(filePath);
    }

    public void saveNewQuery(){
        String filePath = new String("src/queries/curQuery.sql");
        String newQuery = viewer.getQuerryInput();
        try (FileWriter writer = new FileWriter(filePath, false)) { // false означает перезапись
            writer.write(newQuery);
            System.out.println("Файл успешно перезаписан!");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public void fillDB(){
        String filePath = new String("src/queries/fillDB.sql");
        qService.executeQuery(filePath);
    }

    public void drop(){
        String filePath = new String("src/queries/dropTables.sql");
        qService.executeQuery(filePath);
    }
}
