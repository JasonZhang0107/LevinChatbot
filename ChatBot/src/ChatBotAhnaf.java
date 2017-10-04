
public class ChatBotAhnaf {
	int deepthoughts = 0;
	public String startDiscussion()
	{
		return "What do you want to talk about today ?";
	}
	public String startResponse(String statement)
	{
		String response = "";
		if(statement.length() == 0)
		{
			response = "We can talk about space,time, reality. Whatever you feel like";
		}
		else if(findKeyword(statement,"space") >= 0)
		{
			response = spaceConversation(statement);
		}
	}
	public String spaceConversation(String statement)
	{
		response = serh;
	}
	
	private int findKeyword(String statement, String goal,int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	

}
