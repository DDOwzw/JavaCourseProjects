///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Program1)
// Files:            (CommandProcessor.java)
// Semester:         (CS367) Spring 2016
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deppler)
// Lab Section:      ()
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (name of your pair programming partner)
// Email:            (email address of your programming partner)
// CS Login:         (partner's login name)
// Lecturer's Name:  (name of your partner's lecturer)
// Lab Section:      (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The most important class. This processes all the commands issued by the users
 *
 * @author jmishra,zhongwei
 */
/**
 * In this class, we make several different movement that user may call for the
 * method to do so.
 * To be more special, Login and logout method are defined here.
 * Moreover, send message, search, add friend, remove friend, remove friend from
 * broadcastList, add friend to broadcastList, and remove broadcastList method 
 * are defined here.
 * The processCommand method is used to read and deal with data that getting
 * from the Command-line argument.
 * 
 * @author zhongwei
 */
public class CommandProcessor
{

	// session added for saving some typing overhead and slight 
	// performance benefit
	private static final Config CONFIG = Config.getInstance();

	/**
	 * A method to do login. Should show LOGIN_PROMPT for the nickname,
	 * PASSWORD_PROMPT for the password. Says SUCCESSFULLY_LOGGED_IN is
	 * successfully logs in someone. Must set the logged in user in the Config
	 * instance here
	 *
	 * @throws WhatsAppException if the credentials supplied by the user are
	 * invalid, throw this exception with INVALID_CREDENTIALS as the message
	 */
	public static void doLogin() throws WhatsAppException
	{
		CONFIG.getConsoleOutput().printf(Config.LOGIN_PROMPT);
		String nickname = CONFIG.getConsoleInput().nextLine();
		CONFIG.getConsoleOutput().printf(Config.PASSWORD_PROMPT);
		String password = CONFIG.getConsoleInput().nextLine();

		Iterator<User> userIterator = CONFIG.getAllUsers().iterator();
		while (userIterator.hasNext())
		{
			User user = userIterator.next();
			if (user.getNickname().equals(nickname) && user.getPassword()
					.equals(password))
			{
				CONFIG.setCurrentUser(user);
				CONFIG.getConsoleOutput().
				printf(Config.SUCCESSFULLY_LOGGED_IN);
				return;
			}

		}
		throw new WhatsAppException(String.
				format(Config.INVALID_CREDENTIALS));
	}

	/**
	 * A method to logout the user. Should print SUCCESSFULLY_LOGGED_OUT when
	 * done.
	 */
	public static void doLogout()
	{
		// set the currentUser to null
		CONFIG.setCurrentUser(null);
		CONFIG.getConsoleOutput().
		// print the demo.
		printf(Config.SUCCESSFULLY_LOGGED_OUT);
	}

	/**
	 * A method to send a message. Handles both one to one and broadcasts
	 * MESSAGE_SENT_SUCCESSFULLY if sent successfully.
	 *
	 * @param nickname - can be a friend or broadcast list nickname
	 * @param message - message to send
	 * @throws WhatsAppRuntimeException simply pass this untouched from the
	 * constructor of the Message class
	 * @throws WhatsAppException throw this with one of CANT_SEND_YOURSELF,
	 * NICKNAME_DOES_NOT_EXIST messages
	 */
	public static void sendMessage(String nickname, String message)
			throws WhatsAppRuntimeException, WhatsAppException
	{
		// the name of the user who sent the message
		String fromNickname = CONFIG.getCurrentUser().getNickname();
		// the name of the user who would receive the message
		String toNickname = null;
		// the name of the broadcast list which may access the message
		String broadcastNickname = null;
		// the time when the message get sent
		Date sentTime = new Date();
		// whether the message has been read
		boolean read = false;
		//if the user is sending himself the message
		if(CONFIG.getCurrentUser().getNickname().equals(nickname)){
			throw new WhatsAppRuntimeException(Config.CANT_SEND_YOURSELF);
		}
		//if the user is sending his friend the message
		if(CONFIG.getCurrentUser().isFriend(nickname)){
			toNickname = nickname;
		}
		//else if he is sending to a group
		else if(CONFIG.getCurrentUser().isBroadcastList(nickname)){
			broadcastNickname = nickname;
		}else{
			// else throw a exception
			throw new WhatsAppRuntimeException(String.format(
					Config.NICKNAME_DOES_NOT_EXIST, nickname));
		}
		// a new object message type which will be sent soon
		Message objMessage = new Message(fromNickname,toNickname,
				broadcastNickname,sentTime,message,read);
		//if it will be sent to a friend
		if(broadcastNickname == null){
			Helper.getUserFromNickname(CONFIG.getAllUsers(), 
					fromNickname).getMessages().add(objMessage);
			Helper.getUserFromNickname(CONFIG.getAllUsers(),
					toNickname).getMessages().add(objMessage);
			CONFIG.getConsoleOutput().printf(Config.MESSAGE_SENT_SUCCESSFULLY);
		}else if(toNickname == null){
			//else if it will be sent to a group
			Helper.getUserFromNickname(Config.getInstance().getAllUsers(),
					fromNickname).getMessages().add(objMessage);

			Iterator<String> memberIterator = 
					Helper.getBroadcastListFromNickname(
							Helper.getUserFromNickname(CONFIG.getAllUsers(), 
									fromNickname).getBroadcastLists(), 
							broadcastNickname).getMembers().iterator();
			while (memberIterator.hasNext()){
				String member = memberIterator.next();
				Message receivedMessage = new Message(fromNickname, 
						member, null, sentTime, message, read);
				Helper.getUserFromNickname(CONFIG.getAllUsers(), member).
				getMessages().add(receivedMessage);
			}
			CONFIG.getConsoleOutput().printf(Config.MESSAGE_SENT_SUCCESSFULLY);
		}

	}

