import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public final class Main {

	private static ArrayList<urlInfo> urllist = new ArrayList<urlInfo>();
	public static ArrayList<URL> urls = new ArrayList<URL>();
	public static ArrayList<URL> normalurls = new ArrayList<URL>();
	
	public static final String URL_LIST_FILE = "urls.txt";
	public static void main(String[] args)
	{
	   try {
		readURLs();
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
		e.printStackTrace();
	}
	}
	
	private static void readURLs()throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(URL_LIST_FILE));
		String url = "";
		while (input.hasNextLine()) {
			url = input.next();
			if(Parser.parse(url)){//if the url is valid normalize it
				URL normalURL = new URL();
				URL sourceURL = new URL();
				sourceURL = Parser.getURL();
				normalURL = Normalizer.nomalize(sourceURL);
				urls.add(sourceURL);
				normalurls.add(normalURL);
				urlInfo info = new urlInfo(sourceURL,normalURL,sourceURL.toString(),
						normalURL.toString(),false,false,true);
				urllist.add(info);
			}
			else{
				
				urlInfo info = new urlInfo(null,null,url,
						"",false,false,false);
				urllist.add(info);
				
				/**
				System.out.println("Source:");
				System.out.println(url);
				System.out.println("Valid: false");
				System.out.println("Canonical:");
				System.out.println("N/A The URL is invalid");
				System.out.println("Source unique: ********");
				System.out.println("Canonicalized URL unique: N/A The URL is invalid");
				**/
			}	
		}
		
		input.close();
		print();
	}

	private static void print() {
		for(urlInfo url:  urllist){
			System.out.println(url.toString());
		}
	}	
}
