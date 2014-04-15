package com.ftp;

import org.apache.commons.net.ftp.FTPClient;

public class FTPConnection {
	public void connFTP() throws Exception {
		FTPClient fc = new FTPClient();
		fc.setDataTimeout(10000);
		fc.connect("172.24.232.27");
		System.out.println("connect");
		if (fc.login("oracle", "adm!n0876")) {
			System.out.println("berhasil login");
		} else {
			System.out.println("failed");
		}
	}
}
