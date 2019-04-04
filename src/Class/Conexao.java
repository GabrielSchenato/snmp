/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


/**
 *
 * @author gabri
 */
public class Conexao {

    private String ip;
    private int porta;
    private String communit;   
    private int timeout;
    private int retries;

    public Conexao() {
    }

    public Conexao(String ip, int porta, String communit, int timeout, int retries) {
        this.ip = ip;
        this.porta = porta;
        this.communit = communit;
        this.timeout = timeout;
        this.retries = retries;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getCommunit() {
        return communit;
    }

    public void setCommunit(String communit) {
        this.communit = communit;
    }

    public String getVersao() {
        return "2c";
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }
    
    public String getAddress(){
        String address = null;
        address = "udp:" + this.getIp() + "/" + this.getPorta();
        return address;
    }

}
