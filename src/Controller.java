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
            case("NoPurchaseCustomers"):
                model.showNotActiveCustomers();
                break;
            case("Save"):
                model.saveNewQuery();
                break;
            case("InitDB"):
                model.fillDB();
                break;
            case("Drop"):
                model.drop();
                break;
            default:
                break;
        }
    }
}
