import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import sun.reflect.generics.tree.Tree;

public class Main
{
	public static BinaryTree tree = new BinaryTree();	
	public static ArrayList<String> reservedWordTable = new ArrayList<String>();
	public static ArrayList<String> specialSymbolTable = new ArrayList<String>();
	
	//String array list ex. ( [ "(" , "Special Symbol" ] , [...ect  ])
	public static ArrayList<String[]> tokenList = new ArrayList<String[]>();

	
	//FOR SYMBOLIC TABLES
	public Deque<ArrayList> stack = new ArrayDeque<ArrayList>();
	
	public static void main(String[] args)
	{
		initialize();
		File inputFile = new File("input.lisp");
		//Scanner sc = new Scanner(new File("input.lisp"));
		
		try
		{
			Scanner sc = new Scanner(inputFile);
			while(sc.hasNextLine())
				myScanner(sc.nextLine());
			
			//for each token, parse it and add to tree
			int i = 0;
			for (String [] arr : tokenList)
			{
				if(arr[1] == "I")
				{
					tree.insert(i, arr);
					i++;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Input file not found!");
			System.exit(0);
		}
		
		
		tree.print();
		
		
		
	}
	
	private static void initialize()
	{
		reservedWordTable.add("define");
		reservedWordTable.add("lambda");
		reservedWordTable.add("let*");
		reservedWordTable.add("cond");
		reservedWordTable.add("if");
		reservedWordTable.add("else");
		reservedWordTable.add("not");
		reservedWordTable.add("map");
		reservedWordTable.add("car");
		reservedWordTable.add("cdr");
		reservedWordTable.add("cons");
		reservedWordTable.add("upto");
		reservedWordTable.add("null?");
		reservedWordTable.add("member?");
		specialSymbolTable.add("(");
		specialSymbolTable.add("(");
	}

	public static ArrayList<String> myScanner(String line)
	{
		String token = "";
		
		ArrayList<String> al = new ArrayList<String>();
		
		int length = line.length();
		for(int i = 0; i < length; i++)
		{
			char c = line.charAt(i);

			if(c == ';')
			{
				if(token != "")
				{
					al.add(token);
					addToken(token);
				}
				i = line.length();
				continue;
			}
			
			if(c == '(' || c == ')')
			{
				if(token == "")
				{
					token += c;
					al.add(token);
				}
				else
				{
					al.add(token);
					addToken(token);
					token = "" + c;
					al.add(token);
				}
				
				addToken(token);
				token = "";
				continue;
			}
				
			if(c == ' ' || i == length - 1)
			{
				if(token != "")
				{
					if(c != ' ')
						token += c;
					al.add(token);
					addToken(token);
					token = "";
				}
			}
			else
				token += c;
		}

		return al;
	}

	//puts token and their types in an Sting []
	//and adds it to token List
	// R for resrved words, I for Identifier, N for Number, S for Special Symbols
	public static void addToken(String token)
	{
		String [] temp = new String [2];
		char firstChar = token.charAt(0);
	
		temp[0] = token;
		
		if(reservedWordTable.contains(token))
		{
			//System.out.print("\t=> (Reserved Word)\n");
			temp[1] = "R";
		}	
		else if(Character.isLetter(firstChar))
		{
			//System.out.print("\t=> (Identifier)\n");
			temp[1] = "I";
		}
		else if(Character.isDigit(firstChar))
		{
			//System.out.print("\t=> (Number)\n");
			temp[1] = "N";
		}
		else
		{
			//System.out.print("\t=> (Special Symbol)\n");
			temp[1] = "S";
		}
		
		tokenList.add(temp);
		return;
	}
	
	
	//use a token output by scanner and parse to tree
	//also adds to symbol table
	public static String parser(String token)
	{
		ArrayList<String> arr = new ArrayList<String>();
		
		//if not a reserved word
		if(!token.contains("Reserved Word") && token.contains("Identifier"))
		{
			return "HEY";
		}
		return token;
		
		
		//return arr;
	}

}