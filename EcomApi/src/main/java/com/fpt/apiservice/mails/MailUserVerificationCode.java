//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fpt.apiservice.mails;

import com.fpt.apiservice.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailUserVerificationCode {
    final String subject = "Send mail";
    final String templateMail = "";
    @Autowired
    MailUtil mailUtil;

    public void sendMail(String mailTo, String code) {
        this.mailUtil.sendEmail(mailTo, "Send mail", mailTo);
    }
}
