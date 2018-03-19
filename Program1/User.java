///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Program1)
// Files:            (User.java)
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
import java.util.Iterator;
import java.util.List;

/**
 * This is the user class which captures profile information of a single user
 *
 * @author jmishra,zhongwei
 */
/**
 * The user class contains the type called User. All the related methods are
 * in this class for other class to call for.
 *
 * @author zhongwei
 */
public class User
{
	// class fields are here
	// the last name of the user
	private String lastName;
	// the first name of the user
	private String firstName;
	// the nick name of the user(also login name)
	private String nickname;
	// the password of the user
	private String password;
	// list of the messages that related to the user
	private List<Message> messages;
	// list of fiends of the user
	private List<User> friends;
	// list of the broadcast list that the user has
	private List<BroadcastList> broadcastLists;

	/**
	 * A constructor to instantiate this class. None of the Strings passed to
	 * this can be null or empty. Also any of the lists passed to this
	 * constructor cannot be null. You can create empty ArrayLists and pass it
	 * here. For any of the above mentioned validation issues, you must throw a
	 * WhatsAppRuntimeException with the CANT_BE_EMPTY_OR_NULL message
	 *
	 * @param lastName last name of the user
	 * @param firstName first name of the user
	 * @param nickname nickname of the user. This must be unique across all
	 * users
	 * @param password password of the user
	 * @param messages list of messages in the user's message list. This
	 * includes both messages sent and received by the user.
	 * @param friends list of users who are friends of this user
	 * @param broadcastLists list of broadcast lists that this user owns
	 * @throws WhatsAppRuntimeException if any of the strings passed to this
	 * constructor are either null or empty or any of the lists passed to this
	 * are null (they can be empty) throw an instance of this exception with the
	 * message CANT_BE_EMPTY_OR_NULL
	 */
	public User(String lastName, String firstName, String nickname,
			String password, List<Message> messages, List<User> friends,
			List<BroadcastList> broadcastLists) throws WhatsAppRuntimeException
	{//constructor
		if ((lastName == null) || (lastName.isEmpty()) || 
				(firstName == null) || (firstName.isEmpty()) || 
				(nickname == null) || (nickname.isEmpty()) || 
				(password == null) || (password.isEmpty()) || 
				(messages == null) || (friends == null) || 
				(broadcastLists == null)){
			throw new WhatsAppRuntimeException(Config.CANT_BE_EMPTY_OR_NULL);
		}
		this.lastName = lastName;
		this.firstName = firstName;
		this.nickname = nickname;
		this.password = password;
		this.messages = messages;
		this.friends = friends;
		this.broadcastLists = broadcastLists;
	}

	/**
	 * a getter to return the last name
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * A setter for the last name
	 *
	 * @param lastName - the last name of a user
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * A getter for the first name
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * A setter for the first name
	 *
	 * @param firstName the first name of a user
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * A getter for the nickname
	 *
	 * @return the nickname of a user
	 */
	public String getNickname()
	{
		return nickname;
	}

	/**
	 * A setter for the nickname
	 *
	 * @param nickname the nickname of a user
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * A getter for the user password
	 *
	 * @return the user password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * A setter for the use password
	 *
	 * @param password the user password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * A getter for the list of all the user messages both sent and received
	 *
	 * @return the list containing all the user messages
	 */
	public List<Message> getMessages()
	{
		return messages;
	}

	/**
	 * A setter for the list of all the user messages
	 *
	 * @param messages a list of all the user messages
	 */
	public void setMessages(List<Message> messages)
	{
		this.messages = messages;
	}

	/**
	 * A getter for the list of friends of this user
	 *
	 * @return a list of all the user's friends
	 */
	public List<User> getFriends()
	{
		return friends;
	}

	/**
	 * A setter for the list of all friends of this user
	 *
	 * @param friends a list of all friends this user has
	 */
	public void setFriends(List<User> friends)
	{
		this.friends = friends;
	}

	/**
	 * A getter for the list of broadcast lists owned by this user
	 *
	 * @return the list of broadcast lists
	 */
	public List<BroadcastList> getBroadcastLists()
	{
		return broadcastLists;
	}

	/**
	 * A setter for the list of broadcast lists owned by this user
	 *
	 * @param broadcastLists the list of broadcast lists
	 */
	public void setBroadcastLists(List<BroadcastList> broadcastLists)
	{
		this.broadcastLists = broadcastLists;
	}

	/**
	 * this method removes a broadcast list from this user object
	 *
	 * @param broadcastNickname the nickname of the broadcast list to remove
	 * @throws WhatsAppException throw this with BCAST_LIST_DOES_NOT_EXIST as
	 * the message if the broadcast list asked to remove does not exist
	 */
	public void removeBroadcastList(String broadcastNickname) 
			throws WhatsAppException {
		// remove a broadcast list
		boolean broadcastNicknameExist = false;
		// search every list name
		for(int i = 0; i < broadcastLists.size();i++){
			if (broadcastLists.get(i).getNickname().equals(broadcastNickname) &&
					!broadcastNicknameExist){
				broadcastNicknameExist = true;
				// if found, remove it
				broadcastLists.remove(i);
			}
			//otherwise, throw an exception
			if(!broadcastNicknameExist){
				throw new WhatsAppException(Config.BCAST_LIST_DOES_NOT_EXIST);
			}
		}


	}

