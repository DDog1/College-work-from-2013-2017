import java.io.*;
import java.util.Stack;
import java. util.Scanner;

public class  BalanceBrackets
{
    private Stack<Character> symbolStack;
	static String temp;//used for the exception
    public void balance(String inputText)
    {
        symbolStack = new Stack<Character>();
        for(int index = 0; index < inputText.length(); index++)//do till file end
        {
            char currentSymbol = inputText.charAt(index);
            switch (currentSymbol)//looks for the symbol
            {
				case '(':
				case '[':
				case '{': symbolStack.push(currentSymbol);//puts in stack
				break;

				case ')':
				case ']':
				case '}':
					if (!symbolStack.isEmpty())//when false
					{
						char symbolStackTop = symbolStack.pop();//gets the top of the list

						if ((currentSymbol == '}' && symbolStackTop != '{')//if the pre bracket does not match next one
						|| (currentSymbol == ')' && symbolStackTop != '(')
						|| (currentSymbol == ']' && symbolStackTop != '['))
						{
							System.out.println("Unmatched closing bracket : " + currentSymbol);//eg {] or [)
							return;
						}
					}
					else
					{
						System.out.println("Extra closing bracket : " + currentSymbol);//eg } on its own
						return;
					}
					break;
				default:
					break;
            }
        }//end of for loop

        if (!symbolStack.isEmpty())//not true print
        {
            System.out.println("Brackets are not balanced");//when stack is not empty
		}
        else
        {
            System.out.println("Brackets are balanced");//when the stack is empty
		}
    }

    public static void main(String[] args)
    {
		try{
			Scanner user_input = new Scanner (System.in);
			String file;

			System.out.println("Filename : ");
			file=user_input.next();//file name
			temp=file;//used for exception

			BufferedReader in = new BufferedReader(new FileReader(file));//read in file
			String input = null;
			StringBuilder sb = new StringBuilder();

			while ((input = in.readLine()) != null)
			{
				sb.append(input);//add line of text to string builder while file does != null
			}

			new BalanceBrackets().balance(sb.toString());//call self and run method balance. pass sb in

		}

		catch(IOException x)
		{
			System.out.println("Can't find the file "+temp);//can't find the file
		}
    }
}