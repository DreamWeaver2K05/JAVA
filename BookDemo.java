

class Book 
{
    String BKName,BKAuthor;
    int BKId;
    Book()
    {
        BKAuthor=BKName=null;
        BKId=0;
    }
    Book(String x,int y,String z)
    {
        BKName=x;
        BKId=y;
        BKAuthor=z;
    }
    void update(String a,int b,String c)
    {
        BKName=a;
        BKId=b;
        BKAuthor=c;
    }
    void display()
    {
        System.out.println("name of the book:"+BKName);
        System.out.println("book id:"+BKId);
        System.out.println("author of the book:"+BKAuthor);
    }
}
class BookDemo
{
    public static void main(String[]args)
    {
        Book b1=new Book();
        Book b2=new Book("harry potter",31,"J.K.rowling");
        b2.display();
        b2.update("The Monk Who Sold His Ferrari",24,"robin sharma");
        b2.display();
    }
}