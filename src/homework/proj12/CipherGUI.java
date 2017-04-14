package homework.proj12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.14.2017
 * @dueDate 4.20.2017
 * @description Cipher Program
 */
public class CipherGUI extends JFrame implements ActionListener {
    
    // constants
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 850;
    private static final int DEFAULT_SUBCIPHER_SHIFTBY = 5;
    private static final int DEFAULT_TRANSCIPHER_N = 5;
    private static final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);
    private static final int TEXTFIELD_COLUMN_NORMAL = 20;
    private static final int TEXTFIELD_COLUMN_SMALL = 2;
    
    // instance variables
    private JTextField txtSubPlain;
    private JButton btnSubEncode;
    private JTextField txtSubShiftby;
    private JButton btnSubDecode;
    private JTextField txtSubCipher;
    private JTextField txtTransPlain;
    private JButton btnTransEncode;
    private JTextField txtTransN;
    private JButton btnTransDecode;
    private JTextField txtTransCipher;
    private JLabel lblError;
    private SubstitutionCipher subCipher;
    private TranspositionCipher transCipher;

    public CipherGUI() {
        super();
        this.initGUI();
        this.setupListeners();
    }

    private void initGUI() {
        this.setTitle("Cipher GUI");
        this.setSize(new Dimension(CipherGUI.WINDOW_WIDTH, CipherGUI.WINDOW_HEIGHT));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel lblSubTitle = new JLabel("SubstitutionCipher");
        lblSubTitle.setFont(new Font("Dialog", Font.ITALIC, 25));
        gbc.insets = CipherGUI.DEFAULT_INSETS;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblSubTitle, gbc);
        
        this.txtSubPlain = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(this.txtSubPlain, gbc);
        
        this.btnSubEncode = new JButton("> Encode >");
        gbc.gridx = 1;
        panel.add(this.btnSubEncode, gbc);
        
        this.txtSubShiftby = new JTextField(
                String.valueOf(CipherGUI.DEFAULT_SUBCIPHER_SHIFTBY), 
                CipherGUI.TEXTFIELD_COLUMN_SMALL);
        this.txtSubShiftby.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 2;
        panel.add(this.txtSubShiftby, gbc);
        
        this.btnSubDecode = new JButton("< Decode <");
        gbc.gridx = 3;
        panel.add(this.btnSubDecode, gbc);
        
        this.txtSubCipher = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.gridx = 4;
        panel.add(this.txtSubCipher, gbc);
        
        JLabel lblTransTitle = new JLabel("TranspositionCipher");
        lblTransTitle.setFont(new Font("Dialog", Font.ITALIC, 25));
        gbc.insets = new Insets(50, 5, 5, 5);
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblTransTitle, gbc);
        
        this.txtTransPlain = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.insets = CipherGUI.DEFAULT_INSETS;
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        panel.add(this.txtTransPlain, gbc);
        
        this.btnTransEncode = new JButton("> Encode >");
        gbc.gridx = 1;
        panel.add(this.btnTransEncode, gbc);
        
        this.txtTransN = new JTextField(
                String.valueOf(CipherGUI.DEFAULT_TRANSCIPHER_N), 
                CipherGUI.TEXTFIELD_COLUMN_SMALL);
        this.txtTransN.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 2;
        panel.add(this.txtTransN, gbc);
        
        this.btnTransDecode = new JButton("< Decode <");
        gbc.gridx = 3;
        panel.add(this.btnTransDecode, gbc);
        
        this.txtTransCipher = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.gridx = 4;
        panel.add(this.txtTransCipher, gbc);
        
        this.lblError = new JLabel();
        this.lblError.setForeground(Color.RED);
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(this.lblError, gbc);
        
        this.getContentPane().add(panel);
    }

    private void setupListeners() {
        this.btnSubEncode.addActionListener(this);
        this.btnSubDecode.addActionListener(this);
        this.btnTransEncode.addActionListener(this);
        this.btnTransDecode.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.lblError.setText("");
        if (e.getSource().equals(this.btnSubEncode)){
            try {
                this.subCipher = new SubstitutionCipher(
                        Integer.parseInt(this.txtSubShiftby.getText()));
                this.txtSubCipher.setText(this.subCipher.encode(this.txtSubPlain.getText()));
            } catch (IllegalArgumentException ex){ // end try
                this.lblError.setText(ex.getMessage());
            }
        } else if (e.getSource().equals(this.btnSubDecode)){
            try {
                this.subCipher = new SubstitutionCipher(
                        Integer.parseInt(this.txtSubShiftby.getText()));
                this.txtSubPlain.setText(this.subCipher.decode(this.txtSubCipher.getText()));
            } catch (IllegalArgumentException ex){ // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        } else if (e.getSource().equals(this.btnTransEncode)){
            try {
                this.transCipher = new TranspositionCipher(
                        Integer.parseInt(this.txtTransN.getText()));
                this.txtTransCipher.setText(this.transCipher.encode(this.txtTransPlain.getText()));
            } catch (IllegalArgumentException ex){ // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        } else if (e.getSource().equals(this.btnTransDecode)) {
            try {
                this.transCipher = new TranspositionCipher(
                        Integer.parseInt(this.txtTransN.getText()));
                this.txtTransPlain.setText(this.transCipher.decode(this.txtTransCipher.getText()));
            } catch (IllegalArgumentException ex){ // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        }
    }
    
} // end class
