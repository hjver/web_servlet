package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.apache.tomcat.util.descriptor.web.MessageDestination;

//문자를 암호화 변경을 하는 Model
public class encry_model {
	public String dataencode(String word) {  //base64 암호화
		Encoder ec = Base64.getEncoder();
		String securuty = ec.encodeToString(word.getBytes());
		return securuty;
	}
	
	public String datadecode(String word) {  //base64 복호화
		Decoder dc = Base64.getDecoder();
		/*
		byte dec[] = dc.decode(word);
		String security = new String(dec);
		*/
		String security = new String(dc.decode(word));
		return security;
	}
	
	//MD5 : %02x 기본(%x, %01x, %02x 모두 동일), %03x 부터는 자릿수 변경됨 (x : 소문자, X : 대문자)
	//sha-1 : 16진수 40자로 생성된느 암호화 기술 (%01x, %02x 각각 다름)
	//sha-2 : sha-224(224비트), sha-235, sha-384, sha-512
	//sha-3 : sha3-224(224비트), sha3-235, sha3-384, sha3-512
	
	//복합 암호화 기술 : base64 => md5
	//복합 암호화 기술 : md5 + sha-2
	public String md5_encode(String word) {
		String security = "";
		try {
			//MessageDigest : 암호화클래스 구성 형태를 가지고 있는 라이브러리
			//MessageDigest md = MessageDigest.getInstance("md5");
			//MessageDigest md = MessageDigest.getInstance("sha-1");
			//MessageDigest md = MessageDigest.getInstance("sha-224");
			MessageDigest md = MessageDigest.getInstance("sha3-224");
			md.update(word.getBytes()); //해당 암호화 기준으로 byte로 문자를 변환
			byte md5byte[] = md.digest(); //원시배열에 해당 암호화된 byte 저장
			
			StringBuilder sb = new StringBuilder(); //문자열 클래스로 연속화
			for(byte s : md5byte) {
				sb.append(String.format("%02x", s));
				//%02x => 2자리 문자 => 1234 => 01, 02, 03, 04
				//%01x => 1자리 문자 => 1234 => 1, 2, 3, 4
				//%05x => 5자리 문자 => 1234 => 00001, 00002, 
			}
			security = String.valueOf(sb);
		}catch (Exception e) {
			
		}
		return security;
	}
}
