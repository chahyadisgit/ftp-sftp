/**
 * 
 */
package com.sftp;

/**
 * @author SXCHAH
 *
 */
public class Executer {
	public static void main (String[] args) throws Exception {
		SFTPConnection conn = new SFTPConnection();
		conn.connSFTP();
	}
}
