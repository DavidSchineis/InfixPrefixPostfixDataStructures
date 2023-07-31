import java.util.*;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Input Infix Expression: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();	
		String[] e = input.split(" "); 
		
		String postExpression = postfix(e);
		String preExpression = prefix(e);
		
		System.out.println("Postfix version: " + postExpression );
		System.out.println("Prefix version: " + preExpression );
		evaluate(postExpression);
			
	}
	
	public static String postfix(String[] elementsInput) {
		ArrayList<String> operator = new ArrayList<>();
		operator.addAll(Arrays.asList("*", "/", "+", "-"));
		
		ArrayList<String> expression = new ArrayList<>();
		
		Stack<String> operatorStack = new Stack<String>();		
		
		for(String element : elementsInput) {
			if (element.startsWith("(")) {
				operatorStack.push(element);
				
			} else if (element.startsWith(")")) {
				if(!operatorStack.isEmpty()) {
					String lastOperator = operatorStack.pop();
					expression.add(lastOperator);
					if(!operatorStack.isEmpty()) {
						String secondToLastOperator = operatorStack.pop();
						expression.add(secondToLastOperator);
					}
				}
				
			} else if (operator.contains(element)) { 
				if(operatorStack.isEmpty()) {
					operatorStack.push(element);
				} else {
					String op= operatorStack.peek();					
					if( PEMDAS(element.charAt(0)) <= PEMDAS(op.charAt(0))) {
						expression.add(operatorStack.pop());					
						operatorStack.push(element);
					} else {
						operatorStack.push(element);
					}
				}
								
			} else { 
				expression.add(element);
			}
		}
		
		while(!operatorStack.isEmpty()) {
			String lastElements = operatorStack.pop();
			expression.add(lastElements);
		}
		
		
		String resultExpression = "";
		for(int i=0; i < expression.size(); i++) {
			if(!expression.get(i).startsWith("(") && !expression.get(i).startsWith(")")) {
				resultExpression = resultExpression + expression.get(i) + " ";				
			}
		}
		return resultExpression;
	}
	
	public static String prefix(String[] elements) {
		List<String> reversedExpression = Arrays.asList(elements);
		Collections.reverse(reversedExpression);	
				
		ArrayList<String> operator = new ArrayList<>();
		operator.addAll(Arrays.asList("*", "/", "+", "-"));
		
			
		Stack<String> expression = new Stack<>();
		
		Stack<String> operatorStack = new Stack<>();
		
		
		for(String element : reversedExpression) {
			
			if (element.startsWith(")") ) {
				operatorStack.push(element);
				
				
			} else if(operator.contains(element)) {
				operatorStack.push(element);
				
				
			} else if(element.startsWith("(")) {
				expression.push(operatorStack.pop());
				if(!operatorStack.isEmpty()) {
					expression.push(operatorStack.pop());
				}
				
				
			} else {
				expression.push(element);
			}
		}
		
		String resultExpression = "";
		int size = expression.getSize();		
		
		for(int i = 0; i < size; i++) {
			String curr = expression.peek();
			if(curr.charAt(0) != ')') {			
				resultExpression = resultExpression + expression.pop() + " ";
			} else {
				expression.pop();
			}
		}
		
		return resultExpression; 
	}
	
	
	public static int PEMDAS(char c) {
		int position = 0;
		
		if(c == '+' || c == '-') {
			position = 1;
		}
		else if(c == '*' || c == '/') {
			position = 2;
		}
		else {
			position = 3;
		}
		
		return position;			
		
	}
	
	public static void evaluate(String s) {	
		ArrayList<String> operator = new ArrayList<>();
		operator.addAll(Arrays.asList("*", "/", "+", "-"));
		String[] elementsInput = s.split(" "); 
		Stack<Double> myStack = new Stack<>();
		double num1 = 0;
		double num2 = 0;
		double operation;
		
		for(String c : elementsInput) {
			
			if(operator.contains(c)) {
				
				num1 = Double.parseDouble(String.valueOf(myStack.pop()));
				num2 = Double.parseDouble(String.valueOf(myStack.pop()));
				
				if(c.charAt(0) == '*') {
					operation = num2 * num1;
				} else if(c.charAt(0) == '/') {
					operation = num2 / num1;
				} else if (c.charAt(0) == '-') {
					operation = num2 - num1;
				} else if(c.charAt(0) == '+') {
					operation = num2 + num1;
				} else operation = 0;
				myStack.push(operation);
			} else if(c == " ") {
				
			} else {
				myStack.push(Double.parseDouble(String.valueOf(c)));
			}			
		}
		double output = myStack.pop();
		System.out.printf("Evaluation: ");
		System.out.printf("%.2f", output);
		}	

}
	
