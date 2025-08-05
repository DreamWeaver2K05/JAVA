package p2;

import p1.*;

import java.util.*;
class Book extends Publication
{
	int page;
	public void get()
	{
		super.get();
		System.out.println("enter the number of pages of the book");
		Scanner s=new Scanner(System.in);
		page=s.nextInt();
	}
	public void put()
	{
		super.put();
		System.out.println("the number of pages of the book are"+page);
	}
}
class Tape extends Publication
{
	float min;
	public void get()
	{
		super.get();
		System.out.println("enter the play time in minutes");
		Scanner s=new Scanner(System.in);
		min=s.nextFloat();
	}
	public void put()
	{
		super.put();
		System.out.println("the play time in minutes are"+min);
	}
}
class Execution
{
	public static void main(String[] args)
	{
		Book b=new Book();
		b.get();
		b.put();
		Tape t=new Tape();
		t.get();
		t.put();
	}
}
	
			