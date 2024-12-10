import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    /**
     * The Controller class is responsible for handling user actions, such as button clicks
     * The class implements the ActionListener interface,
     * allowing it to listen for user actions and execute the corresponding actions in the application.
     *
     */
    private Model model;

    public Controller(Viewer viewer){
        model = new Model(viewer);
    }

    /**
     * Called when an action is performed by the user .
     * Calls methods in model to properly react to user actions.
     * @param e The ActionEvent that triggered this method call, containing the action command.
     */

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
            case("RemoveOrder"):
                model.removeSmth("Order");
                break;
            case("RemoveBook"):
                model.removeSmth("Book");
                break;
            case("RemoveCustomer"):
                model.removeSmth("Customer");
                break;
            case("RemoveAuthor"):
                model.removeSmth("Author");
                break;
            case("ReplenishBook"):
                model.replenishBook();
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
