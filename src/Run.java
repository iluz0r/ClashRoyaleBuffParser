public class Run {

	public static void main(String[] args) {
		String accIdHex = fromTagToHexStringLong("2GJY9990");
		System.out.println(accIdHex);
		byte[] payload = SCUtils.hexToBuffer(accIdHex);
		BuffParser bp = new BuffParser(payload, 0);
		//System.out.println("My tag with RRSLONG is: " + SCUtils.tagFromId(bp.readRrsLong()));
		System.out.println("My tag with SLONG is: " + SCUtils.tagFromId(bp.readLong()) + "\n");
		System.out.println(bp.toDiscordResponse());
	}

	public static String fromTagToHexStringRrsLong(String tag) {
		BuffParser.SLong accId = SCUtils.idFromTag(tag);
		byte[] hiBytes = SCUtils.intToRrsInt32(accId.hi);
		byte[] loBytes = SCUtils.intToRrsInt32(accId.lo);
		String accIdHex = SCUtils.toHexString(hiBytes) + SCUtils.toHexString(loBytes);
		return accIdHex;
	}
	
	public static String fromTagToHexStringLong(String tag) {
		BuffParser.SLong accId = SCUtils.idFromTag(tag);
		return String.format("%08X", accId.hi) + String.format("%08X", accId.lo);
 	}

}
