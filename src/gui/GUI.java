/**
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * 
 * @author Didier Ngabo
 * 
 **/

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import client.PizzeriaClient;
import model.PizzaConfig;
import client.Client;

import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI extends JFrame
{

    private JPanel contentPane;
    private JTextField txtBasePrice;
    private JButton btnNewButton;
    private JComboBox comboBox;
    private JButton btnNewButton_1;
    private JButton refreshBtn;
    private JButton btnNewButton_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * 
     * @throws IOException
     */
    public GUI() throws IOException
    {
        PizzeriaClient client = new Client("localhost", 6000);
        initComponents();
        createEVents(client);

        loadCombo(client);

    }

    /***
     *
     * method to load combo box
     * 
     ***/
    private void loadCombo(PizzeriaClient client)
    {

        if (!client.getAllPizzerias().isEmpty())
        {
            comboBox.removeAllItems();
            for (String name : client.getAllPizzerias())
            {
                comboBox.addItem(name);
            }
        } else
        {
            comboBox.addItem("No available Pizzerias");
        }

    }

    /***
     *
     * method to handle events
     * 
     ***/
    private void createEVents(PizzeriaClient client)
    {

        // choose file button handler
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser file = new JFileChooser();
                file.setDialogTitle("choose config file");
                // filter ext
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.properties", "properties");
                file.setFileFilter(filter);
                int result = file.showSaveDialog(null);
                // if user click on save in Jchoosed
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    client.loadProperties(path);
                    comboBox.removeAllItems();
                    loadCombo(client);
                } else if (result == JFileChooser.CANCEL_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "No File Selected");
                    System.out.println("No File Selected");
                }
            }
        });

        // update button
        btnNewButton_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String message = client.updateBasePrice(comboBox.getSelectedItem().toString(),
                        Double.parseDouble(txtBasePrice.getText()));
                JOptionPane.showMessageDialog(null, message);
                loadCombo(client);
                txtBasePrice.setText("");
            }
        });

        // refreshing elements
        refreshBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                loadCombo(client);
            }
        });

        // details btn
        btnNewButton_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                loadCombo(client);
                String selectedItem = comboBox.getSelectedItem().toString();
                PizzaConfig config = client.getPizzeria(selectedItem);
                System.out.println(config);
                JOptionPane.showMessageDialog(null, config);
            }
        });
    }

    /***
     *
     * method to initialize component
     * 
     ***/
    private void initComponents()
    {
        setTitle("Pizzeria App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Choose File");

        btnNewButton = new JButton("select File");

        comboBox = new JComboBox();

        JLabel lblNewLabel_1 = new JLabel("base Price");

        txtBasePrice = new JTextField();
        txtBasePrice.setColumns(10);

        btnNewButton_1 = new JButton("Update");

        JTextPane textPane = new JTextPane();

        refreshBtn = new JButton("Refresh");

        btnNewButton_2 = new JButton("details");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                .createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addGap(5).addGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton,
                                                        GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(comboBox, 0, 208, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 84,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                .addComponent(txtBasePrice, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addComponent(refreshBtn)))
                                .addGap(55))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(67).addComponent(btnNewButton_2)
                                .addPreferredGap(ComponentPlacement.RELATED)))
                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE).addGap(5)));
        gl_contentPane
                .setVerticalGroup(gl_contentPane
                        .createParallelGroup(
                                Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(15)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton).addComponent(lblNewLabel))
                                .addGap(24)
                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(29)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtBasePrice, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_1).addComponent(refreshBtn))
                                .addGap(18).addComponent(btnNewButton_2).addGap(36))
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(19)
                                .addComponent(textPane, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                .addContainerGap()));
        contentPane.setLayout(gl_contentPane);

    }
}
