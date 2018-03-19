///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P2)
// Files:            (Receiver)
// Semester:         (367) Spring 2016
//
// Author:           (Zhongwei Wang)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deb Deppler)
// Lab Section:      (02)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (Ying Li)
// Email:            (li528@wisc.edu)
// CS Login:         (yli)
// Lecturer's Name:  (Deb Deppler)
// Lab Section:      (02)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

//Requirement: Source files for OTHER CLASSES must have a file header comment located at the beginning of the file containing the following (see example):

//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
import java.io.IOException;


/**
 * The main class. It simulates a application (image viewer) receiver by
 * maintaining a list buffer. It collects packets from the queue of 
 * InputDriver and arrange them properly, and then reconstructs the image
 * file from its list buffer.
 * 
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 3.6
 * @see also
 */
public class Receiver {
	// fields
	private InputDriver input;
	private ImageDriver img;
	// The list of buffer that hold the data for the picture
	private PacketLinkedList<SimplePacket> list;

	/**
	 * Constructs a Receiver to obtain the image file transmitted.
	 * @param file the filename you want to receive
	 */
	public Receiver(String file) {
		try {
			input = new InputDriver(file, true);
		} catch (IOException e) {
			System.out.println(
					"The file, " + file + ", isn't existed on the server.");
			System.exit(0);
		}
		img = new ImageDriver(input);
		list = new PacketLinkedList<SimplePacket> ();
	}

	/**
	 * Returns the PacketLinkedList buffer in the receiver
	 * 
	 * @return the PacketLinkedList object
	 */
	public PacketLinkedList<SimplePacket> getListBuffer() {
		return list;
	}

	/**
	 * Asks for retransmitting the packet. The new packet with the sequence 
	 * number will arrive later by using {@link #askForNextPacket()}.
	 * Notice that ONLY packet with invalid checksum will be retransmitted.
	 * 
	 * @param pkt the packet with bad checksum
	 * @return true if the requested packet is added in the receiving queue; otherwise, false
	 */
	public boolean askForRetransmit(SimplePacket pkt) {
		return input.resendPacket(pkt);
	}


	/**
	 * Asks for retransmitting the packet with a sequence number. 
	 * The requested packet will arrive later by using 
	 * {@link #askForNextPacket()}. Notice that ONLY missing
	 * packet will be retransmitted. Pass seq=0 if the missing packet is the
	 * "End of Streaming Notification" packet.
	 * 
	 * @param seq the sequence number of the requested missing packet
	 * @return true if the requested packet is added in the receiving queue; otherwise, false
	 */
	public boolean askForMissingPacket(int seq) {
		return input.resendMissingPacket(seq);
	}

	/**
	 * Returns the next packet.
	 * 
	 * @return the next SimplePacket object; returns null if no more packet to
	 *         receive
	 */
	public SimplePacket askForNextPacket() {
		return input.getNextPacket();
	}

	/**
	 * Returns true if the maintained list buffer has a valid image content. Notice
	 * that when it returns false, the image buffer could either has a bad
	 * header, or just bad body, or both.
	 * 
	 * @return true if the maintained list buffer has a valid image content;
	 *         otherwise, false
	 */
	public boolean validImageContent() {
		return input.validFile(list);
	}

	/**
	 * Returns if the maintained list buffer has a valid image header
	 * 
	 * @return true if the maintained list buffer has a valid image header;
	 *         otherwise, false
	 */
	public boolean validImageHeader() {
		return input.validHeader(list.get(0));
	}

	/**
	 * Outputs the formatted content in the PacketLinkedList buffer. See
	 * course webpage for the formatting detail.
	 */
	public void displayList() {
		PacketLinkedListIterator<SimplePacket> itr = list.iterator();
		if(itr.hasNext()){
			SimplePacket temp = itr.next();
			System.out.print(temp.getSeq());
			while(itr.hasNext()){
				temp = itr.next();
				if(!temp.isValidCheckSum()){
					System.out.print(", ["+temp.getSeq() + "]");
				}else System.out.print(", "+temp.getSeq());
			}
		}

	}

