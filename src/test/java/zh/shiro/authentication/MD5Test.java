package zh.shiro.authentication;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String[] args) {
		String source="zs";
		String salt="qwerty";
		int hashIterations=2;
		/**
		 * 参数详解
		 * 1.原始密码
		 * 2.盐，通过使用随机数
		 * 3.散列的次数，比如散列2次，相当于md5(md5(''));
		 */
		Md5Hash md5Hash=new Md5Hash(source, salt, hashIterations);
		String pwd_md5=md5Hash.toString();
		System.out.println(pwd_md5);
		/**
		 * 参数详解
		 * 1.
		 * 2.
		 * 3.
		 * 4.
		 */
		SimpleHash simpleHash=new SimpleHash("md5", source, salt, hashIterations);
		System.out.println(simpleHash.toString());
	}
}
