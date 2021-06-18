package tech.luochan.multi_application.impl;

import tech.luochan.multi_application.MaApplication;

public class MaApplicationImpl extends MaApplication {

    @Override
    public boolean needMultipleProcess() {
        return false;
    }

    @Override
    protected void initializeLogic() {

        registerApplicationLogic("com.demo.app1", 3, ApplicationLogicImpl.class);
        //....

    }
}
