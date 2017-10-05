import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Mr. Levin and Jason Zhang
 * @version Created by Mr. Levin, modified and expanded by Jason
 */
public class chatbotZhang
{	
	//emotion can alter the bot's responses and can be changed as the conversation progresses
	int emotion = 0;
	
	public int findKeyword(String statement, String keyword, int startPosition)
	{
		//makes sentence lowercase to compare
		String sentence = statement.trim().toLowerCase();
		
		//makes keyword lowercase to compare
		String keyword = keyword.toLowerCase();
		
		//position of the keyword in the sentence if found
		int positionOfWord = sentence.indexOf(keyword, startPosition);
		
		//make sure the goal isn't part of a response
		while(positionOfWord > 0)
		{
			String before = " ";
			String after = " ";
			if(positionOfWord > 0)
			{
				before = sentence.substring(positionOfWord-1, positionOfWord);
			}
			if(positionOfWord + keyword.length() < sentence.length())
			{
				after = sentence.substring(positionOfWord + keyword.length(), positionOfWord + keyword.length() + 1);
			}
			// compare to returns 0 if unicode value is same and a positive/negative number if not
			if((before.compareTo("a") < 0) || (before.compareTo("z") > 0) && (after.compareTo("a") < 0 || (after.compareTo("z") > 0)))
			{
				return positionOfWord;
			}
			
			//letter is found before or after the keyword so look for next keyword
			positionOfWord = sentence.indexOf(keyword, startPosition+1);
		}
	}
}