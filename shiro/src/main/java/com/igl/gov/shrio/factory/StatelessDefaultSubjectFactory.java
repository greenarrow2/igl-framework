package com.igl.gov.shrio.factory;

import com.igl.gov.shrio.custom.HmacSHA256Utils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    @Override
    public Subject createSubject(SubjectContext subjectContext) {
        subjectContext.setSessionCreationEnabled(false);
        return super.createSubject(subjectContext);
    }
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("param1", "1");
        params.put("param2", "2");
        System.out.println(HmacSHA256Utils.digest("dadadswdewq2ewdwqdwadsadasd", params));
    }
}
