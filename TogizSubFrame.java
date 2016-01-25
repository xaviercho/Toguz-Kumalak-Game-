import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class TogizSubFrame extends JFrame
{
    private TogizPanel myPanel;
    private final int FRAMEH = 400;
    private final int FRAMEW = 1000;
    JFileChooser myChooser;

    public TogizSubFrame()
    {
        setTitle("Togiz Kumalak Sub Frame");
        setSize(FRAMEW, FRAMEH);
        myPanel = new TogizPanel();
        
        Container contentPane = getContentPane();
        contentPane.add(myPanel,"Center");
    
        myChooser = new JFileChooser();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
         JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        LoadListener myOpenListener = new LoadListener();
        openItem.addActionListener((ActionListener) myOpenListener);
        
        JMenuItem restartItem = new JMenuItem("Restart");
        fileMenu.add(restartItem);
        RestartListener myRestartListener = new RestartListener();
        restartItem.addActionListener((ActionListener) myRestartListener);
        
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        SaveListener mySaveListener = new SaveListener();
        saveItem.addActionListener((ActionListener) mySaveListener);
        
        JMenuItem closeItem = new JMenuItem("Close");
        fileMenu.add(closeItem);
        CloseListener myCloseListener = new CloseListener();
        closeItem.addActionListener((ActionListener) myCloseListener);
    }

    private class RestartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
          myPanel.renewBoard();
          myPanel.RenewTextArea();
          myPanel.setMoveCount(1);
        }
    }


private class CloseListener implements ActionListener
{
 public void actionPerformed(ActionEvent event)
        {
  dispose();
 }
}

private class SaveListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
 String fileName;
        myChooser.setCurrentDirectory(new File("."));
        myChooser.showSaveDialog(TogizSubFrame.this);
        fileName = myChooser.getSelectedFile().getPath();

        try {
                ObjectOutputStream objOut = new ObjectOutputStream(
                        new FileOutputStream(fileName));
            
                objOut.writeObject(myPanel.getActionRecordArea());
                objOut.writeObject(myPanel.getActionScrollPane());
                objOut.writeObject(myPanel.getCupChosenString());

                objOut.writeObject(myPanel.getPlayBoard());
                objOut.writeObject(myPanel.getCupChosen());
                objOut.writeObject(myPanel.getPlayer());

                objOut.writeObject(myPanel.getMoveCount());
                
                objOut.writeObject(myPanel.getMyLabel());
                for (int row = 0; row < 2; row++)
                {
                    for(int col = 0; col < 11; col++)
                    {
                        objOut.writeObject(myPanel.getMyLabel(col, row));
                    }
                }
                objOut.writeObject(myPanel.getsLabel());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getsLabel(i));
                }
                 objOut.writeObject(myPanel.getMyButton());
                for (int row = 0; row < 2; row++)
                {
                    for(int col = 0; col < 11; col++)
                    {
                        objOut.writeObject(myPanel.getMyButton(col, row));    
                    }
                }    
                objOut.writeObject(myPanel.getMyField());
                for (int row = 0; row < 2; row++)
                {
                    for(int col = 0; col < 11; col++)
                    {
                        objOut.writeObject(myPanel.getMyField(col, row));
                    }
                }
               objOut.writeObject(myPanel.getsField());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getsField(i));
                }
                
                objOut.writeObject(myPanel.getGamePanel());
                objOut.writeObject(myPanel.getFinalPanel());
                
                objOut.writeObject(myPanel.getBoardPanel());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getBoardPanel(i));
                }
                objOut.writeObject(myPanel.getLabelPanel());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getLabelPanel(i));
                }
                objOut.writeObject(myPanel.getFieldPanel());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getFieldPanel(i));
                }
                objOut.writeObject(myPanel.getButtonPanel());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getButtonPanel(i));
                }
                objOut.writeObject(myPanel.getScorePanel());
                for(int i = 0; i < 2;i++)
                {
                    objOut.writeObject(myPanel.getScorePanel(i));
                }
            
            objOut.close();
            
        } catch (IOException e) {
            System.out.println("Problem making or writing to an output stream.");
            System.out.println(e);
        }
  }
 }
