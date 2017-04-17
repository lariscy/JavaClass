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
import javax.swing.JSeparator;
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
    private static final int WINDOW_HEIGHT = 350;
    private static final int WINDOW_WIDTH = 850;
    private static final int DEFAULT_SUBCIPHER_SHIFTBY = 5;
    private static final int DEFAULT_TRANSCIPHER_N = 5;
    private static final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);
    private static final int TEXTFIELD_COLUMN_NORMAL = 20;
    private static final int TEXTFIELD_COLUMN_SMALL = 2;
    private static final String TITLE_TEXT = "Cipher GUI 9000";
    private static final String CIPHER_SUB_TITLE_TEXT = "Substitution Cipher";
    private static final String CIPHER_TRANS_TITLE_TEXT = "Transposition Cipher";
    private static final String ENCODE_BUTTON_TEXT = "> Encode >";
    private static final String DECODE_BUTTON_TEXT = "< Decode <";
    private static final String RESET_BUTTON_TEXT = "Reset";

    // instance variables
    private SubstitutionCipher subCipher;
    private TranspositionCipher transCipher;

    // instance variables (UI elements)
    private JTextField txtSubPlain;
    private JButton btnSubEncode;
    private JTextField txtSubShiftby;
    private JButton btnSubDecode;
    private JTextField txtSubCipher;
    private JButton btnResetSub;
    private JTextField txtTransPlain;
    private JButton btnTransEncode;
    private JTextField txtTransN;
    private JButton btnTransDecode;
    private JTextField txtTransCipher;
    private JButton btnResetTrans;
    private JLabel lblError;

    // constructor
    public CipherGUI() {
        super();
        this.initGUI();
        this.setupListeners();
    } // end constructor

    private void initGUI() {
        this.setTitle(CipherGUI.TITLE_TEXT);
        this.setSize(new Dimension(CipherGUI.WINDOW_WIDTH, CipherGUI.WINDOW_HEIGHT));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblSubTitle = new JLabel(CipherGUI.CIPHER_SUB_TITLE_TEXT);
        lblSubTitle.setFont(new Font("Dialog", Font.ITALIC, 25));
        lblSubTitle.setHorizontalAlignment(JLabel.CENTER);
        gbc.insets = CipherGUI.DEFAULT_INSETS;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblSubTitle, gbc);

        this.txtSubPlain = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(this.txtSubPlain, gbc);

        this.btnSubEncode = new JButton(CipherGUI.ENCODE_BUTTON_TEXT);
        gbc.gridx = 1;
        panel.add(this.btnSubEncode, gbc);

        this.txtSubShiftby = new JTextField(
                String.valueOf(CipherGUI.DEFAULT_SUBCIPHER_SHIFTBY),
                CipherGUI.TEXTFIELD_COLUMN_SMALL);
        this.txtSubShiftby.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 2;
        panel.add(this.txtSubShiftby, gbc);

        this.btnSubDecode = new JButton(CipherGUI.DECODE_BUTTON_TEXT);
        gbc.gridx = 3;
        panel.add(this.btnSubDecode, gbc);

        this.txtSubCipher = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.gridx = 4;
        panel.add(this.txtSubCipher, gbc);

        this.btnResetSub = new JButton(CipherGUI.RESET_BUTTON_TEXT);
        this.btnResetSub.addActionListener(this);
        gbc.gridwidth = 3;
        gbc.gridy = 2;
        gbc.gridx = 1;
        panel.add(this.btnResetSub, gbc);

        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JSeparator(JSeparator.HORIZONTAL), gbc);

        JLabel lblTransTitle = new JLabel(CipherGUI.CIPHER_TRANS_TITLE_TEXT);
        lblTransTitle.setFont(new Font("Dialog", Font.ITALIC, 25));
        lblTransTitle.setHorizontalAlignment(JLabel.CENTER);
        gbc.insets = CipherGUI.DEFAULT_INSETS;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblTransTitle, gbc);

        this.txtTransPlain = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.insets = CipherGUI.DEFAULT_INSETS;
        gbc.gridwidth = 1;
        gbc.gridy = 5;
        panel.add(this.txtTransPlain, gbc);

        this.btnTransEncode = new JButton(CipherGUI.ENCODE_BUTTON_TEXT);
        gbc.gridx = 1;
        panel.add(this.btnTransEncode, gbc);

        this.txtTransN = new JTextField(
                String.valueOf(CipherGUI.DEFAULT_TRANSCIPHER_N),
                CipherGUI.TEXTFIELD_COLUMN_SMALL);
        this.txtTransN.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 2;
        panel.add(this.txtTransN, gbc);

        this.btnTransDecode = new JButton(CipherGUI.DECODE_BUTTON_TEXT);
        gbc.gridx = 3;
        panel.add(this.btnTransDecode, gbc);

        this.txtTransCipher = new JTextField(CipherGUI.TEXTFIELD_COLUMN_NORMAL);
        gbc.gridx = 4;
        panel.add(this.txtTransCipher, gbc);

        this.btnResetTrans = new JButton(CipherGUI.RESET_BUTTON_TEXT);
        this.btnResetTrans.addActionListener(this);
        gbc.gridwidth = 3;
        gbc.gridy = 6;
        gbc.gridx = 1;
        panel.add(this.btnResetTrans, gbc);

        this.lblError = new JLabel();
        this.lblError.setForeground(Color.RED);
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(this.lblError, gbc);

        this.getContentPane().add(panel);
    } // end initGUI

    private void setupListeners() {
        this.btnSubEncode.addActionListener(this);
        this.btnSubDecode.addActionListener(this);
        this.btnTransEncode.addActionListener(this);
        this.btnTransDecode.addActionListener(this);
    } // end setupListeners

    @Override
    public void actionPerformed(ActionEvent e) {
        this.lblError.setText("");
        if (e.getSource().equals(this.btnSubEncode)) {
            try {
                this.subCipher = new SubstitutionCipher(
                        Integer.parseInt(this.txtSubShiftby.getText()));
                this.txtSubCipher.setText(this.subCipher
                        .encode(this.txtSubPlain.getText()));
            } catch (IllegalArgumentException ex) { // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        } else if (e.getSource().equals(this.btnSubDecode)) { // end if
            try {
                this.subCipher = new SubstitutionCipher(
                        Integer.parseInt(this.txtSubShiftby.getText()));
                this.txtSubPlain.setText(this.subCipher
                        .decode(this.txtSubCipher.getText()));
            } catch (IllegalArgumentException ex) { // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        } else if (e.getSource().equals(this.btnTransEncode)) { // end else if
            try {
                this.transCipher = new TranspositionCipher(
                        Integer.parseInt(this.txtTransN.getText()));
                this.txtTransCipher.setText(this.transCipher
                        .encode(this.txtTransPlain.getText()));
            } catch (IllegalArgumentException ex) { // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        } else if (e.getSource().equals(this.btnTransDecode)) { // end else if
            try {
                this.transCipher = new TranspositionCipher(
                        Integer.parseInt(this.txtTransN.getText()));
                this.txtTransPlain.setText(this.transCipher
                        .decode(this.txtTransCipher.getText()));
            } catch (IllegalArgumentException ex) { // end try
                this.lblError.setText(ex.getMessage());
            } // end catch
        } else if (e.getSource().equals(this.btnResetSub)) { // end else if
            this.txtSubPlain.setText("");
            this.txtSubCipher.setText("");
            this.txtSubShiftby.setText(
                    String.valueOf(CipherGUI.DEFAULT_SUBCIPHER_SHIFTBY));
        } else if (e.getSource().equals(this.btnResetTrans)) { // end else if
            this.txtTransPlain.setText("");
            this.txtTransCipher.setText("");
            this.txtTransN.setText(
                    String.valueOf(CipherGUI.DEFAULT_TRANSCIPHER_N));
        } // end else if
    } // end actionPerformed

} // end class
