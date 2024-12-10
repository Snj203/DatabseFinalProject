import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Viewer {

    private HashMap<String,Object> containerComponents;
    private JTextArea queryInputArea;

    private JTable table;

    private JFrame addBookFrame;
    private JFrame addOrderFrame;
    private JFrame frame;

    public Viewer(){
        containerComponents = new HashMap<>();

        int buttonStartX = 800;
        int buttonStartY = 10;
        int buttonXOffset = 25;
        int buttonYOffset = 10;
        int buttonHeight = 50;
        int buttonWidth = 175;

        String [] buttonNames = new String[]{"DoCurrentQuery","TotalSalesForBook","ActiveCustomers","FindNBestSellersBooks"
                ,"NBestAuthorInSales","NBestCustomers","NLowStockBooks","NLatestOrders","TotalRevenue","NoPurchaseCustomers",
                "AddBook","AddCustomer","AddOrder","AddAuthor","RemoveOrder","RemoveBook","RemoveCustomer","RemoveAuthor"};


        Controller controller = new Controller(this);

        table = new JTable();

        JScrollPane spTable = new JScrollPane(table);
        spTable.setBounds(0, 10, 800, 500);

        queryInputArea = new JTextArea();
        queryInputArea.setText("Write new current query...");
        queryInputArea.setLineWrap(true);
        queryInputArea.setWrapStyleWord(true);
        queryInputArea.setTabSize(4);

        JScrollPane spText = new JScrollPane(queryInputArea);
        spText.setBounds(0, 510, 800, 250);

        JButton queryInputSubmitButton = new JButton("Save");
        queryInputSubmitButton.setBounds(800,710,75,50);
        queryInputSubmitButton.addActionListener(controller);

        JButton initDB = new JButton("InitDB");
        initDB.setBounds(900,710,75,50);
        initDB.addActionListener(controller);

        JButton drop = new JButton("DropDB");
        drop.setBounds(990,710,75,50);
        drop.addActionListener(controller);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(spTable);
        panel.add(spText);
        panel.add(queryInputSubmitButton);
        panel.add(initDB);
        panel.add(drop);

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

        frame = new JFrame("Bookstore");
        frame.setSize(1300, 800);
        frame.setLocation(300, 100);
        frame.add("Center", panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //__________________

        addBookFrame = new JFrame("Add Book");
        addBookFrame.setSize(400, 400);
        addBookFrame.setLocation(400,400);

        JPanel addBookPanel = new JPanel();
        addBookPanel.setLayout(new GridLayout(8, 2));

        JLabel titleBookLabel = new JLabel("Title:");
        JTextField titleBookField = new JTextField();

        JLabel genreBookLabel = new JLabel("Genre:");
        JTextField genreBookField = new JTextField();

        JLabel priceBookLabel = new JLabel("Price:");
        JTextField priceBookField = new JTextField();

        JLabel authorBookLabel = new JLabel("Author:");
        JTextField authorBookField = new JTextField();

        JButton submitButton = new JButton("SubmitAddBook");
        submitButton.addActionListener(controller);

        addBookPanel.add(titleBookLabel);
        addBookPanel.add(titleBookField);

        addBookPanel.add(genreBookLabel);
        addBookPanel.add(genreBookField);

        addBookPanel.add(priceBookLabel);
        addBookPanel.add(priceBookField);

        addBookPanel.add(authorBookLabel);
        addBookPanel.add(authorBookField);

        addBookPanel.add(new JLabel("Submit"));
        addBookPanel.add(submitButton);

        addBookFrame.add(addBookPanel);
        addBookFrame.setVisible(false);

        /*-----*/
        addOrderFrame = new JFrame("Add Order");
        addOrderFrame.setSize(400, 400);
        addOrderFrame.setLocation(400,400);

        JPanel addOrderPanel = new JPanel();
        addOrderPanel.setLayout(new GridLayout(8, 2));

        JLabel customerIdLabel = new JLabel("CustomerID:");
        JTextField customerIdField= new JTextField();

        JLabel bookIdLabel = new JLabel("BookID:");
        JTextField bookIdField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();

        JButton submitButton2 = new JButton("SubmitAddOrder");
        submitButton2.addActionListener(controller);

        addOrderPanel.add(customerIdLabel);
        addOrderPanel.add(customerIdField);

        addOrderPanel.add(bookIdLabel);
        addOrderPanel.add(bookIdField);

        addOrderPanel.add(quantityLabel);
        addOrderPanel.add(quantityField);


        addOrderPanel.add(new JLabel("Submit"));
        addOrderPanel.add(submitButton2);

        addOrderFrame.add(addOrderPanel);
        addOrderFrame.setVisible(false);
        /*-------*/

        containerComponents.put("priceBook",priceBookField);
        containerComponents.put("genreBook",genreBookField);
        containerComponents.put("titleBook",titleBookField);
        containerComponents.put("authorBook",authorBookField);

        containerComponents.put("customerId",customerIdField);
        containerComponents.put("bookId",bookIdField);
        containerComponents.put("quantity",quantityField);

    }
    public void toggleAddBookFrame(){
        ((JTextField)(containerComponents.get("genreBook"))).setText("");
        ((JTextField)(containerComponents.get("titleBook"))).setText("");
        ((JTextField)(containerComponents.get("priceBook"))).setText("");
        ((JTextField)(containerComponents.get("authorBook"))).setText("");
        if(addBookFrame.isVisible()){
            addBookFrame.setVisible(false);
        }else{
            addBookFrame.setVisible(true);
        }
    }
    public void toggleAddOrderFrame(){
        ((JTextField)(containerComponents.get("customerId"))).setText("");
        ((JTextField)(containerComponents.get("bookId"))).setText("");
        ((JTextField)(containerComponents.get("quantity"))).setText("");
        if(addOrderFrame.isVisible()){
            addOrderFrame.setVisible(false);
        }else{
            addOrderFrame.setVisible(true);
        }
    }
    public String[] getAddBookField(){
        String[] fields = new String[4];
        fields[0] = ((JTextField)(containerComponents.get("titleBook"))).getText();
        fields[1] = ((JTextField)(containerComponents.get("genreBook"))).getText();
        fields[2] = ((JTextField)(containerComponents.get("priceBook"))).getText();
        fields[3] = ((JTextField)(containerComponents.get("authorBook"))).getText();
        return fields;
    }
    public String[] getAddOrderField(){
        String[] fields = new String[3];
        fields[0] = ((JTextField)(containerComponents.get("customerId"))).getText();
        fields[1] = ((JTextField)(containerComponents.get("bookId"))).getText();
        fields[2] = ((JTextField)(containerComponents.get("quantity"))).getText();
        return fields;
    }
    public String getQuerryInput(){
        System.out.println(queryInputArea.getText());
        return queryInputArea.getText();
    }

    public void setNewTableModel(DefaultTableModel model) {
        table.setModel(model);
    }
}
