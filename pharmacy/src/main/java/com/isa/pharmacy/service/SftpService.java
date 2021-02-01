package com.isa.pharmacy.service;

import java.io.IOException;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class SftpService {

    private SSHClient setup() throws IOException {
        try (SSHClient sshClient = new SSHClient()) {
            sshClient.addHostKeyVerifier(new PromiscuousVerifier());
            sshClient.connect("192.168.3.74", 22);
            sshClient.authPassword("tester", "password");

            return sshClient;
        }
    }

    public void downloadFile() throws IOException {
        try (SSHClient sshClient = setup()) {
            SFTPClient sftpClient = sshClient.newSFTPClient();
            String dir = "src/main/resources/";
            sftpClient.get("example.txt", dir + "example.txt");
            sftpClient.close();
            sshClient.disconnect();
        }
    }
}
