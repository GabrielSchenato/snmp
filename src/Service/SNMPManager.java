package Service;

import java.io.IOException;
import Class.Conexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SNMPManager {

    private Snmp snmp = null;
    private Conexao conexao = null;

    /**
     * Constructor
     *
     * @param conexao
     */
    public SNMPManager(Conexao conexao) {
        this.conexao = conexao;
        this.start();
    }

    /**
     * Start the Snmp session. If you forget the listen() method you will not
     * get any answers because the communication is asynchronous and the
     * listen() method listens for answers.
     *
     * @throws IOException
     */
    private void start() {
        try {
            TransportMapping transport = new DefaultUdpTransportMapping();
            this.snmp = new Snmp(transport);
// Do not forget this line!
            transport.listen();
        } catch (IOException ex) {
            Logger.getLogger(SNMPManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method which takes a single OID and returns the response from the agent
     * as a String.
     *
     * @param oid
     * @return
     */
    public String getAsString(OID oid) {
        try {
            ResponseEvent event = get(new OID[]{oid});
            return event.getResponse().get(0).getVariable().toString();
        } catch (IOException ex) {
            Logger.getLogger(SNMPManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method is capable of handling multiple OIDs
     *
     * @param oids
     * @return
     * @throws IOException
     */
    public ResponseEvent get(OID oids[]) throws IOException {
        PDU pdu = new PDU();
        for (OID oid : oids) {
            pdu.add(new VariableBinding(oid));
        }
        pdu.setType(PDU.GET);
        ResponseEvent event = snmp.send(pdu, getTarget(), null);
        if (event != null) {
            return event;
        }
        throw new RuntimeException("GET timed out");
    }

    /**
     * This method returns a Target, which contains information about where the
     * data should be fetched and how.
     *
     * @return
     */
    private Target getTarget() {
        Address targetAddress = GenericAddress.parse(this.conexao.getAddress());
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(this.conexao.getCommunit()));
        target.setAddress(targetAddress);
        target.setRetries(this.conexao.getRetries());
        target.setTimeout(this.conexao.getTimeout());
        target.setVersion(SnmpConstants.version2c);
        return target;
    }
    
    public void close(){
        try {
            this.snmp.close();
        } catch (IOException ex) {
            Logger.getLogger(SNMPManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
