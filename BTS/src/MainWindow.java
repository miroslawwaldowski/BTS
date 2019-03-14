import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
    
	public static final int HEIGHT = 650;
    public static final int WIDTH = 600;
	JButton buttonGenerator; 
	JButton buttonSave;
	JLabel citySizeLabel;
	JLabel btsQuantityLabel;
	JLabel btsRangeLabel;
	JTextField citySizeTextField;
	JTextField btsQuantityTextField;
	JTextField btsRangeTextField;	
    
	public MainWindow() {

		this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BTS");
		
		setLayout(new FlowLayout());
		
		buttonGenerator = new JButton("Generuj"); 
		buttonSave = new JButton("Zapisz");
		citySizeLabel = new JLabel("Wielkosc miasta");
		btsQuantityLabel = new JLabel("Ilosc BTS");
		btsRangeLabel = new JLabel("Zasieg BTS");
		citySizeTextField = new JTextField(5);
		btsQuantityTextField = new JTextField(5);
		btsRangeTextField = new JTextField(5);

		buttonGenerator.addActionListener(new buttonListener());
		citySizeTextField.addKeyListener(new DoubleNumbersKeyListener());
		btsQuantityTextField.addKeyListener(new IntegerNumbersKeyListener());
		btsRangeTextField.addKeyListener(new DoubleNumbersKeyListener());
				
 		this.add(citySizeLabel);
 		this.add(citySizeTextField);
 		this.add(btsQuantityLabel);
 		this.add(btsQuantityTextField);
 		this.add(btsRangeLabel);
 		this.add(btsRangeTextField);
 		this.add(buttonGenerator);
 		this.add(buttonSave);

		JPanel Panel = new Panel();
		
		this.add(Panel);        
		this.setVisible(true);

	}
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonGenerator) {
				double x=0;
				double y=0;
				int z=0;
				
				if (!citySizeTextField.getText().isEmpty()) {
					x = Double.parseDouble(citySizeTextField.getText());
					Bts.citySize = x;
				}
				if (!btsRangeTextField.getText().isEmpty()) {
					y = Double.parseDouble(btsRangeTextField.getText());
					Bts.btsRange=y;
				}
				if (!btsQuantityTextField.getText().isEmpty()) {
					z = Integer.parseInt(btsQuantityTextField.getText());
					Bts.btsQuantity=z;
				}
				
				System.out.println(x+" "+z+" "+y);
				Bts.calculation();
				repaint();
			}
		}
	}
	class DoubleNumbersKeyListener implements KeyListener {

	    final HashSet<Character> valid_keys = new HashSet<>();
	    final ArrayList<Character> sequence = new ArrayList<>();

	    public DoubleNumbersKeyListener() {
	        valid_keys.add('.');
	        valid_keys.add('0');
	        valid_keys.add('1');
	        valid_keys.add('2');
	        valid_keys.add('3');
	        valid_keys.add('4');
	        valid_keys.add('5');
	        valid_keys.add('6');
	        valid_keys.add('7');
	        valid_keys.add('8');
	        valid_keys.add('9');
	        valid_keys.add((char) KeyEvent.VK_BACK_SPACE);
	        valid_keys.add((char) KeyEvent.VK_DELETE);
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {
	        char c = e.getKeyChar();
	            if (!valid_keys.contains(c)) {
	                e.consume();
	            } else {
	                if (c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE) {
	                    if (!sequence.isEmpty()) {
	                        char last = sequence.remove(sequence.size() - 1);
	                        if (last == '.') {
	                            valid_keys.add(last);
	                        }
	                    }
	                } else {
	                    sequence.add(c);
	                    if (c == '.') {
	                        valid_keys.remove(c);
	                    }
	                }
	            }
	    }

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class IntegerNumbersKeyListener implements KeyListener {

	    final HashSet<Character> valid_keys = new HashSet<>();
	    final ArrayList<Character> sequence = new ArrayList<>();

	    public IntegerNumbersKeyListener() {
	        valid_keys.add('0');
	        valid_keys.add('1');
	        valid_keys.add('2');
	        valid_keys.add('3');
	        valid_keys.add('4');
	        valid_keys.add('5');
	        valid_keys.add('6');
	        valid_keys.add('7');
	        valid_keys.add('8');
	        valid_keys.add('9');
	        valid_keys.add((char) KeyEvent.VK_BACK_SPACE);
	        valid_keys.add((char) KeyEvent.VK_DELETE);
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {
	        char c = e.getKeyChar();
	            if (!valid_keys.contains(c)) {
	                e.consume();
	            } else {
	            	sequence.add(c);
	            }
	    }

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}