	/**
	 * Displays messages from the message list of the user logged in. Prints the
	 * messages in the format specified by MESSAGE_FORMAT. Says NO_MESSAGES if
	 * no messages can be displayed at the present time
	 *
	 * @param nickname - send a null in this if you want to display messages
	 * related to everyone. This can be a broadcast nickname also.
	 * @param enforceUnread - send true if you want to display only unread
	 * messages.
	 */
	public static void readMessage(String nickname, boolean enforceUnread)
	{
		//if there is no message to read
		if(CONFIG.getCurrentUser().getMessages().isEmpty()){
			CONFIG.getConsoleOutput().printf(Config.NO_MESSAGES);
		}
		// a counter that counts how many message user will read
		int count = 0;
		// read the message
		for(int i = 0; i < CONFIG.getCurrentUser().getMessages().size(); i++){
			Message temp = CONFIG.getCurrentUser().getMessages().get(i);
			if(enforceUnread){
				if(!temp.isRead()){
					if(nickname == null){
						CONFIG.getConsoleOutput().printf(Config.MESSAGE_FORMAT,
								temp.getFromNickname(),
								temp.getToNickname(),
								temp.getMessage(),
								temp.getSentTime()	);
						count++;
						temp.setRead(true);
					}else{
						if(temp.getFromNickname().equals(nickname)){
							CONFIG.getConsoleOutput().printf(
									Config.MESSAGE_FORMAT,
									temp.getFromNickname(),
									temp.getToNickname(),
									temp.getMessage(),
									temp.getSentTime()	);
							count++;
							temp.setRead(true);
						}
					}
				}

			}else{
				if(nickname == null){
					CONFIG.getConsoleOutput().printf(Config.MESSAGE_FORMAT,
							temp.getFromNickname(),
							temp.getToNickname(),
							temp.getMessage(),
							temp.getSentTime()	);
					count++;
					temp.setRead(true);
				}else{
					if(temp.getFromNickname().equals(nickname)){
						CONFIG.getConsoleOutput().printf(Config.MESSAGE_FORMAT,
								temp.getFromNickname(),
								temp.getToNickname(),
								temp.getMessage(),
								temp.getSentTime()	);
						count++;
						temp.setRead(true);
					}
				}
			}
		}
		if(count == 0){
			CONFIG.getConsoleOutput().printf(Config.NO_MESSAGES);
		}


	}

	/**
	 * Method to do a user search. Does a case insensitive "contains" search on
	 * either first name or last name. Displays user information as specified by
	 * the USER_DISPLAY_FOR_SEARCH format. Says NO_RESULTS_FOUND is nothing
	 * found.
	 *
	 * @param word - word to search for
	 * @param searchByFirstName - true if searching for first name. false for
	 * last name
	 */
	public static void search(String word, boolean searchByFirstName)
	{
		// declare two different key words that we will use
		String no = "no";
		String yes = "yes";
		// the variable that we use to decide which key word we will use soon
		String yesOrNo = no;
		// set all word into lower case
		word = word.toLowerCase();
		// the user type variable that we will find soon
		User userFound = null;
		// if we search by first name
		if(searchByFirstName){
			for(int i = 0; i <CONFIG.getAllUsers().size(); i++){
				if(CONFIG.getAllUsers().get(i).getFirstName().contains(word)){
					userFound = CONFIG.getAllUsers().get(i);
					if(CONFIG.getCurrentUser().
							isFriend(userFound.getNickname())){
						yesOrNo = yes;
					}else{
						yesOrNo = no;
					}
					CONFIG.getConsoleOutput().printf(
							Config.USER_DISPLAY_FOR_SEARCH,
							userFound.getLastName(),
							userFound.getFirstName(),
							userFound.getNickname(),
							yesOrNo);
				}
			}
			// if we search by last name
		}else{
			for(int i = 0; i <CONFIG.getAllUsers().size(); i++){
				if(CONFIG.getAllUsers().get(i).getLastName().contains(word)){
					userFound = CONFIG.getAllUsers().get(i);
					if(CONFIG.getCurrentUser().isFriend(
							userFound.getNickname())){
						yesOrNo = yes;
					}else{
						yesOrNo = no;
					}
					CONFIG.getConsoleOutput().printf(
							Config.USER_DISPLAY_FOR_SEARCH,
							userFound.getLastName(),
							userFound.getFirstName(),
							userFound.getNickname(),
							yesOrNo);
				}
			}
		}
		//if we found nothing
		if(userFound == null){
			CONFIG.getConsoleOutput().printf(Config.NO_RESULTS_FOUND);
		}

	}

