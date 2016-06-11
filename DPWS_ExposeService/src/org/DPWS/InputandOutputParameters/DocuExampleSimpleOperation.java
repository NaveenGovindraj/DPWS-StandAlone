package org.DPWS.InputandOutputParameters;



import org.DPWS.Expose.DocuExampleDevice;
import org.ws4d.java.communication.CommunicationException;
import org.ws4d.java.schema.Element;
import org.ws4d.java.schema.SchemaUtil;
import org.ws4d.java.security.CredentialInfo;
import org.ws4d.java.service.InvocationException;
import org.ws4d.java.service.Operation;
import org.ws4d.java.service.parameter.ParameterValue;
import org.ws4d.java.service.parameter.ParameterValueManagement;
import org.ws4d.java.types.QName;

public class DocuExampleSimpleOperation extends Operation {
	
	public final static String NAME = "name";
	
	public final static String REPLY = "reply";
	

	public DocuExampleSimpleOperation() {
		super("DocuExampleSimpleOperation", new QName("BasicServices", DocuExampleDevice.DOCU_NAMESPACE));
		// TODO Auto-generated constructor stub
		
		//create new Element called "name" (just a simple one in this case)
		Element namElem = new Element(new QName(NAME, DocuExampleDevice.DOCU_NAMESPACE), SchemaUtil.TYPE_STRING);
		
		//set the input of the operation
		setInput(namElem);

		//create new element called 
		Element reply = new Element(new QName(REPLY, DocuExampleDevice.DOCU_NAMESPACE), SchemaUtil.TYPE_STRING);
		
		//set this element as output
		setOutput(reply);
	

}


	@Override
	protected ParameterValue invokeImpl(ParameterValue paremeterValue, CredentialInfo credentialInfo)
			throws InvocationException, CommunicationException {
		// TODO Auto-generated method stub
		
		//get string value from input
		String name = ParameterValueManagement.getString(paremeterValue, NAME);
		System.out.println("Hello World" + name);
		
		//create output and set value
		
	ParameterValue result = createOutputValue();
	ParameterValueManagement.setString(result, REPLY, "How are you Today" + name);		
	return result;
	}
}