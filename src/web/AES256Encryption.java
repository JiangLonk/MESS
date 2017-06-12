package web;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import util.MD5;

public class AES256Encryption {

	private static final String KEY_ALGORITHM = "AES";

	private static final String CIPHER_ALGORITHM = "AES";

	private static String KEY = MD5.md5s("");

	private static final String CHARSET = "UTF8";

	private static byte[] decrypt(byte[] src, String key) throws Exception {

		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

		SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		return cipher.doFinal(src);
	}

	public static String decrypt(String data) {
		try {
			return new String(decrypt(hexStringToBytes(data), KEY), CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Key toKey(byte[] key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);

		return secretKey;
	}

	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {

		Key k = toKey(key);

		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

		cipher.init(Cipher.ENCRYPT_MODE, k);

		return cipher.doFinal(data);
	}

	private static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static String encrypt(String str) {
		return addSecureToStr(str);
	}

	private static String addSecureToStr(String str) {
		byte[] data = null;
		byte[] key = new byte[0];
		try {
			key = KEY.getBytes();
			data = AES256Encryption.encrypt(str.getBytes(CHARSET), key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytesToHexString(data);
	}

	public static void main(String[] args) {
		System.out.println(KEY);
		String en = encrypt("a54a1936ef121b9aa006235d489e1efc");
		System.out.println(en);
		String de = decrypt(en);
		System.out.println(de);
	}

	// @SuppressWarnings("resource")
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// System.out.println("请输入KEY:");
	// KEY = sc.nextLine();
	// int option;
	// do {
	// System.out.println("1:加密;2:解密;3:重新输入key;0:退出");
	// sc = new Scanner(System.in);
	// option = sc.nextInt();
	// String data;
	// switch (option) {
	// case 1:
	// System.out.println("请输入要加密的数据:");
	// sc = new Scanner(System.in);
	// data = sc.nextLine();
	// try {
	// System.out.println(encrypt(data));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// break;
	// case 2:
	// System.out.println("请输入要解密的数据:");
	// sc = new Scanner(System.in);
	// data = sc.nextLine();
	// try {
	// System.out.println(decrypt(data));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// break;
	// case 3:
	// System.out.println("请输入KEY:");
	// sc = new Scanner(System.in);
	// KEY = sc.nextLine();
	// break;
	// default:
	// break;
	// }
	// } while (option != 0);
	// }
}