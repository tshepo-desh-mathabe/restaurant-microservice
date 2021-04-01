package dubby.serve.emailverification.service;

import dubby.serve.emailverification.domain.Verify;
import dubby.serve.emailverification.dto.VerifyDto;
import dubby.serve.emailverification.mapper.IModelMapper;
import dubby.serve.emailverification.repository.IVerifyRepository;
import dubby.serve.emailverification.util.token_generator.TokenGenerator;
import dubby.serve.emailverification.util.helper.IService;
import dubby.serve.emailverification.util.http.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VerifyServiceImpl implements IService {

    @Autowired
    private IVerifyRepository verifyRepository;
    @Autowired
    private IModelMapper<Verify, VerifyDto> modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RestClient restClient;

    @Override
    public void saveData(VerifyDto request) {
        beforeSave(request);
//        request.setVerificationToken(passwordEncoder.encode(request.getVerificationToken()));
        request.setVerificationToken(request.getVerificationToken());
        verifyRepository.save(modelMapper.toEntity(request));
    }

    @Override
    public void deleteData(String token) {
        verifyRepository.findByToken(token).ifPresent(e -> {
            verifyRepository.delete(e);
        });
    }

    private void beforeSave(VerifyDto verify) {
        var tokenGenerator = new TokenGenerator();
        var token = tokenGenerator.getGeneratedToken();

        verify.setCreatedAtDate(LocalDateTime.now());
        verify.setVerificationToken(String.valueOf(token));
        setToMailService(verify); // sent token before encryption
    }

    private void setToMailService(VerifyDto body) {
        restClient.post(body);
    }
}
