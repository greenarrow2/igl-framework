package com.igl.gov.shrio.factory;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    @Override
    public Subject createSubject(SubjectContext subjectContext) {
        subjectContext.setSessionCreationEnabled(false);
        return super.createSubject(subjectContext);
    }
}
