import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TogizMainFrame extends JFrame
{
    private int subFrameLocation = 250;
    private final int FRAMEH = 200;
    private final int FRAMEW = 200;
   
    public TogizMainFrame()
    {
       setTitle("Togiz Kumalak Main Frame");
        setSize(FRAMEW, FRAMEH);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem subFrameItem = new JMenuItem("Create SubFrame");
        fileMenu.add(subFrameItem);
        TogizMainFrame.MakeSubFrameListener mySubFrameListener = new TogizMainFrame.MakeSubFrameListener();
        subFrameItem.addActionListener((ActionListener) mySubFrameListener);
        
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        TogizMainFrame.ExitListener myExitListener = new TogizMainFrame.ExitListener();
        exitItem.addActionListener((ActionListener) myExitListener);
    }

    private class ExitListener  implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {
            System.exit(0);
        }
    }
    
    private class MakeSubFrameListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            JFrame.setDefaultLookAndFeelDecorated(true);
            TogizSubFrame myframe = new TogizSubFrame();
            
            myframe.setLocation(subFrameLocation, subFrameLocation);
            if (subFrameLocation >= 250)
            {
                subFrameLocation = 50;
            } else {
                subFrameLocation += 50;
            }
            myframe.setVisible(true);
            
        }

        }
    }