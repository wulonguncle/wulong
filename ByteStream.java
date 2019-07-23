package ch10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ByteStream 
{
	public static void main (String args[])throws Exception
	{
		File f = new File("D:\\out1.txt");
		if(!f.exists())
		{
			try
			{
				f.createNewFile();
			}
			catch(Exception e)
			{
				System.out.println("File does not exist");
			}
		}
		try(FileOutputStream output = new FileOutputStream(f);)
		{
			byte[] b = new byte[100];
			for(int i = 1;i<101;i++)
			{
				b[i-1] = (byte)i;
			}
			output.write(b);
		}
		try(FileInputStream input = new FileInputStream(f);)
		{
			int number;
			while((number = input.read()) != -1)
			{
				System.out.print(number);
			}
		}
	}
}
