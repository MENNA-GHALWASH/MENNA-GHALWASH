//problems i have :
//cant get the ui right
//dont know how to access table columns and rows to get their data : try get Invsdata
//how to properly align csv data into the invoice table?

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Date;
import java.util.Vector;

public class project1 extends JFrame implements ActionListener {
    private int invoicenum = 0;
    private JTable InvsTable; //create table
    private JTable InvItemsTable;

    private String[] InvsTablecols = {"No.", "Date", "Customer", "Total"}; //table col names
    private String[][] Invsdata = {}; //tables data
    private String[][] InvsItemsdata = new String[7][5]; //keep track

    private String[] InvsItemsTablecols = {"No.", "Item Name", "Item Price", "Count", " Item Total"};

    private JButton Create;
    private JButton Delete;
    private JButton Save;
    private JButton Cancel;
    private JLabel InvNo;
    private JLabel InvVal;
    private JLabel InvDate;
    private JLabel CustName;
    private JLabel InvTotal;
    private JLabel InvTotalVal, rightTabletitle, Lefttabletitle;
    private JTextField InvDt_txt;
    private JTextField CusName_txt;
    private JSplitPane testDP;
    private JMenuBar menuBar;
    private JMenuItem LoadFile;
    private JMenuItem SaveFile;
    private JMenu File;
    private JPanel right, left, input, righttbl, lefttbl, rightbuttons, leftbuttons;

    public project1() {
        super("Sales invoice generator");
        setSize(700, 500);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        File = new JMenu("File");
        LoadFile = new JMenuItem("Load file", 'l');
        SaveFile = new JMenuItem("Save file", 's');
        SaveFile.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        testDP = new JSplitPane();
        InvNo = new JLabel("Invoice Number ");
        InvDate = new JLabel("Invoice Date ");
        CustName = new JLabel("Customer Name ");
        InvTotal = new JLabel("Invoice Total ");
        String A = Integer.toString(invoicenum);
        InvVal = new JLabel(A);
        InvTotalVal = new JLabel("350.0");
        InvDt_txt = new JTextField(20);
        CusName_txt = new JTextField(20);
        Create = new JButton("Create new Invoice");
        Delete = new JButton("Delete Invoice");
        Save = new JButton("Save");
        Cancel = new JButton("Cancel");
        right = new JPanel();
        left = new JPanel();
        input = new JPanel(); //done
        righttbl = new JPanel();
        lefttbl = new JPanel();
        rightbuttons = new JPanel();
        leftbuttons = new JPanel();
        rightTabletitle = new JLabel("Invoice items");
        Lefttabletitle = new JLabel("Invoices table");

        DefaultTableModel tm = new DefaultTableModel(Invsdata, InvsTablecols);
        InvsTable = new JTable(tm);

        DefaultTableModel tm2 = new DefaultTableModel(InvsItemsdata, InvsItemsTablecols);
        InvItemsTable = new JTable(tm2);

        setJMenuBar(menuBar); //adds the menu bar to the panel
        menuBar.add(File);
        File.add(LoadFile);
        File.add(SaveFile);

        BorderLayout BL = new BorderLayout();
        //input.setLayout(BL);
        GridLayout GL = new GridLayout(4, 2);

        // setLayout(new FlowLayout());
//        testDP.setSize(350,500);
//        add(testDP);

        input.add(InvNo); //contains the input part
        input.add(InvVal);
        input.add(InvDate);
        input.add(InvDt_txt);
        input.add(CustName);
        input.add(CusName_txt);
        input.add(InvTotal);
        input.add(InvTotalVal);

        GridLayout Gl2 = new GridLayout(2, 1);
        righttbl.add(rightTabletitle);
        righttbl.add(InvItemsTable);
        righttbl.setLayout(Gl2);

        lefttbl.add(Lefttabletitle); //contains the table and its title
        lefttbl.add(InvsTable);
        lefttbl.setLayout(Gl2);

        GridLayout GLt = new GridLayout(4, 2);
        //GL.setHgap(0);
        input.setLayout(GLt); //done

        GridLayout GLtmain = new GridLayout(1, 2);
        // GL.setHgap(0);


        /*input.setSize(200,200);
        input.setVisible(true);
        add(input);*/
        add(new JScrollPane(InvsTable));
        //add(new JScrollPane(InvItemsTable));
        //add(Create);
        //add(Delete);
        righttbl.add(new JScrollPane(InvItemsTable));

        lefttbl.add(new JScrollPane(InvsTable));

        rightbuttons.add(Save);
        rightbuttons.add(Cancel);
        rightbuttons.setLayout(GLtmain);

        leftbuttons.add(Create);
        leftbuttons.add(Delete);
        leftbuttons.setLayout(GLtmain);
        leftbuttons.setSize(200, 50);
        //add(InvDt_txt);
        //add(CusName_txt);
        //add(InvVal);
        //add(InvTotalVal);

        //add(input);
//        setJMenuBar(menuBar);
//        menuBar.add(File);
//        File.add(LoadFile);
//        File.add(SaveFile);
//        add(menuBar);
        GridLayout rt = new GridLayout(3, 1);
        right.add(input);
        right.add(righttbl);
        right.add(rightbuttons);
        right.setLayout(rt);

        GridLayout lft = new GridLayout(2, 1);
        left.add(lefttbl);
        left.add(leftbuttons);
        left.setLayout(lft);

        add(left); //left and right are still empty
        add(right);
        //setLayout(new FlowLayout());
        setLayout(GLtmain);

        Create.addActionListener(this);
        Delete.addActionListener(this);
        Save.addActionListener(this);
        Cancel.addActionListener(this);

        Create.setActionCommand("Cr");
        Delete.setActionCommand("D");
        Save.setActionCommand("S");
        Cancel.setActionCommand("Cx");

        LoadFile.setActionCommand("Lf");
        SaveFile.setActionCommand("Sf");
    }

