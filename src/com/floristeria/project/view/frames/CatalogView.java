package com.floristeria.project.view.frames;

import com.floristeria.project.application.Controller;
import com.floristeria.project.domain.Decor;
import com.floristeria.project.domain.DecorTypeEnum;
import com.floristeria.project.domain.Flower;
import com.floristeria.project.domain.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Clase de la capa View
 *
 */
public class
CatalogView extends JFrame implements ActionListener {

    private JLabel labelTittle, labelTableStock;
    private JTextField textHighTree, textColorFlower;
    private JLabel linkShowStock;
    private JLabel labelHihgTree, labelColorFlower, labelTypeDecor;
    private JButton buttonCreateTree, buttonCreateFlower, buttonCreateDecor,
            buttonCreateAll, buttonExit, buttonChangeFlorist;
    private JComboBox comboBoxTypeDecor;
    private JTable jTableStock;
    private JScrollPane scrollTableStock;
    private Controller controller;


    public CatalogView(Controller controller) {
        this.controller = controller;

        labelTittle = new JLabel();
        labelTittle.setText("<html><h2>Florist '" + controller.getFlorist().getName().toUpperCase()
                + "' </h2></html>");
        labelTittle.setBounds(40, 20, 300, 50);
        add(labelTittle);

        labelTableStock = new JLabel();
        labelTableStock.setText("Stock");
        labelTableStock.setBounds(40, 310, 100, 30);
        add(labelTableStock);

        scrollTableStock = new JScrollPane();
        scrollTableStock.setBounds(40, 340, 500, 130);
        add(scrollTableStock);

        labelHihgTree = new JLabel();
        labelHihgTree.setText("High Tree");
        labelHihgTree.setBounds(50, 80, 100, 30);
        add(labelHihgTree);

        textHighTree = new JTextField();
        textHighTree.setBounds(140, 80, 120, 30);
        add(textHighTree);

        buttonCreateTree = new JButton();
        buttonCreateTree.setBounds(340, 80, 130, 30);
        buttonCreateTree.setText("Add Tree");
        add(buttonCreateTree);

        labelColorFlower = new JLabel();
        labelColorFlower.setText("Color Flower");
        labelColorFlower.setBounds(50, 120, 100, 30);
        add(labelColorFlower);

        textColorFlower = new JTextField();
        textColorFlower.setBounds(140, 120, 120, 30);
        add(textColorFlower);

        buttonCreateFlower = new JButton();
        buttonCreateFlower.setBounds(340, 120, 130, 30);
        buttonCreateFlower.setText("Add Flower");
        add(buttonCreateFlower);

        labelTypeDecor = new JLabel();
        labelTypeDecor.setText("Type Decor");
        labelTypeDecor.setBounds(50, 160, 100, 30);
        add(labelTypeDecor);

        comboBoxTypeDecor = new JComboBox();
        comboBoxTypeDecor.addItem("Select Decor Type");
        comboBoxTypeDecor.addItem(DecorTypeEnum.PLASTIC.getType());
        comboBoxTypeDecor.addItem(DecorTypeEnum.WOOD.getType());
        comboBoxTypeDecor.setBounds(140, 160, 140, 30);
        add(comboBoxTypeDecor);

        buttonCreateDecor = new JButton();
        buttonCreateDecor.setBounds(340, 160, 130, 30);
        buttonCreateDecor.setText("Add Decor");
        add(buttonCreateDecor);

        buttonCreateAll = new JButton();
        buttonCreateAll.setBounds(340, 200, 130, 30);
        buttonCreateAll.setText("Add All");
        add(buttonCreateAll);

        linkShowStock = new JLabel();
        linkShowStock.setText("<HTML><U>Print Stock</U></HTML>");
        linkShowStock.setBounds(50, 200, 130, 60);
        linkShowStock.setFont(new Font("Verdana", Font.ITALIC, 14));
        linkShowStock.setForeground(Color.BLUE.darker());
        linkShowStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(linkShowStock);

        buttonChangeFlorist = new JButton();
        buttonChangeFlorist.setBounds(50, 260, 150, 30);
        buttonChangeFlorist.setText("Change Florist");
        add(buttonChangeFlorist);

        buttonExit = new JButton();
        buttonExit.setBounds(220, 260, 70, 30);
        buttonExit.setText("Exit");
        add(buttonExit);

        buttonCreateTree.addActionListener(this);
        buttonCreateFlower.addActionListener(this);
        buttonCreateDecor.addActionListener(this);
        buttonChangeFlorist.addActionListener(this);
        buttonCreateAll.addActionListener(this);
        buttonExit.addActionListener(this);

        addMouseListenerLinkShowStock();

        showStock();
        clear();

        setSize(650, 700);
        setTitle("Stock Florist Management");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void clear() {
        textHighTree.setText("");
        textColorFlower.setText("");
        comboBoxTypeDecor.setSelectedIndex(0);
    }

    public void showStock() {

        String tittles[] = {"High Tree", "Color Flower", "Decor Type"};
        String information[][] = getMatrixFlorist();

        jTableStock = new JTable(information, tittles);
        jTableStock.setEnabled(true);
        jTableStock.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollTableStock.setViewportView(jTableStock);

        jTableStock.addMouseListener(new MouseAdapter() {

          public void mouseClicked(MouseEvent e) {
              try {
                  printStock(controller);
              } catch (EmptyFieldException emptyFieldException) {
                  JOptionPane.showMessageDialog(null,
                          "Please Fill In the Fields", "Empty Fields Not Allowed",
                          JOptionPane.WARNING_MESSAGE);
              }
          }
        });
    }

    private String[][] getMatrixFlorist() {
        List<Tree> trees =controller.getFlorist().getTrees();
        List<Flower> flowers =controller.getFlorist().getFlowers();
        List<Decor> decors =controller.getFlorist().getDecors();

        List<List> lists = Arrays.asList(trees,flowers,decors);
        int maxSize = lists.stream().map(List::size).max(Comparator.naturalOrder()).get();

        return populateMatrix(trees, flowers, decors, maxSize);
    }

    private String[][] populateMatrix(List<Tree> trees, List<Flower> flowers, List<Decor> decors, int maxSize) {
        String informationTrees[][] = new String[trees.size()][3];
        String informationFlowers[][] = new String[flowers.size()][3];
        String informationDecors[][] = new String[decors.size()][3];

        String information[][] = new String[maxSize][3];

        for (int x = 0; x < informationTrees.length ||
                x<informationFlowers.length ||
                x<informationDecors.length; x++) {

            if (x < informationTrees.length) {
                informationTrees[x][0] = String.valueOf(trees.get(x).getHeight());
                information[x][0]= informationTrees[x][0];
            }
            if (x < informationFlowers.length) {
                informationFlowers[x][1] = flowers.get(x).getColor();
                information[x][1]= informationFlowers[x][1];
            }
            if (x < informationDecors.length) {
                informationDecors[x][2] = decors.get(x).getType();
                information[x][2]= informationDecors[x][2];
            }
        }
        return information;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonCreateTree.equals(e.getSource())) {
            createTreeAction();
        } else if (buttonCreateFlower.equals(e.getSource())) {
            createFlowerAction();
        } else if (buttonCreateDecor.equals(e.getSource())) {
            createDecorTypeAction();
        } else if (buttonCreateAll.equals(e.getSource())) {
            createTreeAction();
            createFlowerAction();
            createDecorTypeAction();
        } else if (buttonChangeFlorist.equals(e.getSource())) {
            this.setVisible(false);
            FloristView floristView = FloristView.getInstance(controller);
            floristView.setVisible(true);
        } else if (buttonExit.equals(e.getSource())) {
            System.exit(0);
        }
    }

    private void createDecorTypeAction() {
        try {
            if (comboBoxTypeDecor.getSelectedIndex()==0) {
                throw new EmptyFieldException("Empty Field Not Allowed");
            }
            controller.createDecor(comboBoxTypeDecor.getModel().getSelectedItem().toString());
        } catch (EmptyFieldException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Select a Decor Type", "Empty Field Not Allowed",
                    JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Data Entry Error", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (null != controller.getFlorist().getDecors()) {
                comboBoxTypeDecor.setSelectedIndex(0);
                showStock();

            }
        }
    }

    private void createTreeAction(){
        try {
            if (textHighTree.getText().trim().isEmpty()) {
                throw new EmptyFieldException("Empty Field Not Allowed");
            }
            Tree tree = controller.createTree(Double.parseDouble(textHighTree.getText()));
        } catch (EmptyFieldException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Fill In a High Tree", "Empty Field Not Allowed",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Data Entry Error. Please Fill In With a Number Value.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (null != controller.getFlorist().getTrees()) {
                textHighTree.setText("");
                showStock();

            }
        }

    }

    private void createFlowerAction() {
        try {
           if (textColorFlower.getText().trim().isEmpty()) {
                throw new EmptyFieldException("Empty Field Not Allowed");
           }
            Flower flower = controller.createFlower(textColorFlower.getText());

        } catch (EmptyFieldException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Fill In a Color Flower", "Empty Field Not Allowed",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Data Entry Error", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (null != controller.getFlorist().getFlowers()) {
                textColorFlower.setText("");
                showStock();
            }
        }
    }

    private void addMouseListenerLinkShowStock() {
        linkShowStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    printStock(controller);
                } catch (EmptyFieldException emptyFieldException) {
                    JOptionPane.showMessageDialog(null,
                            "Please Fill In the Fields", "Empty Fields Not Allowed",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void printStock(Controller controller) throws EmptyFieldException {
        System.out.print("STOCK FLORISTERIA ");
        controller.printStock(controller.getFlorist());
        System.out.println("========================================");
    }

}
