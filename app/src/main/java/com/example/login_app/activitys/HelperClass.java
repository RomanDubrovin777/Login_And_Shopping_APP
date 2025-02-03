package com.example.login_app.activitys;

public class HelperClass {

    private String m_email,m_password,m_phone;

    public HelperClass(String m_phone, String m_email, String m_password) {
        this.m_phone = m_phone;
        this.m_email = m_email;
        this.m_password = m_password;
    }



    public HelperClass() {

    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }
//check

}
