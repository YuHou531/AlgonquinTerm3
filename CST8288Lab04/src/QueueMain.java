import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import junit.framework.TestSuite;
import mycollections.ArrayListQueue;
import mycollections.EmptyQueueException;
import mycollections.NullObjectException;
import testcollections.Test_ArrayrListQueue;

/**
 * QueueMain
 * 
 * @author    Yu Hou
 * @version   Nov 20 2016
 *
 */
public class QueueMain {
	
	/** attribute queue arraylist */
	private ArrayListQueue arrayListQueue;
	/** attribute to display result */
	private JTextArea textArea;
	/** attribute using as JTextField object */
	private JTextField input;
	
	/**
	 * Default constructor for QueueMain
	 */
	public QueueMain() {
		arrayListQueue = new ArrayListQueue();
	}

	/**
	 * If arguments exist on the command line enqueue them and dequeue them and terminate
	 * if no arguments, display GUI and take it from there
	 * 
	 * @param args - arguments for input enqueue
	 * @throws EmptyQueueException  EmptyQueueException
	 */
	public static void main (String args[]) throws EmptyQueueException {
		
		TestSuite suite = new TestSuite();
		suite.addTest(Test_ArrayrListQueue.suite());
        System.out.println("Executing AllTests ...");
        junit.textui.TestRunner.run(suite);
		
        if(args.length > 0) {
        	System.out.println("Welcome to QueueMain - Yu Hou (Lab 4)");
        	System.out.println("=====================================");
        	
        	ArrayListQueue queue = new ArrayListQueue();
        	System.out.println("enqueue from arguments");
        	
    		for ( String arg : args ) {
    			try {
    				queue.enqueue( arg );
    			}  catch ( NullObjectException e ) {
    				System.out.println( "argument cannot be null for enqueue" );
    			}
    		}
    		System.out.println("current queue is " + queue.getArrayList() );
    		
    		System.out.println("dequeue from arguments");
    		for ( String arg : args ) {
    			queue.dequeue();
    			System.out.println("current queue is " + queue.getCurrentQueueList());
    		}
    		
    		System.out.println("the end, thanks!");
        }
        else {
        	System.out.println("Welcome to QueueMain - Yu Hou (Lab 4) - GUI part");
        	QueueMain queueApp = new QueueMain();
        	queueApp.initGUI();
        }
	}
	
	/**
	 * initGUI for the Queue GUI
	 */
	private void initGUI() {

		JFrame jFrame = new JFrame("Test GUI for QueueMain (Lab 4)");
		GridBagLayout root = new GridBagLayout();
		
		jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jFrame.getContentPane().setLayout( root );
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		// JPanel used to input for enqueue
		JPanel inputPanel = createInputPanel();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 500;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jFrame.getContentPane().add( inputPanel, gridBagConstraints );
		
		// JPanel for buttons (enqueue / dequeue / 100000 and 1000000 elements)
		JPanel buttonPanel = createButtonPanel();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 500;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		jFrame.getContentPane().add( buttonPanel, gridBagConstraints );
		
		// JPanel to display queue
		JPanel queueResultPanel = createQueueResultPanel();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 500;
		gridBagConstraints.ipady = 200;   
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		
		jFrame.getContentPane().add( queueResultPanel, gridBagConstraints );
		
		jFrame.pack(); // update JFrame size to fit content size

		// Set JFrame to the middle of the screen
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      
		int x=(int)((dimension.getWidth() - jFrame.getWidth())/2);
		int y=(int)((dimension.getHeight() - jFrame.getHeight())/2);
		jFrame.setLocation(x, y); 

		jFrame.setVisible(true);
	}
	
