/**
 * 
 */
package com.sftp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * @author SXCHAH
 *
 */
public class SFTPConnection {
	@SuppressWarnings("unchecked")
	public void connSFTP() throws Exception {
		JSch ssh = new JSch();
		Session session = ssh.getSession("oracle", "xxx.xxx.xxx.xxx", 22);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.setPassword("xxxxxxx");
		session.connect();
		
		System.out.println("sftp berhasil connect");
		
		Channel channel = session.openChannel("sftp");
		channel.connect();
		
		ChannelSftp sftp = (ChannelSftp) channel;
		sftp.cd("/home/xxx/");
		
		Vector<LsEntry> files = sftp.ls("*.xls");
		for (ChannelSftp.LsEntry file : files) {
			if (file.getAttrs().isDir()) {
				continue;
			}
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date(file.getAttrs().getMTime()*1000L);
			System.out.println(file.getFilename() + "; " + df.format(date) + "; "+ file.getAttrs().getSize());
		}
		
		channel.disconnect();
		session.disconnect();
	}
}
