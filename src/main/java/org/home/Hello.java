package org.home;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.04.13
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class Hello {

    private String hello;
    private Date date = new Date();

    public Hello() {
    }

    public Hello(String hello) {
        this.hello = hello;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
