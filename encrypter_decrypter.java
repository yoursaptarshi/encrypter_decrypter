import java.util.Scanner;


interface encrypter{
String base_encr(String message);
String advance_encr(String message);
}
interface decrypter{
String base_decr(String message);
String advance_decr(String message);
}
class run implements encrypter,decrypter{

    boolean check_pass(int pass)
    {
        if(pass==1001)
        {
            return true;
        }
        else 
        return false;
    }
    public String palindrome_encr(String message)
    {
        String enc_message;
        char[]arr=message.toCharArray();
        int size=message.length();
        char[]ar=new char[size];
        int j=size-1;
        for(int i=0;i<size;i++)
        {
            ar[j]=arr[i];
            j--;
        }
        enc_message=new String(ar);
        return enc_message;
        
    }
    public String base_encr(String message){
        String enc_message;
        char temp;
        
        char[]arr=message.toCharArray();
        for(int i=0;i<message.length();i++)
        {
            if(arr[i]==' ')
            {
                arr[i]='~';
            }
            else{
                temp=arr[i];
                temp++;
                arr[i]=temp;
               
            }
        }
        String temp_message=new String(arr);
        enc_message=palindrome_encr(temp_message);
        return enc_message;
    }
    public String advance_encr(String message){
       String b_enc_msg=base_encr(message);
       String enc_message;
       char temp;
       
       char[]arr=b_enc_msg.toCharArray();
       for(int i=0;i<message.length();i++)
       {
           if(arr[i]=='~')
           {
               arr[i]=' ';
           }
           else{
            if(i%2==0){
               temp=arr[i];
               temp++;
               arr[i]=temp;
            }
            else{
                temp=arr[i];
               temp--;
               arr[i]=temp;
            }
              
           }
       }
       enc_message=new String(arr);

       return enc_message;
    }
    public String palindrome_decr(String message)
    {
        String enc_message;
        char[]arr=message.toCharArray();
        int size=message.length();
        char[]ar=new char[size];
        int j=size-1;
        for(int i=0;i<size;i++)
        {
            ar[j]=arr[i];
            j--;
        }
        enc_message=new String(ar);
        return enc_message;
        
    }
    public String base_decr(String message){
        String dec_message;
        char temp;
        char[]arr=message.toCharArray();
        for(int i=0;i<message.length();i++)
        {
            if(arr[i]=='~')
            {
                arr[i]=' ';
            }
            else{
                temp=arr[i];
                temp--;
                arr[i]=temp;
            }
        }
        String temp_message=new String(arr);
         dec_message=palindrome_decr(temp_message);
        return dec_message;
    }
    public String advance_decr(String message){
        String dec_messag;
        char temp;
        char[]arr=message.toCharArray();
        for(int i=0;i<message.length();i++)
        {
            if(arr[i]==' ')
            {
                arr[i]='~';
            }
            else{
                if(i%2==0){
                    temp=arr[i];
                    temp--;
                    arr[i]=temp;
                 }
                 else{
                     temp=arr[i];
                    temp++;
                    arr[i]=temp;
                 }
            }
        }
       
        String temp_message=new String(arr);
        // System.out.println("Dec msg: "+temp_message);
      dec_messag= base_decr(temp_message);
        return dec_messag;
    }

    
    
}
public class encrypter_decrypter
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        run obj=new run();
        // int pass;
        String message,enc_messag,dec_messag;
        System.out.println("......................Encrypter Decrypter Portal.................");
        // System.out.print("Enter password: ");
        // pass=sc.nextInt();
        // if(obj.check_pass(pass)==true){
        System.out.println("Enter message");
           String messag=sc.nextLine();
        System.out.println("1.Encrypt\t2.Decrypt");
        int choice=sc.nextInt();
        
        switch(choice){
            case 1:
            enc_messag=obj.advance_encr(messag);
            System.out.println("The encrypted message is : "+enc_messag);
            break;
            case 2:
            dec_messag=obj.advance_decr(messag);
            System.out.println("The encrypted message is : "+dec_messag);
            break;
        }
    }
    // else{
    //     System.out.println("sorry ! wrong password");
    // }
        
        
    // }
}