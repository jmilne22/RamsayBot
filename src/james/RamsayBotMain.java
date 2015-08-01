package james;
public class RamsayBotMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RamsayBot bot = new RamsayBot();
		
		// enable debugging output
		bot.setVerbose(true);
		
		// connect to an irc server
		bot.connect("c.ustream.tv");
                
                 // join a channel
		bot.joinChannel("channel");
	}

}
