import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class App extends JFrame implements ActionListener {

    // Instantiate Objects

    // Random stuff
     JComboBox algosDropdown;
     JLabel lblTtl;
     JLabel name;
     String selectedAlgo = "";
     JPanel panelUpper = new JPanel();
    CreateArray newArray = new CreateArray();
    ArrayList<Integer> array = newArray.createArray();
    Draw draw = new Draw(array);

    // Buttons
    JButton start;
    JButton reset;

    // Instantiate Algorithms
    BubbleSort bubble = new BubbleSort();
    SelectionSort selection = new SelectionSort();
    InsertionSort insertion = new InsertionSort();
    QuickSort quick = new QuickSort();

    // Runtime, No. Comparisons, Array Accesses
    // Objects
    JLabel runtimeLabel;
    JLabel comparisonsLabel;
    JLabel arrayAccessesLabel;

 

    // Bool value for reset check
    boolean needReset = false;

    public App(){
        // Instantiate stuff
        this.setTitle("Sorting Algorithms Visualizer");
        this.setSize(new Dimension(870, 622));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        lblTtl = new JLabel("Sorting Algorithms Visualizer");
        lblTtl.setBounds(235,0,400,60);
        lblTtl.setFont(new Font("Niagara Solid", Font.BOLD, 25));
        lblTtl.setForeground(Color.white);
        panelUpper.add(lblTtl);

        // Add Name
        name = new JLabel("Visualizer");
        name.setBounds(327,50,206,40);
        name.setFont(new Font("Niagara Solid", Font.BOLD, 16));
        name.setForeground(Color.white);
        panelUpper.add(name);

        // Runtime, Number Comparisons, Number Array Accesses
        // Runtime label
        runtimeLabel = new JLabel("Runtime: null");
        runtimeLabel.setBounds(10,10,200,30);
        runtimeLabel.setFont(new Font("Niagara Solid", Font.BOLD, 14));
        runtimeLabel.setForeground(Color.white);
        panelUpper.add(runtimeLabel);

        // Combo Box
        String[] algorithms = {"Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort"};
        algosDropdown = new JComboBox(algorithms);
        algosDropdown.setBounds(690,0,155,30);
        algosDropdown.addActionListener(this);
        panelUpper.add(algosDropdown);

        // Buttons
        // Start Button
        start = new JButton("Start Visualization");
        start.setBounds(700, 30, 140,30);
        start.addActionListener(this);
        panelUpper.add(start);

        // Reset Button
        reset = new JButton("Reset");
        reset.setBounds(700, 60, 140, 30);
        reset.addActionListener(this);
        panelUpper.add(reset);

        // Align two panels
        panelUpper.setBounds(0,0,870,100);
        draw.setBounds(0,100,870,522);

        // Set background colours
        panelUpper.setBackground(Color.black);
        draw.setBackground(Color.black);

        // Add panels
        panelUpper.setLayout(new BorderLayout());
        this.add(draw);
        this.add(panelUpper);
        this.validate();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check status before pressing start button
        if (e.getSource()==start & algosDropdown.getSelectedItem() != "Select Algorithm" & !needReset) {
            if (selectedAlgo.equals("Bubble")) {
                System.out.println("A");
                try {
                    bubble.executeBubbleSort(array, draw, this);
                    System.out.println("B");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    System.out.println("C");
                }

            } else if (selectedAlgo == "Selection") {
                try {
                    selection.executeSelectionSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Insertion") {
                try {
                    insertion.executeInsertionSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Quick") {
                try {
                    quick.executeQuickSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
            // Reset button status
            if (e.getSource()==reset) {
                array = newArray.createArray();
                draw.updateArray(array);
                draw.repaint();
                needReset = false;

            }
            // Combo box status
        if (e.getSource()==algosDropdown) {
            System.out.println(algosDropdown.getSelectedItem());
            if (algosDropdown.getSelectedItem() == "Bubble Sort") {
                selectedAlgo = "Bubble";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Selection Sort") {
                selectedAlgo = "Selection";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Insertion Sort") {
                selectedAlgo = "Insertion";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Quick Sort") {
                selectedAlgo = "Quick";
                runtimeLabel.setText("Runtime: Nlog(N)");
            }
        }

    }
}

