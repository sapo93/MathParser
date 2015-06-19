package Gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.GridLayout;
import javax.swing.JTextField;

import Parser.MathEvaluator;
import Parser.MathParser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;



public class JavaCalcGui implements ActionListener {

	/** Frame */
	private JFrame frame;
	
	/** Text Fields */
	private JTextField inputTextField;
	private JTextField parserTextField;
	private JTextField resultTextField;
	
	/** Panels */
	private JPanel panelIO;
	private JPanel panelParse;
	private JPanel panelCenter;
	private JPanel panelNumber;
	private JPanel panelArithmeticOperators;
	private JPanel panelOperators;	
	
	
	/** Buttons */
	private JButton buttonClear;
	private JButton buttonParse;
	private JButton buttonEval;	
	private JButton buttonPoint;	
	private JButton buttonLP;	
	private JButton buttonRP;	
	private JButton button9;	
	private JButton button8;	
	private JButton button7;	
	private JButton button6;	
	private JButton button5;	
	private JButton button4;	
	private JButton button3;	
	private JButton button2;	
	private JButton button1;	
	private JButton button0;	
	private JButton buttonPI;
	private JButton buttonE;
	private JButton buttonPlus;
	private JButton buttonBinMinus;
	private JButton buttonMult;
	private JButton buttonDiv;
	private JButton buttonUnMinus;
	private JButton buttonEqual;
	private JButton buttonCOS;
	private JButton buttonSIN;
	private JButton buttonTAN;
	private JButton buttonACOS;
	private JButton buttonASIN;
	private JButton buttonATAN;
	private JButton buttonLOG;
	private JButton buttonEXP;
	private JButton buttonPOW;
	private JButton buttonSQRT;
	private JButton buttonCOSH;
	private JButton buttonSINH;
	private JButton buttonTANH;
	private JButton buttonFACT;
	
	
	/**
	 * Constructor Create the application.
	 */
	public JavaCalcGui() {
		
		try {
		    
			// Nimbus Look And Feel
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		       
				if ("Nimbus".equals(info.getName())) {
		       
					UIManager.setLookAndFeel(info.getClassName());
					
		            break;
		        
				}
		    
			} 
			
			// System Look And Feel
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		} catch (Exception e) {
			
			e.printStackTrace();
		   
		}
		
		this.initializeObjects();
		
		this.createGui();
		
