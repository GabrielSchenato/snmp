/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.snmp4j.smi.OID;

/**
 *
 * @author gabri
 */
public class EquipamentoUniversal {

    public static final OID SYSDESCR = new OID(".1.3.6.1.2.1.1.1.0");
    public static final OID SYSCONTACT = new OID(".1.3.6.1.2.1.1.4.0");
    public static final OID SYSNAME = new OID(".1.3.6.1.2.1.1.5.0");
    public static final OID SYSLOCATION = new OID(".1.3.6.1.2.1.1.6.0");
    public static final OID SYSUPTIME = new OID(".1.3.6.1.2.1.1.3.0");
    public static final OID IFNUMBER = new OID(".1.3.6.1.2.1.2.1.0");
    public static final String IFINDEX = ".1.3.6.1.2.1.2.2.1.1.";
    public static final String IFDESCR = ".1.3.6.1.2.1.2.2.1.2.";
    public static final String IFTYPE = ".1.3.6.1.2.1.2.2.1.3.";
    public static final String IFSPEED = ".1.3.6.1.2.1.2.2.1.5.";
    public static final String IFPHYSADDRESS = ".1.3.6.1.2.1.2.2.1.6.";
    public static final String IFADMINSTATUS = ".1.3.6.1.2.1.2.2.1.7.";
    public static final String IFOPERSTATUS = ".1.3.6.1.2.1.2.2.1.8.";
    public static final String IFINOCTETS = ".1.3.6.1.2.1.2.2.1.10.";
    public static final String IFOUTOCTETS = ".1.3.6.1.2.1.2.2.1.16.";
    public static final String IFINERRORS = ".1.3.6.1.2.1.2.2.1.14.";
    public static final String IFOUTERRORS = ".1.3.6.1.2.1.2.2.1.20.";
    public static final String IFINDISCARDS = ".1.3.6.1.2.1.2.2.1.13.";
    public static final String IFOUTDISCARDS = ".1.3.6.1.2.1.2.2.1.19.";
}
