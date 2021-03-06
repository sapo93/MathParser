package MathToken;

import java.util.ArrayList;

import Exceptions.WrongCompareException;


public abstract class MathToken implements Comparable<MathToken> {

	/** Token Value*/
	protected String value;
	
	/** Token Type: Operand, Operator, Parenthesis Or Symbol*/
	protected String type; 
	
	/** Token Name*/
	protected String name;
	
	
	/**
	 * Abstract Constructor That Check The Token Common Fields:
	 * - Value
	 * - Name
	 * 
	 * @param value Token Operator
	 * @param name Token Name
	 */
	public MathToken (String value, String name) {
		
		if (value == null) { // Value Mustn't Be Null
			
			throw new NullPointerException ("Value is null!!!");
			
		}
		
		if (value.length() == 0) { // Value Mustn't Be Empty
			
			throw new NullPointerException ("Value is empty!!!");
			
		}	
		
		if (name == null) { // Name Mustn't Be Null
			
			throw new NullPointerException ("Name is null!!!");
			
		}
		
		if (name.length() == 0) { // Name Mustn't Be Empty
			
			throw new NullPointerException ("Name is empty!!!");
			
		}
		
		this.value = value;	
		
		this.name = name;
		
		
		
	}
	
	
	
	/**
	 * Check If The Token Is An Operand
	 * @return TRUE If The Token Is An Operand, False Otherwise
	 */
	public boolean isOperand() {
		
		boolean returnValue;
		
		if (this.type.equals("operand")) {
			
			returnValue = true;
			
		} else {
			
			returnValue = false;
			
		}
		
		return returnValue;
		
	}

	

	/**
	 * Check If The Token Is An Operator
	 * @return TRUE If The Token Is An Operator, False Otherwise
	 */
	public boolean isOperator() {
		
		boolean returnValue;
		
		if (this.type.equals("operator")) {
			
			returnValue = true;
			
		} else {
			
			returnValue = false;
			
		}
		
		return returnValue;
		
	}
	
	
	
	/**
	 * Check If The Token Is A Parenthesis
	 * @return TRUE If The Token Is A Parenthesis, False Otherwise
	 */
	public boolean isParenthesis() {
		
		boolean returnValue;
		
		if (this.type.equals("parenthesis")) {
			
			returnValue = true;
			
		} else {
			
			returnValue = false;
			
		}
		
		return returnValue;
		
	}
	
	
	/**
	 * Check If The Token Is A Symbol
	 * @return TRUE If The Token Is A Symbol, False Otherwise
	 */
	public boolean isSymbol() {
		
		boolean returnValue;
		
		if (this.type.equals("symbol")) {
			
			returnValue = true;
			
		} else {
			
			returnValue = false;
			
		}
		
		return returnValue;
		
	}

	
	/**
	 * Check If The Given String Is A Number
	 * 
	 * @param s String To Check
	 * @return True If The String Is A Number, False Otherwise
	 */
	protected boolean isDigit (String s) {
		
		// ArrayList With Valid Digit Character
		ArrayList<Character> numArrayList = new ArrayList<Character> ();				
		numArrayList.add('0');
		numArrayList.add('1');
		numArrayList.add('2');
		numArrayList.add('3');
		numArrayList.add('4');
		numArrayList.add('5');
		numArrayList.add('6');
		numArrayList.add('7');
		numArrayList.add('8'); 
		numArrayList.add('9'); 
		numArrayList.add('.');
		
		
		// Return Value
		boolean returnValue = true;
		
		// Point Counter
		int pointCount = 0;		
	
		// Null String isn't a number
		if (s == null) {
		
			returnValue = false;
		
		// Empty String isn't a number
		} else if (s.length() == 0) {
		
			returnValue = false;
		
		} else {
	
			// A number cannot start with 0 unless it's a decimal (0.x)
			if (s.length() > 1 && s.charAt(0) == '0' && s.charAt(1) != '.') {
			
				returnValue = false;
				
			}
		
			// A number cannot start with .
			if (s.charAt(0) == '.') {
						
				returnValue = false;
							
			}
		
			
			// Check if every character is a number or a point (max one)
			// Or the starting symbol is - (Negative Number)
			for (int i = 0; (i < s.length() && returnValue); i++) {
			
				if (!numArrayList.contains(s.charAt(i))) {
				
					returnValue = false;
				
				}
				
				if ( (i == 0) && (s.charAt(i) == '-') ) {
					
					returnValue = true;
				
				}
			
				if (s.charAt(i) == '.') {
				
					pointCount++;
				
					if (pointCount > 1) {
					
						returnValue = false;
					
					}
				
				}
			
			}	
		
		}	
	
		return returnValue;
	
	}
	
		
	/**
	 * @return the value
	 */
	public String getValue() {
		
		return this.value;
	
	}

	

	/**
	 * @return the type
	 */
	public String getType() {
		
		return this.type;
		
	}
	
	
	
	/**
	 * @return the name
	 */
	public String getName () {
		
		return this.name;
		
	}


	
	/**
	 * HashCode	
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	
	
	/**
	 * Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MathToken other = (MathToken) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
	/**
	 * CompareTo
	 */
	@Override
	public int compareTo(MathToken arg0) {
		
		int compareValue = 0;
		
		try {
			
			if (!this.type.equals(arg0.getType())) {
						
				throw new WrongCompareException ("Token Not Comparable (Different Types)");
			
			}
			
		} catch (WrongCompareException e) {
				
				e.printStackTrace();
			
		}
		
		if (this.type.equals ("operand")) {
			
			compareValue = this.myCompareTo((MathTokenOperand) arg0);
			
		} else if (this.type.equals ("operator")) {
			
			compareValue = this.myCompareTo((MathTokenOperator) arg0);
			
		} else if (this.type.equals("parenthesis")) {
			
			compareValue = this.myCompareTo((MathTokenParenthesis) arg0);
			
		} else if (this.type.equals ("symbol")) { 
			
			compareValue = this.myCompareTo((MathTokenSymbol) arg0);
			
		}
		
		return compareValue;
		
	}

	

	/**
	 * Custom Implementation Of CompareTo For MathTokenOperand
	 */
	protected int myCompareTo(MathTokenOperand arg0) {return 0;}
	
	
	
	/**
	 * Custom Implementation Of CompareTo For MathTokenOperator
	 */
	protected int myCompareTo(MathTokenOperator arg0) {return 0;}
	
	
	
	/**
	 * Custom Implementation Of CompareTo For MathTokenParenthesis
	 */
	protected int myCompareTo(MathTokenParenthesis arg0) {return 0;}
	
	
	/**
	 * Custom Implementation Of CompareTo For MathTokenSymbol
	 */
	protected int myCompareTo(MathTokenSymbol arg0) {return 0;}

	

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "MathToken value=" + value + ", type=" + type + "";
		
	}
	
	
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	public String toStringValue() {
		
		return this.value.toString();
		
	}
	

	
}
