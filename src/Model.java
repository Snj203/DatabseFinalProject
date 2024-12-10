import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Model {

    private Viewer viewer;
    QueryService qService;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        qService = new QueryService(viewer);
    }

    public void doCurQuery(){
        String filePath = new String("src/queries/curQuery.sql");
        qService.executeQuery(filePath);
    }

    public void showNotActiveCustomers(){
        String filePath = new String("src/queries/SelectNotActiveCustomers.sql");
        qService.executeQuery(filePath);
    }
    public void showNSmth(String fileName){
        String placeholder = "{placeholder}";
        String replacer = JOptionPane.showInputDialog("");
        String filePath = new String("src/queries/" + fileName + ".sql");
        qService.executeQuery(filePath,replacer,placeholder);
    }
    public void showTotalSalesForBook(){
        String placeholder = "{bookTitle}";
        String book = JOptionPane.showInputDialog("Input Book Name");
        String filePath = new String("src/queries/ShowTotalSalesForBook.sql");
        qService.executeQuery(filePath,book,placeholder);
    }
    public void showActiveCustomers(){
        String placeholder = "{bought_count}";
        String boughtCount = JOptionPane.showInputDialog("Enter how many books");
        String filePath = new String("src/queries/SelectActiveCustomers.sql");
        qService.executeQuery(filePath,boughtCount,placeholder);
    }
    public void showTotalRevenue(){
        String filePath = new String("src/queries/ShowTotalRevenue.sql");
        qService.executeQuery(filePath);
    }

    public void addAuthor(){
        String placeholder = "{placeholder}";
        String replacer = JOptionPane.showInputDialog("Enter Author Name");
        String filePath = new String("src/queries/AddAuthor.sql");
        qService.executeQuery(filePath,replacer,placeholder);
    }

    public void startAddBook(){
        viewer.toggleAddBookFrame();
    }
    public void submitAddBook(){
        String filePath = new String("src/queries/AddBook.sql");
        qService.executeQuery(filePath,viewer.getAddBookField());
        viewer.toggleAddBookFrame();
    }
    public void addCustomer(){
        String[]replacers = new String[2];
        replacers[0] = JOptionPane.showInputDialog("Input Name");
        replacers[1] = JOptionPane.showInputDialog("Input Email");
        String filePath = new String("src/queries/AddCustomer.sql");
        qService.executeQuery(filePath,replacers);
    }
    public void addOrder(){
        viewer.toggleAddOrderFrame();
    }

    public void submitAddOrder(){
        String filePath = new String("src/queries/AddOrder.sql");
        qService.executeQuery(filePath,viewer.getAddOrderField());
        viewer.toggleAddOrderFrame();
    }
    public void removeSmth(String str){
        String placeholder = "{placeholder}";
        String replacer = JOptionPane.showInputDialog(str + " ID");
        String filePath = new String("src/queries/Remove" + str + ".sql");
        qService.executeQuery(filePath,replacer,placeholder);
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
