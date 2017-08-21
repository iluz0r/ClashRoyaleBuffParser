public class Run {

	public static void main(String[] args) {
		//String accIdHex = fromTagToHexString("2PG0Y9UQQ");
		
		byte[] payload = SCUtils.hexToBuffer("");
		BuffParser bp = new BuffParser(payload, 0);
		// System.out.println("My tag with RRSLONG is: " + SCUtils.tagFromId(bp.readRrsLong()));
		// System.out.println("My tag with SLONG is: " + SCUtils.tagFromId(bp.readLong()) + "\n");
		System.out.println(bp.toDiscordResponse());
	}

	public static String fromTagToHexString(String tag) {
		BuffParser.SLong accId = SCUtils.idFromTag(tag);
		byte[] accIdBytes = SCUtils.fromLong(accId.v);
		String accIdHex = SCUtils.toHexString(accIdBytes);
		return accIdHex;
	}

}
