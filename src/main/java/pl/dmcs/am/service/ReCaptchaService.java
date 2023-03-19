package pl.dmcs.am.service;

public interface ReCaptchaService {
    boolean verify(String captcha);
}
