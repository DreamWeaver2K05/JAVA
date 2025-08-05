/* Using a Map write a program to map the details of an employee with the
hobbies of the employee. The program should take the details of the
employee and his/her hobbies as input and then store them as key/value pair
in the map. Once the addition of details is complete, then the user should be
able to list down all the employees, along with their hobbies and also should
be able to view a particular employee&#39;s (by giving employee id as input),
his/her details and his/her hobbies . Also the user should be able to delete an
employee based on the id of the employee.*/
import java.util.*;
class Employee
{
	int empid;
	String name;
	String hob;
	Employee(int a,String b,String c)
	{
		empid=a;
		name=b;
		hob=c;
	}
	public String toString()
	{
		return "   employee id:"+empid+"  employee name:"+name+"  hobby:"+hob;
	}
	public static void main(String[]args)
	{
		HashMap<Integer,Employee>hm=new HashMap<Integer,Employee>();
		hm.put(12,new Employee(12,"dharun","swim"));
		hm.put(23,new Employee(23,"hari","read"));
		hm.put(34,new Employee(34,"vijay","dance"));
		System.out.println(hm.get(34));
		Set<Map.Entry<Integer,Employee>>s=hm.entrySet();
		for(Map.Entry<Integer,Employee>m:s)
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		hm.remove(12);
		System.out.println("after removing");
		for(Map.Entry<Integer,Employee>m:s)
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}
}