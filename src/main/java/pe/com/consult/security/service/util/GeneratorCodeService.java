package pe.com.consult.security.service.util;

import org.springframework.stereotype.Service;

@Service
public class GeneratorCodeService {

    public String generatorCode(String typeRegister, int lastRegister) {

        String nuevoCodigo =typeRegister + String.format("%07d", lastRegister);
        return nuevoCodigo;

    }
}
