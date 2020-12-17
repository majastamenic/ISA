package com.isa.pharmacy.service;

import java.io.IOException;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class SftpService {

	private SSHClient setup() throws IOException {
		SSHClient sshClient= new SSHClient();
		sshClient.addHostKeyVerifier(new PromiscuousVerifier());
		sshClient.connect("192.168.1.12", 22);
		sshClient.authPassword("tester", "password");

		return sshClient;
	};
	
	public void downloadFile() throws IOException {
		//System.out.println("skida fajl sa Rebex-a");
		SSHClient sshClient= setup();
		SFTPClient sftpClient= sshClient.newSFTPClient();
		String dir= "src/main/resources/";
		sftpClient.get("example.txt", dir + "example.txt");
		sftpClient.close();
		sshClient.disconnect();
	}
}