	/**
	 * this method check whether supplied nickname is a friend of this user
	 * object
	 *
	 * @param nickname the nickname of the user to be checked whether he is a
	 * friend
	 * @return true if nickname is a friend of this user object
	 */
	public boolean isFriend(String nickname)
	{
		//search the whole friends list
		for(int i = 0; i < friends.size(); i++){
			if(friends.get(i).nickname.equals(nickname)){
				return true;
			}
		}
		return false;
	}

	/**
	 * this method check whether supplied nickname is a broadcast list of this
	 * user object
	 *
	 * @param nickname the nickname of the user to be checked whether it is a
	 * broadcast list of this user object
	 * @return true if nickname is a broadcast list of this user object
	 */
	public boolean isBroadcastList(String nickname)
	{
		// search the user's whole list of broadcast list
		for(int i = 0; i < broadcastLists.size(); i++){
			//if found, return true
			if(broadcastLists.get(i).getNickname().equals(nickname)){
				return true;
			}

		}
		return false;
	}

	/**
	 * checks if the supplied nickname is associated with this user object. It
	 * can be either a friend or a broadcast list
	 *
	 * @param nickname the nickname to check against
	 * @return true if the nickname supplied is either a friend or a broadcast
	 * list of this user object
	 */
	public boolean isExistingNickname(String nickname)
	{
		//checking the name is a friend nick name or a broadcast nick name
		return (isFriend(nickname) || isBroadcastList(nickname));
	}

	/**
	 * checks whether the supplied nickname is part of the broadcastNickname
	 * list both associated with this user object
	 *
	 * @param nickname the nickname of the user
	 * @param broadcastNickname the nickname of the broadcastList
	 * @return true if nickname is a part of the list represented by
	 * broadcastNickname
	 */
	public boolean isMemberOfBroadcastList(String nickname, 
			String broadcastNickname){
		// search the list of nick names in the broadcast list
		for(int i = 0; i < broadcastLists.size(); i++){
			if(broadcastLists.get(i).getNickname().equals(broadcastNickname)){
				for(int j = 0; j < broadcastLists.get(i).getMembers().size();
						j++){
					if(broadcastLists.get(i).getMembers().get(j)
							.equals(nickname)){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * add a friend to this user
	 *
	 * @param nickname the nickname of the user who is to become a friend of
	 * this user object
	 * @throws WhatsAppException throw a new instance of this exception with one
	 * of the following messages: CANT_BE_OWN_FRIEND (if trying to add the the
	 * same user to itself), ALREADY_A_FRIEND (if the nickname is already a
	 * friend of this user), CANT_LOCATE (if the supplied nickname is not even
	 * an existing global contact)
	 */
	public void addFriend(String nickname) throws WhatsAppException
	{
		// if is the user himself
		if(this.nickname.equals(nickname)){
			throw new WhatsAppException(Config.CANT_BE_OWN_FRIEND);
		}//if is already a friend
		if(isFriend(nickname)){
			throw new WhatsAppException(Config.ALREADY_A_FRIEND);
		}//if the user do not exist
		if(!Helper.isExistingGlobalContact(nickname)){
			throw new WhatsAppException(String.format(
					Config.CANT_LOCATE, nickname));
		}
		//otherwise, add the user to the fiend list
		this.friends.add(Helper.getUserFromNickname(
				Config.getInstance().getAllUsers(), nickname));
	}

	/**
	 * remove a friend from this user object
	 *
	 * @param nickname the nickname of the friend whom to remove as a friend of
	 * this user object
	 * @throws WhatsAppException throw a new instance of this exception with
	 * NOT_A_FRIEND (if nickname is not a friend of this user)
	 */
	public void removeFriend(String nickname) throws WhatsAppException
	{//if not a friend
		if (!isFriend(nickname))
		{
			throw new WhatsAppException(Config.NOT_A_FRIEND);
		}
		//get the user from the nick name
		User friendToRemove = Helper.getUserFromNickname(friends, nickname);
		// remove the user from the friend list
		friends.remove(friendToRemove);
		//create a iterator to check the name of the users in the broadcast list
		Iterator<BroadcastList> bcastIterator = broadcastLists.iterator();
		while (bcastIterator.hasNext())
		{
			BroadcastList bcastList = bcastIterator.next();
			// CORRECTED: Removed the ! from the below if condition
			if (isMemberOfBroadcastList(nickname, bcastList.getNickname()))
			{
				Helper.getBroadcastListFromNickname(broadcastLists, bcastList.
						getNickname()).getMembers().remove(nickname);
			}

		}
	}

}
