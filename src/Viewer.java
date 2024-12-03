import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Viewer {

    private HashMap<String,Object> containerComponents;
    private JTextArea inputArea;

    private JButton inputButton;

    public Viewer(){
        containerComponents = new HashMap<>();

        int buttonStartX = 800;
        int buttonStartY = 10;
        int buttonXOffset = 25;
        int buttonYOffset = 10;
        int buttonHeight = 75;
        int buttonWidth = 175;

        String [] buttonNames = new String[]{"DoCurrentQuerry","TotalSalesForBook","ActiveCustomers","FindNBestSellersBooks"
                ,"NBestAuthorInSales","NBestCustomers","NLowStockBooks","NLatestOrders","TotalRevenue","NoPurchaseCustomers"};


        Controller controller = new Controller(this);

        JTable table = new JTable();

        JScrollPane spTable = new JScrollPane(table);
        spTable.setBounds(0, 10, 800, 500);

        JTextArea queryInputArea = new JTextArea();
        queryInputArea.setText("Write new current querry...");
        queryInputArea.setLineWrap(true);
        queryInputArea.setWrapStyleWord(true);

        JScrollPane spText = new JScrollPane(queryInputArea);
        spText.setBounds(0, 510, 800, 250);

        JButton queryInputSubmitButton = new JButton("Save");
        queryInputSubmitButton.setBounds(800,710,75,50);
        queryInputSubmitButton.addActionListener(controller);

        JButton initDB = new JButton("InitDB");
        initDB.setBounds(900,710,75,50);
        initDB.addActionListener(controller);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(spTable);
        panel.add(spText);
        panel.add(queryInputSubmitButton);
        panel.add(initDB);

        for(int i = 0; i < buttonNames.length;i++){
            JButton bt = new JButton(buttonNames[i]);
            bt.setBounds(buttonStartX + buttonXOffset,buttonStartY + buttonYOffset,buttonWidth,buttonHeight);
            buttonStartX = buttonStartX + buttonWidth + buttonXOffset;
            if(i % 2 != 0){
                buttonStartX = 800;
                buttonStartY = buttonStartY + buttonHeight + buttonYOffset;
            }
            bt.addActionListener(controller);
            panel.add(bt);
        }

        JFrame frame = new JFrame("Bookstore");
        frame.setSize(1300, 800);
        frame.setLocation(300, 100);
        frame.add("Center", panel);
        frame.setVisible(true);
    }


}
