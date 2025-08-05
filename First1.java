import java.util.*;
class First1
{
	public static void main(String[]args)
	{
		HashMap<Integer,String>h=new HashMap<Integer,String>();
		h.put(111,"sastra");
		h.put(222,"vit");
		h.put(333,"srm");
		Set<Map.Entry<Integer,String>>s=h.entrySet();
		
		for(Map.Entry<Integer,String>m:s)
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
		for(Integer i:s)
		{
			System.out.println(i);
		}
		Set<String>s=h.values();
		for(String n:s)
		{
			System.out.println(n);
		}
		System.out.println(h.get(333));
	}
}
