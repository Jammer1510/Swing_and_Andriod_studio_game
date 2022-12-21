/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/***************************************************************  
*  file: PongPanel.java  
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

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class PongPanel extends javax.swing.JPanel implements Runnable {

    int winner = 0;
    // size of panel
    private int panelHeight = 295;
    private int panelWidth = 430;
    // Paddle objects
    private Paddle paddle1;
    private Paddle paddle2;
    private final int PADDLE_HEIGHT = 50;
    private final int PADDLE_WIDTH = 15;
    // Ball object
    private Ball ball;
    private final int BALL_DIAMETER = 15;
    // player scores
    private int score1;
    private int score2;
    // thread for game
    private Thread gameThread;
    // check if game is running
    private boolean running = false;
    private int round = 1;
    
    /**
     * Creates new form PongPanel
     */
    public PongPanel() {
        initComponents();
        setPaddles();
        setBall();
        score1 = 0;
        score2 = 0;
        this.setFocusable(true);
        
        Action escapeExit = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        };
        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escapeExit");
        this.getActionMap().put("escapeExit", escapeExit);
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
        this.getInputMap().put(KeyStroke.getKeyStroke("F1"), "popUp");
        this.getActionMap().put("popUp", popUp);
        
        Action gameStart = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                start();
                roundLabel.setVisible(false);
                startControl.setVisible(false);
                round++;
            }
        };
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "gameStart");
        this.getActionMap().put("gameStart", gameStart);
    }
    
    // draw on JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
    }
    
    // begin up game
    public void start() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    // draw paddles
    private void setPaddles() {
        int middle = (panelHeight/2) - (PADDLE_HEIGHT/2);
        paddle1 = new Paddle(10, middle, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(panelWidth - PADDLE_WIDTH - 10, middle, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    
    // draw ball
    private void setBall() {
        ball = new Ball((panelWidth/2) - (BALL_DIAMETER/2), (panelHeight/2) - (BALL_DIAMETER/2), BALL_DIAMETER);
    }
    
    // move paddles
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    
    // set collision effects for panel
    public void checkCollisions() {
        // stop paddles from leaving panel
        if (paddle1.y <= 0)
            paddle1.y = 0;
        if (paddle1.y >= (panelHeight - PADDLE_HEIGHT))
                paddle1.y = panelHeight - PADDLE_HEIGHT;
        if (paddle2.y <= 0)
            paddle2.y = 0;
        if (paddle2.y >= (panelHeight - PADDLE_HEIGHT))
                paddle2.y = panelHeight - PADDLE_HEIGHT;
        
        // prevent ball moving out from top and bottom of screen
        if (ball.y <= 0)
            ball.setYDirection(-ball.getYVelocity());
        if (ball.y >= (panelHeight - BALL_DIAMETER))
            ball.setYDirection(-ball.getYVelocity());
        
        // bounce ball off paddles
        if (ball.intersects(paddle1))
            ball.setXDirection(Math.abs(ball.getXVelocity()));
        if (ball.intersects(paddle2))
            ball.setXDirection(-ball.getXVelocity());
        
        // determine score when ball goes to other side
        if (ball.x <= 0) {
            score2 = score2 + 10;
            player2Score.setText(String.valueOf(getScore2()));
            if (score2 == 100){
                running = false;
                winner = 2;
                PongWinner next = new PongWinner();
                next.setWinner(winner);
                next.setVisible(true);
                dispose();
            }
            else{
                setBall();
                setPaddles();
                running = false;
                roundLabel.setVisible(true);
                roundLabel.setText("Round" + " " + round);
                startControl.setVisible(true);
            }
        }
        if (ball.x >= panelWidth) {
            score1 = score1 + 10;
            player1Score.setText(String.valueOf(getScore1()));
            if (score1 == 100){
                running = false;
                winner = 1;
                PongWinner next = new PongWinner();
                next.setWinner(winner);
                next.setVisible(true);
                dispose();
            }
            else{
                setBall();
                setPaddles();
                running = false;
                roundLabel.setVisible(true);
                roundLabel.setText("Round" + " " + round);
                startControl.setVisible(true);
            }
        }
    }
    
    // send player scores to JFrame
    public int getScore1() {
        return score1;
    }
    
    public int getScore2() {
        return score2;
    }
    
    public int getWinner(){
        return winner;
    }
    
    // set size of panel
    @Override
    public void setSize(int xValue, int yValue) {
        super.setSize(xValue, yValue);
        panelWidth = xValue;
        panelHeight = yValue;
    }
    
    public void dispose() {
        Pong parent = (Pong) this.getTopLevelAncestor();
        parent.dispose();
    }
    
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        player2Score = new javax.swing.JLabel();
        player1Score = new javax.swing.JLabel();
        roundLabel = new javax.swing.JLabel();
        startControl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(430, 295));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player2Score.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        player2Score.setForeground(new java.awt.Color(255, 255, 255));
        player2Score.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        player2Score.setText("0");
        add(player2Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 35, -1));

        player1Score.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        player1Score.setForeground(new java.awt.Color(255, 255, 255));
        player1Score.setText("0");
        add(player1Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 38, -1));

        roundLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roundLabel.setForeground(new java.awt.Color(255, 255, 255));
        roundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundLabel.setText("Round 1");
        roundLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(roundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 80, 24));
        roundLabel.getAccessibleContext().setAccessibleName("roundLabel");

        startControl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        startControl.setForeground(new java.awt.Color(255, 255, 255));
        startControl.setText("Press SPACE to start");
        add(startControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        paddle1.keyPressed(evt);
        paddle2.keyPressed(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        paddle1.keyReleased(evt);
        paddle2.keyReleased(evt);
    }//GEN-LAST:event_formKeyReleased

    @Override
    public void run() {
        // game loop for pong game
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = (1000000000 / amountOfTicks);
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta = delta + ((now - lastTime) / ns);
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollisions();
                repaint();
                delta--;
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel player1Score;
    private javax.swing.JLabel player2Score;
    private javax.swing.JLabel roundLabel;
    private javax.swing.JLabel startControl;
    // End of variables declaration//GEN-END:variables
}
