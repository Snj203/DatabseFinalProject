import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private QuerryService qService;

    public Controller(Viewer viewer){
        qService = new QuerryService(viewer);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        switch(command){
            case("SelectAllFrom"):
                break;
            case("TotalSalesForBook"):
                qService.showTotalSalesForBook();
                break;
            case("DoCurrentQuerry"):
                qService.doCurQuerry();
                break;
            case("InitDB"):
                qService.fillDB();
                break;
            default:
                break;
        }
    }
}
