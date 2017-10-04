
public class ChatBotPhillips {
	public static String startConversation() {
		return "Let me get to know a little about you. Is the person you are interested in a guy or a girl?";
	}
	public static String getResponse(String statement) {
		String oGend = "";
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if(findKeyword(statement, "guy") >= 0|| findKeyword(statement, "man")>= 0||findKeyword(statement, "boy")>=0||findKeyword(statement, "dude")>=0);
		{
			oGend = "male";
		}
		
		return response;
	}
	private static int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	private static int findKeyword(String statement, String goal,
			int startPos)
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
