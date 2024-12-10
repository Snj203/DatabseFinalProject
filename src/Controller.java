import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Model model;

    public Controller(Viewer viewer){
        model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        switch(command){
            case("DoCurrentQuery"):
                model.doCurQuery();
                break;
            case("TotalSalesForBook"):
                model.showTotalSalesForBook();
                break;
            case("ActiveCustomers"):
                model.showActiveCustomers();
                break;
            case("FindNBestSellersBooks"):
                model.showNSmth("ShowBestSellersBooks");
                break;
            case("NBestAuthorInSales"):
                model.showNSmth("ShowBestSellingAuthors");
                break;
            case("NBestCustomers"):
                model.showNSmth("ShowBestCustomers");
                break;
            case("NLowStockBooks"):
                model.showNSmth("ShowLowStockBooks");
                break;
            case("NLatestOrders"):
                model.showNSmth("ShowLatestOrders");
                break;
            case("TotalRevenue"):
                model.showTotalRevenue();
                break;
            case("NoPurchaseCustomers"):
                model.showNotActiveCustomers();
                break;
            case("AddAuthor"):
                model.addAuthor();
                break;
            case("AddBook"):
                model.startAddBook();
                break;
            case("SubmitAddBook"):
                model.submitAddBook();
                break;
            case("AddCustomer"):
                model.addCustomer();
                break;
            case("AddOrder"):
                model.addOrder();
                break;
            case("SubmitAddOrder"):
                model.submitAddOrder();
                break;
            case("Save"):
                model.saveNewQuery();
                break;
            case("InitDB"):
                model.fillDB();
                break;
            case("DropDB"):
                model.drop();
                break;
            default:
                break;
        }
    }
}