	/**
	 * Adds a new friend. Says SUCCESSFULLY_ADDED if added. Hint: use the
	 * addFriend method of the User class.
	 *
	 * @param nickname - nickname of the user to add as a friend
	 * @throws WhatsAppException simply pass the exception thrown from the
	 * addFriend method of the User class
	 */
	public static void addFriend(String nickname) throws WhatsAppException
	{
		//add a friend to the current user
		CONFIG.getCurrentUser().addFriend(nickname);
		CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_ADDED);
	}

	/**
	 * removes an existing friend. Says NOT_A_FRIEND if not a friend to start
	 * with, SUCCESSFULLY_REMOVED if removed. Additionally removes the friend
	 * from any broadcast list she is a part of
	 *
	 * @param nickname nickname of the user to remove from the friend list
	 * @throws WhatsAppException simply pass the exception from the removeFriend
	 * method of the User class
	 */
	public static void removeFriend(String nickname) throws WhatsAppException
	{
		//remove a friend
		CONFIG.getCurrentUser().removeFriend(nickname);
		CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_REMOVED);
	}

	/**
	 * adds a friend to a broadcast list. Says SUCCESSFULLY_ADDED if added
	 *
	 * @param friendNickname the nickname of the friend to add to the list
	 * @param bcastNickname the nickname of the list to add the friend to
	 * @throws WhatsAppException throws a new instance of this exception with
	 * one of NOT_A_FRIEND (if friendNickname is not a friend),
	 * BCAST_LIST_DOES_NOT_EXIST (if the broadcast list does not exist),
	 * ALREADY_PRESENT (if the friend is already a member of the list),
	 * CANT_ADD_YOURSELF_TO_BCAST (if attempting to add the user to one of his
	 * own lists
	 */
	public static void addFriendToBcast(String friendNickname,
			String bcastNickname) throws WhatsAppException
	{// add a friend to a current broadcast list
		if (friendNickname.equals(CONFIG.getCurrentUser().getNickname()))
		{
			throw new WhatsAppException(Config.CANT_ADD_YOURSELF_TO_BCAST);
		}
		if (!CONFIG.getCurrentUser().isFriend(friendNickname))
		{
			throw new WhatsAppException(Config.NOT_A_FRIEND);
		}
		if (!CONFIG.getCurrentUser().isBroadcastList(bcastNickname))
		{
			throw new WhatsAppException(String.
					format(Config.BCAST_LIST_DOES_NOT_EXIST, bcastNickname));
		}
		if (CONFIG.getCurrentUser().
				isMemberOfBroadcastList(friendNickname, bcastNickname))
		{
			throw new WhatsAppException(Config.ALREADY_PRESENT);
		}
		Helper.getBroadcastListFromNickname(CONFIG.getCurrentUser().
				getBroadcastLists(), bcastNickname).getMembers().
		add(friendNickname);
		CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_ADDED);
	}

	/**
	 * removes a friend from a broadcast list. Says SUCCESSFULLY_REMOVED if
	 * removed
	 *
	 * @param friendNickname the friend nickname to remove from the list
	 * @param bcastNickname the nickname of the list from which to remove the
	 * friend
	 * @throws WhatsAppException throw a new instance of this with one of these
	 * messages: NOT_A_FRIEND (if friendNickname is not a friend),
	 * BCAST_LIST_DOES_NOT_EXIST (if the broadcast list does not exist),
	 * NOT_PART_OF_BCAST_LIST (if the friend is not a part of the list)
	 */
	public static void removeFriendFromBcast(String friendNickname,
			String bcastNickname) throws WhatsAppException
	{//remove a friend from a current broadcast list

		if(!CONFIG.getCurrentUser().isFriend(friendNickname)){
			throw new WhatsAppException(Config.NOT_A_FRIEND);
		}
		BroadcastList broadcastList = Helper.getBroadcastListFromNickname
				(CONFIG.getCurrentUser().getBroadcastLists(), bcastNickname);
		if(broadcastList == null){
			throw new WhatsAppException(Config.BCAST_LIST_DOES_NOT_EXIST);
		}
		User friendToRemove = 
				Helper.getUserFromNickname(CONFIG.getAllUsers(),friendNickname);
		if(!broadcastList.getMembers().contains(friendToRemove)){
			throw new WhatsAppException(Config.NOT_PART_OF_BCAST_LIST);
		}
		List<String> members = broadcastList.getMembers();
		members.remove(friendNickname);
		broadcastList.setMembers(members);
		CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_REMOVED);

	}

	/**
	 * A method to remove a broadcast list. Says BCAST_LIST_DOES_NOT_EXIST if
	 * there is no such list to begin with and SUCCESSFULLY_REMOVED if removed.
	 * Hint: use the removeBroadcastList method of the User class
	 *
	 * @param nickname the nickname of the broadcast list which is to be removed
	 * from the currently logged in user
	 * @throws WhatsAppException Simply pass the exception returned from the
	 * removeBroadcastList method of the User class
	 */
	public static void removeBroadcastcast(String nickname) 
			throws WhatsAppException{
		//remove the entire broadcast list(not all lists, only one each time)
		BroadcastList broadcastList = Helper.getBroadcastListFromNickname
				(CONFIG.getCurrentUser().getBroadcastLists(), nickname);
		if(!CONFIG.getCurrentUser().getBroadcastLists().contains(broadcastList))
			throw new WhatsAppException(Config.BCAST_LIST_DOES_NOT_EXIST);
		CONFIG.getCurrentUser().removeBroadcastList(nickname);
		CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_REMOVED);
	}

	/**
	 * Processes commands issued by the logged in user. Says INVALID_COMMAND for
	 * anything not conforming to the syntax. This basically uses the rest of
	 * the methods in this class. These methods throw either or both an instance
	 * of WhatsAppException/WhatsAppRuntimeException. You ought to catch such
	 * exceptions here and print the messages in them. Note that this method
	 * does not throw any exceptions. Handle all exceptions by catch them here!
	 *
	 * @param command the command string issued by the user
	 */
	public static void processCommand(String command)
	{
		try
		{
			switch (command.split(":")[0])
			{
			case "logout":
				doLogout();
				break;
			case "send message":
				String nickname = command.
				substring(command.indexOf(":") + 1, command.
						indexOf(",")).trim();
				String message = command.
						substring(command.indexOf("\"") + 1, command.trim().
								length() - 1); // CORRECTED: Added - 1
				sendMessage(nickname, message);
				break;
			case "read messages unread from":
				nickname = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim();
				readMessage(nickname, true);
				break;
			case "read messages all from":
				nickname = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim();
				readMessage(nickname, false);
				break;
			case "read messages all":
				readMessage(null, false);
				break;
			case "read messages unread":
				readMessage(null, true);
				break;
			case "search fn":
				String word = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim();
				search(word, true);
				break;
			case "search ln":
				word = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim();
				search(word, false);
				break;
			case "add friend":
				nickname = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim();
				addFriend(nickname);
				break;
			case "remove friend":
				nickname = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim();
				removeFriend(nickname);
				break;
			case "add to bcast":
				String nickname0 = command.
				substring(command.indexOf(":") + 1, command.
						indexOf(",")).
				trim();
				String nickname1 = command.
						substring(command.indexOf(",") + 1, command.trim().
								length()).
						trim();
				addFriendToBcast(nickname0, nickname1);
				break;
			case "remove from bcast":
				nickname0 = command.
				substring(command.indexOf(":") + 1, command.
						indexOf(",")).
				trim();
				nickname1 = command.
						substring(command.indexOf(",") + 1, command.trim().
								length()).
						trim();
				removeFriendFromBcast(nickname0, nickname1);
				break;
			case "remove bcast":
				nickname = command.
				substring(command.indexOf(":") + 1, command.trim().
						length()).trim(); // CORRECTED: Added trim()
				removeBroadcastcast(nickname);
				break;
			default:
				CONFIG.getConsoleOutput().
				printf(Config.INVALID_COMMAND);
			}
		} catch (StringIndexOutOfBoundsException ex)
		{
			CONFIG.getConsoleOutput().
			printf(Config.INVALID_COMMAND);
		} catch (WhatsAppException | WhatsAppRuntimeException ex)
		{
			CONFIG.getConsoleOutput().printf(ex.getMessage());
		}
	}

}
