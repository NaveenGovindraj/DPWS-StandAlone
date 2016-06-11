package org.DPWS.Expose;
import java.io.IOException;

import org.ws4d.java.JMEDSFramework;
import org.ws4d.java.communication.CommunicationException;
import org.ws4d.java.security.CredentialInfo;
import org.ws4d.java.service.InvocationException;
import org.ws4d.java.service.Operation;
import org.ws4d.java.service.parameter.ParameterValue;
import org.ws4d.java.types.QName;

public class DocuExampleServiceProvider {

	public static void main(String[] args) {

		JMEDSFramework.start(args);
		
		//First we need a device
		DocuExampleDevice device = new DocuExampleDevice();
		
		//Then we create a service
		DocuExampleService service = new DocuExampleService();
		
		//In the end we add our service to the device
		device.addService(service);
		
		//We start our device
		
		try {
			device.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.addOperation(new Operation("DocuHelloWorldOp", new QName("BasicServices", DocuExampleDevice.DOCU_NAMESPACE)) {
			
			
			//we have to implement the invoke method
			public ParameterValue invokeImpl(ParameterValue pv, CredentialInfo localCredentialInfo)
					throws InvocationException {
				
				//all we want to do is to print Hello World!
				System.out.println("HelloWOrld!");
				
				return pv;
			}
		});
	}

}
