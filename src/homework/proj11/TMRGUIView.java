package homework.proj11;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.12.2017
 * @dueDate 4.13.2017
 * @description Travel Mileage Calculator
 */
public class TMRGUIView extends JFrame implements ActionListener {

    // instance variables
    private final Container contentPane;
    
    // panel to get number of cities
    private final JPanel pnlNumOfCities;
    private final JLabel lblNumOfCities;
    private final JTextField txtNumOfCities;
    private final JButton btnNumOfCites;
    
    // panel to get starting city
    private final JPanel pnlStartingCity;
    private final JLabel lblStartingCity;
    private final JComboBox<Cities> comboStartingCity;
    private final JButton btnStartingCity;
    
    // panel to get next city
    private final JPanel pnlNextCity;
    private final JLabel lblNextCity;
    private final JComboBox<Cities> comboNextCity;
    private final JButton btnNextCity;

    // panel to show results
    private final JPanel pnlResults;
    private final JTextArea txtResults;
    private final JButton exitButton;
    
    private int numCitiesVisited;
    private Cities startingCity;
    private Cities currentCity;
    private TMRData cityData;
    
    // constructor
    public TMRGUIView(){
        super();

        this.setTitle("MyWBFPRSGUI_Demo");
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.contentPane = this.getContentPane();
        this.contentPane.setLayout(new FlowLayout());
        
        // panel to get number of cities
        this.pnlNumOfCities = new JPanel();
        this.lblNumOfCities = new JLabel("How many cities were visited: ");
        this.txtNumOfCities = new JTextField(5);
        this.btnNumOfCites = new JButton("Enter");
        this.btnNumOfCites.addActionListener(this);
        this.pnlNumOfCities.add(this.lblNumOfCities);
        this.pnlNumOfCities.add(this.txtNumOfCities);
        this.pnlNumOfCities.add(this.btnNumOfCites);
        
        // panel to get starting city
        this.pnlStartingCity = new JPanel();
        this.lblStartingCity = new JLabel("Choose starting city: ");
        this.comboStartingCity = new JComboBox<>(Cities.values());
        this.btnStartingCity = new JButton("Enter");
        this.btnStartingCity.addActionListener(this);
        this.pnlStartingCity.add(this.lblStartingCity);
        this.pnlStartingCity.add(this.comboStartingCity);
        this.pnlStartingCity.add(this.btnStartingCity);
        
        // panel to get next city
        this.pnlNextCity = new JPanel();
        this.lblNextCity = new JLabel("Choose next city: ");
        this.comboNextCity = new JComboBox<>(Cities.values());
        this.btnNextCity = new JButton("Enter");
        this.btnNextCity.addActionListener(this);
        this.pnlNextCity.add(this.lblNextCity);
        this.pnlNextCity.add(this.comboNextCity);
        this.pnlNextCity.add(this.btnNextCity);
        
        // panel to show results
        this.pnlResults = new JPanel();
        this.txtResults = new JTextArea("Results:\n");
        this.exitButton = new JButton("Exit");
        this.exitButton.addActionListener(this);
        this.pnlResults.add(this.txtResults);
        this.pnlResults.add(this.exitButton);
        
        // add panels to contentPane
        this.contentPane.add(this.pnlNumOfCities);
        this.contentPane.add(this.pnlStartingCity);
        this.contentPane.add(this.pnlNextCity);
        this.contentPane.add(this.pnlResults);
        
        this.showPanel(this.pnlNumOfCities);
    } // end constructor
    
    private void showPanel(JPanel panelToShow){
        this.hideAllPanels();
        panelToShow.setVisible(true);
    } // end showPanel

    private void hideAllPanels() {
        this.pnlNumOfCities.setVisible(false);
        this.pnlStartingCity.setVisible(false);
        this.pnlNextCity.setVisible(false);
        this.pnlResults.setVisible(false);
    } // end hideAllPanels

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnNumOfCites){
            this.numCitiesVisited = 
                    Integer.parseInt(this.txtNumOfCities.getText().trim());
            cityData = new TMRData(this.numCitiesVisited);
            this.showPanel(this.pnlStartingCity);
        } else if (e.getSource() == this.btnStartingCity){ // end if
            this.startingCity = (Cities) this.comboStartingCity.getSelectedItem();
            cityData.addCity(this.startingCity);
            this.showPanel(this.pnlNextCity);
        } else if (e.getSource() == this.btnNextCity){ // end else if
            cityData.addCity((Cities) this.comboNextCity.getSelectedItem());
            if (cityData.isFull()){
                int miles;
                for (int i=0; i<(cityData.getCitiesVisited().size() - 1); i++){
                    this.txtResults.append(
                            cityData.getCitiesVisited().get(i) + " -> " +
                            cityData.getCitiesVisited().get(i + 1) + "\n");
                    miles = TMRCalculator.getMilesBetweenCities(
                            cityData.getCitiesVisited().get(i),
                            cityData.getCitiesVisited().get(i + 1)
                    );
                    this.txtResults.append("\tMiles   : " + miles + "\n");
                    this.txtResults.append(
                            "\tCurrency: " + TMRCalculator.getMoneyForMiles(miles)
                            + "\n"
                    );
                } // end for
                this.showPanel(this.pnlResults);
            } // end if
        } else if (e.getSource() == this.exitButton){ // end else if
            System.exit(0);
        } // end else if
    } // end actionPerformed
    
} // end class
