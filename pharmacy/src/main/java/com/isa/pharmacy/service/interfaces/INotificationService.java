package com.isa.pharmacy.service.interfaces;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;

public interface INotificationService {
     @Scheduled(fixedRate = 20000)
     void checkFile() throws IOException;

     void downloadFromSftp() throws IOException;

     void fileDisposer(File file) throws FileNotFoundException;
}