    public static void main(String[] args) {
        new project1().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int invnom = 1;
        switch (e.getActionCommand()) {

            case "Cr":
                //if user clicks on create then the invnom value is increased by 1 and assigned to invoince number
//should create a new invoice by automatically increasing invoice number and providing it to the label InvVal
//and blanks the entry screen on the right except for the number
                break;

            case "D":/*
                InvDt_txt.setText("");
                CusName_txt.setText("");
                InvVal.setText("0");
                InvTotalVal.setText("0");*/
                deleteRow();
                if (Integer.parseInt(InvVal.getText()) > 0) {
                    invoicenum--;
                    InvVal.setText(Integer.toString(invoicenum));

                }

//should delete selected row from the Invstable
                break;

            case "S":
                invoicenum++;
                InvVal.setText(Integer.toString(invoicenum));
                insertRow();

                break;

            case "Cx": //ths one is done
                InvDt_txt.setText(null);
                CusName_txt.setText(null);
                InvVal.setText(null);
                break;

            case "Lf":
      //          loadfile();
                break;

            case "Sf":
        //        saveFile();
                break;
        }
    }

    private void insertRow() {
        String invDate = InvDt_txt.getText();
        String Name = CusName_txt.getText();
        String invoiceNo = InvVal.getText();
        String total = InvTotalVal.getText();

        DefaultTableModel model = (DefaultTableModel) InvsTable.getModel();

        model.addRow(new Object[]{invDate, Name, invoiceNo, total});
    }

    private void deleteRow() {
        DefaultTableModel model = (DefaultTableModel) InvsTable.getModel();
        if (InvsTable.getSelectedRow() != -1) {
            model.removeRow(InvsTable.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
        }
    }

   /* private void loadfile() {
    }


    private void saveFile() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                // change to table
                // byte[] b = txtarea.getText().getBytes();
                //fos.write(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                }

            }*/

        //}
    //}
}