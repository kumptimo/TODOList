package todolist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class GUI extends JPanel {

    private JTable thingsTodo;
    private final JScrollPane todoTextPanel;
    private DefaultTableModel model;
    private final JButton addTaskButton, markReadyButton, removeTaskButton, quitButton;
    String[] columnNames = {"Deadline", "Status", "Description"};

    public GUI(JFrame mainFrame) throws IOException {

        addTaskButton = new JButton("Add task");
        markReadyButton = new JButton("Mark selected ready");
        removeTaskButton = new JButton("Remove selected task");
        quitButton = new JButton("Quit");

        model = new DefaultTableModel(0, columnNames.length);
        model.setColumnIdentifiers(columnNames);
        model.addRow(new Object[]{"Add date", "Not ready", "Add description"});
        thingsTodo = new JTable(model);
        thingsTodo.getColumnModel().getColumn(0).setPreferredWidth(60);
        thingsTodo.getColumnModel().getColumn(1).setPreferredWidth(60);
        thingsTodo.getColumnModel().getColumn(2).setPreferredWidth(500);

        JPanel backGround = new JPanel();
        JPanel buttonPanel = new JPanel();
        todoTextPanel = new JScrollPane(thingsTodo);
        backGround.setLayout(new BoxLayout(backGround, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        ActionListener aL1 = (ActionEvent actionEvent) -> {
            model.addRow(new Object[]{"Add date", "Not ready", "Add description"});
        };

        ActionListener aL2 = (ActionEvent actionEvent) -> {
            model.setValueAt("Ready", thingsTodo.getSelectedRow(), 1);
        };

        ActionListener aL3 = (ActionEvent actionEvent) -> {
            model.removeRow(thingsTodo.getSelectedRow());
        };

        ActionListener aL4 = (ActionEvent actionEvent) -> {
            Runtime.getRuntime().exit(0);
        };

        addTaskButton.setPreferredSize(new Dimension(160, 30));
        markReadyButton.setPreferredSize(new Dimension(160, 30));
        removeTaskButton.setPreferredSize(new Dimension(160, 30));
        quitButton.setPreferredSize(new Dimension(80, 30));

        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 1;
        c.weightx = 0;

        c.insets = new Insets(0, 0, 0, 3);
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(addTaskButton, c);
        addTaskButton.addActionListener(aL1);
        addTaskButton.setActionCommand("true");

        c.insets = new Insets(0, 3, 0, 3);
        c.gridx = 1;
        c.gridy = 0;
        buttonPanel.add(markReadyButton, c);
        markReadyButton.addActionListener(aL2);
        markReadyButton.setActionCommand("true");

        c.insets = new Insets(0, 3, 0, 10);
        c.gridx = 2;
        c.gridy = 0;
        buttonPanel.add(removeTaskButton, c);
        removeTaskButton.addActionListener(aL3);
        removeTaskButton.setActionCommand("true");
     
        c.insets = new Insets(0, 5, 0, 0);
        c.gridx = 3;
        c.gridy = 0;
        buttonPanel.add(quitButton, c);
        quitButton.addActionListener(aL4);
        quitButton.setActionCommand("true");

        backGround.add(todoTextPanel);
        backGround.add(buttonPanel);

        todoTextPanel.setPreferredSize(new Dimension(600, 150));

        buttonPanel.setPreferredSize(new Dimension(600, 50));

        super.add(backGround);
    }

}
