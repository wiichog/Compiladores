import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.lang.StringUtils;
public class main2 {
  public static void main(String[] args)  {
  
    String lineOfText = "if(getip(document.referrer)==\"www.eg.com\" || getip(document.referrer)==\"192.57.42.11\"";

	String[] valuesInQuotes = StringUtils.substringsBetween(lineOfText , "\"", "\"");
	for(int i=0;i<valuesInQuotes.length();i++){
		System.out.println(valuesInQuotes[i]);
	}
	// assertThat(valuesInQuotes[0], is("www.eg.com"));
	// assertThat(valuesInQuotes[1], is("192.57.42.11"));
  
  
  
  }}