	/** 
	 * JPanel used to input for enqueue
	 * @return JPanel used to input for enqueue
	 */
	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new BorderLayout()); 
		panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED), new EmptyBorder(5, 5, 5, 5)));
		input = new JTextField();
		panel.add(new JLabel("Input (separate by space please): "), BorderLayout.WEST); 
		panel.add(input, BorderLayout.CENTER);
		return panel;
	}
	
	/** 
	 * JPanel for buttons (enqueue / dequeue / 100000 and 1000000 elements)
	 * @return JPanel for buttons (enqueue / dequeue / 100000 and 1000000 elements)
	 */
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout( 1, 4 )); // create base panel object
		panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED), new EmptyBorder(5, 5, 5, 5)));
		JButton enqueueButton = new JButton( "enqueue" );
		JButton dequeueButton = new JButton( "dequeue" );
		JButton testCase0Button = new JButton( "100" );
		JButton testCase1Button = new JButton( "100000" );
		JButton testCase2Button = new JButton( "1000000" ); 
		enqueueButton.setPreferredSize(new Dimension(60, 40));
		dequeueButton.setPreferredSize(new Dimension(60, 40));
		testCase0Button.setPreferredSize(new Dimension(60, 40));
		testCase1Button.setPreferredSize(new Dimension(60, 40));
		testCase2Button.setPreferredSize(new Dimension(60, 40));

		enqueueButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( input.getText() != null && !input.getText().isEmpty() ) {
					String inputs[] = input.getText().split(" ");
					for ( String item : inputs ) {
						try {
							arrayListQueue.enqueue((Object)item);
						} catch (NullObjectException e1) {
							textArea.setText( "cannot add null to the queue" );
						}
					}
				}
				textArea.setText( getCurrentQueue() );
				input.setText("");
			}
		});

		dequeueButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					arrayListQueue.dequeue();
				} catch (EmptyQueueException e1) {
					textArea.setText( "queue is empty now" );
				}
				textArea.setText( getCurrentQueue() );
				if( arrayListQueue.getCurrentQueueList().size() == 0 ) {
					textArea.setText( "no items in the queue now..." );
				}
			}
		});

		// 100 test
		testCase0Button.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("perform 100 elements queue test, please wait");
					textArea.setText( performTestQueue(100) );
				} catch (EmptyQueueException e1) {
					// TODO Auto-generated catch block
					textArea.setText( "got EmptyQueueException" );
				}
			}
		});
		
		// 100000 test
		testCase1Button.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("perform 100000 elements queue test, please wait");
					textArea.setText( performTestQueue(100000) );
				} catch (EmptyQueueException e1) {
					// TODO Auto-generated catch block
					textArea.setText( "got EmptyQueueException" );
				}
			}
		});

		// 1000000 test
		testCase2Button.addActionListener( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("perform 1000000 elements queue test, please wait");
					textArea.setText( performTestQueue(1000000) );
				} catch (EmptyQueueException e1) {
					// TODO Auto-generated catch block
					textArea.setText( "got EmptyQueueException" );
				}
			}
		});

		panel.add(enqueueButton);
		panel.add(dequeueButton);
		panel.add(testCase0Button);
		panel.add(testCase1Button);
		panel.add(testCase2Button);
		return panel;
	}
	
	/** 
	 * JPanel to display queue
	 * @return JPanel to display queue
	 */
	private JPanel createQueueResultPanel() {
		JPanel panel = new JPanel(new BorderLayout());				
		textArea = new JTextArea(10, 1);
		textArea.setText( getCurrentQueue() ); // show the queue
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.setPreferredSize(new Dimension(450, 110));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
	}

	/**
	 * Return current queue
	 * @return string of the queue
	 */
	private String getCurrentQueue() {
		String result = "";
		if( arrayListQueue.getCurrentQueueList().size() > 0 ) {
			result += arrayListQueue.getCurrentQueueList();
		}
		return result;
	}
	
	/**
	 * Used to perform more queue tests
	 * @param numberOfTests number of Tests
	 * @return test report
	 * @throws EmptyQueueException 
	 */
	private String performTestQueue(int numberOfTests) throws EmptyQueueException {
		//cleanup
		arrayListQueue.clear();
		
		boolean displayCurrentQueue = numberOfTests <= 1000 ? true : false;
		
		long start, enqueueTime, dequeueTime;
		
		start = System.currentTimeMillis();

		Random rand = new Random();
		String report = "";
		String reportEnqueue = "";
		String reportDequeue = "";
		
		report += "Test queue in " + numberOfTests + " elements\n";
		
		for(int j = 0; j<numberOfTests; j++) {
			//maximum number is 50, minimum is 1
			int  number = rand.nextInt(50) + 1;
			try {
				arrayListQueue.enqueue((Object) number);
			} catch (NullObjectException e1) {
				System.out.println( "argument cannot be null for enqueue" );
			}
		}
		
		enqueueTime = System.currentTimeMillis();
				
		reportEnqueue += "\ncurrent queue is " + arrayListQueue.getArrayList() + "\n";
		reportEnqueue += "\nenqueue time cost is " + (enqueueTime - start) + " milliseconds";
		reportEnqueue += "\ndequeue...\n";
		
		for(int j = 0; j<numberOfTests; j++) {
			arrayListQueue.dequeue();
			if(displayCurrentQueue) {
				reportDequeue += "\ncurrent queue is " + arrayListQueue.getCurrentQueueList() + "\n";
			}
		}
		
		dequeueTime = System.currentTimeMillis();
		
		reportEnqueue += "\ndequeue time cost is " + (dequeueTime - enqueueTime) + " milliseconds";
		report += reportEnqueue;
		report += reportDequeue;
		report += "\nthe end, thanks!\n";
		
		return report;
	}
}
