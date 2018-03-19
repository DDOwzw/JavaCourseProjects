///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Program1)
// Files:            (Helper.java)
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * A few helper static methods
 *
 * @author jmishra,zhongwei
 */
/**
 * The Helper class contains methods to return the user, broadcastList, and
 * whether a user is in the global user list.
 * 
 *
 * @author zhongwei
 */
public class Helper
{

	/**
	 * Given a nickname as a String return the User object from the List of
	 * Users
	 *
	 * @param users the list of users from which a user will be returned
	 * @param nickname the nickname of the user to be returned
	 * @return the USer object whose nickname is nickname and this object is
	 * searched from the users List
	 */
	public static User getUserFromNickname(List<User> users, String nickname)
	{
		// search the whole user list and get the correct user
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getNickname().equals(nickname)){
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * Given a nickname as a String return the BroadcastList from the List of
	 * BroadcastLists
	 *
	 * @param lists the list of lists from which one list object is to be
	 * returned
	 * @param nickname the nickname of the broadcast list to be returned
	 * @return the BroadcastList object whose nickname is nickname. This object
	 * is searched from the lists List
	 */
	public static BroadcastList getBroadcastListFromNickname(
			List<BroadcastList> lists, String nickname)
	{
		// search the whole list of broadcast lists
		for(int i = 0; i < lists.size(); i++){
			if(lists.get(i).getNickname().equals(nickname)){
				return lists.get(i);
			}
		}
		return null;
	}

	/**
	 * Given a nickname determine whether a User exists globally with that
	 * nickname
	 *
	 * @param nickname the nickname to check for
	 * @return true if a user exists globally with the provided nickname
	 */
	public static boolean isExistingGlobalContact(String nickname)
	{
		// whether the user is a real user in the database
		for(int i = 0; i < Config.getInstance().getAllUsers().size(); i++){
			if(Config.getInstance().getAllUsers().get(i).getNickname()
					.equals(nickname)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Populate data from the file with the given path
	 *
	 * @param filename the path to the input file
	 * @throws FileNotFoundException this is thrown if the file is not found
	 * @throws IOException this is thrown if some error occurs while reading the
	 * input file
	 * @throws WhatsAppRuntimeException this is thrown if any invalid data is
	 * used to construct any of the WhatsApp objects or a line is encountered
	 * that does not begin with any of the four words mentioned in the
	 * specification
	 * @throws java.text.ParseException this exception is thrown if some issue
	 * occurs while parsing the date string
	 */
	public static void populateData(String filename) 
			throws FileNotFoundException, IOException, 
			WhatsAppRuntimeException, ParseException
	{
		Scanner scanner = new Scanner(new File(filename));        
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] parts = line.split(",");
			switch (parts[0])
			{
			case "user":
				User user = new User(parts[1], parts[2], parts[3], parts[4], 
						new ArrayList<>(), new ArrayList<>(), 
						new ArrayList<>());
				Config.getInstance().getAllUsers().add(user);
				break;
			case "flist":
				user = getUserFromNickname(Config.getInstance().
						getAllUsers(), parts[1]);
				for (int i = 2; i < parts.length; ++i)
				{
					user.getFriends().add(getUserFromNickname(Config.
							getInstance().getAllUsers(), parts[i]));
				}
				break;
			case "bcast":
				user = getUserFromNickname(Config.getInstance().
						getAllUsers(), parts[1]);
				BroadcastList newList = new BroadcastList(parts[3], 
						new ArrayList<>());
				for (int i = 4; i < parts.length; ++i)
				{
					newList.getMembers().add(parts[i]);
				}
				user.getBroadcastLists().add(newList);
				break;
			case "message":
				SimpleDateFormat sdf = 
				new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				if ((getUserFromNickname(Config.
						getInstance().getAllUsers(), parts[1])).
						isBroadcastList(parts[2]))
				{
					Message sentMessage = new Message(
							parts[1], null, parts[2], sdf.
							parse(parts[3]), parts[4].
							substring(1, parts[4].length() - 1), true);
					getUserFromNickname(Config.getInstance().getAllUsers(), 
							parts[1]).
					getMessages().add(sentMessage);
					Iterator<String> memberIterator = 
							getBroadcastListFromNickname(
									getUserFromNickname(Config.
											getInstance().getAllUsers(), parts[1]).
									getBroadcastLists(), parts[2]).getMembers().
							iterator();
					for (int i = 5; i < parts.length; ++i)
					{
						String member = memberIterator.next();
						Message receivedMessage = new Message(parts[1], 
								member, null, sdf.
								parse(parts[3]), parts[4].
								substring(1, parts[4].length() - 1), parts[i].
								equals("read"));
						getUserFromNickname(Config.getInstance().
								getAllUsers(), member).
						getMessages().add(receivedMessage);
					}
				} else
				{
					Message sentMessage = new Message(parts[1], 
							parts[2], null, sdf.parse(parts[3]), parts[4].
							substring(1, parts[4].length() - 1), true);
					getUserFromNickname(Config.getInstance().getAllUsers(), 
							parts[1]).getMessages().add(sentMessage);
					Message receivedMessage = new Message(parts[1], parts[2],
							null, sdf.parse(parts[3]), parts[4].
							substring(1, parts[4].length() - 1), parts[5].
							equals("read"));
					getUserFromNickname(Config.getInstance().getAllUsers(),
							parts[2]).getMessages().add(receivedMessage);
				}
				break;
			default:
				throw new WhatsAppRuntimeException();
			}
		}
	}

}
