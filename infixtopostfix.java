import java.util.*;
class Node{
	char data;
	Node next;
	public Node(){}
	public Node(char d)
	{
		this.data = d;
		this.next = null;
	}
}

//author:Santhosh Pandi

class Stack{
	Node head,newnode;
	void push(char d)
	{
		if(head==null)
		{
			newnode = new Node(d);
			head=newnode;
		}
		else{
			newnode = new Node(d);
			newnode.next = head;
			head = newnode;
		}

	}

	char pop()
	{
		char value=' ';
		if(head==null)
		{
			System.out.println("Stack underflow !");
		}
		else{
			value=head.data;
			head=head.next;
		}
		return value;
	}
	char top()
	{
		char value= ' ';
		if(head!=null)
			value = head.data;
		return value;
		
	}

	void display()
	{
		Node t = head;
		while(t!=null)
		{
			System.out.print(" "+t.data);
			t=t.next;
		}
		System.out.println();
	}



}

public class infixtopostfix{
	public static void main(String[] args)
	{
		Stack s = new Stack();
		Scanner c = new Scanner(System.in);
		System.out.println("Enter the Infix expression :\n");
		String infix = c.next();
		String ans="";
		for(int i=0;i<infix.length();i++)
		{
			if(infix.charAt(i)=='('||infix.charAt(i)=='^')
				s.push(infix.charAt(i));
			else if(infix.charAt(i)==')')
			{
				while(s.top()!='(')
				{
					ans=ans+String.valueOf(s.pop());

				}
				s.pop();
			}
			else if(infix.charAt(i)=='+'||infix.charAt(i)=='-')
			{
				while(s.top()=='+'||s.top()=='-'||s.top()=='*'||s.top()=='/')
				{	
					ans=ans+String.valueOf(s.pop());
				}
					s.push(infix.charAt(i));
				
			}
			else if(infix.charAt(i)=='*'||infix.charAt(i)=='/')
			{
				while(s.top()=='*'||s.top()=='/')
				{
					ans=ans+String.valueOf(s.pop());
					//s.push(infix.charAt(i));
				}
					
				s.push(infix.charAt(i));
			}
			else{
				ans=ans+String.valueOf(infix.charAt(i));
			}

		}
		while(s.top()!=' ')
		{
			ans=ans+s.pop();
		}
		System.out.println("\n Infix ==> postfix : "+infix+" ==> "+ans);


	}
}