		this.frame.setVisible(true);
	
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeObjects() {
		
		// Instantiate Frame
		this.frame = new JFrame();		
		
		// Instantiate TextFields
		this.inputTextField = new JTextField();
		this.parserTextField = new JTextField();
		this.resultTextField = new JTextField();
		
		// Instantiate Panels
		this.panelIO = new JPanel();
		this.panelParse = new JPanel();
		this.panelCenter = new JPanel();		
		this.panelNumber = new JPanel();
		this.panelArithmeticOperators = new JPanel();
		this.panelOperators = new JPanel();
		
		
		// Instantiate NumberButtons
		this.buttonClear = new JButton("Clear");
		this.buttonParse = new JButton("Parse");
		this.buttonEval = new JButton("Eval");
		this.buttonPoint = new JButton(".");		
		this.buttonLP = new JButton("(");		
		this.buttonRP = new JButton(")");		
		this.button9 = new JButton("9");		
		this.button8 = new JButton("8");		
		this.button7 = new JButton("7");		
		this.button6 = new JButton("6");		
		this.button5 = new JButton("5");		
		this.button4 = new JButton("4");	
		this.button3 = new JButton("3");		
		this.button2 = new JButton("2");		
		this.button1 = new JButton("1");		
		this.button0 = new JButton("0");		
		this.buttonPI = new JButton("PI");		
		this.buttonE = new JButton("e");
		this.buttonPlus = new JButton("+");
		this.buttonBinMinus = new JButton("-");
		this.buttonMult = new JButton("*");
		this.buttonDiv = new JButton("/");
		this.buttonUnMinus = new JButton("(-)");	
		this.buttonEqual = new JButton("=");
		
		
		// Instantiate OperatorsButtons
		this.buttonCOS = new JButton("COS");		
		this.buttonSIN = new JButton("SIN");
		this.buttonTAN = new JButton("TAN");		
		this.buttonACOS = new JButton("ACOS");		
		this.buttonASIN = new JButton("ASIN");		
		this.buttonATAN = new JButton("ATAN");	
		this.buttonLOG = new JButton("LOG");		
		this.buttonEXP = new JButton("EXP");	
		this.buttonPOW = new JButton("POW");	
		this.buttonSQRT = new JButton("SQRT");	
		this.buttonCOSH = new JButton("COSH");	
		this.buttonSINH = new JButton("SINH");	
		this.buttonTANH = new JButton("TANH");	
		this.buttonFACT = new JButton("FACT");
	
	}
	
	
	/**
	 * Create Graphical Structure
	 */
	private void createGui() {
		
		// Construct Frame
		this.frame.setBounds(100, 100, 650, 400);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		// Construct PanelIO
		this.frame.getContentPane().add(this.panelIO);
		this.panelIO.setLayout(new GridLayout(3, 1, 0, 0));
		
		
		// Construct IOTextFields
		this.panelIO.add(this.inputTextField);		
		this.parserTextField.setEditable(false);
		this.panelIO.add(this.parserTextField);
		this.resultTextField.setEditable(false);
		this.panelIO.add(this.resultTextField);
		
		
		// Construct Parse Panel
		this.frame.getContentPane().add(this.panelParse);
		panelParse.setLayout(new GridLayout(0, 3, 0, 0));
		panelParse.add(buttonClear);
		panelParse.add(buttonParse);
		panelParse.add(buttonEval);
		
		
		// Construct CenterPanel
		this.frame.getContentPane().add(this.panelCenter);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.X_AXIS));
		
		
		// Construct NumberPanel
		this.panelCenter.add(this.panelNumber);
		this.panelNumber.setLayout(new GridLayout(5, 3, 0, 0));
		
		
		// Construct NumberButtons
		this.panelNumber.add(this.buttonPoint);
		this.panelNumber.add(this.buttonLP);
		this.panelNumber.add(this.buttonRP);
		this.panelNumber.add(this.button9);
		this.panelNumber.add(this.button8);
		this.panelNumber.add(this.button7);
		this.panelNumber.add(this.button6);
		this.panelNumber.add(this.button5);
		this.panelNumber.add(this.button4);
		this.panelNumber.add(this.button3);
		this.panelNumber.add(this.button2);
		this.panelNumber.add(this.button1);
		this.panelNumber.add(this.button0);
		this.panelNumber.add(this.buttonPI);
		this.panelNumber.add(this.buttonE);
		
		
		// Construct ArithmeticOperatorsPanel
		this.panelCenter.add(this.panelArithmeticOperators);
		this.panelArithmeticOperators.setLayout(new GridLayout(3, 2, 0, 0));
		
		
		// Construct ArithmeticOperatorButtons
		this.panelArithmeticOperators.add(this.buttonPlus);		
		this.panelArithmeticOperators.add(this.buttonBinMinus);		
		this.panelArithmeticOperators.add(this.buttonMult);		
		this.panelArithmeticOperators.add(this.buttonDiv);		
		this.panelArithmeticOperators.add(this.buttonUnMinus);	
		this.panelArithmeticOperators.add(this.buttonEqual);
		
		
		// Construct OperatorsPanel
		this.frame.getContentPane().add(this.panelOperators);
		this.panelOperators.setLayout(new GridLayout(4, 3, 0, 0));
		
		// Construct ArithmeticOperatorButtons
		this.panelOperators.add(this.buttonCOS);		
		this.panelOperators.add(this.buttonSIN);		
		this.panelOperators.add(this.buttonTAN);		
		this.panelOperators.add(this.buttonACOS);		
		this.panelOperators.add(this.buttonASIN);	
		this.panelOperators.add(this.buttonATAN);
		this.panelOperators.add(this.buttonLOG);
		this.panelOperators.add(this.buttonEXP);
		this.panelOperators.add(this.buttonPOW);
		this.panelOperators.add(this.buttonSQRT);;
		this.panelOperators.add(this.buttonCOSH);
		this.panelOperators.add(this.buttonSINH);
		this.panelOperators.add(this.buttonTANH);
		this.panelOperators.add(this.buttonFACT);
		
		
		
		// Add Action Listener To Every Button
		this.buttonClear.addActionListener(this);
		this.buttonParse.addActionListener(this);
		this.buttonEval.addActionListener(this);
		this.button0.addActionListener(this);
		this.buttonPoint.addActionListener(this);		
		this.buttonLP.addActionListener(this);		
		this.buttonRP.addActionListener(this);		
		this.button9.addActionListener(this);		
		this.button8.addActionListener(this);		
		this.button7.addActionListener(this);		
		this.button6.addActionListener(this);		
		this.button5.addActionListener(this);		
		this.button4.addActionListener(this);	
		this.button3.addActionListener(this);		
		this.button2.addActionListener(this);		
		this.button1.addActionListener(this);		
		this.button0.addActionListener(this);	
		this.buttonPI.addActionListener(this);		
		this.buttonE.addActionListener(this);		
		this.buttonPlus.addActionListener(this);
		this.buttonBinMinus.addActionListener(this);
		this.buttonMult.addActionListener(this);
		this.buttonDiv.addActionListener(this);
		this.buttonUnMinus.addActionListener(this);
		this.buttonEqual.addActionListener(this);
		this.buttonCOS.addActionListener(this);		
		this.buttonSIN.addActionListener(this);
		this.buttonTAN.addActionListener(this);	
		this.buttonACOS.addActionListener(this);	
		this.buttonASIN.addActionListener(this);		
		this.buttonATAN.addActionListener(this);	
		this.buttonLOG.addActionListener(this);		
		this.buttonEXP.addActionListener(this);	
		this.buttonPOW.addActionListener(this);	
		this.buttonSQRT.addActionListener(this);	
		this.buttonCOSH.addActionListener(this);
		this.buttonSINH.addActionListener(this);	
		this.buttonTANH.addActionListener(this);
		this.buttonFACT.addActionListener(this);
		
	}
	
	
	/**
	 * ActionPerformed Implementation
	 */
	@Override
	public void actionPerformed (ActionEvent e) {
		
		if (e.getActionCommand().equals ("Eval") || e.getActionCommand().equals ("=")) {
			
			try {
				
				MathParser parser = new MathParser (this.inputTextField.getText(), "infix");
				
				this.parserTextField.setText(parser.getInfixString());
				
				MathEvaluator eval = new MathEvaluator (parser.getMathExpr());
				
				this.resultTextField.setText(eval.getResultString());
				
			} catch (Exception e1) {
				
				this.resultTextField.setText(e1.getMessage());
				
			}
			
		} else if (e.getActionCommand().equals ("Parse")) {
			
			try {
				
				MathParser parser = new MathParser (this.inputTextField.getText(), "infix");
				
				this.parserTextField.setText(parser.getInfixString());
				
				this.resultTextField.setText("");
				
			} catch (Exception e1) {
				
				this.parserTextField.setText(e1.getMessage());
				
			}	
			
			
		} else if (e.getActionCommand().equals ("Clear")) {
			
			this.inputTextField.setText("");
			
			this.parserTextField.setText("");
			
			this.resultTextField.setText("");
			
			this.inputTextField.repaint();
			
			this.parserTextField.repaint();
			
			this.resultTextField.repaint();		
			
			
		}  else {
			
			String currentInput = this.inputTextField.getText();
			
			if (e.getActionCommand().equals ("0")
				|| e.getActionCommand().equals ("1")
				|| e.getActionCommand().equals ("2")
				|| e.getActionCommand().equals ("3")
				|| e.getActionCommand().equals ("4")
				|| e.getActionCommand().equals ("5")
				|| e.getActionCommand().equals ("6")
				|| e.getActionCommand().equals ("7")
				|| e.getActionCommand().equals ("8")
				|| e.getActionCommand().equals ("9")
				|| e.getActionCommand().equals (".")
				|| e.getActionCommand().equals ("PI")
				|| e.getActionCommand().equals ("E")) {
			
				currentInput += e.getActionCommand();
				
			} else if (e.getActionCommand().equals ("(-)")) {
				
				currentInput += " " + "#" + " ";
				
			} else if (e.getActionCommand().equals ("COS")
					|| e.getActionCommand().equals ("SIN")
					|| e.getActionCommand().equals ("TAN")
					|| e.getActionCommand().equals ("ACOS")
					|| e.getActionCommand().equals ("ASIN")
					|| e.getActionCommand().equals ("ATAN")
					|| e.getActionCommand().equals ("LOG")
					|| e.getActionCommand().equals ("EXP")
					|| e.getActionCommand().equals ("POW")
					|| e.getActionCommand().equals ("SQRT")
					|| e.getActionCommand().equals ("COSH")
					|| e.getActionCommand().equals ("SINH")
					|| e.getActionCommand().equals ("TANH")
					|| e.getActionCommand().equals ("FACT")) {
				
				currentInput += e.getActionCommand() + " ( ";
				
			} else {
					
				currentInput += " " + e.getActionCommand() + " ";
				
			}
			
			this.inputTextField.setText (currentInput);
			
		}
		
	}
	
	
}