	/**
	 * Reconstructs the file by arranging the {@link PacketLinkedList} in
	 * correct order. It uses {@link #askForNextPacket()} to get packets until
	 * no more packet to receive. It eliminates the duplicate packets and asks
	 * for retransmitting when getting a packet with invalid checksum.
	 */
	public void reconstructFile() {
		// Collect the packets and arrange them in order.
		// the number of Packets that we suppose to receive
		int numPacket = 0;
		SimplePacket item = askForNextPacket();
		// call the method to deal with normal case in which the item should be
		// added into the list or call for a retransmit.
		while(item != null && item.getSeq() > 0){
			collect(item);
			item = askForNextPacket();
		}
		// after collecting, dealing with the missing packets
		// if the end packet is missed. repeat until finally get one
		while(numPacket == 0){
			// if we get an end packet
			if(item != null){
				numPacket = (-1)*item.getSeq();

				//check the size of list and the end sign
				while(list.size() != numPacket){
					for(int i = 0; i< list.size(); i++){
						if(list.get(i).getSeq() != (i+1)){
							askForMissingPacket(i+1);
							item = askForNextPacket();
							collect(item);
						}
					}
				}
				// if the end packet is missed, ask for it.
			}else if(numPacket == 0){
				askForMissingPacket(0);
				item = askForNextPacket();
			}
		}

	}

	/**
	 * Opens the image file by merging the content in the maintained list
	 * buffer.
	 * @throws BadImageHeaderException 
	 * @throws BadImageContentException 
	 */
	public void openImage() throws BadImageHeaderException, 
	BadImageContentException {	
		try {
			img.openImage(list);
		} 

		/* throws BadImageHeaderException if the maintained list buffer has an 
		 * invalid image header, throws BadImageContentException if the 
		 * maintained list buffer has an invalid image content*/
		catch(BrokenImageException e){
			if(!validImageHeader()){
				throw new BadImageHeaderException(
						"The image is broken due to a damaged header");
			}
			if(!validImageContent()){
				throw new BadImageContentException(
						"The image is broken due to corrupt content");
			}
		}
		catch (Exception e) {
			System.out.println(
					"Please catch the proper Image-related Exception.");
			e.printStackTrace();
		}
	}

	/**
	 * Initiates a Receiver to reconstruct collected packets and open the Image
	 * file, which is specified by args[0]. 
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: java Receiver [filename_on_server]");
			return;
		}

		Receiver recv = new Receiver(args[0]);
		recv.reconstructFile();
		//recv.displayList(); //use for debuggingus

		try{
			recv.openImage();
		}catch(BadImageHeaderException e){
			System.out.println(e.getMessage());
		}catch(BadImageContentException e){
			System.out.println(e.getMessage());
		}
	}



	/**
	 * This is the collect method.
	 * In this method, the param item will be checked for its position and 
	 * duplication in the list, as well as the corruption.
	 * Then, it will be stored proporally(or request a retransmit)
	 * 
	 * @param item - SimplePacket Type; It is the data that the field list will
	 * store in the method.
	 */

	private void collect(SimplePacket item){


		// check the pos to place the item
		int pos = 0;
		for(int i = 0; i< list.size();i++){
			if(item.getSeq() > list.get(i).getSeq()){
				pos ++;
			}
		}
		// check if the pos is the end of the list
		if(pos == list.size()){
			if(item.isValidCheckSum()){
				list.add(pos, item);

			}else{

				askForRetransmit(item);
			}

		}else{
			// check the duplictiy
			if(item.getSeq() == list.get(pos).getSeq()){
				// if valid
				if(item.isValidCheckSum()){
					list.remove(pos);

					list.add(pos, item);

				}else{// if not valid

					askForRetransmit(item);
				}
			}else{// if not duplicity
				// if valid
				if(item.isValidCheckSum()){
					list.add(pos, item);

				}else{// if not valid

					askForRetransmit(item);
				}
			}
		}

	}


}
