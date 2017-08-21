public class Run {

	public static void main(String[] args) {
		String accIdHex = fromTagToHexString("PQ9090GJ");
		byte[] payload = SCUtils.hexToBuffer(accIdHex);
		BuffParser bp = new BuffParser(payload, 0);
		System.out.println("My tag with RRSLONG is: " + SCUtils.tagFromId(bp.readRrsLong()));
		//System.out.println("My tag with SLONG is: " + SCUtils.tagFromId(bp.readLong()) + "\n");
		System.out.println(bp.toDiscordResponse());
	}

	public static String fromTagToHexString(String tag) {
		BuffParser.SLong accId = SCUtils.idFromTag(tag);
		byte[] hiBytes = SCUtils.intToRrsInt32(accId.hi);
		byte[] loBytes = SCUtils.intToRrsInt32(accId.lo);
		String accIdHex = SCUtils.toHexString(hiBytes) + SCUtils.toHexString(loBytes);
		return accIdHex;
	}

}
