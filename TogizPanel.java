import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.Serializable;

public class TogizPanel extends JPanel implements java.io.Serializable 
{
    private JTextArea actionRecordArea;                                         
    private JScrollPane actionScrollPane;
    private String cupChosenString;  

    private TogizBoard playBoard;
    private int cupChosen;
    private int player;

    private int moveCount = 1;
    
    private JLabel myLabel[][] = new JLabel[11][2];
    private JLabel sLabel[]= new JLabel [2];
   
    private JButton myButton[][]  = new JButton[11][2];
   
    private JTextField myField[][]  = new JTextField[11][2];
    private JTextField sField[] = new JTextField[2];
 
    private JPanel gamePanel;
    private JPanel finalPanel;
    private JPanel boardPanel[]  = new JPanel[2];;
    
    private JPanel labelPanel[] = new JPanel[2];;
    private JPanel fieldPanel[] = new JPanel[2];
    private JPanel buttonPanel[] = new JPanel[2];
    private JPanel scorePanel[] = new JPanel[2] ;
  
    public TogizPanel() 
    {
        super();
        playBoard = new TogizBoard();
        cupChosen =0;
        player = 0;
        setFocusable(true);
        addKeyListener( new KeyHandler());
        addMouseListener(new MouseHandler());
        actionRecordArea = new JTextArea(4, 20);                               
 actionRecordArea.setEditable(false);
 actionScrollPane = new JScrollPane(actionRecordArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 add(actionScrollPane, "SOUTH");   
       
        ButtonListener myButtonListener = new ButtonListener();
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout (1,6));
        
        finalPanel = new JPanel();
        BorderLayout BorderLayout = new BorderLayout();
        finalPanel.setLayout(BorderLayout);
        
       
        boardPanel[0] = new JPanel();
        boardPanel[1] = new JPanel();
        boardPanel[0].setLayout(new GridLayout(11,1));
        boardPanel[1].setLayout(new GridLayout(11,1));
        
        
        labelPanel[0] = new JPanel();
        labelPanel[1] = new JPanel();
        labelPanel[0].setLayout(new GridLayout(11,1));
        labelPanel[1].setLayout(new GridLayout(11,1));
        
       
        buttonPanel[0] = new JPanel();
        buttonPanel[1] = new JPanel();
        buttonPanel[0].setLayout(new GridLayout(11,1));
        buttonPanel[1].setLayout(new GridLayout(11,1));
        
        
        fieldPanel[0] = new JPanel();
        fieldPanel[1] = new JPanel();
        fieldPanel[0].setLayout(new GridLayout(11,1));
        fieldPanel[1].setLayout(new GridLayout(11,1));
        
       
        scorePanel[0] = new JPanel();
        scorePanel[1] = new JPanel();
        scorePanel[0].setLayout(new GridLayout(2,1));
        scorePanel[0].setSize(20,20);
        scorePanel[1].setLayout(new GridLayout(2,1));
        scorePanel[1].setSize(20,20);
       
     
       int cup = 1;
      for (int i = 10; i >= 0; i--)
      {  
          myLabel[i][0] = new JLabel("PLayer 1, Cup (0,"+i+") " + cup, JLabel.LEFT);
          
          labelPanel[0].add(myLabel[i][0]);  
          cup++;
      }
      cup = 1;
   
      for(int i = 10; i >= 0; i--)
      {
          myLabel[i][1] = new JLabel("Player 2, Cup (1,"+i+") "+ cup, JLabel.LEFT);
          labelPanel[1].add(myLabel[i][1]);
          cup++;
      }
      
      cup = 1;
      for(int i = 10; i >= 0; i--)
      {
          myButton[i][0] = new JButton("Play Cup");
          myButton[i][0].addActionListener(myButtonListener);
          buttonPanel[0].add(myButton[i][0]);
          cup++;
      }
      cup = 1;
      for(int i = 10; i >= 0; i--)
      {
          myButton[i][1] = new JButton("Play Cup");
          myButton[i][1].addActionListener(myButtonListener);
          buttonPanel[1].add(myButton[i][1]);
          cup++;
      }
        
    //myField = new JTextField[8][2];
      cup = 0;
      for(int i = 10; i >= 0; i--)
      {
          myField[i][0] = new JTextField(playBoard.getCup(0,cup).getSeedString(),5);
         
          cup++;
      }    
      cup = 0;
      for(int i = 10; i >= 0; i--)
      {
          myField[i][1] = new JTextField(playBoard.getCup(1,cup).getSeedString(),5);  
          cup++;
      }
      
           TextFieldListener1 myTextListener00= new TextFieldListener1();
           TextFieldListener2 myTextListener01= new TextFieldListener2();
           TextFieldListener3 myTextListener02= new TextFieldListener3();
           TextFieldListener4 myTextListener03= new TextFieldListener4();
           TextFieldListener5 myTextListener04= new TextFieldListener5();
           TextFieldListener6 myTextListener05= new TextFieldListener6();
           TextFieldListener7 myTextListener06= new TextFieldListener7();
           TextFieldListener8 myTextListener07= new TextFieldListener8();
     TextFieldListener17 myTextListener08= new TextFieldListener17();                                   
     TextFieldListener19 myTextListener09= new TextFieldListener19();                                   
     TextFieldListener21 myTextListener010= new TextFieldListener21();                                   
           
           TextFieldListener9  myTextListener10= new TextFieldListener9();
           TextFieldListener10 myTextListener11= new TextFieldListener10();
           TextFieldListener11 myTextListener12= new TextFieldListener11();
           TextFieldListener12 myTextListener13= new TextFieldListener12();
           TextFieldListener13 myTextListener14= new TextFieldListener13();
           TextFieldListener14 myTextListener15= new TextFieldListener14();
           TextFieldListener15 myTextListener16= new TextFieldListener15();
           TextFieldListener16 myTextListener17= new TextFieldListener16();
     TextFieldListener18 myTextListener18= new TextFieldListener18();           
     TextFieldListener20 myTextListener19= new TextFieldListener20();           
     TextFieldListener22 myTextListener110= new TextFieldListener22();           
           
            myField[0][0].addActionListener(myTextListener00);
            myField[1][0].addActionListener(myTextListener01);
            myField[2][0].addActionListener(myTextListener02);
            myField[3][0].addActionListener(myTextListener03);
            myField[4][0].addActionListener(myTextListener04);
            myField[5][0].addActionListener(myTextListener05);
            myField[6][0].addActionListener(myTextListener06);
            myField[7][0].addActionListener(myTextListener07);
   myField[8][0].addActionListener(myTextListener08);            
   myField[9][0].addActionListener(myTextListener09);             
   myField[10][0].addActionListener(myTextListener010);             
            
            myField[0][1].addActionListener(myTextListener10);
            myField[1][1].addActionListener(myTextListener11);
            myField[2][1].addActionListener(myTextListener12);
            myField[3][1].addActionListener(myTextListener13);
            myField[4][1].addActionListener(myTextListener14);
            myField[5][1].addActionListener(myTextListener15);
            myField[6][1].addActionListener(myTextListener16);
            myField[7][1].addActionListener(myTextListener17);
   myField[8][1].addActionListener(myTextListener18);              
   myField[9][1].addActionListener(myTextListener19);              
   myField[10][1].addActionListener(myTextListener19);              
   
           for(int i =10; i >=0; i--)
           {
               fieldPanel[0].add(myField[i][0]);
           }
           for(int i =10; i >=0; i--)
           {
               fieldPanel[1].add(myField[i][1]);
           }
            
              sLabel[0] = new JLabel ("Player "+1+ " Score");
              scorePanel[0].add(sLabel[0]);
              
              sField[0] = new JTextField(playBoard.getScoreCup(1).getSeedString());
              
              scorePanel[0].add(sField[0]); 
              
              sLabel[1] = new JLabel ("Player "+2+ " Score");
              scorePanel[1].add(sLabel[1]);
              
              sField[1] = new JTextField(playBoard.getScoreCup(1).getSeedString());
             
              scorePanel[1].add(sField[1]);

              gamePanel.add(labelPanel[0]);
              gamePanel.add(buttonPanel[0]);
              gamePanel.add(fieldPanel[0]);
              gamePanel.add(fieldPanel[1]);
              gamePanel.add(buttonPanel[1]);
              gamePanel.add(labelPanel[1]);
              
              finalPanel.add(scorePanel[0], BorderLayout.LINE_START);
              finalPanel.add(gamePanel, BorderLayout.CENTER);
              finalPanel.add(scorePanel[1], BorderLayout.LINE_END);
              add(finalPanel);
    }
    public void renewBoard()
    {
        playBoard = new TogizBoard();
        cupChosen =0;
        player = 0; 
        setTextField();
        repaint();
    }
    public void newTextArea()
    {
        actionRecordArea = new JTextArea(4, 20);                                
 actionRecordArea.setEditable(false);
 actionScrollPane = new JScrollPane(actionRecordArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 add(actionScrollPane, "SOUTH"); 
        
    }
    public void RenewTextArea()                                                
    {
        actionRecordArea.setText("");
    }

    public void panelPlay()
    { 
        playBoard.playBoard(player, cupChosen);
    }
     public void setMoveCount(int countIn)
    {
        moveCount = countIn;
    }
    public void setCupChosen(int cupIn)
    { 
        cupChosen = cupIn;
    }
   public void setPlayer(int playerIn)
   {
       player = playerIn;
   }
   
    public void setActionRecordArea(JTextArea actionRecordAreaIn)
    {
        actionRecordArea = actionRecordAreaIn;   
       
    }
    public void setActionScrollPane(JScrollPane actionScrollPaneIn)
    {
        actionScrollPane = actionScrollPaneIn;
    }
    public void setCupChosenString(String cupChosenStringIn)
    {
        cupChosenString = cupChosenStringIn;
    } 
   public void setPlayBoard(TogizBoard playBoardIn)
   {
       playBoard = playBoardIn;
   }

    public void setMyLabel(JLabel[][] myLabelIn) {
        
        myLabel = myLabelIn;
    }
    public void setMyLabel(JLabel myLabelIn, int row, int col) {
        
        myLabel[row][col] = myLabelIn;
    }

    public void setsLabel(JLabel[] sLabelIn) {
        sLabel = sLabelIn;
    }
    public void setsLabel(JLabel sLabelIn, int i) {
        sLabel[i] = sLabelIn;
    }

    public void setMyButton(JButton[][] myButtonIn) {
        myButton = myButtonIn;
    }
    public void setMyButton(JButton myButtonIn, int row, int col) {
        myButton[row][col] = myButtonIn;
    }

    public void setMyField(JTextField[][] myFieldIn) {
        myField = myFieldIn;
    }
    public void setMyField(JTextField myFieldIn, int row, int col) {
        myField[row][col] = myFieldIn;
    }

    public void setsField(JTextField[] sFieldIn) {
        sField = sFieldIn;
    }
    public void setsField(JTextField sFieldIn, int i) {
        sField[i] = sFieldIn;
    }

    public void setGamePanel(JPanel gamePanelIn) {
        gamePanel = gamePanelIn;
    }

    public void setFinalPanel(JPanel finalPanelIn) {
        finalPanel = finalPanelIn;
    }

    public void setBoardPanel(JPanel[] boardPanelIn) {
        boardPanel = boardPanelIn;
    }
    public void setBoardPanel(JPanel boardPanelIn, int i) {
        boardPanel[i] = boardPanelIn;
    }
    public void setLabelPanel(JPanel[] labelPanelIn) {
        labelPanel = labelPanelIn;
    }
    public void setLabelPanel(JPanel labelPanelIn, int i) {
        labelPanel[i] = labelPanelIn;
    }

    public void setFieldPanel(JPanel[] fieldPanelIn) {
        fieldPanel = fieldPanelIn;
    }
    public void setFieldPanel(JPanel fieldPanelIn, int i) {
        fieldPanel[i] = fieldPanelIn;
    }

    public void setButtonPanel(JPanel[] buttonPanelIn) {
        buttonPanel = buttonPanelIn;
    }
    public void setButtonPanel(JPanel buttonPanelIn, int i) {
        buttonPanel[i] = buttonPanelIn;
    }

    public void setScorePanel(JPanel[] scorePanelIn) {
        scorePanel = scorePanelIn;
    }
    public void setScorePanel(JPanel scorePanelIn, int i) {
        scorePanel[i] = scorePanelIn;
    }
   
   public void setTextField()
    {
        if(playBoard.getCup(0,0).getSeeds() == 0)
        {
            myField[0][0].setText("0");
        }
        else
        {
            myField[0][0].setText(playBoard.getCup(0,0).getSeedString());
        }
        if(playBoard.getCup(0,1).getSeeds() == 0)
        {
            myField[1][0].setText("0");
        }
        else
        {
            myField[1][0].setText(playBoard.getCup(0,1).getSeedString());
        }
        if(playBoard.getCup(0,2).getSeeds() == 0)
        {
            myField[2][0].setText("0");
        }
        else
        {
            myField[2][0].setText(playBoard.getCup(0,2).getSeedString());
        }
        if(playBoard.getCup(0,3).getSeeds() == 0)
        {
            myField[3][0].setText("0");
        }
        else
        {
            myField[3][0].setText(playBoard.getCup(0,3).getSeedString());
        }
        if(playBoard.getCup(0,4).getSeeds() == 0)
        {
            myField[4][0].setText("0");
        }
        else
        {
            myField[4][0].setText(playBoard.getCup(0,4).getSeedString());
        }
        if(playBoard.getCup(0,5).getSeeds() == 0)
        {
            myField[5][0].setText("0");
        }
        else
        {
            myField[5][0].setText(playBoard.getCup(0,5).getSeedString());
        }
        if(playBoard.getCup(0,6).getSeeds() == 0)
        {
            myField[6][0].setText("0");
        }
        else
        {
            myField[6][0].setText(playBoard.getCup(0,6).getSeedString());
        }
        if(playBoard.getCup(0,7).getSeeds() == 0)
        {
            myField[7][0].setText("0");
        }
        else
        {
            myField[7][0].setText(playBoard.getCup(0,7).getSeedString());
        }
  
  if(playBoard.getCup(0,8).getSeeds() == 0)
        {
            myField[8][0].setText("0");
        }
        else
        {
            myField[8][0].setText(playBoard.getCup(0,8).getSeedString());                           
        }
  
  if(playBoard.getCup(0,9).getSeeds() == 0)
        {
            myField[9][0].setText("0");
        }
        else
        {
            myField[9][0].setText(playBoard.getCup(0,9).getSeedString());                           
        }
  
  if(playBoard.getCup(0,10).getSeeds() == 0)
        {
            myField[10][0].setText("0");
        }
        else
        {
            myField[10][0].setText(playBoard.getCup(0,10).getSeedString());                           
        }
  
        if(playBoard.getCup(1,0).getSeeds() == 0)
        {
            myField[0][1].setText("0");
        }
        else
        {
            myField[0][1].setText(playBoard.getCup(1,0).getSeedString());
        }
        if(playBoard.getCup(1,1).getSeeds() == 0)
        {
            myField[1][1].setText("0");
        }
        else
        {
            myField[1][1].setText(playBoard.getCup(1,1).getSeedString());
        }
        if(playBoard.getCup(1,2).getSeeds() == 0)
        {
            myField[2][1].setText("0");
        }
        else
        {
            myField[2][1].setText(playBoard.getCup(1,2).getSeedString());
        }
        if(playBoard.getCup(1,3).getSeeds() == 0)
        {
            myField[3][1].setText("0");
        }
        else
        {
            myField[3][1].setText(playBoard.getCup(1,3).getSeedString());
        }
        if(playBoard.getCup(1,4).getSeeds() == 0)
        {
            myField[4][1].setText("0");
        }
        else
        {
            myField[4][1].setText(playBoard.getCup(1,4).getSeedString());
        }
        if(playBoard.getCup(1,5).getSeeds() == 0)
        {
            myField[5][1].setText("0");
        }
        else
        {
            myField[5][1].setText(playBoard.getCup(1,5).getSeedString());
        }
        if(playBoard.getCup(1,6).getSeeds() == 0)
        {
            myField[6][1].setText("0");
        }
        else
        {
            myField[6][1].setText(playBoard.getCup(1,6).getSeedString());
        }
        if(playBoard.getCup(1,7).getSeeds() == 0)
        {
            myField[7][1].setText("0");
        }
        else
        {
            myField[7][1].setText(playBoard.getCup(1,7).getSeedString());
        }
  
  if(playBoard.getCup(1,8).getSeeds() == 0)
        {
            myField[8][1].setText("0");
        }
        else
        {
            myField[8][1].setText(playBoard.getCup(1,8).getSeedString());                          
        }
  
  if(playBoard.getCup(1,9).getSeeds() == 0)
        {
            myField[9][1].setText("0");
        }
        else
        {
            myField[9][1].setText(playBoard.getCup(1,9).getSeedString());                           
        }
  
  if(playBoard.getCup(1,10).getSeeds() == 0)
        {
            myField[10][1].setText("0");
        }
        else
        {
            myField[10][1].setText(playBoard.getCup(1,10).getSeedString());                           
        }
  
        if(playBoard.getScoreCup(0).getSeeds() == 0)
        {
            sField[0].setText("0");
        }
        else
        {
            sField[0].setText(playBoard.getScoreCup(0).getSeedString());
        }
        if(playBoard.getScoreCup(1).getSeeds() == 0)
        {
            sField[1].setText("0");
        }
        else
        {
            sField[1].setText(playBoard.getScoreCup(1).getSeedString());
        }
    }

   public JLabel[][] getMyLabel()
    {
        return myLabel;
    }
    public JLabel getMyLabel(int row, int col)
    {
        return myLabel[row][col];
    }
    public JLabel[] getsLabel() {
        return sLabel;
    }
    public JLabel getsLabel(int i) {
        return sLabel[i];
    }
    public JButton[][] getMyButton() {
        return myButton;
    }
    public JButton getMyButton(int row, int col) {
        return myButton[row][col];
    }
    public JTextField[][] getMyField() {
        return myField;
    }
    public JTextField getMyField(int row, int col) {
        return myField[row][col];
    }
    public JTextField[] getsField() {
        return sField;
    }
    public JTextField getsField(int i) {
        return sField[i];
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getFinalPanel() {
        return finalPanel;
    }
    public JPanel[] getBoardPanel() {
        return boardPanel;
    }
    public JPanel getBoardPanel(int i) {
        return boardPanel[i];
    }
    public JPanel[] getLabelPanel() {
        return labelPanel;
    }
    public JPanel getLabelPanel(int i) {
        return labelPanel[i];
    }
    public JPanel[] getFieldPanel() {
        return fieldPanel;
    }
    public JPanel getFieldPanel(int i) {
        return fieldPanel[i];
    }
    public JPanel[] getButtonPanel() {
        return buttonPanel;
    }
    public JPanel getButtonPanel(int i) {
        return buttonPanel[i];
    }
    public JPanel[] getScorePanel() {
        return scorePanel;
    }
    public JPanel getScorePanel(int i) {
        return scorePanel[i];
    } 
    
    public int getCupChosen()
    {
        return cupChosen;
    }

    public JTextArea getActionRecordArea()
    {
        
        return actionRecordArea;    
    }
    public JScrollPane getActionScrollPane()
    {
        return actionScrollPane;
    }
    public String getCupChosenString()
    {
        return cupChosenString;
    }  
   public int getPlayer()
   {
       return player;
   }
   public TogizBoard getPlayBoard()
   {
       return playBoard;
   }
   public int getMoveCount()
   {
       return moveCount;
   }
   
private class ButtonListener implements ActionListener, Serializable 
{
  public void actionPerformed(ActionEvent e) 
  {
      boolean wrongCup = false;
      if(e.getSource().equals(myButton[0][0]))
      {
          LinkCup tempRef;
           System.out.println("Made it itttt FUCK YEAH!!!");         
          tempRef = playBoard.getCup(0,0);
          if(tempRef.getPlayer() == player)
          {
            setCupChosen(0);           
            panelPlay();    
            setTextField();
            requestFocus();
            
            actionRecordArea.append("Move:  " + moveCount +
            "; Player: "+ (player+1) +";  Cup:  8 \n");
            moveCount++;
          }
          else
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
              
          }
      }
      if(e.getSource().equals(myButton[1][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 1);
          if (tempRef.getPlayer() == player) {
              setCupChosen(1);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  7 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[2][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 2);
          if (tempRef.getPlayer() == player) {
              setCupChosen(2);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  6 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }  
      }
      if(e.getSource().equals(myButton[3][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 3);
          if (tempRef.getPlayer() == player) {
              setCupChosen(3);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  5 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }   
      }
      if(e.getSource().equals(myButton[4][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 4);
          if (tempRef.getPlayer() == player) {
              setCupChosen(4);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  4 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[5][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 5);
          if (tempRef.getPlayer() == player) {
              setCupChosen(5);
              panelPlay();
              setTextField();
              requestFocus();

              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  3 \n");
              moveCount++;
          } else
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[6][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 6);
          if (tempRef.getPlayer() == player) {
              setCupChosen(6);
              panelPlay();
              setTextField();
              requestFocus();

              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  2 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[7][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 7);
          if (tempRef.getPlayer() == player) {
              setCupChosen(7);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
  
   if(e.getSource().equals(myButton[8][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 8);
          if (tempRef.getPlayer() == player) {
              setCupChosen(8);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");        
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
   
   if(e.getSource().equals(myButton[9][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 9);
          if (tempRef.getPlayer() == player) {
              setCupChosen(9);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");        
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
   
   if(e.getSource().equals(myButton[10][0]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(0, 10);
          if (tempRef.getPlayer() == player) {
              setCupChosen(10);
              panelPlay();
              setTextField();
              requestFocus();
              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");        
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
   
      if(e.getSource().equals(myButton[0][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 0);
          if (tempRef.getPlayer() == player) {
              setCupChosen(0);
              panelPlay();
              setTextField();
              requestFocus();

              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  8 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[1][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 1);
          if (tempRef.getPlayer() == player) {
              setCupChosen(1);
              panelPlay();
              setTextField();
              requestFocus();

              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  7 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          } 
      }
      if(e.getSource().equals(myButton[2][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 2);
          if (tempRef.getPlayer() == player) {
              setCupChosen(2);
              panelPlay();
              setTextField();
              requestFocus();
              
             actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  6 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          } 
      }
      if(e.getSource().equals(myButton[3][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 3);
          if (tempRef.getPlayer() == player) {
              setCupChosen(3);
              panelPlay();
              setTextField();
              requestFocus();

              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  5 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[4][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 4);
          if (tempRef.getPlayer() == player) {
              setCupChosen(4);
              panelPlay();
              setTextField();
              requestFocus();

              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  4 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[5][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 5);
          if (tempRef.getPlayer() == player) {
              setCupChosen(5);
              panelPlay();
              setTextField();
              requestFocus();
              
                  actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  3 \n");
              moveCount++;
          } else
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[6][1]))
      {
          LinkCup tempRef;

          tempRef = playBoard.getCup(1, 6);
          if (tempRef.getPlayer() == player) {
              setCupChosen(6);
              panelPlay();
              setTextField();
              requestFocus();
               
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  2 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
      if(e.getSource().equals(myButton[7][1]))
      {
          LinkCup tempRef;
          tempRef = playBoard.getCup(1, 7);
          if (tempRef.getPlayer() == player) {
              setCupChosen(7);
              panelPlay();
              setTextField();
              requestFocus();

              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)
                      + "; Cup: Invalid \n");
          }
      }
   
   if(e.getSource().equals(myButton[8][1]))
      {
          LinkCup tempRef;
          tempRef = playBoard.getCup(1, 8);
          if (tempRef.getPlayer() == player) {
              setCupChosen(8);
              panelPlay();
              setTextField();
              requestFocus();

              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)         
                      + "; Cup: Invalid \n");
          }
      }
   
   if(e.getSource().equals(myButton[9][1]))
      {
          LinkCup tempRef;
          tempRef = playBoard.getCup(1, 9);
          if (tempRef.getPlayer() == player) {
              setCupChosen(9);
              panelPlay();
              setTextField();
              requestFocus();

              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)         
                      + "; Cup: Invalid \n");
          }
      }
   
   if(e.getSource().equals(myButton[10][1]))
      {
          LinkCup tempRef;
          tempRef = playBoard.getCup(1, 10);
          if (tempRef.getPlayer() == player) {
              setCupChosen(10);
              panelPlay();
              setTextField();
              requestFocus();

              
              actionRecordArea.append("Move:  " + moveCount
                      + "; Player: " + (player + 1) + ";  Cup:  1 \n");
              moveCount++;
          } else 
          {
              wrongCup = true;
              actionRecordArea.append("Move: N/A; Player: "+ (player +1)         
                      + "; Cup: Invalid \n");
          }
      }
  
     if(!wrongCup)
     {
        if (getPlayer() == 0 )
          setPlayer(1);
        else if(getPlayer() == 1)
          setPlayer(0);      
     }
     
  }
}
private class KeyHandler extends KeyAdapter implements Serializable
    {
        public void keyTyped (KeyEvent event)
        {
    
       
            char keyChar = event.getKeyChar();
            int keyInt;
            keyInt = Character.digit(keyChar, 11);
            int cup = 8;
            
            for(int col = 1; col < 11; col++)
            {
                if(col == keyInt)
                {
                    
                   setCupChosen((cup)); 
                   panelPlay(); 
                   setTextField();
                   
                   actionRecordArea.append("Move:  " + moveCount +             
   "; Player: "+ (player+1) +";  Cup:  " + col + "; \n");
                            moveCount++;
                   repaint();
                }
                cup--;
            }
         
                if (getPlayer() == 0)
                    setPlayer(1);
                else if(getPlayer() == 1)
                    setPlayer(0); 

        }
        
    }
 private class TextFieldListener1 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                myField[0][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener2 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[0][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener3 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[1][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener4 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[2][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener5 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[3][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener6 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[4][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener7 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[5][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener8 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[6][0].requestFocusInWindow();    
        }
 }
 private class TextFieldListener9 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[1][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener10 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[2][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener11 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[3][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener12 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[4][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener13 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[5][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener14 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[6][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener15 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[7][1].requestFocusInWindow();    
        }
 }
 private class TextFieldListener16 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[7][0].requestFocusInWindow();    
        }
 }
 
 private class TextFieldListener17 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[8][0].requestFocusInWindow();              
        }
 }
 
 private class TextFieldListener18 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[8][1].requestFocusInWindow();              
        }
 }
 
 private class TextFieldListener19 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[9][0].requestFocusInWindow();              
        }
 }
 
  private class TextFieldListener20 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[9][1].requestFocusInWindow();              
        }
 }
 
 private class TextFieldListener21 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[10][0].requestFocusInWindow();              
        }
 }
 
 private class TextFieldListener22 implements ActionListener, Serializable
    {
        
        public void actionPerformed(ActionEvent e) 
        {
                                           
                myField[10][1].requestFocusInWindow();              
        }
 }
 
  private class MouseHandler extends MouseAdapter implements Serializable
    {
        public void mouseClicked(MouseEvent event)
        {
            if(gamePanel.contains(event.getPoint()))
            {
                requestFocus();
            }
            repaint();
        }
    }
         
}