private class LoadListener implements ActionListener
{
        public void actionPerformed(ActionEvent event)
        {
                String fileName;
                myChooser.setCurrentDirectory(new File("."));
                myChooser.showOpenDialog(TogizSubFrame.this);
                fileName = myChooser.getSelectedFile().getPath();
                try
                {
                        Container contentPane = getContentPane();
                        contentPane.remove(myPanel);
                        myPanel = new TogizPanel();
                        myPanel.remove(myPanel.getFinalPanel());
                        myPanel.remove(myPanel.getActionRecordArea());
                        myPanel.remove(myPanel.getActionScrollPane());
                        
                        contentPane.add(myPanel, "Center");

                        ObjectInputStream objIn = new ObjectInputStream(
                                new FileInputStream(fileName));
                      
                        myPanel.setActionRecordArea((JTextArea) objIn.readObject());
                        myPanel.setActionScrollPane((JScrollPane) objIn.readObject());
                        myPanel.setCupChosenString((String) objIn.readObject());

                        myPanel.setPlayBoard((TogizBoard) objIn.readObject());       
                        myPanel.setCupChosen((int) objIn.readObject());
                        myPanel.setPlayer((int) objIn.readObject());

                        myPanel.setMoveCount((int) objIn.readObject());

                        myPanel.setMyLabel((JLabel[][]) objIn.readObject());
                        for (int row = 0; row < 2; row++)
                        {
                            for(int col = 0; col < 11; col++)
                            {
                                myPanel.setMyLabel((JLabel) objIn.readObject(), col, row);
                            }
                        }
                        myPanel.setsLabel((JLabel[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {
                            myPanel.setsLabel((JLabel) objIn.readObject(),i);
                        }
                        myPanel.setMyButton((JButton[][]) objIn.readObject());
                        for (int row = 0; row < 2; row++)
                        {
                            for(int col = 0; col < 11; col++)
                            {
                                myPanel.setMyButton((JButton) objIn.readObject(), col, row);
                            }
                        }
                        myPanel.setMyField((JTextField[][]) objIn.readObject());
                        for (int row = 0; row < 2; row++)
                        {
                            for(int col = 0; col < 11; col++)
                            {
                                myPanel.setMyField((JTextField) objIn.readObject(), col, row);
                            }
                        }
                       myPanel.setsField((JTextField[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {
                            myPanel.setsField((JTextField) objIn.readObject(),i);
                        }

                        myPanel.setGamePanel((JPanel) objIn.readObject());
                        myPanel.setFinalPanel((JPanel) objIn.readObject());
                        myPanel.setBoardPanel((JPanel[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {
                            myPanel.setBoardPanel((JPanel) objIn.readObject(),i);
                        }
                       myPanel.setLabelPanel((JPanel[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {   
                            myPanel.setLabelPanel((JPanel) objIn.readObject(),i);
                        }
                        myPanel.setFieldPanel((JPanel[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {
                            myPanel.setFieldPanel((JPanel) objIn.readObject(),i);
                        }
                       myPanel.setButtonPanel((JPanel[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {
                            myPanel.setButtonPanel((JPanel) objIn.readObject(),i);
                        }
                        myPanel.setScorePanel((JPanel[]) objIn.readObject());
                        for(int i = 0; i < 2;i++)
                        {
                            myPanel.setScorePanel((JPanel) objIn.readObject(),i);
                        }
                        JScrollPane actionScrollPane = new JScrollPane(myPanel.getActionRecordArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                        myPanel.add(actionScrollPane);
   
                        myPanel.add(myPanel.getFinalPanel());
            
                        myPanel.setTextField();
                        setVisible(true);
                        objIn.close();
                }
                catch(IOException e)
                {
                        System.out.println("Problem making an input stream.");
                }
                catch(ClassNotFoundException e)
                {
                        System.out.println("Class not found problem when reading objects.");
                }
        }
}
}
