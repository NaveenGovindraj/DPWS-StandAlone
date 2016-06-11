package org.DPWS.Expose;
import org.ws4d.java.communication.DPWSCommunicationManager;
import org.DPWS.InputandOutputParameters.DocuExampleAttributeOperation;
import org.DPWS.InputandOutputParameters.DocuExampleComplexOperation;
import org.DPWS.InputandOutputParameters.DocuExampleSimpleOperation;
import org.ws4d.java.service.DefaultService;
import org.ws4d.java.types.URI;

public class DocuExampleService extends DefaultService{

	public final static URI DOCU_EXAMPLE_SERVICE_ID = new URI (DocuExampleDevice.DOCU_NAMESPACE + "/DocuExampleService");


/*
 * Standard Constructor
 */
	
	public DocuExampleService() {
		super(DPWSCommunicationManager.COMMUNICATION_MANAGER_ID);
		// TODO Auto-generated constructor stub
		
		this.setServiceId(DOCU_EXAMPLE_SERVICE_ID);
		
	
		DocuExampleSimpleOperation simpleOperation = new DocuExampleSimpleOperation();
		addOperation(simpleOperation);

	
		DocuExampleComplexOperation complexOp = new DocuExampleComplexOperation();
		addOperation(complexOp);

		DocuExampleAttributeOperation attrOp = new DocuExampleAttributeOperation();
		addOperation(attrOp);

	}

}
