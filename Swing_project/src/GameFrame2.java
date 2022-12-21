/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/***************************************************************  
*  file: GameFrame2.java  
*  author: Timmy Lin, Owen Lovett, Kristine Trevino Kinoshita, Scott Lee 
*  class: CS 2450 – User Interface Design and Programming 
*  
*  assignment: Swing Project 1  
*  date last modified: 10/24/2021  
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

public class GameFrame2 extends javax.swing.JFrame {

    // word to guess
    private String selectedWord = "nurse";
    // number of letters guessed correctly
    private int letterCorrect = 0;
    // score for game 
    private int score = 100;
    // number of mistakes
    private int mistakes = 0;
    //current time
    private Timer t;
    private SimpleDateFormat st;
    
    /**
     * Creates new form GameFrame
     */
    public GameFrame2() {
        initComponents();
        curDate();
        curTime();
        makeLetterSpaceInvisible();
        makeBodyPartsInvisible();
        makeMistakePromptVisible(false);
        
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
    
    // set body parts invisible
    private void makeBodyPartsInvisible() {
        head1.setVisible(false);
        body1.setVisible(false);
        rightArm1.setVisible(false);
        rightLeg1.setVisible(false);
        leftArm1.setVisible(false);
        leftLeg1.setVisible(false);
    }
    
    // set letter labels invisible
    private void makeLetterSpaceInvisible() {
        letter1.setVisible(false);
        letter2.setVisible(false);
        letter3.setVisible(false);
        letter4.setVisible(false);
        letter5.setVisible(false);
    }
    
    //set mistake prompt (in)visible
    private void makeMistakePromptVisible(boolean state) {
        mistakePrompt1.setVisible(state);
    }
    
    // check to see if letter is in selected word, if so, add it
    private void isLetterInWord(char letter) {
        boolean notFound = true;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == letter) {
                addLetter(letter,i);
                notFound = false;
            }
        }
        if (notFound)
        {
            score = score - 10;
            updateScore();
            addMistake();
        }
    }
    
    // add accepted letter in space on game screen and remove if chosen
    private void addLetter(char letter, int index) {
        letterCorrect++;
        mistakePrompt1.setVisible(false);
        switch (index) {
            case 0:
                letter1.setText(Character.toString(letter));
                letter1.setVisible(true);
                break;
            case 1:
                letter2.setText(Character.toString(letter));
                letter2.setVisible(true);
                break;
            case 2:
                letter3.setText(Character.toString(letter));
                letter3.setVisible(true);
                break;
            case 3:
                letter4.setText(Character.toString(letter));
                letter4.setVisible(true);
                break;
            case 4:
                letter5.setText(Character.toString(letter));
                letter5.setVisible(true);
                break;
        }
        if (letterCorrect == selectedWord.length())
            delayNextFrame();
    }
    
    // marks a mistake when the user picks a wrong letter
    private void addMistake() {
        makeMistakePromptVisible(true);
        mistakes++;
        switch (mistakes) {
            case 1:
                head1.setVisible(true);
                break;
            case 2:
                body1.setVisible(true);
                break;
            case 3:
                rightArm1.setVisible(true);
                break;
            case 4:
                leftArm1.setVisible(true);
                break;
            case 5:
                rightLeg1.setVisible(true);
                break;
            case 6:
                leftLeg1.setVisible(true);
                delayNextFrame();
                break;
        }
    }
    
    // update score
    private void updateScore() {
        String pointName = currentScore.getText().substring(0, currentScore.getText().indexOf(" "));
        currentScore.setText(pointName + "  " + score);
    }
    
    // delay ending frame
    private void delayNextFrame() {
        skipButton.setEnabled(false);
        Timer delay;
        ButtonGame next = new ButtonGame();
        ActionListener wait = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setVisible(true);
                next.getScore(score);
                dispose();
            }
        };
        delay = new Timer(900, wait);
        delay.setRepeats(false);
        delay.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        hangmanPole1 = new javax.swing.JLabel();
        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        eButton = new javax.swing.JButton();
        fButton = new javax.swing.JButton();
        gButton = new javax.swing.JButton();
        hButton = new javax.swing.JButton();
        iButton = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        kButton = new javax.swing.JButton();
        lButton = new javax.swing.JButton();
        mButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();
        oButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        qButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        uButton = new javax.swing.JButton();
        vButton = new javax.swing.JButton();
        wButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();
        yButton = new javax.swing.JButton();
        zButton = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        letter1 = new javax.swing.JLabel();
        letter2 = new javax.swing.JLabel();
        letter3 = new javax.swing.JLabel();
        letter4 = new javax.swing.JLabel();
        letter5 = new javax.swing.JLabel();
        currentScore = new javax.swing.JLabel();
        gameTitle = new javax.swing.JLabel();
        mistakePrompt1 = new javax.swing.JLabel();
        head1 = new javax.swing.JLabel();
        body1 = new javax.swing.JLabel();
        leftArm1 = new javax.swing.JLabel();
        rightArm1 = new javax.swing.JLabel();
        leftLeg1 = new javax.swing.JLabel();
        rightLeg1 = new javax.swing.JLabel();

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hangmanPole1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hanger(1).png"))); // NOI18N
        jPanel1.add(hangmanPole1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 6, -1, -1));

        aButton.setText("A");
        aButton.setToolTipText("Select letter");
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });
        jPanel1.add(aButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 304, 38, -1));

        bButton.setText("B");
        bButton.setToolTipText("Select letter");
        bButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButtonActionPerformed(evt);
            }
        });
        jPanel1.add(bButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 304, 38, -1));

        cButton.setText("C");
        cButton.setToolTipText("Select letter");
        cButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 304, 38, -1));

        dButton.setText("D");
        dButton.setToolTipText("Select letter");
        dButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtonActionPerformed(evt);
            }
        });
        jPanel1.add(dButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 304, 38, -1));

        eButton.setText("E");
        eButton.setToolTipText("Select letter");
        eButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eButtonActionPerformed(evt);
            }
        });
        jPanel1.add(eButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 304, 38, -1));

        fButton.setText("F");
        fButton.setToolTipText("Select letter");
        fButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fButtonActionPerformed(evt);
            }
        });
        jPanel1.add(fButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 304, 38, -1));

        gButton.setText("G");
        gButton.setToolTipText("Select letter");
        gButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gButtonActionPerformed(evt);
            }
        });
        jPanel1.add(gButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 304, 38, -1));

        hButton.setText("H");
        hButton.setToolTipText("Select letter");
        hButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hButtonActionPerformed(evt);
            }
        });
        jPanel1.add(hButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 304, 38, -1));

        iButton.setText("I");
        iButton.setToolTipText("Select letter");
        iButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iButtonActionPerformed(evt);
            }
        });
        jPanel1.add(iButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 304, 38, -1));

        jButton.setText("J");
        jButton.setToolTipText("Select letter");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 304, 38, -1));

        kButton.setText("K");
        kButton.setToolTipText("Select letter");
        kButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonActionPerformed(evt);
            }
        });
        jPanel1.add(kButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 304, 38, -1));

        lButton.setText("L");
        lButton.setToolTipText("Select letter");
        lButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lButtonActionPerformed(evt);
            }
        });
        jPanel1.add(lButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 304, 38, -1));

        mButton.setText("M");
        mButton.setToolTipText("Select letter");
        mButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 304, 38, -1));

        nButton.setText("N");
        nButton.setToolTipText("Select letter");
        nButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtonActionPerformed(evt);
            }
        });
        jPanel1.add(nButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 332, 38, -1));

        oButton.setText("O");
        oButton.setToolTipText("Select letter");
        oButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oButtonActionPerformed(evt);
            }
        });
        jPanel1.add(oButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 332, 38, -1));

        pButton.setText("P");
        pButton.setToolTipText("Select letter");
        pButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtonActionPerformed(evt);
            }
        });
        jPanel1.add(pButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 332, 38, -1));

        qButton.setText("Q");
        qButton.setToolTipText("Select letter");
        qButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qButtonActionPerformed(evt);
            }
        });
        jPanel1.add(qButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 332, 38, -1));

        rButton.setText("R");
        rButton.setToolTipText("Select letter");
        rButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButtonActionPerformed(evt);
            }
        });
        jPanel1.add(rButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 332, 38, -1));

        sButton.setText("S");
        sButton.setToolTipText("Select letter");
        sButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 332, 38, -1));

        tButton.setText("T");
        tButton.setToolTipText("Select letter");
        tButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButtonActionPerformed(evt);
            }
        });
        jPanel1.add(tButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 332, 38, -1));

        uButton.setText("U");
        uButton.setToolTipText("Select letter");
        uButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uButtonActionPerformed(evt);
            }
        });
        jPanel1.add(uButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 332, 38, -1));

        vButton.setText("V");
        vButton.setToolTipText("Select letter");
        vButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButtonActionPerformed(evt);
            }
        });
        jPanel1.add(vButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 332, 38, -1));

        wButton.setText("W");
        wButton.setToolTipText("Select letter");
        wButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wButtonActionPerformed(evt);
            }
        });
        jPanel1.add(wButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 332, 40, -1));

        xButton.setText("X");
        xButton.setToolTipText("Select letter");
        xButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtonActionPerformed(evt);
            }
        });
        jPanel1.add(xButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 332, 38, -1));

        yButton.setText("Y");
        yButton.setToolTipText("Select letter");
        yButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yButtonActionPerformed(evt);
            }
        });
        jPanel1.add(yButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 332, 38, -1));

        zButton.setText("Z");
        zButton.setToolTipText("Select letter");
        zButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zButtonActionPerformed(evt);
            }
        });
        jPanel1.add(zButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 332, 38, -1));

        date.setText("date");
        date.setToolTipText("");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 6, 124, -1));

        time.setText("time");
        time.setToolTipText("");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 6, 76, -1));

        skipButton.setText("Skip");
        skipButton.setToolTipText("Skip to next game");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        jPanel1.add(skipButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 81, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 278, 50, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 278, 50, 20));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 278, 50, 20));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 278, 50, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 278, 50, 20));

        letter1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        letter1.setText("letter2");
        jPanel1.add(letter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 247, 30, -1));

        letter2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        letter2.setText("letter3");
        jPanel1.add(letter2, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 247, 30, -1));

        letter3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        letter3.setText("letter4");
        jPanel1.add(letter3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 247, 30, -1));

        letter4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        letter4.setText("letter5");
        jPanel1.add(letter4, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 247, 30, -1));

        letter5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        letter5.setText("letter6");
        jPanel1.add(letter5, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 247, 30, -1));

        currentScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        currentScore.setText("Points:  100");
        jPanel1.add(currentScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 66, 96, 30));

        gameTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gameTitle.setText("Hangman");
        jPanel1.add(gameTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, 124, 39));

        mistakePrompt1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mistakePrompt1.setForeground(new java.awt.Color(255, 0, 51));
        mistakePrompt1.setText("Wrong letter! Try another...");
        jPanel1.add(mistakePrompt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        head1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/head.png"))); // NOI18N
        head1.setDoubleBuffered(true);
        jPanel1.add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        body1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/body.png"))); // NOI18N
        jPanel1.add(body1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 150, -1));

        leftArm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leftArm.png"))); // NOI18N
        jPanel1.add(leftArm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 80, -1));

        rightArm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rightArm.png"))); // NOI18N
        jPanel1.add(rightArm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 40, 170));

        leftLeg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leftLeg.png"))); // NOI18N
        jPanel1.add(leftLeg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        rightLeg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rightLeg.png"))); // NOI18N
        jPanel1.add(rightLeg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        // TODO add your handling code here:
        ButtonGame next = new ButtonGame();
        next.setVisible(true);
        score = 0;
        dispose();
    }//GEN-LAST:event_skipButtonActionPerformed

    private void zButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('z');
        zButton.setVisible(false);
    }//GEN-LAST:event_zButtonActionPerformed

    private void yButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('y');
        yButton.setVisible(false);
    }//GEN-LAST:event_yButtonActionPerformed

    private void xButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('x');
        xButton.setVisible(false);
    }//GEN-LAST:event_xButtonActionPerformed

    private void wButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('w');
        wButton.setVisible(false);
    }//GEN-LAST:event_wButtonActionPerformed

    private void vButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('v');
        vButton.setVisible(false);
    }//GEN-LAST:event_vButtonActionPerformed

    private void uButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('u');
        uButton.setVisible(false);
    }//GEN-LAST:event_uButtonActionPerformed

    private void tButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('t');
        tButton.setVisible(false);
    }//GEN-LAST:event_tButtonActionPerformed

    private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('s');
        sButton.setVisible(false);
    }//GEN-LAST:event_sButtonActionPerformed

    private void rButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('r');
        rButton.setVisible(false);
    }//GEN-LAST:event_rButtonActionPerformed

    private void qButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('q');
        qButton.setVisible(false);
    }//GEN-LAST:event_qButtonActionPerformed

    private void pButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('p');
        pButton.setVisible(false);
    }//GEN-LAST:event_pButtonActionPerformed

    private void oButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('o');
        oButton.setVisible(false);
    }//GEN-LAST:event_oButtonActionPerformed

    private void nButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('n');
        nButton.setVisible(false);
    }//GEN-LAST:event_nButtonActionPerformed

    private void mButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('m');
        mButton.setVisible(false);
    }//GEN-LAST:event_mButtonActionPerformed

    private void lButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('l');
        lButton.setVisible(false);
    }//GEN-LAST:event_lButtonActionPerformed

    private void kButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('k');
        kButton.setVisible(false);
    }//GEN-LAST:event_kButtonActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('j');
        jButton.setVisible(false);
    }//GEN-LAST:event_jButtonActionPerformed

    private void iButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('i');
        iButton.setVisible(false);
    }//GEN-LAST:event_iButtonActionPerformed

    private void hButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('h');
        hButton.setVisible(false);
    }//GEN-LAST:event_hButtonActionPerformed

    private void gButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('g');
        gButton.setVisible(false);
    }//GEN-LAST:event_gButtonActionPerformed

    private void fButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('f');
        fButton.setVisible(false);
    }//GEN-LAST:event_fButtonActionPerformed

    private void eButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('e');
        eButton.setVisible(false);
    }//GEN-LAST:event_eButtonActionPerformed

    private void dButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('d');
        dButton.setVisible(false);
    }//GEN-LAST:event_dButtonActionPerformed

    private void cButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('c');
        cButton.setVisible(false);
    }//GEN-LAST:event_cButtonActionPerformed

    private void bButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('b');
        bButton.setVisible(false);
    }//GEN-LAST:event_bButtonActionPerformed

    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        // TODO add your handling code here:
        isLetterInWord('a');
        aButton.setVisible(false);
    }//GEN-LAST:event_aButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame2().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aButton;
    private javax.swing.JButton bButton;
    private javax.swing.JLabel body1;
    private javax.swing.JButton cButton;
    private javax.swing.JLabel currentScore;
    private javax.swing.JButton dButton;
    private javax.swing.JLabel date;
    private javax.swing.JButton eButton;
    private javax.swing.JButton fButton;
    private javax.swing.JButton gButton;
    private javax.swing.JLabel gameTitle;
    private javax.swing.JButton hButton;
    private javax.swing.JLabel hangmanPole1;
    private javax.swing.JLabel head1;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton kButton;
    private javax.swing.JButton lButton;
    private javax.swing.JLabel leftArm1;
    private javax.swing.JLabel leftLeg1;
    private javax.swing.JLabel letter1;
    private javax.swing.JLabel letter2;
    private javax.swing.JLabel letter3;
    private javax.swing.JLabel letter4;
    private javax.swing.JLabel letter5;
    private javax.swing.JButton mButton;
    private javax.swing.JLabel mistakePrompt1;
    private javax.swing.JButton nButton;
    private javax.swing.JButton oButton;
    private javax.swing.JButton pButton;
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JLabel rightArm1;
    private javax.swing.JLabel rightLeg1;
    private javax.swing.JButton sButton;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton tButton;
    private javax.swing.JLabel time;
    private javax.swing.JButton uButton;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables
}
