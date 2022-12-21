/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/***************************************************************  
*  file: Sudoku.java  
*  author: Timmy Lin, Owen Lovett, Kristine Trevino Kinoshita, Scott Lee 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Swing Project 1  
*  date last modified: 10/16/2021  
*  
*  purpose: This program accepts creates a hangman game and a color button game 
*           in a separate window that has a title screen, main menu, game 
*           screen, high score screen, and credits.
* 
****************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Sudoku extends javax.swing.JFrame {

    // sudoku solution per gridbox
    String[] grid1Solution = {"3", "5", "2", "9", "6", "4", "7"};
    String[] grid2Solution = {"1", "8", "5", "7", "2", "9", "3"};
    String[] grid3Solution = {"9", "2", "3", "1", "8"};
    String[] grid4Solution = {"6", "1", "2", "3", "7"};
    String[] grid5Solution = {"1", "4", "6", "8", "5", "9"};
    String[] grid6Solution = {"2", "5", "4", "9", "6"};
    String[] grid7Solution = {"6", "9", "8", "7", "4"};
    String[] grid8Solution = {"7", "8", "1", "3", "4", "5", "6"};
    String[] grid9Solution = {"3", "4", "2", "7", "6", "8", "1"};
    //current time
    private Timer t;
    private SimpleDateFormat st;
    // current score
    int score = 0;
    int mistakes = 0;
    int sudokuScore = 540 - mistakes*10;    
    // inputted answers
    String[] grid1 = new String[grid1Solution.length];
    String[] grid2 = new String[grid2Solution.length];
    String[] grid3 = new String[grid3Solution.length];
    String[] grid4 = new String[grid4Solution.length];
    String[] grid5 = new String[grid5Solution.length];
    String[] grid6 = new String[grid6Solution.length];
    String[] grid7 = new String[grid7Solution.length];
    String[] grid8 = new String[grid8Solution.length];
    String[] grid9 = new String[grid9Solution.length];
    
    
    Boolean[] checkGrid1 = new Boolean[7];
    Boolean[] checkGrid2 = new Boolean[7];
    Boolean[] checkGrid3 = new Boolean[5];
    Boolean[] checkGrid4 = new Boolean[5];
    Boolean[] checkGrid5 = new Boolean[6];
    Boolean[] checkGrid6 = new Boolean[5];
    Boolean[] checkGrid7 = new Boolean[5];
    Boolean[] checkGrid8 = new Boolean[7];
    Boolean[] checkGrid9 = new Boolean[7];
    

    
    
    
    
    /**
     * Creates new form Sudoku
     */
    public Sudoku() {
        initComponents();
        curDate();
        curTime();
        createChecker(checkGrid1);
        createChecker(checkGrid2);
        createChecker(checkGrid3);
        createChecker(checkGrid4);
        createChecker(checkGrid5);
        createChecker(checkGrid6);
        createChecker(checkGrid7);
        createChecker(checkGrid8);
        createChecker(checkGrid9);
        error.setVisible(false);

        Action escapeExit = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        };
        
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escapeExit");
        jPanel1.getActionMap().put("escapeExit", escapeExit);
        
            Action popUp = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Fall 2022 Semester Project by:\n\n"
                        + "Timmy Lin, 015073799\n"
                        + "Owen Lovett, 014846715\n"
                        + "Kristine Trevino Kinoshita, 014679639\n"
                        + "Scott Lee, 013762138");
            }
        };
        
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("F1"), "popUp");
        jPanel1.getActionMap().put("popUp", popUp);
    }

    //current date
    private void curDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
        
        String dd = sdf.format(d);
        date.setText(dd);
    }
    
    // current time
    private void curTime(){
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
            
                String tt = st.format(dt);
                time.setText(tt);
            }
        });
        t.start();
    }
    
    // check input
    public void checkInt(String checkBox){
        try {
            int checker = Integer.parseInt(checkBox);
            if(checker < 1 || checker > 9){
                error.setVisible(true);
            }
            if(checker > 0 && checker < 10){
                error.setVisible(false);
            }
        } catch (NumberFormatException e) {
            error.setVisible(true);
        }
    }
    
    // get score from previous games
    public void getScore(int points) {
        score = points;
    }
    
    public void getMistakes(int wrong) {
        mistakes = wrong;
    }
    
    public void getSudokuScore(int points){
        sudokuScore = points;
    }
    
    public void startGame(){
        Sudoku restart = new Sudoku();
        restart.setVisible(true);
        restart.getScore(score);
        restart.getMistakes(mistakes);
        restart.getSudokuScore(sudokuScore);
        dispose();
    }
    
    private void createChecker(Boolean[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainBoard = new javax.swing.JPanel();
        square1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        box11 = new javax.swing.JTextField();
        box12 = new javax.swing.JTextField();
        box13 = new javax.swing.JTextField();
        box14 = new javax.swing.JTextField();
        box15 = new javax.swing.JTextField();
        box16 = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        box17 = new javax.swing.JTextField();
        square2 = new javax.swing.JPanel();
        label3 = new javax.swing.JLabel();
        box21 = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        box22 = new javax.swing.JTextField();
        box23 = new javax.swing.JTextField();
        box24 = new javax.swing.JTextField();
        box25 = new javax.swing.JTextField();
        box26 = new javax.swing.JTextField();
        box27 = new javax.swing.JTextField();
        square3 = new javax.swing.JPanel();
        box31 = new javax.swing.JTextField();
        box32 = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        box33 = new javax.swing.JTextField();
        box34 = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        box35 = new javax.swing.JTextField();
        square4 = new javax.swing.JPanel();
        label9 = new javax.swing.JLabel();
        box41 = new javax.swing.JTextField();
        label10 = new javax.swing.JLabel();
        box42 = new javax.swing.JTextField();
        box43 = new javax.swing.JTextField();
        box44 = new javax.swing.JTextField();
        box45 = new javax.swing.JTextField();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        square5 = new javax.swing.JPanel();
        box51 = new javax.swing.JTextField();
        label13 = new javax.swing.JLabel();
        box52 = new javax.swing.JTextField();
        box53 = new javax.swing.JTextField();
        label14 = new javax.swing.JLabel();
        box54 = new javax.swing.JTextField();
        box55 = new javax.swing.JTextField();
        label15 = new javax.swing.JLabel();
        box56 = new javax.swing.JTextField();
        square6 = new javax.swing.JPanel();
        label16 = new javax.swing.JLabel();
        label17 = new javax.swing.JLabel();
        box61 = new javax.swing.JTextField();
        box62 = new javax.swing.JTextField();
        box63 = new javax.swing.JTextField();
        box64 = new javax.swing.JTextField();
        label18 = new javax.swing.JLabel();
        box65 = new javax.swing.JTextField();
        label19 = new javax.swing.JLabel();
        square7 = new javax.swing.JPanel();
        box71 = new javax.swing.JTextField();
        label20 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        box72 = new javax.swing.JTextField();
        box73 = new javax.swing.JTextField();
        label22 = new javax.swing.JLabel();
        label23 = new javax.swing.JLabel();
        box74 = new javax.swing.JTextField();
        box75 = new javax.swing.JTextField();
        square8 = new javax.swing.JPanel();
        box81 = new javax.swing.JTextField();
        box82 = new javax.swing.JTextField();
        box83 = new javax.swing.JTextField();
        box84 = new javax.swing.JTextField();
        box85 = new javax.swing.JTextField();
        box86 = new javax.swing.JTextField();
        label24 = new javax.swing.JLabel();
        box87 = new javax.swing.JTextField();
        label25 = new javax.swing.JLabel();
        square9 = new javax.swing.JPanel();
        box91 = new javax.swing.JTextField();
        label26 = new javax.swing.JLabel();
        box92 = new javax.swing.JTextField();
        box93 = new javax.swing.JTextField();
        box94 = new javax.swing.JTextField();
        box95 = new javax.swing.JTextField();
        box96 = new javax.swing.JTextField();
        box97 = new javax.swing.JTextField();
        label27 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainBoard.setLayout(new java.awt.GridLayout(3, 3));

        square1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square1.setLayout(new java.awt.GridLayout(3, 3));

        label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("8");
        label1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square1.add(label1);

        box11.setBackground(new java.awt.Color(242, 242, 242));
        box11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box11.setToolTipText("Enter digit between 1-9");
        box11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box11ActionPerformed(evt);
            }
        });
        square1.add(box11);

        box12.setBackground(new java.awt.Color(242, 242, 242));
        box12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box12.setToolTipText("Enter digit between 1-9");
        box12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box12ActionPerformed(evt);
            }
        });
        square1.add(box12);

        box13.setBackground(new java.awt.Color(242, 242, 242));
        box13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box13.setToolTipText("Enter digit between 1-9");
        box13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box13ActionPerformed(evt);
            }
        });
        square1.add(box13);

        box14.setBackground(new java.awt.Color(242, 242, 242));
        box14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box14.setToolTipText("Enter digit between 1-9");
        box14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box14ActionPerformed(evt);
            }
        });
        square1.add(box14);

        box15.setBackground(new java.awt.Color(242, 242, 242));
        box15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box15.setToolTipText("Enter digit between 1-9");
        box15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box15ActionPerformed(evt);
            }
        });
        square1.add(box15);

        box16.setBackground(new java.awt.Color(242, 242, 242));
        box16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box16.setToolTipText("Enter digit between 1-9");
        box16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box16ActionPerformed(evt);
            }
        });
        square1.add(box16);

        label2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("1");
        label2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square1.add(label2);

        box17.setBackground(new java.awt.Color(242, 242, 242));
        box17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box17.setToolTipText("Enter digit between 1-9");
        box17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box17ActionPerformed(evt);
            }
        });
        square1.add(box17);

        mainBoard.add(square1);

        square2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square2.setLayout(new java.awt.GridLayout(3, 3));

        label3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("4");
        label3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square2.add(label3);

        box21.setBackground(new java.awt.Color(242, 242, 242));
        box21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box21.setToolTipText("Enter digit between 1-9");
        box21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box21ActionPerformed(evt);
            }
        });
        square2.add(box21);

        label4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setText("6");
        label4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square2.add(label4);

        box22.setBackground(new java.awt.Color(242, 242, 242));
        box22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box22.setToolTipText("Enter digit between 1-9");
        box22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box22ActionPerformed(evt);
            }
        });
        square2.add(box22);

        box23.setBackground(new java.awt.Color(242, 242, 242));
        box23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box23.setToolTipText("Enter digit between 1-9");
        box23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box23ActionPerformed(evt);
            }
        });
        square2.add(box23);

        box24.setBackground(new java.awt.Color(242, 242, 242));
        box24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box24.setToolTipText("Enter digit between 1-9");
        box24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box24ActionPerformed(evt);
            }
        });
        square2.add(box24);

        box25.setBackground(new java.awt.Color(242, 242, 242));
        box25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box25.setToolTipText("Enter digit between 1-9");
        box25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box25ActionPerformed(evt);
            }
        });
        square2.add(box25);

        box26.setBackground(new java.awt.Color(242, 242, 242));
        box26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box26.setToolTipText("Enter digit between 1-9");
        box26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box26ActionPerformed(evt);
            }
        });
        square2.add(box26);

        box27.setBackground(new java.awt.Color(242, 242, 242));
        box27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box27.setToolTipText("Enter digit between 1-9");
        box27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box27ActionPerformed(evt);
            }
        });
        square2.add(box27);

        mainBoard.add(square2);

        square3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square3.setLayout(new java.awt.GridLayout(3, 3));

        box31.setBackground(new java.awt.Color(242, 242, 242));
        box31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box31.setToolTipText("Enter digit between 1-9");
        box31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box31ActionPerformed(evt);
            }
        });
        square3.add(box31);

        box32.setBackground(new java.awt.Color(242, 242, 242));
        box32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box32.setToolTipText("Enter digit between 1-9");
        box32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box32ActionPerformed(evt);
            }
        });
        square3.add(box32);

        label5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setText("7");
        label5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square3.add(label5);

        label6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setText("4");
        label6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square3.add(label6);

        box33.setBackground(new java.awt.Color(242, 242, 242));
        box33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box33.setToolTipText("Enter digit between 1-9");
        box33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box33ActionPerformed(evt);
            }
        });
        square3.add(box33);

        box34.setBackground(new java.awt.Color(242, 242, 242));
        box34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box34.setToolTipText("Enter digit between 1-9");
        box34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box34ActionPerformed(evt);
            }
        });
        square3.add(box34);

        label7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label7.setText("6");
        label7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square3.add(label7);

        label8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label8.setText("5");
        label8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square3.add(label8);

        box35.setBackground(new java.awt.Color(242, 242, 242));
        box35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box35.setToolTipText("Enter digit between 1-9");
        box35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box35ActionPerformed(evt);
            }
        });
        square3.add(box35);

        mainBoard.add(square3);

        square4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square4.setLayout(new java.awt.GridLayout(3, 3));

        label9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label9.setText("5");
        label9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square4.add(label9);

        box41.setBackground(new java.awt.Color(242, 242, 242));
        box41.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box41.setToolTipText("Enter digit between 1-9");
        box41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box41ActionPerformed(evt);
            }
        });
        square4.add(box41);

        label10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label10.setText("9");
        label10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square4.add(label10);

        box42.setBackground(new java.awt.Color(242, 242, 242));
        box42.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box42.setToolTipText("Enter digit between 1-9");
        box42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box42ActionPerformed(evt);
            }
        });
        square4.add(box42);

        box43.setBackground(new java.awt.Color(242, 242, 242));
        box43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box43.setToolTipText("Enter digit between 1-9");
        box43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box43ActionPerformed(evt);
            }
        });
        square4.add(box43);

        box44.setBackground(new java.awt.Color(242, 242, 242));
        box44.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box44.setToolTipText("Enter digit between 1-9");
        box44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box44ActionPerformed(evt);
            }
        });
        square4.add(box44);

        box45.setBackground(new java.awt.Color(242, 242, 242));
        box45.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box45.setToolTipText("Enter digit between 1-9");
        box45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box45ActionPerformed(evt);
            }
        });
        square4.add(box45);

        label11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label11.setText("4");
        label11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square4.add(label11);

        label12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label12.setText("8");
        label12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square4.add(label12);

        mainBoard.add(square4);

        square5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square5.setLayout(new java.awt.GridLayout(3, 3));

        box51.setBackground(new java.awt.Color(242, 242, 242));
        box51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box51.setToolTipText("Enter digit between 1-9");
        box51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box51ActionPerformed(evt);
            }
        });
        square5.add(box51);

        label13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label13.setText("3");
        label13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square5.add(label13);

        box52.setBackground(new java.awt.Color(242, 242, 242));
        box52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box52.setToolTipText("Enter digit between 1-9");
        box52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box52ActionPerformed(evt);
            }
        });
        square5.add(box52);

        box53.setBackground(new java.awt.Color(242, 242, 242));
        box53.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box53.setToolTipText("Enter digit between 1-9");
        box53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box53ActionPerformed(evt);
            }
        });
        square5.add(box53);

        label14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label14.setText("7");
        label14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square5.add(label14);

        box54.setBackground(new java.awt.Color(242, 242, 242));
        box54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box54.setToolTipText("Enter digit between 1-9");
        box54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box54ActionPerformed(evt);
            }
        });
        square5.add(box54);

        box55.setBackground(new java.awt.Color(242, 242, 242));
        box55.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box55.setToolTipText("Enter digit between 1-9");
        box55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box55ActionPerformed(evt);
            }
        });
        square5.add(box55);

        label15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label15.setText("2");
        label15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square5.add(label15);

        box56.setBackground(new java.awt.Color(242, 242, 242));
        box56.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box56.setToolTipText("Enter digit between 1-9");
        box56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box56ActionPerformed(evt);
            }
        });
        square5.add(box56);

        mainBoard.add(square5);

        square6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square6.setLayout(new java.awt.GridLayout(3, 3));

        label16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label16.setText("7");
        label16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square6.add(label16);

        label17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label17.setText("8");
        label17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square6.add(label17);

        box61.setBackground(new java.awt.Color(242, 242, 242));
        box61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box61.setToolTipText("Enter digit between 1-9");
        box61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box61ActionPerformed(evt);
            }
        });
        square6.add(box61);

        box62.setBackground(new java.awt.Color(242, 242, 242));
        box62.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box62.setToolTipText("Enter digit between 1-9");
        box62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box62ActionPerformed(evt);
            }
        });
        square6.add(box62);

        box63.setBackground(new java.awt.Color(242, 242, 242));
        box63.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box63.setToolTipText("Enter digit between 1-9");
        box63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box63ActionPerformed(evt);
            }
        });
        square6.add(box63);

        box64.setBackground(new java.awt.Color(242, 242, 242));
        box64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box64.setToolTipText("Enter digit between 1-9");
        box64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box64ActionPerformed(evt);
            }
        });
        square6.add(box64);

        label18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("1");
        label18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square6.add(label18);

        box65.setBackground(new java.awt.Color(242, 242, 242));
        box65.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box65.setToolTipText("Enter digit between 1-9");
        box65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box65ActionPerformed(evt);
            }
        });
        square6.add(box65);

        label19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label19.setText("3");
        label19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square6.add(label19);

        mainBoard.add(square6);

        square7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square7.setLayout(new java.awt.GridLayout(3, 3));

        box71.setBackground(new java.awt.Color(242, 242, 242));
        box71.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box71.setToolTipText("Enter digit between 1-9");
        box71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box71ActionPerformed(evt);
            }
        });
        square7.add(box71);

        label20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label20.setText("5");
        label20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square7.add(label20);

        label21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label21.setText("2");
        label21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square7.add(label21);

        box72.setBackground(new java.awt.Color(242, 242, 242));
        box72.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box72.setToolTipText("Enter digit between 1-9");
        box72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box72ActionPerformed(evt);
            }
        });
        square7.add(box72);

        box73.setBackground(new java.awt.Color(242, 242, 242));
        box73.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box73.setToolTipText("Enter digit between 1-9");
        box73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box73ActionPerformed(evt);
            }
        });
        square7.add(box73);

        label22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label22.setText("1");
        label22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square7.add(label22);

        label23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label23.setText("3");
        label23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square7.add(label23);

        box74.setBackground(new java.awt.Color(242, 242, 242));
        box74.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box74.setToolTipText("Enter digit between 1-9");
        box74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box74ActionPerformed(evt);
            }
        });
        square7.add(box74);

        box75.setBackground(new java.awt.Color(242, 242, 242));
        box75.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box75.setToolTipText("Enter digit between 1-9");
        box75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box75ActionPerformed(evt);
            }
        });
        square7.add(box75);

        mainBoard.add(square7);

        square8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square8.setLayout(new java.awt.GridLayout(3, 3));

        box81.setBackground(new java.awt.Color(242, 242, 242));
        box81.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box81.setToolTipText("Enter digit between 1-9");
        box81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box81ActionPerformed(evt);
            }
        });
        square8.add(box81);

        box82.setBackground(new java.awt.Color(242, 242, 242));
        box82.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box82.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box82.setToolTipText("Enter digit between 1-9");
        box82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box82ActionPerformed(evt);
            }
        });
        square8.add(box82);

        box83.setBackground(new java.awt.Color(242, 242, 242));
        box83.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box83.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box83.setToolTipText("Enter digit between 1-9");
        box83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box83ActionPerformed(evt);
            }
        });
        square8.add(box83);

        box84.setBackground(new java.awt.Color(242, 242, 242));
        box84.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box84.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box84.setToolTipText("Enter digit between 1-9");
        box84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box84ActionPerformed(evt);
            }
        });
        square8.add(box84);

        box85.setBackground(new java.awt.Color(242, 242, 242));
        box85.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box85.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box85.setToolTipText("Enter digit between 1-9");
        box85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box85ActionPerformed(evt);
            }
        });
        square8.add(box85);

        box86.setBackground(new java.awt.Color(242, 242, 242));
        box86.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box86.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box86.setToolTipText("Enter digit between 1-9");
        box86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box86ActionPerformed(evt);
            }
        });
        square8.add(box86);

        label24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label24.setText("9");
        label24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square8.add(label24);

        box87.setBackground(new java.awt.Color(242, 242, 242));
        box87.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box87.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box87.setToolTipText("Enter digit between 1-9");
        box87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box87ActionPerformed(evt);
            }
        });
        square8.add(box87);

        label25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label25.setText("2");
        label25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square8.add(label25);

        mainBoard.add(square8);

        square9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        square9.setLayout(new java.awt.GridLayout(3, 3));

        box91.setBackground(new java.awt.Color(242, 242, 242));
        box91.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box91.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box91.setToolTipText("Enter digit between 1-9");
        box91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box91ActionPerformed(evt);
            }
        });
        square9.add(box91);

        label26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label26.setText("9");
        label26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square9.add(label26);

        box92.setBackground(new java.awt.Color(242, 242, 242));
        box92.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box92.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box92.setToolTipText("Enter digit between 1-9");
        box92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box92ActionPerformed(evt);
            }
        });
        square9.add(box92);

        box93.setBackground(new java.awt.Color(242, 242, 242));
        box93.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box93.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box93.setToolTipText("Enter digit between 1-9");
        box93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box93ActionPerformed(evt);
            }
        });
        square9.add(box93);

        box94.setBackground(new java.awt.Color(242, 242, 242));
        box94.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box94.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box94.setToolTipText("Enter digit between 1-9");
        box94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box94ActionPerformed(evt);
            }
        });
        square9.add(box94);

        box95.setBackground(new java.awt.Color(242, 242, 242));
        box95.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box95.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box95.setToolTipText("Enter digit between 1-9");
        box95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box95ActionPerformed(evt);
            }
        });
        square9.add(box95);

        box96.setBackground(new java.awt.Color(242, 242, 242));
        box96.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box96.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box96.setToolTipText("Enter digit between 1-9");
        box96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box96ActionPerformed(evt);
            }
        });
        square9.add(box96);

        box97.setBackground(new java.awt.Color(242, 242, 242));
        box97.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        box97.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        box97.setToolTipText("Enter digit between 1-9");
        box97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        box97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box97ActionPerformed(evt);
            }
        });
        square9.add(box97);

        label27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label27.setText("5");
        label27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        label27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        square9.add(label27);

        mainBoard.add(square9);

        jPanel1.add(mainBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 310, 310));

        title.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        title.setText("Sudoku");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 60, 110, 40));

        date.setText("date");
        date.setToolTipText("");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 6, 124, -1));

        time.setText("time");
        time.setToolTipText("");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 6, 76, -1));

        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setToolTipText("Submit answers");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        quitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quitButton.setText("Quit");
        quitButton.setToolTipText("Quit game");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        error.setForeground(new java.awt.Color(255, 51, 51));
        error.setText("ERROR: Only enter values between 1-9");
        jPanel1.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -10, 340, 80));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 400);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void box11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box11ActionPerformed
        grid1[0] = box11.getText().trim();
        checkInt(grid1[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box11ActionPerformed

    private void box12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box12ActionPerformed
        grid1[1] = box12.getText().trim();
        checkInt(grid1[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box12ActionPerformed

    private void box13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box13ActionPerformed
        grid1[2] = box13.getText().trim();
        checkInt(grid1[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box13ActionPerformed

    private void box14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box14ActionPerformed
        grid1[3] = box14.getText().trim();
        checkInt(grid1[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box14ActionPerformed

    private void box15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box15ActionPerformed
        grid1[4] = box15.getText().trim();
        checkInt(grid1[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box15ActionPerformed

    private void box16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box16ActionPerformed
        grid1[5] = box16.getText().trim();
        checkInt(grid1[5]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box16ActionPerformed

    private void box17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box17ActionPerformed
        grid1[6] = box17.getText().trim();
        checkInt(grid1[6]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box17ActionPerformed

    private void box21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box21ActionPerformed
        grid2[0] = box21.getText().trim();
        checkInt(grid2[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box21ActionPerformed

    private void box22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box22ActionPerformed
        grid2[1] = box22.getText().trim();
        checkInt(grid2[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box22ActionPerformed

    private void box23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box23ActionPerformed
        grid2[2] = box23.getText().trim();
        checkInt(grid2[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box23ActionPerformed

    private void box24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box24ActionPerformed
        grid2[3] = box24.getText().trim();
        checkInt(grid2[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box24ActionPerformed

    private void box25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box25ActionPerformed
        grid2[4] = box25.getText().trim();
        checkInt(grid2[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box25ActionPerformed

    private void box26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box26ActionPerformed
        grid2[5] = box26.getText().trim();
        checkInt(grid2[5]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box26ActionPerformed

    private void box27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box27ActionPerformed
        grid2[6] = box27.getText().trim();
        checkInt(grid2[6]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box27ActionPerformed

    private void box31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box31ActionPerformed
        grid3[0] = box31.getText().trim();
        checkInt(grid3[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box31ActionPerformed

    private void box32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box32ActionPerformed
        grid3[1] = box32.getText().trim();
        checkInt(grid3[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box32ActionPerformed

    private void box33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box33ActionPerformed
        grid3[2] = box33.getText().trim();
        checkInt(grid3[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box33ActionPerformed

    private void box34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box34ActionPerformed
        grid3[3] = box34.getText().trim();
        checkInt(grid3[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box34ActionPerformed

    private void box35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box35ActionPerformed
        grid3[4] = box35.getText().trim();
        checkInt(grid3[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box35ActionPerformed

    private void box45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box45ActionPerformed
        grid4[4] = box45.getText().trim();
        checkInt(grid4[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box45ActionPerformed

    private void box41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box41ActionPerformed
        grid4[0] = box41.getText().trim();
        checkInt(grid4[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box41ActionPerformed

    private void box42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box42ActionPerformed
        grid4[1] = box42.getText().trim();
        checkInt(grid4[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box42ActionPerformed

    private void box43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box43ActionPerformed
        grid4[2] = box43.getText().trim();
        checkInt(grid4[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box43ActionPerformed

    private void box44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box44ActionPerformed
        grid4[3] = box44.getText().trim();
        checkInt(grid4[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box44ActionPerformed

    private void box55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box55ActionPerformed
        grid5[4] = box55.getText().trim();
        checkInt(grid5[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box55ActionPerformed

    private void box51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box51ActionPerformed
        grid5[0] = box51.getText().trim();
        checkInt(grid5[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box51ActionPerformed

    private void box52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box52ActionPerformed
        grid5[1] = box52.getText().trim();
        checkInt(grid5[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box52ActionPerformed

    private void box53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box53ActionPerformed
        grid5[2] = box53.getText().trim();
        checkInt(grid5[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box53ActionPerformed

    private void box54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box54ActionPerformed
        grid5[3] = box54.getText().trim();
        checkInt(grid5[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box54ActionPerformed

    private void box65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box65ActionPerformed
        grid6[4] = box65.getText().trim();
        checkInt(grid6[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box65ActionPerformed

    private void box61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box61ActionPerformed
        grid6[0] = box61.getText().trim();
        checkInt(grid6[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box61ActionPerformed

    private void box62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box62ActionPerformed
        grid6[1] = box62.getText().trim();
        checkInt(grid6[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box62ActionPerformed

    private void box63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box63ActionPerformed
        grid6[2] = box63.getText().trim();
        checkInt(grid6[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box63ActionPerformed

    private void box64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box64ActionPerformed
        grid6[3] = box64.getText().trim();
        checkInt(grid6[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box64ActionPerformed

    private void box75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box75ActionPerformed
        grid7[4] = box75.getText().trim();
        checkInt(grid7[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box75ActionPerformed

    private void box71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box71ActionPerformed
        grid7[0] = box71.getText().trim();
        checkInt(grid7[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box71ActionPerformed

    private void box72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box72ActionPerformed
        grid7[1] = box72.getText().trim();
        checkInt(grid7[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box72ActionPerformed

    private void box73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box73ActionPerformed
        grid7[2] = box73.getText().trim();
        checkInt(grid7[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box73ActionPerformed

    private void box74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box74ActionPerformed
        grid7[3] = box74.getText().trim();
        checkInt(grid7[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box74ActionPerformed

    private void box85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box85ActionPerformed
        grid8[4] = box85.getText().trim();
        checkInt(grid8[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box85ActionPerformed

    private void box86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box86ActionPerformed
        grid8[5] = box86.getText().trim();
        checkInt(grid8[5]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box86ActionPerformed

    private void box87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box87ActionPerformed
        grid8[6] = box87.getText().trim();
        checkInt(grid8[6]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box87ActionPerformed

    private void box81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box81ActionPerformed
        grid8[0] = box81.getText().trim();
        checkInt(grid8[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box81ActionPerformed

    private void box82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box82ActionPerformed
        grid8[1] = box82.getText().trim();
        checkInt(grid8[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box82ActionPerformed

    private void box83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box83ActionPerformed
        grid8[2] = box83.getText().trim();
        checkInt(grid8[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box83ActionPerformed

    private void box84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box84ActionPerformed
        grid8[3] = box84.getText().trim();
        checkInt(grid8[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box84ActionPerformed

    private void box92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box92ActionPerformed
        grid9[1] = box92.getText().trim();
        checkInt(grid9[1]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box92ActionPerformed

    private void box93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box93ActionPerformed
        grid9[2] = box93.getText().trim();
        checkInt(grid9[2]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box93ActionPerformed

    private void box94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box94ActionPerformed
        grid9[3] = box94.getText().trim();
        checkInt(grid9[3]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box94ActionPerformed

    private void box95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box95ActionPerformed
        grid9[4] = box95.getText().trim();
        checkInt(grid9[4]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box95ActionPerformed

    private void box96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box96ActionPerformed
        grid9[5] = box96.getText().trim();
        checkInt(grid9[5]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box96ActionPerformed

    private void box97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box97ActionPerformed
        grid9[6] = box97.getText().trim();
        checkInt(grid9[6]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box97ActionPerformed

    private void box91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box91ActionPerformed
        grid9[0] = box91.getText().trim();
        checkInt(grid9[0]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box91ActionPerformed

    private void box56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box56ActionPerformed
        grid5[5] = box56.getText().trim();
        checkInt(grid5[5]);
        jPanel1.requestFocusInWindow();
    }//GEN-LAST:event_box56ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        mistakes = 0;
        for (int a = 0; a < grid1Solution.length; a++) {
            if (!grid1[a].equals(grid1Solution[a]) && checkGrid1[a] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid1[a] = true;
            }
        }
        for (int b = 0; b < grid2Solution.length; b++) {
            if (!grid2[b].equals(grid2Solution[b]) && checkGrid2[b] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid2[b] = true;
            }
        }
        for (int c = 0; c < grid3Solution.length; c++) {
            if (!grid3[c].equals(grid3Solution[c]) && checkGrid3[c] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid3[c] = true;
            }  
        }
        for (int d = 0; d < grid4Solution.length; d++) {
            if (!grid4[d].equals(grid4Solution[d]) && checkGrid4[d] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid4[d] = true;
            }
        }
        for (int e = 0; e < grid5Solution.length; e++) {
            if (!grid5[e].equals(grid5Solution[e]) && checkGrid5[e] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid5[e] = true;
            }
        }
        for (int f = 0; f < grid6Solution.length; f++) {
            if (!grid6[f].equals(grid6Solution[f]) && checkGrid6[f] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid6[f] = true;
            }
        }
        for (int g = 0; g < grid7Solution.length; g++) {
            if (!grid7[g].equals(grid7Solution[g]) && checkGrid7[g] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid7[g] = true;
            }
        }
        for (int h = 0; h < grid8Solution.length; h++) {
            if (!grid8[h].equals(grid8Solution[h]) && checkGrid8[h] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid8[h] = true;
            }
        }
        for (int i = 0; i < grid9Solution.length; i++) {
            if (!grid9[i].equals(grid9Solution[i]) && checkGrid9[i] == false){
                sudokuScore = sudokuScore - 10;
                mistakes++;
                checkGrid9[i] = true;
            }
        }
        
        if(mistakes > 0){
            int result = JOptionPane.showConfirmDialog(jPanel1, "One or more inputs was incorrect. Try again?", "Incorrect Input Detected", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) {
                int finalScore = score + sudokuScore;
                EndHighScores ehs = new EndHighScores();
                ehs.setVisible(true);
                ehs.setFinalScore(finalScore);
                ehs.checkHighScore(finalScore);
                dispose(); 
            }
            //tryAgainPrompt.setVisible(true);
            //tryAgainButton.setVisible(true);
        } else{
            int finalScore = score + sudokuScore;
            EndHighScores ehs = new EndHighScores();
            ehs.setVisible(true);
            ehs.setFinalScore(finalScore);
            ehs.checkHighScore(finalScore);
            dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        EndHighScores ehs = new EndHighScores();
        ehs.setVisible(true);
        ehs.setFinalScore(score);
        dispose();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void tryAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tryAgainButtonActionPerformed
        startGame();
    }//GEN-LAST:event_tryAgainButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sudoku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField box11;
    private javax.swing.JTextField box12;
    private javax.swing.JTextField box13;
    private javax.swing.JTextField box14;
    private javax.swing.JTextField box15;
    private javax.swing.JTextField box16;
    private javax.swing.JTextField box17;
    private javax.swing.JTextField box21;
    private javax.swing.JTextField box22;
    private javax.swing.JTextField box23;
    private javax.swing.JTextField box24;
    private javax.swing.JTextField box25;
    private javax.swing.JTextField box26;
    private javax.swing.JTextField box27;
    private javax.swing.JTextField box31;
    private javax.swing.JTextField box32;
    private javax.swing.JTextField box33;
    private javax.swing.JTextField box34;
    private javax.swing.JTextField box35;
    private javax.swing.JTextField box41;
    private javax.swing.JTextField box42;
    private javax.swing.JTextField box43;
    private javax.swing.JTextField box44;
    private javax.swing.JTextField box45;
    private javax.swing.JTextField box51;
    private javax.swing.JTextField box52;
    private javax.swing.JTextField box53;
    private javax.swing.JTextField box54;
    private javax.swing.JTextField box55;
    private javax.swing.JTextField box56;
    private javax.swing.JTextField box61;
    private javax.swing.JTextField box62;
    private javax.swing.JTextField box63;
    private javax.swing.JTextField box64;
    private javax.swing.JTextField box65;
    private javax.swing.JTextField box71;
    private javax.swing.JTextField box72;
    private javax.swing.JTextField box73;
    private javax.swing.JTextField box74;
    private javax.swing.JTextField box75;
    private javax.swing.JTextField box81;
    private javax.swing.JTextField box82;
    private javax.swing.JTextField box83;
    private javax.swing.JTextField box84;
    private javax.swing.JTextField box85;
    private javax.swing.JTextField box86;
    private javax.swing.JTextField box87;
    private javax.swing.JTextField box91;
    private javax.swing.JTextField box92;
    private javax.swing.JTextField box93;
    private javax.swing.JTextField box94;
    private javax.swing.JTextField box95;
    private javax.swing.JTextField box96;
    private javax.swing.JTextField box97;
    private javax.swing.JLabel date;
    private javax.swing.JLabel error;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label20;
    private javax.swing.JLabel label21;
    private javax.swing.JLabel label22;
    private javax.swing.JLabel label23;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JPanel mainBoard;
    private javax.swing.JButton quitButton;
    private javax.swing.JPanel square1;
    private javax.swing.JPanel square2;
    private javax.swing.JPanel square3;
    private javax.swing.JPanel square4;
    private javax.swing.JPanel square5;
    private javax.swing.JPanel square6;
    private javax.swing.JPanel square7;
    private javax.swing.JPanel square8;
    private javax.swing.JPanel square9;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
