import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		String accIdHex = fromTagToRrsLongHex("2UCVGL2LL");
		System.out.println(accIdHex);
		byte[] payload = SCUtils.hexToBuffer(accIdHex);
		BuffParser bp = new BuffParser(payload, 0);
		// System.out.println("My tag with RRSLONG is: " + SCUtils.tagFromId(bp.readRrsLong()));
		// System.out.println("My tag with SLONG is: " + SCUtils.tagFromId(bp.readLong()) + "\n");
		System.out.println(bp.toDiscordResponse());
	}

	public static String fromTagToRrsLongHex(String tag) {
		BuffParser.SLong accId = SCUtils.idFromTag(tag);
		
		List<Byte> buffer = new ArrayList<>();
		SCUtils.packRrsInt32(buffer, accId.hi);
		SCUtils.packRrsInt32(buffer, accId.lo);

		byte[] byteArray = new byte[buffer.size()];
		for (int i = 0; i < buffer.size(); i++) {
			byteArray[i] = buffer.get(i);
		}

		return SCUtils.toHexString(byteArray);
	}

	public static String fromTagToLongHex(String tag) {
		BuffParser.SLong accId = SCUtils.idFromTag(tag);
		return String.format("%08X", accId.hi) + String.format("%08X", accId.lo);
	}

}
