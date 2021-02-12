package com.isa.pharmacy.service.interfaces;

import java.io.IOException;

public interface IQrService {

     String readQrCode(String path) throws IOException;
}
