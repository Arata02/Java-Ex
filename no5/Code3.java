package no5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code3 {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			StringBuffer sb = new StringBuffer();
			int c;
			while ((c = br.read()) != -1) {
				sb.append((char) c);
			}

			String[] words = molding(sb.toString());

			System.out.println(String.join("", words));

			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("ファイルが存在しません");
			System.out.println(e);
			return;
		}catch(IOException e) {
			System.out.println("エラー");
			System.out.println(e);
			return;
		}
	}

	public static String removeStruct(String text){
	    return text.replaceAll("struct [^\\(\\)]+\\{[^\\}]+\\} *;", "");
	}

	public static String removeComment(String text) {
		return text.replaceAll("/\\*[^/\\*]*\\*/", "");
	}

	public static String[] snipper(String text){
		text = removeStruct(text);
		//func5用
		//text = removeComment(text);
		ArrayList<String> result = new ArrayList<>();
		Pattern pattern = Pattern.compile("[^\\(\\)\\{\\}]*[\\(\\)\\{\\}]");
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			String sentence = matcher.group(0);
			result.add(sentence.substring(0, sentence.length()-1));
			result.add("" + sentence.charAt(sentence.length()-1));
		}
		return result.toArray(new String[result.size()]);
	}

	public static String[] molding(String text) {
		String[] words = snipper(text);
		int indent = 0;
		ArrayList<String> result = new ArrayList<>();
		for(String word: words){
			if("}".equals(word)){
				indent--;
				continue;
			}else if("{".equals(word)){
				indent++;
				continue;
			}else if(indent>=1){
				continue;
			}

			for(String w: word.split("\\r\\n")){
				//System.out.println(w);
				if(w.isEmpty()){
					continue;
				}
				boolean flag=false;
				for(Token t: Token.values()){
					if(t.checkMatch(w)){
						flag=true;
						break;
					}
				}
				if(flag)continue;
				if(")".equals(w)) {
					w = ");\n";
				}
				result.add(w.replaceAll("^[ \\t]+", ""));
			}
		}
		return result.toArray(new String[result.size()]);
	}
}

enum Token{

	TK_INCLUDE ("#include"),
	TK_SEMI (";"),
	OPEN_COMMENT ("\\/\\*"),
	CLOSE_COMMENT ("\\*\\/")
	;

	private final Pattern pattern;

	Token(String regex){
		pattern = Pattern.compile("^" + regex);
	}

	boolean checkMatch(String s) {
		Matcher m = pattern.matcher(s);
		return m.find();
	}

}