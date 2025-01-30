import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class Converter {

    public static boolean check = true;

    public static void main(String[] args) {

        //difference objects
        JFrame frame = new JFrame("Converter");
        JCheckBox checkBox = new JCheckBox();

        JLabel labelRub, labelDollars;
        JTextField inputRub, inputDollars;
        JButton buttonConv;

        //Rubles && Dollars
        labelRub = new JLabel("Rubles");
        labelRub.setBounds(10, 10, 60, 30);

        labelDollars = new JLabel("Dollars");
        labelDollars.setBounds(10, 75, 60, 30);

        //add Inputs
        inputRub = new JTextField();
        inputRub.setFont(new java.awt.Font("Bold",  Font.BOLD, 20));
        inputRub.setBounds(10, 40, 220, 40);

        inputDollars = new JTextField();
        inputDollars.setFont(new java.awt.Font("Bold",  Font.BOLD, 20));
        inputDollars.setBounds(10, 100, 220, 40);
        inputDollars.setEditable(false);

        //checkbox
        checkBox.setText("from dollars");
        checkBox.setBounds(10, 140, 100, 30);


        //add Buttons
        buttonConv = new JButton("Convert");
        buttonConv.setBounds(10, 170, 220, 40);

        //add ActionListener
        buttonConv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check) {
                    double rubles = Double.parseDouble(inputRub.getText());
                    double rubConvert = (rubles / 98.01);

                    DecimalFormat decimalFormatRub = new DecimalFormat("#.#");
                    String resultRub = decimalFormatRub.format(rubConvert);

                    String stringRub = String.valueOf(resultRub);
                    inputDollars.setText(stringRub);
                } else {
                    double dollars = Double.parseDouble(inputDollars.getText());
                    double dolConvert = (dollars * 98.01);

                    DecimalFormat decimalFormatDol = new DecimalFormat("#.###");
                    String resultDol = decimalFormatDol.format(dolConvert);

                    String stringDol = String.valueOf(resultDol);
                    inputRub.setText(stringDol);
                }
            }
        });

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                    inputRub.setText("");
                    inputDollars.setText("");
                    inputRub.setEditable(false);
                    inputDollars.setEditable(true);
                    check = false;
                } else {//checkbox has been deselected
                    check = true;
                    inputRub.setText("");
                    inputDollars.setText("");
                    inputRub.setEditable(true);
                    inputDollars.setEditable(false);
                };
            }
        });

        //add objects in frames
        frame.add(labelRub);
        frame.add(labelDollars);
        frame.add(labelRub);
        frame.add(labelDollars);
        frame.add(inputRub);
        frame.add(inputDollars);
        frame.add(checkBox);
        frame.add(buttonConv);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(260, 260);
        frame.setVisible(true);
    }
}